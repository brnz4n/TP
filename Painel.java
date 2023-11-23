package t2front;

import javax.swing.*;
import t2back.MenuJavaLar;
import t2back.SistemaPlanetas;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Painel extends JFrame{
    private static final int LINHAS = 18;
    private static final int COLUNAS = 24;
    private BufferedReader arq;
    private JComboBox<String> campoQB;
    private int linhaAtual;
    private DadosDAO dadosDAO;
   
    public Painel() {
        setTitle("Painel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension((COLUNAS + 3) * QuadradoPainel.TAMANHO_QUADRADO, LINHAS * QuadradoPainel.TAMANHO_QUADRADO));

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel quadPanel = new JPanel(new GridLayout(LINHAS, COLUNAS));
        
        Map<Integer, ImageIcon> iconMap = carregarIcones();

        for (int i = 0; i < LINHAS * COLUNAS; i++) {
            ImageIcon icon = iconMap.get(i);
            QuadradoPainel square = new QuadradoPainel(icon);
            quadPanel.add(square);
        }

        mainPanel.add(quadPanel, BorderLayout.CENTER);

        JPanel PainelBotao = new JPanel();
        PainelBotao.setLayout(new BoxLayout(PainelBotao, BoxLayout.Y_AXIS));

        Botao botao1 = new Botao("Processar próximo instante");
        Botao botao2 = new Botao("Ler novo arquivo de entrada");
        Botao botao3 = new Botao("Gravar relatório");
        Botao botao4 = new Botao("Ler dados de outros participantes");
        Botao botao5 = new Botao("Gravar arquivo de saída");

        
        setLargerButtonSize(botao1, botao2, botao3, botao4, botao5);
        
        campoQB = new JComboBox<>();
        campoQB.addItem("");
        campoQB.addItem("AE_10.txt");
        campoQB.addItem("AE_50.txt");
        campoQB.addItem("AE_100.txt");
        campoQB.addItem("AE_500.txt");
        campoQB.addItem("AE_1000.txt");
        campoQB.addItem("AE_2000.txt");

        dadosDAO = new DadosDAO(new Conexao());
        
        botao1.addActionListener(e -> processarProximoInstante());
        botao2.addActionListener(e -> escolherArquivo());
        botao3.addActionListener(e -> gravarRelatorio());
//        botao4.addActionListener(e -> lerDadosDeOutrosParticipantes());
        PainelBotao.add(Box.createVerticalStrut(15));
        PainelBotao.add(botao1);
        PainelBotao.add(botao2);
        PainelBotao.add(campoQB);
        PainelBotao.add(botao3);
        PainelBotao.add(botao4);
        PainelBotao.add(botao5);

        mainPanel.add(PainelBotao, BorderLayout.EAST);

        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }

    private void setLargerButtonSize(JButton... buttons) {
        int largerWidth = 240;
        int largerHeight = 100;

        Dimension largerSize = new Dimension(largerWidth, largerHeight);

        for (JButton button : buttons) {
            button.setPreferredSize(largerSize);
        }
    }

    private Map<Integer, ImageIcon> carregarIcones() {
        Map<Integer, ImageIcon> iconMap = new HashMap<>();
        iconMap.put(12 + 3 * COLUNAS, new ImageIcon(getClass().getResource("/imagens/C.png")));
        iconMap.put(12 + 4 * COLUNAS, new ImageIcon(getClass().getResource("/imagens/c++.png")));
        iconMap.put(12 + 5 * COLUNAS, new ImageIcon(getClass().getResource("/imagens/C#.png")));
        iconMap.put(12 + 6 * COLUNAS, new ImageIcon(getClass().getResource("/imagens/PHP.png")));
        iconMap.put(12 + 7 * COLUNAS, new ImageIcon(getClass().getResource("/imagens/RR.png")));
        iconMap.put(12 + 8 * COLUNAS, new ImageIcon(getClass().getResource("/imagens/JS.png")));
        iconMap.put(12 + 9 * COLUNAS, new ImageIcon(getClass().getResource("/imagens/Pyhton.png")));
        iconMap.put(12 + 10 * COLUNAS, new ImageIcon(getClass().getResource("/imagens/java.png")));
        return iconMap;
    }
    private void gravarRelatorio() {
        System.out.println("Gravando relatório...");

        Dados dados = new Dados();
        dados.setNome("Breno");
        dados.setMatricula("542638");
        dados.getBugPython();
        dados.getBugJavaScript();
        dados.getBugRuby();
        dados.setNomeArquivo("AE_10.csv");
        dadosDAO.inserirDados(dados);
//        String nomeArquivoLido = dados.getNomeArquivo();

        System.out.println("Relatório gravado no banco de dados.");
    }
    private void processarProximoInstante() {
        if (arq == null) {
            System.out.println("Selecione um arquivo primeiro.");
            return;
        }

        try {
            String linha = arq.readLine();

            if (linha != null) {
                System.out.println("Linha lida: " + linha);               
            } else {
                System.out.println("Fim do arquivo atingido.");
                arq.close();
                arq = null;
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo TXT: " + e.getMessage());
        }
    }

    private void escolherArquivo() {
        String selectedFileName = (String) campoQB.getSelectedItem();
        System.out.println("Arquivo selecionado: " + selectedFileName);
        Dados dados = new Dados();
        
        
        try {
            if (arq != null) {
                arq.close();
            }
            InputStream inputStream = getClass().getResourceAsStream("/" + selectedFileName);

            if (inputStream == null) {
                System.out.println("Arquivo não encontrado: " + selectedFileName);
                return;
            }

            arq = new BufferedReader(new InputStreamReader(inputStream));
            arq.readLine(); 
            linhaAtual = 1;

            dados.setNomeArquivo(selectedFileName);
        } catch (IOException e) {
            System.err.println("Erro ao abrir o novo arquivo: " + e.getMessage());
        }
    }

    private void LerArquivos() {
        try {
            String arqSelecionado = (String) campoQB.getSelectedItem();

            if (arqSelecionado.isEmpty()) {
                System.out.println("Selecione um novo arquivo primeiro.");
                return;
            }

            if (arq != null) {
                arq.close();
            }

            escolherArquivo();
            processarProximoInstante();

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo TXT: " + e.getMessage());
        }
    }
//    private void lerDadosDeOutrosParticipantes() {
//    	 try {
//    	        List<Dados> dadosOutrosParticipantes = dadosDAO.lerDadosDeOutrosParticipantes();
//
//    	        for (Dados dados : dadosOutrosParticipantes) {
//    	            System.out.println("Dados de outros participantes: " + dados);
//    	        }
//
//    	        System.out.println("Leitura de dados de outros participantes concluída.");
//
//    	    } catch (SQLException ex) {
//    	        System.err.println("Erro ao ler dados de outros participantes: " + ex.getMessage());
//    	        ex.printStackTrace();
//    	    }
//    	}
//    public void gravarArquivoSaida() {
//        try {
//            String planetaComMaisMortes = dadosDAO.obterPlanetaComMaisMortes();
//
//            // Agora, você pode gravar essa informação no seu arquivo de saída
//            // ...
//
//        } catch (SQLException e) {
//            // Trate a exceção conforme necessário
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
            new MenuJavaLar();
            SwingUtilities.invokeLater(() -> {
            	new Painel().setVisible(true);
        });
    }
}