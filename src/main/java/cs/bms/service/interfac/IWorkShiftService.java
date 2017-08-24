package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.WorkShift;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IWorkShiftService extends IGenericService<WorkShift, Integer> {

    public List<Object[]> getFreeBasicDataByCompany(Date paramDate, Company paramCompany);

    public List<Object[]> getBasicDataByCompany(Company paramCompany);

    public Integer getIdByCompanyName(Company company, String name);

    public List<Object[]> getCreatedByAfterDate(Date init, Date end ,String company);

    public List<Object[]> getEditedByAfterDate(Date lastUpdateDate, Date currentDateUpdate, String companyCode, boolean b);
}
