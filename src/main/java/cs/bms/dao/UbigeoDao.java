/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.bms.dao;

import cs.bms.dao.interfac.IUbigeoDao;
import cs.bms.model.Ubigeo;
import gkfire.hibernate.generic.GenericDao;

/**
 *
 * @author Darkus Nightmare
 */
public class UbigeoDao extends GenericDao<Ubigeo, Integer> implements IUbigeoDao {

    @Override
    public void saveOrUpdate(Ubigeo object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer save(Ubigeo object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Ubigeo object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Ubigeo object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int updateHQL(String hql) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int updateHQL(String hql, Object... parameters) {
        throw new UnsupportedOperationException();
    }
}
