package cs.bms.util;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SSLByPass {

    private static SSLByPass instance;
    private SSLSocketFactory sslSocketFactory;

    public SSLByPass()
            throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = {new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

        }};
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, new SecureRandom());

        this.sslSocketFactory = sslContext.getSocketFactory();
    }

    public static SSLByPass getInstance() throws NoSuchAlgorithmException, KeyManagementException {
        if (instance == null) {
            instance = new SSLByPass();
        }
        return instance;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }
}
