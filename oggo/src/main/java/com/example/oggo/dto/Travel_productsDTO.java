package com.example.oggo.dto;

import lombok.Data;

@Data
public class Travel_productsDTO {
	private String productId;
    private String title;
    private String description;
    private String region;
    private int price;
    private String startDate;
    private String endDate;
    private Integer totalSeats;
    private Integer minSeats;
    private Integer leftSeats;
    private String imageUrl;
    private String createdAt;
    private Integer views;
    private String tag;
    private String status;

}
