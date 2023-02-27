package de.chloedev.cdnlib.ui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * Simple Implementation of an UI-Inventory that can be easily compared with the holder.<br><br>
 * Example: <h3>if(player.getInventory().getHolder() == myInventory.getHolder())<h3/>
 */
public class UIContainer implements InventoryHolder {

    private final Inventory inventory;

    public UIContainer(String title, int rows) {
        this.inventory = Bukkit.createInventory(this, rows * 9, title);
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }
}
