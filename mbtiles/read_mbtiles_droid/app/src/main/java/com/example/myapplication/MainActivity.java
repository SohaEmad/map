package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.imintel.mbtiles4j.MBTilesReadException;
import org.imintel.mbtiles4j.MBTilesReader;
import org.imintel.mbtiles4j.TileIterator;
import org.imintel.mbtiles4j.model.MetadataEntry;
import java.io.File;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MBTilesReader r = null;
        try {
            r = new MBTilesReader(new File("/storage/self/primary/Download/compressed.mbtiles"));
//metadata
            MetadataEntry metadata = r.getMetadata();
            String tileSetName = metadata.getTilesetName();
            MetadataEntry.TileSetType type = metadata.getTilesetType();
            String tilesetVersion = metadata.getTilesetVersion();
            String description = metadata.getTilesetDescription();
            MetadataEntry.TileMimeType tileMimeType = metadata.getTileMimeType();
//            MetadataEntry.MetadataBounds bounds = metadata.getTilesetBounds();
            String attribution = metadata.getAttribution();
//tiles
            System.out.println("the set name is "+tileSetName);
            System.out.println("the set type is "+type);
            TileIterator tiles = r.getTiles();
            while (tiles.hasNext()) {
                TileIterator.Tile next = tiles.next();
                int zoom = next.getZoom();
                int column = next.getColumn();
                int row = next.getRow();
                InputStream tileData = next.getData();
                System.out.println(tileData);
            }
            tiles.close();
            r.close();

        } catch (MBTilesReadException e) {
            e.printStackTrace();
        }
    }
}
