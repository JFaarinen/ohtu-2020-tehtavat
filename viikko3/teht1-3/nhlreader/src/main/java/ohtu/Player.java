
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private String team;
    private int goals;
    private int assists;
    private String nationality;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getTeam() {
        return this.team;
    }
    
    public void setGoals(int goals) {
        this.goals = goals;
    }
    
    public int getGoals() {
        return this.goals;
    }
    
    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    public int getAssists() {
        return this.assists;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public int getPoints() {
        return goals+assists;
    }

    @Override
    public String toString() {
        return name + " team " + team + "  " +goals+ " + " +assists+ " = " +getPoints();
    }

    @Override
    public int compareTo(Player o) {
        return o.getPoints() - this.getPoints();
    }
      
}
