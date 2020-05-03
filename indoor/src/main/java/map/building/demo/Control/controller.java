package map.building.demo.Control;

import map.building.demo.Module.Building_Block;
import map.building.demo.Module.User;
import map.building.demo.Module.User_mobiles;
import map.building.demo.Repository.DataBase_Repo;
import map.building.demo.Repository.user_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

    @Controller
    public class controller {

        private final DataBase_Repo data;
        private final user_repo user;
        @Autowired
        public controller(DataBase_Repo data, user_repo user) {
            this.data = data;
            this.user = user;
        }

        // return user information for one user by user_id
        @CrossOrigin
        @GetMapping(path="/user", produces="application/json")
        @ResponseBody
        public User User_query(@RequestParam int user_id){
            return user.user_data(user_id);
        }

        // get user information and update the database
        @CrossOrigin
        @GetMapping(path="/update_user", produces="application/json")
        @ResponseBody
        public User User_query(@RequestParam int user_id, @RequestParam double lon, @RequestParam double lat, @RequestParam String mobile ){
            return user.New_user_data( user_id,  lon,  lat,  mobile);
        }



        // return all users
        @CrossOrigin
        @GetMapping(path="/users", produces="application/json")
        @ResponseBody
        public List<User> owner_query_user(){
            return user.users_data();
        }

        // return heat map for all blocks
        @CrossOrigin
        @GetMapping(path="/building", produces="application/json")
        @ResponseBody
        public List<Building_Block> owner_query_building(){
            return data.building_blocks();
        }
        // return all mobile devices for all users
        @CrossOrigin
        @GetMapping(path="/mobile", produces="application/json")
        @ResponseBody
        public List<User_mobiles> owner_query_mobile(){
            return data.getallmobiles();
        }




    }

