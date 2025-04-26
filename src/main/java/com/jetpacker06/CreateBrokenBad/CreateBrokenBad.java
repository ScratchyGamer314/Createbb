package com.jetpacker06.CreateBrokenBad;

import com.jetpacker06.CreateBrokenBad.register.*;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.Registrate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ComposterBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;


@Mod(CreateBrokenBad.MOD_ID)
public class CreateBrokenBad {
    public static final String MOD_ID = "createbb";
    public static final ResourceKey<CreativeModeTab> CREATIVE_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(MOD_ID, MOD_ID));
    public static final Registrate registrate = Registrate.create(MOD_ID).defaultCreativeTab(CREATIVE_TAB.location().getPath(),
            builder -> builder.icon(() -> new ItemStack(CBBItems.BLUE_METH.asItem()))).build();

    public static Registrate registrate(){
        return registrate;
    }


    public CreateBrokenBad(IEventBus eventBus, ModContainer container) {
        AllSoundEvents.register(eventBus);

        CBBItems.register();
        CBBBlocks.register();
        CBBFluids.register();
        CBBBlockEntityTypes.register();

        eventBus.addListener(this::commonSetup);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(CBBItems.EPHEDRA.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(CBBItems.EPHEDRA_SEEDS.get(), 0.65f);
        });
        
        AllCustomTriggerAdvancements.register();
    }
}