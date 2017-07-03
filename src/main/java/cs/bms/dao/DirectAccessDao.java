/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.bms.dao;

import cs.bms.dao.interfac.IDirectAccessDao;
import cs.bms.model.DirectAccess;
import gkfire.hibernate.generic.GenericDao;

/**
 *
 * @author Darkus Nightmare
 */
public class DirectAccessDao extends GenericDao<DirectAccess, Short> implements IDirectAccessDao {
    
}
