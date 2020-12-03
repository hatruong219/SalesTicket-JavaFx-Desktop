package sample.Home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.*;

public class Controller_Home implements Initializable {
    // lấy id
    int ID_User = LoginController.getID_User();


    final ToggleGroup allChoice = new ToggleGroup();
    @FXML
    Button btnBuyTrain,btnSearch;
    @FXML
    TabPane tpSearch;
    @FXML
    ComboBox<String> cbDeparture;
    @FXML
    ComboBox<String> cbDestination;
    @FXML
    ComboBox<String> cbTime;
    @FXML
    DatePicker dpDate;
    @FXML
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10,rb11,rb12,rb13,rb14,rb15
            ,rb16,rb17,rb18,rb19,rb20,rb21,rb22,rb23,rb24,rb25,rb26,rb27,rb28;

    public void ButtonSearch(){
        String Departure = cbDeparture.getValue();
        String Destination = cbDestination.getValue();
        String Time = cbTime.getValue();
        LocalDate Date = dpDate.getValue();

        try {
            boolean check = Home_Main.serviceSales.checkRoute(Departure, Destination, Time);
            ArrayList<Integer> t =  Home_Main.serviceSales.getSeats(Departure, Destination, Time, Date);
            if (check){
                buttonss();
                for (int i=0; i<t.size(); i++){
                    switch (t.get(i)){
                        case 1:{
                            rb1.setDisable(true);
                            continue;
                        }
                        case 2:{
                            rb2.setDisable(true);
                            continue;
                        }
                        case 3:{
                            rb3.setDisable(true);
                            continue;
                        }
                        case 4:{
                            rb4.setDisable(true);
                            continue;
                        }
                        case 5:{
                            rb5.setDisable(true);
                            continue;
                        }case 6:{
                            rb6.setDisable(true);
                            continue;
                        }case 7:{
                            rb7.setDisable(true);
                            continue;
                        }case 8:{
                            rb8.setDisable(true);
                            continue;
                        }case 9:{
                            rb9.setDisable(true);
                            continue;
                        }case 10:{
                            rb10.setDisable(true);
                            continue;
                        }case 11:{
                            rb11.setDisable(true);
                            continue;
                        }case 12:{
                            rb12.setDisable(true);
                            continue;
                        }case 13:{
                            rb13.setDisable(true);
                            continue;
                        }
                        case 14:{
                            rb14.setDisable(true);
                            continue;
                        }
                        case 15:{
                            rb15.setDisable(true);
                            continue;
                        }
                        case 16:{
                            rb16.setDisable(true);
                            continue;
                        }case 17:{
                            rb17.setDisable(true);
                            continue;
                        }
                        case 18:{
                            rb18.setDisable(true);
                            continue;
                        }case 19:{
                            rb19.setDisable(true);
                            continue;
                        }
                        case 20:{
                            rb20.setDisable(true);
                            continue;
                        }
                        case 21:{
                            rb21.setDisable(true);
                            continue;
                        }
                        case 22:{
                            rb22.setDisable(true);
                            continue;
                        }
                        case 23:{
                            rb23.setDisable(true);
                            continue;
                        }
                        case 24:{
                            rb24.setDisable(true);
                            continue;
                        }case 25:{
                            rb25.setDisable(true);
                            continue;
                        }
                        case 26:{
                            rb26.setDisable(true);
                            continue;
                        }
                        case 27:{
                            rb27.setDisable(true);
                            continue;
                        }
                        case 28:{
                            rb28.setDisable(true);
                            continue;
                        }
                        default:
                            break;
                    }
                }
                tpSearch.setPrefHeight(149);
                tpSearch.setPrefWidth(601);

            }
            else{
                tpSearch.setPrefWidth(0);
                tpSearch.setPrefHeight(0);
                buttonss();
            }
            System.out.println(t);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
    public  void buttonss(){
        rb1.setDisable(false);
        rb2.setDisable(false);rb3.setDisable(false);rb4.setDisable(false);
        rb5.setDisable(false);rb6.setDisable(false);rb7.setDisable(false);
        rb8.setDisable(false);rb9.setDisable(false);rb10.setDisable(false);
        rb11.setDisable(false);rb12.setDisable(false);rb13.setDisable(false);
        rb14.setDisable(false);rb15.setDisable(false);rb16.setDisable(false);
        rb17.setDisable(false);rb18.setDisable(false);rb19.setDisable(false);
        rb20.setDisable(false);rb21.setDisable(false);rb22.setDisable(false);
        rb23.setDisable(false);rb24.setDisable(false);rb25.setDisable(false);
        rb26.setDisable(false);rb27.setDisable(false);rb28.setDisable(false);
    }

    public void BuyTrain() {
        RadioButton selectedRadioButton = (RadioButton) allChoice.getSelectedToggle();
        String ss = selectedRadioButton.getText();
        if (ss!= null){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("information_xml.fxml"));
                Stage stage = (Stage) btnBuyTrain.getScene().getWindow();
                stage.resizableProperty().setValue(false);
                stage.setScene(new Scene(root, 600, 500));


            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        else {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION,
                    "Bạn chưa chọn ghế ngồi", ButtonType.OK);
            // show the dialog
            a1.show();
        }

    }

//    public ArrayList<String> getValue() {
//        ArrayList<String> ss = new ArrayList<>();
//        RadioButton selectedRadioButton = (RadioButton) allChoice.getSelectedToggle();
//        String s1 = selectedRadioButton.getText();
//        String s2 = cbDeparture.getValue();
//        String s3 = cbDestination.getValue();
//
//        ss.add(0,s1);
//        ss.add(1,s2);
//        ss.add(3,s3);
//        System.out.println(ss);
//        return ss;
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tpSearch.setPrefWidth(0);
        tpSearch.setPrefHeight(0);
        ObservableList<String> list = FXCollections.observableArrayList("HÀ NỘI","TP.HCM");
        cbDeparture.setItems(list);
        cbDestination.setItems(list);
        ObservableList<String> listtime = FXCollections.observableArrayList("08:00:00","17:00:00","22:00:00");
        cbTime.setItems(listtime);
        rb1.setToggleGroup(allChoice);
        rb2.setToggleGroup(allChoice);
        rb3.setToggleGroup(allChoice);
        rb4.setToggleGroup(allChoice);
        rb5.setToggleGroup(allChoice);
        rb6.setToggleGroup(allChoice);
        rb7.setToggleGroup(allChoice);
        rb8.setToggleGroup(allChoice);
        rb9.setToggleGroup(allChoice);
        rb10.setToggleGroup(allChoice);
        rb11.setToggleGroup(allChoice);
        rb12.setToggleGroup(allChoice);
        rb13.setToggleGroup(allChoice);
        rb14.setToggleGroup(allChoice);
        rb15.setToggleGroup(allChoice);
        rb16.setToggleGroup(allChoice);
        rb17.setToggleGroup(allChoice);
        rb18.setToggleGroup(allChoice);
        rb19.setToggleGroup(allChoice);
        rb20.setToggleGroup(allChoice);
        rb21.setToggleGroup(allChoice);
        rb22.setToggleGroup(allChoice);
        rb23.setToggleGroup(allChoice);
        rb24.setToggleGroup(allChoice);
        rb25.setToggleGroup(allChoice);
        rb26.setToggleGroup(allChoice);
        rb27.setToggleGroup(allChoice);
        rb28.setToggleGroup(allChoice);
    }
}

