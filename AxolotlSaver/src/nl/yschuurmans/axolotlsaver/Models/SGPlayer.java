/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.yschuurmans.axolotlsaver.Models;

import java.util.stream.Stream;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 *
 * @author youri
 */
public class SGPlayer {

    private String playerName;
    private int lastSeenSecond;

    private SimpleLocation originLocation;
    private GameMode originGameMode;

    private transient Player bukkitPlayer;

    public SGPlayer() {
    }

    public SGPlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
        this.playerName = bukkitPlayer.getName();

        this.originLocation = new SimpleLocation(bukkitPlayer.getLocation());
        this.originGameMode = bukkitPlayer.getGameMode();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLastSeenSecond() {
        return lastSeenSecond;
    }

    public void setLastSeenSecond(int lastSeenSecond) {
        this.lastSeenSecond = lastSeenSecond;
    }

    public Player getBukkitPlayer() {
        if (bukkitPlayer == null) {
            bukkitPlayer = Bukkit.getPlayer(playerName);
        }
        return bukkitPlayer;
    }

    public void setBukkitPlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
    }

    public boolean isOnline() {
        var player = getBukkitPlayer();
        if (player == null) {
            return false;
        }
        return player.isOnline();
    }

    public SimpleLocation getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(SimpleLocation originLocation) {
        this.originLocation = originLocation;
    }

    public GameMode getOriginGameMode() {
        return originGameMode;
    }

    public void setOriginGameMode(GameMode originGameMode) {
        this.originGameMode = originGameMode;
    }

}
