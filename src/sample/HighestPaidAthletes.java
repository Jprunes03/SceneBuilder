package sample;
import java.util.ArrayList;

public class HighestPaidAthletes {

    public static void main(String[] args) {
        String pathToTwentyTwentyAthleteData = args[0];
        TwentyTwentyAthlete.read(pathToTwentyTwentyAthleteData);

        Athlete.describeAll();
    }
}
