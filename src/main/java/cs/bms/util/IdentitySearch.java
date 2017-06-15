package cs.bms.util;

import cs.bms.util.exception.CaptchaFailedException;
import cs.bms.util.exception.IdentityException;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.websocket.SessionException;

public class IdentitySearch
        implements Serializable {

    protected List<Object> cookieLogin;
    protected byte[] imageCaptcha;
    protected String[] urls;

    public IdentitySearch() {
        this.urls = new String[3];
    }

    public void init(int length) {
        if (length == 8) {
            this.urls[0] = "https://cel.reniec.gob.pe/valreg/valreg.do;";
            this.urls[1] = "https://cel.reniec.gob.pe/valreg/codigo.do";
            this.urls[2] = "https://cel.reniec.gob.pe/valreg/valreg.do;";
            try {
                this.cookieLogin = CookieSearch.cookieLoginSSL(this.urls[0]);
                this.imageCaptcha = RequestCookie.requestCookieCaptchaSSL(this.urls[1], "POST", (List) this.cookieLogin.get(0));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            this.urls[0] = "http://www.sunat.gob.pe/cl-ti-itmrconsruc/frameCriterioBusqueda.jsp";
            this.urls[1] = "http://www.sunat.gob.pe/cl-ti-itmrconsruc/captcha?accion=image";
            this.urls[2] = "http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias;";
            try {
                this.cookieLogin = CookieSearch.cookieLogin(this.urls[0]);
                this.imageCaptcha = RequestCookie.requestCookieCaptcha(this.urls[1], "POST", (List) this.cookieLogin.get(0));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public Object search(String identityNumber, String captcha)
            throws CaptchaFailedException, IdentityException, IOException, MalformedURLException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, SessionException, Exception {
        if ((identityNumber.trim().length() != 8) && (identityNumber.trim().length() != 11)) {
            throw new IllegalArgumentException("Formato incorrecto de documento");
        }
        boolean isDNI = identityNumber.trim().length() == 8;
        StringBuilder sbParams = new StringBuilder();

        if (isDNI) {
            sbParams.append("accion=buscar&");
            sbParams.append("nuDni=");
            sbParams.append(identityNumber.trim());
            sbParams.append("&");
            sbParams.append("imagen=");
            sbParams.append(captcha.trim());
        } else {
            sbParams.append("accion=consPorRuc&");
            sbParams.append("nroRuc=");
            sbParams.append(identityNumber.trim());
            sbParams.append("&");
            sbParams.append("codigo=");
            sbParams.append(captcha.trim().toUpperCase());
        }

        String params = sbParams.toString();
        StringBuilder sb_url = new StringBuilder();
        sb_url.append(this.urls[2]);

        List<HttpCookie> cookies = (List) this.cookieLogin.get(0);
        for (HttpCookie httpCookie : cookies) {
            if (httpCookie.getName().compareToIgnoreCase("jsessionid") == 0) {
                sb_url.append(httpCookie.getName());
                sb_url.append("=");
                sb_url.append(httpCookie.getValue());
            }
        }
        String name = null;

        if (isDNI) {
            String[] result = RequestCookie.requestCookieSSL(sb_url.toString(), "POST", params, (List) this.cookieLogin.get(0));
            name = result[0];
            if ((name.contains("<")) || (name.contains(">"))) {
                return null;
            }
            return name;
        }
        String[] result = RequestCookie.requestCookie(sb_url.toString(), "POST", params, (List) this.cookieLogin.get(0));
        if (result[0] == null) {
            return result;
        }
        String[] cadena = result[1].split(" - ");
        String[] data = new String[6];
        data[0] = result[0];

        data[3] = UbigeoUtil.homologateSubregion(cadena[(cadena.length - 2)].trim());
        data[4] = UbigeoUtil.homologateDistrict(cadena[(cadena.length - 1)].trim());
        String address = "";
        for (int i = 0; i < cadena.length - 2; i++) {
            address = cadena[i];
        }
        data[2] = UbigeoUtil.getRegionFromAddress(address);
        address = address.substring(0, address.length() - data[2].length()).trim();
        data[1] = address;
        data[2] = UbigeoUtil.homologateRegion(data[2].trim());
        data[5] = result[2];
        return data;
    }

    public List<Object> getCookieLogin() {
        return this.cookieLogin;
    }

    public void setCookieLogin(List<Object> cookieLogin) {
        this.cookieLogin = cookieLogin;
    }

    public byte[] getImageCaptcha() {
        return this.imageCaptcha;
    }

    public void setImageCaptcha(byte[] imageCaptcha) {
        this.imageCaptcha = imageCaptcha;
    }

    public String[] getUrls() {
        return this.urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }
}
