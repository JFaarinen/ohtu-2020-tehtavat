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
public class Pelaaja {
    private String nimi;
    private int pisteet;
    
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public int getPisteidenLkm() {
        return pisteet;
    }
    
    public void lisaaPiste() {
        pisteet+=1;
    }
    
    public String pisteet() {
        String tilanne="";
        switch (pisteet) {
            case 0:
                tilanne = "Love";
                break;
            case 1:
                tilanne = "Fifteen";
                break;
            case 2:
                tilanne = "Thirty";
                break;
            case 3:
                tilanne = "Forty";
                break;
        }
        return tilanne;
    }
}
