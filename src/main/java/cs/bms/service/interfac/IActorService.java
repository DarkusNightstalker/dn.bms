package cs.bms.service.interfac;

import cs.bms.model.Actor;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Darkus Nightmare
 */
public abstract interface IActorService extends IGenericService<Actor, Long> {

    /**
     *
     * @param identityNumber
     * @param name
     */
    public abstract void updateNameByIdentityDocument(String identityNumber, String name);

    /**
     *
     * @param identityDocumentCodes
     * @return
     */
    public abstract List<Object[]> getIdentityDataForSynchro(String... identityDocumentCodes);

    /**
     *
     * @param identityDocumentCodes
     * @return
     */
    public abstract Long countIdentityDataForSynchro(String... identityDocumentCodes);

    /**
     *
     * @param identityNumber
     * @return
     */
    public abstract Actor getByIdentityNumber(String identityNumber);

    /**
     *
     * @param identityNumber
     * @param id
     * @return
     */
    public abstract boolean verifyIdentityNumber(String identityNumber, Long id);

    /**
     *
     * @param date
     * @return
     */
    public abstract List<Object[]> getCreatedByAfterDate(Date date);

    /**
     *
     * @param date
     * @param withRecentlyCreated
     * @return
     */
    public abstract List<Object[]> getEditedByAfterDate(Date date, boolean withRecentlyCreated);

    /**
     *
     * @param id
     * @param points
     * @param user
     */
    public abstract void subtractPoints(Long id, Long points, User user);

    /**
     *
     * @param id
     * @param points
     * @param user
     */
    public abstract void addPoints(Long id, Long points, User user);

    /**
     *
     * @param identityNumber
     * @return
     */
    public abstract Long getIdByIdentityNumber(String identityNumber);

    /**
     *
     * @param quantity
     * @param query
     * @return
     */
    public List<Object[]> forAutocomplete(Integer quantity,String query);

    /**
     *
     * @param quantity
     * @param query
     * @return
     */
    public List<Object[]> forSupplierAutocomplete(Integer quantity,String query);
    
    public Long countNotUploaded();

    public void completeUploaded();
}
