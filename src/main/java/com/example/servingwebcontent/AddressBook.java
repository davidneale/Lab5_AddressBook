package com.example.servingwebcontent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook{
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "addressBook")
    private List<BuddyInfo> addressBook;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public AddressBook() {}

    public AddressBook(Long id) {
        this.id = id;
        this.addressBook = new ArrayList<BuddyInfo>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BuddyInfo> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(List<BuddyInfo> addressBook) {
        this.addressBook = addressBook;
    }

    public int getSize() {
        return addressBook.size();
    }

    public BuddyInfo getElementAt(int index) {
        return addressBook.get(index);
    }

    public void addBuddy(BuddyInfo buddy){
        addressBook.add(buddy);
    }
}

