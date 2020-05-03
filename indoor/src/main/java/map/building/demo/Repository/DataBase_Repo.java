package map.building.demo.Repository;

import map.building.demo.Module.Building_Block;
import map.building.demo.Module.User_mobiles;

import java.util.List;

public interface DataBase_Repo {

    List<User_mobiles> getallmobiles();
    public List<Building_Block> building_blocks();

}
