package main;

import DOMTempateParser.BasicDomParser;
import DOMTempateParser.BasicSearcgEngineResultUrlFetcher;
import DOMTempateParser.YahooAnswerDomParser;
import DOMTempateParser.YahooAnswerResultWebUrlFetcher;
import DOMTempateParser.httpUtil.HTTPCommonUtil;
import websiteProcess.UrlTable;
import websiteProcess.UrlTableController;
import websiteProcess.WebPageFileWriter;


public class MultiThreadCrawler {

    static UrlTableController urlTableController;
    static WebPageFileWriter webPageFileWriter;

    public static void main(String[] args) {
        HTTPCommonUtil.trustEveryone();
        webPageFileWriter =new WebPageFileWriter();
        urlTableController =new UrlTableController(new UrlTable());
        BasicSearcgEngineResultUrlFetcher urlFetcher= new YahooAnswerResultWebUrlFetcher();
        BasicDomParser webContentFetcher=new YahooAnswerDomParser();
        urlFetcher.getSearchEngineResult("https://answers.search.yahoo.com/search?p=wine&b=11");
        urlTableController.addNextUrlIntoUrlTable(urlFetcher.parseSearchEngineResult());
        System.out.println(urlTableController.getUrlTable().getFirstNextUrl());
        urlTableController.addNextSearchEnginePageUrlIntoUrlTable(urlFetcher.parseNextSearchEngineResultPage());
        //System.out.println(urlTableController.getUrlTable().getFirstNextSearchEngineUrl());
        webContentFetcher.getWebContent(urlTableController.getNextUrl());
        webPageFileWriter.setWebContent(webContentFetcher.parseWebContent());
        webPageFileWriter.writeWebPage("1",0);
    }

}
