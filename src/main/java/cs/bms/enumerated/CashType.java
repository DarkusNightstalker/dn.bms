/*    */ package cs.bms.enumerated;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.math.RoundingMode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CashType
/*    */ {
/* 16 */   CASH_010("0.10"), 
/* 17 */   CASH_020("0.20"), 
/* 18 */   CASH_050("0.50"), 
/* 19 */   CASH_1("1"), 
/* 20 */   CASH_2("2"), 
/* 21 */   CASH_5("5"), 
/* 22 */   CASH_10("10"), 
/* 23 */   CASH_20("20"), 
/* 24 */   CASH_50("50"), 
/* 25 */   CASH_100("100"), 
/* 26 */   CASH_200("200");
/*    */   
/*    */   private final BigDecimal value;
/*    */   
/*    */   private CashType(String value)
/*    */   {
/* 32 */     this.value = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
/*    */   }
/*    */   
/*    */   public BigDecimal getValue() {
/* 36 */     return this.value;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\enumerated\CashType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */