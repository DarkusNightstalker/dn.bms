package cs.bms.dao;

import cs.bms.dao.interfac.IDataCompanyDao;
import cs.bms.model.DataCompany;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class DataCompanyDao extends GenericDao<DataCompany, Integer> implements IDataCompanyDao {
}
