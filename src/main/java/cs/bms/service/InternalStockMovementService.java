package cs.bms.service;

import cs.bms.dao.interfac.IInternalStockMovementDao;
import cs.bms.model.InternalStockMovement;
import cs.bms.service.interfac.IInternalStockMovementService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InternalStockMovementService extends GenericService<InternalStockMovement, Long> implements IInternalStockMovementService {

    @Autowired
    @Qualifier("internalStockMovementDao")
    private IInternalStockMovementDao dao;

    @Override
    protected IGenericDao<InternalStockMovement, Long> getDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date date, String codeCompany) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "ism.id,"
                    + "ism.paymentProof.id,"
                    + "ism.paymentProof.code,"
                    + "ism.serie,"
                    + "ism.documentNumber,"
                    + "ism.sourceCompany.id,"
                    + "ism.sourceCompany.code,"
                    + "ism.targetCompany.id,"
                    + "ism.targetCompany.code,"
                    + "c.id,"
                    + "c.identityNumber,"
                    + "ism.dateArrival,"
                    + "ism.dateShipping,"
                    + "ism.transportDescription,"
                    + "ism.driverLicense,"             
                    + "ism.electronic,"
                    + "ism.dateRealArrival,"   
                    + "ism.sent,"  
                    + "ism.operationTypeSource.id,"  
                    + "ism.operationTypeSource.code," 
                    + "ism.operationTypeTarget.id,"  
                    + "ism.operationTypeTarget.code," 
                    + "ism.active,"
                    + "ism.createUser.id,"
                    + "ism.createDate,"
                    + "ism.id "
                + "FROM InternalStockMovement ism "
                    + "LEFT JOIN ism.carrier c "
                + "WHERE "
                + "ism.createDate > ? AND "
                + "(ism.sourceCompany.code LIKE ? OR "
                + "ism.targetCompany.code LIKE ?)", date,codeCompany,codeCompany);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date date, String codeCompany, boolean b) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "ism.id,"
                    + "ism.paymentProof.id,"
                    + "ism.paymentProof.code,"
                    + "ism.serie,"
                    + "ism.documentNumber,"
                    + "ism.sourceCompany.id,"
                    + "ism.sourceCompany.code,"
                    + "ism.targetCompany.id,"
                    + "ism.targetCompany.code,"
                    + "c.id,"
                    + "c.identityNumber,"
                    + "ism.dateArrival,"
                    + "ism.dateShipping,"
                    + "ism.transportDescription,"
                    + "ism.driverLicense,"             
                    + "ism.electronic,"
                    + "ism.dateRealArrival,"   
                    + "ism.sent,"  
                    + "ism.operationTypeSource.id,"  
                    + "ism.operationTypeSource.code," 
                    + "ism.operationTypeTarget.id,"  
                    + "ism.operationTypeTarget.code," 
                    + "ism.active,"
                    + "ism.createUser.id,"
                    + "ism.createDate,"
                    + "ism.id "
                + "FROM InternalStockMovement ism "
                    + "LEFT JOIN ism.carrier c "
                + "WHERE "
                + "ism.createDate < ? AND "
                + "ism.editDate > ? AND "
                + "(ism.sourceCompany.code LIKE ? OR "
                + "ism.targetCompany.code LIKE ?)", date,date,codeCompany,codeCompany);
    }

    @Override
    public Long countNotUploaded() {
        return (Long) dao.getByHQL("SELECT COUNT(ism.id) FROM InternalStockMovement ism WHERE ism.uploaded = false");    
    }

    @Override
    public void completeUploaded() {
        dao.updateHQL("UPDATE InternalStockMovement ism SET ism.uploaded = ? WHERE ism.uploaded = ?",true,false);
    }
}
