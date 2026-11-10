package com.example.d1;

public class Student implements Comparable<Student> {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    // Collections.sort 就是靠这个方法决定谁在前
    @Override
    public int compareTo(Student other) {
        return Double.compare(other.score, this.score);
    }

    // 打印对象时自动调用
    @Override
    public String toString() {
        return "姓名：" + name + "，成绩：" + score;
    }
}