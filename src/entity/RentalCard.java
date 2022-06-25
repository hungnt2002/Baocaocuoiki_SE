package entity;

import com.google.gson.JsonObject;

import boundary.StoredFiles;

public class RentalCard extends Card {
    private static StoredFiles rentalCards = new StoredFiles("rentalCards.json");
    private String username;
    private Integer password;
    private String email;
    private String numberPlate = "0000";
    private Long rentalTime;
    private boolean loggedIn = false;

    private BankCard bankCard;
    private Bicycle bicycle;

    public RentalCard() {

    }

    public RentalCard(String iD, String name, String phoneNumber, Integer balance, String username, Integer password,
            String email,BankCard bankCard) {
        super(iD, name, phoneNumber, balance);
        this.bankCard = bankCard;
        this.username = username;
        this.password = password;
        this.email = email;
        bicycle = new Bicycle();
        this.loggedIn = true;   
    }

    public void logout() {
        this.setiD(null);
        this.setName(null);
        this.setPhoneNumber(null);
        this.setBalance(null);
        this.loggedIn = false;
        this.username = null;
        this.password = null;
        this.email = null;
        this.numberPlate = null;
        this.rentalTime = null;
        this.bankCard = null;
        this.bicycle = null;
    }

    public static JsonObject convertToJsonObject(RentalCard rentalCard){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", rentalCard.getUsername());
        jsonObject.addProperty("password", rentalCard.getPassword());
        jsonObject.addProperty("email", rentalCard.getEmail());
        jsonObject.addProperty("iD", rentalCard.getiD());
        jsonObject.addProperty("name", rentalCard.getName());
        jsonObject.addProperty("phoneNumber", rentalCard.getPhoneNumber());
        jsonObject.addProperty("balance", rentalCard.getBalance());
        jsonObject.addProperty("numberPlate", rentalCard.getNumberPlate());
        jsonObject.addProperty("rentalTime", rentalCard.getRentalTime());
        jsonObject.add("bicycle", Bicycle.convertToJsonObject(rentalCard.getBicycle()));
        jsonObject.add("bankCard", BankCard.convertToJsonObject(rentalCard.getBankCard()));
        return jsonObject;
    }

    public static RentalCard convertToObject(JsonObject jsonObject){
        RentalCard rentalCard = new RentalCard();
        rentalCard.setUsername(jsonObject.get("username").getAsString());
        rentalCard.setPassword(jsonObject.get("password").getAsInt());
        rentalCard.setEmail(jsonObject.get("email").getAsString());
        rentalCard.setiD(jsonObject.get("iD").getAsString());
        rentalCard.setName(jsonObject.get("name").getAsString());
        rentalCard.setPhoneNumber(jsonObject.get("phoneNumber").getAsString());
        rentalCard.setBalance(jsonObject.get("balance").getAsInt());
        rentalCard.setNumberPlate(jsonObject.get("numberPlate").getAsString());
        if(rentalCard.getNumberPlate().equals("0000") == false){
            rentalCard.setRentalTime(jsonObject.get("rentalTime").getAsLong());
        }
        rentalCard.setBankCard(BankCard.convertToObject(jsonObject.get("bankCard").getAsJsonObject()));
        rentalCard.setBicycle(Bicycle.convertToObject(jsonObject.get("bicycle").getAsJsonObject()));
        return rentalCard;
    }

    public boolean checkBalance(){
        if(this.getBalance()>=1000000){
            return true;
        }
        return false;
    }

    public int checkTypeCard(){
        if(this.getiD().equals("123")){
            return 1;
        }else{
            return 2;
        }
    }

    public static StoredFiles getRentalCards() {
        return rentalCards;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }
    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }



    public Integer getPassword() {
        return password;
    }
    public void setPassword(Integer password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    public String getEmail() {
        return email;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Long getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(Long rentalTime) {
        this.rentalTime = rentalTime;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean checkLoggedIn() {
        return loggedIn;
    }

}
