package cs.bms.service.interfac;

import cs.bms.model.ProductLine;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IProductLineService extends IGenericService<ProductLine, Integer> {

    public boolean existPath(String paramString, Integer paramInteger);

    public List<Object[]> getBasicData();

    public Integer getIdByName(String name);

    public List<Object[]> getEditedByAfterDate(Date init, Date end, boolean b);

    public List<Object[]> getCreatedByAfterDate(Date init, Date end);
}
