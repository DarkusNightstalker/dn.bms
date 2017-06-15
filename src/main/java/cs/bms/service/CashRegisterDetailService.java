/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.ICashRegisterDetailDao;
/*    */ import cs.bms.enumerated.CashType;
/*    */ import cs.bms.model.CashRegisterDetail;
/*    */ import cs.bms.service.interfac.ICashRegisterDetailService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import java.io.Serializable;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class CashRegisterDetailService
/*    */   extends GenericService<CashRegisterDetail, Serializable>
/*    */   implements ICashRegisterDetailService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("cashRegisterDetailDao")
/*    */   private ICashRegisterDetailDao dao;
/*    */   
/*    */   protected IGenericDao<CashRegisterDetail, Serializable> getDao()
/*    */   {
/* 32 */     return this.dao;
/*    */   }
/*    */   
/*    */   public Integer getQuantity(Long cashRegisterId, CashType type)
/*    */   {
/* 37 */     return this.dao.getQuantity(cashRegisterId, type);
/*    */   }
/*    */   
/*    */   public Map<CashType, Integer> getQuantitiesAsMap(Long id)
/*    */   {
/* 42 */     Map<CashType, Integer> map = new HashMap();
/* 43 */     for (CashType type : CashType.values()) {
/* 44 */       Integer quantity = this.dao.getQuantity(id, type);
/* 45 */       if (quantity == null) quantity = Integer.valueOf(0);
/* 46 */       map.put(type, quantity);
/*    */     }
/* 48 */     return map;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\CashRegisterDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */