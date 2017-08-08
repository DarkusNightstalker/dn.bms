package cs.bms.service;

import cs.bms.dao.interfac.IElectronicBookDao;
import cs.bms.model.ElectronicBook;
import cs.bms.service.interfac.IElectronicBookService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ElectronicBookService
        extends GenericService<ElectronicBook, Short>
        implements IElectronicBookService {

    @Autowired
    @Qualifier("electronicBookDao")
    private IElectronicBookDao dao;

    public boolean existCode(String code, Short id) {
        return this.dao.existCode(code, id);
    }

    protected IGenericDao<ElectronicBook, Short> getBasicDao() {
        return this.dao;
    }
}
