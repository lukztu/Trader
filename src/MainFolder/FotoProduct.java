package MainFolder;


/* Этот класс (FotoProduct) является наследником класса Product
   Класс-наследник определяется по сочетанию extends Product
 */

public class FotoProduct extends Product
{
    public static final int DISCOUNT_FOR_NON_DIGITAL = 20;
    private boolean digital;
    private double megapx;

    /* метод вычисления дисконта 20%, при условии если
    фотокамера не цифровая  */

    // вид метода - protected - должен быть одинаков у родителя и наследника
    @Override
    protected int calcDiscount() {
        /* выражение super.calcDiscount() указывает на то, что
        вычисление ведется по родительскому и наследованному
        классам. Здесь идет обращение к родительскому объекту посчитать
		calcDiscount(), потом просто добавляется константа
		 */

        int def = super.calcDiscount();
        if (!digital) {
            def += DISCOUNT_FOR_NON_DIGITAL;
        }
        return def;
    }

    // геттеры
    public boolean getDigital() {return digital;}
    public double getMegapx() {return megapx;}
    // сеттеры
    public void setDigital(boolean digital){
        this.digital = digital;
    }
    public void setMegapx(double megapx){
        this.megapx = megapx;
    }

}
