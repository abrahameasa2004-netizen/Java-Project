import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Sample questions
        questions.add(new Question(
            "Who developed Java?",
            Arrays.asList("Dennis Ritchie", "James Gosling", "Bjarne Stroustrup", "Guido van Rossum"),
            1 // James Gosling
        ));
        questions.add(new Question(
            "Which company owns Java now?",
            Arrays.asList("Google", "Oracle", "Microsoft", "IBM"),
            1 // Oracle
        ));
        questions.add(new Question(
            "Which keyword is used to inherit a class in Java?",
            Arrays.asList("this", "extends", "implements", "super"),
            1 // extends
        ));

        int score = 0;

        // Quiz loop
        System.out.println("=== Welcome to the Quiz App ===\n");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": ");
            q.displayQuestion();
            System.out.print("Your answer (1-4): ");
            int ans = sc.nextInt();

            if (q.checkAnswer(ans)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong!\n");
            }
        }

        // Final score
        System.out.println("=== Quiz Over ===");
        System.out.println("Your Score: " + score + "/" + questions.size());
        if (score == questions.size()) {
            System.out.println("🎉 Excellent! Perfect Score!");
        } else if (score >= questions.size() / 2) {
            System.out.println("👍 Good Job!");
        } else {
            System.out.println("📖 Keep Practicing!");
        }

        sc.close();
    }
}
