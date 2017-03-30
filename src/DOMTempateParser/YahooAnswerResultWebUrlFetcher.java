package DOMTempateParser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import websiteProcess.UrlTableController;

import java.util.ArrayList;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

/**
 * Created by roye on 2017/3/28.
 */
public class YahooAnswerResultWebUrlFetcher extends BasicSearcgEngineResultUrlFetcher implements Runnable{



    public YahooAnswerResultWebUrlFetcher(String initUrl, UrlTableController urlTableController)
    {
        super(initUrl,urlTableController);

    }
    @Override
    public ArrayList<String> parseSearchEngineResult() {
        Elements searchResultElements;
        ArrayList<String> searchEngineUrlResult=new ArrayList<String>();
        searchResultElements = searchEngineResult.select("div#main").select("h3").select("a.lh-17.fz-m");
        for (Element singleResultElement : searchResultElements) {
            String singleResultUrl=singleResultElement.absUrl("href");
            searchEngineUrlResult.add(singleResultUrl);
        }

        return searchEngineUrlResult;
    }

    @Override
    public ArrayList<String> parseNextSearchEngineResultPage() {
        Elements searchResultElements;
        ArrayList<String> nextSearchEngineUrlResultPage=new ArrayList<String>();
        searchResultElements = searchEngineResult.select("ol.reg.searchBottom").select("a");
        for (Element singleResultElement : searchResultElements) {
            if(singleResultElement.hasClass("prev")||singleResultElement.hasClass("next"))
            {
              // we don't need get previous page and next page button url.
            }
            else
            {
                String singleResultUrl=singleResultElement.absUrl("href");
                nextSearchEngineUrlResultPage.add(singleResultUrl);
            }

        }
        return nextSearchEngineUrlResultPage;
    }

    @Override
    public void run() {

        getSearchEngineResult(initUrl);
        urlTableController.addNextSearchEnginePageUrlIntoUrlTable(parseNextSearchEngineResultPage());
        urlTableController.addNextUrlIntoUrlTable(parseSearchEngineResult());
        System.out.println("UrlFetcher is ready!");
        while(true)
        {
            if(!urlTableController.getUrlTable().getNextSearchEnginePageUrlSet().isEmpty())
            {
                getSearchEngineResult(urlTableController.getNextSearchEnginePageUrl());
                urlTableController.addNextSearchEnginePageUrlIntoUrlTable(parseNextSearchEngineResultPage());
                urlTableController.addNextUrlIntoUrlTable(parseSearchEngineResult());
            }

        }


    }
}
