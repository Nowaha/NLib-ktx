package xyz.nowaha.nlib.gui

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

interface GuiEvents : Listener {

    val registeredGUIs: List<Gui<out PluginInventoryHolder>>

    @EventHandler(ignoreCancelled = true)
    fun on(event: InventoryClickEvent) {
        if (event.currentItem != null) {
            registeredGUIs.firstOrNull { it.getTitle() == event.view.title }?.let {
                event.isCancelled = true
                if (event.clickedInventory == event.view.topInventory) {
                    it.onClick(event)
                }
            }
        }
    }

}