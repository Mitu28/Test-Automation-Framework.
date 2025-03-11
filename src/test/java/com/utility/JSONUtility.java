package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.ui.pojo.Config;
import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Environment;

public class JSONUtility {

    public static String readJson(Env env) {
        Gson gson = new Gson();
        File jsonFile = new File(System.getProperty("user.dir") + "//config//config.json");

        // Ensure the file exists before proceeding
        if (!jsonFile.exists()) {
            System.out.println("Config file not found: " + jsonFile.getAbsolutePath());
            return null;
        }

        try (FileReader fileReader = new FileReader(jsonFile)) {
            Config config = gson.fromJson(fileReader, Config.class);
            Environment environment = config.getEnvironments().get("QA");
            if (environment != null) {
                System.out.println(environment.getUrl());
                return environment.getUrl();
            } else {
                System.out.println("Environment 'QA' not found in config.");
                return null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
}
