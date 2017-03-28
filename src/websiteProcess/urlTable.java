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

    public void addNextUrl(String nextUrl)
    {
        nextUrlSet.add(nextUrl);
    }
}
