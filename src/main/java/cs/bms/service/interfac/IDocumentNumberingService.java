package cs.bms.service.interfac;

import cs.bms.model.DocumentNumbering;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.List;

/**
 *
 * @author Darkus Nightmare
 */
public abstract interface IDocumentNumberingService extends IGenericService<DocumentNumbering, Integer> {

    /**
     *
     * @param user
     * @param ruc
     * @return
     */
    public abstract List<Object[]> getDataByUser(User user, String ruc);

    /**
     *
     * @return Lista de datos de numeración de documentos <br/>
     *<b>FORMATO : </b><br/>
     * <code>[0]</code>  - <b>Tipo : </b>{@link java.lang.Integer} - Identificador único de registro<br/>
     * <code>[1]</code>  - <b>Tipo : </b>{@link java.lang.Short}   - Identificador de tipo de comprobante de pago<br/>
     * <code>[2]</code>  - <b>Tipo : </b>{@link java.lang.String}  - Ruc de empresa<br/>
     * <code>[3]</code>  - <b>Tipo : </b>{@link java.lang.String}  - Serie<br/>
     * <code>[4]</code>  - <b>Tipo : </b>{@link java.lang.Long}    - Numeración actual<br/>
     * <code>[5]</code>  - <b>Tipo : </b>{@link java.lang.Boolean} - Es electronico<br/>
     */
    public abstract List<Object[]> getListData();
    /**
     *
     * @return Lista de datos de numeración de documentos <br/>
     *<b>FORMATO : </b><br/>
     * <code>[0]</code>  - <b>Tipo : </b>{@link java.lang.Integer} - Identificador único de registro<br/>
     * <code>[1]</code>  - <b>Tipo : </b>{@link java.lang.String}  - Codigo de tipo de comprobante de pago<br/>
     * <code>[2]</code>  - <b>Tipo : </b>{@link java.lang.String}  - Ruc de empresa<br/>
     * <code>[3]</code>  - <b>Tipo : </b>{@link java.lang.String}  - Serie<br/>
     * <code>[4]</code>  - <b>Tipo : </b>{@link java.lang.Long}    - Numeración actual<br/>
     * <code>[5]</code>  - <b>Tipo : </b>{@link java.lang.Boolean} - Es electronico<br/>
     */
    public abstract List<Object[]> getForSynchro(String companyCode);

    public Integer getIdByBasicData(String rucCompany, String paymentProofCode, String serie);
}
