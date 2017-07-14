package cs.bms.service;

import cs.bms.dao.interfac.IPaymentProofDao;
import cs.bms.model.PaymentProof;
import cs.bms.service.interfac.IPaymentProofService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentProofService extends GenericService<PaymentProof, Short> implements IPaymentProofService {

    @Autowired
    @Qualifier("paymentProofDao")
    private IPaymentProofDao dao;

    @Override
    public boolean existCode(String code, Short id) {
        return this.dao.existCode(code, id);
    }

    @Override
    protected IGenericDao<PaymentProof, Short> getDao() {
        return this.dao;
    }

    @Override
    public Short getIdByAbbr(String abbr) {
        return this.dao.getIdByAbbr(abbr);
    }

    @Override
    public List<Object[]> getCreateByAfterDate(Date init,Date end) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "pp.code,"
                    + "pp.abbr,"
                    + "pp.name,"
                    + "pp.forSale,"
                    + "pp.forPurchase,"
                    + "pp.forStored,"
                    + "pp.forReturn,"
                    + "pp.active,"
                    + "pp.createUser.username,"
                    + "pp.createDate,"
                    + "e.username,"
                    + "pp.editDate "
                + "FROM PaymentProof pp left join pp.editUser e "
                + "WHERE pp.createDate >= ?  AND pp.createDate < ?", init,end);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init,Date end, boolean b) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "pp.code,"
                    + "pp.abbr,"
                    + "pp.name,"
                    + "pp.forSale,"
                    + "pp.forPurchase,"
                    + "pp.forStored,"
                    + "pp.forReturn,"
                    + "pp.active,"
                    + "pp.createUser.username,"
                    + "pp.createDate,"
                    + "e.username,"
                    + "pp.editDate "
                + "FROM PaymentProof pp left join pp.editUser e "
                + "WHERE "
                    + "(pp.createDate < ? OR pp.createDate >= ?) AND "
                    + "(pp.editDate >= ?  AND pp.editDate < ?)", init, end,init,end);
    }

    @Override
    public Short getIdByCode(String code) {
        return (Short) this.dao.getByHQL(""
                + "SELECT "
                    + "pp.id "
                + "FROM PaymentProof pp "
                + "WHERE pp.code LIKE ?", code);
    }

    @Override
    public List<Object[]> getForReturn() {
        return this.dao.listHQL(""
                + "SELECT "
                    + "pp.id,"
                    + "pp.abbr,"
                    + "pp.name "
                + "FROM PaymentProof pp "
                + "WHERE "
                    + "pp.active = true AND "
                    + "pp.forReturn = true");
    }
}
