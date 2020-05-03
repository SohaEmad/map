package map.building.demo.Repository;


import map.building.demo.Module.Building_Block;
import map.building.demo.Module.User_mobiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Data_Repository implements DataBase_Repo {

    private JdbcTemplate jdbc;

    @Autowired

    public Data_Repository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public List<Building_Block> building_blocks() {
        return jdbc.query(" SELECT  building.Block_name, count(user_id) as user_count from building inner join trackers t on building.Block_id = t.location_id group by Block_id", new RowMapper<Building_Block>(){
            public Building_Block mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Building_Block(
                        rs.getString("Block_name"),
                        rs.getInt("user_count"));   }
        });
    }




    @Override
    public List<User_mobiles> getallmobiles() {
        return jdbc.query("select * from user_mobile ", new RowMapper<User_mobiles>() {
            public User_mobiles mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User_mobiles(
                        rs.getInt("device_id"),rs.getInt("user_id"),
                        rs.getString("mobile_version"));
            }
        });    }




    public  final double R = 6372.8; // In kilometers

    public  double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }

/*
//in case we needed the distance

    double lat1 = 51.552969; double lon1= -1.777053;


    public List<User_Tracker> doProviderSearch(double lat, double lon){
        int i=0;
       List<User_Tracker> all=getalluserstracks();
        for (User_Tracker track:all) {
            track.setDistance(haversine(lat1, lon1, track.location.lat, track.location.lon));
            if(track.distanceKm>20){
                all.remove(i);
            }
i++;
        }

return  all;
    }
*/
    }
