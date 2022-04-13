package uz.project.myquizgame


object Constants {

    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestionsLevel1(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1,
            "...... many stars in the sky.",
            "Are there", "Is there",
            "There is", "There are", 4
        )
        questionsList.add(que1)

        // 2
        val que2 = Question(
            2,
            "..... an aquarium in the room. ",
            "Are there", "There is ",
            "There are", "Is there", 2
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3,
            "...... any frogs around the pond.",
            "There are", "There is",
            "Are there", "There aren't", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4,
            "...... any sugar?",
            "Is there", "Are there",
            "There isn't", "There is", 1
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5,
            "...... any snow.",
            "Is there", "There isn't",
            "Are there", "There aren't", 2
        )

        questionsList.add(que5)

        return questionsList
    }


}