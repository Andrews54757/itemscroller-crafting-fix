package fi.dy.masa.itemscroller.mixin;

import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.awt.*;

@Mixin(AnvilScreen.class)
public interface IMixinAnvilScreen {
    @Invoker("onRenamed")
    void itemscroller_setItemName(String newName);

    @Accessor("nameField")
    TextFieldWidget itemscroller_getNameField();
}
