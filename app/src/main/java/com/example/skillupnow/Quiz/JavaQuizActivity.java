package com.example.skillupnow.Quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.skillupnow.R;

public class JavaQuizActivity extends AppCompatActivity {

    Toolbar toolbar;
    private TextView questionText, scoreText;
    private RadioGroup answersGroup;
    private RadioButton answer1, answer2, answer3, answer4;
    private Button nextButton;
    private ImageView hintButton;

    private int currentQuestionIndex = 0;
    private int score = 0;
    private final int TOTAL_QUESTIONS = 10; // Total number of questions
    private final int PASS_SCORE = 5; // Minimum score to pass, adjusted for 10 questions
    private final int MAX_HINTS = 3; // Maximum number of hints allowed

    private boolean[] hintsShown;
    private int hintsUsed = 0;

    private Question[] questions = new Question[]{
            new Question("Which keyword is used to define a class in Java?", "class", "public", "void", "static", "class", "It's the same word as the term for a group of students."),
            new Question("Which method is the entry point for a Java application?", "start()", "init()", "main()", "run()", "main()", "It's a method that every Java application must have."),
            new Question("Which operator is used to compare two values for equality?", "==", "=", "===", "!=", "==", "It's a double equals sign."),
            new Question("What is the superclass of all classes in Java?", "Object", "Class", "System", "Root", "Object", "All classes in Java inherit from this class."),
            new Question("Which keyword is used to inherit a class in Java?", "extends", "implements", "inherits", "super", "extends", "It's the keyword used for class inheritance."),
            new Question("Which keyword is used to declare an interface in Java?", "interface", "abstract", "implements", "extends", "interface", "It's also used in the context of user interfaces."),
            new Question("Which keyword is used to create an instance of a class?", "new", "create", "make", "instance", "new", "This keyword is followed by the class constructor."),
            new Question("Which exception is thrown when a method tries to access a null object?", "NullPointerException", "IOException", "ArrayIndexOutOfBoundsException", "ClassNotFoundException", "NullPointerException", "It's thrown when dereferencing a null reference."),
            new Question("Which data type is used to store true/false values in Java?", "boolean", "int", "char", "String", "boolean", "This data type has only two possible values."),
            new Question("Which loop is guaranteed to execute at least once?", "do-while", "while", "for", "foreach", "do-while", "This loop checks the condition after executing the loop body.")
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        questionText = findViewById(R.id.question_text);
        answersGroup = findViewById(R.id.answers_group);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        nextButton = findViewById(R.id.next_button);
        hintButton = findViewById(R.id.hint);
        scoreText = findViewById(R.id.score_text);
        /*toolbar = findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JavaQuizActivity.this,QuizActivity.class);
                startActivity(intent);
            }
        });*/

        hintsShown = new boolean[TOTAL_QUESTIONS];

        loadQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < TOTAL_QUESTIONS) {
                    loadQuestion();
                } else {
                    showResultDialog();
                }
            }
        });

        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHint();
            }
        });
    }

    private void loadQuestion() {
        Question currentQuestion = questions[currentQuestionIndex];
        String questionWithIndex = "Question " + (currentQuestionIndex + 1) + " out of " + TOTAL_QUESTIONS + ": " + currentQuestion.getQuestionText();
        questionText.setText(questionWithIndex);
        answer1.setText(currentQuestion.getOption1());
        answer2.setText(currentQuestion.getOption2());
        answer3.setText(currentQuestion.getOption3());
        answer4.setText(currentQuestion.getOption4());
        answersGroup.clearCheck();
    }

    private void checkAnswer() {
        int selectedId = answersGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedAnswer = findViewById(selectedId);
            String answerText = selectedAnswer.getText().toString();
            if (answerText.equals(questions[currentQuestionIndex].getCorrectAnswer())) {
                score++;
                scoreText.setText("Score: " + score);
            }
        }
    }

    private void showHint() {
        if (hintsUsed >= MAX_HINTS) {
            Toast.makeText(JavaQuizActivity.this, "You have used all your hints.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (hintsShown[currentQuestionIndex]) {
            Toast.makeText(JavaQuizActivity.this, "Hint already shown for this question", Toast.LENGTH_SHORT).show();
            return;
        }

        Question currentQuestion = questions[currentQuestionIndex];
        String hint = currentQuestion.getHint();

        AlertDialog.Builder builder = new AlertDialog.Builder(JavaQuizActivity.this);
        builder.setMessage(hint)
                .setTitle("Hint")
                .setIcon(R.drawable.lightbulb)
                .setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();

        hintsShown[currentQuestionIndex] = true;
        hintsUsed++;
    }

    private void showResultDialog() {
        // Create a dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaQuizActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_result, null);
        builder.setView(dialogView);

        TextView resultMessage = dialogView.findViewById(R.id.result_message);
        Button okButton = dialogView.findViewById(R.id.ok_button);

        if (score >= PASS_SCORE) {
            resultMessage.setText("Congratulations! You passed the quiz.");
        } else {
            resultMessage.setText("You failed the quiz. Try again!");
        }

        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                resetQuiz();
            }
        });
    }

    private void resetQuiz() {
        currentQuestionIndex = 0;
        score = 0;
        scoreText.setText("Score: " + score);
        hintsShown = new boolean[TOTAL_QUESTIONS]; // Reset the hints shown array
        hintsUsed = 0; // Reset the hint counter
        loadQuestion();
    }

    private static class Question {
        private String questionText;
        private String option1;
        private String option2;
        private String option3;
        private String option4;
        private String correctAnswer;
        private String hint;

        public Question(String questionText, String option1, String option2, String option3, String option4, String correctAnswer, String hint) {
            this.questionText = questionText;
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.option4 = option4;
            this.correctAnswer = correctAnswer;
            this.hint = hint;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String getOption1() {
            return option1;
        }

        public String getOption2() {
            return option2;
        }

        public String getOption3() {
            return option3;
        }

        public String getOption4() {
            return option4;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public String getHint() {
            return hint;
        }
    }
}
