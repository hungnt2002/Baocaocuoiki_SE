package entity;

import com.google.gson.JsonObject;

import boundary.StoredFiles;

public class Bicycle {
    private static StoredFiles bicycles = new StoredFiles("bicycles.json");
    private String numberPlate = "0000";
    private String type;
    private String color;
    private String manufacturer;
    private String status = "Ready"; //   Sẵn sàng/Đang cho thuê

    public Bicycle(){

    }


    public Bicycle(String numberPlate, String type, String color, String manufacturer, String status) {
        this.numberPlate = numberPlate;
        this.type = type;
        this.color = color;
        this.manufacturer = manufacturer;
    }

    public void showInfor(){
        System.out.printf("%-15s %-12s %-12s %-14s %-18s ",this.numberPlate,this.type,this.color,this.manufacturer,this.status);
    }

    public static JsonObject convertToJsonObject(Bicycle bicycle){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("numberPlate", bicycle.getNumberPlate());
        jsonObject.addProperty("type", bicycle.getType());
        jsonObject.addProperty("color", bicycle.getColor());
        jsonObject.addProperty("manufacturer", bicycle.getManufacturer());
        jsonObject.addProperty("status", bicycle.checkStatus());
        return jsonObject;
    }

    public static Bicycle convertToObject(JsonObject jsonObject){
        Bicycle bicycle = new Bicycle();
        bicycle.setNumberPlate(jsonObject.get("numberPlate").getAsString());
        bicycle.setStatus(jsonObject.get("status").getAsString());
        if(bicycle.getNumberPlate().equals("0000") == false){
            bicycle.setType(jsonObject.get("type").getAsString());
            bicycle.setColor(jsonObject.get("color").getAsString());
            bicycle.setManufacturer(jsonObject.get("manufacturer").getAsString());
        }
        return bicycle;
    }



    public static StoredFiles getBicycles() {
        return bicycles;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public String checkStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    

    
}
