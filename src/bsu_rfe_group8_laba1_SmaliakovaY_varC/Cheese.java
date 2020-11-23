package bsu_rfe_group8_laba1_SmaliakovaY_varC;

public class Cheese extends Food{
    public Cheese(){ // конструктор
        super("Cheese"); // вызывает конструктор базового класса
    }
    public Double calculateCalories() { // реализация метода подсчета калорий
        calories = 30.0;
        return calories;
    }

    public void consume(){ // реализация метода consume
        System.out.println(this + " eaten");
    }
}