package geomate.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import geomate.Main;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionManager {
    private static List<Question> questions = new ArrayList<>();

    public static void loadQuestionsFromFile(String filePath) {
        try (InputStreamReader reader = new InputStreamReader(Main.class.getResourceAsStream(filePath))) {
            questions = new Gson().fromJson(reader, new TypeToken<List<Question>>() {}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}
