package cs.bms.dao;

import cs.bms.dao.interfac.IProductSalePriceDao;
import cs.bms.model.ProductSalePrice;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProductSalePriceDao
        extends GenericDao<ProductSalePrice, Long>
        implements IProductSalePriceDao {
}
