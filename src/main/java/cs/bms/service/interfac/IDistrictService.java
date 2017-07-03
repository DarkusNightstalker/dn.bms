package cs.bms.service.interfac;

import cs.bms.model.District;
import gkfire.hibernate.generic.interfac.IGenericService;

public interface IDistrictService extends IGenericService<District, Integer> {    
    public String getUbigeoNameById(Integer id);
}
