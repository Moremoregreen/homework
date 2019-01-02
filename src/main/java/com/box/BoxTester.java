package com.box;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BoxTester {
    static Box box;
    static String nowTime = "";
    static int menuChoose = -1;
    static Map<String, String> history = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("============歡迎來到郵局便利箱系統============");
        operateMenu(sc);

        while (menuChoose != -1) {
            switch (menuChoose) {
                case 0:
                    chooseBox(sc);
                    break;
                case 1:
                    showHistory(sc);
                    break;
                case 2:
                    showBoxInfo(sc);
                    break;
                default:
                    break;
            }
        }
        System.out.println("已離開系統");
    }

    private static void showBoxInfo(Scanner sc) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("BoxInfo.txt"));
            String info = br.readLine();
            StringBuffer sb = new StringBuffer();
            while (info != null) {
                sb.append(info + "\r\n");
                info = br.readLine();
            }
            System.out.println(sb.toString());
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("要讀取的文件不存在" + e.getMessage());
        } catch (IOException e) {
            System.out.println("文件讀取錯誤" + e.getMessage());
        }
        operateMenu(sc);
    }

    private static void showHistory(Scanner sc) {
        System.out.println("目前記錄" + history.size() + "個");
        // Get a set of the entries
        Set set = history.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.println(me.getKey() + "\t" + me.getValue());
        }
        clearHistory(sc);
        operateMenu(sc);
    }

    private static void clearHistory(Scanner sc) {
        int clear = -1;
        System.out.println("是否清除紀錄? 清除請按 9 ，不清除請按任意鍵。");
        clear = sc.nextInt();
        while (clear == 9) {
            history.clear();
            System.out.println("紀錄已清除");
            break;
        }
    }

    private static void chooseBox(Scanner sc) {
        float length = input(sc, "Please enter object's length:");
        float width = input(sc, "Please enter object's width:");
        float height = input(sc, "Please enter object's height:");
        boxType(length, width, height);
        nowTime = getNowTime();
        history.put(nowTime, box.getName());
        operateMenu(sc);
    }

    private static void operateMenu(Scanner sc) {
        System.out.println("請輸入以下數字進行操作： " + "\n" +
                "★★★ 挑選便利箱：0  ★★★ 查詢紀錄：1 ★★★ 查看便利箱規格：2 ★★★  離開：-1");
        menuChoose = sc.nextInt();
    }

    private static String getNowTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return formatter.format(now);
    }

    private static Box boxType(float length, float width, float height) {
        if (new Box5().validate(length, width, height)) {
            box = new Box5();
        } else if (new Box1().validate(length, width, height)) {
            box = new Box1();
        } else if (new Box2().validate(length, width, height)) {
            box = new Box2();
        } else if (new Box3().validate(length, width, height)) {
            box = new Box3();
        } else if (new Box4().validate(length, width, height)) {
            box = new Box4();
        } else {
            box = new Box();
        }
        box.printBoxInfo();
        return box;
    }

    private static float input(Scanner sc, String enterInfo) {
        System.out.println(enterInfo);
        return sc.nextFloat();
    }

}
