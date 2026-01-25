package com.github.charredgrass.gauntletbankedxp;

import com.github.charredgrass.gauntletbankedxp.config.BattlestavesMethod;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("gauntletbankedxp")
public interface GauntletBankedXpConfig extends Config
{
//	@ConfigItem(
//		keyName = "greeting",
//		name = "Welcome Greeting",
//		description = "The message to show to the user when they login"
//	)
//	default String greeting()
//	{
//		return "Hello";
//	}
	@ConfigItem(
		name = "Battlestaves",
		description = "The orbs to attach to battlestaves.",
			keyName = "battlestavesMethod"
	)
	default BattlestavesMethod getBattlestavesMethod() {
		return BattlestavesMethod.NONE;
	}
}
