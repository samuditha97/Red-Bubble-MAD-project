package com.example.mynew;
public class UserHelperClass {
    String Name, Age, Gender, Height, Weight, BloodGroup;
    public UserHelperClass() {
    }
    public UserHelperClass(String Name, String Age, String Gender, String Height, String Weight, String BloodGroup) {
        this.Name = Name;
        this.Age = Age;
        this.Gender = Gender;
        this.Height = Height;
        this.Weight = Weight;
        this.BloodGroup =BloodGroup;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getAge() {
        return Age;
    }
    public void setAge(String Age) {
        this.Age = Age;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    public String getHeight() {
        return Height;
    }
    public void setHeight(String Height) {
        this.Height = Height;
    }
    public String getWeight() {
        return Weight;
    }
    public void setWeight(String Weight) {
        this.Weight = Weight;
    }
    public String getBloodGroup() {
        return BloodGroup;
    }
    public void setBloodGroup(String BloodGroup) {
        this.BloodGroup = BloodGroup;
    }
}