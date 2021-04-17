package me.rekuseq.MineBlock;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BlockMine implements Listener {

    private Plugin plugin = MineBlock.getPlugin(MineBlock.class);

    public void customRecipe() {
        FileConfiguration config = plugin.getConfig();

        ItemStack item = new ItemStack(Material.valueOf(config.getString("block").toUpperCase(Locale.ROOT)), 1);
        ItemMeta meta = item.getItemMeta();
        String blockName = ChatColor.translateAlternateColorCodes('&', config.getString("blockName"));
        meta.setDisplayName(blockName);

        List<String> lore = new ArrayList<>();
        for (String string : config.getStringList("blocklore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', string));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);

        ShapedRecipe r = new ShapedRecipe(item);

        r.shape("!@#", "$%^", "&*(");

        r.setIngredient('!', Material.valueOf(config.getString("1").toUpperCase(Locale.ROOT)));
        r.setIngredient('@', Material.valueOf(config.getString("2").toUpperCase(Locale.ROOT)));
        r.setIngredient('#', Material.valueOf(config.getString("3").toUpperCase(Locale.ROOT)));
        r.setIngredient('$', Material.valueOf(config.getString("4").toUpperCase(Locale.ROOT)));
        r.setIngredient('%', Material.valueOf(config.getString("5").toUpperCase(Locale.ROOT)));
        r.setIngredient('^', Material.valueOf(config.getString("6").toUpperCase(Locale.ROOT)));
        r.setIngredient('&', Material.valueOf(config.getString("7").toUpperCase(Locale.ROOT)));
        r.setIngredient('*', Material.valueOf(config.getString("8").toUpperCase(Locale.ROOT)));
        r.setIngredient('(', Material.valueOf(config.getString("9").toUpperCase(Locale.ROOT)));

        plugin.getServer().addRecipe(r);

    }
}
