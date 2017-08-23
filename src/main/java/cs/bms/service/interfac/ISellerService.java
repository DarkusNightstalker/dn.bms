package cs.bms.service.interfac;

import cs.bms.model.Actor;
import cs.bms.model.Product;
import cs.bms.model.Seller;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public interface ISellerService extends IGenericService<Seller, Long> {

    public List<Long> getIdsByProduct(Product paramProduct);

    public Seller getByDescSupplier(String paramString, Actor paramActor);

    public Seller getByDefaulSupplier(Actor paramActor);

    public Long getIdByBasicData(String supplierIdentityNumber, String description, boolean default_);

    public List<Object[]> getCreatedByAfterDate(Date lastUpdateDate, Date currentDateUpdate);

    public List<Object[]> getEditedByAfterDate(Date lastUpdateDate, Date currentDateUpdate, boolean b);
}
