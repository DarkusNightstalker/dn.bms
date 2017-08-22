package cs.bms.service.interfac;

import cs.bms.model.User;
import gkfire.auditory.AuditoryEntity;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Darkus Nightmare
 * @version 1.0
 */
public interface IUserService extends IGenericService<User, Integer> {

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public User login(String username, String password) throws Exception;

    /**
     *
     * @param username
     * @param exception
     * @return
     */
    public boolean existUsername(String username, Integer exception);

    /**
     *
     * @param class_
     * @param id
     * @return
     */
    public String getCreatorUsername(Class class_, Serializable id);

    /**
     *
     * @param class_
     * @param id
     * @return
     */
    public User getCreator(Class class_, Serializable id);

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public boolean verifyAuthenthication(String username, String password) throws Exception;

    /**
     *
     * @param init
     * @param companyCode
     * @param end
     * @return
     */
    public List<Object[]> getCreateByAfterDate(Date init,Date end, String companyCode);

    /**
     *
     * @param init
     * @param end
     * @param companyCode
     * @param b
     * @return
     */
    public List<Object[]> getEditedByAfterDate(Date init,Date end, String companyCode, boolean b);

    /**
     *
     * @param username
     * @param password
     * @param codePermission
     * @return
     */
    public boolean authorize(String username,String password, String codePermission) throws Exception;

    public Object[] getCreatedBasicData(AuditoryEntity entity);

    public Integer getIdByUsername(String username);

    public boolean havePermissionInCompany(String codeLocalCompany,User user);

    public User getByUsername(String system);

}
