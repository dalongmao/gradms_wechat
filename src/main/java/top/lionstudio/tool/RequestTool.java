package top.lionstudio.tool;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import top.lionstudio.properties.ParameterStatic;
import top.lionstudio.properties.UrlStatic;





public class RequestTool {

	public  String getUserInfo(String code) {
		StringBuffer buffer = new StringBuffer();
		try {
			TrustManager[] tm = { new HttpsTrustManagerTool() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL urlo = new URL(UrlStatic.MINILOGIN+"?appid=" + ParameterStatic.MINIID + "&secret="
					+ ParameterStatic.MINISECRET + "&js_code=" + code + "&grant_type=authorization_code");
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) urlo
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.connect();

			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return buffer.toString();
	}
}
