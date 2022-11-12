@file:Suppress("UNCHECKED_CAST")

package xyz.nowaha.nlib.gui

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import xyz.nowaha.nlib.gui.slots.Slot

interface Gui<T : PluginInventoryHolder> {

    val buttons: HashMap<Slot, (player: Player, holder: T, slot: Int) -> Unit>

    fun getTitle(): String

    fun getFor(player: Player, page: Int = 0): Inventory

    fun open(player: Player) {
        player.openInventory(getFor(player))
    }

    fun onClick(event: InventoryClickEvent) {
        val holder = event.inventory.holder as? T

        if (holder == null) {
            event.whoClicked.closeInventory()
            return
        }

        val player = event.whoClicked as Player
        buttons.entries.firstOrNull { it.key.hasSlot(event.slot) }?.value?.invoke(player, holder, event.slot)
    }

    fun create(holder: T, rows: Int): Pair<Inventory, T> {
        val inventory = Bukkit.createInventory(holder, rows*9, getTitle())
        holder.inventory = inventory
        return Pair(inventory, holder)
    }

}