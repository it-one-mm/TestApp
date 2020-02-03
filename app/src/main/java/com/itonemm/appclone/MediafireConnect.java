package com.itonemm.appclone;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MediafireConnect {

    public static String getVideoFileLink(String  videolink)
    {

        String BASEURL="https://media-fire-api.herokuapp.com/?url="+URLEncoder.encode(videolink);

        try {
            URL url=new URL(BASEURL);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");
            connection.setRequestProperty("Content-type","application/json;charset=utf-8");
            connection.setDoInput(true);
            InputStream stream=connection.getInputStream();
            InputStreamReader reader=new InputStreamReader(stream);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String line="";
            StringBuilder builder=new StringBuilder();
            while ((line=bufferedReader.readLine())!=null)
            {
                builder.append(line);
            }
            JSONArray array=new JSONArray(builder.toString());
            JSONObject object=array.getJSONObject(0);
            String link=object.getString("file");
            return  link;


        }
        catch (Exception ex)
        {
            return null;
        }

    }

}
