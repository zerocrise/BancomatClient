/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancomat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rolandosucco
 */
public class Ascolta extends Thread{
    private Socket s;
    private ClientBancomat c;
    
    public Ascolta() {
    }

    Ascolta(Socket s, ClientBancomat aThis) {
    this.s=s;
    c=aThis;
    }
    public void run(){
     boolean connesso=true;
     Protocollo p=new Protocollo();
     Tipo t;
     ObjectInputStream inp=null;
        try {
            inp=new ObjectInputStream(s.getInputStream());
        } catch (IOException ex) {
            System.out.println("errore stream");   
        }
        while(connesso){
         try {
             p=(Protocollo)inp.readObject();
         } catch (IOException ex) {
             Logger.getLogger(Ascolta.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Ascolta.class.getName()).log(Level.SEVERE, null, ex);
         }
         switch(p.tipo){
             case RISPOSTAPIN:
                 if(p.isAutorizzazione())
                     c.visualizza();
                 else 
                   c.scrivi("pin errato");
                 break;
         }
        }
        
    }
    
}
