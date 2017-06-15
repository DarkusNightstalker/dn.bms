package cs.bms.service.interfac;

import cs.bms.model.Actor;
import cs.bms.model.Product;
import cs.bms.model.Seller;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.List;

public abstract interface ISellerService
  extends IGenericService<Seller, Long>
{
  public abstract List<Long> getIdsByProduct(Product paramProduct);
  
  public abstract Seller getByDescSupplier(String paramString, Actor paramActor);
  
  public abstract Seller getByDefaulSupplier(Actor paramActor);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\ISellerService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */