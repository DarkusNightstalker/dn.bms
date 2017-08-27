package cs.bms.service.interfac;

import cs.bms.model.Actor;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Darkus Nightmare
 */
public  interface IActorService extends IGenericService<Actor, Long> {

    /**
     *
     * @param identityNumber
     * @param name
     */
    public void updateNameByIdentityDocument(String identityNumber, String name);

    /**
     *
     * @param identityDocumentCodes
     * @return
     */
    public List<Object[]> getIdentityDataForSynchro(String... identityDocumentCodes);

    /**
     *
     * @param identityDocumentCodes
     * @return
     */
    public Long countIdentityDataForSynchro(String... identityDocumentCodes);

    /**
     *
     * @param identityNumber
     * @return
     */
    public Actor getByIdentityNumber(String identityNumber);

    /**
     *
     * @param identityNumber
     * @param id
     * @return
     */
    public boolean verifyIdentityNumber(String identityNumber, Long id);

    /**
     *
     * @param init
     * @param end
     * @return
     */
    public List<Object[]> getCreatedByAfterDate(Date init,Date end);

    /**
     *
     * @param init
     * @param end
     * @param withRecentlyCreated
     * @return
     */
    public List<Object[]> getEditedByAfterDate(Date init,Date end, boolean withRecentlyCreated);

    /**
     *
     * @param id
     * @param points
     * @param user
     */
    public void subtractPoints(Long id, Long points, User user);

    /**
     *
     * @param id
     * @param points
     * @param user
     */
    public void addPoints(Long id, Long points, User user);
    
    /**
     *
     * @param identityNumber
     * @param points
     * @param user
     */
    public void addPoints(String identityNumber, Long points, User user);

    /**
     *
     * @param identityNumber
     * @return
     */
    public Long getIdByIdentityNumber(String identityNumber);

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

    public List<Object[]> getDataWhenNotUploaded();

    public List<Map<String, Object>> getForSynchroUpload();


}
