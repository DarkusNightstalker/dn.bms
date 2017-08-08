package cs.bms.service;

import cs.bms.dao.interfac.ISaleDetailDao;
import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.Sale;
import cs.bms.model.SaleDetail;
import cs.bms.service.interfac.ISaleDetailService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SaleDetailService extends GenericService<SaleDetail, Long> implements ISaleDetailService {

    @Autowired
    @Qualifier("saleDetailDao")
    private ISaleDetailDao dao;

    @Override
    protected IGenericDao<SaleDetail, Long> getBasicDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getBasicDataBySale(Sale sale) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "sd.productName,"
                    + "sd.quantity,"
                    + "sd.uom.abbr,"
                    + "sd.unitPrice,"
                    + "sd.subtotal "
                + "FROM SaleDetail sd "
                    + "WHERE sd.sale = ?", sale);
    }

    @Override
    public BigDecimal getQuantityById(Long id) {
        return (BigDecimal) this.dao.getByHQL(""
                + "SELECT "
                    + "sd.quantity "
                + "FROM SaleDetail sd "
                + "WHERE sd.id = ?", id);
    }

    @Override
    public List<Object[]> getProductDataBySale(Sale sale) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "sd.product.id,"
                    + "sd.quantity "
                + "FROM SaleDetail sd "
                    + "WHERE sd.sale = ?", sale);
    }

    @Override
    public BigDecimal getSumQuantityByCompanyProduct(Company company, Product product) {        
        return (BigDecimal) dao.getByHQL(""
                + "SELECT "
                    + "COALESCE(SUM(sd.quantity),0) "
                + "FROM SaleDetail pd "
                + "WHERE "
                    + "sd.sale.company = ? AND "
                    + "sd.product = ? AND "
                    + "sd.sale.active = true",company,product);
    }
}
