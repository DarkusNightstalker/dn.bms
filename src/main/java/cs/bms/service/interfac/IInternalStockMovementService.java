package cs.bms.service.interfac;

import cs.bms.model.InternalStockMovement;
import cs.bms.model.PaymentProof;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IInternalStockMovementService extends IGenericService<InternalStockMovement, Long> {

    public List<Object[]> getCreatedByAfterDate(Date init,Date end, String paramString);

    public List<Object[]> getEditedByAfterDate(Date init,Date end, String paramString, boolean paramBoolean);

    public Long countNotUploaded();

    public void completeUploaded();

    public Long getIdByFullDocument(PaymentProof paymentProof, String serie, String documentNumber);
}
