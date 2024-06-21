package com.test.board.unity.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Repository
public class ConvDaoImpl implements ConvDao{

    @Override
    public Map<String, String> getConv(String scriptPath, String userConv) {
        System.out.println("getConvDao");
        ProcessBuilder processBuilder = new ProcessBuilder("python", scriptPath, userConv);
        System.out.println(scriptPath);
        Map<String, String> result = new HashMap<>();
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorr = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line = "";
            String errline ="";
            Type type = new TypeToken<Map<String, String>>(){}.getType();
            errline = errorr.readLine();
            System.out.println (errline);
            line = reader.readLine();
            Map<String, String> output = new Gson().fromJson(line, type);
            System.out.println(output);
            result.putAll(output);
            //}
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                Logger.getGlobal().severe("Error occurred while executing python script.");
            }
        } catch (IOException | InterruptedException e) {
            Logger.getGlobal().severe(e.getMessage());
        }

        return result;
    }
}
