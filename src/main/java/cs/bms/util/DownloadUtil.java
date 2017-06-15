package cs.bms.util;

import cs.bms.bean.util.PNotifyMessage;
import gkfire.util.AES;
import gkfire.web.bean.AbstractSessionBean;
import gkfire.web.util.BeanUtil;
import java.net.URLEncoder;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class DownloadUtil {

    public static void downloadJSONSale(Long id, AbstractSessionBean sessionBean) {
        try {
            String q = URLEncoder.encode(AES.encrypt(id + "," + new Date().getTime(), "TjYHIx60uTEukXY9"), "UTF-8");
            BeanUtil.exceuteJS("var link = document.createElement(\"a\");    link.download = 'data_sale.dkn';    link.href = '"
                    + BeanUtil.getRequest().getContextPath() + "/resources/sale/data_sale.dkn?q=" + q + "';" + "    link.click();");
        } catch (Exception e) {
            PNotifyMessage.systemError(e, sessionBean);
        }
    }
}
