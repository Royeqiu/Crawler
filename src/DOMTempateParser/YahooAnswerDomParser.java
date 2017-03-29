package DOMTempateParser;

import model.WebPageContent;
import model.YahooAnswerContent;
import org.jsoup.nodes.Element;

/**
 * Created by roye on 2017/3/28.
 */
public class YahooAnswerDomParser extends BasicDomParser {


    @Override
    public WebPageContent parseWebContent()
    {
        YahooAnswerContent webPageContet=new YahooAnswerContent();

        Element questTitleElement = webContent.select("h1.Fz-24.Fw-300.Mb-10").first();
        String questionTitle = questTitleElement.text();
        webPageContet.setTitle(questionTitle);

        Element questionTextElement = webContent.select("span.ya-q-text").first();
        String questionText=questionTextElement.text();
        webPageContet.setContent(questionText);

        Element bestAnswerTextElemnt=webContent.select("span.ya-q-full-text").first();
        String bestAnswerText=bestAnswerTextElemnt.text();
        webPageContet.setBestAnswer(bestAnswerText);

        return webPageContet;
    }
}
