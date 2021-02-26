package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestController {
    private BuddyInfoRepository buddyRepo;
    private AddressBookRepository bookRepo;

    @Autowired
    public RestController(BuddyInfoRepository buddyRepo, AddressBookRepository bookRepo){
        this.buddyRepo = buddyRepo;
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public String start(){
        return "hello";
    }

    @GetMapping("/hello")
    public String greeting(Model model){
        model.addAttribute("addressBook", new AddressBook());
        model.addAttribute("buddy", new BuddyInfo());
        model.addAttribute("addressBook");
        return "hello";
    }

    @PostMapping("/addBuddy")
    public String addBuddy(@ModelAttribute("buddy") BuddyInfo buddy){
        AddressBook book = bookRepo.findAddressBookById(3L);
        book.addBuddy(buddy);
        buddyRepo.save(buddy);
        bookRepo.save(book);
        return "buddy";
    }

    @PostMapping("/makeAddressBook")
    public String makeAddressBook(Model model){
        AddressBook addressBook = new AddressBook(3L);
        model.addAttribute("addressBook", addressBook );
        bookRepo.save(addressBook);
        //AddressBook addressBook = bookRepo.findById(3L);

        return "addressBook";
    }

}
