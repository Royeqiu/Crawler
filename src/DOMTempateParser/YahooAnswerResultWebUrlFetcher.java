package DOMTempateParser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by roye on 2017/3/28.
 */
public class YahooAnswerResultWebUrlFetcher extends BasicSearcgEngineResultUrlFetcher {

    private Elements searchResultElements;
    @Override
    public ArrayList<String> parseSearchEngineResult() {
        ArrayList<String> searchEngineUrlResult=new ArrayList<String>();
        searchResultElements = searchEngineResult.select("div#main").select("h3").select("a.lh-17.fz-m");
        for (Element singleResultElement : searchResultElements) {
            String singleResultUrl=singleResultElement.absUrl("href");
            searchEngineUrlResult.add(singleResultUrl);
        }

        return searchEngineUrlResult;
    }
}
