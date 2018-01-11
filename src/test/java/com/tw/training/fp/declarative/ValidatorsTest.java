package com.tw.training.fp.declarative;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tw.training.fp.declarative.Validators.requireField;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author pzzheng
 * @date 1/11/18
 */
public class ValidatorsTest {
    /**
     * @author pzzheng
     */
    @Test
    public void should_validate_require_fields() {
        Map<String, Object> mapInput = new HashMap(){{
            put("id", 1);
            put("employee_id", "pzzheng");
            put("from_date", "20170101");
            put("to_date", "20180101");
        }};

        List<String> errors = Validators.validate(mapInput, requireField("id"),
                    requireField("employee_id"),
                    requireField("from_date"),
                    requireField("to_date")
                );

        assertThat(errors.isEmpty(), is(true));
    }
}