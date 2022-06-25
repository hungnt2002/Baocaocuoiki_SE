package entity;

public abstract class Card {
    private String iD;
    private String name;
    private String phoneNumber;
    private Integer balance;

    public Card() {

    }

    public Card(String iD, String name, String phoneNumber, Integer balance) {
        this.iD = iD;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    



    
    
}
