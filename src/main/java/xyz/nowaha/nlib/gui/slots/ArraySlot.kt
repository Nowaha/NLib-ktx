package xyz.nowaha.nlib.gui.slots

/**
 * A slot record which contains more than one slot in the form of an [IntArray].
 */
class ArraySlot(private val slots: IntArray) : Slot {
    override fun hasSlot(slot: Int) : Boolean = this.slots.contains(slot)
}