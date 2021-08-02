package ir.maktab56.views;

import ir.maktab56.base.views.BasePage;

import java.util.ArrayList;
import java.util.Arrays;

public class Home extends BasePage {

    public Home(){
        super("Main",new String[]{"login","register"});

    }

    @Override
    protected void run() {
        int select = input(options.length);
      switch (select){
          case 1:
              new Login();
            break;
          case 2:
              new Register();
      }
    }


}
