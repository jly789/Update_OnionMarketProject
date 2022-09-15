package com.youprice.onion.entity;

@Entity
public class ProductImg {

        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "image_id")
        private Long id; //이미지번호 PK

        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product; //상품번호 FK

        private String imageFileName; //이미지파일이름

}