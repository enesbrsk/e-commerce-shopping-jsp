package com.example.ecommerceshopping.dao;

import com.example.ecommerceshopping.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public UserDao(Connection con) {
        this.con = con;
    }

    public User userLogin(String email, String password){
        User user= null;

        try {

            query = "SELECT * FROM users where email=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1,email);
            pst.setString(2,password);

            rs = pst.executeQuery();

            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("User Dao : "+e.getMessage());
        }

        return user;

    }
}
