package cs.bms.util;

import cs.bms.util.exception.CaptchaFailedException;
import cs.bms.util.exception.IdentityException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.websocket.SessionException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class RequestCookie {

    public static byte[] requestCookieCaptchaSSL(String urlp, String method, List<HttpCookie> cookies) throws Exception {
        System.setProperty("http.agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.10) Gecko/2009042316 Firefox/3.0.10 (.NET CLR 3.5.30729)");
        try {
            CookieManager manager = new CookieManager();
            CookieHandler.setDefault(manager);
            CookieStore cookieJar = manager.getCookieStore();
            URL url = new URL(urlp);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setSSLSocketFactory(SSLByPass.getInstance().getSslSocketFactory());
            cookieJar.add(url.toURI(), (HttpCookie) cookies.get(0));

            connection.setRequestMethod(method);
            connection.connect();
            connection.getContent();
            BufferedInputStream reader = new BufferedInputStream(connection.getInputStream());
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            int c;
            while ((c = reader.read()) != -1) {
                byteArrayOut.write(c);
            }
            byte[] data = byteArrayOut.toByteArray();
            reader.close();
            return data;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "No se puede obtener Cookies ", "Consulta DNI - peticionConCookieImagenSSL", 0);
            throw e;
        }
    }

    public static String[] requestCookieSSL(String urlp, String metodo, String parametros, List<HttpCookie> cookies) throws CaptchaFailedException, IdentityException, MalformedURLException, IOException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, SessionException {
        System.setProperty("http.agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.10) Gecko/2009042316 Firefox/3.0.10 (.NET CLR 3.5.30729)");
        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);
        CookieStore cookieJar = manager.getCookieStore();
        URL url = new URL(urlp);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(SSLByPass.getInstance().getSslSocketFactory());
        cookieJar.add(url.toURI(), (HttpCookie) cookies.get(0));

        connection.setRequestMethod(metodo);
        connection.setDoOutput(true);

        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(parametros);
        writer.flush();

        connection.connect();
        connection.getContent();
        StringBuilder answer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "ISO-8859-1"));

        int linea = 1;
        String line;
        while ((line = reader.readLine()) != null) {
            if (linea == 151) {
                if (line.toUpperCase().contains("INGRESE EL")) {
                    throw new CaptchaFailedException("Texto de verificación erroneo");
                }
            } else if (linea == 160) {
                if (line.toUpperCase().contains("FALLECIMIENTO")) {
                    throw new IdentityException("El dueño del dni esta 3 metros bajo tierra");
                }
            } else if (linea == 150) {
                if (line.toUpperCase().contains("EXPIRADO")) {
                    throw new SessionException("La sesión ha expirado", null, null);
                }
            } else if (linea == 166) {
                if (line.toUpperCase().contains("MENOR")) {
                    throw new IdentityException("Documento de menor de edad");
                }
            } else if ((linea >= 154) && (linea <= 156)) {
                if (linea != 154) {
                    answer.append(" ");
                }
                answer.append(line.trim());
            }
            linea++;
        }
        writer.close();
        reader.close();

        String[] rpta = new String[1];
        rpta[0] = answer.toString().replace("<br>", "").trim();

        return rpta;
    }

    public static byte[] requestCookieCaptcha(String urlp, String metodo, List<HttpCookie> cookies) throws Exception {
        System.setProperty("http.agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.10) Gecko/2009042316 Firefox/3.0.10 (.NET CLR 3.5.30729)");
        try {
            CookieManager manager = new CookieManager();
            CookieHandler.setDefault(manager);
            CookieStore cookieJar = manager.getCookieStore();
            URL url = new URL(urlp);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            cookieJar.add(url.toURI(), (HttpCookie) cookies.get(0));

            connection.setRequestMethod(metodo);

            connection.connect();
            connection.getContent();
            BufferedInputStream reader = new BufferedInputStream(connection.getInputStream());
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            int c;
            while ((c = reader.read()) != -1) {
                byteArrayOut.write(c);
            }
            byte[] data = byteArrayOut.toByteArray();
            reader.close();
            return data;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "No se puede obtener Cookies ", "Consulta RUC - peticionConCookieImagen", 0);
            throw e;
        }
    }

    public static String[] requestCookie(String urlp, String metodo, String parametros, List<HttpCookie> cookies) throws CaptchaFailedException, IdentityException, MalformedURLException, IOException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, SessionException {
        System.setProperty("http.agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.10) Gecko/2009042316 Firefox/3.0.10 (.NET CLR 3.5.30729)");
        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);
        CookieStore cookieJar = manager.getCookieStore();
        URL url = new URL(urlp);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        for (HttpCookie item : cookies) {
            cookieJar.add(url.toURI(), item);
        }
        connection.setRequestMethod(metodo);
        connection.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(parametros);
        writer.flush();
        connection.connect();
        connection.getContent();
        String[] answer = new String[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "ISO-8859-1"));

        int linea = 1;
        String tipocontr = "";
        PrintWriter pw = new PrintWriter("D:\\SUNAT\\from_page.html");
        String line;
        while ((line = reader.readLine()) != null) {
            pw.println(line);
            if (linea == 122) {
                answer[0] = Jsoup.parse(line.trim()).body().text().trim().split(" - ")[1];
            } else if (linea == 126) {
                tipocontr = Jsoup.parse(line.trim()).body().text().trim();
            } else if (linea == 33) {
                if (line.trim().toUpperCase().contains("NO ES VÁLIDO")) {
                    answer[0] = null;
                    answer[1] = null;
                    return answer;
                }
            } else if (linea == 50) {
                if (line.trim().toUpperCase().contains("PROBLEMAS")) {
                    pw.close();
                    throw new SessionException("Codigo de verificación vencido", null, null);
                }
                if (line.trim().toUpperCase().contains("EL CODIGO INGRESADO ES INCORRECTO")) {
                    throw new CaptchaFailedException();
                }
            }
            if ((tipocontr.equalsIgnoreCase("PERSONA NATURAL SIN NEGOCIO")) || (tipocontr.equalsIgnoreCase("PERSONA NATURAL CON NEGOCIO"))) {
                if (linea == 167) {
                    answer[1] = Jsoup.parse(line.trim()).body().text().trim();
                }
            } else if (linea == 158) {
                answer[1] = Jsoup.parse(line.trim()).body().text().trim();
            } else if (linea == 131) {
                answer[2] = Jsoup.parse(line.trim()).body().text().trim();
            }

            linea++;
        }
        pw.close();
        writer.close();
        reader.close();

        return answer;
    }
}
