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
public class Nollaa extends Komento{
    
    public Nollaa(Sovelluslogiikka laskin) {
        super(laskin);
    }

    @Override
    public void suorita() {
        laskin.nollaa();
    }
    
}
