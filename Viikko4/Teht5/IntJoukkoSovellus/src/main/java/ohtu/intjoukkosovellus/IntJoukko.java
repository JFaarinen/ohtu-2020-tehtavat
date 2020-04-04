
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm=0;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        luvut = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Taulukon koko ei voi olla negatiivinen");
        }
        luvut = new int[kapasiteetti];
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Taulukon koko ei voi olla negatiivinen");
        }
        if (kasvatuskoko <= 0) {
            throw new IndexOutOfBoundsException("Taulukkoa kasvattava arvo ei voi olla negatiivinen");
        }
        luvut = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (onLukujoukossa(luku)) {
            return false;
        }
        
        if (luvut.length <= alkioidenLkm) {
            luvut = suurennaTaulukkoa(luvut);
        }
        
        luvut[alkioidenLkm] = luku;
        alkioidenLkm++;
        return true;
    }
    
    //Mahtavuus() on vaan pöljä nimi metodille joka kertoo lukuja sisältävän joukon koon
    public int koko() {
        return alkioidenLkm;
    }
    
    @Override
    public String toString() {
        StringBuilder palautusMerkkijono = new StringBuilder();
        palautusMerkkijono.append("{");
        if (alkioidenLkm > 0) {
            for (int i=0; i<alkioidenLkm-1; i++) {
                palautusMerkkijono.append(luvut[i] + ", ");
            }
            palautusMerkkijono.append(luvut[alkioidenLkm-1]);
        }
        palautusMerkkijono.append("}");
        return palautusMerkkijono.toString();
    }

    public boolean poista(int luku) {
        if (!onLukujoukossa(luku)) {
            return false;
        }      
        int[] uusiLukutaulu = new int[alkioidenLkm-1];
        int uusiIndeksi=0;
        for (int i=0; i<alkioidenLkm; i++) {
            if (luvut[i] == luku) {
                continue;
            } else {
                uusiLukutaulu[uusiIndeksi] = luvut[i];
                uusiIndeksi++;
            }             
        }
        alkioidenLkm--;
        luvut = uusiLukutaulu;
        return true;
    }

    public int[] toIntArray() {
        int[] palautettavaLukujoukko = new int[alkioidenLkm];
        for (int i = 0; i < palautettavaLukujoukko.length; i++) {
            palautettavaLukujoukko[i] = luvut[i];
        }
        return palautettavaLukujoukko;
    }
   
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdistetty = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdistetty.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdistetty.lisaa(bTaulu[i]);
        }
        return yhdistetty;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikattuJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikattuJoukko.lisaa(bTaulu[j]);
                }
            }
        }
        return leikattuJoukko;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotusJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotusJoukko.poista(bTaulu[i]);
        }
 
        return erotusJoukko;
    }
    
    //Tarkastetaan onko parametrilla välitetty luku IntJoukossa
    //ja onLukujoukossa on nyt vaan yksiselitteisempi nimi metodille kuin 'kuuluu()'
    public boolean onLukujoukossa(int luku) {
        if (alkioidenLkm == 0) {
            return false;
        } else {
            for (int i : luvut) {
                if (i == luku) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //Kopioidaan taulukon sisältö uuteen taulukkoon
    private void kopioiTaulukko(int[] kopioitava, int[] kohde) {
        for (int i = 0; i < kopioitava.length; i++) {
            kohde[i] = kopioitava[i];
        }
    }
    
    private int[] suurennaTaulukkoa(int[] taulukko) {
        int[] uusiTaulukko = new int[taulukko.length + kasvatuskoko];
        kopioiTaulukko(taulukko, uusiTaulukko); 
        return uusiTaulukko;
    }
    
    //Palauttaa parametrina annetun luvun indeksin lukujonossa
    //Jos lukua ei löydy lukujonosta palautetaan -1
    private int sijaintiLukujonossa(int luku) {
        for (int i=0; i<alkioidenLkm; i++) {
            if (luvut[i] == luku) {
                return i;
            }
        }
        return -1;
    }
        
}
