package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BuddyInfoController {

    private BuddyInfoRepository buddyRepo;
    private AddressBookRepository bookRepo;

    @Autowired
    public BuddyInfoController(BuddyInfoRepository buddyRepo, AddressBookRepository bookRepo){
        this.buddyRepo = buddyRepo;
        this.bookRepo = bookRepo;
    }

    @GetMapping("/buddy")
    public BuddyInfo getBuddy(@RequestParam(value = "bookId", defaultValue = "3L") Long bookId, @RequestParam("buddyId") Long buddyId){
        AddressBook book = bookRepo.findAddressBookById(bookId);
        int index = buddyId.intValue() - 1;
        return book.getElementAt(index);
    }

    @PostMapping("/buddy")
    public BuddyInfo addBuddy(@RequestBody BuddyInfo buddy,@RequestParam(value = "bookId", defaultValue = "3L") Long bookId){
        AddressBook book = bookRepo.findAddressBookById(bookId);
        book.addBuddy(buddy);
        buddyRepo.save(buddy);
        bookRepo.save(book);
        return buddy;
    }
}
