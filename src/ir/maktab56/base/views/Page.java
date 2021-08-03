package ir.maktab56.base.views;

public interface Page {
    void showTitle();

    <T> void showList(
            T[] list
    );

    void showOptions(String[] names);

    int input(int max);

    <T> void print(T s);

    String input(String msg);

    String input(int minChar, String msg);

    <T> void err(T str);
     void err();

    <T>    void success(T str);
     void success();

     void sayTime();

     void line();
}
