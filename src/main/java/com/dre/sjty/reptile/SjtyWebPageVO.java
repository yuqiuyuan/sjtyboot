package com.dre.sjty.reptile;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SjtyWebPageVO {
    private String urlStr;
    private URL url;
    private String content;
    private Map<String,String> params = new HashMap<>();

    public SjtyWebPageVO(String urlStr) throws Exception {
        this.urlStr = urlStr;
    }

    public URL getURL() throws Exception{
        return this.url==null?new URL(this.urlStr):url;
    }
}
