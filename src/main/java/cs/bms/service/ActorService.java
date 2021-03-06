package cs.bms.service;

import cs.bms.dao.interfac.IActorDao;
import cs.bms.model.Actor;
import cs.bms.model.User;
import cs.bms.service.interfac.IActorService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Darkus Nightmare
 */
@Service
public class ActorService extends GenericService<Actor, Long> implements IActorService {

    @Autowired
    @Qualifier("actorDao")
    private IActorDao dao;


    @Override
    protected IGenericDao<Actor, Long> getBasicDao() {
        return this.dao;
    }

    @Override
    public void updateNameByIdentityDocument(String identityNumber, String name) {
        this.dao.updateHQL(""
                + "UPDATE Actor "
                + "SET "
                    + "name = ?,"
                    + "synchronized_ = true "
                + "WHERE identityNumber LIKE ?", name, identityNumber);
    }

    @Override
    public List<Object[]> getIdentityDataForSynchro(String... identityDocumentCodes) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "a.identityNumber,"
                    + "a.identityDocument.code "
                + "FROM Actor a "
                + "WHERE "
                    + "a.synchronized_ = false AND "
                    + "a.identityDocument.code IN (:codes)", new String[]{"codes"},Arrays.asList(identityDocumentCodes));
    }

    @Override
    public Long countIdentityDataForSynchro(String... identityDocumentCodes) {
        return (Long) this.dao.getByHQL(""
                + "SELECT "
                    + "COUNT(*) "
                + "FROM Actor a "
                + "WHERE "
                    + "a.synchronized_ = false AND "
                    + "a.identityDocument.code IN (:codes)", new String[]{"codes"},Arrays.asList(identityDocumentCodes));
    }

    @Override
    public Actor getByIdentityNumber(String identityNumber) {
        return (Actor) this.dao.getByHQL(""
                + "FROM Actor a "
                + "WHERE a.identityNumber Like ?", new Object[]{identityNumber});
    }

    @Override
    public boolean verifyIdentityNumber(String identityNumber, Long id) {
        return this.dao.getByHQL(""
                + "SELECT "
                    + "1 "
                + "FROM Actor a "
                + "WHERE "
                    + "a.identityNumber LIKE ? AND "
                    + "a.id <> ?", identityNumber, id == null ? -1L : id) != null;
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date init,Date end) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "a.identityDocument.code,"
                    + "a.identityNumber,"
                    + "a.name,"
                    + "a.other,"
                    + "a.address,"
                    + "a.customer,"
                    + "a.supplier,"
                    + "a.points,"
                    + "a.representative,"
                    + "a.synchronized_,"
                    + "u.name,"
                    + "a.createUser.username,"
                    + "a.createDate,"
                    + "e.username,"
                    + "a.editDate,"
                    + "a.active "
                + "FROM Actor a "
                    + "left join a.ubigeo u "
                    + "left join a.editUser e "
                + "WHERE a.createDate >= ? AND a.createDate < ?", init,end);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init,Date end, boolean withRecentlyCreated) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "a.identityDocument.code,"
                    + "a.identityNumber,"
                    + "a.name,"
                    + "a.other,"
                    + "a.address,"
                    + "a.customer,"
                    + "a.supplier,"
                    + "a.points,"
                    + "a.representative,"
                    + "a.synchronized_,"
                    + "u.name,"
                    + "a.createUser.username,"
                    + "a.createDate,"
                    + "e.username,"
                    + "a.editDate,"
                    + "a.active "
                + "FROM Actor a "
                    + "left join a.ubigeo u "
                    + "left join a.editUser e "
                + "WHERE "
                    + "(a.createDate < ? OR a.createDate >= ?) AND "
                    + "a.editDate >= ? AND a.editDate < ?", init, end,init,end);
    }

    @Override
    public void subtractPoints(Long id, Long points, User user) {
        this.dao.updateHQL(""
                + "UPDATE Actor a "
                + "SET "
                    + "points = (points - ?),"
                    + "editDate = ?,"
                    + "editUser = ? "
                + "WHERE id = ?", points, new Date(), user, id);
    }

    @Override
    public void addPoints(Long id, Long points, User user) {
        this.dao.updateHQL(""
                + "UPDATE Actor a "
                + "SET "
                    + "points = (points + ?),"
                    + "editDate = ?,"
                    + "editUser = ? "
                + "WHERE id = ?", points, new Date(), user, id);
    }

    @Override
    public Long getIdByIdentityNumber(String identityNumber) {
        return (Long) this.dao.getByHQL(""
                + "SELECT "
                    + "a.id "
                + "FROM Actor a "
                + "WHERE a.identityNumber LIKE ?",identityNumber);
    }

    @Override
    public List<Object[]> forAutocomplete(Integer quantity,String query) {
        return dao.listHQLPage(""
                + "SELECT "
                    + "a.id,"
                    + "a.identityDocument.abbr,"
                    + "a.identityNumber,"
                    + "COALESCE(a.other,a.name),"
                    + "a.points "
                + "FROM Actor a "
                + "WHERE "
                    + "LOWER(COALESCE(a.other,a.name)) LIKE LOWER(?) OR "
                    + "a.identityNumber LIKE ?", 1, quantity, "%"+query+"%","%"+query+"%");
    }

    @Override
    public List<Object[]> forSupplierAutocomplete(Integer quantity, String query) {
        return dao.listHQLPage(""
                + "SELECT "
                    + "a.id,"
                    + "a.identityDocument.abbr,"
                    + "a.identityNumber,"
                    + "COALESCE(a.other,a.name),"
                    + "u.name,"
                    + "a.address  "
                + "FROM Actor a left join a.ubigeo u "
                + "WHERE "
                + "a.supplier = true AND "
                + "("
                    + "LOWER(COALESCE(a.other,a.name)) LIKE LOWER(?) OR "
                    + "a.identityNumber LIKE ?"
                + ")", 1, quantity, "%"+query+"%","%"+query+"%");
    }

    @Override
    public Long countNotUploaded() {
        return (Long) dao.getByHQL("SELECT COUNT(a.id) FROM Actor a WHERE a.uploaded = false");
    }

    @Override
    public void completeUploaded(Date date) {
        dao.updateHQL("UPDATE Actor a SET a.uploaded = ? WHERE ((a.createDate >=  ? AND a.createDate < ?) OR (a.editDate >= ? AND a.editDate < ?))",true,date,date,date,date);
    }

    @Override
    public List<Map<String, Object>> getDataWhenNotUploaded(Date init, Date end,boolean onlyCreated) {
        return onlyCreated ? dao.listHQL(""
                + "SELECT "
                + "new map("
                    + "a.identityDocument.code as identityDocumentCode,"
                    + "a.identityNumber as identityNumber,"
                    + "a.name as name,"
                    + "a.other as other,"
                    + "a.address as address,"
                    + "a.customer as customer,"
                    + "a.supplier as supplier,"
                    + "a.points as points,"
                    + "a.representative as representative,"
                    + "a.synchronized_ as synchronized,"
                    + "u.name as ubigeoName,"
                    + "a.createUser.username as createUsername,"
                    + "a.createDate as createDate,"
                    + "e.username as editUsername,"
                    + "a.editDate as editDate,"
                    + "a.active as active"
                + ") "
                + "FROM Actor a "
                    + "left join a.ubigeo u "
                    + "left join a.editUser e "
                + "WHERE a.uploaded = false AND " +
                "(a.createDate >=  ? AND a.createDate < ?)",init,end)
                :
                dao.listHQL(""
                + "SELECT "
                + "new map("
                    + "a.identityDocument.code as identityDocumentCode,"
                    + "a.identityNumber as identityNumber,"
                    + "a.name as name,"
                    + "a.other as other,"
                    + "a.address as address,"
                    + "a.customer as customer,"
                    + "a.supplier as supplier,"
                    + "a.points as points,"
                    + "a.representative as representative,"
                    + "a.synchronized_ as synchronized,"
                    + "u.name as ubigeoName,"
                    + "a.createUser.username as createUsername,"
                    + "a.createDate as createDate,"
                    + "e.username as editUsername,"
                    + "a.editDate as editDate,"
                    + "a.active as active"
                + ") "
                + "FROM Actor a "
                    + "left join a.ubigeo u "
                    + "left join a.editUser e "
                + "WHERE a.uploaded = false AND " +
                "((a.createDate >=  ? AND a.createDate < ?) OR " +
                "(a.editDate >= ? AND a.editDate < ?))",init,end,init,end);
    }

    @Override
    public void addPoints(String identityNumber, Long points, User user) {
         this.dao.updateHQL(""
                + "UPDATE Actor a "
                + "SET "
                    + "points = (points + ?),"
                    + "editDate = ?,"
                    + "editUser = ? "
                + "WHERE identityNumber = ?", points, new Date(), user, identityNumber);
    }
}
