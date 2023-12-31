# JsonUtility
[![](https://jitpack.io/v/najoan125/JsonUtility.svg)](https://jitpack.io/#najoan125/JsonUtility)
<br>
This is the Json library that read and write conveniently<br>
This library was created using org.json.

## Classes and Methods
* **JsonWriter**
  + *writeToFile(JSONObject obj, String path)*
    + Create a JSONObject as a file at that path.
    + it can throws **IOException**
    + JSONObject example:
      ```java
      JSONObject json = new JSONObject();
        try {
            json.put("name", "Google");
            json.put("employees", 140000);
            json.put("offices", List.of("Mountain View", "Los Angeles", "New York"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
      ```
      <br>
* **JsonReader** - This class's methods are return **JSONObject**
  + *readFromURL(String url)*
    + Read all URL contents and convert them to JSON.
    + it can throws **IOException, JsonEmptyException**
  + *readFromURL(String url, int fromLine)*
    + Read from the line fromLine to the last line in the URL and convert it to json.
    + Note: line starts at 1. NOT 0!<br><br>
  + *readFromFile(String path)*
    + Read from File.
    + it can throw **IOException**
  + *readFromFile(String path, int fromLine)*
    + Read from the line fromLine to the last line in the file and convert it to json.
    + Note: line starts at 1. NOT 0!<br><br>
  + *readFromInputStream(InputStream inputStream)*
    + Read from InputStream
  + *readFromInputStream(InputStream inputStream, int fromLine)*
    + Read from the line fromLine to the last line in the inputStream and convert it to json.
    + Note: line starts at 1. NOT 0!
    ### Example
    ```java
    String url = "https://www...";
    JSONObject obj = JsonReader.readFromURL(url, 2);
    
    JSONArray array = obj.getJSONArray("array");
    int jsonInt = obj.getInt("number");
    String jsonString = obj.getString("key");
    JSONObject object = obj.getJSONObject("key");

    JSONObject obj2 = JsonReader.readFromInputStream(Main.class.getResourceAsStream("file"));
    ```

## Maven Setup
```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
```xml
	<dependency>
	    <groupId>com.github.najoan125</groupId>
	    <artifactId>JsonUtility</artifactId>
	    <version>1.1.1</version>
	</dependency>
```

## Editing
This source is licensed under the **MIT license**. Modify or distribute as you like, **but be sure to cite the source!**
