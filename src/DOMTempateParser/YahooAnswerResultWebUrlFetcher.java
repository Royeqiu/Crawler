package DOMTempateParser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by roye on 2017/3/28.
 */
public class YahooAnswerResultWebUrlFetcher extends BasicSearcgEngineResultUrlFetcher {


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
}
