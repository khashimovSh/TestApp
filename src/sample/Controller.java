package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controller {

    @FXML
    private ToggleGroup answers;

    @FXML
    private Text question_text;

    @FXML
    private RadioButton radio_btn_1;

    @FXML
    private RadioButton radio_btn_2;

    @FXML
    private RadioButton radio_btn_3;

    @FXML
    private RadioButton radio_btn_4;

    @FXML
    private Button answerBtn;

    @FXML
    private Button java;

    @FXML
    private Button csharp;

    @FXML
    private Button cplusplus;

    @FXML
    private Button python;

    @FXML
    private Button js;

    private Questions[] questions = new Questions[]{
            new Questions("Which format is correct?", new String[]{"Console.Write","console.log","print","System.out.println()"}),
            new Questions("Which datatype is for whole numbers?", new String[] {"String", "Float", "Boolean", "Integer"}),
            new Questions("Which declaration of two-dimensional array is correct?", new String[] {"a(0)(0) = 1;", "a[0 0] = 1;", "a{0}{0} = 1;", "a[0][0] = 1;"}),
            new Questions("Which method allows to start java?", new String[] {"No such method", "from class which was written first and method on it", "any, just we should set on settings", "from main method from any class"}),
            new Questions("Every file should be called...", new String[] {"with first library on it", "with package name", "as your wish", "with name of class on it"}),
            new Questions("How many parameters can get method?", new String[] {"5", "10", "20", "no limit"})
    };

    private int nowQuestion = 0, correctAnswers;
    private String nowCorrectAnswer;

    @FXML
    public void initialize() {
        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

        answerBtn.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
            if(selectedRadioButton != null) {
                String toogleGroupValue = selectedRadioButton.getText();

                if(toogleGroupValue.equals(nowCorrectAnswer)) {
                    System.out.println("Верный ответ");
                    correctAnswers++;
                } else {
                    System.out.println("Не верный ответ");
                }

                // Это был последний вопрос
                if(nowQuestion + 1 == questions.length) {
                    radio_btn_1.setVisible(false);
                    radio_btn_2.setVisible(false);
                    radio_btn_3.setVisible(false);
                    radio_btn_4.setVisible(false);
                    answerBtn.setVisible(false);

                    question_text.setText("Вы ответили корректно на " + correctAnswers + " из " + questions.length + " вопросов!");
                } else {
                    nowQuestion++;
                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                    question_text.setText(questions[nowQuestion].getQuestion());
                    String[] answers = questions[nowQuestion].getAnswers();


                    List<String> intList = Arrays.asList(answers);

                    Collections.shuffle(intList);

                    radio_btn_1.setText(intList.get(0));
                    radio_btn_2.setText(intList.get(1));
                    radio_btn_3.setText(intList.get(2));
                    radio_btn_4.setText(intList.get(3));

                    selectedRadioButton.setSelected(false);
                }

            }
        });
        csharp.setOnAction(event ->{
            
        });

    }




}
