package com.example.campusexpensese06206.model;

public class ExpensesModel {
    public int id;
    public String name;
    public int price;
    public String description;
    public int icon;
    public ExpensesModel(int _id, String _name, int _price, String _des, int _icon){
        id = _id;
        name = _name;
        price = _price;
        description = _des;
        icon = _icon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }
}
