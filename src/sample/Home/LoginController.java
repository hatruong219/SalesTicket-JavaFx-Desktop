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

public class LoginController implements Initializable {
    @FXML
    static
    TextField tfPhone;
    static PasswordField pfPass;
    Button btnLogin, btnRegister;
    public void Register(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage stage = (Stage) btnRegister.getScene().getWindow();
            stage.resizableProperty().setValue(false);
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int getID_User(){
        int ID_User = 0;
        String phone = tfPhone.getText();
        String pass = pfPass.getText();
        try {
            ID_User = Home_Main.serviceSales.getID_User(phone,pass);
            return ID_User;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return ID_User;
    }
    public void Login(){
        try {
            String phone = tfPhone.getText();
            String pass = pfPass.getText();
            boolean check = Home_Main.serviceSales.checkLogin(phone,pass);
            if (check){
                Parent root = FXMLLoader.load(getClass().getResource("home_xml.fxml"));
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.resizableProperty().setValue(false);
                stage.setScene(new Scene(root));
            }
            else {
                Alert alert = new Alert(Alert.AlertType.NONE,
                        "Tên tài khoản không chính xác", ButtonType.APPLY);
                alert.show();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getID_User();
    }
}
