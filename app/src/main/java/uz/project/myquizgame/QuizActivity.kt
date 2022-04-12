package uz.project.myquizgame

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import uz.project.myquizgame.databinding.ActivityQuizBinding


class QuizActivity : AppCompatActivity() {
    var mCountDownTimer: CountDownTimer? = null
    var i = 0
    private var CurrentQuestion = 1
    private lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val mProgressBar: ProgressBar = findViewById<View>(R.id.progressbar) as ProgressBar
        mProgressBar.progress = i
        mCountDownTimer= object : CountDownTimer(5000, 500) {
            override fun onTick(millisUntilFinished: Long) {
                Log.v("Log_tag", "Tick of Progress$i$millisUntilFinished")
                i++
                mProgressBar.progress = i * 100 / (5000 / 500)
            }

            override fun onFinish() {
                CurrentQuestion++
                binding.currentNumber.text = CurrentQuestion.toString()
                if (CurrentQuestion==5){
                    val intent = Intent(this@QuizActivity,ResultActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                mProgressBar.progress = 0
                i=0
                mCountDownTimer?.start()
            }
        }
        mCountDownTimer?.start()
    }
}