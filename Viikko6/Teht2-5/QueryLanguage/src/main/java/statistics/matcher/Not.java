/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author Juho
 */
public class Not implements Matcher {
    Matcher ehto;
    
    public Not(Matcher m) {
        this.ehto = m;
    }

    @Override
    public boolean matches(Player p) {
        return !ehto.matches(p);
    }
    
}
