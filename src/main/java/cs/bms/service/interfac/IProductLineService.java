package cs.bms.service.interfac;

import cs.bms.model.ProductLine;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.List;

public interface IProductLineService extends IGenericService<ProductLine, Integer> {

    public boolean existPath(String paramString, Integer paramInteger);

    public List<Object[]> getBasicData();

    public Integer getIdByName(String name);
}
