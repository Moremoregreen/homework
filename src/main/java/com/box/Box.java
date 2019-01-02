package com.box;

public class Box implements PrintBoxInfo {
    protected String name;
    protected float length;
    protected float height;
    protected float width;
    protected int price;
    protected int reuse;
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_4 = 4;
    public static final int TYPE_5 = 5;
    public static final int TYPE_NULL = -9;

    //    public static Box getInstance(float length, float width, float height) {
//
//    }
    @Override
    public void printBoxInfo() {
        System.out.println("型號：" + name + "\n" +
                "長：" + length + "\t" + "寬：" + width + "\t" + "高：" + height + "\n" +
                "價錢：" + price + "\t" + "重複使用折價：" + reuse);
    }

    ;

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public int getPrice() {
        return price;
    }

    public int getReuse() {
        return reuse;
    }

    protected boolean validate(float length, float width, float height) {
        float blength = length > width ? length : width;
        float bwidth = length > width ? width : length;
        return this.length >= blength && this.width >= bwidth && this.height >= height;
    }
//    protected abstract boolean validate();

    public String getName() {
        return name;
    }
}
