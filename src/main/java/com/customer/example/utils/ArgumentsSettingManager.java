package com.customer.example.utils;

import com.customer.example.entity.ResultType;
import com.customer.example.exception.ParseArgumentsException;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

public class ArgumentsSettingManager {

    private static ArgumentsSettingManager INSTANCE;
    private ResultType typeOperation;
    private File input;
    private File output;

    private ArgumentsSettingManager() {
    }

    public static ArgumentsSettingManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ArgumentsSettingManager();
        return INSTANCE;
    }

    public void parseArguments(String[] args) {
        if (args.length != 3) {
            throw new ParseArgumentsException("Error: 3 arguments are required for processing [operation type, path to input and output files]");
        }

        Optional<ResultType> resultType = Arrays.stream(args).filter(s -> s.equals("search") || s.equals("stat"))
                .map(s -> s.equals("search") ? ResultType.search : ResultType.stat).findFirst();

        Optional<String> filePathInput = Arrays.stream(args).filter(s -> s.contains("json")).reduce((s, s2) -> s);
        Optional<String> filePathOutput = Arrays.stream(args).filter(s -> s.contains("json")).reduce((s, s2) -> s2);

        resultType.ifPresent(resultType1 -> typeOperation = resultType1);
        filePathInput.ifPresent(path -> input = FileUtil.getFile(path));
        filePathOutput.ifPresent(path -> output = FileUtil.getFile(path));
    }

    public ResultType getTypeOperation() {
        return typeOperation;
    }

    public File getInput() {
        return input;
    }

    public File getOutput() {
        return output;
    }
}
