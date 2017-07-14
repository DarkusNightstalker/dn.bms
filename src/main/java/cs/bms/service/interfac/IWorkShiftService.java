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
}
