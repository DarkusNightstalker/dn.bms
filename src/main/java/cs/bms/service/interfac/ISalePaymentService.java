package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.SalePayment;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Interfaz SERVICE para el modelo SALE PAYMENT
 *
 * @author Darkus Nightmare
 * @version 1.0
 */
public interface ISalePaymentService extends IGenericService<SalePayment, Long> {

    /**
     * Obtiene la sumatoria de todas las ventas al contado sin <code>VISA</code>
     * de una sede especifica, a partir de un momento determinado en adelante.
     * De no dar la fecha sumara todos los montos
     *
     * @param date Momento desde el cual se tomara en cuenta
     * <code>(Puede ser nulo)</code>
     * @param company Sede
     * @return monto total de ventas al contado
     *
     */
    public BigDecimal getCashAfterByCompany(Date date, Company company);

    /**
     * Obtiene la sumatoria de todas las ventas al credito de una sede
     * especifica, a partir de un momento determinado en adelante. De no dar la
     * fecha sumara todos los montos
     *
     * @param date Momento desde el cual se tomara en cuenta
     * <code>(Puede ser nulo)</code>
     * @param company Sede
     * @return monto total de ventas al contado
     */
    public BigDecimal getCreditAfterByCompany(Date date, Company company);
}
