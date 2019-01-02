package com.box.kotlin

import java.awt.SystemColor.menu
import java.io.File
import java.nio.charset.Charset
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.HashMap

val sc = Scanner(System.`in`)
var menuChoose = 0
var history = HashMap<LocalDateTime, String?>()
var box: Box? = null
fun main(args: Array<String>) {
    val input = arrayOf("長度：", "寬度：", "高度：")
    val inputData = FloatArray(3)
    history.clear()
    println("============歡迎來到郵局便利箱系統============")
    operateMenu(sc)
    while (menuChoose != -1) {
        when (menuChoose) {
            0 -> chooseBox(input, inputData)
            1 ->showBoxHistory()
            2 ->showBoxInfo()
        }
    }
}

private fun clearHistory() {
    var clear = -9
    println("是否清除紀錄? 清除請按 1 ，不清除請按任意鍵。")
    clear = sc.nextInt()
    while (clear == 1) {
        history.clear()
        println("紀錄已清除")
        break
    }
    operateMenu(sc)
}

private fun showBoxHistory() {
    println("目前記錄" + history.size + "個")
    while (history.size>0){
        for ((key, value) in history) {
            println("時間:$key => $value")
        }
        clearHistory()
    }
    operateMenu(sc)
}

private fun showBoxInfo() {
    println(File("BoxInfo.txt").readText(Charset.forName("UTF-8")) + "\n")
    operateMenu(sc)

}

private fun chooseBox(input: Array<String>, inputData: FloatArray) {
    for (i in input.indices) {
        println("請輸入 ${input[i]}")
        inputData[i] = sc.nextFloat()
    }
    boxType(inputData[0], inputData[1], inputData[2])
    var chooseTime = LocalDateTime.now()
    history.put(chooseTime, box!!.name)
    operateMenu(sc)
}

fun boxType(length: Float, width: Float, height: Float): Box? {
    if (Box5().validate(length, width, height)) {
        box = Box5()
    } else if (Box1().validate(length, width, height)) {
        box = Box1()
    } else if (Box2().validate(length, width, height)) {
        box = Box2()
    } else if (Box3().validate(length, width, height)) {
        box = Box3()
    } else if (Box4().validate(length, width, height)) {
        box = Box4()
    } else {
        box = Box()
    }
    box!!.printInfo()
    return box
}

fun operateMenu(scanner: Scanner) {
    println(
        "請輸入以下數字進行操作：\n" +
                "★★★ 挑選便利箱：0  ★★★ 查詢紀錄：1 ★★★ 查看便利箱規格：2 ★★★  離開：-1"
    )
    menuChoose = scanner.nextInt()
}

open class Box(var name: String = "Box", var length: Float = 0.0f, var width: Float = 0.0f, var height: Float = 0.0f) {
    fun printInfo() = println(
        "型號：$name\n" +
                "長：$length\t寬：$width\t高：$height\n"
    )

    fun validate(length: Float, width: Float, height: Float): Boolean {
        var bLength: Float = if (length > width) length else width
        var bWidth: Float = if (length > width) width else length
        return this.length >= bLength && this.width>= bWidth && this.height >= height
    }
}

class Box1 : Box("Box1：長型便利箱 ", 31f, 22.8f, 10.3f)

class Box2 : Box("Box2：方型便利箱 ", 23f, 18f, 19f)

class Box3 : Box("Box3：90cm便利箱 ", 39.5f, 27.5f, 23f)

class Box4 : Box("Box4：長柱型便利箱 ", 10f, 10f, 62.5f)

class Box5 : Box("Box5：小型便利箱 ", 23f, 14f, 13f)