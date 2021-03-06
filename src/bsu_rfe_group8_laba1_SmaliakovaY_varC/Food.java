package bsu_rfe_group8_laba1_SmaliakovaY_varC;

public abstract class Food implements Consumable, Nutritous {

    String name = null;
    String par1 = null;
    String par2 = null;
    Double calories = null;

    public Food (String name){ // конструктор инициализации
        this.name = name;
    }

    public Food(String par1, String par2){ //конструктор с 2 параметрами
        this.par1 = par1;
        this.par2 = par2;
    }

    public boolean equals (Object arg0){ // перегружен метод сравнения
        if (!(arg0 instanceof Food)) return false;
        if (name==null || ((Food)arg0).name==null) return false;
        return name.equals(((Food)arg0).name);
    }

    public String toString() { // перегружен метод преобразования в строку
        return name;
    }

    public String getName(){ // возвращает имя
        return name;
    }

    public void setName (String name){ // для изменения имени
        this.name = name;
    }

    public void consume(){ }
}