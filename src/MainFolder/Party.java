package MainFolder;

/**
 ********** Class Party сверен с оригиналом 29 11 2016 / 16-47 ********.
 */
public class Party
{
    // Для Party мы конструктор не писали - обошлись геттером и сеттером
    // приватное поле, доступное только внутри класса
    private String name;
    // ****
    private String address;

    private String[] keys;

    private String[] values;
    // ****
    /* далее идут публичные методы, позволяющие доступится
    к этому полю(переменной) - геттеры и сеттеры.
    Чтобы прочитать значение внутреннего имени геттер*/
    public String getName()
    {
        return name;
    }
    // *******
    public String getAddress()
    {
        return address;
    }
    public String[] getKeys() {return keys;}
    public String[] getValues() { return values;}
    // *******
    // И для установки имени при создании обекта - сеттер
    public void setName(String name){
        this.name = name;
    }
    // ****
    public void setAddress(String address) { this.address = address;}
    public void setKeys(String[] keys) {this.keys = keys;}
    public void setValues(String[] values){this.values = values;}
    // ****


}
