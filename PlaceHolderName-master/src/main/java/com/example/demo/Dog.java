package com.example.demo;

public class Dog {
    private String name;
    private String age;
    private String color;
    private AdoptionStatus status;
    private AgeCategory ageCategory;
    private int id;
    private Breed breed;
    private String imageUrl;
    private String description;

    public Dog(String name, String age, String color, AdoptionStatus status, AgeCategory ageCategory, int id, Breed breed, String imageUrl, String description) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.status = status;
        this.ageCategory = ageCategory;
        this.id = id;
        this.breed = breed;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public Dog() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getAge() {

        return age;
    }

    public void setAge(String age) {

        this.age = age;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public AdoptionStatus getStatus() {

        return status;
    }

    public void setStatus(AdoptionStatus status) {

        this.status = status;
    }

    public AgeCategory getAgeCategory() {

        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {

        this.ageCategory = ageCategory;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {

        this.breed = breed;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

