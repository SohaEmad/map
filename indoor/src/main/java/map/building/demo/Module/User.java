package map.building.demo.Module;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    @NonNull
    private  int user_id;
    @NonNull
    private String user_name;
    private String User_phone;

    public User(@NonNull int user_id, @NonNull String user_name, String user_phone) {
        this.user_id = user_id;
        this.user_name = user_name;
        User_phone = user_phone;
    }


    public void setLocation_history(Iterable<String> location_history) {
        Location_history = location_history;
    }

    public void setDevices(Iterable<String> devices) {
        Devices = devices;
    }


   // @NonNull
    private Iterable<String> Location_history ;
    //@NonNull
    private Iterable<String>  Devices;


}
