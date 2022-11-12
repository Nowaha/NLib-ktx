package xyz.nowaha.nlib.gui

import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

abstract class PluginInventoryHolder(private var inventory: Inventory?) : InventoryHolder {

    override fun getInventory(): Inventory {
        return inventory!!
    }

    fun setInventory(inventory: Inventory) {
        this.inventory = inventory
    }

}