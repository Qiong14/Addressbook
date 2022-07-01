package com.qiong.addressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Operate {
    private List<ContactPerson> list = new ArrayList<>();

    public Operate(List<ContactPerson> list) {
        this.list = list;
    }

    public Operate() {
    }

    public void addLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while(true){
            menu.addMenu();
            int item = regex.menuItemValidate(1, 3);
            switch (item){
                case 1: this.addOperation(); break;
                case 2: this.showAll(); break;
                case 3: return;
            }
        }
    }

    public void searchLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while(true){
            menu.searchMenu();
            int item = regex.menuItemValidate(1, 7);
            switch (item){
                case 1: this.searchByName(); break;
                case 2: this.searchByAge(); break;
                case 3: this.searchBySex(); break;
                case 4: this.searchByTelNum(); break;
                case 5: this.searchByAddr(); break;
                case 6: this.showAll(); break;
                case 7: return;
            }
        }
    }

    public void modifyLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while(true){
            menu.modifyMenu();
            int item = regex.menuItemValidate(1, 3);
            switch (item){
                case 1: this.modifyOperation(); break;
                case 2: this.showAll(); break;
                case 3: return;
            }
        }
    }

    public void deleteLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while(true){
            menu.deleteMenu();
            int item = regex.menuItemValidate(1, 4);
            switch (item){
                case 1: this.deleteOperation(); break;
                case 2: this.showAll(); break;
                case 3: this.deleteAllOperation(); break;
                case 4: return;
            }
        }
    }

    public void orderLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while(true){
            menu.orderMenu();
            int item = regex.menuItemValidate(1, 5);
            switch (item){
                case 1: this.orderByName(); break;
                case 2: this.orderByAge(); break;
                case 3: this.orderBySex(); break;
                case 4: this.showAll(); break;
                case 5: return;
            }
        }
    }

    public void addOperation(){
        TelNoteRegex regex = new TelNoteRegex();
        String name = regex.nameValidate();
        String age = regex.ageValidate();
        String sex = regex.sexValidate();
        String telNum = regex.telNumValidate();
        String address = regex.addressValidate();
        ContactPerson person = new ContactPerson(name, age, sex, telNum, address);
        this.list.add(person);
        person.setId(this.list.size());
    }

    public void showAll(){
        if (this.list.size()==0){
            System.out.println("0 Contact person!");
            return;
        }
        for (int i = 0; i < this.list.size(); i++){
            System.out.println(this.list.get(i));
        }
    }

    public void searchByName(){
        TelNoteRegex regex = new TelNoteRegex();
        String name = regex.nameValidate();
        boolean flag = false;
        for (int i = 0; i < this.list.size(); i++){
            if (name.equals(this.list.get(i).getName())) {
                System.out.println(this.list.get(i));
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Not found!");
        }
    }

    public void searchByAge(){
        TelNoteRegex regex = new TelNoteRegex();
        String age = regex.ageValidate();
        boolean flag = false;
        for (int i = 0; i < this.list.size(); i++){
            if (age.equals(this.list.get(i).getAge())) {
                System.out.println(this.list.get(i));
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Not found!");
        }
    }

    public void searchBySex(){
        TelNoteRegex regex = new TelNoteRegex();
        String sex = regex.sexValidate();
        boolean flag = false;
        for (int i = 0; i < this.list.size(); i++){
            if (sex.equals(this.list.get(i).getSex())) {
                System.out.println(this.list.get(i));
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Not found!");
        }
    }

    public void searchByTelNum(){
        TelNoteRegex regex = new TelNoteRegex();
        String telNum = regex.telNumValidate();
        boolean flag = false;
        for (int i = 0; i < this.list.size(); i++){
            if (telNum.equals(this.list.get(i).getTelNum())) {
                System.out.println(this.list.get(i));
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Not found!");
        }
    }

    public void searchByAddr(){
        TelNoteRegex regex = new TelNoteRegex();
        String add = regex.addressValidate();
        boolean flag = false;
        for (int i = 0; i < this.list.size(); i++){
            if (add.equals(this.list.get(i).getAddress())) {
                System.out.println(this.list.get(i));
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Not found!");
        }
    }

    public void modifyOperation(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        System.out.println("Please enter Id: ");
        int idItem = regex.menuItemValidate(1, this.list.size());
        while(true){
            menu.subModifyMenu();
            int menuItem = regex.menuItemValidate(1, 6);
            switch (menuItem){
                case 1:
                    String name = regex.nameValidate();
                    (this.list.get(idItem - 1)).setName(name);
                    break;
                case 2:
                    String age = regex.ageValidate();
                    (this.list.get(idItem - 1)).setName(age);
                    break;
                case 3:
                    String sex = regex.sexValidate();
                    (this.list.get(idItem - 1)).setSex(sex);
                    break;
                case 4:
                    String telNum = regex.telNumValidate();
                    (this.list.get(idItem - 1)).setTelNum(telNum);
                    break;
                case 5:
                    String add = regex.addressValidate();
                    (this.list.get(idItem - 1)).setAddress(add);
                    break;
                case 6: return;
            }
        }
    }

    public void deleteOperation(){
        TelNoteRegex regex = new TelNoteRegex();
        System.out.println("Please enter Id: ");
        int idItem = regex.menuItemValidate(1, this.list.size());
        this.list.remove(idItem - 1);
        for (int i = 0; i < this.list.size(); i++){
            (this.list.get(i)).setId(i+1);
        }
        System.out.println("Delete success!");
    }

    public void deleteAllOperation(){
        this.list.clear();
        System.out.println("Delete success!");
    }

    public void orderByName(){
        Collections.sort(this.list, new OrderByName());
        for (int i = 0; i < this.list.size(); i++){
            (this.list.get(i)).setId(i+1);
        }
        System.out.println("Order success!");
    }

    public void orderByAge(){
        Collections.sort(this.list, new OrderByAge());
        for (int i = 0; i < this.list.size(); i++){
            (this.list.get(i)).setId(i+1);
        }
        System.out.println("Order success!");
    }

    public void orderBySex(){
        Collections.sort(this.list, new OrderBySex());
        for (int i = 0; i < this.list.size(); i++){
            (this.list.get(i)).setId(i+1);
        }
        System.out.println("Order success!");
    }

    class OrderByName implements Comparator<ContactPerson>{
        public int compare(ContactPerson p1, ContactPerson p2){
            return p1.getName().compareTo(p2.getName());
        }
    }

    class OrderByAge implements Comparator<ContactPerson>{
        public int compare(ContactPerson p1, ContactPerson p2){
            return p1.getAge().compareTo(p2.getAge());
        }
    }

    class OrderBySex implements Comparator<ContactPerson>{
        public int compare(ContactPerson p1, ContactPerson p2){
            return p1.getSex().compareTo(p2.getSex());
        }
    }
}
