package com.example.servingwebcontent;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {
    private AddressBookRepository repo;

    @Autowired
    public AddressBookController(AddressBookRepository repo){
        this.repo = repo;
    }

    @RequestMapping("/addressBook")
    public AddressBook makeAddressBook() {
        AddressBook book = new AddressBook();
        repo.save(book);
        return book;
    }

    @RequestMapping(value="/addressBook", method= RequestMethod.GET)
    public AddressBook getAddressBook(@RequestParam("id") Long id){
        return repo.findAddressBookById(id);
    }

}
