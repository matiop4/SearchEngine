package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import GUI.ReadedFile;

public class Controller {

    @FXML
    private ListView<File> dataListLV;

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

    // TESTOWE
    @FXML
    private Button testBT;
    ////////////////////////////


    @FXML
    void loadFilesBTclick(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users"));
        ExtensionFilter TXTFilter = new ExtensionFilter("TXT Files","*.txt");
        fc.getExtensionFilters().addAll(TXTFilter);
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);

        if (selectedFiles != null)
        {
            for(int i =0; i< selectedFiles.size();i++)
            {
                if(!dataListLV.getItems().contains(selectedFiles.get(i).getAbsoluteFile()))
                dataListLV.getItems().add(selectedFiles.get(i).getAbsoluteFile());
            }
        }
        else
        {
            System.out.println("ReadedFile not valid!");
        }
    }

    void listViewSelection() throws IOException
    {
        dataListLV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        File selectedfile = dataListLV.getSelectionModel().getSelectedItem();

        String path = selectedfile.getPath();
        //
        System.out.println(path);
        //
        ReadedFile readedfile = new ReadedFile(path);

        for(int i =0; i< readedfile.getList().size();i++)
        {
            resultListLV.getItems().add(readedfile.getLine(i));
            System.out.println(readedfile.getLine(i));
        }


    }

    //TESTOWE
    @FXML
    void testBTclick(ActionEvent event) throws IOException {
        listViewSelection();
    }
    ///////////////////////////
}
