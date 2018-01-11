package com.tw.training.fp.declarative;

import java.util.List;
import java.util.Map;

/**
 * @author pzzheng
 * @date 1/11/18
 */
public class Validators {


    public static List<String> validate(Map<String, Object> input, Validator... validators) {
        return null;
    }

    interface Validator {
        List<String> validate(Map<String, Object> input);
    }

    public static Validator requireField(String fieldName) {
        return null;
    }
}
