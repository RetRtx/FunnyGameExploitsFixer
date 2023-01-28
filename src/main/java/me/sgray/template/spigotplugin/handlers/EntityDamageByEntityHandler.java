package me.sgray.template.spigotplugin.handlers;

import me.sgray.template.spigotplugin.SpigotPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static me.sgray.template.spigotplugin.SpigotPlugin.armor;

public class EntityDamageByEntityHandler implements Listener {

    public EntityDamageByEntityHandler(SpigotPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            player.getInventory().getHelmet().getDurability();
            if (player.getInventory().getHelmet().getDurability() < 0){
                if (player.getInventory().getHelmet().toString().contains(armor))return;
                player.getInventory().getHelmet().setDurability((short) 0);
            }
            if (player.getInventory().getChestplate().getDurability() < 0){
                if (player.getInventory().getChestplate().toString().contains(armor))return;
                player.getInventory().getChestplate().setDurability((short) 0);
            }
            if (player.getInventory().getLeggings().getDurability() < 0){
                if (player.getInventory().getLeggings().toString().contains(armor))return;
                player.getInventory().getLeggings().setDurability((short) 0);
            }
            if (player.getInventory().getBoots().getDurability() < 0){
                if (player.getInventory().getBoots().toString().contains(armor))return;
                player.getInventory().getBoots().setDurability((short) 0);
            }
        }
    }
}
