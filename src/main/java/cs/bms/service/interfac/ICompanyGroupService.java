package cs.bms.service.interfac;

import cs.bms.model.CompanyGroup;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.List;

public interface ICompanyGroupService extends IGenericService<CompanyGroup, Integer> {

    public  List<Object[]> getBasicData();

    public Integer getIdByName(String name);
}
