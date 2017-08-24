package cs.bms.service;

import cs.bms.dao.interfac.IPaymentVoucherDao;
import cs.bms.model.CashRegister;
import cs.bms.model.Company;
import cs.bms.model.PaymentVoucher;
import cs.bms.model.Sale;
import cs.bms.model.User;
import cs.bms.service.interfac.IPaymentVoucherService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Implementación SERVICE para el modelo PAYMENT VOUCHER
 * @author Darkus Nightmare
 */
@Service
public class PaymentVoucherService extends GenericService<PaymentVoucher, Long> implements IPaymentVoucherService {

    @Autowired
    @Qualifier("paymentVoucherDao")
    private IPaymentVoucherDao dao;

    @Override
    protected IGenericDao<PaymentVoucher, Long> getBasicDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getBasicDataByCashRegister(CashRegister cashRegister) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Long getNextNumerationByPrefix(String prefix) {
        List result = this.dao.listHQLPage(""
                + "SELECT "
                    + "pv.numeration "
                + "FROM PaymentVoucher pv "
                + "WHERE pv.numeration LIKE ? "
                + "ORDER BY numeration_format(pv.numeration,?) DESC", 1, 1, prefix + "%",prefix);
        if (result.isEmpty()) {
            return 1L;
        }
        return Long.parseLong(result.get(0).toString().replace(prefix, "")) + 1L;
    }

    @Override
    public boolean verifyNumeration(String code) {
        return this.dao.getByHQL(""
                + "SELECT "
                    + "1 "
                + "FROM PaymentVoucher pv "
                + "WHERE "
                    + "pv.sale is not null AND "
                    + "pv.active = true AND "
                    + "pv.numeration LIKE ?", code) != null;
    }

    @Override
    public boolean existNumeration(String code) {
        return this.dao.getByHQL(""
                + "SELECT "
                    + "1 "
                + "FROM PaymentVoucher pv "
                + "WHERE pv.numeration LIKE ?", code) != null;
    }

    @Override
    public Integer getValueByCode(String code) {
        return (Integer) this.dao.getByHQL(""
                + "SELECT "
                    + "pv.value "
                + "FROM PaymentVoucher pv "
                + "WHERE pv.numeration LIKE ?",code);
    }

    @Override
    public void useVoucher(String code, Long saleId,User user) {
        this.dao.updateHQL(""
                + "UPDATE PaymentVoucher "
                + "SET "
                    + "sale = ?,"
                    + "active = false,"
                    + "editUser = ?,"
                    + "editDate = ? "
                + "WHERE numeration like ?", new Sale(saleId), user,new Date(),code);
    }

    @Override
   public Integer getTotalSumAfterByCompany(Date date, Company company) {
        if (date != null) {
            return ((Long) this.dao.getByHQL(""
                    + "SELECT "
                        + "COALESCE(SUM(pv.value),0) "
                    + "FROM PaymentVoucher pv "
                    + "WHERE  "
                        + "pv.sale.company = ? AND "
                        + "pv.sale.dateIssue > ? AND "
                        + "pv.sale.active = true AND "
                        + "pv.sale.verified = true AND "
                        + "pv.sale.credit = false", company,date))
                    .intValue();
        }

        return ((Long) this.dao.getByHQL(""
                + "SELECT "
                    + "COALESCE(SUM(pv.value),0) "
                + "FROM PaymentVoucher pv WHERE  "
                    + "pv.sale.company = ? AND "
                    + "pv.sale.active = true AND "
                    + "pv.sale.verified = true AND "
                    + "pv.sale.credit = false", company))
                .intValue();
    }

    @Override
    public Long getIdByNumeration(String numeration) {
        return (Long) dao.getByHQL(""
                + "SELECT "
                    + "pv.id "
                + "FROM PaymentVoucher pv "
                + "WHERE pv.numeration LIKE ?",numeration);
    }

    @Override
    public List<String> getUsedNumerations(Date min, Date max) {
     return dao.listHQL(""
            + "SELECT "
                + "pv.numeration "
            + "FROM PaymentVoucher pv "
            + "WHERE "
            + "(pv.editDate BETWEEN ? AND ?) ",min,max);
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date init, Date end) {
        return dao.listHQL("" +
                "SELECT " +
                    "pv.numeration," +
                    "pv.dateExpiry," +
                    "pv.value," +
                    "pv.createUser.username," +
                    "pv.createDate," +
                    "e.username," +
                    "pv.editDate," +
                    "pv.active " +
                "FROM PaymentVoucher pv");
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init, Date end, boolean b) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void useVoucher(String code, User user) {
       this.dao.updateHQL(""
                + "UPDATE PaymentVoucher "
                + "SET "
                    + "active = false,"
                    + "editUser = ?,"
                    + "editDate = ? "
                + "WHERE numeration like ?",user,new Date(),code);
    }
}
