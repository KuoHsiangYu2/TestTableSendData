package com.hsiangyu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsiangyu.data.Database;
import com.hsiangyu.model.CustomerBean;

@WebServlet("/TablePage")
public class TablePage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TablePage() {
        super();
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            Class.forName("com.hsiangyu.data.Database");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<CustomerBean> customerBeanList = Database.getDatabaseList();
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("customerBeanList", customerBeanList);
        System.out.println("request.getContextPath() = [" + request.getContextPath() + "]");
        response.sendRedirect(request.getContextPath() + "/tablePage.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* get請求執行這個函數 */

        this.process(request, response);
    }

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* post請求執行這個函數 */

        this.process(request, response);
    }

}
