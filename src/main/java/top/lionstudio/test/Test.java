package top.lionstudio.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import top.lionstudio.tool.RequestTool;

public class Test {

	public static void main(String[] args) {
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("username", "vip"));
		nvps.add(new BasicNameValuePair("password", "secret"));
		String content=RequestTool.HttpsPostForMap(nvps, "http://localhost:8080/gradms/wechat/wechatWebRequestDataObject.do");
		System.out.println(content);
			
	}

}
