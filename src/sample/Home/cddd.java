package sample.Home;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class cddd implements Initializable {
    final ToggleGroup allChoice = new ToggleGroup();
    @FXML
    RadioButton rb1,rb2,rb3,rb4,rb5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rb1.setToggleGroup(allChoice);
        rb2.setToggleGroup(allChoice);
        rb3.setToggleGroup(allChoice);
        rb4.setToggleGroup(allChoice);
        rb5.setToggleGroup(allChoice);
        allChoice.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
                System.out.println("Selected Radio Button - "+chk.getText());
                String dd = chk.getText();
                System.out.println(dd);
            }
        });
    }

}
