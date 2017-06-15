/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IWorkShiftDao;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.model.WorkShift;
/*    */ import cs.bms.service.interfac.IWorkShiftService;
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
/*    */ public class WorkShiftService
/*    */   extends GenericService<WorkShift, Integer>
/*    */   implements IWorkShiftService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("workShiftDao")
/*    */   private IWorkShiftDao dao;
/*    */   
/*    */   protected IGenericDao<WorkShift, Integer> getDao()
/*    */   {
/* 31 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List<Object[]> getFreeBasicDataByCompany(Date date, Company company)
/*    */   {
/* 36 */     return this.dao.listHQL("SELECT ws.id,ws.name,ws.timeEntry FROM WorkShift ws WHERE ws.active = true AND ws.company = ? AND ws.id not in (SELECT cr.workShift.id FROM CashRegister cr WHERE cr.dateArcing = ?) ORDER by ws.timeEntry", new Object[] { company, date });
/*    */   }
/*    */   
/*    */   public List<Object[]> getBasicDataByCompany(Company company)
/*    */   {
/* 41 */     return this.dao.listHQL("SELECT ws.id,ws.name,ws.timeEntry FROM WorkShift ws WHERE ws.active = true AND ws.company = ? ORDER by ws.timeEntry", new Object[] { company });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\WorkShiftService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */