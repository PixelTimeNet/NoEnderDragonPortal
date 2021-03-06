/*
 * Copyright (C) 2017 The MoonLake Authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.minecraft.moonlake.noenderdragonportal;

import org.bukkit.PortalType;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public Main() {
    }


    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getLogger().info("NoEnderDragonPortal plugin v" + getDescription()
            .getVersion() + " fully loaded.");
    }


    @Override
    public void onDisable() {
    }


    @EventHandler(priority = EventPriority.MONITOR)
    public void onPortal(EntityCreatePortalEvent event) {
        if (event.getEntity() instanceof EnderDragon && event
            .getPortalType() == PortalType.ENDER)
            event.setCancelled(true);
    }
}
