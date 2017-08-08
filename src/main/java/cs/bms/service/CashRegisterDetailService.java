package cs.bms.service;

import cs.bms.dao.interfac.ICashRegisterDetailDao;
import cs.bms.enumerated.CashType;
import cs.bms.model.CashRegister;
import cs.bms.model.CashRegisterDetail;
import cs.bms.service.interfac.ICashRegisterDetailService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Implementación SERVICE para el modelo CASH REGISTER DETAIL
 * 
 * @author Darkus Nightmare
 * @version  1.0
 */
@Service
public class CashRegisterDetailService extends GenericService<CashRegisterDetail, Serializable> implements ICashRegisterDetailService {

    @Autowired
    @Qualifier("cashRegisterDetailDao")
    private ICashRegisterDetailDao dao;

    @Override
    protected IGenericDao<CashRegisterDetail, Serializable> getBasicDao() {
        return this.dao;
    }

    @Override
    public Integer getQuantity(Long cashRegisterId, CashType type) {
        return this.dao.getQuantity(cashRegisterId, type);
    }

    @Override
    public Object[] getQuantitiesAsMap(Long id) {
        Map<CashType, Integer> map = new HashMap();
        double total =0;
        for (CashType type : CashType.values()) {
            
            Integer quantity = this.dao.getQuantity(id, type);
            if (quantity == null) {
                quantity = 0;
            }
            map.put(type, quantity);
            total += quantity * type.getValue().doubleValue();
        }
        return new Object[]{map,new BigDecimal(total).setScale(2,RoundingMode.HALF_UP)};
    }

    @Override
    public void deleteBy(CashRegister cashRegister) {
        dao.updateHQL("DELETE FROM CashRegisterDetail crd WHERE crd.cashRegister = ?",cashRegister);
    }
}
