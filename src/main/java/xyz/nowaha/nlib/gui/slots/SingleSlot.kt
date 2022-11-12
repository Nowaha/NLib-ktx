package xyz.nowaha.nlib.gui.slots

class SingleSlot(private val slot: Int) : Slot {
    override fun hasSlot(slot: Int) : Boolean = this.slot == slot
}