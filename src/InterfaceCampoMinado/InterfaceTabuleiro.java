  package InterfaceCampoMinado;



import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import CodigosFonteCampoMinado.ConstantesTabuleiro;
import CodigosFonteCampoMinado.Main;
import CodigosFonteCampoMinado.Tabuleiro;

public class InterfaceTabuleiro extends JFrame {
	private static final long serialVersionUID = 1L; 
	JPanel panel; // painel gr�fico.
	InterfaceCelula[][] matrizButton;
	Tabuleiro t;
	JButton botaoReset;
	JButton botaoFacil;
	JButton botaoMedio;
	JButton botaoDificil;
	JButton botaoCmm;
	
	
	public InterfaceTabuleiro() {	
		iniciarInterface();
		
	}
	
	
	public  void resetGerral() {
			Main.resetGeral();
			this.dispose();
			
		}
	
	private void iniciarInterface() {
		this.t = new Tabuleiro();
		t.iniciarTabuleiro();
		t.inserirMinas();
		this.panel = new JPanel();	
		panel.setLayout(null);
		this.add(panel);
		System.out.println(t);
		
		
				
		iniciarTabuleiroNaInterface();
						
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // N�o rodar em segundo plano quando fechar a janela.
		this.setSize((ConstantesTabuleiro.nColunas*ConstantesTabuleiro.tamanhoCelula)+ConstantesTabuleiro.diferencaLateral, (ConstantesTabuleiro.nLinhas*ConstantesTabuleiro.tamanhoCelula) + ConstantesTabuleiro.deslocamento + ConstantesTabuleiro.diferencaSuperior); // Setar o tamanho da janela.
		this.setResizable(false); // N�o deixa redimensionar a janela. 
		this.setVisible(true); // Tornar vis�vel.
			
		//botao reset
		Icon icon = new ImageIcon("src/imagens/Screenshot_1.png");
		this.botaoReset = new JButton(icon);
		this.panel.add(this.botaoReset);
		this.botaoReset.addActionListener((java.awt.event.ActionEvent evento) -> {
			Cronometro.elapsedTime=0;
			  Cronometro.seconds =0;
			  Cronometro.minutes=0;
			  Cronometro.hours=0;
			  
			this.resetar();
			
			
		});
		this.botaoReset.setSize(ConstantesTabuleiro.tamanhoCelula, ConstantesTabuleiro.tamanhoCelula);
		this.botaoReset.setLocation((ConstantesTabuleiro.tamanhoCelula*ConstantesTabuleiro.nColunas)/2 - (ConstantesTabuleiro.tamanhoCelula)/2, 70);
	
		//botao facil
		Icon iconf = new ImageIcon("C:\\Users\\romer\\eclipse-workspace\\CampoMinadoLPOO\\src\\imagens\\f.png");
		this.botaoFacil = new JButton(iconf);
		this.panel.add(this.botaoFacil);
		this.botaoFacil.addActionListener((java.awt.event.ActionEvent evento) -> {
			 ConstantesTabuleiro.nLinhas = 6;
			 ConstantesTabuleiro.nColunas= 6;
			 ConstantesTabuleiro.nMinas = 7;
			 Cronometro.elapsedTime=0;
			  Cronometro.seconds =0;
			  Cronometro.minutes=0;
			  Cronometro.hours=0;
			this.resetGerral();
		});
		this.botaoFacil.setSize((ConstantesTabuleiro.tamanhoCelula -10), (ConstantesTabuleiro.tamanhoCelula -10));
		this.botaoFacil.setLocation(0 , 0);
	
		//botao Medio
		Icon iconm = new ImageIcon("C:\\Users\\romer\\eclipse-workspace\\CampoMinadoLPOO\\src\\imagens\\m.png");
		this.botaoMedio = new JButton(iconm);
		this.panel.add(this.botaoMedio);
		this.botaoMedio.addActionListener((java.awt.event.ActionEvent evento) -> {
			 ConstantesTabuleiro.nLinhas = 9;
			 ConstantesTabuleiro.nColunas= 9;
			 ConstantesTabuleiro.nMinas = 12;
			 Cronometro.elapsedTime=0;
			  Cronometro.seconds =0;
			  Cronometro.minutes=0;
			  Cronometro.hours=0;
			 this.resetGerral();
		});
		this.botaoMedio.setSize((ConstantesTabuleiro.tamanhoCelula -10 ), (ConstantesTabuleiro.tamanhoCelula -10));
		this.botaoMedio.setLocation((ConstantesTabuleiro.tamanhoCelula * ConstantesTabuleiro.nLinhas)/4+ 10 , 0);
		
		//botao Dificil
		Icon icond = new ImageIcon("C:\\Users\\romer\\eclipse-workspace\\CampoMinadoLPOO\\src\\imagens\\d.png");
		
		this.botaoDificil = new JButton(icond);
		this.panel.add(this.botaoDificil);
		this.botaoDificil.addActionListener((java.awt.event.ActionEvent evento) -> {
			 ConstantesTabuleiro.nLinhas = 15;
			 ConstantesTabuleiro.nColunas= 15;
			 ConstantesTabuleiro.nMinas = 38;
			 Cronometro.elapsedTime=0;
			  Cronometro.seconds =0;
			  Cronometro.minutes=0;
			  Cronometro.hours=0;
			 
			 this.resetGerral();
			
		});
		this.botaoDificil.setSize((ConstantesTabuleiro.tamanhoCelula -10), (ConstantesTabuleiro.tamanhoCelula-10));
		this.botaoDificil.setLocation( (ConstantesTabuleiro.tamanhoCelula * ConstantesTabuleiro.nLinhas)/4*2 +20, 0);
		
		//botao Ranking
		Icon iconcmm = new ImageIcon("C:\\Users\\romer\\eclipse-workspace\\CampoMinadoLPOO\\src\\imagens\\letra-r.png");
		this.botaoCmm = new JButton(iconcmm);
		this.panel.add(this.botaoCmm);
		this.botaoCmm.addActionListener((java.awt.event.ActionEvent evento) -> {
			Jogador save2 = new Jogador();
			save2.lerLista();
			//Ranking on = new Ranking();
	    	
	    	//try {
			//	on.leitorArq();
			//} catch (IOException e) {
			//	e.printStackTrace();
			//}
			
		
		});
		this.botaoCmm.setSize((ConstantesTabuleiro.tamanhoCelula-10), (ConstantesTabuleiro.tamanhoCelula-10));
		this.botaoCmm.setLocation((ConstantesTabuleiro.tamanhoCelula * ConstantesTabuleiro.nLinhas)/4*3 + 35 , 0);
		
		
		
	}
	
	public void iniciarTabuleiroNaInterface() {
		matrizButton = new InterfaceCelula[ConstantesTabuleiro.nLinhas][ConstantesTabuleiro.nColunas];
		
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				matrizButton[l][c] = new InterfaceCelula(this.t, this);
				t.getCelula(l, c).setButton(matrizButton[l][c]);
				matrizButton[l][c].setPosition(l, c);
				matrizButton[l][c].setSize(ConstantesTabuleiro.tamanhoCelula, ConstantesTabuleiro.tamanhoCelula); // Setar o tamanho do button.
				matrizButton[l][c].setLocation(ConstantesTabuleiro.tamanhoCelula*c, (ConstantesTabuleiro.tamanhoCelula*l)+ConstantesTabuleiro.deslocamento); // Setar a posi��o x e y dos buttons.
				panel.add(matrizButton[l][c]);
			}			
		}

		
	}

	public void revelarMinas() { // Revela todas as minas.
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				if (matrizButton[l][c].e.isMinado()) {
					matrizButton[l][c].revelaMinado("-1");
				}
			}
		}	
	}
	public void desativarButtons() {
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				matrizButton[l][c].setEnabled(false);
			}
		}
	}
	public void checarGanhouOuPerdeu() {
		if(this.t.ganhou()) {
			InterfaceCampoMinado.Cronometro.timer.stop();
			JOptionPane.showMessageDialog(this, "Ganhou!");
			Jogador save1 = new Jogador();
			save1.salvar();
			
			this.desativarButtons();
		}
		
		if(this.t.perdeu()) {
			InterfaceCampoMinado.Cronometro.timer.stop();
			JOptionPane.showMessageDialog(this, "Perdeu!");
			this.desativarButtons();
		}
	}
	public void resetar() {
		for (int l = 0; l < ConstantesTabuleiro.nLinhas; l++) {
			for (int c = 0; c < ConstantesTabuleiro.nColunas; c++) {
				matrizButton[l][c].resetar();
			}
		}
		this.t.inserirMinas();
	}
	
}
