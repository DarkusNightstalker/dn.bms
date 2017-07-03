package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.ProductCostPrice;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Darkus Nightmare
 * @version 1.0
 */
public abstract interface IProductCostPriceService extends IGenericService<ProductCostPrice, Long> {

    public abstract Long getIdByCompanyProduct(Company company, Product product);

    public abstract BigDecimal getCostByCompanyProduct(Company paramCompany, Product paramProduct);

    public abstract BigDecimal getLastAcquisitionCost(Company paramCompany, Product paramProduct);

    public abstract void updateGroupCostByCompanyProduct(BigDecimal paramBigDecimal, Company paramCompany, Product paramProduct, User paramUser);

    public abstract List<Object[]> getCreatedByAfterDate(Date date, String companyCode);

    public abstract List<Object[]> getEditedByAfterDate(Date date, String companyCode, boolean b);
}

