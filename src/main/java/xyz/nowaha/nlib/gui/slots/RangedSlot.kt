package xyz.nowaha.nlib.gui.slots

/**
 * A slot record which contains more than one slot in the form of an [IntRange].
 * This is here so it's easy to create slots using Kotlin ranges like 1..5
 */
class RangedSlot(private val slots: IntRange) : Slot {
    override fun hasSlot(slot: Int) : Boolean = this.slots.contains(slot)
}