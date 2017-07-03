package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Sale;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaz SERVICE para el modelo SALE
 * @author Darkus Nightmare
 * @version 1.0
 */
public interface ISaleService extends IGenericService<Sale, Long> {

    /**
     * Obtiene las ventas no verificadas de una sede en especifico y que no se tenga los identificadores señalados
     * @param company Sede 
     * @param exceptions Identificadores a no tomar en cuenta
     * @return Lista de datos de las ventas no verificadas <br/>
     *<b>FORMATO : </b><br/>
     * <code>[0]</code> - Identificador único de registro<br/>
     * <code>[1]</code> - Fecha de emisión<br/>
     * <code>[2]</code> - Tipo,serie y numero de comprobante de pago<br/>
     * <code>[3]</code> - Nombre del cliente<br/>
     * <code>[4]</code> - Total de la venta<br/>
     */
    public abstract List<Object[]> getNotVerifySales(Company company, List<Long> exceptions);

    /**
     * Ratifica una venta en caja y especifica si fue al credito o al contado
     * 
     * @param id el identificador único del registro
     * @param credit si la venta fue al crédito
     */
    public abstract void verified(Long id,boolean credit);

    /**
     * Actualiza unicamente los puntos de una venta en base a su identificador único
     * 
     * @param points los nuevos puntos generados de la venta
     * @param id identificador unico del registro
     */
    public abstract void updatePoints(Long points, Long id);

    /**
     * Actualiza unicamente el descuento de una venta en base a su identificador único
     * 
     * @param discount el nuevo descuento de la venta
     * @param id identificador univo del registro
     */
    public abstract void updateDiscount(BigDecimal discount, Long id);

    /**
     *
     * @param points
     * @param id
     */
    public void subtractCustomerPointsDiscount(long points, Long id);

    public void clean() throws Exception;

}
