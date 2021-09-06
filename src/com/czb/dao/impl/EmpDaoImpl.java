package com.czb.dao.impl;

import com.czb.dao.EmpDao;
import com.czb.pojo.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 新厝埕 czb
 */
public class EmpDaoImpl implements EmpDao{
    public String url = "jdbc:mysql://127.0.0.1:3306/mytestdb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    public String username = "root";
    public String password = "root";

    @Override
    public List<Emp> findAll() {
        Connection connection = null;
        PreparedStatement pS = null;
        ResultSet resultSet = null;

        List<Emp> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            pS = connection.prepareStatement("select * from emp");
            resultSet = pS.executeQuery();

            while(resultSet.next()){
                int empno = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate = resultSet.getDate("hiredate");
                double sal = resultSet.getDouble("sal");
                double comm = resultSet.getDouble("comm");
                int deptno = resultSet.getInt("deptno");
                Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(null != resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != pS){
                try {
                    pS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
