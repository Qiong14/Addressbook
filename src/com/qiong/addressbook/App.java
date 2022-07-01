package com.qiong.addressbook;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public void start(){
        Operate operate = new Operate();
        while (true){
            Menu.mainMenu();
            int item = TelNoteRegex.menuItemValidate(1,6);
            switch (item){
                case 1:
                    operate.addLogic();
                    break;
                case 2:
                    operate.searchLogic();
                    break;
                case 3:
                    operate.modifyLogic();
                    break;
                case 4:
                    operate.deleteLogic();
                    break;
                case 5:
                    operate.orderLogic();
                    break;
                case 6: System.exit(0);
            }
        }
    }

}
