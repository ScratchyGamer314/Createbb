package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = CreateBrokenBad.MOD_ID)
public class AllEvents {

    @SubscribeEvent
    public static void addTrade(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(CBBItems.EPHEDRA.get(), 8),
                    10, 8, 0.02F));
        }
        if (event.getType() != VillagerProfession.NITWIT) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(CBBItems.WHITE_METH.get()),
                    new ItemStack(Items.EMERALD, 2),
                    10, 8, 0.02F));
            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(CBBItems.BLUE_METH.get()),
                    new ItemStack(Items.EMERALD, 3),
                    10, 8, 0.02F));
        }
    }
}
