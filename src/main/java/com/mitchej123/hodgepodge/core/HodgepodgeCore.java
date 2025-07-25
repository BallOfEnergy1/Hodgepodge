package com.mitchej123.hodgepodge.core;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;

import com.gtnewhorizon.gtnhlib.config.ConfigException;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;
import com.gtnewhorizon.gtnhlib.mixin.IMixins;
import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;
import com.mitchej123.hodgepodge.asm.AsmTransformers;
import com.mitchej123.hodgepodge.config.ASMConfig;
import com.mitchej123.hodgepodge.config.DebugConfig;
import com.mitchej123.hodgepodge.config.FixesConfig;
import com.mitchej123.hodgepodge.config.GeneralConfig;
import com.mitchej123.hodgepodge.config.SpeedupsConfig;
import com.mitchej123.hodgepodge.config.TweaksConfig;
import com.mitchej123.hodgepodge.mixins.Mixins;
import com.mitchej123.hodgepodge.util.StringPooler;
import com.mitchej123.hodgepodge.util.VoxelMapCacheMover;
import com.mitchej123.hodgepodge.util.WorldDataSaver;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.TransformerExclusions({ "com.mitchej123.hodgepodge.asm", "optifine" })
@IFMLLoadingPlugin.DependsOn("cofh.asm.LoadingPlugin")
public class HodgepodgeCore implements IFMLLoadingPlugin, IEarlyMixinLoader {

    private static boolean isObf;
    private String[] transformerClasses;

    static {
        try {
            ConfigurationManager.registerConfig(ASMConfig.class);
            ConfigurationManager.registerConfig(DebugConfig.class);
            ConfigurationManager.registerConfig(FixesConfig.class);
            ConfigurationManager.registerConfig(GeneralConfig.class);
            ConfigurationManager.registerConfig(SpeedupsConfig.class);
            ConfigurationManager.registerConfig(TweaksConfig.class);
            if (TweaksConfig.enableTagCompoundStringPooling || TweaksConfig.enableNBTStringPooling)
                StringPooler.setupPooler();
        } catch (ConfigException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveWorldData(File file, NBTTagCompound tag) {
        WorldDataSaver.INSTANCE.saveData(file, tag, true, false);
    }

    public static void saveWorldDataUncompressed(File file, NBTTagCompound tag) {
        WorldDataSaver.INSTANCE.saveData(file, tag, false, false);
    }

    public static void saveWorldDataBackup(File file, NBTTagCompound tag) {
        WorldDataSaver.INSTANCE.saveData(file, tag, true, true);
    }

    public static void savfeWorldDataUncompressedBackup(File file, NBTTagCompound tag) {
        WorldDataSaver.INSTANCE.saveData(file, tag, false, true);
    }

    @Override
    public String getMixinConfig() {
        return "mixins.hodgepodge.early.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        return IMixins.getEarlyMixins(Mixins.class, loadedCoreMods);
    }

    @Override
    public String[] getASMTransformerClass() {
        if (transformerClasses == null) {
            transformerClasses = AsmTransformers.getTransformers();
        }
        return transformerClasses;
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        VoxelMapCacheMover.changeFileExtensions((File) data.get("mcLocation"));
        isObf = (boolean) data.get("runtimeDeobfuscationEnabled");
    }

    @Override
    public String getAccessTransformerClass() {
        try {
            final Class<?> clazz = Class.forName("makamys.coretweaks.Config");
            CoreCompat.disableCoretweaksConflictingMixins();
        } catch (ClassNotFoundException e) {}
        return null;
    }

    public static boolean isObf() {
        return isObf;
    }
}
