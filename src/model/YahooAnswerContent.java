package model;

/**
 * Created by roye on 2017/3/29.
 */
public class YahooAnswerContent extends WebPageContent {
    public String getBestAnswer() {
        return bestAnswer;
    }

    public void setBestAnswer(String bestAnswer) {
        this.bestAnswer = bestAnswer;
    }

    private String bestAnswer;

}
