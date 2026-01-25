package com.github.charredgrass.gauntletbankedxp;

import net.runelite.client.game.ItemStack;

import java.util.Collection;

public class GauntletBankedXpCalculate {
    class Items {
        static final int UNCUT_SAPPHIRE = 1623;
        static final int UNCUT_EMERALD = 1621;
        static final int UNCUT_RUBY = 1619;
        static final int BATTLESTAFF = 1391;
    }
    public static double calculateLoot(Collection<ItemStack> items) {
        double xp = 0; //crafting xp. probably should intify this?
        for (ItemStack i : items) {
            switch (i.getId()) {
                case Items.UNCUT_SAPPHIRE:
                    xp += 50;
                    break;
                case Items.UNCUT_EMERALD:
                    xp += 67.5;
                    break;
                case Items.UNCUT_RUBY:
                    xp += 85;
                    break;
                case Items.BATTLESTAFF:
                    xp += 100;
                    //TODO change based on configured bstaff method
                    break;
            }
        }
        return xp;
    }
}
