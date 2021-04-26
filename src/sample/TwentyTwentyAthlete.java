package sample;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyTwentyAthlete extends Athlete {
    //Fields
    private int Salary;
    private int Endorsements;

    public TwentyTwentyAthlete(int rank, String name, String sport, String nation, int earnings, int salary, int endorsements) {
        super(rank, name, sport, nation, earnings);
        this.Salary = salary;
        this.Endorsements = endorsements;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getEndorsements() {
        return Endorsements;
    }

    public void setEndorsements(int endorsements) {
        Endorsements = endorsements;
    }

    public String toString() {
        String description = "\"" + this.getName();
        description += "\" is ranked #" + this.getRank();
        description += ". He plays " + this.getSport();
        description += " in " + this.getNation();
        description += " and has earned " + this.getEarnings();
        description += " in Millions. He makes " + this.getSalary();
        description += " million for his salary and makes " + this.getEndorsements();
        description += " million in endorsements.";
        return description;
    }

    static void read(String dataFilePath) {
        Scanner scanner = null;
        try {
            File file = new File(dataFilePath);
            scanner = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problem opening file: " + dataFilePath);
        }
        if (scanner == null) {
            // I can't scan without a scanner, so we're done.
            return;
        }

        // Read from each line in data file until there are no more
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            // Construct a new scanner for each to get its tokens
            Scanner lineScanner = new Scanner(next);
            // Data tokens are separated by tabs
            lineScanner.useDelimiter("\t");

            int rank = lineScanner.nextInt();
            String name = lineScanner.next();
            String sport = lineScanner.next();
            String nation = lineScanner.next();
            int earnings = lineScanner.nextInt();
            int salary = lineScanner.nextInt();
            int endorsements = lineScanner.nextInt();

            Athlete athlete = new TwentyTwentyAthlete(rank, name, sport, nation, earnings, salary, endorsements);
        }

    }

}