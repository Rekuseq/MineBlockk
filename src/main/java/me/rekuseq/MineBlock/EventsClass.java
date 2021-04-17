package me.rekuseq.MineBlock;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class EventsClass implements Listener {
    private Plugin plugin = MineBlock.getPlugin(MineBlock.class);

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        FileConfiguration config = plugin.getConfig();
        InventoryView opened = e.getView();
        ItemStack item = e.getCurrentItem();
        String title = ChatColor.translateAlternateColorCodes('&', config.getString("craftingInventoryTitle"));
        if(opened.getTitle().equals(title)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();
        Location loc = b.getLocation();
        FileConfiguration config = plugin.getConfig();
        String blockName = net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', config.getString("blockName"));
        int deep = config.getInt("glebokosc");
        int period = config.getInt("period");
        int delay = config.getInt("delay");
        int xx = config.getInt("x");
        int zz = config.getInt("z");
        if(e.getItemInHand().getItemMeta().getDisplayName().equals(blockName)) {
            new BukkitRunnable() {
                int y = 0;
                @Override
                public void run() {
                    if(y<=deep) {
                        loc.getWorld().getBlockAt(b.getX(), b.getY() - y, b.getZ()).setType(Material.AIR);
                        for(int x = 0; x<=xx; x++) {
                            for(int z = 0; z<=zz; z++) {
                                loc.getWorld().getBlockAt(b.getX() + x, b.getY() - y, b.getZ() + z).setType(Material.AIR);
                                loc.getWorld().getBlockAt(b.getX() + x, b.getY() - y, b.getZ() - z).setType(Material.AIR);
                                loc.getWorld().getBlockAt(b.getX() + x, b.getY() - y, b.getZ()).setType(Material.AIR);
                                loc.getWorld().getBlockAt(b.getX() - x, b.getY() - y, b.getZ() + z).setType(Material.AIR);
                                loc.getWorld().getBlockAt(b.getX() - x, b.getY() - y, b.getZ() - z).setType(Material.AIR);
                                loc.getWorld().getBlockAt(b.getX(), b.getY() - y, b.getZ() + z).setType(Material.AIR);
                                loc.getWorld().getBlockAt(b.getX(), b.getY() - y, b.getZ() - z).setType(Material.AIR);
                                loc.getWorld().getBlockAt(b.getX() - x, b.getY() - y, b.getZ()).setType(Material.AIR);
                            }
                        }
                        y++;
                    }else{
                        cancel();
                    }
                }
            }.runTaskTimer(plugin, delay, period);
        }
    }
}
