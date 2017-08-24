package cs.bms.service;

import cs.bms.dao.interfac.IProductLineDao;
import cs.bms.model.ProductLine;
import cs.bms.service.interfac.IProductLineService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductLineService
        extends GenericService<ProductLine, Integer>
        implements IProductLineService {

    @Autowired
    @Qualifier("productLineDao")
    private IProductLineDao dao;

    @Override
    protected IGenericDao<ProductLine, Integer> getBasicDao() {
        return this.dao;
    }

    @Override
    public boolean existPath(String path, Integer exception) {
        return this.dao.existPath(path, exception);
    }

    @Override
    public List<Object[]> getBasicData() {
        return this.dao.listHQL("SELECT pl.id,UPPER(pl.path) FROM ProductLine pl where pl.active = true");
    }

    @Override
    public Integer getIdByName(String name) {
        return (Integer) dao.getByHQL("SELECT pl.id FROM ProductLine pl  WHERE pl.path LIKE ?", name);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init, Date end, boolean b) {
        return dao.listHQL("" +
                "SELECT " +
                    "pl.path," +
                    "pl.name," +
                    "pl.createUser.username," +
                    "pl.createDate," +
                    "e.username," +
                    "pl.editDate " +
                "FROM ProductLine pl LEFT JOIN pl.editUser e "
                    + "WHERE "
                    + "(pl.createDate >= ? AND pl.createDate < ?) ",init,end);
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date init, Date end) {
        return dao.listHQL("" +
                "SELECT " +
                "pl.path," +
                "pl.name," +
                "pl.createUser.username," +
                "pl.createDate," +
                "e.username," +
                "pl.editDate " +
                "FROM ProductLine pl LEFT JOIN pl.editUser e "
                + "WHERE "
                + "(pl.editDate >= ? AND pl.editDate < ?) AND "
                + "(pl.createDate < ? OR pl.createDate >= ?) ",init,end,init,end);
    }
}
