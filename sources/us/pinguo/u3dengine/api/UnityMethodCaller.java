package us.pinguo.u3dengine.api;

import android.text.TextUtils;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.collections.c0;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.u;
import us.pinguo.common.log.a;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.u3dengine.PgUnityPlayer;
import us.pinguo.util.d;
/* compiled from: UnityMethodCaller.kt */
/* loaded from: classes6.dex */
public final class UnityMethodCaller {
    private static final String EFFECT_MESSAGE_RECEIVER = "BaseRenderController";
    private static final String ENGINE_MESSAGE_RECEIVER = "PGCameraEngine";
    public static final UnityMethodCaller INSTANCE = new UnityMethodCaller();

    /* compiled from: UnityMethodCaller.kt */
    /* loaded from: classes6.dex */
    public enum FilterType {
        Local,
        Path,
        None
    }

    private UnityMethodCaller() {
    }

    public static final void cleanUp() {
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "Clean", "");
        d.d("Clean");
    }

    public static final void clearAllMakeup() {
        a.c("clearAllMakeup", new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetMakeupThemeMat", "");
        d.d("SetMakeupThemeMat");
    }

    public static final void clearMakeup(MakeupType type) {
        s.h(type, "type");
        String str = "null," + type.getKey() + ",-1,0";
        a.c("clearMakeup: '" + str + '\'', new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetMakeupMat", str);
        d.d("SetMakeupMat");
    }

    public static final void clearSticker(boolean z) {
        String str = z ? "1" : "";
        a.c(s.q("clearSticker:", Boolean.valueOf(z)), new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "ClearBundleLua", str);
        d.d("ClearBundleLua");
    }

    public static /* synthetic */ void clearSticker$default(boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        clearSticker(z);
    }

    public static final void loadStickerBundle(String bundlePath, String luaName) {
        s.h(bundlePath, "bundlePath");
        s.h(luaName, "luaName");
        a.c("loadStickerBundle:" + bundlePath + ", " + luaName, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(bundlePath);
        sb.append(',');
        sb.append(luaName);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "LoadBundleLua", sb.toString());
        d.d("LoadBundleLua");
    }

    private final float normalize0to1(float f2) {
        if (f2 < 0.0f) {
            return 0.0f;
        }
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private final float normalizeNegative1to1(float f2) {
        if (f2 < -1.0f) {
            return -1.0f;
        }
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    public static final void requestSetFilter() {
        a.c("requestSetFilter", new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetFilterSignal", "");
        d.d("SetFilterSignal");
    }

    private final void sampleSetDeformationParam() {
        DeformationParam deformationParam = DeformationParam.FACE_TYPE_SHAONV;
        setDeformation(deformationParam);
        setDeformation(deformationParam, DeformationParam.MOUTH_TYPE_WEIXIAO);
        DeformationParam deformationParam2 = DeformationParam.FACE_ADJUST_XIAOLIAN;
        deformationParam2.setValue(0.5f);
        u uVar = u.a;
        DeformationParam deformationParam3 = DeformationParam.EYE_ADJUST_YANDAXIAO;
        deformationParam3.setValue(0.7f);
        setDeformation(deformationParam2, deformationParam3);
    }

    private final void sampleSetMakeupFixParam() {
        MakeupFixParam makeupFixParam = MakeupFixParam.BLUSHER;
        makeupFixParam.setValue(0.5f);
        u uVar = u.a;
        MakeupFixParam makeupFixParam2 = MakeupFixParam.FACE_HIGHLIGHT;
        makeupFixParam2.setValue(0.7f);
        setFixingMakeup(makeupFixParam, makeupFixParam2);
    }

    private final void sampleSetSoftSkinParam() {
        SoftSkinParam softSkinParam = SoftSkinParam.SOFT_SKIN;
        setSoftSkin(softSkinParam);
        setSoftSkin(softSkinParam, SoftSkinParam.SMOOTH);
        softSkinParam.setValue(0.5f);
        u uVar = u.a;
        SoftSkinParam softSkinParam2 = SoftSkinParam.FA_LING_WEN;
        softSkinParam2.setValue(0.7f);
        setSoftSkin(softSkinParam, softSkinParam2);
        setSoftSkin((SoftSkinParam[]) Arrays.copyOf(new SoftSkinParam[]{softSkinParam, SoftSkinParam.CHUN_WEN}, 2));
    }

    public static final void setContrastValue(float f2) {
        a.c(s.q("setContrastValue: ", p.a), new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetBaseAdjustParameter", s.q("contrast,", Float.valueOf(INSTANCE.normalizeNegative1to1(f2) / 2)));
        d.d("SetBaseAdjustParameter");
    }

    public static final void setDeformation(DeformationParam... params) {
        CharSequence h0;
        s.h(params, "params");
        StringBuilder sb = new StringBuilder();
        int length = params.length;
        int i2 = 0;
        while (i2 < length) {
            DeformationParam deformationParam = params[i2];
            i2++;
            if (deformationParam == DeformationParam.NOSE_ADJUST_BISHANGXIA) {
                deformationParam.setValue(deformationParam.getValue() * 2.0f);
            }
            sb.append(deformationParam.getKey() + ',' + deformationParam.getValue() + '|');
        }
        h0 = StringsKt__StringsKt.h0(sb, Effect.DIVIDER);
        if (h0.length() > 0) {
            a.c("setDeformation: '" + ((Object) h0) + '\'', new Object[0]);
            PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetDeformationParameter", h0.toString());
            d.d("SetDeformationParameter");
        }
    }

    public static final void setFilterInfo(FilterType type, String path) {
        s.h(type, "type");
        s.h(path, "path");
        FilterType filterType = FilterType.Path;
        if (type == filterType && TextUtils.isEmpty(path)) {
            a.e("path should not be empty when set path type filter!", new Object[0]);
            return;
        }
        if (type != filterType) {
            path = type.toString().toLowerCase(Locale.ROOT);
            s.g(path, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        a.c(s.q("SetFilterInfo:", path), new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetFilterInfo", path);
    }

    public static /* synthetic */ void setFilterInfo$default(FilterType filterType, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        setFilterInfo(filterType, str);
    }

    public static final void setFilterOpacity(float f2) {
        a.c(s.q("setFilterOpacity:", Float.valueOf(f2)), new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetOpacityForRealRender", String.valueOf(INSTANCE.normalize0to1(f2)));
        d.d("SetOpacityForRealRender");
    }

    public static final void setFilterToDefault() {
        a.c("setFilterToDefault", new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetFilterToDefault", "");
        d.d("SetFilterToDefault");
    }

    public static final void setFixedMakeupIntensity(float f2) {
        a.c(s.q("setFixedMakeupIntensity: ", Float.valueOf(f2)), new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetFixedMakeupIntensity", String.valueOf(f2));
    }

    public static final void setFixingMakeup(MakeupFixParam... params) {
        CharSequence h0;
        s.h(params, "params");
        StringBuilder sb = new StringBuilder();
        int length = params.length;
        int i2 = 0;
        while (i2 < length) {
            MakeupFixParam makeupFixParam = params[i2];
            i2++;
            sb.append(makeupFixParam.getKey$u3dengine_release() + ',' + makeupFixParam.getValue() + '|');
        }
        h0 = StringsKt__StringsKt.h0(sb, Effect.DIVIDER);
        a.c("setFixingMakeup: '" + ((Object) h0) + '\'', new Object[0]);
        if (h0.length() > 0) {
            PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetAutoFixedParameter", h0.toString());
            d.d("SetAutoFixedParameter");
        }
    }

    public static final void setMakeupMaterial(String bundlePath, MakeupType type, int i2, float f2) {
        s.h(bundlePath, "bundlePath");
        s.h(type, "type");
        if (type == MakeupType.FACE_T_AREA) {
            f2 *= 0.82f;
        }
        String str = bundlePath + ',' + type.getKey() + ',' + i2 + ',' + INSTANCE.normalize0to1(f2);
        a.c("setMakeupMaterial: '" + str + '\'', new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetMakeupMat", str);
        d.d("SetMakeupMat");
    }

    public static /* synthetic */ void setMakeupMaterial$default(String str, MakeupType makeupType, int i2, float f2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            f2 = 1.0f;
        }
        setMakeupMaterial(str, makeupType, i2, f2);
    }

    public static final void setMakeupTheme(List<MakeupMaterial> theme, float f2) {
        s.h(theme, "theme");
        if (!theme.isEmpty()) {
            String str = "";
            int i2 = 0;
            for (Object obj : theme) {
                int i3 = i2 + 1;
                if (i2 >= 0) {
                    MakeupMaterial makeupMaterial = (MakeupMaterial) obj;
                    if (f2 >= 0.0f) {
                        makeupMaterial.setValue(f2);
                    }
                    str = s.q(str, makeupMaterial.toUnityParam$u3dengine_release());
                    if (i2 != theme.size() - 1) {
                        str = s.q(str, Effect.DIVIDER);
                    }
                    i2 = i3;
                } else {
                    kotlin.collections.s.n();
                    throw null;
                }
            }
            a.c("setMakeupTheme: '" + str + '\'', new Object[0]);
            PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetMakeupThemeMat", str);
            d.d("SetMakeupThemeMat");
            return;
        }
        a.c("setMakeupTheme empty param", new Object[0]);
    }

    public static /* synthetic */ void setMakeupTheme$default(List list, float f2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f2 = -1.0f;
        }
        setMakeupTheme(list, f2);
    }

    public static final void setMakeupThemeValue(float f2) {
        a.c("setMakeupThemeValue: '" + f2 + '\'', new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetMakeupThemeParameter", String.valueOf(INSTANCE.normalize0to1(f2)));
        d.d("SetMakeupThemeParameter");
    }

    public static final void setMakeupValue(MakeupType type, float f2) {
        s.h(type, "type");
        StringBuilder sb = new StringBuilder();
        sb.append(type.getKey());
        sb.append(',');
        sb.append(INSTANCE.normalize0to1(f2));
        String sb2 = sb.toString();
        a.c("setMakeupValue: '" + sb2 + '\'', new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetMakeupParameter", sb2);
        d.d("SetMakeupParameter");
    }

    public static /* synthetic */ void setMakeupValue$default(MakeupType makeupType, float f2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f2 = 1.0f;
        }
        setMakeupValue(makeupType, f2);
    }

    public static final void setPreviewRenderState(RenderState state) {
        s.h(state, "state");
        a.c(s.q("setPreviewRenderState:", state), new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetPreviewRenderState", String.valueOf(state.ordinal()));
        d.d("SetPreviewRenderState");
    }

    public static final void setSaturationValue(float f2) {
        a.c(s.q("setSaturationValue: ", p.a), new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetBaseAdjustParameter", s.q("saturation,", Float.valueOf(INSTANCE.normalizeNegative1to1(f2))));
        d.d("SetBaseAdjustParameter");
    }

    public static final void setScreenOrientation(ScreenOrientation orientation) {
        s.h(orientation, "orientation");
        a.c(s.q("setScreenOrientation:", orientation), new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "OnScreenOrientationChanged", String.valueOf(orientation.getValue()));
        d.d("OnScreenOrientationChanged");
    }

    public static final void setSkyChangeFilterInfo(FilterType type, String path) {
        s.h(type, "type");
        s.h(path, "path");
        FilterType filterType = FilterType.Path;
        if (type == filterType && TextUtils.isEmpty(path)) {
            a.e("path should not be empty when set path type filter!", new Object[0]);
            return;
        }
        if (type != filterType) {
            path = type.toString().toLowerCase(Locale.ROOT);
            s.g(path, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        a.c(s.q("SetSkyChangeFilterInfo:", path), new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetSkyChangeFilterInfo", path);
    }

    public static /* synthetic */ void setSkyChangeFilterInfo$default(FilterType filterType, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        setSkyChangeFilterInfo(filterType, str);
    }

    public static /* synthetic */ void setSkyChangeParameter$default(UnityMethodCaller unityMethodCaller, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Integer num, Float f9, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = null;
        }
        if ((i2 & 2) != 0) {
            f3 = null;
        }
        if ((i2 & 4) != 0) {
            f4 = null;
        }
        if ((i2 & 8) != 0) {
            f5 = null;
        }
        if ((i2 & 16) != 0) {
            f6 = null;
        }
        if ((i2 & 32) != 0) {
            f7 = null;
        }
        if ((i2 & 64) != 0) {
            f8 = null;
        }
        if ((i2 & 128) != 0) {
            num = null;
        }
        if ((i2 & 256) != 0) {
            f9 = null;
        }
        if ((i2 & 512) != 0) {
            z = false;
        }
        unityMethodCaller.setSkyChangeParameter(f2, f3, f4, f5, f6, f7, f8, num, f9, z);
    }

    public static final void setSoftSkin(SoftSkinParam... params) {
        CharSequence h0;
        s.h(params, "params");
        StringBuilder sb = new StringBuilder();
        int length = params.length;
        int i2 = 0;
        while (i2 < length) {
            SoftSkinParam softSkinParam = params[i2];
            i2++;
            if (softSkinParam == SoftSkinParam.WHITE_TOOTH) {
                sb.append(softSkinParam.getKey() + ',' + (softSkinParam.getValue() * 0.6f) + '|');
            } else {
                sb.append(softSkinParam.getKey() + ',' + softSkinParam.getValue() + '|');
            }
        }
        h0 = StringsKt__StringsKt.h0(sb, Effect.DIVIDER);
        a.c("setSoftSkin: '" + ((Object) h0) + '\'', new Object[0]);
        if (h0.length() > 0) {
            PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetSoftSkinParameter", h0.toString());
            d.d("SetSoftSkinParameter");
        }
    }

    public static final void setUnityVolume(float f2) {
        a.c(s.q("setUnityVolume:", Float.valueOf(f2)), new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetUnityVolume", String.valueOf(INSTANCE.normalize0to1(f2)));
        d.d("SetUnityVolume");
    }

    public static final void setWatermarkShowOnScreen(boolean z) {
        a.c(s.q("setWatermarkShowOnScreen:", Boolean.valueOf(z)), new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetWatermarkShowOnScreen", z ? "1" : "0");
        d.d("SetWatermarkShowOnScreen");
    }

    public static final void setWatermarkStyle(WatermarkStyle style) {
        s.h(style, "style");
        a.c(s.q("setWatermarkStyle:", Integer.valueOf(style.ordinal())), new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetWatermarkStyle", String.valueOf(style.ordinal()));
        d.d("SetWatermarkStyle");
    }

    public static final void startCaptureRender() {
        a.c("startCaptureRender", new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetCurrentCameraInformation", "1");
        d.d("SetCurrentCameraInformation");
    }

    public static final void startRecord() {
        a.c("startRecord", new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "OnStartRecord", "");
        d.d("OnStartRecord");
    }

    public static final void startRender() {
        a.c("UnitySendMessage SetCurrentCameraInformation 0---start", new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetCurrentCameraInformation", "0");
        a.c("UnitySendMessage SetCurrentCameraInformation 0---done", new Object[0]);
        d.d("SetCurrentCameraInformation");
    }

    public static final void startRenderHDImage(boolean z) {
        String str = z ? "1" : "0";
        a.c(s.q("startRenderHDImage:", Boolean.valueOf(z)), new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "StartRenderHDImage", str);
        d.d("StartRenderHDImage");
    }

    public static /* synthetic */ void startRenderHDImage$default(boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        startRenderHDImage(z);
    }

    public static final void startRenderScreenImage(boolean z) {
        a.c(s.q("startRenderScreenImage:", Boolean.valueOf(z)), new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "StartRenderScreenImage", z ? "1" : "");
        d.d("StartRenderScreenImage");
    }

    public static /* synthetic */ void startRenderScreenImage$default(boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        startRenderScreenImage(z);
    }

    public static final void stopAutoUpdateTexture() {
        a.c("stopAutoUpdateTexture", new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "StopAutoUpdateTexture", "");
        d.d("StopAutoUpdateTexture");
    }

    public static final void stopRecord() {
        a.c("stopRecord", new Object[0]);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "OnStopRecord", "");
        d.d("OnStopRecord");
    }

    public static final void updateRender() {
        a.c("UnitySendMessage UpdateTextureByPtr", new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "UpdateTextureByPtr", "");
        d.d("UpdateTextureByPtr");
    }

    public final void cleanSkyChangeRenderAssets() {
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "CleanSkyChangeRenderAssets", "");
        d.d("CleanSkyChangeRenderAssets");
        a.c(s.q("CleanSkyChangeRenderAssets:", ""), new Object[0]);
    }

    public final void renderObjectWithTransformInfo(float f2, float f3, float f4, float f5) {
        StringBuilder sb = new StringBuilder();
        sb.append(f2);
        sb.append(',');
        sb.append(f3);
        sb.append(',');
        sb.append(f4);
        sb.append(',');
        sb.append(f5);
        String sb2 = sb.toString();
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "RenderObjectWithTransformInfo", sb2);
        d.d("RenderObjectWithTransformInfo");
        a.c(s.q("RenderObjectWithTransformInfo:", sb2), new Object[0]);
    }

    public final void setAutoSHTexture(String shPath) {
        s.h(shPath, "shPath");
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetAutoSHTexture", shPath);
        d.d("SetAutoSHTexture");
        a.c(s.q("SetAutoSHTexture:", shPath), new Object[0]);
    }

    public final void setSkyChangeMask(String maskPath) {
        s.h(maskPath, "maskPath");
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetSkyChangeMaskTexture", maskPath);
        d.d("SetSkyChangeMaskTexture");
        a.c(s.q("SetSkyChangeMaskTexture:", maskPath), new Object[0]);
    }

    public final void setSkyChangeParameter(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Integer num, Float f9, boolean z) {
        String J;
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(TaskDetailBasePresenter.SCENE_LIST);
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(',');
            sb.append(f3);
            sb.append(',');
            sb.append(f4);
            sb.append(',');
            sb.append(f5);
            sb.append(',');
            sb.append(f6);
            sb.append(',');
            sb.append(f7);
            sb.append(',');
            sb.append(f8);
            sb.append(',');
            sb.append(num);
            sb.append(',');
            sb.append(f9);
            arrayList.add(sb.toString());
        } else {
            if (f2 != null) {
                arrayList.add(s.q("0|", f2));
            }
            if (f3 != null) {
                arrayList.add(s.q("1|", f3));
            }
            if (f4 != null) {
                arrayList.add(s.q("2|", f4));
            }
            if (f5 != null) {
                arrayList.add(s.q("3|", f5));
            }
            if (f6 != null) {
                arrayList.add(s.q("4|", f6));
            }
            if (f7 != null) {
                arrayList.add(s.q("5|", f7));
            }
            if (f8 != null) {
                arrayList.add(s.q("6|", f8));
            }
            if (num != null) {
                arrayList.add(s.q("7|", num));
            }
            if (f9 != null) {
                arrayList.add(s.q("8|", f9));
            }
        }
        J = c0.J(arrayList, Effect.DIVIDER, null, null, 0, null, null, 62, null);
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetSkyChangeParameter", J);
        d.d("SetSkyChangeParameter");
        a.c(s.q("SetSkyChangeParameter:", J), new Object[0]);
    }

    public final void setSkyTransformInfo(float f2, float f3, float f4, float f5) {
        StringBuilder sb = new StringBuilder();
        sb.append(f2);
        sb.append(',');
        sb.append(f3);
        sb.append(',');
        sb.append(f4);
        sb.append(',');
        sb.append(f5);
        String sb2 = sb.toString();
        PgUnityPlayer.a(ENGINE_MESSAGE_RECEIVER, "SetSkyTransformInfo", sb2);
        d.d("SetSkyTransformInfo");
        a.c(s.q("SetSkyTransformInfo:", sb2), new Object[0]);
    }

    public static final void setMakeupMaterial(MakeupMaterial mat) {
        s.h(mat, "mat");
        String unityParam$u3dengine_release = mat.toUnityParam$u3dengine_release();
        a.c("setMakeupMaterial: '" + unityParam$u3dengine_release + '\'', new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetMakeupMat", unityParam$u3dengine_release);
        d.d("SetMakeupMat");
    }

    public static final void setDeformation(String[] paramStrings) {
        CharSequence h0;
        s.h(paramStrings, "paramStrings");
        if (paramStrings.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = paramStrings.length;
        int i2 = 0;
        while (i2 < length) {
            String str = paramStrings[i2];
            i2++;
            sb.append(s.q(str, Effect.DIVIDER));
        }
        h0 = StringsKt__StringsKt.h0(sb, Effect.DIVIDER);
        a.c("setDeformation: '" + ((Object) h0) + '\'', new Object[0]);
        PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetDeformationParameter", h0.toString());
        d.d("SetDeformationParameter");
    }

    public static final void setSoftSkin(String[] paramStrings) {
        CharSequence h0;
        s.h(paramStrings, "paramStrings");
        int i2 = 0;
        a.c("setSoftSkin: '" + paramStrings + '\'', new Object[0]);
        if (!(paramStrings.length == 0)) {
            StringBuilder sb = new StringBuilder();
            int length = paramStrings.length;
            while (i2 < length) {
                String str = paramStrings[i2];
                i2++;
                sb.append(s.q(str, Effect.DIVIDER));
            }
            h0 = StringsKt__StringsKt.h0(sb, Effect.DIVIDER);
            PgUnityPlayer.a(EFFECT_MESSAGE_RECEIVER, "SetSoftSkinParameter", h0.toString());
            d.d("SetSoftSkinParameter");
        }
    }
}
