/*    */ package cs.bms.model;
/*    */ 
/*    */ import cs.bms.enumerated.CashType;
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.EnumType;
/*    */ import javax.persistence.Enumerated;
/*    */ import javax.persistence.FetchType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
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
/*    */ @Entity
/*    */ @Table(name="cash_register_detail", catalog="public")
/*    */ @XmlRootElement
/*    */ public class CashRegisterDetail
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @JoinColumn(name="id_cash_register", nullable=false)
/*    */   @ManyToOne(fetch=FetchType.LAZY)
/*    */   protected CashRegister cashRegister;
/*    */   @Id
/*    */   @Column(name="cash_type", nullable=false)
/*    */   @Enumerated(EnumType.ORDINAL)
/*    */   protected CashType cashType;
/*    */   @Column(name="quantity", nullable=true)
/* 40 */   protected Integer quantity = 0;
/*    */   
/*    */ 
/*    */ 
/*    */   public CashRegister getCashRegister()
/*    */   {
/* 46 */     return this.cashRegister;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setCashRegister(CashRegister cashRegister)
/*    */   {
/* 53 */     this.cashRegister = cashRegister;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CashType getCashType()
/*    */   {
/* 60 */     return this.cashType;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setCashType(CashType cashType)
/*    */   {
/* 67 */     this.cashType = cashType;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Integer getQuantity()
/*    */   {
/* 74 */     return this.quantity;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setQuantity(Integer quantity)
/*    */   {
/* 81 */     this.quantity = quantity;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\CashRegisterDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */