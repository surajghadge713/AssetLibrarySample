## AssetStorage
AssetStorage Library simplify developer task to copy Sqlite Database and Shared Preference file from assets to app internal storage at run time in few lines of code.

## Prerequisites

Add it in your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
## Dependency
Add the dependency

```
dependencies {
    implementation 'com.github.surajghadge713:AssetLibrarySample:1.0'
}
```

## Configuration

1) To copy database from asset to app internal storage. where "dbFile.db" is sqlite file.

```
AssetDatabase assetDatabase = AssetDatabase.getAssetDatabaseInstance(this,"dbFile.db");
assetDatabase.copyDatabase();
```
2) To copy SharedPreference files from asset to app internal storage. where "sharedPrefListb" is an ArrayList of type string. Add SharedPreference file name in list. 

```
private List<String> sharedPrefList;
sharedPrefList= new ArrayList<>();
sharedPrefList.add("one.xml");
sharedPrefList.add("two.xml");

AssetSharedPrefHelper sharedPrefHelper =  AssetSharedPrefHelper.getAssertSharedPrefHelper(this,sharedPrefList);
sharedPrefHelper.storeSharedPref();
```


