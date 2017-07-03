package cs.bms.service;

import cs.bms.dao.interfac.IProductSalePriceDao;
import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.ProductSalePrice;
import cs.bms.model.User;
import cs.bms.service.interfac.IProductSalePriceService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Darkus Nightmare
 * @version 1.0
 */
@Service
public class ProductSalePriceService extends GenericService<ProductSalePrice, Long> implements IProductSalePriceService {

    @Autowired
    @Qualifier("productSalePriceDao")
    private IProductSalePriceDao dao;

    @Override
    protected IGenericDao<ProductSalePrice, Long> getDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getBasicDataByCompanyProduct(Company company, Product product) {
        return this.dao.listHQL("SELECT psp.quantity,psp.price FROM ProductSalePrice psp WHERE psp.company = ? AND psp.product = ? ORDER BY psp.quantity", new Object[]{company, product});
    }

    /**
     *
     * @param company
     * @param product
     */
    @Override
    public void deleteByCompanyProduct(Company company, Product product) {
        this.dao.updateHQL(""
                + "DELETE FROM ProductSalePrice psp "
                + "WHERE "
                    + "psp.product = ? AND "
                    + "psp.company.id IN ("
                        + "SELECT "
                            + "c.id "
                        + "FROM Company c "
                        + "WHERE c.companyGroup = ?"
                    + ")", product, company.getCompanyGroup());
    }

    @Override
    public void saveForGroup(BigDecimal price, Integer quantity, Company currentCompany, Product selected, User user) {
        List<Integer> cIds = this.dao.listHQL(""
                + "SELECT "
                    + "c.id "
                + "FROM Company c "
                + "WHERE c.companyGroup = ?",currentCompany.getCompanyGroup());
        for (Integer cId : cIds) {
            ProductSalePrice pspItem = new ProductSalePrice();
            pspItem.setProduct(selected);
            pspItem.setPrice(price);
            pspItem.setQuantity(quantity);
            pspItem.setCompany(new Company(cId));
            pspItem.setCreateUser(user);
            pspItem.setCreateDate(new Date());
            this.dao.saveOrUpdate(pspItem);
        }
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date date, String company) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "psp.product.id,"
                    + "psp.product.barcode,"
                    + "psp.company.id,"
                    + "psp.company.code,"
                    + "psp.quantity,"
                    + "psp.price "
                + "FROM ProductSalePrice psp "
                + "WHERE "
                    + "psp.createDate > ? AND "
                    + "psp.company.code = ? "
                + "ORDER BY psp.createDate", date, company);
    }

    @Override
    public BigDecimal getBasicPrice(Company currentCompany, Product product) {
        try{
            return (BigDecimal) dao.listHQLPage(""
                    + "SELECT "
                        + "psp.price "
                    + "FROM ProductSalePrice psp "
                    + "WHERE "
                        + "psp.product = ? and "
                        + "psp.company = ? "
                    + "ORDER BY psp.price", 1, 1,product, currentCompany).get(0);
        }catch(Exception e){
            return null;
        }
    }
}
