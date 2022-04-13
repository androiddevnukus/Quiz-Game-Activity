package uz.project.myquizgame

data class Question(
    val id: Int,
    val questionEng: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)