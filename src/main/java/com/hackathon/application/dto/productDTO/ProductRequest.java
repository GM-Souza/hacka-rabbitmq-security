package com.hackathon.application.dto.productDTO;

public record ProductRequest (
    String name,
    String description,
    Double price){
}
