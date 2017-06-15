/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IStockTypeDao;
/*    */ import cs.bms.model.StockType;
/*    */ import cs.bms.service.interfac.IStockTypeService;
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
/*    */ public class StockTypeService
/*    */   extends GenericService<StockType, Short>
/*    */   implements IStockTypeService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("stockTypeDao")
/*    */   private IStockTypeDao dao;
/*    */   
/*    */   protected IGenericDao<StockType, Short> getDao()
/*    */   {
/* 30 */     return this.dao;
/*    */   }
/*    */   
/*    */   public StockType getByCode(String code)
/*    */   {
/* 35 */     return (StockType)this.dao.getByHQL("FROM StockType st WHERE st.code LIKE ?", new Object[] { code });
/*    */   }
/*    */   
/*    */   public List<Object[]> getBasicData()
/*    */   {
/* 40 */     return this.dao.listHQL("SELECT st.id,st.name FROM StockType st where st.active = true");
/*    */   }
/*    */   
/*    */   public Short getIdByCode(String code)
/*    */   {
/* 45 */     return (Short)this.dao.getByHQL("SELECT st.id FROM StockType st WHERE st.code LIKE ?", new Object[] { code });
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Object[]> getCreatedByAfterDate(Date date)
/*    */   {
/* 51 */     return this.dao.listHQL("SELECT stt.code,stt.name,stt.active FROM StockType stt WHERE stt.createDate > ?  ORDER BY stt.createDate", new Object[] { date });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Object[]> getEditedByAfterDate(Date date, boolean b)
/*    */   {
/* 60 */     return this.dao.listHQL("SELECT stt.code,stt.name,stt.active FROM StockType stt WHERE stt.editDate > ? AND stt.createDate < ?  ORDER BY stt.editDate", new Object[] { date });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\StockTypeService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */