package com.rbc.incidentmanagement.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rbc.incidentmanagement.bean.Incident;

public class IncidentDao {

                private String jdbcURL = "jdbc:mariadb://fxsupport:3306/fx_incidents?useSSL=false";
                //private String jdbcURL = "jdbc:mysql://localhost:3306/fx_incidents?useSSL=false";
                private String jdbcUsername = "root";
                private String jdbcPassword = "";
                //private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
                private String jdbcDriver = "org.mariadb.jdbc.Driver";
      
                private static final String SELECT_INCIDENT_BY_INCIDENT_NUMBER = "SELECT dev_tagged.incident_number,dev_tagged.app_code,dev_tagged.date_raised,dev_tagged.raised_by,dev_tagged.description,comments.priority,comments.target_date,comments.jira,comments.comments FROM dev_tagged,comments WHERE dev_tagged.incident_number=comments.incident_number AND dev_tagged.incident_number = ?";
                private static final String UPDATE_INCIDENT_SQL ="UPDATE comments SET comments = ?,jira = ?,target_date = ?,priority = ? WHERE incident_number = ?;";
                private static final String SELECT_ALL_SQL = "SELECT dev_tagged.incident_number,dev_tagged.app_code,dev_tagged.date_raised,dev_tagged.raised_by,dev_tagged.description,comments.priority,comments.target_date,comments.jira,comments.comments FROM dev_tagged,comments WHERE dev_tagged.incident_number=comments.incident_number";
                private static final String SELECT_APP_SQL = "SELECT dev_tagged.incident_number,dev_tagged.app_code,dev_tagged.date_raised,dev_tagged.raised_by,dev_tagged.description,comments.priority,comments.target_date,comments.jira,comments.comments FROM dev_tagged,comments WHERE dev_tagged.incident_number=comments.incident_number AND dev_tagged.app_code= ?";
      
                public IncidentDao() {
      
      
                }
      
      protected Connection getConnection() {
                      Connection connection = null;
                      try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                      }catch (SQLException e) {
            e.printStackTrace();
                      }catch (ClassNotFoundException e) {
            e.printStackTrace();
                      }
      return connection;
      }
      
              
      //select incidents by incident number
      
      public Incident selectIncident(String incidentNumber ) {
                      Incident  incident = null;
                      try (Connection connection = getConnection();
  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INCIDENT_BY_INCIDENT_NUMBER);) {
            //System.out.println(preparedStatement);
                   preparedStatement.setString(1, incidentNumber);
            ResultSet rs = preparedStatement.executeQuery();
            
            //Process the result set object.
            while (rs.next()) {
  String incident_number = rs.getString("incident_number");
  String date_raised = rs.getString("date_raised");
  String raised_by = rs.getString("raised_by");
  String app_code = rs.getString("app_code");
  String description = rs.getString("description");
  String comments = rs.getString("comments");
  String jira = rs.getString("jira");
  String priority = rs.getString("priority");
  String target_date = rs.getString("target_date");
  incident = new Incident(incident_number, date_raised, raised_by, app_code, description, comments,jira, priority, target_date);
  
            }
                        
                      } catch (SQLException e) {
            printSQLException(e);
                      }
                      return incident;
      }
      
      
      //Select incidents per application
      
      public List<Incident> selectAppIncidents(String appCode) {
                      List<Incident> incidentsapp = new ArrayList<>();
                      try (Connection connection = getConnection();
  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APP_SQL);) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, appCode);
            ResultSet rs = preparedStatement.executeQuery();
            
            //Process the result set object.
            while (rs.next()) {
  String incident_number = rs.getString("incident_number");
  String date_raised = rs.getString("date_raised");
  String raised_by = rs.getString("raised_by");
  String app_code = rs.getString("app_code");
  String description = rs.getString("description");
  String comments = rs.getString("comments");
  String jira = rs.getString("jira");
  String priority = rs.getString("priority");
  String target_date = rs.getString("target_date");
  incidentsapp.add(new Incident(incident_number,date_raised,raised_by,app_code,description,comments,jira,priority,target_date));
  
            }
                        
                      } catch (SQLException e) {
            printSQLException(e);
                      }
                      return incidentsapp;
      }
      
            //select all incidents
  
      public List<Incident> selectAllIncidents() {
                      List<Incident> incidentsall = new ArrayList<>();
                      try (Connection connection = getConnection();
  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            //Process the result set object.
            while (rs.next()) {
  String incident_number = rs.getString("incident_number");
  String date_raised = rs.getString("date_raised");
  String raised_by = rs.getString("raised_by");
  String app_code = rs.getString("app_code");
  String description = rs.getString("description");
  String comments = rs.getString("comments");
  String jira = rs.getString("jira");
  String priority = rs.getString("priority");
  String target_date = rs.getString("target_date");
  incidentsall.add(new Incident(incident_number,date_raised,raised_by,app_code,description,comments,jira,priority,target_date));
  
            }
                        
                      } catch (SQLException e) {
            printSQLException(e);
                      }
                      return incidentsall;
      }
      
                      
      
      
      //Update incidents record
      
      public boolean updateIncident(Incident incident) throws SQLException {
                      boolean rowUpdated;
                      try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_INCIDENT_SQL);) {
           
            statement.setString(5, incident.getIncident_number());
            statement.setString(4, incident.getPriority());
            statement.setString(3, incident.getTarget_date());
            statement.setString(2, incident.getJira());
            statement.setString(1, incident.getComments());
         
            rowUpdated = statement.executeUpdate() > 0;
            System.out.println("updated INcident:"+statement);
  
                      }
                      
                      return rowUpdated;
                      
      }
      
                
      private void printSQLException(SQLException ex) {
                      for  (Throwable e : ex) {
            if (e instanceof SQLException) {
  e.printStackTrace(System.err);
  System.err.println("SQLState: " + ((SQLException) e).getSQLState());
  System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
  System.err.println("Message:  " + e.getMessage());
  Throwable t = ex.getCause();
  while (t !=null) {
                  System.out.println("Cause: " + t);
                  t = t.getCause();
  }
              
            }
                      }
      }
      
}
