package cs.bms.service;

import cs.bms.dao.interfac.IDocumentNumberingDao;
import cs.bms.model.DocumentNumbering;
import cs.bms.model.User;
import cs.bms.service.interfac.IDocumentNumberingService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DocumentNumberingService extends GenericService<DocumentNumbering, Integer> implements IDocumentNumberingService {

    @Autowired
    @Qualifier("documentNumberingDao")
    private IDocumentNumberingDao dao;

    @Override
    protected IGenericDao<DocumentNumbering, Integer> getBasicDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getDataByUser(User user, String ruc) {
        return this.dao.getDataByUser(user, ruc);
    }

    @Override
    public List<Object[]> getListData() {
        List<Object[]> data = this.dao.listHQL(""
                + "SELECT "
                    + "dn.rucCompany,"
                    + "dn.paymentProof.code,"
                    + "dn.serie,"
                    + "dn.numbering,"
                    + "dn.electronic,"
                    + "dn.id "
                + "FROM DocumentNumbering dn ");
        data.forEach(item ->{
            item[5] =  dao.listHQL("SELECT u.username FROM DocumentNumbering dn join dn.users u WHERE dn.id = ?",item[5]);
        });
        return data;
    }

    /**
     * @param companyCode
     * @return Lista de datos de numeración de documentos <br/>
     * <b>FORMATO : </b><br/>
     * <code>[0]</code>  - <b>Tipo : </b>{@link String}  - Ruc de empresa<br/>
     * <code>[1]</code>  - <b>Tipo : </b>{@link String}  - Codigo de tipo de comprobante de pago<br/>
     * <code>[2]</code>  - <b>Tipo : </b>{@link String}  - Serie<br/>
     * <code>[3]</code>  - <b>Tipo : </b>{@link Long}    - Numeración actual<br/>
     * <code>[4]</code>  - <b>Tipo : </b>{@link Boolean} - Es electronico<br/>
     * <code>[5]</code>  - <b>Tipo : </b>{@link java.util.List} - Nombres de usuarios enlazados<br/>
     */
    @Override
    public List<Object[]> getForSynchro(String companyCode) {
        List<Object[]> data = this.dao.listHQL(""
                + "SELECT "
                + "dn.rucCompany,"
                + "dn.paymentProof.code,"
                + "dn.serie,"
                + "dn.numbering,"
                + "dn.electronic,"
                + "dn.id "
                + "FROM DocumentNumbering dn WHERE dn.rucCompany IN (SELECT c.ruc FROM Company c WHERE c.code LIKE ?)",companyCode);
        data.forEach(item ->{
            item[5] =  dao.listHQL("SELECT u.username FROM DocumentNumbering dn join dn.users u WHERE dn.id = ?",item[5]);
        });
        return data;
    }

    @Override
    public Integer getIdByBasicData(String rucCompany, String paymentProofCode, String serie) {
        return (Integer) dao.getByHQL("SELECT dn.id FROM DocumentNumbering dn WHERE dn.rucCompany LIKE ? AND dn.paymentProof.code LIKE ? AND dn.serie LIKE ?",rucCompany,paymentProofCode,serie);
    }
}
