package xyz.nowaha.nlib.extensions

import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

fun Inventory.fill(itemStack: ItemStack?) {
    for (i in 0 until size) {
        setItem(i, itemStack)
    }
}

fun Inventory.fillSquare(itemStack: ItemStack?, topLeft: Int, width: Int, height: Int) {
    for (rowOffset in 0 until height) {
        for (slotOffset in 0 until width) {
            setItem((topLeft + slotOffset + (rowOffset*9)).coerceAtMost(size - 1), itemStack)
        }
    }
}

fun Inventory.fillSlots(itemStack: ItemStack?, slots: IntArray) {
    for (i in slots) {
        setItem(i, itemStack)
    }
}

fun Inventory.row(row: Int, itemStack: ItemStack?, override: Boolean = true) {
    for (i in (row*9) until ((row + 1) * 9).coerceAtMost(size)) {
        if (!override && (getItem(i) != null && getItem(i)?.type != Material.AIR)) continue
        setItem(i, itemStack)
    }
}