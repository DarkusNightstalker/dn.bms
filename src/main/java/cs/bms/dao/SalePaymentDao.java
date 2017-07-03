package cs.bms.dao;

import cs.bms.dao.interfac.ISalePaymentDao;
import cs.bms.model.SalePayment;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

/**
 * Implementación DAO para el modelo SALE PAYMENT
 * 
 * @author Darkus Nightmare
 * @version 1.0
 */
@Repository
public class SalePaymentDao extends GenericDao<SalePayment, Long> implements ISalePaymentDao {
}
