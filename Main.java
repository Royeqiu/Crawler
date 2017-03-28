package main;

import DOMTempateParser.BasicSearcgEngineResultUrlFetcher;
import DOMTempateParser.YahooAnswerResultWebUrlFetcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import websiteProcess.urlTable;

import java.io.IOException;


public class Main {
    static urlTable urlTable;
    public static void main(String[] args) {
        BasicSearcgEngineResultUrlFetcher urlFetcher= new YahooAnswerResultWebUrlFetcher();
        urlFetcher.getSearchEngineResult("https://answers.search.yahoo.com/search?b=11&p=wine");
        urlFetcher.parseSearchEngineResult();
    }
}
