package me.rekuseq.MineBlock;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MineBlock extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "\n\n[MineBlock] Plugin zostal wlaczony!\n\n");
        getCommand("crafting").setExecutor(new Commandexecutor());
        getServer().getPluginManager().registerEvents(new EventsClass(), this);
        BlockMine block = new BlockMine();
        block.customRecipe();
        loadConfig();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "\n\n[MineBlock] Plugin zostal wylaczony!\n\n");
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
