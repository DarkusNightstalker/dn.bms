package cs.bms.service;

import cs.bms.dao.interfac.IProductCostPriceDao;
import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.ProductCostPrice;
import cs.bms.model.User;
import cs.bms.service.interfac.IProductCostPriceService;
import gkfire.auditory.Auditory;
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
public class ProductCostPriceService extends GenericService<ProductCostPrice, Long> implements IProductCostPriceService {

    @Autowired
    @Qualifier("productCostPriceDao")
    private IProductCostPriceDao dao;

    @Override
    protected IGenericDao<ProductCostPrice, Long> getDao() {
        return this.dao;
    }

    @Override
    public Long getIdByCompanyProduct(Company company, Product product) {
        return (Long) this.dao.getByHQL(""
                + "SELECT "
                    + "pcp.id "
                + "FROM ProductCostPrice pcp "
                + "WHERE "
                    + "pcp.company = ? AND "
                    + "pcp.product.id = ?", company, product.getId() == null ? -1L : product.getId());
    }

    @Override
    public BigDecimal getCostByCompanyProduct(Company company, Product product) {
        BigDecimal cost = (BigDecimal) this.dao.getByHQL(""
                + "SELECT "
                    + "pcp.cost "
                + "FROM ProductCostPrice pcp "
                + "WHERE "
                    + "pcp.product = ? AND "
                    + "pcp.company = ?", product, company);
        if (cost == null) {
            cost = BigDecimal.ZERO.setScale(2);
        }
        return cost;
    }

    @Override
    public BigDecimal getLastAcquisitionCost(Company company, Product product) {
        try {
            return (BigDecimal) this.dao.listHQLPage(""
                    + "SELECT "
                        + "k.costIn "
                    + "FROM Kardex k "
                    + "WHERE "
                        + "k.product = ? AND "
                        + "k.company.id IN ("
                            + "SELECT "
                                + "c.id "
                            + "FROM Company c "
                            + "WHERE c.companyGroup = ?"
                        + ") AND "
                        + "k.costIn is not null AND "
                        + "k.operationType.id IN (21,2) "
                    + "ORDER BY k.orderDate desc ", 1, 1, product, company.getCompanyGroup()).get(0);
        } catch (IndexOutOfBoundsException e) {
            
        }
        return BigDecimal.ZERO.setScale(2);
    }

    @Override
    public void updateGroupCostByCompanyProduct(BigDecimal cost, Company company, Product product, User user) {
        List<Integer> cIds = this.dao.listHQL(""
                + "SELECT "
                    + "c.id "
                + "FROM Company c "
                + "WHERE c.companyGroup =?",company.getCompanyGroup());
        for (Integer cId : cIds) {
            ProductCostPrice pcp = new ProductCostPrice();
            Object[] info = (Object[]) this.dao.getByHQL(""
                    + "SELECT "
                        + "pcp.id,"
                        + "pcp.createUser.id,"
                        + "pcp.createDate "
                    + "FROM ProductCostPrice pcp "
                    + "WHERE "
                        + "pcp.company.id = ? AND "
                        + "pcp.product = ?", cId, product);
            if (info != null) {
                pcp.setId((Long) info[0]);
                pcp.setCreateUser(new User((Integer) info[1]));
                pcp.setCreateDate((Date) info[2]);
            }
            pcp.setCompany(new Company(cId));
            pcp.setCost(cost);
            pcp.setProduct(product);
            Auditory.make(pcp, user);
            this.dao.saveOrUpdate(pcp);
        }
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date date, String idCompany) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "pcp.id,"
                    + "pcp.product.id,"
                    + "pcp.product.barcode,"
                    + "pcp.company.id,"
                    + "pcp.company.code,"
                    + "pcp.cost,"
                    + "pcp.createUser.id,"
                    + "pcp.createDate "
                + "FROM ProductCostPrice pcp "
                + "WHERE "
                    + "pcp.createDate > ? AND "
                    + "pcp.company.code = ? "
                + "ORDER BY psp.createDate", date, idCompany);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date date, String codeCompany, boolean b) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "pcp.id,"
                    + "pcp.product.id,"
                    + "pcp.product.barcode,"
                    + "pcp.company.id,"
                    + "pcp.company.code,"
                    + "pcp.cost,"
                    + "pcp.createUser.id,"
                    + "pcp.createDate,"
                    + "pcp.editUser.id,"
                    + "pcp.editDate "
                + "FROM ProductCostPrice pcp "
                + "WHERE "
                    + "pcp.editDate > ? AND "
                    + "pcp.createDate < ? AND "
                    + "pcp.company.code = ? "
                + "ORDER BY psp.editDate", date, date, codeCompany);
    }
}
