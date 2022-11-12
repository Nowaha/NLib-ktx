package xyz.nowaha.nlib.gui.slots

class ArraySlot(private val slots: IntArray) : Slot {
    override fun hasSlot(slot: Int) : Boolean = this.slots.contains(slot)
}