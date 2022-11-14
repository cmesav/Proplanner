package app.vercel.wappi.models;

public class Product {

    private final String date;
    private final String description;
    private final String price;
    private final String shipping;
    private final String trade;
    private final String address;

    public Product(String date, String description, String price, String shipping, String trade, String address) {
        this.date = date;
        this.description = description;
        this.price = price;
        this.shipping = shipping;
        this.trade = trade;
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getShipping() {
        return shipping;
    }

    public String getTrade() {
        return trade;
    }

    public String getAddress() {
        return address;
    }
}