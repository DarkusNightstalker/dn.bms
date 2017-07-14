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
public  interface IProductCostPriceService extends IGenericService<ProductCostPrice, Long> {

    public  Long getIdByCompanyProduct(Company company, Product product);

    public  BigDecimal getCostByCompanyProduct(Company paramCompany, Product paramProduct);

    public  BigDecimal getLastAcquisitionCost(Company paramCompany, Product paramProduct);

    public  void updateGroupCostByCompanyProduct(BigDecimal paramBigDecimal, Company paramCompany, Product paramProduct, User paramUser);

    public  List<Object[]> getCreatedByAfterDate(Date init,Date end, String companyCode);

    public  List<Object[]> getEditedByAfterDate(Date init,Date end, String companyCode, boolean b);
}

