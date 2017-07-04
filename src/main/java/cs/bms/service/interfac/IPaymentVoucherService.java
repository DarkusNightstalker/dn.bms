package cs.bms.service.interfac;

import cs.bms.model.CashRegister;
import cs.bms.model.Company;
import cs.bms.model.PaymentVoucher;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

/**
 * Interfaz SERVICE  para el modelo PAYMENT VOUCHER
 * 
 * @author Darkus Nightmare
 * @version 1.0
 */
public interface IPaymentVoucherService extends IGenericService<PaymentVoucher, Long> {

    /**
     * @deprecated 
     * Obtiene los datos de los vouchers registrados en un cierre de caja especifico
     * @param cashRegister
     * @return
     */
    public List<Object[]> getBasicDataByCashRegister(CashRegister cashRegister);

    /**
     * Obtiene el siguiente numero correlacional de los vales de consumo en base a un caracter prefijo
     * @param prefix el caracter prefijo
     * @return el siguiente numero correlativo
     */
    public Long getNextNumerationByPrefix(String prefix);

    /**
     * Verifica si el codigo le pertenece a un vale de consumo ha sido ya canjeado 
     * 
     * @param code codigo de vale de consumo
     * @return 
     * <code>true</code> - si el vale de consumo existe y no fue consumido<br/>
     * <code>false</code> - si el vale de consumo no existe o fue consumido
     */
    public boolean verifyNumeration(String code);

    /**
     * Verifica si el codigo le pertenece a un vale de consumo existente
     * 
     * @param code codigo de vale de consumo
     * @return 
     * <code>true</code> - si el vale de consumo existe <br/>
     * <code>false</code> - si el vale de consumo no existe 
     */
    public boolean existNumeration(String code);

    /**
     * Obtiene el valor de un vale de consumo en base a su codigo
     * 
     * @param code codigo de vale de consumo
     * @return Devolvera el valor  del vale de consumo ; si no existe , devolvera <code>null</code> 
     */
    public Integer getValueByCode(String code);

    /**
     * Actualiza un vale de consumo indicando que sera usado en una venta determinada
     * 
     * @param code codigo de vale de consumo
     * @param saleId identifiador único de la venta
     * @param user
     */
    public void useVoucher(String code, Long saleId,User user);

    /**
     * Obtiene la suma de todos los valores de los vouchers registrados desde un momento especifico en adelante en una sede
     * 
     * @param date momento en el tiempo desde donde se iniciara <code>PPuede ser nulo</code>
     * @param company
     * @return
     */
    public Integer getTotalSumAfterByCompany(Date date, Company company);
}
