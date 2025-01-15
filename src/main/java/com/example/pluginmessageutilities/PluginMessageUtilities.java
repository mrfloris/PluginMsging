package com.example.pluginmessageutilities;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMessageUtilities extends JavaPlugin {
    
    @Override
    public void onEnable() {
        this.getCommand("getoutgoingchannels").setExecutor(new OutgoingChannelsCommand());
        this.getCommand("getincomingchannels").setExecutor(new IncomingChannelsCommand());
    }

    private class OutgoingChannelsCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            // Additional permission check in code if needed
            if (!sender.hasPermission("plugin.debug.getoutgoingchannels")) {
                sender.sendMessage("You do not have permission to execute this command.");
                return true;
            }

            getServer().getMessenger().getOutgoingChannels().forEach(channel -> {
                sender.sendMessage("Outgoing Channel: " + channel);
            });

            return true;
        }
    }

    private class IncomingChannelsCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            // Additional permission check in code if needed
            if (!sender.hasPermission("plugin.debug.getincomingchannels")) {
                sender.sendMessage("You do not have permission to execute this command.");
                return true;
            }

            getServer().getMessenger().getIncomingChannels().forEach(channel -> {
                sender.sendMessage("Incoming Channel: " + channel);
            });

            return true;
        }
    }
}
