package com.dre.sjty.reptile;

import org.omg.CORBA.NameValuePair;
import org.springframework.http.HttpEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.net.Proxy.Type.HTTP;

/**
 * Crawl the web page information, retrieve useful information and send detection report
 */
public class SjtyGetYanZhao {

    public static void main(String[] args) {
        SjtyGetYanZhao yan = new SjtyGetYanZhao();
        yan.run();
    }

    public void run() {
        try {
            //            1、发送请求
            SjtyWebPageVO request = new SjtyWebPageVO("https://yz.chsi.com.cn/sytj/tj/qecx.html");
            //        2、解析超文本连接
            System.out.println(get(request));
            //        3、分析信息
            //        4、发送邮件
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }

    public String get(SjtyWebPageVO pageVO) {
        BufferedReader in = null;
        try {
            URL realUrl = pageVO.getURL();
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
