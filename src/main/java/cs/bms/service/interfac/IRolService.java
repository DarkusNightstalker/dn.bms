package cs.bms.service.interfac;

import cs.bms.model.Rol;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IRolService extends IGenericService<Rol, Integer> {

    public boolean existCode(String paramString, Integer paramInteger);

    public List<Object[]> getCreateByAfterDate(Date init, Date end);

    public List<Object[]> getEditedByAfterDate(Date init, Date end, boolean paramBoolean);
}
