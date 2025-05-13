package com.example.finalprojectv2;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SatelliteDatabaseApp extends Application {

    private final ObservableList<Satellite> satelliteData = FXCollections.observableArrayList(
            new Satellite("Hubble Space Telescope", "USA", "1990-04-24", "Low Earth Orbit", "Observatory",
                    "Active", "Atlantis", "11,110 kg", "13.3m x 4.2m", "Solar", "X-band", "95 min", "540 km", "Optical, UV, Infrared"),
            new Satellite("GPS IIR-1", "USA", "2000-10-17", "Medium Earth Orbit", "Navigation",
                    "Inactive", "Atlas II", "1,630 kg", "2.4m x 2.0m", "Solar", "L1/L2 bands", "12 hrs", "20,200 km", "Navigation Payload"),
            new Satellite("Starlink 1", "USA (SpaceX)", "2019-05-24", "Low Earth Orbit", "Internet",
                    "Active", "Falcon 9", "260 kg", "2.8m x 2.2m", "Solar", "Ku-band", "90 min", "550 km", "Data Relay, Communications"),
            new Satellite("Sentinel-2A", "EU (ESA)", "2015-06-23", "Sun-synchronous Orbit", "Earth Observation",
                    "Active", "Vega", "1,140 kg", "3.4m x 1.8m", "Solar", "X-band", "100 min", "786 km", "Multispectral Camera"),
            new Satellite("Gaofen-4", "China", "2015-12-28", "Geostationary Orbit", "Earth Observation",
                    "Active", "Long March 3B", "4,600 kg", "3.8m x 2.2m", "Solar", "X-band", "24 hrs", "35,786 km", "Infrared Camera"),
            new Satellite("Astra 1KR", "Luxembourg (SES)", "2006-04-20", "Geostationary Orbit", "Telecommunication",
                    "Active", "Atlas V", "5,535 kg", "2.4m x 3.0m", "Solar", "Ku-band", "24 hrs", "35,786 km", "Broadcast Transponders"),
            new Satellite("RISAT-2BR1", "India", "2019-12-11", "Low Earth Orbit", "Radar Imaging",
                    "Active", "PSLV-C48", "628 kg", "1.6m x 1.4m", "Solar", "X-band", "95 min", "576 km", "SAR Radar Payload")

    );

    @Override
    public void start(Stage primaryStage) {
        TableView<Satellite> tableView = new TableView<>();
        tableView.setItems(satelliteData);

        // Columns
        TableColumn<Satellite, String> nameCol = createColumn("Name", "name");
        TableColumn<Satellite, String> countryCol = createColumn("Country", "country");
        TableColumn<Satellite, String> dateCol = createColumn("Launch Date", "launchDate");
        TableColumn<Satellite, String> orbitCol = createColumn("Orbit", "orbitType");
        TableColumn<Satellite, String> missionCol = createColumn("Mission", "missionType");
        TableColumn<Satellite, String> statusCol = createColumn("Status", "operationalStatus");

        tableView.getColumns().addAll(nameCol, countryCol, dateCol, orbitCol, missionCol, statusCol);

        // Search
        TextField searchField = new TextField();
        searchField.setPromptText("Search by name");
        searchField.textProperty().addListener((obs, oldVal, newVal) -> filterTable(newVal, tableView));

        // Buttons
        Button sortDateBtn = new Button("Sort by Date");
        sortDateBtn.setOnAction(e -> {
            satelliteData.sort((a, b) -> a.getLaunchDate().compareTo(b.getLaunchDate()));
            tableView.setItems(satelliteData);
        });

        Button sortOrbitBtn = new Button("Sort by Orbit");
        sortOrbitBtn.setOnAction(e -> {
            satelliteData.sort((a, b) -> a.getOrbitType().compareToIgnoreCase(b.getOrbitType()));
            tableView.setItems(satelliteData);
        });

        Button sortCountryBtn = new Button("Sort by Country");
        sortCountryBtn.setOnAction(e -> {
            satelliteData.sort((a, b) -> a.getCountry().compareToIgnoreCase(b.getCountry()));
            tableView.setItems(satelliteData);
        });

        Button sortStatusBtn = new Button("Sort by Status");
        sortStatusBtn.setOnAction(e -> {
            satelliteData.sort((a, b) -> a.getOperationalStatus().compareToIgnoreCase(b.getOperationalStatus()));
            tableView.setItems(satelliteData);
        });

        Button filterInternetBtn = new Button("Filter: Internet Mission");
        filterInternetBtn.setOnAction(e -> {
            ObservableList<Satellite> filtered = FXCollections.observableArrayList();
            for (Satellite s : satelliteData) {
                if (s.getMissionType().equalsIgnoreCase("Internet")) {
                    filtered.add(s);
                }
            }
            tableView.setItems(filtered);
        });

        HBox buttons = new HBox(10, sortDateBtn, sortOrbitBtn, sortCountryBtn, sortStatusBtn, filterInternetBtn);
        VBox root = new VBox(10, searchField, buttons, tableView);
        root.setPadding(new javafx.geometry.Insets(10));

        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setTitle("Satellite Database");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TableColumn<Satellite, String> createColumn(String title, String prop) {
        TableColumn<Satellite, String> col = new TableColumn<>(title);
        col.setCellValueFactory(cell -> {
            switch (prop) {
                case "name": return new SimpleStringProperty(cell.getValue().getName());
                case "country": return new SimpleStringProperty(cell.getValue().getCountry());
                case "launchDate": return new SimpleStringProperty(cell.getValue().getLaunchDate());
                case "orbitType": return new SimpleStringProperty(cell.getValue().getOrbitType());
                case "missionType": return new SimpleStringProperty(cell.getValue().getMissionType());
                case "operationalStatus": return new SimpleStringProperty(cell.getValue().getOperationalStatus());
                default: return new SimpleStringProperty("N/A");
            }
        });
        return col;
    }

    private void filterTable(String text, TableView<Satellite> tableView) {
        ObservableList<Satellite> filtered = FXCollections.observableArrayList();
        for (Satellite s : satelliteData) {
            if (s.getName().toLowerCase().contains(text.toLowerCase())) {
                filtered.add(s);
            }
        }
        tableView.setItems(filtered);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
