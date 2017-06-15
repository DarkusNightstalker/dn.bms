/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IProductSalePriceDao;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.model.Product;
/*    */ import cs.bms.model.ProductSalePrice;
/*    */ import cs.bms.model.User;
/*    */ import cs.bms.service.interfac.IProductSalePriceService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import java.math.BigDecimal;
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
/*    */ public class ProductSalePriceService
/*    */   extends GenericService<ProductSalePrice, Long>
/*    */   implements IProductSalePriceService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("productSalePriceDao")
/*    */   private IProductSalePriceDao dao;
/*    */   
/*    */   protected IGenericDao<ProductSalePrice, Long> getDao()
/*    */   {
/* 34 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List<Object[]> getBasicDataByCompanyProduct(Company company, Product product)
/*    */   {
/* 39 */     return this.dao.listHQL("SELECT psp.quantity,psp.price FROM ProductSalePrice psp WHERE psp.company = ? AND psp.product = ? ORDER BY psp.quantity", new Object[] { company, product });
/*    */   }
/*    */   
/*    */   public void deleteByCompanyProduct(Company company, Product product)
/*    */   {
/* 44 */     this.dao.updateHQL("DELETE FROM ProductSalePrice psp WHERE psp.product = ? AND psp.company.id IN (SELECT c.id FROM Company c WHERE c.companyGroup = ? )", new Object[] { product, company.getCompanyGroup() });
/*    */   }
/*    */   
/*    */   public void saveForGroup(BigDecimal price, Integer quantity, Company currentCompany, Product selected, User user)
/*    */   {
/* 49 */     List<Integer> cIds = this.dao.listHQL("SELECT c.id FROM Company c WHERE c.companyGroup = ?", new Object[] { currentCompany.getCompanyGroup() });
/* 50 */     for (Integer cId : cIds) {
/* 51 */       ProductSalePrice pspItem = new ProductSalePrice();
/* 52 */       pspItem.setProduct(selected);
/* 53 */       pspItem.setPrice(price);
/* 54 */       pspItem.setQuantity(quantity);
/* 55 */       pspItem.setCompany(new Company(cId));
/* 56 */       pspItem.setCreateUser(user);
/* 57 */       pspItem.setCreateDate(new Date());
/* 58 */       this.dao.saveOrUpdate(pspItem);
/*    */     }
/*    */   }
/*    */   
/*    */   public List<Object[]> getCreatedByAfterDate(Date date, String company)
/*    */   {
/* 64 */     return this.dao.listHQL("SELECT psp.product.barcode,psp.company.code,psp.quantity,psp.price FROM ProductSalePrice psp WHERE psp.createDate > ? and psp.company.code = ? ORDER BY psp.createDate", new Object[] { date, company });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\ProductSalePriceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */