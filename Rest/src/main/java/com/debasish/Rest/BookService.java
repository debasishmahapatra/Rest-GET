package com.debasish.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    Repository repository;

    //Get all the books
    public List<Result> getAllBooks() {
        List<Result> results = repository.findAll();
        return results;
    }

    //display one book by id
    public Result getBookById(int id) {
        return repository.findById(id);
    }

    //save book in database
    public void saveBook(Result result) {
        try{
            repository.save(result);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //delete book by id
    public void deleteBook(int id) {
        try{
            repository.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}