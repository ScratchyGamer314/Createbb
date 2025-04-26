package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import com.jetpacker06.CreateBrokenBad.block.BrassCallBellBlockEntity;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class CBBBlockEntityTypes {

    public static BlockEntityEntry<BrassCallBellBlockEntity> BRASS_CALL_BELL;

    public static void register() {
        BRASS_CALL_BELL = CreateBrokenBad.registrate()
                .blockEntity("brass_call_bell", BrassCallBellBlockEntity::new)
                .validBlocks(CBBBlocks.BRASS_CALL_BELL, CBBBlocks.TRAPPED_BRASS_CALL_BELL)
                .register();
    }
}
