package com.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Persistence {
    private String databaseurl;
    private String username;
    private String password;
    private Connection conn;

public Persistence() throws SQLException {
    this.databaseurl = "jdbc:h2:./db";
    this.username = "sa";
    this.password = "password";
    this.conn = DriverManager.getConnection(
        this.databaseurl, this.username, this.password);
}

public void disablePersistence() throws SQLException {
    this.conn.close();
}

public String populateDatabase() throws Exception {
    FileReader file = new FileReader("Java.sql");
    BufferedReader reader = new BufferedReader(file);
    StringBuilder str = new StringBuilder();
    String line = reader.readLine();
    while (line != null) {
        str.append(line);
        line = reader.readLine();
    }
    file.close();
    Statement stmt = this.conn.createStatement();
    stmt.executeUpdate(str.toString());
    return "Sucess";
}

    public String testConnection() throws SQLException {
        StringBuilder str = new StringBuilder();
        Statement stmt = this.conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM JOGADOR");
        while(result.next()) {
            str.append(result.getString("Nome") + "\n");
            str.append(result.getString("Idade") + "\n");
        }
        return str.toString();
    }

    @RequestMapping("/populate")
    public String populate() {
        try {
            return this.populateDatabase();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping("/database")
    String db() {
        try {
            return this.testConnection();
        } catch(Exception e) {
            return e.getMessage();
        }
    }
}