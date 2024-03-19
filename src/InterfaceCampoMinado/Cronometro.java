package InterfaceCampoMinado;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import CodigosFonteCampoMinado.ConstantesTabuleiro;

public class Cronometro implements ActionListener{
 
 JFrame frame ;

 static JLabel timeLabel = new JLabel();
 public static int elapsedTime = 0;
 public static int seconds =0;
 public static int minutes =0;
 public static int hours =0;
 protected static boolean saida = false;
 public boolean started = false;
 static String seconds_string = String.format("%02d", seconds);
 static String minutes_string = String.format("%02d", minutes);
 static String hours_string = String.format("%02d", hours);
 
 static Timer timer = new Timer(1000, new ActionListener() {
  
  public void actionPerformed(ActionEvent e) {
   
   elapsedTime=elapsedTime+1000;
   hours = (elapsedTime/3600000);
   minutes = (elapsedTime/60000) % 60;
   seconds = (elapsedTime/1000) % 60;
   seconds_string = String.format("%02d", seconds);
   minutes_string = String.format("%02d", minutes);
   hours_string = String.format("%02d", hours);
   timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
   
  }
  
 });
 
 
 public Cronometro(JFrame frame ){
	 
  this.frame = frame;
  timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
  timeLabel.setBounds((ConstantesTabuleiro.tamanhoCelula*ConstantesTabuleiro.nColunas)/2 - (ConstantesTabuleiro.tamanhoCelula)/2 +70, 70,80,40);
  timeLabel.setFont(new Font("Verdana",Font.PLAIN,15));
  timeLabel.setBorder(BorderFactory.createBevelBorder(1));
  timeLabel.setOpaque(true);
  timeLabel.setHorizontalAlignment(JTextField.CENTER);
  
  

  
  
  frame.add(timeLabel);
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
  frame.setLayout(null);
  frame.setVisible(true);
  frame.setResizable(false);
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  
 
  
 }
 
 public void start() {
  timer.start();
 }
 
 public void stop() {
  timer.stop();
 }
 
 public void reset() {
  timer.stop();
  elapsedTime=0;
  seconds =0;
  minutes=0;
  hours=0;
  seconds_string = String.format("%02d", seconds);
  minutes_string = String.format("%02d", minutes);
  hours_string = String.format("%02d", hours);     
  timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
 }

}