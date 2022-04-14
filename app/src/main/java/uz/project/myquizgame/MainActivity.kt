package uz.project.myquizgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import uz.project.myquizgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btn = findViewById<Button>(R.id.btn_next)
        btn.setOnClickListener {
            if (binding.editText.text.isNullOrEmpty()){
                binding.filledTextField.error = "Please enter name"
            }else{
                val intent = Intent(this, QuizActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}