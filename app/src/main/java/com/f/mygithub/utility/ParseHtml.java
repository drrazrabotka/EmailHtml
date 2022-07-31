package com.f.mygithub.utility;

import android.content.Context;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;

public class ParseHtml {
    private Context context;
    private String Logtag = "ParseHtml";

    public ParseHtml(Context context){
        this.context = context;
    }

    public byte[] LoadData(String inFile) {
        byte[] html = null;

        try {
            InputStream stream = context.getAssets().open(inFile);

            int size = stream.available();
            html = new byte[size];
            stream.read(html);
            stream.close();
            //html = new String(buffer);
        } catch (IOException e) {
        }

        return html;

    }

    public String getHtmlParse(String file){
        String html = "";
        try {
            InputStream stream = context.getAssets().open(file);

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            html = new String(buffer);
        } catch (IOException e) {
        }

        return html;

    }

    }
