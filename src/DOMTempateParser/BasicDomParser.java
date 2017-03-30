package DOMTempateParser;

import model.WebPageContent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import websiteProcess.UrlTableController;
import websiteProcess.WebPageFileWriter;

import java.io.IOException;

/**
 * Created by roye on 2017/3/27.
 */
abstract public class BasicDomParser implements Runnable{
    protected Document webContent;
    protected WebPageFileWriter webPageFileWriter;
    protected UrlTableController urlTableController;
    public BasicDomParser(UrlTableController urlTableController)
    {
        this.urlTableController=urlTableController;
        webPageFileWriter=new WebPageFileWriter();
    }
    public void getWebContent(String Url) {
        try {
            webContent= Jsoup.connect(Url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("http://www.google.com")
                    .timeout(5000)
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public abstract WebPageContent parseWebContent();
}
