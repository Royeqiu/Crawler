package main;

import DOMTempateParser.BasicDomParser;
import DOMTempateParser.YahooAnswerDomParser;
import DOMTempateParser.YahooAnswerResultWebUrlFetcher;
import DOMTempateParser.httpUtil.HTTPCommonUtil;
import model.WebPageContent;
import websiteProcess.UrlTable;
import websiteProcess.UrlTableController;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class MultiThreadCrawler {

    static UrlTableController urlTableController;


    public static void main(String[] args) {
        HTTPCommonUtil.trustEveryone();
        Executor executor = Executors.newFixedThreadPool(8);

        urlTableController =new UrlTableController(new UrlTable());

        executor.execute(new YahooAnswerResultWebUrlFetcher("https://answers.search.yahoo.com/search?p=wine&b=11",urlTableController));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.execute(new YahooAnswerDomParser(urlTableController,1));
        executor.execute(new YahooAnswerDomParser(urlTableController,2));
        executor.execute(new YahooAnswerDomParser(urlTableController,3));
        executor.execute(new YahooAnswerDomParser(urlTableController,4));
        executor.execute(new YahooAnswerDomParser(urlTableController,5));
        executor.execute(new YahooAnswerDomParser(urlTableController,6));

    }

}
