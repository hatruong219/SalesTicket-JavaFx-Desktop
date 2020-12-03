package sample.Home;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Server.ServiceSales;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Home_Main extends Application {
    public static ServiceSales serviceSales = null;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("home_xml.fxml").toURI().toURL());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.resizableProperty().setValue(false);
        primaryStage.setTitle("CLIENT TICKET SALES");
        primaryStage.show();
        serviceSales = (ServiceSales) Naming.lookup("rmi://192.168.58.21:6789//Myservice");
    }
}
