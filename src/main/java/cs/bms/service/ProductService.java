/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IProductDao;
/*    */ import cs.bms.model.Product;
/*    */ import cs.bms.service.interfac.IProductService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProductService
/*    */   extends GenericService<Product, Long>
/*    */   implements IProductService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("productDao")
/*    */   private IProductDao dao;
/*    */   
/*    */   protected IGenericDao<Product, Long> getDao()
/*    */   {
/* 30 */     return this.dao;
/*    */   }
/*    */   
/*    */   public boolean existBarCode(String code, Long exception)
/*    */   {
/* 35 */     return this.dao.existBarCode(code, exception);
/*    */   }
/*    */   
/*    */   public Product getByBarcode(String barcode)
/*    */   {
/* 40 */     return (Product)this.dao.getByHQL("FROM Product p WHERE p.barcode LIKE ?", new Object[] { barcode });
/*    */   }
/*    */   
/*    */   public Object[] getAuditoryData(Long id)
/*    */   {
/* 45 */     return (Object[])this.dao.getByHQL("SELECT cu,p.createDate,eu,p.editDate FROM Product p LEFT JOIN p.createUser as cu LEFT JOIN p.editUser as eu WHERE p.id = ?", new Object[] { id });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Object[]> getSuppliersBasicData(Long id)
/*    */   {
/* 58 */     return this.dao.listHQL("SELECT s.id,s.ubigeo.name,s.identityDocument.abbr,s.identityNumber,s.name  FROM Product p join p.suppliers s WHERE p.id = ?", new Object[] { id });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Object[]> getSellersBasicData(Long id)
/*    */   {
/* 69 */     return this.dao.listHQL("SELECT s.id,s.description,s.supplier.ubigeo.name,s.supplier.identityDocument.abbr,s.supplier.identityNumber,s.supplier.name  FROM Product p join p.sellers s WHERE p.id = ? AND s.active =true AND s.supplier.active = true", new Object[] { id });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<String> getAllBarcodes()
/*    */   {
/* 80 */     return this.dao.listHQL("SELECT p.barcode FROM Product p WHERE p.active = true");
/*    */   }
/*    */   
/*    */   public List<Object[]> getCreatedByAfterDate(Date date)
/*    */   {
/* 85 */     return this.dao.listHQL("SELECT p.barcode,p.name,p.description,p.stockYpe.code,p.uom.code,p.active FROM Product p WHERE p.createDate > ? ORDER BY p.createDate", new Object[] { date });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Object[]> getEditedByAfterDate(Date date, boolean b)
/*    */   {
/* 96 */     return this.dao.listHQL("SELECT p.barcode,p.name,p.description,p.stockYpe.code,p.uom.code,p.active FROM Product p WHERE p.editDate > ? AND p.createDate < ? ORDER BY p.editDate", new Object[] { date });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\ProductService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */