package cs.bms.service;

import cs.bms.dao.interfac.IStockTypeDao;
import cs.bms.model.StockType;
import cs.bms.service.interfac.IStockTypeService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StockTypeService extends GenericService<StockType, Short> implements IStockTypeService {

    @Autowired
    @Qualifier("stockTypeDao")
    private IStockTypeDao dao;

    @Override
    protected IGenericDao<StockType, Short> getBasicDao() {
        return this.dao;
    }

    /**
     *
     * @param code
     * @return
     */
    @Override
    public StockType getByCode(String code) {
        return (StockType) this.dao.getByHQL(""
                + "FROM StockType st "
                + "WHERE st.code LIKE ?", code);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Object[]> getBasicData() {
        return this.dao.listHQL(""
                + "SELECT "
                    + "st.id,"
                    + "st.name "
                + "FROM StockType st "
                + "WHERE st.active = true");
    }

    /**
     *
     * @param code
     * @return
     */
    @Override
    public Short getIdByCode(String code) {
        return (Short) this.dao.getByHQL(""
                + "SELECT "
                    + "st.id "
                + "FROM StockType st "
                + "WHERE st.code LIKE ?", code);
    }
    
    @Override
    public List<Object[]> getCreatedByAfterDate(Date init,Date end) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "stt.code,"
                    + "stt.name,"
                    + "stt.createUser.username,"
                    + "stt.createDate,"
                    + "e.username,"
                    + "stt.editDate,"
                    + "stt.active "
                + "FROM StockType stt left join stt.editUser e "
                + "WHERE "
                    + "stt.createDate >= ? AND stt.createDate < ? "
                + "ORDER BY stt.createDate", init,end);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init,Date end, boolean b) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "stt.code,"
                    + "stt.name,"
                    + "stt.createUser.username,"
                    + "stt.createDate,"
                    + "e.username,"
                    + "stt.editDate,"
                    + "stt.active "
                + "FROM StockType stt left join stt.editUser e "
                + "WHERE "
                    + "(stt.editDate >= ? AND stt.editDate < ?) AND "
                    + "(stt.createDate < ? OR stt.createDate >= ?) "
                + "ORDER BY stt.editDate", init,end,init,end);
    }
}
