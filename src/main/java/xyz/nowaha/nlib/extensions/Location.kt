package xyz.nowaha.nlib.extensions

import org.bukkit.Bukkit
import org.bukkit.Location

/**
 * Extension functions for a [org.bukkit.Location]
 */
object LocationExtensions {
    /**
     * Extension function to easily convert a [Location] to a storable string.
     *
     * @receiver [org.bukkit.Location]
     * @return The location serialized to a string.
     */
    fun Location.stringSerialize(): String {
        return "${world!!.name};$x;$y;$z;$yaw;$pitch"
    }

    /**
     * Extension function to convert a [serialized][stringSerialize] [Location] back into a [Location] object.
     *
     * @receiver [org.bukkit.Location]
     * @return The location serialized to a string.
     * @throws IllegalArgumentException If the string is not a properly serialized Location. Serialize with [stringSerialize].
     */
    fun String.deserializeLocation(): Location {
        val splitStr = split(";")
        if (splitStr.size != 6) throw IllegalArgumentException("String is not in the right format to deserialize.")
        return Location(
            Bukkit.getWorld(splitStr[0]) ?: throw IllegalArgumentException("Invalid world name in string."),
            splitStr[1].toDoubleOrNull() ?: throw IllegalArgumentException("Invalid value for x in string."),
            splitStr[2].toDoubleOrNull() ?: throw IllegalArgumentException("Invalid value for y in string."),
            splitStr[3].toDoubleOrNull() ?: throw IllegalArgumentException("Invalid value for z in string."),
            splitStr[4].toFloatOrNull() ?: throw IllegalArgumentException("Invalid value for yaw in string."),
            splitStr[5].toFloatOrNull() ?: throw IllegalArgumentException("Invalid value for pitch in string.")
        )
    }
}
