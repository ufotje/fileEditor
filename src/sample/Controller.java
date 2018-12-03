package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private BorderPane bPane;
    static File file;
    static List<File> files = new ArrayList<>();
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a textFile!");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        file = fileChooser.showOpenDialog(new Stage());

    }

    @FXML
    private void edit(){
        try {
            bPane.setCenter(FXMLLoader.load(getClass().getResource("center.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void save() {
        if (file != null) {
            files.add(file);
            alert.setContentText("File has bin saved");
            alert.showAndWait();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("No File Selected!");
            alert.showAndWait();
        }
    }



    @FXML
    private void delete() {
    }
}
