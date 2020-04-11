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
public class Undo extends Komento{
    private int edellinenTila;
    
    public Undo(Sovelluslogiikka laskin, int edellinenTila) {
        super(laskin);
        this.edellinenTila = edellinenTila;
    }

    @Override
    public void suorita() {
        laskin.nollaa();
        laskin.plus(edellinenTila);
    }
    
}
