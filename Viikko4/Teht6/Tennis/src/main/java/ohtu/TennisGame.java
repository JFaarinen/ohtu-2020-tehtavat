package ohtu;

public class TennisGame {
    
    Pelaaja p1;
    Pelaaja p2;

    public TennisGame(String player1Name, String player2Name) {
        p1 = new Pelaaja(player1Name);
        p2 = new Pelaaja(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(p1.getNimi())) {
            p1.lisaaPiste();
        } else if (playerName.equals(p2.getNimi())) {
            p2.lisaaPiste();
        }
    }

    public String getScore() {
        String score = "";
        if (p1.getPisteidenLkm()==p2.getPisteidenLkm()){
            score = pisteytaTasatilanne(p1.getPisteidenLkm());
        }
        else if (p1.getPisteidenLkm()>=4 || p2.getPisteidenLkm()>=4)
        {
            score = tarkistaVoittotilanne();
        }
        else
        {
            score = p1.pisteet() + "-" + p2.pisteet();
        }
        return score;
    }
    
    public String pisteytaTasatilanne(int pisteet) {
        String tulos;
        if (pisteet == 0) {
            tulos = "Love-All";
        } else if (pisteet > 3) {
            tulos = "Deuce";
        } else {
            tulos = p1.pisteet() + "-All";
        }
        return tulos;
    }
    
    public String tarkistaVoittotilanne() {
        String tulos="";
        int pisteidenEro = p1.getPisteidenLkm()-p2.getPisteidenLkm();
        if (pisteidenEro==1) tulos ="Advantage player1";
        else if (pisteidenEro ==-1) tulos ="Advantage player2";
        else if (pisteidenEro>=2) tulos = "Win for player1";
        else tulos ="Win for player2";  
        return tulos;
    }
}