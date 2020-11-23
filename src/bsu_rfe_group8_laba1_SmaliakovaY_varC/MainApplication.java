package bsu_rfe_group8_laba1_SmaliakovaY_varC;

import java.lang.reflect.Constructor;
import java.lang.Math;
import java.lang.Double;
import java.util.*;

public class MainApplication {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Food[] breakfast = new Food[20];
        int i = 0;

        System.out.println("Input quantity of products");
        int quantity = scanner.nextInt();

        for (int j =0; j < quantity; j++){
            //System.out.println("Input product");
            String temp2 = scanner.next();
            String[] parts = temp2.split(("/")); //раздлеяем параметры ком строки
            int length = parts.length;
            switch (length){
                case 1:{
                    if (parts[0].equals("Cheese")){
                        breakfast[j] = new Cheese();
                    }
                    else {
                        j--;
                        System.out.println("Unknown product");
                    }
                    break;
                }

                case 2:{
                    if (parts[0].equals("Apple")){
                        if (parts[1].equals("small") || parts[1].equals("middle") || parts[1].equals("big")){
                            breakfast[j] = new Apple(parts[1]);
                        }
                        else {
                            j--;
                            System.out.println("Unknown size of Apple product");
                        }
                    }
                    else {
                        j--;
                        System.out.println("Unknown product");
                    }
                    break;
                }

                case 3:{
                    if (parts[0].equals("Sandwich")){
                        if ((parts[1].equals("cheese") || parts[1].equals("tomato") || parts[1].equals("ham")) &&
                                (parts[2].equals("cheese") || parts[2].equals("tomato") || parts[2].equals("ham"))){
                            breakfast[j] = new Sandwich(parts[1],parts[2]);
                        }
                        else {
                            j--;
                            System.out.println("Unknown filling of Sandwich product");
                        }
                    }
                    else {
                        j--;
                        System.out.println("Unknown product");
                    }
                    break;
                }
            }


        }

        /*
        System.out.println("Breakfast: "); //выводим завтрак таким,каким он был первоначально
        for (Food item : breakfast) {
            if (item != null){
                if (item.calculateCalories() == 0.0){  // если ввели продукт, который не предусмотрен в программе
                    System.out.print("This product is not provided: " + item.name);
                    if(item.par1!=null)
                        System.out.print(", " + item.par1);
                    if(item.par2!=null)
                        System.out.print(", " + item.par2);
                    System.out.println(")");
                    continue;
                }
                item.consume();
                System.out.println(" " + item.calculateCalories());
            } else {
                break;
            }
        }
         */

        Arrays.sort(breakfast, new Comparator<Object>() { //Сортируем массив
            public int compare(Object f1, Object f2) {
                if (f1 == null) return 1;
                if (f2 == null) return -1;
                return Integer.valueOf(((Food)f1).getName().length()).compareTo(((Food)f2).getName().length());
            }
        });

        System.out.println("Sorted breakfast: ");
        for (Food item : breakfast) {
            if (item != null){
                if (item.calculateCalories() == 0.0){  // если ввели продукт, который не предусмотрен в программе
                    System.out.print("This product is not provided: " + item.name);
                    if(item.par1!=null)
                        System.out.print(", " + item.par1);
                    if(item.par2!=null)
                        System.out.print(", " + item.par2);
                    System.out.println(")");
                    continue;
                }
                item.consume();
                System.out.println(" " + item.calculateCalories());
            } else {
                break;
            }
        }

        int eatten_a1, eatten_a2, eatten_a3, eatten_c, eatten_s1, eatten_s2, eatten_s3;
        eatten_a1 = eatten_a2 = eatten_a3 = eatten_c = eatten_s1 = eatten_s2 = eatten_s3 = 0;
        for(Food item: breakfast){ // считаем, сколько чего было съедено на завтрак
            if(item == null)
                break;
            if(item.name.equals("Apple")) {
                if(item.par1.equals("small"))
                    eatten_a1++;
                else if(item.par1.equals("middle"))
                    eatten_a2++;
                else if(item.par1.equals("big"))
                    eatten_a3++;
            }
            if(item.name.equals("Cheese"))
                eatten_c++;
            if(item.name.equals("Sandwich")) {
                if(item.par1.equals("cheese") || item.par2.equals("cheese")){
                    if(item.par1.equals("ham") || item.par2.equals("ham"))
                        eatten_s1++;
                    if(item.par1.equals("tomato") || item.par2.equals("tomato"))
                        eatten_s2++;
                }
                if(item.par1.equals("ham") || item.par2.equals("ham")){
                    if(item.par1.equals("tomato") || item.par2.equals("tomato"))
                        eatten_s3++;
                }
            }
        }
        System.out.println("Eaten for breakfast:");
        System.out.println(" small apples - " + eatten_a1 + ", middle apples - " + eatten_a2 + ", big apples - " + eatten_a3);
        System.out.println(" pieces of cheese - " + eatten_c);
        System.out.println(" sandwiches with ham and cheese - " + eatten_s1);
        System.out.println(" sandwiches with tomato and cheese - " + eatten_s2);
        System.out.println(" sandwiches with ham and tomato - " + eatten_s3);
    }
}
