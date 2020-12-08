package de.b100.customworldgen;

import java.io.File;

import com.google.gson.Gson;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = CustomWorldGenMod.MODID, name = CustomWorldGenMod.NAME, version = CustomWorldGenMod.VERSION)
public class CustomWorldGenMod
{
    public static final String MODID = "customworldgen";
    public static final String NAME = "Custom World Gen";
    public static final String VERSION = "1.0";

    public static File configFolder;
    public static File modConfigFolder;
    
    public static Gson gson = new Gson();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        configFolder = event.getModConfigurationDirectory();
        modConfigFolder = new File(configFolder, "customworldgen");

        WorldGenerator.instance = new WorldGenerator();
        GameRegistry.registerWorldGenerator(WorldGenerator.instance, 1);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        WorldGenerator.biomeGroups = BiomeGroup.loadBiomeGroups();
        WorldGenerator.generators = Generator.loadGenerators();
    }
}
