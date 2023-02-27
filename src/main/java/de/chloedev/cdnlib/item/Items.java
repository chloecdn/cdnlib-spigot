package de.chloedev.cdnlib.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Items {

    public ItemStack createItem(Material type, String name, String... descLines) {
        ItemStack i = new ItemStack(type);
        ItemMeta m1 = i.getItemMeta();
        if (m1 != null) {
            m1.setDisplayName(name);
            m1.setLore(Arrays.asList(descLines));
        }
        i.setItemMeta(m1);
        return i;
    }
}
