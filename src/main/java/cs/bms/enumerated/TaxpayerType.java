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
/*    */ public enum TaxpayerType
/*    */ {
/* 13 */   NATURAL_PERSON("Persona natural", null, null), 
/* 14 */   NATURAL_PERSON_WITHOUT_BUSINESS("Persona natural sin negocio", null, Integer.valueOf(167)), 
/* 15 */   NATURAL_PERSON_WITH_BUSINESS("Persona natural con negocio", null, Integer.valueOf(167)), 
/* 16 */   OTHERS("Otros", Integer.valueOf(131), Integer.valueOf(158));
/*    */   
/*    */   private final String description;
/*    */   protected final Integer otherData;
/*    */   protected final Integer addressRow;
/*    */   
/*    */   private TaxpayerType(String descripction, Integer otherData, Integer addressRow) {
/* 23 */     this.description = descripction;
/* 24 */     this.otherData = otherData;
/* 25 */     this.addressRow = addressRow;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 29 */     return this.description;
/*    */   }
/*    */   
/*    */ 
/*    */   public static TaxpayerType getByDescription(String term)
/*    */   {
/* 35 */     TaxpayerType[] types = values();
/* 36 */     for (TaxpayerType type : types) {
/* 37 */       if (type.getDescription().equalsIgnoreCase(term)) {
/* 38 */         return type;
/*    */       }
/*    */     }
/* 41 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Integer getOtherData()
/*    */   {
/* 48 */     return this.otherData;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Integer getAddressRow()
/*    */   {
/* 55 */     return this.addressRow;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\enumerated\TaxpayerType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */