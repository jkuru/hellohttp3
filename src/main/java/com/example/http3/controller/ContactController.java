package com.example.http3.controller;

import com.example.http3.model.Contact;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "contact", value = "/contact")
public class ContactController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Contact> contactList = new ArrayList<>();
        Contact contact1 = new Contact();
        contact1.setFirstName("Jerry");
        contact1.setLastName("Kuru");
        Contact contact2 = new Contact();
        contact2.setFirstName("Fight");
        contact2.setLastName("Back");
        Contact contact3 = new Contact();
        contact3.setFirstName("You can");
        contact3.setLastName("doit");
        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        String employeeJsonString = new Gson().toJson(contactList);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }

}
