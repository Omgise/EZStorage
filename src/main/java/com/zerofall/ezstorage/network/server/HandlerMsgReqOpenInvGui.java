package com.zerofall.ezstorage.network.server;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import com.zerofall.ezstorage.item.ItemPortableStoragePanel;
import com.zerofall.ezstorage.network.client.MsgReqOpenInvGui;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class HandlerMsgReqOpenInvGui implements IMessageHandler<MsgReqOpenInvGui, IMessage> {

    @Override
    public IMessage onMessage(MsgReqOpenInvGui message, MessageContext ctx) {
        EntityPlayerMP player = ctx.getServerHandler().playerEntity;

        switch (message.source) {
            case BAUBLES:
                ItemStack itemStack = ItemPortableStoragePanel.getFromBaubles(player);
                if (itemStack != null && itemStack.getItem() instanceof ItemPortableStoragePanel panel) {
                    panel.onItemRightClick(itemStack, player.getEntityWorld(), player);
                }
                break;
        }

        return null;
    }

}
