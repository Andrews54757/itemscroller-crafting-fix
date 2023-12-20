## Note
This is a customized version of Andrew54757's itemscroller-crafting-fix, which is a customized version of Masa's itemscroller mod that fixes crafting features for 1.18.

Masa's original mod can be found [here](https://github.com/maruohon/itemscroller)

Andrew54757's mod can be found [here](https://github.com/Andrews54757/itemscroller-crafting-fix)

Customizations:
Beside the customizations offered by crafting-fix, we also provide some features that are not present in the original mod:
* Apply crafting features over anvil, grindstone(could help with building overstacked items), stonecutter.
* Renaming multiple items automatically over anvil
* `reserveCrafting` to make it possible to pick up every kind of recipe items after each crafting

- Fix rendering bug when recipes do not have the length of a square number 

除crafting-fix提供的功能外，还提供以下功能：
* 可以在铁砧/砂轮(可用于合成堆叠附魔书等)/切石机上使用快速合成功能
* 可以在铁砧上批量重命名物品，只需快速合成前在铁砧上预先写好名字并调用对应的快速合成功能即可，注意仅能用于`合成而不扔出`
* `reserveCrafting` 选项可以在合成后保留物品栏中合成材料的槽位，无论地上合成材料扔出的顺序，总有物品栏位置能从地上捡起合成材料

## This is not Masa's original itemscroller. If you have issues with this mod, please contact WenDavid552 (or open a bug report here).

Item Scroller
==============
Item Scroller is a Minecraft mod that adds various convenience features for moving items
inside inventory GUIs. Examples are scrolling the mouse wheel over slots with items in them
or Shift/Ctrl + click + dragging over slots to move items from them in various ways etc.

Item scrolling is basically what the old NEI mod did and Mouse Tweaks also does.
This mod has some different drag features compared to Mouse Tweaks, and also some special
villager trading related helper features as well as crafting helper features.

For more information and downloads of the already compiled builds,
see https://www.curseforge.com/minecraft/mc-mods/item-scroller

Compiling
=========
* Clone the repository
* Open a command prompt/terminal to the repository directory
* run 'gradlew build'
* The built jar file will be in build/libs/
