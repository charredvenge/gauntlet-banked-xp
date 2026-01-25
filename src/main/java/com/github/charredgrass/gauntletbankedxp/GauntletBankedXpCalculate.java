package com.github.charredgrass.gauntletbankedxp;

import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class GauntletBankedXpCalculate {
    private static final Logger log = LoggerFactory.getLogger(GauntletBankedXpCalculate.class);

    public static double calculateLoot(Collection<ItemStack> items, GauntletBankedXpConfig config) {
        double xp = 0; //crafting xp. probably should intify this?
        for (ItemStack i : items) {
            log.debug("loot currid: {}", i.getId());
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
                case ItemID.UNCUT_DIAMOND:
                    xp += 107.5 * i.getQuantity();
                    break;
                case ItemID.BATTLESTAFF:
                    double staffxp = 0;
                    switch (config.getBattlestavesMethod()) {
                        //TODO maybe change this to some key value thing to be cleaner
                        case WATER:
                            staffxp = 100;
                            break;
                        case EARTH:
                            staffxp = 112.5;
                            break;
                        case FIRE:
                            staffxp = 125;
                            break;
                        case AIR:
                            staffxp = 137.5;
                            break;
                    }
                    xp += staffxp * i.getQuantity();
                    break;
            }
        }
        return xp;
    }
}
