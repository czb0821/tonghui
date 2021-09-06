<%@ page import="com.czb.pojo.Emp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/3/3
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 3px solid blue;
            width: 80%;
            margin: 0px auto;
        }
        td,th{
            border: 2px solid green;
        }
    </style>
</head>
<body>
<table cellspacing="0px" cellpadding="0px">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>职位</th>
        <th>上级编号</th>
        <th>入职日期</th>
        <th>薪资</th>
        <th>补助</th>
        <th>部门号</th>
        <th>薪资等级</th>
    </tr>
    <%
        List<Emp> emps = (List<Emp>) request.getAttribute("list");
        for (Emp emp : emps) {
    %>
    <tr>
        <td><%=emp.getEmpno()%></td>
        <td><%=emp.getEname()%></td>
        <td><%=emp.getJob()%></td>
        <td><%=emp.getMgr()%></td>
        <td><%=emp.getHiredate()%></td>
        <td><%=emp.getSal()%></td>
        <td><%=emp.getComm()%></td>
        <td><%=emp.getDeptno()%></td>
        <td><%
            Double sal = emp.getSal();
            if(sal<=500){
                out.print("A");
            }else if(sal<=1000){
                out.print("B");
            }else if(sal<=1500){
                out.print("C");
            }else if(sal<=2000){
                out.print("D");
            }else if(sal<=3000){
                out.print("E");
            }else if(sal<=4000){
                out.print("F");
            }else{
                out.print("G");
            }
        %></td>
    </tr>
    <%
        }
    %>
</table>


</body>
</html>
