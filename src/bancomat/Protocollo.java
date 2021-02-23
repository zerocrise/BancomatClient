/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancomat;

import java.io.Serializable;

/**
 *
 * @author rolandosucco
 */
public class Protocollo implements Serializable {
  Tipo tipo;
    private int pin;
    private  int cifra;
    private String msg;
    private boolean autorizzazione;

    public Protocollo() {
    }

    public Protocollo(Tipo tipo, int pin, String msg) {
        this.tipo = tipo;
        this.pin = pin;
        this.msg = msg;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getCifra() {
        return cifra;
    }

    public void setCifra(int cifra) {
        this.cifra = cifra;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isAutorizzazione() {
        return autorizzazione;
    }

    public void setAutorizzazione(boolean autorizzazione) {
        this.autorizzazione = autorizzazione;
    }
    
    
}
