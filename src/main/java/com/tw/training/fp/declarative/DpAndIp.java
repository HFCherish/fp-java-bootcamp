package com.tw.training.fp.declarative;

import java.util.List;

/**
 * @author pzzheng
 * 对比命令式编程 和 声明式编程
 * @date 1/11/18
 */
public class DpAndIp {
    public int countAdults_imperative(List<Student> students) {
        int count = 0;
        for (Student student : students) {
            if (student.age() >= 18) {
                count++;
            }
        }
        return count;
    }

    public int countAdults_declarative(List<Student> students) {
        return (int)students.stream().filter(student -> student.age() >= 18).count();
    }
}

class Student {
    int age;

    public int age() {
        return age;
    }
}
