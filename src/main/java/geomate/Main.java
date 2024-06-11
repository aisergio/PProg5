package geomate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        showMainScene();
    }

    public static void showMainScene() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("/fxml/MainScene.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Inicio");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showQuestionScene() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("/fxml/QuestionScene.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Preguntas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
