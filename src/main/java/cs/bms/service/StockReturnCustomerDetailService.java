package cs.bms.service;

import cs.bms.dao.interfac.IStockReturnCustomerDetailDao;
import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.StockReturnCustomerDetail;
import cs.bms.service.interfac.IStockReturnCustomerDetailService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StockReturnCustomerDetailService extends GenericService<StockReturnCustomerDetail, Long> implements IStockReturnCustomerDetailService {

    @Autowired
    @Qualifier("stockReturnCustomerDetailDao")
    private IStockReturnCustomerDetailDao dao;

    @Override
    protected IGenericDao<StockReturnCustomerDetail, Long> getBasicDao() {
        return this.dao;
    }

    @Override
    public BigDecimal getSumQuantityByCompanyProduct(Company company, Product product) {
        return (BigDecimal) dao.getByHQL(""
                + "SELECT "
                    + "SUM(srcd.quantity) "
                + "FROM StockReturnCustomerDetail srcd "
                + "WHERE "
                    + "srcd.stockReturnCustomer.sale.company = ? AND "
                    + "srcd.product = ? AND "
                    + "srcd.stockReturnCustomer.active = true",company,product);
    }
}
