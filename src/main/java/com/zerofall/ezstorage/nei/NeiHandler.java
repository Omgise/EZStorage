package com.zerofall.ezstorage.nei;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

import com.zerofall.ezstorage.gui.GuiStorageCore;

import codechicken.nei.guihook.GuiContainerManager;
import codechicken.nei.guihook.IContainerObjectHandler;
import cpw.mods.fml.common.Optional.Interface;

@Interface(iface = "codechicken.nei.guihook.IContainerObjectHandler", modid = "NotEnoughItems")
public class NeiHandler implements IContainerObjectHandler {

    public static void init() {
        GuiContainerManager.addObjectHandler(new NeiHandler());
    }

    @Override
    public void guiTick(GuiContainer gui) {}

    @Override
    public void refresh(GuiContainer gui) {}

    @Override
    public void load(GuiContainer gui) {}

    @Override
    public ItemStack getStackUnderMouse(GuiContainer gui, int mousex, int mousey) {
        if (gui instanceof GuiStorageCore guiStorageCore) {
            return guiStorageCore.getMouseOverItem();
        }
        return null;
    }

    @Override
    public boolean objectUnderMouse(GuiContainer gui, int mousex, int mousey) {
        return false;
    }

    @Override
    public boolean shouldShowTooltip(GuiContainer gui) {
        return true;
    }
}
