package t2front;

import java.util.List;
import t2back.Impressoes;
import t2back.SistemaPlanetas;
import t2back.Planetas;

public class Dados {
    private String nome;
    private String matricula;
    private String id;
    private String nomeArquivo;
    private int bugPython;
    private int bugJavaScript;
    private int bugRuby;
    private int bugPHP;
    private int bugCSharp;
    private int bugCPlusPlus;
    private int bugC;
    private int devPython;
    private int devJavaScript;
    private int devRuby;
    private int devPHP;
    private int devCSharp;
    private int devCPlusPlus;
    private int devC;
    private double vPython;
    private double vJavaScript;
    private double vRuby;
    private double vPHP;
    private double vCSharp;
    private double vCPlusPlus;
    private double vC;
    private double dPython;
    private double dJavaScript;
    private double dRuby;
    private double dPHP;
    private double dCSharp;
    private double dCPlusPlus;
    private double dC;
    private double aPython;
    private int aJavaScript;
    private double aRuby;
    private double aPHP;
    private double aCSharp;
    private double aCPlusPlus;
    private double aC;
    private int bugQ1;
    private int bugQ2;
    private int bugQ3;
    private int bugQ4;
    Impressoes imprimir = new Impressoes();
    int planetasExplodidos=0;
    
    public void PegarDados(SistemaPlanetas sistema) {
        List<Planetas> planetas = sistema.planetas;

        for (Planetas planeta : planetas) {
            if(planeta.getNome()== "C") {
            	setBugC(planeta.getBugsColididos());
            	setDevC(planeta.getDevsColididos());
            	setvC(planeta.getVelDeslocamento());
            	setdC(planeta.getDias());
            	setaC(planeta.getAnos());
            }
            	else{
            		if(planeta.getNome()=="Php") {
            			setBugPHP(planeta.getBugsColididos());
            			setDevPHP(planeta.getDevsColididos());
            			setvPHP(planeta.getVelDeslocamento());
            			setdPHP(planeta.getDias());
            			setaPHP(planeta.getAnos());
            		}else {
            			if(planeta.getNome()=="Ruby") {
            				setBugRuby(planeta.getBugsColididos());
            				setDevRuby(planeta.getDevsColididos());
            				setvRuby(planeta.getVelDeslocamento());
            				setdRuby(planeta.getDias());
            				setaRuby(planeta.getAnos());
            		
            			}else {
            				if(planeta.getNome()=="C++") {
            					setBugCPlusPlus(planeta.getBugsColididos());
            					setDevCPlusPlus(planeta.getDevsColididos());
            					setvCPlusPlus(planeta.getVelDeslocamento());
            					setdCPlusPlus(planeta.getDias());
            					setaCPlusPlus(planeta.getAnos());
            				}else {
            					if(planeta.getNome()=="Phyton") {
            						setBugPython(planeta.getBugsColididos());
            						setDevPython(planeta.getDevsColididos());
            						setvPython(planeta.getVelDeslocamento());
            						setdPython(planeta.getDias());
            						setaPython(planeta.getAnos());
            					}else {
                					if(planeta.getNome()=="Csharp") {
                						setBugCSharp(planeta.getBugsColididos());
                						setDevCSharp(planeta.getDevsColididos());
                						setvCSharp(planeta.getVelDeslocamento());
                						setvCSharp(planeta.getDias());
                						setaCSharp(planeta.getAnos());
                					}else {
                    					if(planeta.getNome()=="JavaScript") {
                    						setBugJavaScript(planeta.getBugsColididos());
                    						setDevCSharp(planeta.getDevsColididos());
                    						setvCSharp(planeta.getVelDeslocamento());
                    						setvCSharp(planeta.getDias());
                    						setaCSharp(planeta.getAnos());
                    					}
                		 		
                					}
            					}
            				}
            			}
            		}
            } 
        }
    }
    
    public Dados() {
    	nomeArquivo = "";
    	this.nomeArquivo = nomeArquivo;
    }
    public String Nomearquivo() {
    	return nomeArquivo;
    	
    }
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public int getBugPython() {
		return bugPython;
	}

	public void setBugPython(int bugPython) {
		this.bugPython = bugPython;
	}

	public int getBugJavaScript() {
		return bugJavaScript;
	}

	public void setBugJavaScript(int bugJavaScript) {
		this.bugJavaScript = bugJavaScript;
	}

	public int getBugRuby() {
		return bugRuby;
	}

	public void setBugRuby(int bugRuby) {
		this.bugRuby = bugRuby;
	}

	public int getBugPHP() {
		return bugPHP;
	}

	public void setBugPHP(int bugPHP) {
		this.bugPHP = bugPHP;
	}

	public int getBugCSharp() {
		return bugCSharp;
	}

	public void setBugCSharp(int bugCSharp) {
		this.bugCSharp = bugCSharp;
	}

	public int getBugCPlusPlus() {
		return bugCPlusPlus;
	}

	public void setBugCPlusPlus(int bugCPlusPlus) {
		this.bugCPlusPlus = bugCPlusPlus;
	}

	public int getBugC() {
		return bugC;
	}

	public void setBugC(int bugC) {
		this.bugC = bugC;
	}

	public int getDevPython() {
		return devPython;
	}

	public void setDevPython(int devPython) {
		this.devPython = devPython;
	}

	public int getDevJavaScript() {
		return devJavaScript;
	}

	public void setDevJavaScript(int devJavaScript) {
		this.devJavaScript = devJavaScript;
	}

	public int getDevRuby() {
		return devRuby;
	}

	public void setDevRuby(int devRuby) {
		this.devRuby = devRuby;
	}

	public int getDevPHP() {
		return devPHP;
	}

	public void setDevPHP(int devPHP) {
		this.devPHP = devPHP;
	}

	public int getDevCSharp() {
		return devCSharp;
	}

	public void setDevCSharp(int devCSharp) {
		this.devCSharp = devCSharp;
	}

	public int getDevCPlusPlus() {
		return devCPlusPlus;
	}

	public void setDevCPlusPlus(int devCPlusPlus) {
		this.devCPlusPlus = devCPlusPlus;
	}

	public int getDevC() {
		return devC;
	}

	public void setDevC(int devC) {
		this.devC = devC;
	}

	public double getvPython() {
		return vPython;
	}

	public void setvPython(int vPython) {
		this.vPython = vPython;
	}

	public double getvJavaScript() {
		return vJavaScript;
	}

	public void setvJavaScript(int vJavaScript) {
		this.vJavaScript = vJavaScript;
	}

	public double getvRuby() {
		return vRuby;
	}

	public void setvRuby(int vRuby) {
		this.vRuby = vRuby;
	}

	public double getvPHP() {
		return vPHP;
	}

	public void setvPHP(int vPHP) {
		this.vPHP = vPHP;
	}

	public double getvCSharp() {
		return vCSharp;
	}

	public void setvCSharp(double d) {
		this.vCSharp = d;
	}

	public double getvCPlusPlus() {
		return vCPlusPlus;
	}

	public void setvCPlusPlus(int vCPlusPlus) {
		this.vCPlusPlus = vCPlusPlus;
	}

	public double getvC() {
		return vC;
	}

	public void setvC(int vC) {
		this.vC = vC;
	}

	public double getdPython() {
		return dPython;
	}

	public void setdPython(double d) {
		this.dPython = d;
	}

	public double getdJavaScript() {
		return dJavaScript;
	}

	public void setdJavaScript(int dJavaScript) {
		this.dJavaScript = dJavaScript;
	}

	public double getdRuby() {
		return dRuby;
	}

	public void setdRuby(double d) {
		this.dRuby = d;
	}

	public double getdPHP() {
		return dPHP;
	}

	public void setdPHP(double d) {
		this.dPHP = d;
	}

	public double getdCSharp() {
		return dCSharp;
	}

	public void setdCSharp(int dCSharp) {
		this.dCSharp = dCSharp;
	}

	public double getdCPlusPlus() {
		return dCPlusPlus;
	}

	public void setdCPlusPlus(double d) {
		this.dCPlusPlus = d;
	}

	public double getdC() {
		return dC;
	}

	public void setdC(double d) {
		this.dC = d;
	}

	public double getaPython() {
		return aPython;
	}

	public void setaPython(double d) {
		this.aPython = d;
	}

	public int getaJavaScript() {
		return aJavaScript;
	}

	public void setaJavaScript(int aJavaScript) {
		this.aJavaScript = aJavaScript;
	}

	public double getaRuby() {
		return aRuby;
	}

	public void setaRuby(double d) {
		this.aRuby = d;
	}

	public double getaPHP() {
		return aPHP;
	}

	public void setaPHP(double d) {
		this.aPHP = d;
	}

	public double getaCSharp() {
		return aCSharp;
	}

	public void setaCSharp(double d) {
		this.aCSharp = d;
	}

	public double getaCPlusPlus() {
		return aCPlusPlus;
	}

	public void setaCPlusPlus(double d) {
		this.aCPlusPlus = d;
	}

	public double getaC() {
		return aC;
	}

	public void setaC(double d) {
		this.aC = d;
	}

	public int getBugQ1() {
		return bugQ1;
	}

	public void setBugQ1(int bugQ1) {
		this.bugQ1 = bugQ1;
	}

	public int getBugQ2() {
		return bugQ2;
	}

	public void setBugQ2(int bugQ2) {
		this.bugQ2 = bugQ2;
	}

	public int getBugQ3() {
		return bugQ3;
	}

	public void setBugQ3(int bugQ3) {
		this.bugQ3 = bugQ3;
	}

	public int getBugQ4() {
		return bugQ4;
	}

	public void setBugQ4(int bugQ4) {
		this.bugQ4 = bugQ4;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
