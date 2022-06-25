package entity;

import com.google.gson.JsonObject;

import boundary.StoredFiles;

public class BankCard extends Card{

    private static StoredFiles bankCards = new StoredFiles("bankCards.json");
    private Integer pin;
    private String bankName;
    

    public BankCard() {
        this.setiD("123");
    }

    public BankCard(String iD, String name, String phoneNumber, Integer balance, Integer pin, String bankName) {
        super(iD, name, phoneNumber, balance);
        this.pin = pin;
        this.bankName = bankName;
    }

    public static JsonObject convertToJsonObject(BankCard bankCard){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("pin", bankCard.getPin());
        jsonObject.addProperty("bankName", bankCard.getBankName());
        jsonObject.addProperty("iD", bankCard.getiD());
        jsonObject.addProperty("name", bankCard.getName());
        jsonObject.addProperty("phoneNumber", bankCard.getPhoneNumber());
        jsonObject.addProperty("balance", bankCard.getBalance());
        return jsonObject;
    }

    public static BankCard convertToObject(JsonObject jsonObject){
        BankCard bankCard = new BankCard();
        bankCard.setiD(jsonObject.get("iD").getAsString());
        if(!bankCard.getiD().equals("123")){
            bankCard.setPin(jsonObject.get("pin").getAsInt());
            bankCard.setBankName(jsonObject.get("bankName").getAsString());
            bankCard.setName(jsonObject.get("name").getAsString());
            bankCard.setPhoneNumber(jsonObject.get("phoneNumber").getAsString());
            bankCard.setBalance(jsonObject.get("balance").getAsInt());
        }
        return bankCard;
    }

    public static StoredFiles getBankCards() {
        return bankCards;
    }

    public static void setBankCards(StoredFiles bankCards) {
        BankCard.bankCards = bankCards;
    }

    public Integer getPin() {
        return pin;
    }
    public void setPin(Integer pin) {
        this.pin = pin;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }



}
