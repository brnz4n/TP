package t2back;


public class CSharp extends Planetas {
	public CSharp(int X, int Y, String nome) {
		super(X, Y, nome);
	}

	{
		setVelDeslocamento(1);
		setLimiteminX(5);
		setLimitemaxX(15);
		setLimiteminY(5);
		setLimitemaxY(15);
		setVelRotacao(6);
		setMovimentosAno(40);
		setMovimentosDados(0); // this.velDeslocamento = 1;
								// this.limiteminX = 5;
								// this.limitemaxX = 15;
								// this.limiteminY = 5;
								// this.limitemaxY = 15;
								// this.velRotacao = 6;
								// this.movimentosAno = 40;
								// this.movimentosDados = 0;
		setResumoLinguagem(
				"C# é uma linguagem de programação orientada a objetos e orientada a componentes. "
				+ "\n" + "C# fornece construções de linguagem para dar suporte diretamente a esses conceitos, "
				+ "\n" + "tornando C# uma linguagem natural para criação e uso de componentes de software.");
	}

}