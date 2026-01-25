package com.github.charredgrass.gauntletbankedxp;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GauntletBankedXpTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(GauntletBankedXpPlugin.class);
		RuneLite.main(args);
	}
}