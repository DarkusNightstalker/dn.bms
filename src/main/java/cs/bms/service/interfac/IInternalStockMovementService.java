package cs.bms.service.interfac;

import cs.bms.model.InternalStockMovement;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IInternalStockMovementService extends IGenericService<InternalStockMovement, Long> {

    public List<Object[]> getCreatedByAfterDate(Date paramDate, String paramString);

    public List<Object[]> getEditedByAfterDate(Date paramDate, String paramString, boolean paramBoolean);

    public Long countNotUploaded();

    public void completeUploaded();

}
