package cs.bms.service;

import cs.bms.dao.interfac.ISellerDao;
import cs.bms.model.Actor;
import cs.bms.model.Product;
import cs.bms.model.Seller;
import cs.bms.service.interfac.ISellerService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SellerService extends GenericService<Seller, Long>   implements ISellerService {

    @Autowired
    @Qualifier("sellerDao")
    private ISellerDao dao;

    @Override
    protected IGenericDao<Seller, Long> getBasicDao() {
        return this.dao;
    }

    @Override
    public List<Long> getIdsByProduct(Product product) {
        return this.dao.listHQL(""
                + "SELECT "
                + "s.id "
                + "FROM Seller s "
                    + "join s.products p "
                + "WHERE p.id = ?",product.getId() == null ? -1L : product.getId());
    }

    @Override
    public Seller getByDescSupplier(String description, Actor actor) {
        return (Seller) this.dao.getByHQL("FROM Seller s WHERE UPPER(s.description) LIKE UPPER(?) AND s.supplier = ?", new Object[]{description, actor});
    }

    @Override
    public Seller getByDefaulSupplier(Actor actor) {
        return (Seller) this.dao.getByHQL("FROM Seller s WHERE s.default_ = true AND s.supplier = ?", new Object[]{actor});
    }

    @Override
    public Long getIdByBasicData(String supplierIdentityNumber, String description, boolean default_) {
        return (Long) dao.getByHQL(""
                + "SELECT "
                    + "s.id "
                + "FROM Seller s "
                + "WHERE "
                    + "s.supplier.identityNumber LIKE ? AND "
                    + "s.description LIKE ? AND "
                    + "s.default_ = ? ",supplierIdentityNumber,description,default_);
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date init, Date end) {
        return dao.listHQL("" +
                "SELECT " +
                    "s.supplier.identityNumber," +
                    "s.actor.identityNumber," +
                    "s,description," +
                    "s.default_," +
                    "s.id," +
                    "s.createUser.username," +
                    "s.createDate," +
                    "e.username," +
                    "s.editDate " +
                "FROM Seller s " +
                    "LEFT JOIN s.editUser e" +
                "WHERE " +
                    "s.createDate >= ? AND " +
                    "s.createDate < ?", init,end);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init, Date end, boolean b) {
        return dao.listHQL("" +
                "SELECT " +
                    "s.supplier.identityNumber," +
                    "s.actor.identityNumber," +
                    "s,description," +
                    "s.default_," +
                    "s.id," +
                    "s.createUser.username," +
                    "s.createDate," +
                    "e.username," +
                    "s.editDate " +
                "FROM Seller s " +
                "LEFT JOIN s.editUser e" +
                "WHERE " +
                    "(s.createDate < ? OR s.createDate >= ?) AND " +
                    "s.editDate >= ? AND s.editDate < ?", init, end,init,end);
    }
}
