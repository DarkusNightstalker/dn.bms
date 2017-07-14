package cs.bms.service;

import cs.bms.dao.interfac.IStockReturnCustomerDao;
import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.StockReturnCustomer;
import cs.bms.service.interfac.IStockReturnCustomerService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StockReturnCustomerService extends GenericService<StockReturnCustomer, Long> implements IStockReturnCustomerService {

    @Autowired
    @Qualifier("stockReturnCustomerDao")
    private IStockReturnCustomerDao dao;

    @Override
    protected IGenericDao<StockReturnCustomer, Long> getDao() {
        return this.dao;
    }

}
