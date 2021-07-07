/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.yschuurmans.axolotlsaver.EventListeners;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

/**
 *
 * @author youri
 */
public class AxolotlDamageHandler implements Listener {

    @EventHandler
    final void onEntityDamageEvent(EntityDamageEvent event) {
//        System.out.println("EVENT!");
        var entity = event.getEntity();
        if (!entity.getType().equals(EntityType.AXOLOTL)) {
            return;
        }

        if (!event.isCancelled()) {
            if (event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)
                    || event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)
                    || event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK)) {
//                System.out.println("ATTACK EVENT!");
                return;
            }

//            System.out.println("AXOLOTL EVENT!");
            if (entity.getCustomName() == null) {
                return;
            }
            
//            System.out.println("AXOLOTL NAME:" + entity.getCustomName());
//            System.out.println("NON-ATTACK EVENT!");
            event.setCancelled(true);
        }
    }

}
