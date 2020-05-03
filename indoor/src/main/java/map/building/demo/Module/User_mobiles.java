package map.building.demo.Module;

import lombok.Data;
import lombok.NonNull;

@Data
public class User_mobiles {
    @NonNull
    int device_id;
    int user_id;
    @NonNull
    String mobile_module;

    public User_mobiles(int device_id ,int user_id, @NonNull String mobile_module) {
          this.device_id = device_id;
        this.user_id = user_id;
        this.mobile_module = mobile_module;
    }
    public User_mobiles( int user_id, @NonNull String mobile_module) {
      //  this.device_id = device_id;
        this.user_id = user_id;
        this.mobile_module = mobile_module;
    }
}
