package com.example.d1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    // 所有学生都存在这个列表里；static 让 main 和下面三个方法都能直接用
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            System.out.print("请选择：");

            int choice;
            try {
                choice = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("请输入数字！");
                continue;   // 回到 while 开头，菜单重新显示
            }

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                showAll();
            } else if (choice == 3) {
                sortByScore();
            } else if (choice == 4) {
                System.out.println("再见！");
                break;
            } else {
                System.out.println("没有这个选项，请输入 1~4。");
            }
        }
        sc.close();
    }

    static void showMenu() {
        System.out.println();
        System.out.println("===== 学生成绩管理系统 =====");
        System.out.println("1. 录入成绩");
        System.out.println("2. 显示全部");
        System.out.println("3. 按分数排序（高 → 低）");
        System.out.println("4. 退出");
    }

    static void addStudent() {
        System.out.print("姓名：");
        String name = sc.next();

        System.out.print("分数：");
        double score;
        try {
            score = Double.parseDouble(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("请输入数字！");
            return;   // 本次录入取消，回到菜单
        }

        // 需求没要求，但演示时很加分
        if (score < 0 || score > 100) {
            System.out.println("分数要在 0~100 之间。");
            return;
        }

        students.add(new Student(name, score));
        System.out.println("录入成功：" + name + " " + score + " 分");
    }

    static void showAll() {
        if (students.isEmpty()) {
            System.out.println("还没有学生，请先录入。");
            return;
        }
        System.out.println("----- 全部学生 -----");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    static void sortByScore() {
        if (students.isEmpty()) {
            System.out.println("还没有学生，请先录入。");
            return;
        }
        Collections.sort(students);   // 顺序由 Student.compareTo 决定
        System.out.println("排序完成（高 → 低）：");
        showAll();
    }

}
