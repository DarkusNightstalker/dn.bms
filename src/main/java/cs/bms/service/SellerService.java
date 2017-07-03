/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.ISellerDao;
/*    */ import cs.bms.model.Actor;
/*    */ import cs.bms.model.Product;
/*    */ import cs.bms.model.Seller;
/*    */ import cs.bms.service.interfac.ISellerService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
@Service
/*    */ public class SellerService
/*    */   extends GenericService<Seller, Long>
/*    */   implements ISellerService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("sellerDao")
/*    */   private ISellerDao dao;
/*    */   
/*    */   protected IGenericDao<Seller, Long> getDao()
/*    */   {
/* 31 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List<Long> getIdsByProduct(Product product)
/*    */   {
/* 36 */     return this.dao.listHQL("SELECT s.id FROM Seller s join s.products p WHERE p.id = ?", new Object[] {
/*    */     
/* 38 */       Long.valueOf(product.getId() == null ? -1L : product.getId().longValue()) });
/*    */   }
/*    */   
/*    */   public Seller getByDescSupplier(String description, Actor actor)
/*    */   {
/* 43 */     return (Seller)this.dao.getByHQL("FROM Seller s WHERE UPPER(s.description) LIKE UPPER(?) AND s.supplier = ?", new Object[] { description, actor });
/*    */   }
/*    */   
/*    */   public Seller getByDefaulSupplier(Actor actor)
/*    */   {
/* 48 */     return (Seller)this.dao.getByHQL("FROM Seller s WHERE s.default_ = true AND s.supplier = ?", new Object[] { actor });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\SellerService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */