#Module NLib-ktx
Documentation for the Kotlin part of the NLib library. The GitHub source code can be found [here](https://github.com/Nowaha/NLib-ktx).

#Package xyz.nowaha.nlib.extensions
Useful extension functions with a variety of purposes.

#Package xyz.nowaha.nlib.gui
Utilities to help you to easily create custom inventories to use as GUIs.

To get an extremely bare-bones GUI:
1. Create a GUI by implementing the `Gui` interface.
2. Override the `getTitle()` method to return
   - Example implementation:\
     `override fun getTitle() = "Inventory Title"` 
3. Implement the `GuiEvents` interface
   - Make sure to register your class as an event listener
4. Add your created GUI to the `registeredGUIs` list.

#Package xyz.nowaha.nlib.gui.slots
Slot classes to hold one or more slots for use with the GUI system.