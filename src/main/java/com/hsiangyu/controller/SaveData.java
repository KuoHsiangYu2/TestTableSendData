package com.hsiangyu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.hsiangyu.model.CustomerBean;

@WebServlet("/SaveData")
public class SaveData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveData() {
        super();
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        System.out.println("SaveData HttpServlet has been call.");

        /* 在後端Java程式從 request物件 取出JSON格式資料進行解析 */
        JSONArray jsonArray = null;
        String jsonInputString = "";

        Enumeration<String> enumeration = request.getParameterNames();
        while (true == enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String[] values = request.getParameterValues(key);
            System.out.println("key = [" + key + "]");
            System.out.println("values = [" + Arrays.toString(values) + "]");
            jsonInputString = key;
        }

        jsonArray = new JSONArray(jsonInputString);
        System.out.println("jsonArray -> [" + jsonArray.toString() + "]");
        System.out.println("Get JSON array data in Back-End.");

        List<CustomerBean> tableDataList = null;

        if (jsonArray != null) {
            /* 在這邊把 jsonArray物件 轉換成 java.util.ArrayList 以做進一步後續利用。 */
            tableDataList = new ArrayList<CustomerBean>();
            for (int i = 0, len = jsonArray.length(); i < len; i++) {
                JSONObject jsonUnit = jsonArray.getJSONObject(i);
                System.out.println(i + " unit: " + jsonUnit.toString());
                CustomerBean customerBean = new CustomerBean();

                /* 編號 */
                customerBean.setId(jsonUnit.getInt("id"));

                /* 伺服器 */
                customerBean.setServerName(jsonUnit.getString("serverName"));

                /* 角色名稱 */
                customerBean.setRoleName(jsonUnit.getString("roleName"));

                /* Facebook名稱 */
                customerBean.setFacebookName(jsonUnit.getString("facebookName"));

                /* 等級 */
                customerBean.setLevel(jsonUnit.getString("level"));

                tableDataList.add(customerBean);

                customerBean = null;
            }
        }

        System.out.println("最後出來的 ArrayList資料");
        System.out.println("tableDataList = " + tableDataList.toString());

        /* HttpServletResponse.SC_OK == 200 */
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        out.print("SaveData successful");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.process(request, response);
    }

}
