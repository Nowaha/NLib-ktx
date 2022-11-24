package xyz.nowaha.nlib.extensions

/**
 * Extension functions for a [List]
 */
object ListExtensions {
    /**
     * Get a value from a list if it exists, or else get back a [default].
     *
     * @param index The value to get from the list
     * @param default The value to return if [index] is outside the list bounds.
     * @receiver [List]
     * @return The value at [index] if it's there, and otherwise [default].
     */
    fun <T> List<T>.getOr(index: Int, default: T): T = if (index < size) get(index) else default
}
