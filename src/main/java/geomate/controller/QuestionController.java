package geomate.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import geomate.model.Question;
import geomate.model.QuestionManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
    private Button answerButton4;

    private Question currentQuestion;

    @FXML
    public void initialize() {
        loadRandomQuestion();
    }

    private void loadRandomQuestion() {
        currentQuestion = QuestionManager.getRandomQuestion();
        if (currentQuestion != null) {
            questionLabel.setText(currentQuestion.getQuestionText());
            String[] answers = currentQuestion.getAnswers();
            answerButton1.setText(answers[0]);
            answerButton2.setText(answers[1]);
            answerButton3.setText(answers[2]);
            answerButton4.setText(answers[3]);

            answerButton1.setOnAction(event -> handleAnswer(0));
            answerButton2.setOnAction(event -> handleAnswer(1));
            answerButton3.setOnAction(event -> handleAnswer(2));
            answerButton4.setOnAction(event -> handleAnswer(3));
        }
    }

    private void handleAnswer(int selectedIndex) {
        boolean isCorrect = currentQuestion.isCorrectAnswer(selectedIndex);
        String message = isCorrect ? "¡Correcto!" : "Incorrecto. Intenta de nuevo.";
        questionLabel.setText(message);

        // Espera un segundo antes de cargar la siguiente pregunta
        new Timeline(new KeyFrame(Duration.seconds(1), e -> loadRandomQuestion())).play();
    }
}
