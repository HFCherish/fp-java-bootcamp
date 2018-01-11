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

    interface Validator {
        Optional<String> validate(Map<String, Object> input);
    }

    public static Validator requireField(String fieldName) {
        return input -> input.getOrDefault(fieldName, "").toString().isEmpty() ?
                Optional.of(fieldName + " cannot be empty") : Optional.empty();
    }
}
