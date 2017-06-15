/*    */ package cs.bms.enumerated;
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
/*    */ public enum UoMType
/*    */ {
/* 14 */   LESS("Menor a la unidad base", ""),  BASE("Unidad Base", ""),  HIGH("Mayor a la unidad base", "");
/*    */   
/*    */   private final String description;
/*    */   private final String appLabel;
/*    */   
/*    */   private UoMType(String description, String appLabel) {
/* 20 */     this.description = description;
/* 21 */     this.appLabel = appLabel;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 25 */     return this.description;
/*    */   }
/*    */   
/*    */   public String getAppLabel() {
/* 29 */     return this.appLabel;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\enumerated\UoMType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */