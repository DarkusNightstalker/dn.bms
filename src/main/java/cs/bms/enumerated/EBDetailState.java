/*    */ package cs.bms.enumerated;
/*    */ 
/*    */ import gkfire.util.Month;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum EBDetailState
/*    */ {
/* 18 */   _NULL(0, ""), 
/* 19 */   PERIOD(1, ""), 
/* 20 */   DISABLED_PERIOD(2, ""), 
/* 21 */   OUT_PERIOD(8, ""), 
/* 22 */   DISABLED_OUT_PERIOD(9, "");
/*    */   
/*    */   private final int number;
/*    */   private final String descrition;
/*    */   
/*    */   private EBDetailState(int number, String descrition) {
/* 28 */     this.number = number;
/* 29 */     this.descrition = descrition;
/*    */   }
/*    */   
/*    */   public int getNumber() {
/* 33 */     return this.number;
/*    */   }
/*    */   
/*    */   public String getDescrition() {
/* 37 */     return this.descrition;
/*    */   }
/*    */   
/*    */   public static EBDetailState calculate(Date detail, int year, Month month, boolean active) throws ParseException {
/* 41 */     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
/* 42 */     if (active) {
/* 43 */       if (detail.before(sdf.parse("01/" + month.getNumber() + "/" + year))) {
/* 44 */         return OUT_PERIOD;
/*    */       }
/* 46 */       return PERIOD;
/*    */     }
/*    */     
/* 49 */     if (detail.before(sdf.parse("01/" + month.getNumber() + "/" + year))) {
/* 50 */       return DISABLED_OUT_PERIOD;
/*    */     }
/* 52 */     return DISABLED_PERIOD;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\enumerated\EBDetailState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */