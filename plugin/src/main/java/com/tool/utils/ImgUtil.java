package com.tool.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by XM on 2017/5/5.
 */
public class ImgUtil {

    public static void getThumbnails(String destUrl, String targetPath, String subfix) throws IOException {
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        byte[] buf = new byte[1024];
        int size = 0;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            Thumbnails.of(bis).scale(1f).outputQuality(0.25f).outputFormat(subfix).toFile(targetPath);
        }  finally {
            try {
                bis.close();
                httpUrl.disconnect();
            } catch (NullPointerException e) {
            }
        }
    }

    public static void getThumbnails(String url, String targetPath) throws IOException {
        getThumbnails(url,targetPath, "jpg");
    }

    public static void main(String[] args) throws Exception {
        getThumbnails("", "");
    }
}
