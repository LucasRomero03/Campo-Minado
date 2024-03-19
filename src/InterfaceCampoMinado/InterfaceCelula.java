package InterfaceCampoMinado;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import CodigosFonteCampoMinado.Celula;
import CodigosFonteCampoMinado.Tabuleiro;

public class InterfaceCelula extends JButton {
	private static final long serialVersionUID = 1L;

	int linha;
	int coluna;
	Tabuleiro t;
	Celula e;
	InterfaceTabuleiro it;
	String text;
		
	public InterfaceCelula(Tabuleiro t, InterfaceTabuleiro it) {
		this.t = t;
		this.it = it;
		text = "";
		this.setText(text);
		this.addActionListener((java.awt.event.ActionEvent evento) -> { 
			buttonAction(false);
		});
		this.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mousePressed(java.awt.event.MouseEvent e) { // Usar bot�o direito do mouse (peguei no Stackoverflow).
				if(SwingUtilities.isRightMouseButton(e)) {
					buttonAction(true);
				}
			}
		});
	}
	public void pressionar() {
		
		System.out.println("linha: " + linha + " coluna: " + coluna);
		int retorno = t.clicarButton(linha, coluna);// retorno � o numero de vizinhos com minas
		
		if (this.e.isMinado()) {
			this.it.revelarMinas();
			
			
		}
		
		if (retorno ==0) {
			for ( Celula vizinho : e.vizinhos) {
				
				if (!vizinho.isClicado()) {
					vizinho.button.pressionar();
					this.setIcon(null);
				}
			}
			//return;
		}
		
		this.text = Integer.toString(retorno);
		this.revelaMinado(this.text);
		this.setIcon(null);
		
		
	}
	public void buttonAction(boolean botaoDireito) { // A��o do Button (bot�o gr�fico).
		
		
		if (!botaoDireito) {
			if (!this.e.isMarcado()) {
				this.pressionar();
				
			}InterfaceCampoMinado.Cronometro.timer.start();
		} else {
			this.marcarBandeira();
			
		}InterfaceCampoMinado.Cronometro.timer.start();
		this.it.checarGanhouOuPerdeu();
		
													
	}
	
	public void setPosition(int linha, int coluna) { // Informar linha e coluna do button.
		this.linha = linha;
		this.coluna = coluna;
		this.e  = t.getCelula(linha, coluna);        
			
	}
	
	
	public void revelaMinado(String retorno) { // setText "-1" em todas as minas reveladas.
		this.setText(retorno);
		this.setEnabled(false);
		this.setIcon(null);
	}
	
	public void marcarBandeira() {
		if(this.e.isClicado()) {
			return;
		}
		
		boolean marcado = this.e.marcarBandeira();
		
		if(this.e.isMarcado()) {
			Icon icon1 = new ImageIcon("src/imagens/bandeira_.png");

			//this.setText("M");
			
			this.setIcon(icon1);
			
		}else {
			this.setIcon(null);
			this.setText("");
		}
	}
	public void resetar() {
		this.e.reset();
		this.text = "";
		this.setText(text);
		this.setEnabled(true);
		this.setIcon(null);
	}

} 
