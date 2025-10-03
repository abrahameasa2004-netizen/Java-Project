import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex; // 0-based

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean checkAnswer(int userChoice) {
        return (userChoice - 1) == correctAnswerIndex;
    }
}
