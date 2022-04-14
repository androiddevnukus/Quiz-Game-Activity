package uz.project.myquizgame

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import uz.project.myquizgame.databinding.ActivityQuizBinding


class QuizActivity : AppCompatActivity() {

    var mCountDownTimer: CountDownTimer? = null
    var i = 0
    var mCurrentQuestion = 1
    private lateinit var binding: ActivityQuizBinding
    var questions = Constants.getQuestions()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDefaultDialog()
        changeQuestion(mCurrentQuestion - 1)


        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnSubmit.setOnClickListener {
            mCountDownTimer?.cancel()
            mCurrentQuestion++
            changeQuestion(mCurrentQuestion - 1)
            binding.currentNumber.text = mCurrentQuestion.toString()
            binding.progressbar.progress = 0
            i = 0
            mCountDownTimer?.start()
        }
        binding.maxNumber.text = Constants.MAX_NUMBER_OF_QUESTION.toString()

        binding.progressbar.progress = i
        mCountDownTimer = object : CountDownTimer(10000, 10) {
            override fun onTick(millisUntilFinished: Long) {
                i++
                binding.progressbar.progress = 100 - (i * 100 / (10000 / 10))
                Log.v("TTTT", "OnTiCK")
            }

            override fun onFinish() {
                Log.v("TTTT", "$mCurrentQuestion")
                if (mCurrentQuestion == questions.size) {
                    val intent = Intent(this@QuizActivity,ResultActivity::class.java)
                    startActivity(intent)
                    finish()
                    binding.currentNumber.text = Constants.MAX_NUMBER_OF_QUESTION.toString()
                } else {
                    mCurrentQuestion++
                    changeQuestion(mCurrentQuestion - 1)
                    binding.currentNumber.text = mCurrentQuestion.toString()
                    binding.progressbar.progress = 0
                    i = 0
                    mCountDownTimer?.start()
                }
            }
        }


    }

    private fun showDefaultDialog() {
        val alertDialog = AlertDialog.Builder(this)

        alertDialog.apply {
            setTitle("Note")
            setMessage("If you are ready click OK\n")
            setPositiveButton("OK") { _, _ ->

                //progress bar animate code

                mCountDownTimer?.start()
            }
            setNeutralButton("Cancel") { _, _ ->
                finish()
            }
        }.create().show()
    }

    private fun changeQuestion(number: Int) {
        binding.nameOfCountry.text = questions[number].questionEng
        binding.btnOne.text = questions[number].optionOne
        binding.btnTwo.text = questions[number].optionTwo
        binding.btnThree.text = questions[number].optionThree
        binding.btnFour.text = questions[number].optionFour
    }


    private fun changeBack(id: Int){

        binding.apply {

        }

    }
}



