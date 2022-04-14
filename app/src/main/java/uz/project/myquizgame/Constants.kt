package uz.project.myquizgame


object Constants {

    const val MAX_NUMBER_OF_QUESTION = 5

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1,
            "USA ?",
            "St.Peterburg", "Moscow",
            "Tashkent", "Peter", 4
        )
        questionsList.add(que1)

        // 2
        val que2 = Question(
            2,
            "Russia ?" ,
            "St.Peterburg", "Moscow",
            "English", "Peter", 2
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3,
            "Uzbekistan ?",
            "Avropa", "Samarqand",
            "Xorezm", "Tashkent", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4,
            "Kazakhstan ?",
            "Nursultan", "Astana",
            "Nukus", "Almati", 1
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5,
            "Tajikistan ?",
            "StStst", "Xojeli",
            "Indonezia", "Turkmenistan", 2
        )

        questionsList.add(que5)

        return questionsList
    }


}