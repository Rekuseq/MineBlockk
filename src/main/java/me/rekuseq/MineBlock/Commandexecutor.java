package me.rekuseq.MineBlock;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandexecutor implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        Player p = (Player)sender;

        if(cmd.getName().equalsIgnoreCase("crafting")){
            if(p.hasPermission("MineBlock.crafting") || p.isOp()){
                craftingInventory ci = new craftingInventory();
                ci.craftingInv(p);
            }
        }
        return false;
    }
}
