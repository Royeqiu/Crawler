package DOMTempateParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import websiteProcess.UrlTableController;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by roye on 2017/3/28.
 */
abstract public class BasicSearcgEngineResultUrlFetcher implements Runnable{
    protected Document searchEngineResult;
    protected String initUrl;
    protected UrlTableController urlTableController;
    public BasicSearcgEngineResultUrlFetcher(String initUrl,UrlTableController urlTableController)
    {
        this.urlTableController=urlTableController;
        this.initUrl=initUrl;
    }
    public void getSearchEngineResult(String searchEngineUrl)
    {
        try {
            searchEngineResult= Jsoup.connect(searchEngineUrl)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("http://www.google.com")
                    .timeout(5000)
                    .get();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    abstract public ArrayList<String> parseSearchEngineResult();
    abstract public ArrayList<String> parseNextSearchEngineResultPage();
}
