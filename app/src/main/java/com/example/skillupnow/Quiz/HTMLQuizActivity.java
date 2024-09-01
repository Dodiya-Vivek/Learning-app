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

public class HTMLQuizActivity extends AppCompatActivity {

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

    private HTMLQuizActivity.Question[] questions = new HTMLQuizActivity.Question[]{
            new HTMLQuizActivity.Question("Which tag is used to define the largest heading in HTML?", "<h1>", "<title>", "<head>", "<h6>", "<h1>", "It's the tag for the main heading."),
            new HTMLQuizActivity.Question("Which attribute is used to provide an alternate text for an image in HTML?", "alt", "title", "src", "href", "alt", "It's an attribute that describes the image."),
            new HTMLQuizActivity.Question("Which tag is used to create a hyperlink in HTML?", "<a>", "<link>", "<href>", "<nav>", "<a>", "It's the anchor tag."),
            new HTMLQuizActivity.Question("What is the root element of an HTML document?", "<html>", "<body>", "<head>", "<title>", "<html>", "It's the top-level element in an HTML document."),
            new HTMLQuizActivity.Question("Which attribute specifies the destination URL of a hyperlink?", "href", "src", "link", "target", "href", "It's an attribute of the anchor tag."),
            new HTMLQuizActivity.Question("Which tag is used to include JavaScript code in an HTML document?", "<script>", "<style>", "<code>", "<js>", "<script>", "It's the tag that encloses JavaScript code."),
            new HTMLQuizActivity.Question("How do you create an ordered list in HTML?", "<ol>", "<ul>", "<li>", "<list>", "<ol>", "It's the tag for an ordered list."),
            new HTMLQuizActivity.Question("Which tag is used to create a table in HTML?", "<table>", "<tr>", "<td>", "<th>", "<table>", "It's the tag that defines a table."),
            new HTMLQuizActivity.Question("Which attribute is used to specify the path to an image in HTML?", "src", "href", "alt", "link", "src", "It's an attribute of the img tag."),
            new HTMLQuizActivity.Question("Which tag is used to create a line break in HTML?", "<br>", "<lb>", "<break>", "<newline>", "<br>", "It's the tag that creates a line break.")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_htmlquiz);
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
        HTMLQuizActivity.Question currentQuestion = questions[currentQuestionIndex];
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
            Toast.makeText(HTMLQuizActivity.this, "You have used all your hints.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (hintsShown[currentQuestionIndex]) {
            Toast.makeText(HTMLQuizActivity.this, "Hint already shown for this question", Toast.LENGTH_SHORT).show();
            return;
        }

        HTMLQuizActivity.Question currentQuestion = questions[currentQuestionIndex];
        String hint = currentQuestion.getHint();

        AlertDialog.Builder builder = new AlertDialog.Builder(HTMLQuizActivity.this);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(HTMLQuizActivity.this);
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
