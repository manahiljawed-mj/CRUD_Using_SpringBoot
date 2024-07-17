package com.example.webproject.repository;
import com.example.webproject.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class LaptopRepository {

//    @Autowired
//    Laptop lp;

    private static Connection connection() throws Exception
    {

         Class.forName("org.postgresql.Driver");
         Connection conn =DriverManager.getConnection("jdbc:postgresql://localhost:5433/databaseDemo","postgres","1804");
        System.out.println("Connected to PostgreSQL database");
        if(conn != null)
        { System.out.println("Database connection established");
            return conn;}
        else{
            System.out.println("Database connection failed");
            return null;
        }
    }


    public List<Laptop> getInfo() throws Exception {
        List<Laptop> list=new ArrayList<>();
        Connection conn=connection();
        PreparedStatement ps=conn.prepareStatement("select * from Laptop");
        ResultSet rs=ps.executeQuery();
        while (rs.next())
        {
            Laptop lp=new Laptop();
            lp.setId(rs.getInt(1));
            lp.setName(rs.getString(2));
            list.add(lp);
        }
        rs.close();
        return list;
    }

    public boolean addLaptop(Laptop lp) throws Exception
    {
        Connection conn=connection();
        PreparedStatement ps=conn.prepareStatement("insert into Laptop values(?,?)");
        ps.setInt(1,lp.getId());
        ps.setString(2,lp.getName());
        boolean result=ps.execute();
        if(result)
        {
            System.out.println("Laptop not added");
            return false;
        }
        else
        {
            System.out.println("Laptop added");

            return true;
        }
    }

    public boolean updateLaptop(Laptop lp,int id) throws Exception
    {
        Connection conn=connection();
        PreparedStatement ps=conn.prepareStatement("update Laptop set laptop_id =? , laptop_name =? where laptop_id=?");
        ps.setInt(1,lp.getId());
        ps.setString(2,lp.getName());
        ps.setInt(3,id);
        int result=ps.executeUpdate();
        if(result<=0)
        {
            System.out.println("Laptop not added");
            return false;
        }
        else
        {
            System.out.println("Laptop added");

            return true;
        }
    }

    public boolean patchLaptop(Laptop lp,int id) throws Exception
    {
        Connection conn=connection();
        PreparedStatement ps=conn.prepareStatement("update Laptop set laptop_name =? where laptop_id=?");
        ps.setString(1,lp.getName());
        ps.setInt(2,id);
        int result=ps.executeUpdate();
        if(result<=0)
        {
            System.out.println("Laptop not added");
            return false;
        }
        else
        {
            System.out.println("Laptop added");

            return true;
        }
    }
    public boolean deleteLaptop(int id) throws Exception
    {
        Connection conn=connection();
        PreparedStatement ps=conn.prepareStatement("delete from laptop where laptop_id=?");
        ps.setInt(1,id);
        boolean result=ps.execute();
        if(result)
        {
            System.out.println("Laptop not added");
            return false;
        }
        else
        {
            System.out.println("Laptop added");

            return true;
        }
    }
}
