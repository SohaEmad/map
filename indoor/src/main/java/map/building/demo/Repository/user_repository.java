package map.building.demo.Repository;

import map.building.demo.Module.User;
import map.building.demo.Module.User_Tracker;
import map.building.demo.Module.User_mobiles;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class user_repository implements user_repo{

    private JdbcTemplate jdbc;
    public user_repository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> users_data() {
        String sql= "SELECT * FROM users ";
        List<User> all= jdbc.query(sql, new RowMapper<User>(){
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return  new User(rs.getInt("user_id"),
                        rs.getString("user_name"),rs.getString("user_phone"));}});
        for (User x: all) {


            x.setLocation_history(get_user_locationhistory(x.getUser_id()));
            x.setDevices(get_user_devices(x.getUser_id()));
        }
        return all;
    }

    // insert new user
    @Override
    public User New_user_data(int user_id, double lon, double lat,  String mobile){

       int location_id= get_location(lon,lat);
       User_Tracker t =new User_Tracker(user_id,location_id);
        String sql="insert into trackers (user_id, location_id) values (?,?)";
        jdbc.update(sql,t.user_id, t.location);

        User_mobiles u= new User_mobiles(user_id,mobile);
        String sql2="insert into user_mobile (user_id, mobile_version) values(?,?) ";
        //WHERE \""+ mobile +"\" NOT IN (select mobile_version from user_mobile where user_id="+user_id+
        jdbc.update(sql2,user_id, mobile);
        User x= user_data(user_id);
        return x;
    }

public int get_location (double lon, double lat){
String sql = "select Block_id from building where lat ="+lat +"and lon="+lon;
        return  jdbc.queryForObject(sql, new RowMapper<Integer>(){
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("Block_id");}});

}

    @Override
    public User user_data(int user_id) {
        String sql= "SELECT * FROM users where user_id= "+user_id;
        User x= jdbc.queryForObject(sql, new RowMapper<User>(){
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return  new User(user_id,
                        rs.getString("user_name"),rs.getString("user_phone"));}});
        x.setLocation_history( get_user_locationhistory(user_id));
        x.setDevices(get_user_devices(user_id));
        return x;
    }


    @Override
    public Iterable<String> get_user_locationhistory(int user_id) {
        List<String> data= jdbc.query("SELECT  Block_name FROM building inner join trackers t on building.Block_id = t.location_id where user_id=?", new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return    rs.getString("Block_name");
            }},user_id);
        return tostring(data);
    }


    @Override
    public Iterable<String> get_user_devices(int user_id) {
        List<String> data= jdbc.query("SELECT  distinct mobile_version FROM user_mobile where user_id=?", new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return    rs.getString("mobile_version");
            }
        },user_id);
        return tostring(data);
    }

    public Iterable<String> tostring (List<String> data){
        String out="" ;
        for (String x: data) {
            out+=x+",";
        }

        out=  out.replaceAll("\\s","");
        data.clear();
        data.addAll(Arrays.asList(out.split(",")));
        Set<String> set = new HashSet<>(data);
        data.clear();
        data.addAll(set);
        return data;
    }

}
