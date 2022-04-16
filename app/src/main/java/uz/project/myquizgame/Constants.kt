package uz.project.myquizgame


object Constants {


    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val MAX_NUMBER_OF_QUESTION = 5

    fun getQuestions(): MutableList<Question> {
        val questionsList = mutableListOf<Question>()

        // 1
        val que1 = Question(
            1,
            "Nicaragua",
            "Managua", "Sao Tome",
            "N'Djamena", "Saint John's", 1
        )
        questionsList.add(que1)

        // 2
        val que2 = Question(
            2,
            "Peru ?" ,
            "Palikir", "P'yongyang",
            "Lima", "Madrid", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3,
            "Indonesia ?",
            "Maputo", "Ankara",
            "Jakarta", "Minsk", 3
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4,
            "The Bahamas ?",
            "Cairo", "Nassau",
            "Copenhagen", "Bairiko", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5,
            "Portugal ?",
            "Lisbon", "Ottawa",
            "Buenos Aires", "Madrid", 1
        )

        questionsList.add(que5)

        // 5
        val que6 = Question(
            6,
            "Costa Rica ?",
            "San Jose", "Funafuti",
            "Georgetown", "Thimphu", 1
        )

        questionsList.add(que6)

        // 5
        val que7 = Question(
            7,
            "France ?",
            "New Delhi", "Paris",
            "Castries", "Libreville", 2
        )

        questionsList.add(que7)

        // 5
        val que8 = Question(
            8,
            "Germany ?",
            "Berlin", "Port-au-Prince",
            "Yaren district", "Athens", 1
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9,
            "Haiti ?",
            "Wellington", "Port-au-Prince",
            "Havana", "Lima", 2
        )

        questionsList.add(que9)


        // 10
        val que10 = Question(
            10,
            "Spain ?",
            "San Marino", "Bucharest",
            "Dushanbe", "Madrid", 4
        )

        questionsList.add(que10)




        return questionsList
    }


}