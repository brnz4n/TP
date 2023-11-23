package t2front;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DadosDAO {
	private Conexao conexao;
	
	public DadosDAO(Conexao conexao) {
        this.conexao = conexao;
    }
	
    private static final String INSERIR_DADOS_SQL = "INSERT INTO javalar (nome, matricula, id, nome_arquivo, "
            + "bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c, "
            + "dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c, "
            + "v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, "
            + "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, "
            + "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, "
            + "bug_q1, bug_q2, bug_q3, bug_q4) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


    public void inserirDados(Dados dados) {
    	
    	System.out.println("Query SQL: " + INSERIR_DADOS_SQL);

        try (Connection connection = conexao.getConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_DADOS_SQL)) {

            configurarParametros(preparedStatement, dados);

            preparedStatement.executeUpdate();

            System.out.println("Dados inseridos com sucesso.");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir dados: " + e.getMessage());
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }
//    public List<Dados> lerDadosDeOutrosParticipantes() throws SQLException {
//        List<Dados> dadosList = new ArrayList<>();
//        Connection connection = null;
//
//        try {
//            
//            connection = conexao.getConexao();
//
//            
//            String query = "SELECT * FROM javalar"; 
//
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
//                 ResultSet resultSet = preparedStatement.executeQuery()) {
//
//                while (resultSet.next()) {
//                 
//                    Dados dados = new Dados();
//                    dados.setNome(resultSet.getString("nome"));
//                    dados.setMatricula(resultSet.getString("matricula"));
//
//                    dadosList.add(dados);
//                }
//            }
//
//        } finally {
//            conexao.fecharConexao(); 
//        }
//
//        return dadosList;
//    }
//    public Dados obterAlunoComMaisInstantesJavaLar() throws SQLException {
//        String query = "SELECT * FROM tabela_dados ORDER BY (bugQ1 + bugQ2 + bugQ3 + bugQ4) DESC LIMIT 1";
//        try (Connection connection = conexao.getConexao();
//                PreparedStatement preparedStatement = connection.prepareStatement(query);
//                ResultSet resultSet = preparedStatement.executeQuery()) {
//
//
//            if (resultSet.next()) {
//                Dados aluno = new Dados();
//                aluno.setNome(resultSet.getString("nome"));
//                aluno.setMatricula(resultSet.getString("matricula"));
//                return aluno;
//            }
//        }
//        return null;
//    }
    public String obterPlanetaComMaisMortes() throws SQLException {
        String query = "SELECT nome_arquivo, (bugQ1 + bugQ2 + bugQ3 + bugQ4) AS totalMortes FROM javalar ORDER BY totalMortes DESC LIMIT 1";
        try (Connection connection = conexao.getConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                String nomeArquivo = resultSet.getString("nome_arquivo");
                int totalMortes = resultSet.getInt("totalMortes");

                System.out.println("Planeta com mais mortes: " + nomeArquivo + ", Total de Mortes: " + totalMortes);

                return nomeArquivo;
            }
        }
        return null;
    }


    private void configurarParametros(PreparedStatement preparedStatement, Dados dados) throws SQLException {
        preparedStatement.setString(1, dados.getNome());
        preparedStatement.setString(2, dados.getMatricula());
        preparedStatement.setString(3, dados.getId());
        preparedStatement.setString(4, dados.getNomeArquivo());
        preparedStatement.setInt(5, dados.getBugPython());
        preparedStatement.setInt(6, dados.getBugJavaScript());
        preparedStatement.setInt(7, dados.getBugRuby());
        preparedStatement.setInt(8, dados.getBugPHP());
        preparedStatement.setInt(9, dados.getBugCSharp());
        preparedStatement.setInt(10, dados.getBugCPlusPlus());
        preparedStatement.setInt(11, dados.getBugC());
        preparedStatement.setInt(12, dados.getDevPython());
        preparedStatement.setInt(13, dados.getDevJavaScript());
        preparedStatement.setInt(14, dados.getDevRuby());
        preparedStatement.setInt(15, dados.getDevPHP());
        preparedStatement.setInt(16, dados.getDevCSharp());
        preparedStatement.setInt(17, dados.getDevCPlusPlus());
        preparedStatement.setInt(18, dados.getDevC());
        preparedStatement.setDouble(19, dados.getvPython());
        preparedStatement.setDouble(20, dados.getvJavaScript());
        preparedStatement.setDouble(21, dados.getvRuby());
        preparedStatement.setDouble(22, dados.getvPHP());
        preparedStatement.setDouble(23, dados.getvCSharp());
        preparedStatement.setDouble(24, dados.getvCPlusPlus());
        preparedStatement.setDouble(25, dados.getvC());
        preparedStatement.setDouble(26, dados.getdPython());
        preparedStatement.setDouble(27, dados.getdJavaScript());
        preparedStatement.setDouble(28, dados.getdRuby());
        preparedStatement.setDouble(29, dados.getdPHP());
        preparedStatement.setDouble(30, dados.getdCSharp());
        preparedStatement.setDouble(31, dados.getdCPlusPlus());
        preparedStatement.setDouble(32, dados.getdC());
        preparedStatement.setDouble(33, dados.getaPython());
        preparedStatement.setInt(34, dados.getaJavaScript());
        preparedStatement.setDouble(35, dados.getaRuby());
        preparedStatement.setDouble(36, dados.getaPHP());
        preparedStatement.setDouble(37, dados.getaCSharp());
        preparedStatement.setDouble(38, dados.getaCPlusPlus());
        preparedStatement.setDouble(39, dados.getaC());
        preparedStatement.setInt(40, dados.getBugQ1());
        preparedStatement.setInt(41, dados.getBugQ2());
        preparedStatement.setInt(42, dados.getBugQ3());
        preparedStatement.setInt(43, dados.getBugQ4());
    }
}
