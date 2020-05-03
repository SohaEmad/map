package map.building.demo.Repository;

import map.building.demo.Module.User;

import java.util.List;

public interface user_repo {

    public List<User> users_data();
    User user_data(int user_id);
    public Iterable<String> get_user_devices(int user_id);
    public Iterable<String> get_user_locationhistory(int user_id);
public User New_user_data(int user_id, double lon, double lat, String mobile);
}
