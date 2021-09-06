package com.czb.servlet;

import com.czb.dao.EmpDao;
import com.czb.dao.impl.EmpDaoImpl;
import com.czb.pojo.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 新厝埕 czb
 */
@WebServlet(urlPatterns = "/testservlet.do")
public class testServlet extends HttpServlet {
    EmpDao empDao = new EmpDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> list = empDao.findAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("Emptest.jsp").forward(req,resp);
    }
}
