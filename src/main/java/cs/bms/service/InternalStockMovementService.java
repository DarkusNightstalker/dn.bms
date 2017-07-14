package cs.bms.service;

import cs.bms.dao.interfac.IInternalStockMovementDao;
import cs.bms.model.InternalStockMovement;
import cs.bms.model.PaymentProof;
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
    public List<Object[]> getCreatedByAfterDate(Date init,Date end, String codeCompany) {
        List<Object[]> data = this.dao.listHQL(""
                + "SELECT "
                    + "ism.targetCompany.code,"
                    + "ism.sourceCompany.code,"
                    + "ism.paymentProof.code,"
                    + "ism.serie,"
                    + "ism.documentNumber,"
                    + "c.identityNumber,"
                    + "ism.dateArrival,"
                    + "ism.dateRealArrival,"   
                    + "ism.dateShipping,"
                    + "ism.driverLicense,"            
                    + "ism.electronic,"
                    + "ism.operationTypeSource.code," 
                    + "ism.operationTypeTarget.code," 
                    + "ism.sent,"  
                    + "ism.transportDescription," 
                    + "ism.uploaded," 
                    + "ism.createUser.username,"
                    + "ism.createDate,"
                    + "e.username,"
                    + "ism.editDate,"
                    + "ism.active,"
                    + "ism.id "
                + "FROM InternalStockMovement ism "
                    + "LEFT JOIN ism.carrier c LEFT JOIN ism.editUser e "
                + "WHERE "
                + "(ism.createDate >= ? AND ism.createDate < ?) AND "
                + "(ism.sourceCompany.code LIKE ? OR "
                + "ism.targetCompany.code LIKE ?)", init,end,codeCompany,codeCompany);
        data.forEach( item ->{
            item[21] = dao.listHQL(""
                    + "SELECT "
                        + "ismd.product.barcode,"
                        + "ismd.uom.code,"
                        + "ismd.productName,"
                        + "ismd.unitCost,"
                        + "ismd.quantity,"
                        + "ismd.weight,"
                        + "uomw.code "
                    + "FROM InternalStockMovementDetail ismd left join ismd.weightUoM uomw WHERE"
                    + "ismd.internalStockMovement.id = ?",item[21]);
        });
        
        return data;
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init,Date end, String codeCompany, boolean b) {
        List<Object[]> data = this.dao.listHQL(""
                + "SELECT "
                    + "ism.targetCompany.code,"
                    + "ism.sourceCompany.code,"
                    + "ism.paymentProof.code,"
                    + "ism.serie,"
                    + "ism.documentNumber,"
                    + "c.identityNumber,"
                    + "ism.dateArrival,"
                    + "ism.dateRealArrival,"   
                    + "ism.dateShipping,"
                    + "ism.driverLicense,"            
                    + "ism.electronic,"
                    + "ism.operationTypeSource.code," 
                    + "ism.operationTypeTarget.code," 
                    + "ism.sent,"  
                    + "ism.transportDescription," 
                    + "ism.uploaded," 
                    + "ism.createUser.username,"
                    + "ism.createDate,"
                    + "e.username,"
                    + "ism.editDate,"
                    + "ism.active,"
                    + "ism.id "
                + "FROM InternalStockMovement ism "
                    + "LEFT JOIN ism.carrier c "
                + "WHERE "
                + "(ism.createDate < ? OR ism.create >= ?) AND "
                + "ism.editDate >= ? AND ism.editDate < ? AND "
                + "(ism.sourceCompany.code LIKE ? OR "
                + "ism.targetCompany.code LIKE ?)", init,end,init,end,codeCompany,codeCompany);
         data.forEach( item ->{
            item[21] = dao.listHQL(""
                    + "SELECT "
                        + "ismd.product.barcode,"
                        + "ismd.uom.code,"
                        + "ismd.productName,"
                        + "ismd.unitCost,"
                        + "ismd.quantity,"
                        + "ismd.weight,"
                        + "uomw.code "
                    + "FROM InternalStockMovementDetail ismd left join ismd.weightUoM uomw WHERE"
                    + "ismd.internalStockMovement.id = ?",item[21]);
        });
        
        return data;
    }

    @Override
    public Long countNotUploaded() {
        return (Long) dao.getByHQL("SELECT COUNT(ism.id) FROM InternalStockMovement ism WHERE ism.uploaded = false");    
    }

    @Override
    public void completeUploaded() {
        dao.updateHQL("UPDATE InternalStockMovement ism SET ism.uploaded = ? WHERE ism.uploaded = ?",true,false);
    }

    @Override
    public Long getIdByFullDocument(PaymentProof paymentProof, String serie, String documentNumber) {
        return (Long) dao.getByHQL(""
                + "SELECT "
                + "ism.id "
                + "FROM InternalStockMovement ism "
                + "WHERE "
                + "ism.paymentProof = ? AND "
                + "ism.serie LIKE ? AND "
                + "ism.documentNumber LIKE ?",paymentProof,serie,documentNumber);
    }
}
