package cs.bms.service.interfac;

import cs.bms.model.UoM;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IUoMService extends IGenericService<UoM, Integer> {

    public boolean existName(String paramString, Integer paramInteger);

    public boolean existAbbr(String paramString, Integer paramInteger);

    public boolean existCode(String paramString, Integer paramInteger);

    public Integer getIdByCode(String paramString);

    public List<Object[]> getBasicData();

    public List<Object[]> getCreatedByAfterDate(Date init,Date end);

    public List<Object[]> getEditedByAfterDate(Date init,Date end, boolean paramBoolean);

}

