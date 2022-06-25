package boundary;

import java.io.FileReader;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class StoredFiles {
    private String storedFile;
    private JsonArray memory;// data on RAM

    public StoredFiles(String storedFile) {
        this.storedFile = storedFile;
        // tu dong doc du lieu tu file len memory
        this.memory = read();
    }

    public int search(String key, String value) {
        // duyet
        int index = -1;

        String name = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();

            name = jsonObject.get(key).getAsString();
            if (value.equals(name)) {
                index = i;//
                break;
            }
        }

        return index;
    }

    public JsonArray read() {
        JsonArray jsonArray = null;

        try (FileReader reader = new FileReader(storedFile)) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    // add to memory
    public void add(JsonObject jsonObject) {
        memory.add(jsonObject);
    }

    public void set(int index, JsonObject jsonObject) {
        memory.set(index, jsonObject);
    }

    public void remove(int index){
        memory.remove(index);
    }

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(storedFile)) {
            gson.toJson(memory, writer);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public JsonArray getAll() {
        return this.memory;
    }

}
