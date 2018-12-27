package top.lionstudio.test;

import static org.assertj.core.api.Assertions.in;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;

import top.lionstudio.tool.RequestTool;

public class Test {

	public static void main(String[] args) throws Exception {
//		File file = new File("E:/te.txt");
//		FileInputStream inputStream = new FileInputStream(file);
//		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
//		ArrayList arr=new ArrayList<>();
//		Map tempMap=null;
//		String tempStr=null;
//		while ((tempStr = reader.readLine()) != null) {
//			String t[]=tempStr.split(",");
//			tempMap=new HashMap<>();
//			tempMap.put("index", t[0]);
//			tempMap.put("name",  t[1]);
//			tempMap.put("des", "专业:"+t[2]);
//			arr.add(tempMap);
//		}
//		System.out.println(new Gson().toJson(arr));
//		
//		
		ArrayList arr=new ArrayList<>();
		Map m=new HashMap<>();
		m.put("index", 1);
		m.put("name","数据科学");
		m.put("des", "专业代码：99J4；申请授权级别：博士；审议内容：新设置");
		arr.add(m);
		m=new HashMap<>();
		m.put("index", 2);
		m.put("name","人工智能科学");
		m.put("des", "专业代码：99J4；申请授权级别：博士；审议内容：新设置");
		arr.add(m);
		System.out.println(new Gson().toJson(arr));
		

	}

}
