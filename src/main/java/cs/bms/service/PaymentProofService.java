/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IPaymentProofDao;
/*    */ import cs.bms.model.PaymentProof;
/*    */ import cs.bms.service.interfac.IPaymentProofService;
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
/*    */ public class PaymentProofService
/*    */   extends GenericService<PaymentProof, Short>
/*    */   implements IPaymentProofService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("paymentProofDao")
/*    */   private IPaymentProofDao dao;
/*    */   
/*    */   public boolean existCode(String code, Short id)
/*    */   {
/* 30 */     return this.dao.existCode(code, id);
/*    */   }
/*    */   
/*    */   protected IGenericDao<PaymentProof, Short> getDao()
/*    */   {
/* 35 */     return this.dao;
/*    */   }
/*    */   
/*    */   public Short getIdByAbbr(String abbr)
/*    */   {
/* 40 */     return this.dao.getIdByAbbr(abbr);
/*    */   }
/*    */   
/*    */   public List<Object[]> getCreateByAfterDate(Date date)
/*    */   {
/* 45 */     return this.dao.listHQL("SELECT pp.code,pp.abbr,pp.name,pp.forSale,pp.forPurchase,pp.forStored,pp.forReturn,pp.active FROM PaymentProof pp WHERE pp.createDate > ?", new Object[] { date });
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
/*    */   public List<Object[]> getEditedByAfterDate(Date date, boolean b)
/*    */   {
/* 58 */     return this.dao.listHQL("SELECT pp.code,pp.abbr,pp.name,pp.forSale,pp.forPurchase,pp.forStored,pp.forReturn,pp.active,pp.createUser.id,pp.createDate FROM PaymentProof pp WHERE pp.createDate < ? and pp.editDate > ?", new Object[] { date, date });
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
/*    */ 
/*    */ 
/*    */ 
/*    */   public Short getIdByCode(String string)
/*    */   {
/* 74 */     return (Short)this.dao.getByHQL("SELECT pp.id FROM PaymentProof pp WHERE pp.code LIKE ?", new Object[] { string });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\PaymentProofService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */