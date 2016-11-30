package MainFolder;

/**
 ******* Class Product сверен с оригиналом 29 11 2016 / 16-53 ***********.
 */
public class Product
{
    private String title;
    private double price;
    private int quantity;
    // Здесь надо еще написать методы - геттеры
    // НАПИСАНО !!!
    public String getTitle() {return title;}
    public double getPrice() {return price;}
    public int getQuantity() {return quantity;}
    // и сеттеры
    // НАПИСАНО !!!
    public void setTitle(String title) { this.title = title; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) {this.quantity = quantity;}
    // Пишем метод getCost() - получения локальный стоимостей товаров.
    public double getCost() {return quantity * price;}
}
