package a.dice;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Random;

public final class Dice extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        getServer().getPluginManager().registerEvents(new EventManager(), this);

    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (args.length != 0) {
            String title;
            String Numbererror;
            String Configreload;
            if (args[0].equals("reload")) {
                reloadConfig();
                title = getConfig().getString("Title");
                Configreload = getConfig().getString("Configreload");
                sender.sendMessage(title + Configreload);
            } else {
                int sides = Integer.parseInt(args[0]);
                title = getConfig().getString("Title");
                Numbererror = getConfig().getString("Numbererror");
                if(sides >= 1) {
                    sender.sendMessage(title + "§eあなたは" + sides + "面ダイスを振って" + ((new Random()).nextInt(sides) + 1) + "を出しました!");
                } else {
                    sender.sendMessage(title + Numbererror);
                }
            }
            return true;
        } else {
            String hikisuuerror;
            String title;
            hikisuuerror = getConfig().getString("Hikisuuerror");
            title = getConfig().getString("Title");
            sender.sendMessage(title + hikisuuerror);
            return false;
        }
    }
}