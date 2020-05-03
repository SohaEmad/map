package map.building.demo.Module;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Building_Block {
    @NonNull
String block_name;
int num_of_visitor ;

    public Building_Block(String block_name, int num_of_visitor) {
        this.block_name = block_name;
        this.num_of_visitor = num_of_visitor;
    }
}
