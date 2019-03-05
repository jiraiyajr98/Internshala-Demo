package com.example.interntest.lists;

public class MyWorkshopListObject {

    private String myWorkshop;

    public MyWorkshopListObject(String myWorkshop) {
        this.myWorkshop = myWorkshop;
    }

    public String getMyWorkshop() {
        return myWorkshop;
    }

    public void setMyWorkshop(String myWorkshop) {
        this.myWorkshop = myWorkshop;
    }

    @Override
    public String toString() {
        return "MyWorkshopListObject{" +
                "myWorkshop='" + myWorkshop + '\'' +
                '}';
    }
}
