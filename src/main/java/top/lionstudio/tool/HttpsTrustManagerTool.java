package top.lionstudio.tool;






import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;

public class HttpsTrustManagerTool extends X509ExtendedTrustManager {
	//空的https验证，这里不安全。出了事再说

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType,
			Socket socket) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType,
			SSLEngine engine) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType,
			Socket socket) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType,
			SSLEngine engine) throws CertificateException {
		// TODO Auto-generated method stub
		
	}


}
