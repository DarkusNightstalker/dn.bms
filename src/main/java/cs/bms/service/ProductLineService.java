/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IProductLineDao;
/*    */ import cs.bms.model.ProductLine;
/*    */ import cs.bms.service.interfac.IProductLineService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
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
/*    */ public class ProductLineService
/*    */   extends GenericService<ProductLine, Integer>
/*    */   implements IProductLineService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("productLineDao")
/*    */   private IProductLineDao dao;
/*    */   
/*    */   protected IGenericDao<ProductLine, Integer> getDao()
/*    */   {
/* 29 */     return this.dao;
/*    */   }
/*    */   
/*    */   public boolean existPath(String path, Integer exception)
/*    */   {
/* 34 */     return this.dao.existPath(path, exception);
/*    */   }
/*    */   
/*    */   public List<Object[]> getBasicData()
/*    */   {
/* 39 */     return this.dao.listHQL("SELECT pl.id,UPPER(pl.path) FROM ProductLine pl where pl.active = true");
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\ProductLineService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */