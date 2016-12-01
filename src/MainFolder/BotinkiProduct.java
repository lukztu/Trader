package MainFolder;

/* Этот класс, также как и класс FotoProduct, является наследником
   класса Product (extends Product)
 */
public class BotinkiProduct extends Product {
    private String color;
    private int size;
    // геттеры
    public String getColor() {return color;}
    public int getSize() {return size;}
    // сеттеры
    public void setColor(String color) {
        this.color = color;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
