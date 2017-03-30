package websiteProcess;

import java.util.*;

/**
 * Created by roye on 2017/3/27.
 */
public class UrlTable {

    private Set<String> visitedSearchEnginePageUrlSet;
    private ArrayList<String> nextSearchEnginePageUrlSet;
    private Set<String> visitedUrlSet;
    private ArrayList<String> nextUrlSet;

    public UrlTable()
    {
        visitedUrlSet=new HashSet<String>();
        nextUrlSet=new ArrayList<String>();
        visitedSearchEnginePageUrlSet =new HashSet<String>();
        nextSearchEnginePageUrlSet =new ArrayList<String>();
    }

    public Set<String> getVisitedUrlSet()
    {
        return visitedUrlSet;
    }
    public ArrayList<String> getNextUrlSet()
    {
        return nextUrlSet;
    }

    public Set<String> getVisitedSearchEnginePageUrlSet()
    {
        return visitedSearchEnginePageUrlSet;
    }
    public ArrayList<String> getNextSearchEnginePageUrlSet()
    {
        return nextSearchEnginePageUrlSet;
    }
    public String getFirstNextSearchEngineUrl()
    {
        if(!nextSearchEnginePageUrlSet.isEmpty())
        {
            return nextSearchEnginePageUrlSet.get(0);
        }
        else return null;
    }
    public void removeFirstNextSearchEngineUrl()
    {
        if(!nextSearchEnginePageUrlSet.isEmpty())
        {
            nextSearchEnginePageUrlSet.remove(0);
        }
        else return;
    }
    public String getFirstNextUrl()
    {
        if(!nextUrlSet.isEmpty())
        {
            return nextUrlSet.get(0);
        }
        else return null;
    }
    public void removeFirstNextUrl()
    {
        if(!nextUrlSet.isEmpty())
        {
            nextUrlSet.remove(0);
        }
        else return;
    }
    public void addNextUrl(String nextUrl)
    {
        if(!visitedUrlSet.contains(nextUrl)&&!nextUrlSet.contains(nextUrl))
        {
            nextUrlSet.add(nextUrl);
        }
    }
    public void addNextSearchEnginePageUrl(String nextSearchEnginePageUrl)
    {
        if(!visitedSearchEnginePageUrlSet.contains(nextSearchEnginePageUrl)&&!nextSearchEnginePageUrlSet.contains(nextSearchEnginePageUrl))
        {
            nextSearchEnginePageUrlSet.add(nextSearchEnginePageUrl);

        }
    }
    public void addVisitedUrl(String visitedUrl)
    {
        visitedUrlSet.add(visitedUrl);
    }
    public void addVisitedSearchEngineUrl(String visitedSearchEngineUrl)
    {
        visitedSearchEnginePageUrlSet.add(visitedSearchEngineUrl);
    }
}
