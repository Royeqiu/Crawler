package main;

import DOMTempateParser.BasicSearcgEngineResultUrlFetcher;
import DOMTempateParser.YahooAnswerResultWebUrlFetcher;
import websiteProcess.urlTable;
import websiteProcess.urlTableController;


public class multiThreadCrawler {

    static urlTableController urlTableController;

    public static void main(String[] args) {
        BasicSearcgEngineResultUrlFetcher urlFetcher= new YahooAnswerResultWebUrlFetcher();
        urlFetcher.getSearchEngineResult("https://answers.search.yahoo.com/search?b=11&p=wine");
        urlFetcher.parseSearchEngineResult();
        urlTable urlTable;

    }
}
