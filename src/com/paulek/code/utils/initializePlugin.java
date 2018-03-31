package com.paulek.code.utils;

import com.paulek.code.Main;
import com.paulek.code.cmds.HelpCMD;
import com.paulek.code.config.ConfigMenager;
import com.paulek.code.data.ChatDisableData;
import com.paulek.code.data.RtpButtonsData;
import com.paulek.code.threads.GiantSpawnThread;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class initializePlugin {

    private static JavaPlugin plugin = Main.getInstance();

    public static void initialize(){
        ConfigMenager.checkFiles();


        initializeListners.initialize();
        initializeCommands.initialize();



        HelpCMD.setList(ConfigMenager.getConfiguration().getList("helpMSG"));
        RtpButtonsData.loadButtons();

        ItemStack item = new ItemStack(Material.ENDER_STONE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§a§lGenerator");
        meta.setLore(Arrays.asList(new String[]{
                "§cPostaw na ziemi stowniarke,",
                "§cPoluz na niej stone lub obsidian",
                "§cGotowe! Zostalo tylko kopac :D"
        }));
        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(item).shape(new String[] {
                "RIR",
                "ISI",
                "RPR"
        })
                .setIngredient('R', Material.REDSTONE)
                .setIngredient('I', Material.IRON_INGOT)
                .setIngredient('S', Material.STONE)
                .setIngredient('P', Material.PISTON_BASE);
        plugin.getServer().addRecipe(recipe);

        ItemStack cobblex = new ItemStack(Material.EMERALD_ORE);

        ShapedRecipe cobbleX = new ShapedRecipe(cobblex).shape(new String[] {
                "CCC",
                "CCC",
                "CCC"
         }).setIngredient('C', Material.COBBLESTONE);
        plugin.getServer().addRecipe(cobbleX);

        int size = ConfigMenager.getGigants().getList("drops_giant").size();
        List<ItemStack> loots = new ArrayList<>();
        for(int i =0; i < size; i++){
            ItemStack loot = new ItemStack(parseMaterial((String) ConfigMenager.getGigants().getList("drops_giant").get(i)), 1);
            loots.add(loot);
        }
        giantutil.setLoots(loots);

        //boolean test = ConfigMenager.getCenzor().getBoolean("enabled");
        //System.out.println(test);
        //testforsize = ConfigMenager.getCenzor().getList("blacklisted_words").size();
       // System.out.println(testforsize);
        //for(int i = 0; i < testforsize; i++){
        //    ChatDisableData.getTocenzor().add((String) ConfigMenager.getConfiguration().getList("blacklisted_words").get(i));
       //     plugin.getLogger().info("Added cenzor word: " + ConfigMenager.getConfiguration().getStringList("blacklisted_words").get(i));
        //}

        plugin.getServer().getScheduler().runTaskTimer(plugin, new GiantSpawnThread(), 20*60*ConfigMenager.getGigants().getInt("spawn_time"), 20*60*ConfigMenager.getGigants().getInt("spawn_time"));

        plugin.getLogger().info("Plugin initialized!");
    }


    public static Material parseMaterial(String string)
    {
        if (string == null)
        {
            return Material.AIR;
        }
        String m = string;
        m = m.toUpperCase();
        m = m.replaceAll(" ", "_");
        Material material = Material.getMaterial(m);
        if (material == null)
        {
            return Material.AIR;
        }
        return material;
    }
}
