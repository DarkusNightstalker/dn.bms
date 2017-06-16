package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Sale;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract interface ISaleService extends IGenericService<Sale, Long> {

    public abstract List<Object[]> getNotVerifySales(Company company, List<Long> exceptions);

    public abstract void verified(Long id);

    public abstract BigDecimal getVisaAfterByCompany(Date date, Company company);

    public abstract void updatePoints(Long paramLong1, Long paramLong2);

    public abstract void updateDiscount(BigDecimal paramBigDecimal, Long paramLong);
}
