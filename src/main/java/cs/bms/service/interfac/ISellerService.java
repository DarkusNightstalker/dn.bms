package cs.bms.service.interfac;

import cs.bms.model.Actor;
import cs.bms.model.Product;
import cs.bms.model.Seller;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.List;

public interface ISellerService extends IGenericService<Seller, Long> {

    public List<Long> getIdsByProduct(Product paramProduct);

    public Seller getByDescSupplier(String paramString, Actor paramActor);

    public Seller getByDefaulSupplier(Actor paramActor);
}
