package com.dre.sjty.reptile;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.omg.CORBA.NameValuePair;
import org.springframework.http.HttpEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.net.Proxy.Type.HTTP;

public class SjtyRequestClient {
    //设置链接超时和请求超时等参数，否则会长期停止或者崩溃
    private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).setConnectionRequestTimeout(60000).build();

    //    public static String sendHttpsPost (String url, Map< String, String > params){
    //        String responseContent = null;
    //        try {
    //            HttpPost httpPost = new HttpPost(url);
    //            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
    //            for (String key : params.keySet()) {
    //                nvps.add(new BasicNameValuePair(key, params.get(key)));
    //            }
    //            httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
    //            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setDefaultRequestConfig(requestConfig).build();
    //            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
    //            HttpEntity httpEntity = httpResponse.getEntity();
    //            if (httpEntity != null) {
    //                responseContent = EntityUtils.toString(httpEntity, HTTP.UTF_8);
    //            }
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //        return responseContent;
    //    }
    //}
}
