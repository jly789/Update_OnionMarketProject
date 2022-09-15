package com.youprice.onion.entity;

@Entity

public class MemberCategory {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "member_category_id")
    private Long id; //회원카테고리 번호 PK

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; //카테고리번호 FK


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;//회원번호 FK








}




















