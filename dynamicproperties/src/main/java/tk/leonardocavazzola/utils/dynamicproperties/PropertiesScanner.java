package tk.leonardocavazzola.utils.dynamicproperties;

import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Log
public class PropertiesScanner {
    public static void scanProperties(String path) throws IOException {
        try {
            Properties properties = readFile(path);
            System.setProperties(properties);
        } catch (FileNotFoundException ex) {
            log.warning("File not found");
        }
        log.info("Properties has been scanned");
    }

    private static Properties readFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Properties properties = new Properties();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] kv = line.split("=");
            properties.put(kv[0], kv[1]);
        }
        reader.close();
        return properties;
    }
}
