package fi.dy.masa.itemscroller.compat.carpet;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

import java.lang.invoke.*;
import java.util.function.Function;
import java.util.function.IntSupplier;

public class StackingShulkerBoxes {
    public static boolean enabled = false;

    public static void init(){
        if (FabricLoader.getInstance().isModLoaded("carpet")){
            try {
                enabled = true;
                MethodHandles.Lookup lookup = MethodHandles.lookup();
                MethodHandle shulkerBoxHasItemsTarget = lookup.findStatic(Class.forName("carpet.helpers.InventoryHelper"), "shulkerBoxHasItems", MethodType.methodType(boolean.class, ItemStack.class));
                shulkerBoxHasItems = (ItemStack stack) -> {
                    try {
                        return (Boolean) shulkerBoxHasItemsTarget.invokeWithArguments(stack);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                };
                MethodHandle shulkerBoxStackSizeHandle = lookup.findStaticVarHandle(Class.forName("carpet.CarpetSettings"), "shulkerBoxStackSize", int.class).toMethodHandle(VarHandle.AccessMode.GET);
                shulkerBoxStackSizeGetter = ()-> {
                    try {
                        return (int) shulkerBoxStackSizeHandle.invokeExact();
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                };

            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
    private static IntSupplier shulkerBoxStackSizeGetter = null;
    private static Function<ItemStack, Boolean> shulkerBoxHasItems = null;

    /**
     * @param stack {@link ItemStack}
     * @return Stack size considering empty boxes stacking rule from carpet mod
     * @author <a href="https://github.com/gnembon">gnembon</a>, <a href="https://github.com/vlad2305m">vlad2305m</a>
     * @see <a href="https://https://github.com/gnembon/fabric-carpet/blob/master/src/main/java/carpet/mixins/Slot_stackableSBoxesMixin.java">Original implementation</a>
     */
    public static int getMaxCount(ItemStack stack){
        if (!enabled) return stack.getMaxCount();
        int shulkerBoxStackSize = shulkerBoxStackSizeGetter.getAsInt();
        if (shulkerBoxStackSize > 1 &&
                stack.getItem() instanceof BlockItem &&
                ((BlockItem)stack.getItem()).getBlock() instanceof ShulkerBoxBlock &&
                !shulkerBoxHasItems.apply(stack)
        ) {
            return shulkerBoxStackSize;
        }
        return stack.getMaxCount();
    }
}
