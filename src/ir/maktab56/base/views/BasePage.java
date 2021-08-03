package ir.maktab56.base.views;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class BasePage implements Page {

    private String name;
    protected String[] options;

    protected abstract void run();

    public String  getPageName(){
        String[] split = getClass().getName().toUpperCase().split("\\.");
        return this.name = split[split.length - 1];
    }

    public void autoHeader(){
        line();
        String name = getPageName();
        int x = name.length() / 2;
        x = 50 - x;
        print("||" + " ".repeat(x) + name + " ".repeat(x - 4) + "||");
        line();
    }



    public BasePage() {


    }

    public void defaultInit(){
        autoHeader();
        run();
    }
    public BasePage(String name) {
        this.name = name;
        showTitle();
        run();

    }

    public BasePage(String name, String[] options) {
        this.name = name;
        showTitle();
        this.options = options;
        showOptions(options);
        run();

    }

    @Override
    public void line() {
        print("_".repeat(100));
    }

    @Override
    public void showTitle( ) {
        line();
        int x = name.length() / 2;
        x = 50 - x;
        print("||" + " ".repeat(x) + name + " ".repeat(x - 4) + "||");
        line();
    }

    @Override
    public <T> void showList(T[] list) {

    }

    @Override
    public void showOptions(String[] names) {
        int k = 0;
        if (names != null)
            for (String n : names) {
                print(++k + "\t" + n);
            }
    }

    public  int inputSelector(int max, String msg){
        int select;
        print(msg);
        while (true) {
            System.out.print(" : ");
            try {
                select = new Scanner(System.in).nextInt();
                if (select > max || select < 1)
                    print("select an action from 1 to " + max);
                else
                    break;
            } catch (Exception e) {
                print("please insert a valid number");
            }
        }
        return select;
    }

    @Override
    public int input( int max) {
        int select;
        print("select an action value");
        while (true) {
            System.out.print(" : ");
            try {
                select = new Scanner(System.in).nextInt();
                if (select > max || select < 1)
                    print("select an action from 1 to " + max);
                else
                    break;
            } catch (Exception e) {
                print("please insert a valid number");
            }
        }
        return select;
    }

    @Override
    public <T> void print(T s) {
        System.out.println(s);
    }

    @Override
    public String input(String msg) {
        System.out.print(msg + " : ");
        return new Scanner(System.in).next();
    }

    @Override
    public String input(int minChar, String msg) {
        System.out.print(msg + " : ");
        String inp;
        while (true) {
            inp = new Scanner(System.in).next();
            if (inp.length() < minChar)
                print("at least insert " + minChar + " characters");
            else
                break;
        }
        return inp;
    }

    @Override
    public <S> void err(S str) {
        print("-".repeat(10) + " FAILED " + str.toString() + "-".repeat(10));
    }

    @Override
    public void err() {
        print("-".repeat(10) + " FAILED " + "-".repeat(10));
    }

    @Override
    public <S> void success(S str) {
        print("-".repeat(10) + " SUCCESSFUL " + str.toString() + "-".repeat(10));

    }

    @Override
    public void success() {
        print("-".repeat(10) + " SUCCESSFUL " + "-".repeat(10));

    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    String enterPass(int min) {
        return input(min, "enter your password");
    }

    @Override
    public void sayTime() {

            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            System.out.print(formatter.format(ts));

    }
}
