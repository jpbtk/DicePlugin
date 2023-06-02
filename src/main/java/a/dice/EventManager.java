package a.dice;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;
import org.bukkit.block.Sign;

public class EventManager implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (!event.hasBlock()) return;
        if (!(event.getClickedBlock().getState() instanceof Sign)) return;
        Sign signboard = (Sign) event.getClickedBlock().getState();
        if (!signboard.getLine(0).equals("[Dice]")) return;{
            String title;
            String Numbererror;
            String Configreload;
            String hikisuuerror;
            if (signboard.getLine(1).equals("reload")) {
                Dice.getPlugin(Dice.class).reloadConfig();
                title = Dice.getPlugin(Dice.class).getConfig().getString("Title");
                Configreload = Dice.getPlugin(Dice.class).getConfig().getString("Configreload");
                event.getPlayer().sendMessage(title + Configreload);
            } else {
                int sides = Integer.parseInt(signboard.getLine(1));
                title = Dice.getPlugin(Dice.class).getConfig().getString("Title");
                Numbererror = Dice.getPlugin(Dice.class).getConfig().getString("Numbererror");
                if(sides >= 1) {
                    event.getPlayer().sendMessage(title + "§eあなたは" + sides + "面ダイスを振って" + ((new java.util.Random()).nextInt(sides) + 1) + "を出しました!");
                } else {
                    event.getPlayer().sendMessage(title + Numbererror);
                }
            }
        }
    }
}

