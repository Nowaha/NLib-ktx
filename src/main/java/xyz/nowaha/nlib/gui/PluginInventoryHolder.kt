package xyz.nowaha.nlib.gui

import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

/**
 * Using the inventory holder, you can store data inside the GUI while the GUI is open.
 * This allows you to keep data, like pages, on the GUI without having to keep track of what GUI
 * has what data.
 *
 * You can override this as a data class and simply add any variables you need inside the constructor
 * for the simplest implementation, not having to touch any of the existing methods.
 */
abstract class PluginInventoryHolder(private var inventory: Inventory?) : InventoryHolder {

    override fun getInventory(): Inventory {
        return inventory!!
    }

    fun setInventory(inventory: Inventory) {
        this.inventory = inventory
    }

}