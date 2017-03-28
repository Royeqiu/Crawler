package websiteProcess;

import java.util.*;

/**
 * Created by roye on 2017/3/27.
 */
public class urlTable {

    private Set<String> visitedUrlSet;
    private ArrayList<String> nextUrlSet;

    public urlTable()
    {
        visitedUrlSet=new HashSet<String>();
        nextUrlSet=new ArrayList<String>();
    }

    public Set<String> getVisitedUrlSet()
    {
        return visitedUrlSet;
    }
    public ArrayList<String> getNextUrlSet()
    {
        return nextUrlSet;
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
        if(!visitedUrlSet.contains(nextUrl))
        {
            nextUrlSet.add(nextUrl);
        }
    }
}
