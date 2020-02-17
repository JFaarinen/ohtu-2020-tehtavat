package ohtuesimerkki;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Juho
 */
public class StatisticsTest {
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
    
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void playerHakeeOikeanPelaajan() {
        Player p = stats.search("Semenko");
        assertEquals("Semenko", p.getName());
    }
    
    @Test
    public void playerPalauttaaTyhjanJosPelaajaaEiLoydy() {
        Player p = stats.search("Koivu");
        assertEquals(null, p);
    }
    
    @Test
    public void teamHakeeJoukkueenPelaajat() {
        List pelaajat = stats.team("EDM");
        assertEquals(3, pelaajat.size());
    }
    
    @Test
    public void topScoresPalauttaaOikeatPisteet() {
        List top = stats.topScorers(3);
        Player grezky = (Player)top.get(0);
        assertEquals(3, top.size());
        assertEquals(124, grezky.getPoints());
    }

}
