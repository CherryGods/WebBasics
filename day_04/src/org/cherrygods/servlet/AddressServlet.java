package org.cherrygods.servlet;

import org.cherrygods.dao.AddressDao;
import org.cherrygods.domain.Address;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddressServlet extends HttpServlet {
    //嵌入数据访问层
    private AddressDao addressDao = new AddressDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码，很重要，否则页面提交，中文会出现乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
//设置路径
        String path = "list.jsp";
        String method = req.getParameter("method");
//若请求的url有list
        if (("list").equals(method)) {
            List<Address> list = addressDao.findAll();
            req.setAttribute("list", list);
        } else if (method.equals("add")) {

//注入Address实体类
            Address address = new Address();
//获取参数
            String name = req.getParameter("name");
            String street = req.getParameter("street");
            String city = req.getParameter("city");
            String state = req.getParameter("state");
            String zip = req.getParameter("zip");
//设置增加的属性
            address.setName(name);
            address.setStreet(street);
            address.setCity(city);
            address.setState(state);
            address.setZip(zip);

            addressDao.add(address);
            path = "AddressServlet?method=list";
        } else if (method.equals("delete")) {

//根据id来删除
            int id = Integer.parseInt(req.getParameter("id"));
            addressDao.delete(id);
//要重新查询一遍，否则会报空指针
            path = "AddressServlet?method=list";
        }
//跳转编辑页面url请求如下：


        else if (method.equals("toedit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Address address = addressDao.findById(id);
            path = "edit.jsp";
            req.setAttribute("address", address);
        } else if (method.equals("edit")) {

//根据id修改
            int id = Integer.parseInt(req.getParameter("id"));

            String name = req.getParameter("name");
            String street = req.getParameter("street");
            String city = req.getParameter("city");
            String state = req.getParameter("state");
            String zip = req.getParameter("zip");

            Address address = new Address();
            address.setId(id);
            address.setName(name);
            address.setStreet(street);
            address.setCity(city);
            address.setState(state);
            address.setZip(zip);

            addressDao.update(address);
//把新加入的数据重新加载
            path = "AddressServlet?method=list";
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
//    //设置编码
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");
//    //设置路径
//    String path = "list.jsp";
//    String method = req.getParameter("method");
//    //若请求的url有list
//        if(("list").equalsIgnoreCase(method)){
//        List<Address> list = addressDao.findAll();
//        req.setAttribute("list",list);
//    }else if(method.equalsIgnoreCase("add")){
//        //嵌入实体层
//        Address address = new Address();
//        //获取参数
//        String name = req.getParameter("name");
//        String street = req.getParameter("street");
//        String city = req.getParameter("city");
//        String state = req.getParameter("state");
//        String zip = req.getParameter("zip");
//        //设置增加的属性
//        address.setName(name);
//        address.setStreet(street);
//        address.setCity(city);
//        address.setState(state);
//        address.setZip(zip);
//        //添加到数据库
//        addressDao.add(address);
//        //把新加入的数据重新加载，否则刷新页面会报空指针
//        path = "AddressServlet?method=list";
//    }else if(method.equalsIgnoreCase("delete")){
//        //根据id来删除
//        int id = Integer.parseInt(req.getParameter("id"));
//        addressDao.delete(id);
//        //要重新查询一遍，否则会报空指针
//        path = "AddressServlet?method=list";
//    }else if(method.equalsIgnoreCase("edit")){
//        int id = Integer.parseInt(req.getParameter("id"));
//        Address address = addressDao.findById(id);
//        path = "edit.jsp";
//        req.setAttribute("address", address);
//    }else if(method.equalsIgnoreCase("toedit")){
//        //根据id来修改
//        int id = Integer.parseInt(req.getParameter("id"));
//        String name = req.getParameter("name");
//        String street = req.getParameter("street");
//        String city = req.getParameter("city");
//        String state = req.getParameter("state");
//        String zip = req.getParameter("zip");
//        //设置更新的属性
//        Address address = new Address();
//        address.setId(id);
//        address.setName(name);
//        address.setStreet(street);
//        address.setCity(city);
//        address.setState(state);
//        address.setZip(zip);
//        addressDao.update(address);
//        //刷新数据
//        path = "AddressServlet?method=list";
//    }
//        req.getRequestDispatcher(path).forward(req,resp);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

