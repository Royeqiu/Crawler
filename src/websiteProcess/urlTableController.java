package websiteProcess;

import DOMTempateParser.BasicDomParser;

import java.util.ArrayList;

/**
 * Created by roye on 2017/3/27.
 */
public class urlTableController {
    private urlTable urlTable;

    public urlTable getUrlTable()
    {
        return urlTable;
    }

    public void setUrlTable(urlTable urlTable)
    {
        this.urlTable = urlTable;
    }

    public void addNextUrlIntoUrlTable(ArrayList<String> nextUrlSet)
    {
        if(urlTable==null)
        {
            urlTable=new urlTable();
        }
        for(String nextUrl:nextUrlSet)
        {
            urlTable.addNextUrl(nextUrl);
        }
    }
    public String getNextUrl()
    {
        String nextUrl=urlTable.getFirstNextUrl();
        urlTable.removeFirstNextUrl();
        return nextUrl;
    }
}
