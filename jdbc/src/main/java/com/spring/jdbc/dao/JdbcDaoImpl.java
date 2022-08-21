package com.spring.jdbc.dao;

import com.spring.jdbc.models.Circle;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class JdbcDaoImpl {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    Connection connection= null;

    public int getCircleCount(){
        String sql= "select count(*) from Circle";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public String getCircleUsingJdbcTemplate(int id){
        String sql= "select name from Circle where id="+id;
        return jdbcTemplate.queryForObject(sql,String.class);
    }

    public void insertCircle(Circle circle){
        String sql = "insert into Circle (id,name) values (:id, :name)";
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("id", circle.getId());
        namedParameters.put("name", circle.getName());
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public Circle getCircle(int id){
        try {
            this.connection= this.dataSource.getConnection();
            PreparedStatement preparedStatement = this.connection.prepareStatement("select * from circle where id=?");
            preparedStatement.setInt(1,id);

            Circle circle=null;
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                circle= new Circle(id,resultSet.getString("name"));
            }
            resultSet.close();
            preparedStatement.close();
            return  circle;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
