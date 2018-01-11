package com.tw.training.fp.declarative;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author pzzheng
 * @date 1/11/18
 */
public class Validators {


    public static List<String> validate(Map<String, Object> input, Validator... validators) {
        return Arrays.stream(validators).filter(v -> v.validate(input).isPresent())
                .map(v -> v.validate(input).get())
                .collect(Collectors.toList());
    }

    public static Validator fieldMatchesPattern(String fieldName, String pattern, String errorMessage) {
        return input -> input.getOrDefault(fieldName, "").toString().matches(pattern) ?
                Optional.empty() : Optional.of("[字段：" + fieldName + "] " + errorMessage);
    }

    interface Validator {
        Optional<String> validate(Map<String, Object> input);
    }

    public static Validator requireField(String fieldName) {
        return input -> input.getOrDefault(fieldName, "").toString().isEmpty() ?
                Optional.of("[字段：" + fieldName + "] 字段不能为空") : Optional.empty();
    }
}
