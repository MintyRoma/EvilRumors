// 
// Decompiled by Procyon v0.5.36
// 

package pomestie.minty;

import org.bukkit.event.EventHandler;
import java.util.Collection;
import org.bukkit.Bukkit;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.Listener;

public class Spy implements Listener
{
    @EventHandler
    public void Killed(final PlayerDeathEvent event) {
        final Player dead = event.getEntity();
        if (dead.getKiller() != null && dead.getKiller() instanceof Player) {
            final Random rnd = new Random();
            final int players = Bukkit.getServer().getOnlinePlayers().size();
            final Collection<? extends Player> online = (Collection<? extends Player>)Bukkit.getServer().getOnlinePlayers();
            String deathmessage = ConfigKeeper.messages.get(rnd.nextInt(ConfigKeeper.messages.size()));
            final Player sdoh = (Player)online.toArray()[rnd.nextInt(players)];
            final Player killer = (Player)online.toArray()[rnd.nextInt(players)];
            deathmessage = deathmessage.replaceAll("%player1%", sdoh.getDisplayName());
            deathmessage = deathmessage.replaceAll("%player2%", killer.getDisplayName());
            event.setDeathMessage(deathmessage);
        }
    }
}
