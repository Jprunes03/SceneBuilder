package sample;
public class AllTimeAthlete extends Athlete {
    //Fields


    public AllTimeAthlete(int rank, String name, String sport, String nation, int earnings) {
        super(rank, name, sport, nation, earnings);
    }
    public String toString() {
        String description = "\"" + this.getName();
        description += "\" is ranked #" + this.getRank();
        description += ". He plays " + this.getSport();
        description += " in " + this.getNation();
        description += " and has earned " + this.getEarnings();
        description += "in millions.";
        return description;
    }



}
