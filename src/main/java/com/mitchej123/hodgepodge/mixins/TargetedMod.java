package com.mitchej123.hodgepodge.mixins;

import com.gtnewhorizon.gtnhlib.mixin.ITargetedMod;

import cpw.mods.fml.common.Mod;

public enum TargetedMod implements ITargetedMod {

    ADVANCED_SOLAR_PANELS("Advanced Solar Panels", null, "AdvancedSolarPanel"),
    ANGELICA("Angelica", "com.gtnewhorizons.angelica.loading.AngelicaTweaker", "angelica"),
    ARCHAICFIX("ArchaicFix", "org.embeddedt.archaicfix.ArchaicCore", "archaicfix"),
    AUTOMAGY("Automagy", null, "Automagy"),
    BAUBLES("Baubles", null, "Baubles"),
    BETTERHUD("Better HUD", null, "hud"),
    BIBLIOCRAFT("Bibliocraft", null, "BiblioCraft"),
    BOP("BiomesOPlenty", null, "BiomesOPlenty"),
    BUGTORCH("BugTorch", "jss.bugtorch.mixinplugin.BugTorchEarlyMixins", "bugtorch"),
    BUKKIT("Bukkit/Thermos", "Bukkit", null),
    CANDYCRAFT("candycraftmod", null, "candycraftmod"),
    COFH_CORE("CoFHCore", "cofh.asm.LoadingPlugin", "CoFHCore"),
    DAMAGE_INDICATORS("Damage Indicators", null, "DamageIndicatorsMod"),
    DREAMCRAFT("GT: New Horizons", "com.dreammaster.coremod.DreamCoreMod", "dreamcraft"),
    ETFURUMREQUIEM("Et Futurum Requiem", "ganymedes01.etfuturum.mixinplugin.EtFuturumEarlyMixins", "etfuturum"),
    EXTRATIC("ExtraTiC", null, "ExtraTiC"),
    EXTRA_UTILITIES("ExtraUtilities", null, "ExtraUtilities"),
    FASTCRAFT("FastCraft", "fastcraft.Tweaker"),
    FALSETWEAKS("FalseTweaks", "com.falsepattern.falsetweaks.asm.CoreLoadingPlugin", "falsetweaks"),
    GALACTICRAFT_CORE("GalacticraftCore", "micdoodle8.mods.galacticraft.core.asm.GCLoadingPlugin", "GalacticraftCore"),
    GLIBYS_VOICE_CHAT("Gliby's Voice Chat Mod", null, "gvc"),
    GT5U("GregTech5u", null, "gregtech"), // Also matches GT6.
    GT6("GregTech6", "gregtech.asm.GT_ASM", "gregapi"), // Can be used to exclude GT6 from the GT5U target.
    GTNHLIB("GTNHLib", "GTNHLib Core", "gtnhlib"),
    HARVESTCRAFT("harvestcraft", null, "harvestcraft"),
    HARVESTTHENETHER("harvestthenether", null, "harvestthenether"),
    HUNGER_OVERHAUL("HungerOverhaul", null, "HungerOverhaul"),
    IC2("IC2", "ic2.core.coremod.IC2core", "IC2"),
    IMMERSIVE_ENGINENEERING("Immersive Engineering", null, "ImmersiveEngineering"),
    JOURNEYMAP("JourneyMap", null, "journeymap"),
    LOTR("The Lord of the rings mod", "lotr.common.coremod.LOTRLoadingPlugin", "lotr"),
    LWJGL3IFY("lwjgl3ify", "me.eigenraven.lwjgl3ify.core.Lwjgl3ifyCoremod", "lwjgl3ify"),
    MINECHEM("Minechem", null, "minechem"),
    MINEFACTORY_RELOADED("MineFactory Reloaded", null, "MineFactoryReloaded"),
    MODULARPOWERSUITS("MachineMuse's Modular Powersuits", null, "powersuits"),
    MORPHEUS("Morpheus", null, "Morpheus"),
    MRTJPCORE("MrTJPCore", null, "MrTJPCoreMod"),
    NOTENOUGHITEMS("NotEnoughItems", "codechicken.nei.asm.NEICorePlugin", "NotEnoughItems"),
    OPTIFINE("Optifine", "optifine.OptiFineForgeTweaker", "Optifine"),
    PORTAL_GUN("PortalGun", null, "PortalGun"),
    PROJECTE("ProjectE", null, "ProjectE"),
    RAILCRAFT("Railcraft", null, "Railcraft"),
    SPOOL("Spool", "com.gamma.spool.SpoolCoreMod", "spool"),
    THAUMCRAFT("Thaumcraft", null, "Thaumcraft"), // "thaumcraft.codechicken.core.launch.DepLoader"
    THERMALDYNAMICS("Thermal Dynamics", null, "ThermalDynamics"),
    THERMALEXPANSION("Thermal Expansion", null, "ThermalExpansion"),
    TINKERSCONSTRUCT("TConstruct", null, "TConstruct"),
    TRAVELLERSGEAR("TravellersGear", null, "TravellersGear"),
    VANILLA("Minecraft", null),
    VOXELMAP("VoxelMap", "com.thevoxelbox.voxelmap.litemod.VoxelMapTransformer", "voxelmap"),
    WITCHERY("Witchery", null, "witchery"),
    XAEROMINIMAP("Xaero's Minimap", null, "XaeroMinimap"),
    XAEROWORLDMAP("Xaero's World Map", null, "XaeroWorldMap"),
    ZTONES("ZTones", null, "Ztones");

    /** The "name" in the {@link Mod @Mod} annotation */
    public final String modName;
    /** Class that implements the IFMLLoadingPlugin interface */
    public final String coreModClass;
    /** The "modid" in the {@link Mod @Mod} annotation */
    public final String modId;

    TargetedMod(String modName, String coreModClass) {
        this(modName, coreModClass, null);
    }

    TargetedMod(String modName, String coreModClass, String modId) {
        this.modName = modName;
        this.coreModClass = coreModClass;
        this.modId = modId;
    }

    @Override
    public String toString() {
        return "TargetedMod{modName='" + modName + "', coreModClass='" + coreModClass + "', modId='" + modId + "'}";
    }

    @Override
    public String getCoreModClass() {
        return coreModClass;
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public String getModName() {
        return modName;
    }
}
