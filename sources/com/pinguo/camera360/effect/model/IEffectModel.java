package com.pinguo.camera360.effect.model;

import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.camera360.effect.model.entity.EffectType;
import java.util.List;
/* loaded from: classes3.dex */
public interface IEffectModel {
    public static final String[] sSceneEffectOldValue = {"blackwhite", "lomo105", "lomo108", "enhance", "businesscolor", "lomofilm", "greenish", "velvia_vivid", "fakehdr", "fakehdr_enhance", "fisheye", "sketch", "colorsketch", "linesketch", "dream", "backto1839", "colorful", "sketch_class,1"};
    public static final String[] sSceneEffectNewValue = {"bw_class,0", "lomo_class,0", "lomo_class,2", "enhance_class,0", "enhance_class,7", "lomo_class,1", "lomo_class,2", "enhance_class,4", "hdrpro_class,0", "hdrpro_class,4", "funny_class,5", "sketch_class,2", "sketch_class,4", "sketch_class,8", "dream", "backto1839,/sdcard/Camera360/Data/test_old.png", "colorful_class,0,0", "sketch_class,8"};
    public static final String[] sSceneGPUEffectValue = {"C360_Skin_Soft", "C360_Skin_DepthClean", "C360_Skin_SoftWhitening", "C360_Skin_DepthWhitening", "C360_Skin_CleanBW", "C360_Skin_Sunshine", "C360_Skin_Greenish", "C360_Skin_RedLip", "C360_Skin_Sweet", "C360_LightColor_SweetRed", "C360_LightColor_ColorBlue", "LightColor_Lighting;Offset=1,0;Direct=0", "LightColor_Lighting;Offset=0,1;Direct=1", "C360_LightColor_Beauty", "C360_LightColor_Cyan", "C360_LightColor_LowSatGreen", "C360_LightColor_NatureFresh", "C360_LightColor_NatureWarm", "C360_LOMO_Cyan", "C360_LOMO_Film", "C360_LOMO_Greenish", "C360_LOMO_Fashion", "C360_LOMO_Recall", "C360_LOMO_Cold", "C360_LOMO_Warm", "C360_LOMO_Zest", "C360_LOMO_Leaf", "C360_Enhance_Auto", "C360_Enhance_Night", "C360_Enhance_Room", "C360_Enhance_Warm", "C360_Enhance_Cool", "C360_Enhance_Vivid", "C360_Enhance_Strong", "C360_Enhance_Balance", "C360_Enhance_Cold", "C360_Retro_Decadent", "C360_Retro_Hazy", "C360_Retro_Rustic", "C360_Retro_Recall", "C360_Retro_Blue", "C360_Retro_Turn", "C360_Retro_Yellow", "C360_Retro_Greenish", "C360_Retro_Blueish", "C360_HDR_ORIGINAL", "C360_HDR_Soft", "C360_HDR_Vivid", "C360_HDR_Enhance", "C360_HDR_Shine", "C360_HDR_Storm", "C360_Sketch_Line", "C360_Sketch_BW", "C360_Sketch_Yellow", "C360_Sketch_Color", "C360_Sketch_ColorMul", "C360_Sketch_Neon", "C360_Sketch_WideLine", "C360_Sketch_LightColor", "C360_Sketch_SoftColor", "C360_Colorful_rainbow", "C360_Colorful_Crystal", "C360_Colorful_Sky", "C360_Colorful_Cloud", "C360_Colorful_Ripple", "C360_Colorful_Vivid", "C360_Colorful_Flow", "C360_Colorful_Red", "C360_Colorful_Gold", "C360_Colorful_Purple", "C360_Dream_Stand", "C360_Old_BackTo1839", "Funny_Mirror;mirrorType=0", "Funny_Mirror;mirrorType=1", "Funny_Mirror;mirrorType=2", "Funny_Mirror;mirrorType=3", "Funny_FishEye_Android;radius=0.5;amount=0.8", "C360_Funny_Pop1", "C360_Funny_Pop2", "C360_Funny_Pop3", "C360_Funny_Pop4", "C360_ShiftColor_Red1", "C360_ShiftColor_Red2", "C360_ShiftColor_Yellow1", "C360_ShiftColor_Green", "C360_ShiftColor_Blue", "C360_ShiftColor_SkyBlue", "C360_ShiftColor_Yellow2", "C360_ShiftColor_Purple", "C360_ShiftColor_Summer", "C360_BW_Normal", "C360_BW_Enhance", "C360_BW_Strong", "C360_BW_Storm", "C360_BW_Art"};
    public static final String[] sSceneCPUEffectValue = {"skin_class,0", "skin_class,1", "skin_class,2", "skin_class,3", "skin_class,4", "skin_class,5", "skin_class,6", "skin_class,7", "skin_class,8", "lightcolor_class,0", "lightcolor_class,2", "lightcolor_class,9,1", "lightcolor_class,7", "lightcolor_class,9,0", "lightcolor_class,6", "lightcolor_class,13", "lightcolor_class,14", "lightcolor_class,15", "lomo_class,0", "lomo_class,2", "lomo_class,1", "lomo_class,9", "lomo_class,5", "lomo_class,10", "lomo_class,7", "lomo_class,8", "lomo_class,4", "enhance_class,0", "enhance_class,6", "enhance_class,1", "enhance_class,7", "enhance_class,9", "enhance_class,4", "enhance_class,3", "enhance_class,5", "enhance_class,8", "retro_class,0", "retro_class,1", "retro_class,2", "retro_class,4", "retro_class,5", "retro_class,6", "retro_class,8", "retro_class,9", "retro_class,10", "hdrpro_class,200,50,50,0,0", "hdrpro_class,0", "hdrpro_class,2", "hdrpro_class,4", "hdrpro_class,100,2,6,18,20", "hdrpro_class,100,4,5,40,40", "sketch_class,8", "sketch_class,2", "sketch_class,15,0", "sketch_class,4", "sketch_class,11,0", "sketch_class,16,0", "sketch_class,9", "sketch_class,14,0", "sketch_class,10", "colorful_class,0,0", "colorful_class,0,1", "colorful_class,0,2", "colorful_class,0,3", "colorful_class,0,4", "colorful_class,0,5", "colorful_class,0,6", "colorful_class,0,7", "colorful_class,0,8", "colorful_class,0,9", "dream", "backto1839,/sdcard/Camera360/Data/test_old.png", "funny_class,0", "funny_class,1", "funny_class,2", "funny_class,3", "funny_class,4", "funny_class,5", "funny_class,6", "funny_class,7", "funny_class,8", "bw_class,100,235,54,157,40,50", "bw_class,100,255,0,0,40,20", "bw_class,100,245,80,0,30,50", "bw_class,100,115,255,100,70,70", "bw_class,100,0,50,255,32,70", "bw_class,100,0,170,255,40,40", "bw_class,100,255,255,0,35,50", "bw_class,100,150,0,255,60,55", "bw_class,100,10,255,145,105,80", "bw_class,0", "bw_class,1", "bw_class,2", "bw_class,3", "bw_class,4"};

    Effect getEffectByKey(String str);

    EffectType getEffectTypeByEffectKey(String str);

    EffectType getEffectTypeByKey(String str);

    List<EffectType> getEffectTypes(Effect.Type type);

    List<Effect> getEffectsByPackKey(String str);

    List<Effect> getEffectsByTypeKey(String str);

    List<String> getPackKeyListInEffectType(EffectType effectType);

    boolean updateEffectTypeSort(List<EffectType> list);

    boolean updateFrontImage(String str, String str2);
}
