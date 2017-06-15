 package cs.bms.util;
 
 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.net.CookieHandler;
 import java.net.CookieManager;
 import java.net.CookiePolicy;
 import java.net.CookieStore;
 import java.net.HttpCookie;
 import java.net.HttpURLConnection;
 import java.net.URL;
 import java.util.ArrayList;
 import java.util.List;
 import javax.net.ssl.HttpsURLConnection;
 import javax.swing.JOptionPane;
 
 
 
 public class CookieSearch
 {
   public static final String USER_AGENT_FIREFOX = "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.10) Gecko/2009042316 Firefox/3.0.10 (.NET CLR 3.5.30729)";
   public static final String NOMBRE_COOKIE = "JSESSIONID";
   
   public static List<Object> cookieLoginSSL(String urlseguridad)
     throws Exception
   {
     List<Object> rpta = new ArrayList(1);
     
     HttpsURLConnection connection = null;
     try
     {
       CookieManager manager = new CookieManager();
       manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
       CookieHandler.setDefault(manager);
       
 
       System.setProperty("https.protocols", "TLSv1,SSLv3,SSLv2Hello");
       System.setProperty("javax.net.debug", "all");
       System.setProperty("http.agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.10) Gecko/2009042316 Firefox/3.0.10 (.NET CLR 3.5.30729)");
       
       URL url = new URL(urlseguridad);
       connection = (HttpsURLConnection)url.openConnection();
       connection.setSSLSocketFactory(SSLByPass.getInstance().getSslSocketFactory());
       connection.setRequestMethod("POST");
       connection.setDoInput(true);
       connection.connect();
       connection.getContent();
       
       CookieStore cookieJar = manager.getCookieStore();
       List<HttpCookie> cookies = cookieJar.getCookies();
       
       rpta.add(cookies);
       StringBuilder answer = new StringBuilder();
       BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
       String line;
       while ((line = reader.readLine()) != null) {
         answer.append(line);
       }
       reader.close();
       connection.disconnect();
       rpta.add(answer);
     }
     catch (IOException e) {
       if (connection.getResponseCode() != 500) {
         JOptionPane.showMessageDialog(null, "No hay conexión", "Consulta DNI - buscarCookieLogueoSSL", 0);
       } else {
         JOptionPane.showMessageDialog(null, "No se puede obtener Cookies", "Consulta DNI - buscarCookieLogueoSSL", 0);
       }
       
       throw e;
     } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "No se puede obtener Cookies", "Consulta DNI - buscarCookieLogueoSSL", 0);
       throw e; }
     List<HttpCookie> cookies;
     return rpta;
   }
   
   public static List<Object> cookieLogin(String urlseguridad) throws Exception {
     List<Object> rpta = new ArrayList(1);
     
     HttpURLConnection connection = null;
     try
     {
       CookieManager manager = new CookieManager();
       manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
       CookieHandler.setDefault(manager);
       
 
       System.setProperty("http.agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.10) Gecko/2009042316 Firefox/3.0.10 (.NET CLR 3.5.30729)");
       
       URL url = new URL(urlseguridad);
       connection = (HttpURLConnection)url.openConnection();
       connection.setRequestMethod("POST");
       connection.setDoInput(true);
       connection.connect();
       connection.getContent();
       
 
       CookieStore cookieJar = manager.getCookieStore();
       List<HttpCookie> cookies = cookieJar.getCookies();
       
       rpta.add(cookies);
       StringBuilder answer = new StringBuilder();
       BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
       String line;
       while ((line = reader.readLine()) != null) {
         answer.append(line);
       }
       reader.close();
       connection.disconnect();
       rpta.add(answer);
     } catch (IOException e) {
       if (connection.getResponseCode() != 500) {
         JOptionPane.showMessageDialog(null, "No hay conexión", "Consulta RUC - buscarCookieLogueo", 0);
       } else {
         JOptionPane.showMessageDialog(null, "No se puede obtener Cookies", "Consulta RUC - buscarCookieLogueo", 0);
       }
       
       throw e;
     } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "No se puede obtener Cookies", "Consulta RUC - buscarCookieLogueo", 0);
       throw e; }
     List<HttpCookie> cookies;
     return rpta;
   }
 }

