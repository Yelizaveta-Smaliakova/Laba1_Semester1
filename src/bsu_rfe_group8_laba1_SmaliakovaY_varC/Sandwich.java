package bsu_rfe_group8_laba1_SmaliakovaY_varC;

public class Sandwich extends Food {
    public Sandwich(String filling1, String filling2){ // конструктор инициализации
        super("Sandwich");
        par1 = filling1;
        par2 = filling2;
    }

    public boolean equals (Object arg0){ // переопределние метода сравнения
        if (super.equals(arg0)){
            if (!(arg0 instanceof Sandwich)) return false;
            if (!(par1.equals(((Sandwich)arg0).par1))) return false;
            return par2.equals(((Sandwich)arg0).par2);
        } else
            return false;
    }

    public Double calculateCalories() { // реализация метода подсчета калорий
        calories = 0.0;
        if(!par1.equals("cheese") && !par1.equals("tomato") && !par1.equals("ham"))
            return calories;
        if(!par2.equals("cheese") && !par2.equals("tomato") && !par2.equals("ham"))
            return calories;
        if(par1.equals("cheese") || par2.equals("cheese")) {
            calories += 40.0;
        }
        if(par1.equals("tomato") || par2.equals("tomato")) {
            calories += 20.0;
        }
        if(par1.equals("ham") || par2.equals("ham")) {
            calories += 50.0;
        }
        return calories;
    }

    public String getFilling1(){  // возвращает первую начинку
        return par1;
    }

    public String getFilling2(){ // возвращает вторую начинку
        return par2;
    }
    public String toString(){ // переопределение метода преобразования в строку
        return super.toString() + " with filling: " + par1 + " and " + par2;
    }
    public void consume(){ // реализация метода consume (что произошло с объектом)
        System.out.println(this + " eaten");
    }

}