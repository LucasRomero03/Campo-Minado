package InterfaceCampoMinado;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Jogador {

	private  String nome ;
	private String  y;
	 private String tempo;
	private  String saida = "";
	private  String everything;

	
	
		
	
	public Jogador(String nome, String tempo) {
		
		this.nome = nome;
		this.tempo = tempo;
			
		
		
	}
	
	public Jogador() {
		
		
			
		
		
		
		
		
	}	
	public  void salvar() {
		
		
		
		nome =JOptionPane.showInputDialog("Insira Seu Nome");
		
	    tempo = Cronometro.hours_string+":"+Cronometro.minutes_string+":"+Cronometro.seconds_string;
	    
		try {
			FileWriter fw = new FileWriter("jogadores.txt",true);
			PrintWriter pw = new PrintWriter(fw);
			pw.printf(nome +";"+tempo+";");
			
			pw.flush();
			pw.close();
			fw.close();
			
			
			
				
		
			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		
		
	}
	 public void lerLista() {
		Path caminho = Paths.get("C:/Users/romer/eclipse-workspace/CampoMinadoLPOO/jogadores.txt");
			try {
				byte[] texto  =  Files.readAllBytes(caminho);
				String leitura = new String(texto);
				y= leitura;
			  
			} catch (Exception erro) {
				
			}
			
			String[] palavras = y.split(";");
			ArrayList<Jogador> ar = new ArrayList<Jogador>();
			for (int i = 0; i < palavras.length -1  ; i++) {
			     
				
				  nome = palavras[i];
				  tempo = palavras[i+1];
				
				ar.add(new Jogador(nome,tempo));
				i++;
			}
			
			Collections.sort(ar, new SortTempo());
			
			for (int i = 0; i < ar.size(); i++) {
				 everything = ar.get(i).toString();
				
				saida += everything+"\n";
			}
			JOptionPane.showMessageDialog(null, saida,"Ranking",3);
			
	 }
	 
	 


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTempo() {
		return tempo;
	}


	public void setTempo(String tempo) {
		this.tempo = tempo;
	}


	
	
	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	

	public String toString(){
	    return "Nome: " + nome + "\n"+ " Tempo: " + tempo +"\n";
	}





	
	
	

	
}
