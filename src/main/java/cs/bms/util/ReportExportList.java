package cs.bms.util;

import cs.bms.bean.util.PNotifyMessage;
import cs.bms.bean.util.PNotifyMessage.Type;
import gkfire.report.util.ReportContentType;
import gkfire.web.bean.AbstractSessionBean;
import gkfire.web.util.BeanUtil;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.SimpleFileResolver;

public class ReportExportList
        extends ReportExport {

    private final Function<Map<String, Object>, List<JasperPrint>> function;

    public ReportExportList(String pathJasper, String fileName, AbstractSessionBean sessionBean, Map<String, Object> defaultParams, Function<Map<String, Object>, List<JasperPrint>> functionMakeList) {
        super(pathJasper, fileName, sessionBean, defaultParams);
        this.function = functionMakeList;
    }

    public InputStream makeInputStream() {
        return BeanUtil.getContext().getResourceAsStream(this.pathJasper);
    }

    protected String execute(JRExporter exporter) {
        try {
            String reportsDirPath = BeanUtil.getContext().getRealPath("/") + "1258488425132154132154214536";
            File reportsDir = new File(reportsDirPath);
            this.params.put("REPORT_FILE_RESOLVER", new SimpleFileResolver(reportsDir));

            List<JasperPrint> list = (List) this.function.apply(this.params);

            exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, list);

            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.setContentType(this.contentType.getMimeType());
            response.addHeader("Content-disposition", "attachment; filename=\"" + this.fileName + "." + this.contentType.name().toLowerCase() + "\"");

            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());

            exporter.exportReport();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            this.sessionBean.getMessages().add(new PNotifyMessage("ERROR EN REPORTE!", ex.toString(), PNotifyMessage.Type.Danger, "fa fa-warning shaked animated"));
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return "index?faces-redirect=true";
    }
}
