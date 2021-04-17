package me.rekuseq.MineBlock;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class craftingInventory {
    private Plugin plugin = MineBlock.getPlugin(MineBlock.class);

    public void craftingInv(Player p){
        FileConfiguration config = plugin.getConfig();
        String title = ChatColor.translateAlternateColorCodes('&', config.getString("craftingInventoryTitle"));
        Inventory i = plugin.getServer().createInventory(null, 45, title);

        ItemStack mineblock = new ItemStack(Material.SPONGE, 1);
        ItemMeta mineblockMeta = mineblock.getItemMeta();
        String blockName = ChatColor.translateAlternateColorCodes('&', config.getString("blockName"));
        mineblockMeta.setDisplayName(blockName);
        List<String> lore = new ArrayList<>();
        for (String string : config.getStringList("blocklore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', string));
        }
        mineblockMeta.setLore(lore);
        mineblock.setItemMeta(mineblockMeta);


        ItemStack stone = new ItemStack(Material.STONE, 1);

        i.setItem(24, mineblock);
        i.setItem(11, stone);
        i.setItem(12, stone);
        i.setItem(13, stone);
        i.setItem(20, stone);
        i.setItem(21, stone);
        i.setItem(22, stone);
        i.setItem(29, stone);
        i.setItem(30, stone);
        i.setItem(31, stone);

        p.openInventory(i);
    }
}
