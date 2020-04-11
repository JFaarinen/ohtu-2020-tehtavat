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
public class Erotus extends Komento{
    int vahennettava;
    
    public Erotus(Sovelluslogiikka laskin, int vahennettava) {
        super(laskin);
        this.vahennettava = vahennettava;
    }

    @Override
    public void suorita() {
        laskin.miinus(vahennettava);
    }
    
    
}
