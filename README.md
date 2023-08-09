# JsonUtility
This is the Json library that read and write conveniently<br>
This library was created using org.json.

## Classes and Methods
* **JsonWriter**
  + *writeToFile(JSONObject obj, String path)* - Create a JSONObject as a file at that path. it throws **IOException**
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
  + *readFromURL(String url)* - Read all URL contents and convert them to JSON. it throws **IOException, JsonEmptyException**
  + *readFromURL(String url, int fromLine)* - Read from the line fromLine to the last line in the URL and convert it to json.
  + *readFromFile(String path)* - Read from File. it throw **IOException**
    ### Example
    ```java
    String url = "https://www...";
    JSONObject obj = JsonReader.readFromURL(url, 2);
    JSONArray array = obj.getJSONArray("array");
    int jsonInt = obj.getInt("number");
    String jsonString = obj.getString("key");
    JSONObject object = obj.getJSONObject("key");
    ```
