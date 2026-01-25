package com.github.charredgrass.gauntletbankedxp;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.loottracker.LootReceived;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
@PluginDescriptor(
	name = "Gauntlet Banked XP"
)
public class GauntletBankedXpPlugin extends Plugin
{
	private static final Logger log = LoggerFactory.getLogger(GauntletBankedXpPlugin.class);

	private final String CG_LOOT = "Corrupted Hunllef";
	private final String G_LOOT = "Crystalline Hunllef";


	@Inject
	private Client client;

	@Inject
	private GauntletBankedXpConfig config;

	@Override
	protected void startUp() throws Exception
	{
//		log.debug("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
//		log.debug("Example stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
//		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
//		{
//			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
//		}
	}

	@Subscribe
	public void onLootReceived(LootReceived event) {
		log.debug("LOOT RECVD FROM {}", event.getName());
		if (event.getName().equals(CG_LOOT) || event.getName().equals(G_LOOT)) {
			double xp = GauntletBankedXpCalculate.calculateLoot(event.getItems());
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Crafting XP: " + xp, null);
		}
	}

	@Provides
	GauntletBankedXpConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GauntletBankedXpConfig.class);
	}
}
