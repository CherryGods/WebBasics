package org.cherrygods.dao;

import org.cherrygods.domain.Address;
import org.cherrygods.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据访问层
 * @author cherrygods
 * @since ２０１８－０６－１０　１７：３５：５５
 */
public class AddressDao {
    /**
     * 增加
     * @param address
     */
    public void add(Address address){
        try{
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement
                    ("INSERT INTO address(name,street,city,state,zip) value (?,?,?,?,?)");
            ps.setString(1,address.getName());
            ps.setString(2,address.getStreet());
            ps.setString(3,address.getCity());
            ps.setString(4,address.getState());
            ps.setString(5,address.getZip());
            //执行
            ps.executeUpdate();
            //释放资源
            JdbcUtil.close(ps,connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 删除
     * @param id address表中的id
     */
    public void delete(int id){
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement
                    ("DELETE FROM address WHERE id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
            JdbcUtil.close(ps,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新
     * @param address
     */
    public void update(Address address){
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement
                    ("UPDATE address SET name=?,street = ?,city=?,state=?,zip=? WHERE id = ?");
            ps.setInt(1,address.getId());
            ps.setString(2, address.getName());
            ps.setString(3,address.getStreet());
            ps.setString(4,address.getCity());
            ps.setString(5,address.getState());
            ps.setString(6,address.getZip());
            ps.executeUpdate();
            JdbcUtil.close(ps,connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有
     * @return List<Address>
     */
    public List<Address> findAll(){
        List<Address> addressList = new ArrayList<>();
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement
                    ("SELECT * FROM address");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setName(rs.getString("name"));
                address.setStreet(rs.getString("street"));
                address.setCity(rs.getString("city"));
                address.setState(rs.getString("state"));
                address.setZip(rs.getString("zip"));
                addressList.add(address);
            }
            JdbcUtil.close(ps,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressList;
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Address findById(int id){
        Address address = new Address();
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement
                    ("SELECT (id,name,street,city,state,zip) FROM address WHERE id = "+id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                address.setId(rs.getInt("id"));
                address.setName(rs.getString("name"));
                address.setStreet(rs.getString("street"));
                address.setCity(rs.getString("city"));
                address.setState(rs.getString("state"));
                address.setZip(rs.getString("zip"));
            }
            JdbcUtil.close(ps,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }
}
