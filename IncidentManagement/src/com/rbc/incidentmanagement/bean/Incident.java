package com.rbc.incidentmanagement.bean;

public class Incident {

       private String incident_number;
       private String date_raised;
       private String raised_by;
       private String app_code;
       private String description;
       private String comments;
       private String jira;
       private String priority;
       private String target_date;
       
       
       
       
              public Incident(String incident_number,  String app_code,String priority,String target_date,String jira,String comments) {
              super();
              this.incident_number = incident_number;
              this.app_code = app_code;
              this.priority = priority;
              this.target_date = target_date;
              this.jira = jira;
              this.comments = comments;
              
          
              
       }
              public Incident(String incident_number, String date_raised, String raised_by, String app_code, String description, String comments,
                     String jira, String priority, String target_date) {
              super();
              this.incident_number = incident_number;
              this.date_raised = date_raised;
              this.raised_by = raised_by;
              this.app_code = app_code;
              this.description = description;
              this.comments = comments;
              this.jira = jira;
              this.priority = priority;
              this.target_date = target_date;
       }
       public String getIncident_number() {
              return incident_number;
       }
       public void setIncident_number(String incident_number) {
              this.incident_number = incident_number;
       }
       public String getDate_raised() {
              return date_raised;
       }
       public void setDate_raised(String date_raised) {
              this.date_raised = date_raised;
       }
       public String getRaised_by() {
           return raised_by;
       }
       public void setRaised_by(String raised_by) {
           this.raised_by = raised_by;
       }
       public String getApp_code() {
              return app_code;
       }
       public void setApp_code(String app_code) {
              this.app_code = app_code;
       }
       public String getDescription() {
              return description;
       }
       public void setDescription(String description) {
              this.description = description;
       }
       public String getComments() {
              return comments;
       }
       public void setComments(String comments) {
              this.comments = comments;
       }
       public String getJira() {
              return jira;
       }
       public void setJira(String jira) {
              this.jira = jira;
       }
       public String getPriority() {
              return priority;
       }
       public void setPriority(String priority) {
              this.priority = priority;
       }
       public String getTarget_date() {
              return target_date;
       }
       public void setTarget_date(String target_date) {
              this.target_date = target_date;
       }
}
