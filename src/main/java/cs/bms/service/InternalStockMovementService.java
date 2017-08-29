package cs.bms.service;

import cs.bms.dao.interfac.IInternalStockMovementDao;
import cs.bms.model.InternalStockMovement;
import cs.bms.model.PaymentProof;
import cs.bms.service.interfac.IInternalStockMovementService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InternalStockMovementService extends GenericService<InternalStockMovement, Long> implements IInternalStockMovementService {

    @Autowired
    @Qualifier("internalStockMovementDao")
    private IInternalStockMovementDao dao;

    @Override
    protected IGenericDao<InternalStockMovement, Long> getBasicDao() {
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
                + "ism.targetCompany.code LIKE ?)"
                , init,end,codeCompany,codeCompany);
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
                    + "LEFT JOIN ism.carrier c LEFT JOIN ism.editUser e "
                + "WHERE "
                + "(ism.createDate < ? OR ism.createDate >= ?) AND "
                + "(ism.editDate >= ? AND ism.editDate < ?) AND "
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
    public void completeUploaded(Date date) {
        dao.updateHQL("UPDATE InternalStockMovement ism SET ism.uploaded = ? WHERE ((ism.createDate >= ? AND ism.createDate < ?) OR (ism.editDate >= ? AND ism.editDate < ?))",true,date,date,date,date);
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

    @Override
    public List<Map<String, Object>> getForSynchroUpload(Date init, Date end, String companyCode) {
          List<Map<String,Object>> data = this.dao.listHQL(""
                + "SELECT "
                  + "new map("
                    + "ism.targetCompany.code as targetCompanyCode,"
                    + "ism.sourceCompany.code as sourceCompanyCode,"
                    + "ism.paymentProof.code as paymentProofCode,"
                    + "ism.serie as serie,"
                    + "ism.documentNumber as documentNumber,"
                    + "c.identityNumber as carrierIdentityNumber,"
                    + "ism.dateArrival as dateArrival,"
                    + "ism.dateRealArrival as dateRealArrival,"   
                    + "ism.dateShipping as dateShopping,"
                    + "ism.driverLicense as driverLicense,"            
                    + "ism.electronic as electronic,"
                    + "ism.operationTypeSource.code as operationTypeSourceCode," 
                    + "ism.operationTypeTarget.code as operationTypeTargetCode," 
                    + "ism.sent as sent,"  
                    + "ism.transportDescription as transportDescription," 
                    + "ism.uploaded as uploaded," 
                    + "ism.createUser.username as createUsername,"
                    + "ism.createDate as createDate,"
                    + "e.username as editUsername,"
                    + "ism.editDate as editDate,"
                    + "ism.active as active,"
                    + "ism.id as details"
                  + ") "
                + "FROM InternalStockMovement ism "
                    + "LEFT JOIN ism.carrier c LEFT JOIN ism.editUser e "
                + "WHERE "
                + "((ism.createDate >= ? AND ism.createDate < ?) OR (ism.editDate >= ? AND ism.editDate < ?)) AND "
                + "(ism.sourceCompany.code LIKE ? OR "
                + "ism.targetCompany.code LIKE ?)", init,end,init,end,companyCode,companyCode);
        data.forEach( item ->{
            item.put("details",dao.listHQL(""
                    + "SELECT "
                    + "new map("
                        + "ismd.product.barcode as productBarcode,"
                        + "ismd.uom.code as uomCode,"
                        + "ismd.productName as productName,"
                        + "ismd.unitCost as unitCost,"
                        + "ismd.quantity as quantity,"
                        + "ismd.weight as weight,"
                        + "uomw.code as uomWeightCode"
                    + ") "
                    + "FROM InternalStockMovementDetail ismd left join ismd.weightUoM uomw WHERE "
                    + "ismd.internalStockMovement.id = ?",item.get("details")));
        });
        
        return data;
    }
}
