
<%@ page language="java" contentType="text/html; charset=UTF-8"
       pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>FX IncidentUser Management</title>
<link rel="stylesheet"
       href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
       integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
       crossorigin="anonymous">
       
       
         
       
       
<style>
    .table td, .table th {
        font-size: 13px;
        font:sans-serif;
    }
</style>
       
       <style>

body {
margin-left: 5mm;
margin-right: 5mm;
margin-top: 10;
}

table {
    counter-reset: tableCount;     
}
.counterCell:before {              
    content: counter(tableCount); 
    counter-increment: tableCount; 
}

body {background-color: black;}

</style>

</head>
<body>

       <header>
       
       
              <nav class="navbar navbar-expand-md navbar-dark navbar-inverse navbar-expand-lg"
                     style="background-color: black">
                     
                     
                     <div>
                           <a href="https://rbcfg.service-now.com" class="navbar-brand"> FX Incident Management </a>
                     </div>

                     <ul class="navbar-nav">
                           <li><a href="<%=request.getContextPath()%>/list"
                                  class="nav-link px-3 color: green">All</a></li>
                     </ul>
                     <ul class="navbar-nav">
                           <li><a href="<%=request.getContextPath()%>/tet0?app_code=tet0"
                                  class="nav-link px-3 ">TET0 (Strat Ecom)</a></li>
                     </ul>
                     <ul class="navbar-nav">
                           <li><a href="<%=request.getContextPath()%>/yqy0?app_code=yqy0"
                                  class="nav-link px-3">YQY0 (Rats)</a></li>
                     </ul>
                     <ul class="navbar-nav">
                           <li><a href="<%=request.getContextPath()%>/rho0?app_code=rho0"
                                  class="nav-link px-3">RHO0 (Client Algo)</a></li>
                     </ul>
                     <ul class="navbar-nav">
                           <li><a href="<%=request.getContextPath()%>/tcb0?app_code=tcb0"
                                  class="nav-link px-3">TCB0 (FX Risk)</a></li>
                     </ul>
                     <ul class="navbar-nav">
                           <li><a href="<%=request.getContextPath()%>/zaq0?app_code=zaq0"
                                  class="nav-link px-3">ZAQ0 (Whistler)</a></li>
                     </ul>
                     <ul class="navbar-nav">
                           <li><a href="<%=request.getContextPath()%>/tes0?app_code=tes0"
                                  class="nav-link px-3">TES0 (Edge)</a></li>
                     </ul>
                     <ul class="navbar-nav">
                           <li><a href="<%=request.getContextPath()%>/ueq0?app_code=ueq0"
                                  class="nav-link px-3">UEQ0 (FX Pricing)</a></li>
                     </ul>
                     <ul class="navbar-nav">
                           <li><a href="<%=request.getContextPath()%>/xvj0?app_code=xvj0"
                                  class="nav-link px-3">XVJ0 (Loonix)</a></li>
                     </ul>
                     <ul class="navbar-nav">
                           <li><a href="<%=request.getContextPath()%>/wow0?app_code=wow0"
                                  class="nav-link px-3">WOW0 (RBCDX)</a></li>
                     </ul>
              </nav>
       </header>
       <br>

       <div class="row">
              <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
              
       
              <table class="table table-bordered table-striped table-dark">
                           <thead>
                                  <tr class="m-0">
                                    <style> 
         th { 
            white-space: nowrap; 
         } 
         th {
  background: black;
  position: sticky;
  top: 0; /* Don't forget this, required for the stickiness */
  box-shadow: 0 2px 2px -1px rgba(0, 0, 0, 0.4);
      </style> 
      
                                         <th style="color:#990000" class="w-2">#</th>
                                         <th style="color:#990000" class="w-5">Incident Number</th>
                                         <th style="color:#990000" class="w-10">Date Raised</th>
                                         <th style="color:#990000" class="w-10">Raised By</th>
                                         <th style="color:#990000" class="w-5">App Code</th>
                                         <th style="color:#990000" class="w-25">Description</th>
                                         <th style="color:#990000" class="w-5">Priority</th>
                                         <th style="color:#990000" class="w-20">Jira</th>
                                         <th style="color:#990000" class="w-5">Target Date</th>
                                         <th style="color:#990000" class="w-20">Comments</th>
                                         <th style="color:#990000" class="w-2">Action</th>
                                  </tr>
                           </thead>
                           <tbody>
                           <c:forEach var="incident" items="${listIncident}">

                                         <tr class="m-0">
                                                <td class="counterCell"></td>
                                                <td><c:out value="${incident.incident_number}" /></td>
                                                <td><c:out value="${incident.date_raised}" /></td>
                                                <td><c:out value="${incident.raised_by}" /></td>
                                                <td><c:out value="${incident.app_code}" /></td>
                                                <td><c:out value="${incident.description}" /></td>
                                                <td><c:out value="${incident.priority}" /></td>
                                                <td><c:out value="${incident.jira}" /></td>
                                                <td><c:out value="${incident.target_date}" /></td>
                                                <td><c:out value="${incident.comments}" /></td>
                                                <td><a href="edit?incident_number=<c:out value='${incident.incident_number}' />" style="color: #39ff14">Update</a>
                                                &nbsp;&nbsp;
                                                                                  
                                         </tr>
                                  </c:forEach>
              
                           </tbody>

                     </table>
                     </div>
       </div>
</body>
</html>
