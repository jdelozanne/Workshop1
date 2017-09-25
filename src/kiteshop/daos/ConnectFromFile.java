/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author julia
 */
public class ConnectFromFile {

    Connection conn;
    Statement stat;
    ResultSet rset;

    public void connect() {
        try {
            //load properties file
            Properties props = new Properties();
            props.load(new FileInputStream("connect.properties"));
            //read props
            String probsUser = props.getProperty("user");
            String probsWW = props.getProperty("password");
            String probsUrl = props.getProperty("dburl");
            //connect to database
            this.conn = DriverManager.getConnection(probsUrl, probsUser, probsWW);
        } catch (Exception ex) {
            System.out.println("geen connectie gemaakt:" + ex);
        }

    }

}
