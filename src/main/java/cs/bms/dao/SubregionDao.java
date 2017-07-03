package cs.bms.dao;

import cs.bms.dao.interfac.ISubregionDao;
import cs.bms.model.Subregion;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class SubregionDao extends GenericDao<Subregion, Integer> implements ISubregionDao {
}
