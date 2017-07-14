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
    protected IGenericDao<DocumentNumbering, Integer> getDao() {
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
}
