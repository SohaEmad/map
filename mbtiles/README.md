# mbtiles
this repo include an application for this https://github.com/imintel/mbtiles4j library usage in java and android project 

## java 
just work fine 

## android

complain about the sqlite file with .mbtiles extension or .db extension 

```
 java.lang.UnsatisfiedLinkError: dalvik.system.PathClassLoader[DexPathList[[zip file "/data/app/com.example.myapplication-hPXYpl5DxEIfSYY2GBVDyw==/base.apk"],nativeLibraryDirectories=[/data/app/com.example.myapplication-hPXYpl5DxEIfSYY2GBVDyw==/lib/arm64, /system/lib64]]] couldn't find "libsqlitejdbc.so"
```

have tried many staff to fix one of the fixes 

https://bitbucket.org/xerial/sqlite-jdbc/issues/236/unsatisfiedlinkerror-couldnt-find

another code looked good in kotline https://gist.github.com/typebrook/7d25be326f0e9afd58e0bbc333d2a175 

trials.mbtiles is an example from MapBox site for a set of vector tiles so it's valid 

- you can show the database through https://sqlitebrowser.org/ or simply in intelliJ database from source file 
- a valid file should have data in map , metadata tables and tiles views in the case of .mbtiles for vector tiles 
- a raster .mbtiles include tiles table 


the origin of working on this is to read the file produced by this tutorial from a vector tile server 
https://github.com/mapbox/node-mbtiles
