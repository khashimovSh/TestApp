package sample;

public class Questions {

    private String question;
    private String answers[];

    public Questions(String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }

    public String correctAnswer()
    {
        return answers[answers.length-1];
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
}
