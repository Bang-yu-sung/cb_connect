package cubox.aero.connect.util;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class ApiUtil {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static ApiUtil instance;

    private static String KFACE_API_URL = "http://172.16.153.54:5770";

    static {
        instance = new ApiUtil();
    }


    public JSONObject getApiReq(String reqBody, String url) {

        int responseCode = -1;

        String InputLine = "";
        String responseBody = "";
        HttpURLConnection matchConn = null;
        try {

            String reqUrl = KFACE_API_URL + url;

            URL Url = new URL(reqUrl);
            matchConn = (HttpURLConnection) Url.openConnection();

            matchConn.setDoOutput(true);
            matchConn.setRequestMethod("POST");
            matchConn.setRequestProperty("Content-Type", "application/json");
            matchConn.setRequestProperty("Accept-Charset", "UTF-8");
            matchConn.setConnectTimeout(5000);
            matchConn.setReadTimeout(5000);

            OutputStream matchOs = matchConn.getOutputStream();
            matchOs.write(reqBody.getBytes("UTF-8"));
            matchOs.flush();

            responseCode = matchConn.getResponseCode();

            // 리턴된 결과 읽기
            InputStreamReader isr = null;
            if (responseCode == 200) {
                isr = new InputStreamReader(matchConn.getInputStream(), "UTF-8");
            } else {
                isr = new InputStreamReader(matchConn.getErrorStream(), "UTF-8");
            }
            BufferedReader matchIn = new BufferedReader(isr);
            while ((InputLine = matchIn.readLine()) != null) {
                responseBody += InputLine;
            }


            logger.info("response : {}", responseBody);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (matchConn != null) matchConn.disconnect();
        }

        JSONObject response = new JSONObject();
        response.put("code", responseCode);
        response.put("body", responseBody);


        return response;
    }

}


