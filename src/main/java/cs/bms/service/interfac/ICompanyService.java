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

    public Integer getIdByCode(String code);
}

