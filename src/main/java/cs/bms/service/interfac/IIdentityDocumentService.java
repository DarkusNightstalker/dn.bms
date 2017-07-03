package cs.bms.service.interfac;

import cs.bms.model.IdentityDocument;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public abstract interface IIdentityDocumentService extends IGenericService<IdentityDocument, Short> {

    /**
     *
     * @param paramString
     * @param paramShort
     * @return
     */
    public abstract boolean validCode(String paramString, Short paramShort);

    public abstract List<Object[]> getBasicData();

    public abstract Short getIdByLength(int paramInt);

    public abstract List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);

    public abstract List<Object[]> getCreateByAfterDate(Date paramDate);
}
