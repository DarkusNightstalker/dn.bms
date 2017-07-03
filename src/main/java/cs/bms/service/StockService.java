package cs.bms.service;

import cs.bms.dao.interfac.IStockDao;
import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.Stock;
import cs.bms.model.User;
import cs.bms.service.interfac.IStockService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StockService
        extends GenericService<Stock, Long>
        implements IStockService {

    @Autowired
    @Qualifier("stockDao")
    private IStockDao dao;

    protected IGenericDao<Stock, Long> getDao() {
        return this.dao;
    }

    @Override
    public void substractQuantity(BigDecimal quantity, Product product, Company company, User user) {
        this.dao.updateHQL("UPDATE Stock SET quantity = (quantity - ?),editUser = ?,editDate = ?  WHERE product = ? AND company = ?", new Object[]{quantity, user, new Date(), product, company});
    }

    @Override
    public void addQuantity(BigDecimal quantity, Product product, Company company, User user) {
        boolean exist = this.dao.getByHQL("SELECT 1 FROM Stock s WHERE s.product = ? and s.company = ?", new Object[]{product, company}) != null;
        if (!exist) {
            Stock st = new Stock();
            st.setCompany(company);
            st.setProduct(product);
            st.setQuantity(quantity);
            st.setCreateUser(user);
            st.setCreateDate(new Date());
            this.dao.saveOrUpdate(st);
        } else {
            this.dao.updateHQL("UPDATE Stock SET quantity = (quantity + ?),editUser = ?,editDate = ? WHERE product = ? AND company = ?", new Object[]{quantity, user, new Date(), product, company});
        }
    }

    @Override
    public Long getIdByCompanyProduct(Company currentCompany, Product product) {
        return (Long) this.dao.getByHQL("SELECT s.id FROM Stock s WHERE s.product = ? AND s.company = ?", new Object[]{product, currentCompany});
    }

    @Override
    public BigDecimal getGroupQuantityByCompanyProduct(Company company, Product product) {
        return (BigDecimal) this.dao.getByHQL("SELECT SUM(st.quantity) FROM Stock st WHERE st.product = ? AND st.company.id IN (SELECT c.id from Company c WHERE c.companyGroup = ?)", new Object[]{product, company.getCompanyGroup()});
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date date, String company) {
        return this.dao.listHQL("SELECT "
                + "st.id,"
                + "st.quantity,"
                + "st.product.id,"
                + "st.product.barcode,"
                + "st.company.id,"
                + "st.company.code "
                + "FROM Stock st WHERE st.company.code = ? AND st.createDate > ?", company, date);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date date, String company, boolean b) {
        return this.dao.listHQL("SELECT "
                + "st.id,"
                + "st.quantity,"
                + "st.product.id,"
                + "st.product.barcode,"
                + "st.company.id,"
                + "st.company.code "
                + "FROM Stock st WHERE st.company.code = ? AND st.createDate < ? AND st.editDate > ?", company, date, date);
    }
}
