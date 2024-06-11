package geomate.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;
import geomate.Main;

public class MainController {

    @FXML
    private Button botonDesafios;

    @FXML
    public void initialize() {
        // Inicializa la animación del botón
        animarBotonDesafio();
    }

    @FXML
    private void iniciarDesafio(ActionEvent event) throws Exception {
        Main.showQuestionScene();
    }

    private void animarBotonDesafio() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.5), e -> botonDesafios.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: WHITE;")),
                new KeyFrame(Duration.seconds(1), e -> botonDesafios.setStyle("-fx-background-color: #45A049; -fx-text-fill: WHITE;"))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
