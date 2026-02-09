package com.github.charredvenge.gauntletbankedxp;

import com.github.charredvenge.gauntletbankedxp.config.BattlestavesMethod;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("gauntletbankedxp")
public interface GauntletBankedXpConfig extends Config
{

	@ConfigItem(
		name = "Battlestaves",
		description = "The orbs to attach to battlestaves.",
			keyName = "battlestavesMethod"
	)
	default BattlestavesMethod getBattlestavesMethod() {
		return BattlestavesMethod.NONE;
	}
}
