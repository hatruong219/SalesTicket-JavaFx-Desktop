package sample.Home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    TextField tfName, tfCart, tfPhone;
    PasswordField pfPass, pfConfirmPass;
    Button btnRegister;
    public void Register(){
        String Name = tfName.getText();
        String Cart = tfCart.getText();
        String Phone = tfPhone.getText();
        String Pass = pfPass.getText();
        String ConfirmPass = pfConfirmPass.getText();
        if (Pass != ConfirmPass){
            Alert a1 = new Alert(Alert.AlertType.NONE,
                    "ConfirmPass không trùng Pass", ButtonType.APPLY);
            // show the dialog
            a1.show();
        }
        else {
            try {
                boolean check = Home_Main.serviceSales.register(Name, Cart, Phone, Pass);
                if (check){
                    Alert a1 = new Alert(Alert.AlertType.NONE,
                            "Đăng ký thành công", ButtonType.APPLY);
                    // show the dialog
                    a1.show();
                    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                    Stage stage = (Stage) btnRegister.getScene().getWindow();
                    stage.resizableProperty().setValue(false);
                    stage.setScene(new Scene(root));
                }
                else {
                    Alert a1 = new Alert(Alert.AlertType.NONE,
                            "Đăng ký thất bại", ButtonType.APPLY);
                    // show the dialog
                    a1.show();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
