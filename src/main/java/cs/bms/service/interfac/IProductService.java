package cs.bms.service.interfac;

import cs.bms.model.Product;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface IProductService extends IGenericService<Product, Long> {

    public boolean existBarCode(String paramString, Long paramLong);

    public Product getByBarcode(String paramString);

    public Object[] getAuditoryData(Long paramLong);

    public List<Object[]> getSuppliersBasicData(Long paramLong);

    public List<Object[]> getSellersBasicData(Long paramLong);

    public List<String> getAllBarcodes();

    public List<Object[]> getCreatedByAfterDate(Date paramDate);

    public List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);

    public List<Object[]> forAutocomplete(Integer quantity, String query);
}
