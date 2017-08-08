package cs.bms.service;

import cs.bms.dao.interfac.IDistrictDao;
import cs.bms.model.District;
import cs.bms.service.interfac.IDistrictService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DistrictService extends GenericService<District, Integer> implements IDistrictService {

    @Autowired
    @Qualifier("districtDao")
    private IDistrictDao dao;

    @Override
    protected IGenericDao<District, Integer> getBasicDao() {
        return this.dao;
    }

    @Override
    public String getUbigeoNameById(Integer id) {
        return (String) dao.getByHQL(""
                + "SELECT "
                + "d.subregion.region.name||'-'||d.subregion.name||'-'||d.name "
                + "FROM District d "
                + "WHERE d.id = ?",id);
    }

    @Override
    public Integer getIdByUbigeo(String ubigeo) {
        return (Integer) dao.getByHQL(""
                + "SELECT "
                + "d.id "
                + "FROM District d "
                + "WHERE d.subregion.region.name||'-'||d.subregion.name||'-'||d.name = ?",ubigeo);
    }
}
