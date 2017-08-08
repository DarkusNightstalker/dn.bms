package cs.bms.service;

import cs.bms.dao.interfac.IWorkShiftDao;
import cs.bms.model.Company;
import cs.bms.model.WorkShift;
import cs.bms.service.interfac.IWorkShiftService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WorkShiftService extends GenericService<WorkShift, Integer> implements IWorkShiftService {

    @Autowired
    @Qualifier("workShiftDao")
    private IWorkShiftDao dao;

    @Override
    protected IGenericDao<WorkShift, Integer> getBasicDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getFreeBasicDataByCompany(Date date, Company company) {
        return this.dao.listHQL("SELECT ws.id,ws.name,ws.timeEntry FROM WorkShift ws WHERE ws.active = true AND ws.company = ? AND ws.id not in (SELECT cr.workShift.id FROM CashRegister cr WHERE cr.dateArcing = ?) ORDER by ws.timeEntry", new Object[]{company, date});
    }

    @Override
    public List<Object[]> getBasicDataByCompany(Company company) {
        return this.dao.listHQL("SELECT ws.id,ws.name,ws.timeEntry FROM WorkShift ws WHERE ws.active = true AND ws.company = ? ORDER by ws.timeEntry", new Object[]{company});
    }

    @Override
    public Integer getIdByCompanyName(Company company, String name) {
        return (Integer) dao.getByHQL(""
                + "SELECT "
                    + "ws.id "
                + "FROM WorkShift ws "
                + "WHERE "
                    + "ws.company = ? AND "
                    + "ws.name LIKE ?", company, name);
    }
}
