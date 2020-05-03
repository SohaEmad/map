package map.building.demo.Module;

import lombok.Data;

// cancer Services provider
@Data
public class User_Tracker {

    public  int tracker_id;
    public final int user_id;
    public int  location;
   // public double distanceKm;
  //  LocalDateTime tracker_date_time ;

    public User_Tracker( int user_id, int location_id) {
       this.location =location_id;
        this.user_id = user_id;
      //  this.location=new Location(lat,lon);
    }
/*
    public void setMyObj(LocalDateTime myObj) {
        this.tracker_date_time = myObj;
    }


    public void setDistance(double distance) {
        this.distanceKm = distance;
    }
*/
}
