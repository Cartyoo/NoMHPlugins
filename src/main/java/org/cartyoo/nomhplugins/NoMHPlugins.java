package org.cartyoo.nomhplugins;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoMHPlugins extends JavaPlugin implements Listener {
    static NoMHPlugins plugin;

    @Override
    public void onEnable() {

        getLogger().info("&d&lNoMoreMinehut Loaded");
        getLogger().info("&d&lNoMoreMinehut Made By herbert#6969 aka Cartyoo");


        getServer().getPluginManager().registerEvents(this, this);


        Plugin minehut = Bukkit.getPluginManager().getPlugin("MinehutCosmetics");
        Plugin minehut2 = Bukkit.getPluginManager().getPlugin("MinehutPlugin");

        if(minehut.isEnabled()) {
            Bukkit.getServer().getPluginManager().disablePlugin(minehut);
        }

        if(minehut2.isEnabled()) {
            Bukkit.getServer().getPluginManager().disablePlugin(minehut2);
        }


        //bStats
        int pluginId = 17056;
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("ok", () -> "ok"));
    }

    private static NoMHPlugins getPlugin() {
        return plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Plugin minehut = Bukkit.getPluginManager().getPlugin("MinehutCosmetics");
        Plugin minehut2 = Bukkit.getPluginManager().getPlugin("MinehutPlugin");

        if(minehut.isEnabled()) {
            Bukkit.getServer().getPluginManager().disablePlugin(minehut);
        }

        if(minehut2.isEnabled()) {
            Bukkit.getServer().getPluginManager().disablePlugin(minehut2);
        }
    }

}

