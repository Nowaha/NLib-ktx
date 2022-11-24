package xyz.nowaha.nlib.gui.slots

/**
 * A slot record for a singular slot (single [Int]).
 */
class SingleSlot(private val slot: Int) : Slot {
    override fun hasSlot(slot: Int) : Boolean = this.slot == slot
}