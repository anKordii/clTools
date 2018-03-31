package com.paulek.code.threads;

import com.paulek.code.config.ConfigMenager;
import com.paulek.code.utils.fixColors;
import com.paulek.code.utils.giantutil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Random;

public class GiantSpawnThread implements Runnable {

    Random random = new Random();
    List nicks = giantutil.getNicks();
    int maxX = giantutil.getMaxX();
    int maxZ = giantutil.getMaxZ();
    World world = giantutil.getWorld();
    double health = giantutil.getHealth();
    int skeletons = giantutil.getSkeletos();
    int spiders = giantutil.getSpiders();
    String brodcast = ConfigMenager.getMessages().getString("boss_respawn");


    public void run(){

        String nick = fixColors.fixColor((String) nicks.get(random.nextInt(nicks.size())));

        int x = random.nextInt(maxX*2)-maxX;
        int z = random.nextInt(maxZ*2)-maxZ;

        Location location = new Location(world, x, 150.0D, z);

        world.getChunkAt(location).load();

        LivingEntity giant = (LivingEntity) world.spawnEntity(location, EntityType.GIANT);
        giant.setMaxHealth(health);
        giant.setCustomName(nick);
        giant.setCustomNameVisible(true);
        giant.setHealth(health);
        giant.setFireTicks(100);

        for(int i = 0; i < skeletons; i++){
            Skeleton skeleton = (Skeleton) world.spawnEntity(location, EntityType.SKELETON);
            skeleton.setSkeletonType(Skeleton.SkeletonType.WITHER);
            skeleton.setMaxHealth(100.0D);
            skeleton.setHealth(100.0D);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 2));
        }

        for(int i = 0; i < spiders; i++){
            Spider spider = (Spider) world.spawnEntity(location, EntityType.SPIDER);
            spider.setMaxHealth(100.0D);
            spider.setHealth(100.0D);
            spider.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 2));
        }
        String s1 = brodcast.replace("{x}", Integer.toString(x));
        String s2 = s1.replace("{z}", Integer.toString(z));
        Bukkit.broadcastMessage(fixColors.fixColor(s2));

    }

}
