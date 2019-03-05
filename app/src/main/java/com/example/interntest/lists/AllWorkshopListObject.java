package com.example.interntest.lists;

public class AllWorkshopListObject {

    private String workshopName;
    private String workshopDescription;

    public AllWorkshopListObject(String workshopName, String workshopDescription) {
        this.workshopName = workshopName;
        this.workshopDescription = workshopDescription;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getWorkshopDescription() {
        return workshopDescription;
    }

    public void setWorkshopDescription(String workshopDescription) {
        this.workshopDescription = workshopDescription;
    }

    @Override
    public String toString() {
        return "AllWorkshopListObject{" +
                "workshopName='" + workshopName + '\'' +
                ", workshopDescription='" + workshopDescription + '\'' +
                '}';
    }
}
