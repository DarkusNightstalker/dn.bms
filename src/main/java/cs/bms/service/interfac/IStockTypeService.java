package cs.bms.service.interfac;

import cs.bms.model.StockType;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IStockTypeService extends IGenericService<StockType, Short> {

    public StockType getByCode(String paramString);

    public List<Object[]> getBasicData();

    public Short getIdByCode(String paramString);

    public List<Object[]> getCreatedByAfterDate(Date init,Date end);

    public List<Object[]> getEditedByAfterDate(Date init,Date end, boolean paramBoolean);
}
