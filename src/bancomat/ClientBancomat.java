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
import javax.swing.*;

/**
 *
 * @author rolandosucco
 */
public class ClientBancomat implements ActionListener {
    private JFrame f;
    private JTextField testo;
    private JTextArea msg;
    private JPanel p1,p2;
    public ClientBancomat(){
    f=new JFrame("Bancomat");
    //f.setSize(500, 500);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     msg = new JTextArea("Inserisci Carta");
     f.add(msg,BorderLayout.CENTER);
     JButton[] b=new JButton[5];
     b[0]=new JButton("Login");
     b[1]=new JButton("Prelievo");
     b[2]= new JButton("Versamento");
     b[3]=new JButton("Lista");
     b[4]=new JButton("Ricarica");
     for(int i=0;i<b.length;i++)
      b[i].addActionListener(this);
      p1= new JPanel();
      testo=new JTextField();
      testo.setPreferredSize(new Dimension(300,30));
      p1.add(testo);
      p1.add(b[0]);
      f.add(p1,BorderLayout.SOUTH);
      p2=new JPanel();
      p2.setPreferredSize(new Dimension(100,400));
      for(int i=1;i<b.length;i++)
          p2.add(b[i]);
      f.add(p2,BorderLayout.LINE_END);
     p2.setVisible(false);
     f.pack();
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
          
    }
    }
    
}
