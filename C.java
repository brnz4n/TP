package t2back;

public class C extends Planetas {

	public C(int X, int Y, String nome) {
		super(X, Y, nome);
	}

	{
		setVelDeslocamento(10);
		setLimiteminX(3);
		setLimitemaxX(17);
		setLimiteminY(3);
		setLimitemaxY(17);
		setVelRotacao(240);
		setMovimentosAno(56);
		setMovimentosDados(0); // this.velDeslocamento = 10;
								// this.limiteminX = 3;
								// this.limitemaxX = 17;
								// this.limiteminY = 3;
								// this.limitemaxY = 17;
								// this.velRotacao = 240;
								// this.movimentosAno = 56;
								// this.movimentosDados = 0;
		setResumoLinguagem(
				"Na linguagem C, todas as variáveis precisam ser declaradas no início do programa, antes de serem usadas."
				+ "\n" + "Elas também devem receber um tipo, que vai determinar quais espécies de valores cada variável pode armazenar."
				+ "\n" + "Por fim, uma variável pode ter seu conteúdo alterado a qualquer momento.");

	}

}