package xyz.nowaha.nlib.gui.slots

/**
 * The main inventory slot interface which is implemented as [SingleSlot], [ArraySlot] or [RangedSlot].
 */
interface Slot {

    /**
     * Implemented to check whether a given [Int] is equal to or within the boundaries of a [Slot].
     */
    fun hasSlot(slot: Int) : Boolean
}