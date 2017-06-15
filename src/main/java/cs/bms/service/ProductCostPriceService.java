/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IProductCostPriceDao;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.model.Product;
/*    */ import cs.bms.model.ProductCostPrice;
/*    */ import cs.bms.model.User;
/*    */ import cs.bms.service.interfac.IProductCostPriceService;
/*    */ import gkfire.auditory.Auditory;
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
/*    */ public class ProductCostPriceService
/*    */   extends GenericService<ProductCostPrice, Long>
/*    */   implements IProductCostPriceService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("productCostPriceDao")
/*    */   private IProductCostPriceDao dao;
/*    */   
/*    */   protected IGenericDao<ProductCostPrice, Long> getDao()
/*    */   {
/* 35 */     return this.dao;
/*    */   }
/*    */   
/*    */   public Long getIdByCompanyProduct(Company company, Product product)
/*    */   {
/* 40 */     return (Long)this.dao.getByHQL("SELECT pcp.id FROM ProductCostPrice pcp WHERE pcp.company = ?  AND pcp.product.id = ?", new Object[] { company, Long.valueOf(product.getId() == null ? -1L : product.getId().longValue()) });
/*    */   }
/*    */   
/*    */ 
/*    */   public BigDecimal getCostByCompanyProduct(Company company, Product product)
/*    */   {
/* 46 */     BigDecimal cost = (BigDecimal)this.dao.getByHQL("SELECT pcp.cost FROM ProductCostPrice pcp WHERE pcp.product = ? AND pcp.company = ?", new Object[] { product, company });
/* 47 */     if (cost == null) {
/* 48 */       cost = BigDecimal.ZERO.setScale(2);
/*    */     }
/* 50 */     return cost;
/*    */   }
/*    */   
/*    */ 
/*    */   public BigDecimal getLastAcquisitionCost(Company company, Product product)
/*    */   {
/*    */     try
/*    */     {
/* 58 */       return (BigDecimal)this.dao.listHQLPage("SELECT k.costIn from Kardex k WHERE k.product = ? AND k.company.id IN (SELECT c.id FROM Company c WHERE c.companyGroup = ?) and k.costIn is not null and k.operationType.id IN (21,2) ORDER BY k.orderDate desc ", 1, 1, new Object[] { product, company.getCompanyGroup() }).get(0);
/*    */     } catch (IndexOutOfBoundsException e) {}
/* 60 */     return BigDecimal.ZERO.setScale(2);
/*    */   }
/*    */   
/*    */ 
/*    */   public void updateGroupCostByCompanyProduct(BigDecimal cost, Company company, Product product, User user)
/*    */   {
/* 66 */     List<Integer> cIds = this.dao.listHQL("SELECT c.id FROM Company c WHERE c.companyGroup =?", new Object[] { company.getCompanyGroup() });
/* 67 */     for (Integer cId : cIds) {
/* 68 */       ProductCostPrice pcp = new ProductCostPrice();
/* 69 */       Object[] info = (Object[])this.dao.getByHQL("SELECT pcp.id,pcp.createUser.id,pcp.createDate FROM ProductCostPrice pcp WHERE pcp.company.id = ? AND pcp.product = ?", new Object[] { cId, product });
/* 70 */       if (info != null) {
/* 71 */         pcp.setId((Long)info[0]);
/* 72 */         pcp.setCreateUser(new User((Integer)info[1]));
/* 73 */         pcp.setCreateDate((Date)info[2]);
/*    */       }
/* 75 */       pcp.setCompany(new Company(cId));
/* 76 */       pcp.setCost(cost);
/* 77 */       pcp.setProduct(product);
/* 78 */       Auditory.make(pcp, user);
/* 79 */       this.dao.saveOrUpdate(pcp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Object[]> getCreatedByAfterDate(Date date, String idCompany)
/*    */   {
/* 86 */     return this.dao.listHQL("SELECT pcp.product.barcode,pcp.company.code,pcp.cost FROM ProductCostPrice pcp WHERE pcp.createDate > ? and pcp.company.code = ? ORDER BY psp.createDate", new Object[] { date, idCompany });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Object[]> getEditedByAfterDate(Date date, String idCompany, boolean b)
/*    */   {
/* 94 */     return this.dao.listHQL("SELECT pcp.product.barcode,pcp.company.code,pcp.cost FROM ProductCostPrice pcp WHERE pcp.editDate > ? and pcp.createDate < ? and pcp.company.code = ? ORDER BY psp.editDate", new Object[] { date, date, idCompany });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\ProductCostPriceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */