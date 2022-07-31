package com.f.mygithub.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class EditHtml {
    private String html;
    private Document document;

    public EditHtml(String html){
        this.html = html;
        document = Jsoup.parse(html);
    }

    public void setTitle(String newData){
        document.select("i").get(0).text("");
        document.select("i").get(0).prepend(newData);
    }

    public void setHeading(String newData){
        document.select("i").get(1).text("");
        document.select("i").get(1).prepend(newData);
    }

    public void setBody(String newData){
        document.select("i").get(2).text("");
        document.select("i").get(2).prepend(newData);
    }

    public void setLower(String newData){
        document.select("i").get(3).text("");
        document.select("i").get(3).prepend(newData);
    }


    public String getTitle(){
       return document.select("i").get(0).text();
    }

    public String getHeading(){
        return document.select("i").get(1).text();
    }

    public String getBody(){
        return document.select("i").get(2).text();
    }

    public String getLower(){
        return document.select("i").get(3).text();
    }

    public String getHtml(){
        return document.html();
    }


}
