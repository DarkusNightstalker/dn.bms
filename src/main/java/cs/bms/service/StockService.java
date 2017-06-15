/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IStockDao;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.model.Product;
/*    */ import cs.bms.model.Stock;
/*    */ import cs.bms.model.User;
/*    */ import cs.bms.service.interfac.IStockService;
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
/*    */ public class StockService
/*    */   extends GenericService<Stock, Long>
/*    */   implements IStockService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("stockDao")
/*    */   private IStockDao dao;
/*    */   
/*    */   protected IGenericDao<Stock, Long> getDao()
/*    */   {
/* 34 */     return this.dao;
/*    */   }
/*    */   
/*    */   public void substractQuantity(BigDecimal quantity, Product product, Company company, User user)
/*    */   {
/* 39 */     this.dao.updateHQL("UPDATE Stock SET quantity = (quantity - ?),editUser = ?,editDate = ?  WHERE product = ? AND company = ?", new Object[] { quantity, user, new Date(), product, company });
/*    */   }
/*    */   
/*    */   public void addQuantity(BigDecimal quantity, Product product, Company company, User user)
/*    */   {
/* 44 */     boolean exist = this.dao.getByHQL("SELECT 1 FROM Stock s WHERE s.product = ? and s.company = ?", new Object[] { product, company }) != null;
/* 45 */     if (!exist) {
/* 46 */       Stock st = new Stock();
/* 47 */       st.setCompany(company);
/* 48 */       st.setProduct(product);
/* 49 */       st.setQuantity(quantity);
/* 50 */       st.setCreateUser(user);
/* 51 */       st.setCreateDate(new Date());
/* 52 */       this.dao.saveOrUpdate(st);
/*    */     } else {
/* 54 */       this.dao.updateHQL("UPDATE Stock SET quantity = (quantity + ?),editUser = ?,editDate = ? WHERE product = ? AND company = ?", new Object[] { quantity, user, new Date(), product, company });
/*    */     }
/*    */   }
/*    */   
/*    */   public Long getIdByCompanyProduct(Company currentCompany, Product product)
/*    */   {
/* 60 */     return (Long)this.dao.getByHQL("SELECT s.id FROM Stock s WHERE s.product = ? AND s.company = ?", new Object[] { product, currentCompany });
/*    */   }
/*    */   
/*    */   public BigDecimal getGroupQuantityByCompanyProduct(Company company, Product product)
/*    */   {
/* 65 */     return (BigDecimal)this.dao.getByHQL("SELECT SUM(st.quantity) FROM Stock st WHERE st.product = ? AND st.company.id IN (SELECT c.id from Company c WHERE c.companyGroup = ?)", new Object[] { product, company.getCompanyGroup() });
/*    */   }
/*    */   
/*    */   public List<Object[]> getCreatedByAfterDate(Date date, String company)
/*    */   {
/* 70 */     return this.dao.listHQL("SELECT st.quantity,st.product.barcode,st.company.code FROM Stock st WHERE st.company.code = ? AND st.createDate > ?", new Object[] { company, date });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Object[]> getEditedByAfterDate(Date date, String company, boolean b)
/*    */   {
/* 78 */     return this.dao.listHQL("SELECT st.quantity,st.product.barcode,st.company.code FROM Stock st WHERE st.company.code = ? AND st.createDate < ? AND st.editDate > ?", new Object[] { company, date, date });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\StockService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */