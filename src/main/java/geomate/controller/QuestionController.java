package geomate.controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class QuestionController {

    @FXML
    private VBox questionBox;

    @FXML
    private Label questionLabel;

    @FXML
    private Button answerButton1;
    @FXML
    private Button answerButton2;
    @FXML
    private Button answerButton3;

    @FXML
    public void initialize() {
        // Configurar la pregunta y las respuestas (esto puede ser dinámico en una implementación más completa)
        questionLabel.setText("¿Cuál es la distancia promedio entre la Tierra y Marte?");
        answerButton1.setText("78M Km");
        answerButton2.setText("225M Km");
        answerButton3.setText("384M Km");

        answerButton1.setOnAction(event -> mostrarResultado(false));
        answerButton2.setOnAction(event -> mostrarResultado(true));
        answerButton3.setOnAction(event -> mostrarResultado(false));
    }

    private void mostrarResultado(boolean esCorrecta) {
        String mensaje = esCorrecta ? "¡Correcto!" : "Incorrecto. Intenta de nuevo.";
        Stage resultadoStage = new Stage();
        Label resultadoLabel = new Label(mensaje);
        resultadoLabel.setStyle(esCorrecta ? "-fx-text-fill: green;" : "-fx-text-fill: red;");
        VBox vbox = new VBox(resultadoLabel);
        vbox.setAlignment(Pos.CENTER);
        resultadoStage.setScene(new Scene(vbox, 200, 100));
        resultadoStage.show();
    }
}
