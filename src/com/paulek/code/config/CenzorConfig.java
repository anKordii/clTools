package com.paulek.code.config;

import com.paulek.code.Main;
import org.apache.commons.codec.language.bm.Lang;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

public class CenzorConfig {

    private static final String prefix = "cenzor.";
    public static boolean ENABLED = true;


    private static File file = new File(Main.getInstance().getDataFolder(), "cenzor.yml");
    private static FileConfiguration c = null;

    public static void load(){
        try {

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                InputStream is = Main.getInstance().getResource(file.getName());
                if (is != null)
                    copy(is, file);
            }

            c = YamlConfiguration.loadConfiguration(file);

            for (Field f : Lang.class.getFields()) {

                if (c.isSet(prefix + f.getName().toLowerCase().replaceFirst("_", ",").replace(",", ".")))
                    f.set(null, c.get(prefix + f.getName().toLowerCase().replaceFirst("_", ",").replace(",", ".")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
