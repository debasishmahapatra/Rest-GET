package com.debasish.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ResultController {

    @Autowired
    Repository resultRepository;

    //check the api's working correctly api
    @RequestMapping(value="/ping", method=RequestMethod.GET)
    @ResponseBody
    public String healthCheck() {
        return "This is working well";
    }


    @RequestMapping(value="/book", method=RequestMethod.POST)
    @ResponseBody
    public Result addBook(Result result) {
        return resultRepository.save(result);
    }
}

