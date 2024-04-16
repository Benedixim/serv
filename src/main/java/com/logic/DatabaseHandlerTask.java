package com.logic;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandlerTask extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException
    {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signup( String title, String description, String status)
    {
        String insert = "INSERT INTO " + Const.TASK_TABLE + "(" +

                Const.TASK_TITLE + "," + Const.TASK_DESCRIPTION + "," + Const.TASK_STATUS + ")" +
                "VALUES(?,?,?)";
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, title);
            prSt.setString(2, description);
            prSt.setString(3, status);

            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(String title, String description, String status,  Long idSelected)
    {

            String up = "UPDATE " + Const.TASK_TABLE +
                    " SET " + Const.TASK_TITLE + "=?," + Const.TASK_DESCRIPTION + "=?," + Const.TASK_STATUS + "=?" +
                    " WHERE " + Const.TASK_ID + " = " + idSelected ;

            PreparedStatement prSt = null;
            try {
                prSt = getDbConnection().prepareStatement(up);
                prSt.setString(1, title);
                prSt.setString(2, description);
                prSt.setString(3, status);

                prSt.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

    }

    public KanbanTask getUser (String title, String description, String status) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.TASK_TABLE + " WHERE " +
                Const.TASK_TITLE + "=? AND " + Const.TASK_DESCRIPTION + "=?" + " AND " + Const.TASK_STATUS + "=?";

        KanbanTask u = null;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, title);
            prSt.setString(2, description);
            prSt.setString(3, status);

            resSet = prSt.executeQuery();

            if (resSet.next()) {
                u = new KanbanTask(resSet.getLong(1), resSet.getString(2), resSet.getString(3), resSet.getString(4));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return u;
    }

    public KanbanTask getUserById (int id) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.TASK_TABLE + " WHERE " +
                Const.TASK_ID + "=" + id;

        KanbanTask u = null;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();

            if (resSet.next()) {
                u = new KanbanTask(resSet.getLong(1), resSet.getString(2), resSet.getString(3), resSet.getString(4));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return u;
    }


    public void deleteUser (int userId)
    {
        String query = "DELETE FROM " + Const.TASK_TABLE + " WHERE " + Const.TASK_ID + "=" + userId;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
             prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public List<KanbanTask> getAllUsers()
    {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.TASK_TABLE ;

        List<KanbanTask> users = new ArrayList<>();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);


            resSet = prSt.executeQuery();

            while (resSet.next()) {
                users.add( new KanbanTask(resSet.getLong(1), resSet.getString(2), resSet.getString(3), resSet.getString(4)));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public int maleCount() {
        int count = 0;

        ResultSet resSet = null;

        String select = "SELECT count(*) FROM " + Const.USER_TABLE + " WHERE gender='Мужской'" ;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();
            //preparedStatement = connection.prepareStatement("SELECT count(*) FROM taxtype WHERE taxName='MoneyTax'");
            //ResultSet rs = preparedStatement.executeQuery();
            while (resSet.next()) {
                count = resSet.getInt("count(*)");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int femaleCount() {
        int count = 0;

        ResultSet resSet = null;

        String select = "SELECT count(*) FROM " + Const.USER_TABLE + " WHERE gender='Женский'" ;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();
            //preparedStatement = connection.prepareStatement("SELECT count(*) FROM taxtype WHERE taxName='MoneyTax'");
            //ResultSet rs = preparedStatement.executeQuery();
            while (resSet.next()) {
                count = resSet.getInt("count(*)");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int professionCount(String profession) {
        int count = 0;

        ResultSet resSet = null;

        //String select = "SELECT count(*) FROM " + Const.USER_TABLE + " WHERE profession=" + profession ;

        String select = "SELECT COUNT(*) FROM " + Const.USER_TABLE + " WHERE profession=?";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, profession);

            resSet = prSt.executeQuery();
            //preparedStatement = connection.prepareStatement("SELECT count(*) FROM taxtype WHERE taxName='MoneyTax'");
            //ResultSet rs = preparedStatement.executeQuery();
            while (resSet.next()) {
                count = resSet.getInt("count(*)");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }


    public List<String> getAllProfessions() {

        List<String> professions = new ArrayList<>();


        try {
            Connection conn = getDbConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT profession FROM " + Const.USER_TABLE);

            while (rs.next()) {
                String profession = rs.getString("profession");
                professions.add(profession);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return professions;

    }

    public List<String> getAllPlaces() {

        List<String> places = new ArrayList<>();


        try {
            Connection conn = getDbConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT placement FROM " + Const.USER_TABLE);

            while (rs.next()) {
                String profession = rs.getString("placement");
                places.add(profession);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return places;

    }

    public double placeCount(String placement) {

        int count = 0;

        ResultSet resSet = null;

        //String select = "SELECT count(*) FROM " + Const.USER_TABLE + " WHERE profession=" + profession ;

        String select = "SELECT COUNT(*) FROM " + Const.USER_TABLE + " WHERE placement=?";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, placement);

            resSet = prSt.executeQuery();
            //preparedStatement = connection.prepareStatement("SELECT count(*) FROM taxtype WHERE taxName='MoneyTax'");
            //ResultSet rs = preparedStatement.executeQuery();
            while (resSet.next()) {
                count = resSet.getInt("count(*)");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
