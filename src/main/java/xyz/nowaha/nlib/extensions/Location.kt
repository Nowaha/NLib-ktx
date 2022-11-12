package xyz.nowaha.nlib.extensions

import org.bukkit.Bukkit
import org.bukkit.Location

fun Location.stringSerialize(): String {
    return "${world!!.name};$x;$y;$z;$yaw;$pitch"
}

fun String.deserializeLocation(): Location {
    val splitStr = split(";")
    return Location(Bukkit.getWorld(splitStr[0]), splitStr[1].toDouble(), splitStr[2].toDouble(), splitStr[3].toDouble(), splitStr[4].toFloat(), splitStr[5].toFloat())
}