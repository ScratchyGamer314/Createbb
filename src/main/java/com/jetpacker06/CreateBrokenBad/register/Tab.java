package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Tab {
    public static final DeferredRegister<CreativeModeTab> TAB_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateBrokenBad.MOD_ID);

    public static RegistryObject<CreativeModeTab> CREATEBB;

    public static void register(Registrate REGISTRATE, IEventBus eventBus) {
        CREATEBB = TAB_REGISTER.register("createbb",
                () -> CreativeModeTab.builder()
                        .title(Component.translatable("itemGroup.CreateBB"))
                        .icon(CBBItems.BLUE_METH::asStack)
                        .displayItems((b, output) -> {
                            for (RegistryEntry<Item> item : REGISTRATE.getAll(Registries.ITEM)) {
                                output.accept(item.get());
                            }
                        })
                        .build());
        TAB_REGISTER.register(eventBus);
    }
}