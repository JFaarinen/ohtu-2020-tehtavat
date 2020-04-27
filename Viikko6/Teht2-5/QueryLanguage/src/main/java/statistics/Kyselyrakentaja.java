/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.Matcher;

/**
 *
 * @author Juho
 */
public class Kyselyrakentaja {
    Statistics stats;
    
    public Kyselyrakentaja(PlayerReaderImpl imp) {
        stats = new Statistics(imp);
    }
    
    public Statistics tilasto() {
        return stats;
    }
   
}
