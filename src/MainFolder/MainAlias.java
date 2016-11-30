package MainFolder;

    /*  ПРОЕКТЫ мой - Trader & Юрия Ткача - JavaPractice03 ИДЕНТИЧНЫ */

import java.util.Scanner;
    /*  В этой программе классы  Deal, Party, Product проанализированы и
    написаны мной, с последующей сверкой с оригиналом автора Юрия Ткача.
    Ошибки, которые выявились при сверке, были все исправлены и около них
    былы сделана соответствующая отметка в комментариях.
    ******
    Автор программы использовал для ввода с клавиатуры класс Scanner.
	Я пробовал использовать для ввода с клавиатуры классы прописанные ниже.
	При этом возникло неудобство в применении этих классов, т.к. пришлось
	вводит в каждый метод коасса Program строку "throws Exception", иначе
	программа не компилировалась, вернее копиливалась с ошибкой
	(что в конечном счете одно и то же). Поэтому возникает вопрос о
	правомерности приоритетного использования reader.readLine() совместно
	с указанными ниже классами, взамен класса Scanner??? Пока ответ в пользу
	Scannera.
    */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainAlias
{
    /* Создаем приватные переменные, задающие количества циклов
          обращения к методам класса и определяющие для пользователя
          количество товаров и количество сделок, которые позволяет
           обрабатывать данная программа*/
    private static final int MAX_PRODUCTS = 2;
    private static final int MAX_DEALS = 2;

    /* Создаем приватный массив deals типа Deal в классе Program */
    private Deal[] deals;

    /**
     * Program's entry point
     *
     * @param args
     *            command line arguments
     */
    //  ********  ТОЧКА ВХОДЫ В ПРОГРАММУ *******************************
    public static void main(String[] args) /*throws Exception*/{
		/* Создаем новый объект "new Programm" и вызываем на исполнение
		 метод типа void - allActions(). Это и есть точка входа в программу,
		 которая задается с помощью метода main(). Выходит, что надо создать
		 сначала объект от того же класа Program, в котором находится этот же
		 main и выполнить любой метод класса Program.
		  */
        new MainAlias().allActions();
        /* Если НЕ СОЗДАВАТЬ новый объект, а просто вызвать allActions() на исполнение
        то выражение allActions() будет подчеркнуто красным, то есть предвидится ошибка
        компиляции. Это, видимо, объясняется тем, что строки
         private static final int MAX_PRODUCTS = 2;
         private static final int MAX_DEALS = 2;
         private Deal[] deals;
         перестают входить в область компиляции и возникает ошибка.
         */
    }

    /* Это метод класса Program, содержащий в себе последовательный
    вызов на исполнение методов ВВОД-input(), ВЫВОД-output() типа void
     */
    private void allActions() /*throws Exception*/{
        input();
        System.out.println("================================");
        output();
    }
    // ДАЛЕЕ ИДУТ ТАКЖЕ МЕТОДЫ КЛАССА Program - входящие в новый объект "new Programm"  !!!!!

    /* Это метод ВЫВОД-output(), который в свою очередь, делает выборку
    переменных deal типа Deal из массива deals[]. В цикле выбираются
    значения полей переменных deal, полученных из элементов массива deals[],
    полученных с помощью методов класса Deal - getDate(), getBuyer(),
    getSeller(), getProducts(), getSum(), а также методов класса Product - getTitle(),
    getPrice(), getQuantity()
     */
    private void output() {
        for (Deal deal : deals) {
            System.out.println("Deal " + deal.getDate());
            System.out.println("    " + deal.getBuyer().getName()
                    + " buys from " + deal.getSeller().getName());

            for (Product product : deal.getProducts()) {
                System.out.println("        " + product.getTitle() + " "
                        + product.getQuantity() + " x " + product.getPrice()
                        + " = " + product.getCost());
            }

            System.out.println("Sum: " + deal.getSum());
            System.out.println("----------------------------");
        }
    }
    // Это метод ВВОД-input(), который в свою очередь, использует метод ВВОД СДЕЛКИ-inputDeal()
    // ВВОД организует цикл из 2-х витков и заполняет массив deals[i] элементами inputDeal()
    private void input() /*throws Exception*/{
        deals = new Deal[MAX_DEALS];

        for (int i = 0; i < deals.length; i++) {
            System.out.print((i + 1) + " of " + deals.length + ": ");  // Визуальная надпись
            deals[i] = inputDeal();  /* Вызов inputDeal() и запись в переменную deals[i]
			 Это массив сделок размером равным MAX_DEALS (=2 в данном случае)
			 В элементах массива расположены сделки deal типа Deal, полученные из inputDeal()
			 */
        }
    }
    /* Это метод ВВОД СДЕЛКИ-inputDeal(), который в свою очередь, использует методы
       ВВОД ПРОДАВЦА-inputParty()
       ВВОД ПОКУПАТЕЛЯ-inputParty()
       ВВОД ПРОДУКТА-inputProduct()
      */
    private Deal inputDeal()/*throws Exception */{
        System.out.println("Input deal ->");

        System.out.print("  Seller -> ");
		/* Здесь подготавливаются аргументы - задаются их значения для объекта Deal
		аргументы - переменные buyer, seller, products - 2 витка (MAX_PRODUCTS=2)
		 */
        Party seller = inputParty();

        System.out.print("  Buyer -> ");
        Party buyer = inputParty();

        //products - 2 витка (MAX_PRODUCTS=2)
        Product[] products = new Product[MAX_PRODUCTS];
        for (int i = 0; i < products.length; i++) {
            products[i] = inputProduct();
        }
		/* Здесь создается новый объект Deal и в него вводятся подготовленные
		аргументы - переменные buyer, seller, products
		 */
        Deal deal = new Deal(buyer, seller, products);
        return deal;
    }

    /* Это метод ВВОД ПРОДУКТА-inputProdukt(). Здесь вводятся с клавиатуры поля
       Name, Price, Quantity в созданный объект Product() и возвращается
       новый объект с новыми полями
      */
    private Product inputProduct() /*throws Exception*/{
		/* Здесь идет подготовка - ввод значений переменных с клавиатуры
		   В качестве аргумента метода keyboard() вводится текст,
		   который предшествует вводу текста с клавиатуры*/
        System.out.println("  Input product ->");
        String title = keyboard("    Name");
        String price = keyboard("    Price");
        String quan = keyboard("    Quantity");

		/* Здесь создается новый объект и в него вводятся новые аргументы (переменные) */
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(Double.valueOf(price));
        product.setQuantity(Integer.valueOf(quan));

        return product;
    }
    /* Это метод ВВОД КОНТРАГЕНТА-inputParty(). Здесь вводятся с клавиатуры поле
       Party Name в созданный объект Party() и возвращается
       новый объект с новыми полями
      */
    private Party inputParty()/*throws Exception*/ {
		/* Здесь идет подготовка - ввод значений переменных с клавиатуры
		   В качестве аргумента метода keyboard() вводится текст,
		   который предшествует вводу текста с клавиатуры*/
        String partyName = keyboard("Party name");
        Party party = new Party();
        party.setName(partyName);
        return party;
    }

    private String keyboard(String message) /*throws Exception*/{
		/* Здесь выводится текст, который предшествует вводу текста с клавиатуры*/
        System.out.print(message + ": ");
		/* Здесь вводится текст - значения аргументов */
        Scanner scan = new Scanner(System.in);
        return scan.next();
		/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		return s;*/
    }


}
