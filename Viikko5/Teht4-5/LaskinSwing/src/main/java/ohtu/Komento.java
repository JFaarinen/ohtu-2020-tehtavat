/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author Juho
 */
public abstract class Komento {
    protected Sovelluslogiikka laskin;
    
    public Komento() {
        
    }
    public Komento(Sovelluslogiikka laskin) {
        this.laskin = laskin;
    }
    
    public abstract void suorita();
        
}
