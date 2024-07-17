package com.example.webproject;

import com.example.webproject.model.Laptop;
import com.example.webproject.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FirstController {

    @Autowired
    LaptopService ls;



    @RequestMapping(value="/laptop", method=RequestMethod.GET )
    public List<Laptop> laptopInformation() throws Exception {

        return ls.getInformation();
    }

    @PostMapping("/addLaptop")
    public boolean addLaptop(@RequestBody Laptop l) throws Exception {
       boolean result= ls.addLaptop(l);
        if(result)
        {
            System.out.println("Laptop not added");
            return true;
        }
        else
        {
            System.out.println("Laptop added");

            return false;
        }
    }

    @PutMapping("/updateLaptop/{required_id}")
    public boolean updateLaptop(@RequestBody Laptop l,@PathVariable(name="required_id") int id) throws Exception {
        boolean result=ls.updateLaptop(l,id);
        if(result)
        {
            System.out.println("Laptop Data Updated");
            return true;
        }
        else
        {
            System.out.println("Laptop Data not Update");

            return false;
        }
    }

    @PatchMapping("/patchLaptop/{required_id}")
    public boolean patchLaptop(@RequestBody Laptop l,@PathVariable(name="required_id") int id) throws Exception {
        boolean result=ls.patchLaptop(l,id);
        if(result)
        {
            System.out.println("Laptop Data Updated");
            return true;
        }
        else
        {
            System.out.println("Laptop Data not Updated");

            return false;
        }
    }

    @DeleteMapping("/deleteLaptop/{required_id}")
    public boolean deleteLaptop(@PathVariable(name="required_id") int id) throws Exception {
        boolean result=ls.deleteLaptop(id);
        if(result)
        {
            System.out.println("Laptop Data Deleted");
            return true;
        }
        else
        {
            System.out.println("Laptop Data not Deleted");

            return false;
        }
    }

}
