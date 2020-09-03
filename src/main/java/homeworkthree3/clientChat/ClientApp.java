package homeworkthree3.clientChat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientApp extends Application {


    public static void main(String[] args) {
        launch(args);
        new ClientService().run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Client.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("My Chat");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }
}
