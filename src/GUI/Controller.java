package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.util.List;

public class Controller {

    @FXML
    private ListView dataListLV;

    @FXML
    private RadioButton algorithm1RB;

    @FXML
    private RadioButton algorithm2RB;

    @FXML
    private RadioButton algorithm3RB;

    @FXML
    private Button searchBT;

    @FXML
    private TextField textSampleTF;

    @FXML
    private ListView resultListLV;

    @FXML
    private Button loadFilesBT;

    @FXML
    void loadFilesBTclick(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users"));
        ExtensionFilter TXTFilter = new ExtensionFilter("Txt Files","*.txt");
        fc.getExtensionFilters().addAll(TXTFilter);
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);

        if (selectedFiles != null)
        {
            for(int i =0; i< selectedFiles.size();i++)
            {
                if(!dataListLV.getItems().contains(selectedFiles.get(i).getName()))
                dataListLV.getItems().add(selectedFiles.get(i).getName());
            }
        }
        else
        {
            System.out.println("File not valid!");
        }
    }

}
