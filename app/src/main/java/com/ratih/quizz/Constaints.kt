package com.ratih.quizz

object Constaints {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answer"

    fun getQuestion(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val  que1 = Question(
            1,
            "Rumah Gadang adalah rumah adat Provinsi?",
             R.drawable.sumbar,
            "Sumatra Selatan",
            "Sumatra Barat",
            "Kalimantan Barat",
            "Sulawesi Selatan",
            2
        )
        questionList.add(que1)

        val  que2 = Question(
            2,
            "Rumah Selaso Jatuh Kembar adalah rumah adat provinsi?",
            R.drawable.img_riau,
            "Lampung",
            "NTT",
            "NTB",
            "Riau",
            4
        )
        questionList.add(que2)

        val  que3 = Question(
            3,
            "Nama Rumah Adat dibawah ini Adalah?",
            R.drawable.sasadu,
            "Honai",
            "Sasadu",
            "Tongkonan",
            "Betang",
            2
        )
        questionList.add(que3)
        val  que4 = Question(
            4,
            "Nama Rumah Adat dibawah ini Adalah?",
            R.drawable.kajangleko,
            "Limas",
            "Dalam Loka",
            "Betang",
            "Kajang Leko",
            4
        )
        questionList.add(que4)

        val  que5 = Question(
            5,
            "Rumah Adat Loka berasal dari Provinsi?",
            R.drawable.img_loka,
            "Sulawesi Selatan",
            "Aceh",
            "Kalimantan Barat",
            "Kalimantan Timur",
            3
        )

        questionList.add(que5)

        return questionList

    }
}