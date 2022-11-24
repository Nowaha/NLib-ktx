package xyz.nowaha.nlib.extensions

import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

/**
 * Extension functions for a [org.bukkit.inventory.Inventory]
 */
object InventoryExtensions {

    /**
     * Fill the whole inventory with an item.
     *
     * @param itemStack The nullable [ItemStack] to fill the inventory with.
     * @receiver [org.bukkit.inventory.Inventory]
     */
    fun Inventory.fill(itemStack: ItemStack?) {
        for (i in 0 until size) {
            setItem(i, itemStack?.clone())
        }
    }

    /**
     * Fill a rectangle in an inventory with an item.
     *
     * @param itemStack The nullable [ItemStack] to fill the inventory with.
     * @param topLeft The top left slot to start with.
     * @param width The width of the rectangle to fill.
     * @param height The height of the rectangle to fill.
     * @receiver [org.bukkit.inventory.Inventory]
     */
    fun Inventory.fillRectangle(itemStack: ItemStack?, topLeft: Int, width: Int, height: Int) {
        for (rowOffset in 0 until height) {
            for (slotOffset in 0 until width) {
                setItem((topLeft + slotOffset + (rowOffset*9)).coerceAtMost(size - 1), itemStack)
            }
        }
    }

    /**
     * Fill specific slots in an inventory.
     *
     * @param itemStack The nullable [ItemStack] to fill the inventory with.
     * @param slots The slots, as an [IntArray], to fill.
     * @receiver [org.bukkit.inventory.Inventory]
     */
    fun Inventory.fillSlots(itemStack: ItemStack?, slots: IntArray) {
        for (i in slots) {
            setItem(i, itemStack)
        }
    }

    /**
     * Fill a row in an inventory.
     *
     * @param row The row of the inventory to fill.
     * @param itemStack The nullable [ItemStack] to fill the inventory with.
     * @param override Whether slots with items in them already will be filled.
     * @receiver [org.bukkit.inventory.Inventory]
     */
    fun Inventory.row(row: Int, itemStack: ItemStack?, override: Boolean = true) {
        for (i in (row*9) until ((row + 1) * 9).coerceAtMost(size)) {
            if (!override && (getItem(i) != null && getItem(i)?.type != Material.AIR)) continue
            setItem(i, itemStack)
        }
    }

}
