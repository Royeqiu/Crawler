package DOMTempateParser;

import model.WebPageContent;
import model.YahooAnswerContent;
import org.jsoup.nodes.Element;
import websiteProcess.UrlTableController;

/**
 * Created by roye on 2017/3/28.
 */
public class YahooAnswerDomParser extends BasicDomParser implements Runnable {

    private int id;
    public YahooAnswerDomParser(UrlTableController urlTableController,int id)
    {
        super(urlTableController);
        this.id=id;

    }
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

    @Override
    public void run() {
        int fileId=0;
        while(true)
        {

            System.out.println(urlTableController.getUrlTable().getNextUrlSet().size());
            if(!urlTableController.getUrlTable().getNextUrlSet().isEmpty())
            {
                getWebContent(urlTableController.getNextUrl());
                webPageFileWriter.setWebContent(parseWebContent());
                webPageFileWriter.writeWebPage(id+"/"+fileId+++"",0);
                System.out.println(id+":"+fileId);
            }

        }

    }
}
