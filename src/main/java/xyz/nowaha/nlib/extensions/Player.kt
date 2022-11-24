package xyz.nowaha.nlib.extensions

import org.bukkit.entity.Player

/**
 * Extension functions for a [org.bukkit.entity.Player]
 */
object PlayerExtensions {
    /**
     * Can be called on a [Player] to send a [message] when, and only when, it is not null.
     *
     * @param message The nullable message to send to the player.
     * @receiver [org.bukkit.entity.Player]
     */
    fun Player.sendIfNotNull(message: String?) {
        message?.let { sendMessage(it) }
    }
}
