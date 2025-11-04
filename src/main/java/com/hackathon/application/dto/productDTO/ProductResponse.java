package com.hackathon.application.dto.productDTO;

public record ProductResponse(
    Long id,
    String name,
    String description,
    Double price
){
}
