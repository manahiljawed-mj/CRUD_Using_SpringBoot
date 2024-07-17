package com.example.webproject.service;


import com.example.webproject.model.Laptop;
import com.example.webproject.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

     @Autowired
     LaptopRepository lr;

    public List<Laptop> getInformation() throws Exception {

       return lr.getInfo();
    }

    public boolean addLaptop(Laptop laptop) throws Exception {
        return lr.addLaptop(laptop);
    }

    public boolean updateLaptop(Laptop laptop,int id) throws Exception {
        return lr.updateLaptop(laptop,id);
    }
    public boolean patchLaptop(Laptop laptop,int id) throws Exception {
        return lr.patchLaptop(laptop,id);
    }
    public boolean deleteLaptop(int id) throws Exception {
        return lr.deleteLaptop(id);
    }

}
