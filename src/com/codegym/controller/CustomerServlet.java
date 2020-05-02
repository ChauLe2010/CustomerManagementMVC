package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.omg.CORBA.Request;

import javax.print.attribute.standard.PresentationDirection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService=new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null)
            action="";
        switch (action){
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            case "view":
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null)
            action="";
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteFrom(request,response);
                break;
            case "view":
                viewCustomer(request,response);
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer=this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer!=null){
            dispatcher=request.getRequestDispatcher("customer/viewDetail.jsp");
            request.setAttribute("customer",customer);
        }else{
            dispatcher= request.getRequestDispatcher("error-404.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer=this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer!=null){
            this.customerService.remove(id);
            dispatcher=request.getRequestDispatcher("customer/delete.jsp");
            request.setAttribute("successMessage","Deleted!");
        }else{
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeleteFrom(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer=this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer!=null){
            dispatcher=request.getRequestDispatcher("customer/delete.jsp");
            request.setAttribute("customer",customer);
        }else{
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        Customer customer=this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer!=null){
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            this.customerService.update(id,customer);
            request.setAttribute("successMessage","Update successful!");
            request.setAttribute("customer",customer);
            dispatcher= request.getRequestDispatcher("customer/edit.jsp");
        }else{
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer=this.customerService.findById(id);

        RequestDispatcher dispatcher=request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer",customer);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher=request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        //int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int id = (int)(Math.random() * 10000);

        Customer customer=new Customer(id,name,email,address);
        this.customerService.save(customer);

        RequestDispatcher dispatcher=request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("successMessage","Create successful!");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.customerService.findAll();
        request.setAttribute("customers", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
