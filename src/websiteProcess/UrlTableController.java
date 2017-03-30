package websiteProcess;

import java.util.ArrayList;

/**
 * Created by roye on 2017/3/27.
 */
public class UrlTableController {
    private UrlTable UrlTable;

    public UrlTableController(UrlTable UrlTable)
    {
        this.UrlTable = UrlTable;
    }
    public UrlTable getUrlTable()
    {
        return UrlTable;
    }


    public void addNextUrlIntoUrlTable(ArrayList<String> nextUrlSet)
    {
        if(UrlTable ==null)
        {
            UrlTable =new UrlTable();
        }
        for(String nextUrl:nextUrlSet)
        {
            UrlTable.addNextUrl(nextUrl);
        }
    }
    public void addNextSearchEnginePageUrlIntoUrlTable(ArrayList<String> nextSearchEnginePageUrlSet)
    {
        for(String nextSearchEnginePageUrl:nextSearchEnginePageUrlSet)
        {
            UrlTable.addNextSearchEnginePageUrl(nextSearchEnginePageUrl);
        }
    }
    synchronized public String getNextSearchEnginePageUrl()
    {
        String nextSearchEnginePageUrl= UrlTable.getFirstNextSearchEngineUrl();
        UrlTable.removeFirstNextSearchEngineUrl();
        return nextSearchEnginePageUrl;
    }
    synchronized public String getNextUrl()
    {
        String nextUrl= UrlTable.getFirstNextUrl();
        UrlTable.removeFirstNextUrl();
        return nextUrl;
    }
}
