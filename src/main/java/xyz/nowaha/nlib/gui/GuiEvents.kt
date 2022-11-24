package xyz.nowaha.nlib.gui

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

/**
 * This interface should be extended in your own class with all your [GUIs][Gui] registered in the [registeredGUIs] variable.
 *
 * Do not forget to register your implementation as an [event listener][org.bukkit.event.Listener] in the [org.bukkit.plugin.PluginManager]
 *
 */
interface GuiEvents : Listener {

    /**
     * This should contain all the [Gui] objects in a simple [listOf].
     * Every GUI in here will properly be passed the on click event.
     *
     * *Note: The title of a GUI is used for this; having GUIs with the exact same title
     * might cause issues. (You can always add invisible color characters at the end)*
     */
    val registeredGUIs: List<Gui<out PluginInventoryHolder>>

    /**
     * This should be **appended** to every single GUI title that is used.
     * The value should be the same for all GUIs.
     *
     * It is used as a fallback in case GUI data gets lost, or a GUI title changes
     * after a reload.
     *
     * This suffix can be visible, but it makes more sense to put in an invisible value
     * by using only color codes (ending in a reset code). Examples:
     * 1. §a§b§c§r
     * 2. §1§r
     * 3. §3§2§1§r
     *
     * *Note: It is a better idea to use [org.bukkit.ChatColor] for this instead of the raw symbol.*
     */
    val guiSuffix: String

    @EventHandler(ignoreCancelled = true)
    fun on(event: InventoryClickEvent) {
        if (event.currentItem != null) {
            registeredGUIs.firstOrNull { it.getTitle() == event.view.title }?.let {
                event.isCancelled = true
                if (event.clickedInventory == event.view.topInventory) {
                    it.onClick(event)
                }
            } ?: run {
                if (event.view.title.endsWith(guiSuffix)) {
                    event.isCancelled = true
                    event.whoClicked.closeInventory()
                }
            }
        }
    }

}