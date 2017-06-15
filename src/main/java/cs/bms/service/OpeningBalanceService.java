/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IOpeningBalanceDao;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.model.OpeningBalance;
/*    */ import cs.bms.model.OperationType;
/*    */ import cs.bms.model.Product;
/*    */ import cs.bms.model.UoM;
/*    */ import cs.bms.model.User;
/*    */ import cs.bms.service.interfac.IOpeningBalanceService;
/*    */ import cs.bms.service.interfac.IOperationTypeService;
/*    */ import gkfire.auditory.Auditory;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import gkfire.util.Month;
/*    */ import java.math.BigDecimal;
/*    */ import java.math.RoundingMode;
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
/*    */ 
/*    */ 
/*    */ public class OpeningBalanceService
/*    */   extends GenericService<OpeningBalance, Long>
/*    */   implements IOpeningBalanceService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("openingBalanceDao")
/*    */   private IOpeningBalanceDao dao;
/*    */   @Autowired
/*    */   @Qualifier("operationTypeService")
/*    */   private IOperationTypeService operationTypeService;
/*    */   
/*    */   protected IGenericDao<OpeningBalance, Long> getDao()
/*    */   {
/* 44 */     return this.dao;
/*    */   }
/*    */   
/*    */   public void generate(Integer year, Month month, Integer companyId, User user)
/*    */   {
/* 49 */     List<Object[]> data = this.dao.listHQL("SELECT st.product.id,st.quantity,st.product.uom.id,COALESCE((SELECT pcp.cost FROM ProductCostPrice pcp WHERE pcp.product = st.product AND pcp.company = st.company),0) as cost FROM Stock st WHERE st.product.active = true AND st.quantity > 0 AND st.company.id = ?", new Object[] { companyId });
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 56 */     for (Object[] item : data) {
/* 57 */       OpeningBalance ob = new OpeningBalance();
/* 58 */       ob.setCompany(new Company(companyId));
/* 59 */       ob.setMonth(month);
/* 60 */       ob.setOperationType(new OperationType(this.operationTypeService.getOpeningBalanceTypeId()));
/* 61 */       ob.setProduct(new Product((Long)item[0]));
/* 62 */       ob.setQuantity((BigDecimal)item[1]);
/* 63 */       ob.setUnitCost((BigDecimal)item[3]);
/* 64 */       ob.setTotalCost(new BigDecimal(ob.getQuantity().doubleValue() * ob.getUnitCost().doubleValue()).setScale(2, RoundingMode.HALF_UP));
/* 65 */       ob.setUom(new UoM((Integer)item[2]));
/* 66 */       ob.setYear(year);
/* 67 */       Auditory.make(ob, user);
/* 68 */       this.dao.saveOrUpdate(ob);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\OpeningBalanceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */