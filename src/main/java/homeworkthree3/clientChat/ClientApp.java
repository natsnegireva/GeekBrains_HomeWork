package homeworkthree3.clientChat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ClientApp extends Application {
    private static Stage stage;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("/Client.fxml"));
        Image image = new Image(getClass().getResourceAsStream("/chat.png"));
        primaryStage.setTitle("Чат для девчат");
        primaryStage.getIcons().add(image);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.show();
    }
    public static Stage getStage() {
        return stage;
    }
}
