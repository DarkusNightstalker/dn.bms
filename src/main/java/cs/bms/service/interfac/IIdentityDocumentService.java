package cs.bms.service.interfac;

import cs.bms.model.IdentityDocument;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IIdentityDocumentService extends IGenericService<IdentityDocument, Short> {

    /**
     *
     * @param paramString
     * @param paramShort
     * @return
     */
    public boolean validCode(String paramString, Short paramShort);

    public List<Object[]> getBasicData();

    public Short getIdByLength(int paramInt);

    public List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);

    public List<Object[]> getCreateByAfterDate(Date paramDate);

    public Short getIdByCode(String string);
}
