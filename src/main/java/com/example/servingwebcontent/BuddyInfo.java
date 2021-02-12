package com.example.servingwebcontent;

import javax.persistence.*;

@Entity
public class BuddyInfo {
    private String name;
    private String number;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private AddressBook addressBook;

    public BuddyInfo() {}

    public BuddyInfo(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "com.part3.lab3.BuddyInfo{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    private void setAddressBook(AddressBook book){
        this.addressBook = book;
    }
}
