package uz.project.myquizgame

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import uz.project.myquizgame.databinding.ActivityQuizBinding


class QuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: MutableList<Question>? = null
    private lateinit var binding: ActivityQuizBinding
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    //for progressbar
    private var i = 0
    var mCountDownTimer: CountDownTimer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mQuestionsList = Constants.getQuestions()
        mQuestionsList?.shuffle()
        setQuestion()

        binding.maxNumber.text = mQuestionsList!!.size.toString()
        //progressbar animate
        binding.progressbar.progress = i
        mCountDownTimer = object : CountDownTimer(15000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                i++
                binding.timerTv.text = i.toString()
                binding.progressbar.progress = 100 - (i * 100 / (15000 / 1000))
            }

            override fun onFinish() {
                submitFunc()
                binding.progressbar.progress = 100
                mCountDownTimer?.start()
            }
        }


        //alertdialog
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Note")
        builder.setMessage("If you are ready click OK button")
        builder.setPositiveButton("Yes") { dialog, which ->
            mCountDownTimer?.start()
        }

        builder.setNeutralButton("No") { dialog, which ->
            finish()
        }
        builder.show()

        binding.btnBack.setOnClickListener {
            finish()
        }


        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
    }

    //Function when you can not click button after answer or can
    private fun setClickable(bool: Boolean) {
        binding.tvOptionOne.isClickable = bool
        binding.tvOptionTwo.isClickable = bool
        binding.tvOptionThree.isClickable = bool
        binding.tvOptionFour.isClickable = bool
    }

    override fun onClick(v: View?) {
        //added recently
        setClickable(false)

        mCountDownTimer?.cancel()

        //added
        if (mCurrentPosition == mQuestionsList!!.size) {
            binding.btnSubmit.text = "Finish"
        } else {
            binding.btnSubmit.text = "Next"
        }


        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(binding.tvOptionOne, 1)
                myFunc()
            }
            R.id.tv_option_two -> {
                selectedOptionView(binding.tvOptionTwo, 2)
                myFunc()
            }
            R.id.tv_option_three -> {
                selectedOptionView(binding.tvOptionThree, 3)
                myFunc()
            }
            R.id.tv_option_four -> {
                selectedOptionView(binding.tvOptionFour, 4)
                myFunc()
            }
            R.id.btn_submit -> {
                mCountDownTimer?.start()
                submitFunc()
            }
        }
    }

    private fun submitFunc() {
        i = 0
        mCurrentPosition++
        binding.currentNumber.text = mCurrentPosition.toString()
        when {
            mCurrentPosition <= mQuestionsList!!.size -> {
                setQuestion()
            }
            else -> {
                val name = intent.getStringExtra("name")
                val intent =
                    Intent(this, ResultActivity::class.java)
                intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                intent.putExtra("nameperson", name)
                intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                startActivity(intent)
                mCountDownTimer?.cancel()
                finish()
            }
        }
    }

    private fun myFunc() {
        val question = mQuestionsList?.get(mCurrentPosition - 1)

        if (question!!.correctAnswer != mSelectedOptionPosition) {
            answerView(mSelectedOptionPosition, R.drawable.wrong_answer)
        } else {
            mCorrectAnswers++
        }

        answerView(question.correctAnswer, R.drawable.correct_answer)

        if (mCurrentPosition == mQuestionsList!!.size) {
            binding.btnSubmit.text = "Finish"
        } else {
            binding.btnSubmit.text = "Next"
        }

        mSelectedOptionPosition = 0

    }


    private fun setQuestion() {
        setClickable(true)


        val question =
            mQuestionsList!![mCurrentPosition - 1]
        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            binding.btnSubmit.text = "Finish"
        } else {
            binding.btnSubmit.text = "Next"
        }

        binding.nameOfCountry.text = question.question
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#FFFFFF")
        )
    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)

        for (option in options) {
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_btn
            )
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                binding.tvOptionOne.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                binding.tvOptionTwo.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                binding.tvOptionThree.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                binding.tvOptionFour.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}
