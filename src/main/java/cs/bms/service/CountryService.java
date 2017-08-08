package cs.bms.service;

import cs.bms.dao.interfac.ICountryDao;
import cs.bms.model.Country;
import cs.bms.service.interfac.ICountryService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CountryService
        extends GenericService<Country, Integer>
        implements ICountryService {

    @Autowired
    @Qualifier("countryDao")
    private ICountryDao dao;

    protected IGenericDao<Country, Integer> getBasicDao() {
        return this.dao;
    }
}
