package me.jpedrofc.fc_expansion;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libearies.dough.config;

public class FC_Expansion extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }
        NamespacedKey categoryId = new NamespacedKey(this, "cool_category");
        CustomItemStack categoryItem = new CustomItemStack(Material.SMOOTH_STONE, "&4My CATEGORY!");

// Our custom Category
        ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);

// The custom item for our SlimefunItem
        SlimefunItemStack itemStack = new SlimefunItemStack("MY_ADDON_ITEM", Material.STONE, "&aAhh hardworking", "", "&7This is too sad");

// A 3x3 shape representing our recipe
        ItemStack[] recipe = {
                new ItemStack(Material.COBBLESTONE),    null,                               new ItemStack(Material.COBBLESTONE),
                null,                               SlimefunItems.CARBONADO,            null,
                new ItemStack(Material.STONE,    null,                               new ItemStack(Material.STONE)
        };

        SlimefunItem sfItem = new SlimefunItem(itemGroup, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        sfItem.register(this);
// Our item is now registered
        };
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
