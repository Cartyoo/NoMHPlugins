package org.cartyoo.nomhplugins;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoMHPlugins extends JavaPlugin implements Listener {
    static NoMHPlugins plugin;


    @Override
    public void onEnable() {

        getLogger().info("NoMHPlugins Loaded");


        getServer().getPluginManager().registerEvents(this, this);


        if(Bukkit.getPluginManager().getPlugin("MinehutCosmetics") != null) {
            Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("MinehutCosmetics"));
        } else {
            Bukkit.getLogger().info("Plugin 'MinehutCosmetics' not found! (This is normal)");
        }

        if(Bukkit.getPluginManager().getPlugin("MinehutPlugin") != null) {
            Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("MinehutPlugin"));
        } else {
            Bukkit.getLogger().info("Plugin 'MinehutPlugin' not found! (This is normal)");
        }


        Bukkit.getLogger().info("[NoMHPlugins] Note: You may need to join the server to disable Minehut's plugins.");


        //bStats
        int pluginId = 17056;
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("ok", () -> "ok"));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        if(Bukkit.getPluginManager().getPlugin("MinehutCosmetics") != null) {
            Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("MinehutCosmetics"));
        }

        if(Bukkit.getPluginManager().getPlugin("MinehutPlugin") != null) {
            Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("MinehutPlugin"));
        }

    }

}

