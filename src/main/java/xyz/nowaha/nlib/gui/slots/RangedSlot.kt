package xyz.nowaha.nlib.gui.slots

class RangedSlot(private val slots: IntRange) : Slot {
    override fun hasSlot(slot: Int) : Boolean = this.slots.contains(slot)
}