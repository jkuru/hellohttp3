
package com.example.http3.controller;

import com.example.http3.model.Employee;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// [START example]
@SuppressWarnings("serial")
@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Employee employee = new Employee();
        employee.setDepartment("Digital");
        employee.setId(203930);
        employee.setName("Jerry Kuru");
        employee.setSalary(3000000l);
        String employeeJsonString = new Gson().toJson(employee);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }
}
// [END example]
