package com.youprice.onion.entity;

@Entity
public class ProductCategory {

      @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
      @Column(name = "product_category")
      private Long id; //상품카테고리번호 PK

      @ManyToOne
      @JoinColumn(name = "product_id")
      private Product product;//상품번호 FK

      @ManyToOne
      @JoinColumn(name = "category_id")
      private Category category;//카테고리번호 FK




}