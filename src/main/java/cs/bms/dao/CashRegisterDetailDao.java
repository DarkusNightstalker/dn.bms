package cs.bms.dao;

import cs.bms.dao.interfac.ICashRegisterDetailDao;
import cs.bms.enumerated.CashType;
import cs.bms.model.CashRegisterDetail;
import gkfire.hibernate.generic.GenericDao;
import java.io.Serializable;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CashRegisterDetailDao extends GenericDao<CashRegisterDetail, Serializable> implements ICashRegisterDetailDao {

    @Override
    public Integer getQuantity(Long cashRegisterId, CashType type) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT crd.quantity FROM CashRegisterDetail crd WHERE crd.cashRegister.id = ? AND crd.cashType = ?");

        query.setLong(0, cashRegisterId == null ? -1L : cashRegisterId);
        query.setParameter(1, type);
        return (Integer) query.uniqueResult();
    }
}
