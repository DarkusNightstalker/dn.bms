package cs.bms.service.interfac;

import cs.bms.model.Purchase;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.List;
import java.util.Map;

public interface IPurchaseService extends IGenericService<Purchase, Long> {

    public List<Object[]> forAutocomplete(int quantity, String query, Long idSupplier);

    public List<Object[]> getBasicData(Long idSupplier);

    public void clean() throws Exception;

    public Long getIdByDocument(String supplierIdentityNumber, String paymentProofCode, String serie, String documentNumber);

    public List<Map<String, Object>> getForSynchroUpload();

}
