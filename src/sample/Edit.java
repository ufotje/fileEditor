package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.io.*;

public class Edit {
    @FXML
    private TextArea tArea;
    private Alert alert = new Alert(Alert.AlertType.NONE);

    @FXML
    public void initialize() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Controller.file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (br != null) {
            String st;
            while ((st = br.readLine()) != null)
                tArea.appendText(st + "\n");
        }
    }

    @FXML
    private void saveEdit() {
        try {
            PrintWriter writer = new PrintWriter(Controller.file);
            writer.write(tArea.getText());
            writer.close();
            Controller.files.add(Controller.file);
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("The file has bin successful edited and saved.");
            alert.showAndWait();
            tArea.setText("");
        } catch (FileNotFoundException e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Unable to write to file");
            alert.showAndWait();
        }
    }
}
