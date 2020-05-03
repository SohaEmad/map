import org.imintel.mbtiles4j.MBTilesReadException;
import org.imintel.mbtiles4j.MBTilesReader;
import org.imintel.mbtiles4j.Tile;
import org.imintel.mbtiles4j.TileIterator;
import org.imintel.mbtiles4j.model.MetadataBounds;
import org.imintel.mbtiles4j.model.MetadataEntry;

import java.io.File;
import java.io.InputStream;

public class read {

    public static void main(String[] args) throws MBTilesReadException {
        MBTilesReader r = new MBTilesReader(new File("/fullpath/trails.mbtiles"));
//metadata
        MetadataEntry metadata = r.getMetadata();
        String tileSetName = metadata.getTilesetName();
        MetadataEntry.TileSetType type = metadata.getTilesetType();
        String tilesetVersion = metadata.getTilesetVersion();
        String description = metadata.getTilesetDescription();
        MetadataEntry.TileMimeType tileMimeType = metadata.getTileMimeType();
        MetadataBounds bounds = metadata.getTilesetBounds();
        String attribution = metadata.getAttribution();
        
        System.out.println(tileSetName);
        System.out.println(type);
//tiles
        TileIterator tiles = r.getTiles();
        while (tiles.hasNext()) {
            Tile next = tiles.next();
            int zoom = next.getZoom();
            int column = next.getColumn();
            int row = next.getRow();
            InputStream tileData = next.getData();
            System.out.println(tileData);
        }
        tiles.close();
        r.close();
    }
}
