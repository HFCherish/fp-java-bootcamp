package com.tw.training.fp.declarative;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tw.training.fp.declarative.Validators.requireField;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author pzzheng
 * @date 1/11/18
 */
public class ValidatorsTest {
    public HashMap validInput() {
        return new HashMap() {{
            put("id", 1);
            put("employee_id", "pzzheng");
            put("from_date", "20170101");
            put("to_date", "20180101");
        }};
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_no_error_when_meet_the_constraints() {

        List<String> errors = Validators.validate(validInput(), requireField("id"),
                requireField("employee_id"),
                requireField("from_date"),
                requireField("to_date"),
                Validators.fieldMatchesPattern("employee_id", "^[a-z][a-z_]*[a-z]$", "字段不满足命名规范：只能由小写字母和下划线组成")
        );

        assertThat(errors.isEmpty(), is(true));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_error_when_miss_require_fields() {
        Map<String, Object> input = validInput();
        input.remove("id");

        List<String> errors = Validators.validate(input, requireField("id"),
                requireField("employee_id"),
                requireField("from_date"),
                requireField("to_date")
        );

        assertThat(errors.isEmpty(), is(false));
        assertThat(errors.size(), is(1));
        assertThat(errors.get(0), containsString("id"));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_error_when_violate_pattern_constraint() {

        HashMap input = validInput();
        input.replace("employee_id", "_fjkd");

        List<String> errors = Validators.validate(input, requireField("id"),
                requireField("employee_id"),
                requireField("from_date"),
                requireField("to_date"),
                Validators.fieldMatchesPattern("employee_id", "^[a-z][a-z_]*[a-z]$", "字段不满足命名规范：只能由小写字母和下划线组成")
        );

        assertThat(errors.isEmpty(), is(false));
        assertThat(errors.size(), is(1));
        assertThat(errors.get(0), containsString("字段不满足命名规范：只能由小写字母和下划线组成"));
        System.out.println(errors);
    }

}