package sample;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;



public class Athlete implements Serializable {
    //Fields
    private static Controller myController;
    private static ArrayList<Athlete> athletes;
    private int Rank;
    private String Name;
    private String Sport;
    private String Nation;
    private int Earnings;

    public Athlete(int rank, String name, String sport, String nation, int earnings) {
        this.Rank = rank;
        this.Name = name;
        this.Sport = sport;
        this.Nation = nation;
        this.Earnings = earnings;

        if(athletes == null){
            athletes = new ArrayList<Athlete>();
        }
        athletes.add(this);
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSport() {
        return Sport;
    }

    public void setSport(String sport) {
        Sport = sport;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String nation) {
        Nation = nation;
    }

    public int getEarnings() {
        return Earnings;
    }

    public void setEarnings(int earnings) {
        Earnings = earnings;
    }

    public static Controller getMyController() {
        return myController;
    }

    public static void setMyController(Controller myController) {
        Athlete.myController = myController;
    }

    public static ArrayList<Athlete> getAthletes() {
        return athletes;
    }

    public static void setAthletes(ArrayList<Athlete> athletes) {
        Athlete.athletes = athletes;
    }


    public static void save(){
        if(athletes != null && !athletes.isEmpty()) {
            try {
                File savedModelFile = new File("serializedAllAthletes");
                FileOutputStream savedModelFileStream = new FileOutputStream(savedModelFile);
                ObjectOutputStream out = new ObjectOutputStream(savedModelFileStream);
                out.writeObject(athletes);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    static public boolean restore(){

       File savedModelFile = new File("serializedAllAthletes");
       if (savedModelFile.exists()){
           try {
               FileInputStream savedModelFileStream = new FileInputStream(savedModelFile);
               ObjectInputStream in = new ObjectInputStream(savedModelFileStream);
               athletes = (ArrayList<Athlete>)in.readObject();
               if (!athletes.isEmpty()){
                   return  true;
               }
           } catch (Exception ex)  {
               ex.printStackTrace();
           }
       }
       return false;
    }

    static void describeAll() {
        athletes.forEach((eachAthlete)-> {
            System.out.println(eachAthlete);
        } );

    }

    static void initialize() {
        getMyController().updateAthleteUI();
    }
}
