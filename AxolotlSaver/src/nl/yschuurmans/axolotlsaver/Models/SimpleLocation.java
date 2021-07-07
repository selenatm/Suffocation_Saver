/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.yschuurmans.axolotlsaver.Models;

import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

/**
 *
 * @author youri
 */
public class SimpleLocation {

    public SimpleLocation() {
    }

    public SimpleLocation(String world, int x, int y, int z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public SimpleLocation(Location location) {
        this.world = location.getWorld().getName();
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
    }

    public Location toBlockLocation() {
        return new Location(Bukkit.getWorld(world), x, y, z);
    }

    public Location toLocation() {
        return new Location(Bukkit.getWorld(world), x + 0.5f, y, z + 0.5f);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(this.x);
        sb.append(", ");
        sb.append(this.y);
        sb.append(", ");
        sb.append(this.z);
        sb.append("]");
        return sb.toString();
    }

    public String toSGTeleportCommand(String survivalGameName) {
        StringBuilder sb = new StringBuilder();
        sb.append("/sg tp ");
        sb.append(survivalGameName);
        sb.append(" ");
        sb.append(this.x);
        sb.append(" ");
        sb.append(this.y);
        sb.append(" ");
        sb.append(this.z);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.x;
        hash = 29 * hash + this.y;
        hash = 29 * hash + this.z;
        hash = 29 * hash + Objects.hashCode(this.world);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleLocation other = (SimpleLocation) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.z != other.z) {
            return false;
        }
        if (!Objects.equals(this.world, other.world)) {
            return false;
        }
        return true;
    }
    
    

    private int x;
    private int y;
    private int z;
    private String world;

}
