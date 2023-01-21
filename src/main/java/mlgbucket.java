import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class mlgbucket extends JavaPlugin implements Listener {
    public void onFallDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        if (event.getCause() == DamageCause.FALL && player.getInventory().getItemInMainHand().getType() == Material.WATER_BUCKET) {
            player.sendMessage(ChatColor.RED + "haha you failed to mlg");
        }
    }
    public void onEnable() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvent(EntityDamageEvent.class, this, EventPriority.NORMAL, (listener, event) -> {
            if (event instanceof EntityDamageEvent) {
                onFallDamage((EntityDamageEvent) event);
            }
        }, this);
    }
}

