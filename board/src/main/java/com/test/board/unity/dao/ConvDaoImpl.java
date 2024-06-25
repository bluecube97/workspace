package com.test.board.unity.dao;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.python.util.PythonInterpreter;

@Repository
public class ConvDaoImpl implements ConvDao {

    @Override
    public Map<String, String> getConv(String scriptPath, String userConv, String jsonPath) {
        System.out.println(scriptPath);
        Map<String, String> result = new HashMap<>();

        PythonInterpreter python = new PythonInterpreter();

        StringWriter out = new StringWriter();
        python.setOut(out);

        python.set("user_ment", userConv);
        python.execfile(scriptPath);

        String output = out.toString();
        System.out.println(output);
        python.close();

        return result;
    }

}
