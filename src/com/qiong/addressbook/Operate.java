package com.qiong.addressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//操作加数据库，或可分离
public class Operate {
    private List<ContactPerson> list = new ArrayList<>() ;
    public Operate(List<ContactPerson> list) {
        this.list = list;
    }

    public Operate() {
    }

    public void addLogic(){
        while(true){
            Menu.addMenu();
            int item = TelNoteRegex.menuItemValidate(1, 3);
            switch (item){
                case 1: this.addOperation(); break;
                case 2: this.showAll(); break;
                case 3: return;
            }
        }
    }

    public void searchLogic(){
        while(true){
            Menu.searchMenu();
            int item = TelNoteRegex.menuItemValidate(1, 7);
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
        while(true){
            Menu.modifyMenu();
            int item = TelNoteRegex.menuItemValidate(1, 3);
            switch (item){
                case 1: this.modifyOperation(); break;
                case 2: this.showAll(); break;
                case 3: return;
            }
        }
    }

    public void deleteLogic(){
        while(true){
            Menu.deleteMenu();
            int item = TelNoteRegex.menuItemValidate(1, 4);
            switch (item){
                case 1: this.deleteOperation(); break;
                case 2: this.showAll(); break;
                case 3: this.deleteAllOperation(); break;
                case 4: return;
            }
        }
    }

    public void orderLogic(){
        while(true){
            Menu.orderMenu();
            int item = TelNoteRegex.menuItemValidate(1, 5);
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
        String name = TelNoteRegex.nameValidate();
        String age = TelNoteRegex.ageValidate();
        String sex = TelNoteRegex.sexValidate();
        String telNum = TelNoteRegex.telNumValidate();
        String address = TelNoteRegex.addressValidate();
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
        String name = TelNoteRegex.nameValidate();
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
        String age = TelNoteRegex.ageValidate();
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
        String sex = TelNoteRegex.sexValidate();
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
        String telNum = TelNoteRegex.telNumValidate();
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
        String add = TelNoteRegex.addressValidate();
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
        System.out.println("Please enter Id: ");
        int idItem = TelNoteRegex.menuItemValidate(1, this.list.size());
        while(true){
            Menu.subModifyMenu();
            int menuItem = TelNoteRegex.menuItemValidate(1, 6);
            switch (menuItem){
                case 1:
                    String name = TelNoteRegex.nameValidate();
                    (this.list.get(idItem - 1)).setName(name);
                    break;
                case 2:
                    String age = TelNoteRegex.ageValidate();
                    (this.list.get(idItem - 1)).setName(age);
                    break;
                case 3:
                    String sex = TelNoteRegex.sexValidate();
                    (this.list.get(idItem - 1)).setSex(sex);
                    break;
                case 4:
                    String telNum = TelNoteRegex.telNumValidate();
                    (this.list.get(idItem - 1)).setTelNum(telNum);
                    break;
                case 5:
                    String add = TelNoteRegex.addressValidate();
                    (this.list.get(idItem - 1)).setAddress(add);
                    break;
                case 6: return;
            }
        }
    }

    public void deleteOperation(){
        System.out.println("Please enter Id: ");
        int idItem = TelNoteRegex.menuItemValidate(1, this.list.size());
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
