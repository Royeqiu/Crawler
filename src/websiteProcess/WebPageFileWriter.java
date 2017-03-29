package websiteProcess;

import model.WebPageContent;
import model.YahooAnswerContent;
import util.IOManager;

/**
 * Created by roye on 2017/3/27.
 */
public class WebPageFileWriter {
    IOManager io;
    WebPageContent webContent;
    public WebPageFileWriter()
    {
        io=new IOManager();
    }
    public void setWebContent(WebPageContent webContent)
    {
        this.webContent=webContent;
    }
    public void writeWebPage(String fileName,int type)
    {
        io.setwritepath("page/"+fileName,true);
        if(type==0)
        {
            YahooAnswerContent webContent=(YahooAnswerContent) this.webContent;
            io.writeLine(webContent.getTitle());
            io.writeLine(webContent.getContent());
            io.writeLine(webContent.getBestAnswer());
        }

    }
}
