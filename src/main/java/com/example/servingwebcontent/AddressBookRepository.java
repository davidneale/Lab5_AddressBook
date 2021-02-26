package com.example.servingwebcontent;

import org.springframework.data.repository.CrudRepository;


public interface AddressBookRepository extends CrudRepository<AddressBook,Long> {
    AddressBook findAddressBookById(long id);
}
