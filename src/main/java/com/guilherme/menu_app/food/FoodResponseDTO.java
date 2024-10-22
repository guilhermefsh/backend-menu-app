package com.guilherme.menu_app.food;

public record FoodResponseDTO(Long id, String title, String imageUrl, Double price) {
    public FoodResponseDTO(Food food) {
        this(food.getId(), food.getTitle(), food.getImageUrl(), food.getPrice());
    }
}
