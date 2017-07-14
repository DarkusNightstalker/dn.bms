package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.Stock;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IStockService extends IGenericService<Stock, Long> {

    public void substractQuantity(BigDecimal paramBigDecimal, Product paramProduct, Company paramCompany, User paramUser);

    public void addQuantity(BigDecimal paramBigDecimal, Product paramProduct, Company paramCompany, User paramUser);

    public Long getIdByCompanyProduct(Company paramCompany, Product paramProduct);

    public BigDecimal getGroupQuantityByCompanyProduct(Company paramCompany, Product paramProduct);

    public List<Object[]> getCreatedByAfterDate(Date init,Date end, String paramString);

    public List<Object[]> getEditedByAfterDate(Date init,Date end,  String paramString, boolean paramBoolean);
}

