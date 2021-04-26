package sample;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Controller {
    public TextField textField1;
    public TextField textField2;
    public Button AllTimeButton;

    public TableView<Athlete> alltimeTable;
    public TableColumn<Athlete, Integer> rankColumn;
    public TableColumn<Athlete, String> nameColumn;
    public TableColumn<Athlete, String> sportColumn;
    public TableColumn<Athlete, String> nationColumn;
    public TableColumn<Athlete, Integer> earningsColumn;

    public void initialize() {
        Athlete.setMyController(this);

        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        sportColumn.setCellValueFactory(new PropertyValueFactory<>("sport"));
        nationColumn.setCellValueFactory(new PropertyValueFactory<>("nation"));
        earningsColumn.setCellValueFactory(new PropertyValueFactory<>("earnings"));

        TwentyTwentyAthlete.initialize();
        AllTimeAthlete.initialize();
        Athlete.initialize();

        Athlete.describeAll();
    }

    void updateAthleteUI() {
        // Delete every item from UI
        alltimeTable.getItems().clear();
        ArrayList<Athlete> allFilms = Athlete.getAthletes();
        if (allFilms != null) {
            allFilms.forEach(athlete -> {
                alltimeTable.getItems().add(athlete);
            });
        }
    }

}
