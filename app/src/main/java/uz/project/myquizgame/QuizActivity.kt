package uz.project.myquizgame

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import uz.project.myquizgame.databinding.ActivityQuizBinding
import java.lang.Boolean.FALSE


class QuizActivity : AppCompatActivity() {

    var mCountDownTimer: CountDownTimer? = null
    var i = 0
    var mCurrentQuestion = 1
    private lateinit var binding: ActivityQuizBinding

    private val maxNumberOfQuestion = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDefaultDialog()



        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnSubmit.setOnClickListener {
            mCurrentQuestion++
            mCountDownTimer?.start()
        }
        binding.maxNumber.text = maxNumberOfQuestion.toString()


    }
    private fun showDefaultDialog() {
        val alertDialog = AlertDialog.Builder(this)

        alertDialog.apply {
            setTitle("Note")
            setMessage("If you are ready click OK\n")
            setPositiveButton("OK") { _, _ ->

                //progress bar animate code
                binding.progressbar.progress = i
                mCountDownTimer = object : CountDownTimer(10000, 50) {
                    override fun onTick(millisUntilFinished: Long) {
                        i++
                        binding.progressbar.progress = 100 - (i * 100 / (10000 / 50))
                    }

                    override fun onFinish() {

                        if (mCurrentQuestion == maxNumberOfQuestion) {
                            binding.currentNumber.text = maxNumberOfQuestion.toString()
                            val intent = Intent(this@QuizActivity, ResultActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        mCurrentQuestion++
                        binding.currentNumber.text = mCurrentQuestion.toString()
                        binding.progressbar.progress = 100
                        i = 0
                        mCountDownTimer?.start()
                    }
                }
                mCountDownTimer?.start()
            }
            setNeutralButton("Cancel") { _, _ ->
                finish()
            }
        }.create().show()
    }
}



