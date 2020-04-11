/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author Juho
 */
public class Komentotehdas {
    
    private Sovelluslogiikka laskin;
    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JButton undo;
    
    public Komentotehdas(Sovelluslogiikka laskin, JButton plus, JButton miinus, JButton nollaa, JButton undo) {
        this.laskin = laskin;
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
    }
    
    public Komento hae(ActionEvent ae, int arvo) {
        if (ae.getSource() == plus) {
            return new Summa(laskin, arvo);
        } else if (ae.getSource() == miinus) {           
            return new Erotus(laskin, arvo);
        } else if (ae.getSource() == nollaa) {
            return new Nollaa(laskin);
        }
        return new Tuntematon();
    
    }
    
}
