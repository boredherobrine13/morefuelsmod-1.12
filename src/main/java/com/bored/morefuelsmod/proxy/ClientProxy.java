package com.bored.morefuelsmod.proxy;

import com.bored.morefuelsmod.ModBlocks;
import com.bored.morefuelsmod.ModEntities;
import com.bored.morefuelsmod.ModItems;
import com.bored.morefuelsmod.Main;
import com.bored.morefuelsmod.input.InputHandler;
import com.bored.morefuelsmod.input.KeyBindings;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        OBJLoader.INSTANCE.addDomain(Main.MODID);
        // Typically initialization of models and such goes here:
        ModEntities.initModels();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);

        // Initialize our input handler so we can listen to keys
        MinecraftForge.EVENT_BUS.register(new InputHandler());
        KeyBindings.init();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        ModBlocks.initItemModels();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModBlocks.initModels();
        ModItems.initModels();
    }

}