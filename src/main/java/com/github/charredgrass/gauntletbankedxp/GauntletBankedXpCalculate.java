package com.github.charredgrass.gauntletbankedxp;

import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class GauntletBankedXpCalculate {
    private static final Logger log = LoggerFactory.getLogger(GauntletBankedXpCalculate.class);

    public static double calculateLoot(Collection<ItemStack> items) {
        double xp = 0; //crafting xp. probably should intify this?
        for (ItemStack i : items) {
            log.debug("currid: {}", i.getId());
            switch (i.getId() - 1) { //dont ask idk lol
                case ItemID.UNCUT_SAPPHIRE:
                    xp += 50 * i.getQuantity();
                    break;
                case ItemID.UNCUT_EMERALD:
                    xp += 67.5 * i.getQuantity();
                    break;
                case ItemID.UNCUT_RUBY:
                    xp += 85 * i.getQuantity();
                    break;
                case ItemID.BATTLESTAFF:
                    xp += 100 * i.getQuantity();
                    //TODO change based on configured bstaff method
                    break;
            }
        }
        return xp;
    }
}
