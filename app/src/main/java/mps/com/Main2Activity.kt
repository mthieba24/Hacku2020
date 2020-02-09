package mps.com

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    var quizes = ArrayList<Quiz>()
    var numberOfGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        quizes.add(Quiz( question = "Do you often take care of your personal health? i.e. brush your teeth, take a shower/bath, eat food, drink water etc....", answer1 = "Yes Daily", answer2 = "Most Days", answer3 = "Not Often", correctAnswerNumber = 1))

        quizes.add(Quiz( question = "How many times have you focused on your thoughts today?", answer1 = "About 3-4", answer2 = "At Least 5", answer3 = "I didn't really", correctAnswerNumber = 2))

        quizes.add(Quiz( question = "How much sleep did you get last night", answer1 = "Around 2-4", answer2 = "Around 4-6", answer3 = "Above 6", correctAnswerNumber = 3))

        quizes.add(Quiz( question = "Do you sleep with your phone by you?", answer1 = "Yes", answer2 = "No", answer3 = "I need to for my alarm", correctAnswerNumber = 2))

        quizes.add(Quiz( question = "How much water are you drinking everyday?", answer1 = "More than enough", answer2 = "Enough I think", answer3 = "Not Often", correctAnswerNumber = 1))

        quizes.add(Quiz( question = "Around how many minutes of aerobic exercise do you get a week", answer1 = "Around 10-25", answer2 = "Around 25-40", answer3 = "More than 40", correctAnswerNumber = 3))

        quizes.add(Quiz( question = "How many times to you eat fruits & vegetables a week", answer1 = "Around once or twice", answer2 = "Around 3-4", answer3 = "Almost daily", correctAnswerNumber = 3))

        quizes.add(Quiz( question = "Do you often compare yourself to others instead of just being yourself?", answer1 = "Yes", answer2 = "No", answer3 = "Sometimes", correctAnswerNumber = 2))

        quizes.add(Quiz( question = "Do write down, recite, or read your goals everyday?", answer1 = "Yes", answer2 = "No", answer3 = "Sometimes", correctAnswerNumber = 1 or  2))

        quizes.add(Quiz( question = "How many days a week do you study for classes?", answer1 = "About 1-2", answer2 = "About 2-3", answer3 = "More than 3", correctAnswerNumber = 2 or  3))

        showQuestion(quizes.get(currentQuizIndex))


    }

    fun handleAnswer(answerID: Int){
        val quiz = quizes.get(currentQuizIndex)

        if (quiz.isCorrect(answerID)) {
            numberOfGoodAnswers++
            Toast.makeText( this, "+5", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText( this, "+0", Toast.LENGTH_SHORT).show()

        }
        currentQuizIndex++

        if (currentQuizIndex >= quizes.size) {
            var alert = AlertDialog.Builder( this)
            alert.setTitle("Quiz is Done")
            alert.setMessage("You scored " + numberOfGoodAnswers + " points")
            if (numberOfGoodAnswers >=25 ){
                alert.setMessage("You have room for self improvement, keep the good habits and build better ones")
            }
            else{
                alert.setMessage("You need to build better habits ASAP! It will tremendously help in college, talk to your peers and family for advice and seek resources around campus.")
            }
            alert.setPositiveButton("Ok"){ dialog: DialogInterface?, which: Int ->
                finish()
                
            }

            alert.show()
        } else {
            showQuestion(quizes.get(currentQuizIndex))
        }

    }
    fun showQuestion(quiz: Quiz){
        txtQuestion.setText(quiz.question)
        answer1.setText(quiz.answer1)
        answer2.setText(quiz.answer2)
        answer3.setText(quiz.answer3)
    }

    fun onClickAnswerOne(view: View){
        handleAnswer(1)


    }

    fun onClickAnswerTwo(view: View){
        handleAnswer(2)

    }

    fun onClickAnswerThree(view: View){
        handleAnswer(3)

    }
}
