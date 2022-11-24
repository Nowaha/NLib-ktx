@file:Suppress("UNCHECKED_CAST")

package xyz.nowaha.nlib.gui

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import xyz.nowaha.nlib.gui.slots.Slot

/**
 * The GUI can easily be decorated using [extension functions][xyz.nowaha.nlib.extensions.InventoryExtensions].
 *
 * @param T An implementation of a [PluginInventoryHolder]
 */
interface Gui<T : PluginInventoryHolder> {

    /**
     * This HashMap should contain pairs of a [Slot] object (one or more slots), and a method to move the click
     * to. This can be a simple lambda method, a method reference or anything else.
     * You can make use of the [Player] variable, the current [PluginInventoryHolder] for the player, and the slot
     * as an [Int] that was actually clicked (i.e. in case of there being multiple options).
     */
    val buttons: HashMap<Slot, (player: Player, holder: T, slot: Int) -> Unit>

    /**
     * This method will be called to figure out what the title of a GUI should be.
     * The easiest implementation is as follows:
     * override fun getTitle() = "Inventory Title"
     */
    fun getTitle(): String

    /**
     * This method handles an [InventoryClickEvent] to call the right function from
     * the [buttons] map. There should not be a reason to make changes to this.
     *
     * @param event The [InventoryClickEvent] that was called.
     */
    fun onClick(event: InventoryClickEvent) {
        val holder = event.inventory.holder as? T

        if (holder == null) {
            event.whoClicked.closeInventory()
            return
        }

        val player = event.whoClicked as Player
        buttons.entries.firstOrNull { it.key.hasSlot(event.slot) }?.value?.invoke(player, holder, event.slot)
    }

    /**
     * Create a new inventory with an inventory holder for this GUI.
     *
     * @param holder An instance of a [PluginInventoryHolder] for a player who wants to view this GUI.
     * @param rows The amount of rows the inventory should have. Value must be between 1 (inclusive) and 6 (inclusive).
     * @return A pair of the newly created [Inventory] and the now associated [holder].
     */
    fun create(holder: T, rows: Int): Pair<Inventory, T> {
        if (rows > 6 || rows < 1) throw IllegalArgumentException("Rows has a minimum of 1 and a maximum of 6.")
        val inventory = Bukkit.createInventory(holder, rows*9, getTitle())
        holder.inventory = inventory
        return Pair(inventory, holder)
    }

}