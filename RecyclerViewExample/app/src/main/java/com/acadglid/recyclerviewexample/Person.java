package com.acadglid.recyclerviewexample;

/**
 * Created by Manikanta on 7/4/2016.
 */
public class Person
{
    String name;
    String age;
    int photoId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    Person(String name, String age, int photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }
}
