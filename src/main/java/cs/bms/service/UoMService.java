/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IUoMDao;
/*    */ import cs.bms.model.UoM;
/*    */ import cs.bms.service.interfac.IUoMService;
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
/*    */ public class UoMService
/*    */   extends GenericService<UoM, Integer>
/*    */   implements IUoMService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("uomDao")
/*    */   private IUoMDao dao;
/*    */   
/*    */   protected IGenericDao<UoM, Integer> getDao()
/*    */   {
/* 30 */     return this.dao;
/*    */   }
/*    */   
/*    */   public boolean existName(String name, Integer exception)
/*    */   {
/* 35 */     return this.dao.existName(name, exception);
/*    */   }
/*    */   
/*    */   public boolean existAbbr(String abbr, Integer exception)
/*    */   {
/* 40 */     return this.dao.existAbbr(abbr, exception);
/*    */   }
/*    */   
/*    */   public boolean existCode(String code, Integer exception)
/*    */   {
/* 45 */     return this.dao.existCode(code, exception);
/*    */   }
/*    */   
/*    */   public Integer getIdByCode(String code)
/*    */   {
/* 50 */     return (Integer)this.dao.getByHQL("SELECT uom.id FROM UoM uom WHERE uom.code LIKE ?", new Object[] { code });
/*    */   }
/*    */   
/*    */   public List<Object[]> getBasicData()
/*    */   {
/* 55 */     return this.dao.listHQL("SELECT uom.id,uom.abbr,uom.name FROM UoM uom where uom.active = true");
/*    */   }
/*    */   
/*    */   public List<Object[]> getCreatedByAfterDate(Date date)
/*    */   {
/* 60 */     return this.dao.listHQL("SELECT uom.code,uom.name,uom.active FROM UoM uom WHERE uom.createDate > ?  ORDER BY uom.createDate", new Object[] { date });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Object[]> getEditedByAfterDate(Date date, boolean b)
/*    */   {
/* 69 */     return this.dao.listHQL("SELECT uom.code,uom.name,uom.active FROM UoM uom WHERE uom.editDate > ? AND uom.createDate < ?  ORDER BY uom.editDate", new Object[] { date });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\UoMService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */