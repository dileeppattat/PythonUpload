package com.rbc.incidentmanagement.web;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rbc.incidentmanagement.bean.Incident;
import com.rbc.incidentmanagement.dao.IncidentDao;

/**
* Servlet implementation class IncidentServlet
*/
@WebServlet("/")
public class IncidentServlet extends HttpServlet {
                private static final long serialVersionUID = 1L;
                                private IncidentDao incidentDao;
       

                /**
                * @see Servlet#init(ServletConfig)
                */
                public void init() throws ServletException {
                                incidentDao = new IncidentDao();
                }
                
                /**
                * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                                doGet(request, response);
                }
                /**
                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                String action = request.getServletPath();
               
                    switch (action) {
                    
                    
                case "/edit":
                                
                    try {
                                      showEditForm(request, response);
                     } catch (SQLException | ServletException | IOException e) {
                                     // TODO Auto-generated catch block
                                      e.printStackTrace();
                      }
                      break;
                
                case "/update":
                     try {
                                      updateIncident(request, response);
                      } catch (SQLException | IOException e) {
                                        // TODO Auto-generated catch block
                                      e.printStackTrace();
                      }
                                                
                     break;
                
                case "/tet0":
                     try {
                                     listAppIncident(request, response);
                     } catch (SQLException | IOException e) {
                                      // TODO Auto-generated catch block
                                     e.printStackTrace();
                      }
                                              
                     break;
                     
                case "/yqy0":
                    try {
                                    listAppIncident(request, response);
                    } catch (SQLException | IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }
                                    
                    break;
                    
                    
                case "/rho0":
                    try {
                                    listAppIncident(request, response);
                    } catch (SQLException | IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }
                                    
                    break;
                    
                case "/tcb0":
                    try {
                                    listAppIncident(request, response);
                    } catch (SQLException | IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }
                                    
                    break;
                    
                case "/zaq0":
                    try {
                                    listAppIncident(request, response);
                    } catch (SQLException | IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }
                                    
                    break;
                    
                case "/tes0":
                    try {
                                    listAppIncident(request, response);
                    } catch (SQLException | IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }
                                    
                    break;
                    
                case "/ueq0":
                    try {
                                    listAppIncident(request, response);
                    } catch (SQLException | IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }
                                    
                    break;
                    
                case "/xvj0":
                    try {
                                    listAppIncident(request, response);
                    } catch (SQLException | IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }
                                    
                    break;
                    
                case "/wow0":
                    try {
                                    listAppIncident(request, response);
                    } catch (SQLException | IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                    }
                                    
                    break;
                                                
                default:
                               try {
                                                 listIncident(request, response);
                                } catch (SQLException | IOException | ServletException e) {
                                                  // TODO Auto-generated catch block
                                                 e.printStackTrace();
                                }
                                break;
                                          
                }
                                }
                
                //edit
                private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
                                String incident_number = request.getParameter("incident_number");
                                Incident existingIncident;
                                try {
                                    
                                                System.out.println(incident_number);
                                                existingIncident = incidentDao.selectIncident(incident_number);
                                                RequestDispatcher dispatcher = request.getRequestDispatcher("update-form.jsp");
                                                request.setAttribute("incident", existingIncident);
                                                dispatcher.forward(request, response);
                                }catch (Exception e) {
                                                e.printStackTrace();
                                }
                }
                
                //update incident
                private void updateIncident(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
                                String incident_number = request.getParameter("incident_number");
                                String app_code = request.getParameter("app_code");
                                String priority = request.getParameter("priority");
                                String target_date = request.getParameter("target_date");
                                String jira = request.getParameter("jira");
                                String comments = request.getParameter("comments");
                                Incident book = new Incident(incident_number,app_code,priority, target_date, jira, comments);
                                incidentDao.updateIncident(book);
                                response.sendRedirect("http://fxsupport:8081/IncidentManagement/tet0?app_code="+app_code);
                }
                
                //Select by application code
                private void listAppIncident(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
                                try {
                                String app_code = request.getParameter("app_code");
                                List<Incident> listAppIncident = incidentDao.selectAppIncidents(app_code);
                                request.setAttribute("listAppIncident", listAppIncident);
                                RequestDispatcher dispatcher = request.getRequestDispatcher("app.jsp");
                                dispatcher.forward(request, response);
                } catch (Exception e) {
                                e.printStackTrace();
                }

}

                //default section of the switch
                
                private void listIncident(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
                                try {
                                List<Incident> listIncident = incidentDao.selectAllIncidents();
                                request.setAttribute("listIncident", listIncident);
                               RequestDispatcher dispatcher = request.getRequestDispatcher("incident-list.jsp");
                                dispatcher.forward(request, response);
                } catch (Exception e) {
                                e.printStackTrace();
                }

}

}
