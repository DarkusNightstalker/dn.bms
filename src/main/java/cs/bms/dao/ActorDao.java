package cs.bms.dao;

import cs.bms.dao.interfac.IActorDao;
import cs.bms.model.Actor;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class ActorDao
        extends GenericDao<Actor, Long>
        implements IActorDao {
}


