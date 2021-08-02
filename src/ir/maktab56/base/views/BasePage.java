package ir.maktab56.base.views;

import java.util.Locale;
import java.util.Scanner;

public abstract class BasePage implements Page {

    private String name;
    protected String[] options;
    protected abstract void run();

    public BasePage( ){
        this.name = getClass().getName().toUpperCase();
        showTitle();
        run();

    }

   public BasePage(String name){
        this.name = name;
        showTitle();
        run();

    }
    public BasePage(String name,String[] options){
        this.name = name;
        showTitle();
        this.options =options;
        showOptions(options);
        run();

    }



    @Override
    public void showTitle() {
        print("_".repeat(100));
        int x = name.length()/2;
        x = 50-x;
        print("||"+" ".repeat(x)+name+" ".repeat(x-4)+"||");
        print("_".repeat(100));
    }

    @Override
    public <T> void showList(T[] list) {

    }

    @Override
    public void showOptions(String[] names) {
        int k =0;
        if(names!= null)
        for(String n: names){
            print(++k+"\t"+n);
        }
    }

    @Override
    public int input(int max) {
        int select;
        print("select an action value");
        while (true){
            System.out.print(" : ");
            select = new Scanner(System.in).nextInt();
            if (select>max || select<1)
                print("select an action from 1 to "+max);
            else
                break;
        }
        return select;
    }

    @Override
    public <T> void print(T s) {
        System.out.println(s);
    }

    @Override
    public String input(String msg) {
        System.out.print(msg+" : ");
        return new Scanner(System.in).next();
    }

    @Override
    public String input(int minChar, String msg) {
        System.out.print(msg+" : ");
        String inp;
        while (true) {
            inp = new Scanner(System.in).next();
            if (inp.length()<minChar)
                print("at least insert "+minChar+" characters");
            else
                break;
        }
        return inp;
    }



    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    String enterPass(int min){
       return input(min,"enter your password");
    }
}
