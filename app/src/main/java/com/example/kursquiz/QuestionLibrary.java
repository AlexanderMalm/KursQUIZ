package com.example.kursquiz;

public final class QuestionLibrary {

    //Manuellt inmatade frågor, svarsalternativ och korrekt svar.
    Question q1 = new Question( "Vilken av följande innebär överföring med tidsmultiplexering?", new String[]{"FDM",
            "TDM", "WDM", "SDM"}, 2);

    Question q2 = new Question( "Djikstra's algoritm är en vägvalsalgoritm inom vilken kategori:", new String[]{"Link state",
            "OSPF", "distance vector", "Hot potato-routing"}, 1);

    Question q3 = new Question( "Vad kan hidden terminal-problem leda till", new String[]{"Dålig modulering",
            "Fel wifi-protokoll används", "Krockar under dataöverföring", "Finns inget som kallas så"}, 3);

    Question q4 = new Question( "Hur många bitar lång är en IPv4-address?", new String[]{"20 bitar",
            "4 bitar", "72 bitar", "32 bitar"}, 4);
    Question[] all = new Question[] {q1, q2, q3, q4};

public Question[] getQuestions(){
    return all;
}

}
