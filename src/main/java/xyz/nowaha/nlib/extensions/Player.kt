package xyz.nowaha.nlib.extensions

import org.bukkit.entity.Player

fun Player.sendIfNotNull(message: String?) {
    message?.let { sendMessage(it) }
}