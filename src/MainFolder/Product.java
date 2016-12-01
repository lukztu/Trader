package MainFolder;

/**
 ******* Class Product сверен с оригиналом 29 11 2016 / 16-53 ***********.
 у4_ Здесь класс public class Product, который был в 3-м уроке, мы преобразуем в
 абстрактный класс. Это значит, что от этого класса нельзя создавать экземпляры
 объектов, а можно только наследовать!!!!!!
 ПРАВИЛО - если можно обойтись без наследования - надо обходиться без наследования!
 НАСЛЕДОВАНИЕ можно заменить АГРЕГАЦИЕЙ - это когда в новом объекте есть ссылка на
 объект, который как-бы - родительский
 */
public abstract class Product
{
    public static final int DEF_DISCOUNT = 10;

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
    /* Добавляем. Пишем метод вычисляющий надбавку 10% при условии
     превышения закупки товара более 10 штук  */
    protected int calcDiscount() {
        if (quantity > DEF_DISCOUNT) {return 10;}
        else {return 0;}
    }
}
