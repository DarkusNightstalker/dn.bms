package cs.bms.service.interfac;

import cs.bms.model.Company;
import gkfire.hibernate.generic.interfac.IGenericService;
import gkfire.util.Month;
import java.util.Date;
import java.util.List;

public interface ICompanyService extends IGenericService<Company, Integer> {

    public List getDataByList(List paramList);

    public List<Object[]> getBasicDataNotOpening(int paramInt, Month paramMonth);

    public List<Object[]> getCreatedByAfterDate(Date paramDate);

    public List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);

    public Company getByCode(String code);

    public List<Object[]> getBasicData();
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\ICompanyService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
