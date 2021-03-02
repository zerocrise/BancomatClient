/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancomat;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author rolandosucco
 */
public class ClientBancomat implements ActionListener {
    private JFrame f;
    private JTextField testo;
    private JTextArea msg;
    private JPanel p1,p2,p3,p4;
     private Socket s;
    private int porta=11234;
    private  InetAddress ip;
    private ObjectOutputStream out;
    private Protocollo p=new Protocollo();
    private Tipo t;
    private JButton[] b=new JButton[5];
    public ClientBancomat(){
    f=new JFrame("Bancomat");
    
   f.setSize(500, 500);
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     msg = new JTextArea("Inserisci Carta");
     f.add(msg,BorderLayout.CENTER);
     
     b[0]=new JButton("Login");
     b[1]=new JButton("Prelievo");
     b[2]= new JButton("Versamento");
     b[3]=new JButton("Lista");
     b[4]=new JButton("Ricarica");
     for(int i=0;i<b.length;i++)
      b[i].addActionListener(this);
      p1= new JPanel();
      testo=new JTextField();
      testo.setVisible(false);
      testo.setPreferredSize(new Dimension(300,30));
      p1.add(testo);
      p1.add(b[0]);
      f.add(p1,BorderLayout.SOUTH);
      p2=new JPanel();
      p2.setPreferredSize(new Dimension(100,400));
        p3=new JPanel();
      p3.setPreferredSize(new Dimension(100,400));
      for(int i=1;i<b.length;i++){
             b[i].setPreferredSize(new Dimension(90,40));
          p2.add(b[i]);
      }
      f.add(p2,BorderLayout.LINE_END);
      f.add(p3,BorderLayout.LINE_START);
       p4=new JPanel();
      p4.setPreferredSize(new Dimension(400,40));
       f.add(p4,BorderLayout.PAGE_START);
     p2.setVisible(false);
     //f.pack();
    f.setVisible(true);

   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ClientBancomat();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String evento= e.getActionCommand();
    switch(evento){
        case "Login":
        
            try {
                ip=InetAddress.getByName("localhost");
                s=new Socket(ip,porta);
               new Ascolta(s,this).start();
               
            } catch (UnknownHostException ex) {
              msg.setText("Connessione non disponibile");
              break;
            } catch (IOException ex) {
              
            break;
            }
      b[0].setText("Pin");
break;
case "Pin":
 int pin=Integer.parseInt(testo.getText());
  p.setPin(pin);
  p.setTipo(t.PIN);
        {
            try {
                out=new ObjectOutputStream(s.getOutputStream());
           out.writeObject(p);
  out.flush();
            } catch (IOException ex) {
                Logger.getLogger(ClientBancomat.class.getName()).log(Level.SEVERE, null, ex);
            break;
            }
        }
  
  b[0].setVisible(false);
  break;

          
          
            
            
           
         
          
    }
    }
 public void visualizza(){
 p2.setVisible(true);
 b[0].setVisible(false);
 msg.setText("Operazioni consentite");
 } 
 public void scrivi(String s){
 msg.setText(s);
 b[0].setVisible(true);
 }
}
