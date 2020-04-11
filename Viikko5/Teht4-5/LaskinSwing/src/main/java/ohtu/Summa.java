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
public class Summa extends Komento{
    int lisattava;
    
    public Summa(Sovelluslogiikka laskin, int lisattava) {
        super(laskin); 
        this.lisattava = lisattava;
    }

    @Override
    public void suorita() {
        laskin.plus(lisattava);
    }
    
}
