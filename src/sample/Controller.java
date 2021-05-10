package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class Controller {
    public TextField textField1;
    public Button TwentyTwentyEdit;
    public Button TwentyTwentyImport;

    public TableView<Athlete> alltimeTable;
    public TableColumn<Athlete, Integer> rankColumn;
    public TableColumn<Athlete, String> nameColumn;
    public TableColumn<Athlete, String> sportColumn;
    public TableColumn<Athlete, String> nationColumn;
    public TableColumn<Athlete, Integer> earningsColumn;

    public Accordion myAccordian;
    public TitledPane twentytwentyPane;

    public void initialize() {
        Athlete.setMyController(this);

        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        sportColumn.setCellValueFactory(new PropertyValueFactory<>("sport"));
        nationColumn.setCellValueFactory(new PropertyValueFactory<>("nation"));
        earningsColumn.setCellValueFactory(new PropertyValueFactory<>("earnings"));
        TwentyTwentyImport.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                TwentyTwentyImport();
            }
        });

        boolean thereWasData = restoreData();
        if (thereWasData){
            updateAthleteUI();
            myAccordian.setExpandedPane(twentytwentyPane);
        }
    }

    public boolean restoreData(){
        return TwentyTwentyAthlete.restore();
    }

    public void TwentyTwentyImport(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null && selectedFile.exists()); {
            TwentyTwentyAthlete.read(selectedFile.getPath());

            updateAthleteUI();
            myAccordian.setExpandedPane(twentytwentyPane);
        }
    }

    void updateAthleteUI() {
        // Delete every item from UI
        alltimeTable.getItems().clear();
        ArrayList<Athlete> allAthletes = Athlete.getAthletes();
        if (allAthletes != null) {
            allAthletes.forEach(athlete -> {
                alltimeTable.getItems().add(athlete);
            });
        }
    }

}
