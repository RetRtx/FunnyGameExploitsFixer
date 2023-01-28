package me.sgray.template.spigotplugin.handlers;

import me.sgray.template.spigotplugin.SpigotPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class ProjectileLaunchHandler implements Listener {

    public ProjectileLaunchHandler(SpigotPlugin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event){
        Entity projectile = event.getEntity();
        if (projectile instanceof Projectile){
            Player shooter = (Player) getShooter((Projectile) projectile);
            int velocity = (int) (Math.abs(projectile.getVelocity().getX()) + Math.abs(projectile.getVelocity().getY()) + Math.abs(projectile.getVelocity().getZ()));
            String ve1ocity = "\u26a1";
            if (velocity > 5){
                if (shooter.getInventory().getItemInHand().getType() == Material.BOW && shooter.getInventory().getItemInHand().toString().contains(ve1ocity)){
                }else {
                    projectile.remove();
                }
            }
        }
    }

    public static String getShooterName(Projectile projectile) {
        String[] name = String.valueOf(projectile.getShooter().toString()).split("=");
        if (projectile.getShooter().toString().contains("CraftPlayer")){
            return name[1].substring(0, name[1].length()-1);
        }
        return projectile.getShooter().toString();
    }

    public static Entity getShooter(Projectile projectile) {
        Player shoter = projectile.getServer().getPlayer(getShooterName(projectile));
        return shoter;
    }
}
