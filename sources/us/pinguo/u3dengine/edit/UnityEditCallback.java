package us.pinguo.u3dengine.edit;

import android.graphics.Color;
import us.pinguo.common.log.a;
import us.pinguo.u3dengine.api.NativeFacesData;
/* loaded from: classes6.dex */
public class UnityEditCallback {
    private static UnityEditCallbackApi mImpl;

    public static void OnStaticStickerStatusChanged(String str, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3) {
        a.c("OnStaticStickerStatusChanged: key=" + str + ",stickerStatus=" + i3 + ",blendMode=" + i2, new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onStaticStickerStatusChanged(str, f2, f3, f4, f5, f6, f7, i2, i3);
        }
    }

    public static void ReportBodyBeatifyEffectStatus(boolean z) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportBodyBeatifyEffectStatus(z);
        }
    }

    public static void ReportBodyBeautifyToolUpdated(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportBodyBeautifyToolUpdated(f2, f3, f4, f5, f6, f7, f8, f9, f10, z);
        }
    }

    public static void ReportBokehGeneratedIconTexture(int i2, int i3, int i4) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportBokehGeneratedIconTexture(i2, i3, i4);
        }
    }

    public static void ReportBokehGeneratedPreviewMaskTexture(int i2, int i3, int i4) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportBokehGeneratedPreviewMaskTexture(i2, i3, i4);
        }
    }

    public static void ReportBokehShapePreviewTexture(int i2, int i3, int i4) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportBokehShapePreviewTexture(i2, i3, i4);
        }
    }

    public static void ReportCurrentFilterTexture(int i2, int i3, int i4) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportCurrentFilterTexture(i2, i3, i4);
        }
    }

    public static void ReportStaticStickerLayerStatus(String str, boolean z, boolean z2) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportStaticStickerLayerStatus(str, z, z2);
        }
    }

    public static NativeFacesData editUpdateFaceData(int i2, int i3, int i4) {
        a.c("editUpdateFaceData  tid:" + i2 + "   width:" + i3 + "  height:" + i4, new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            return unityEditCallbackApi.editUpdateFaceData(i2, i3, i4);
        }
        return new NativeFacesData();
    }

    public static int getCustomSpotDetected() {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        int customSpotDetected = unityEditCallbackApi != null ? unityEditCallbackApi.getCustomSpotDetected() : 0;
        a.c("getCustomSpotDetected:" + customSpotDetected, new Object[0]);
        return customSpotDetected;
    }

    public static NativeFilterInfo getEditFilterInfos() {
        a.c("getEditFilterInfos", new Object[0]);
        return new NativeFilterInfo("", "", "");
    }

    public static boolean getFilterAdjustIs64Level() {
        a.c("preNativeFilterRendering", new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            return unityEditCallbackApi.getFilterAdjustIs64Level();
        }
        return false;
    }

    public static String getGLExtensions() {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            String gLExtensions = unityEditCallbackApi.getGLExtensions();
            a.c("glExtensions:" + gLExtensions, new Object[0]);
            return gLExtensions;
        }
        return "";
    }

    public static void onCanvasTransformChanged(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        a.c("onCanvasTransformChanged  screen:" + f2 + "x" + f3 + "    origCanvas:" + f4 + "x" + f5 + "    newCanvas:" + f6 + "x" + f7 + "    offset:" + f8 + "," + f9 + "  " + f10, new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onCanvasTransformChanged(f2, f3, f4, f5, f6, f7, f8, f9, f10);
        }
    }

    public static void onClipViewChanged(float f2, float f3, float f4, float f5) {
        a.c("onClipViewChanged left=" + f2 + ", up=" + f3 + ", right=" + f4 + ", down=" + f5, new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onClipViewChanged(f2, f3, f4, f5);
        }
    }

    public static void onEditCurrentTextureUpdate(int i2, int i3, int i4) {
        a.c("onEditCurrentTextureUpdate", new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onEditCurrentTextureUpdate(i2, i3, i4);
        }
    }

    public static void onEditImagedSavedSuccess(String str, boolean z) {
        a.c("onEditImagedSavedSuccess:" + str + "   " + z, new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onEditImagedSavedSuccess(str, z);
        }
    }

    public static void onEditMakeupInitRenderComplete() {
        a.c("onEditMakeupInitRenderComplete", new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onEditMakeupInitRenderComplete();
        }
    }

    public static void onMagicBackgroundItemStatusChanged(String str, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onMagicBackgroundItemStatusChanged(str, f2, f3, f4, f5, f6, f7, i2, i3);
        }
    }

    public static void onMagicBackgroundMattingMaskImagePrepared(String str, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3, int i4, int i5, float f8, float f9) {
        a.c("key='" + str + "', imageW=" + f2 + ", imageH=" + f3 + ", cutCenterX=" + f4 + ", cutCenterY=" + f5 + ", cutWidth=" + f6 + ", cutHeight=" + f7 + ", cutTexTid=" + i2 + ", maskWidth=" + i3 + ", maskHeight=" + i4 + ", maskTid=" + i5 + ", scaleX=" + f8 + ", scaleY=" + f9 + '}', new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onMagicBackgroundMattingMaskImagePrepared(str, f2, f3, f4, f5, f6, f7, i2, i3, i4, i5, f8, f9);
        }
    }

    public static void onRetouchFinished() {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onRetouchFinished();
        }
    }

    public static void onRetouchStart() {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onRetouchStart();
        }
    }

    public static void onSpotRemoveEnd() {
        a.c("onSpotRemoveEnd", new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onSpotRemoveEnd();
        }
    }

    public static void onSpotRemoveStart() {
        a.c("onSpotRemoveStart", new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onSpotRemoveStart();
        }
    }

    public static String onUnityInitFilterPath() {
        a.c("onUnityInitFilterPath", new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        return unityEditCallbackApi != null ? unityEditCallbackApi.onUnityInitFilterPath() : "";
    }

    public static void onUnityRenderEnd() {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onUnityRenderEnd();
        }
    }

    public static void preCustomSpotDetected(int i2, int i3, int i4, float f2) {
        a.c("preCustomSpotDetected:" + i2 + "," + i3 + "," + i4 + "," + f2, new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.preCustomSpotDetected(i2, i3, i4, f2);
        }
    }

    public static void receiveBlurProtectedAreaInfos(boolean z, float f2, float f3, float f4, float f5, float f6) {
        a.c("receiveBlurProtectedAreaInfos  cx:" + f3 + "  cy:" + f4 + "  dx:" + f5 + " dy:" + f6, new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.receiveBlurProtectedAreaInfos(z, f2, f3, f4, f5, f6);
        }
    }

    public static void registerImpl(UnityEditCallbackApi unityEditCallbackApi) {
        mImpl = unityEditCallbackApi;
    }

    public static void repaintTransformObjectComplete(String str, float f2, float f3, float f4, float f5, float f6) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.repaintTransformObjectComplete(str, f2, f3, f4, f5, f6);
        }
    }

    public static void reportColorAfterSetBasicAdjustmentHSLValue(int i2, String str) {
        int i3 = 0;
        a.c("reportColorAfterSetBasicAdjustmentHSLValue:" + i2 + "," + str, new Object[0]);
        if (mImpl != null) {
            HSLAdjustColor hSLAdjustColor = HSLAdjustColor.None;
            HSLAdjustColor[] values = HSLAdjustColor.values();
            int length = values.length;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                HSLAdjustColor hSLAdjustColor2 = values[i3];
                if (hSLAdjustColor2.getColorType() == i2) {
                    hSLAdjustColor = hSLAdjustColor2;
                    break;
                }
                i3++;
            }
            mImpl.reportColorAfterHSLAdjust(hSLAdjustColor, Color.parseColor(str));
        }
    }

    public static void reportGestureTransformIfNeed(boolean z, boolean z2) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportGestureTransformIfNeed(z, z2);
        }
    }

    public static void reportMagicBackgroundBrushMaskStatus(float f2) {
        a.c("reportBrushMaskStatus", new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportMagicBackgroundBrushMaskStatus(f2);
        }
    }

    public static void reportMagnifierRenderer() {
        a.q("reportMagnifierRenderer", new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportMagnifierRenderer();
        }
    }

    public static void reportMagnifierTexture(int i2, int i3, int i4) {
        a.c("reportMagnifierTexture  tex:" + i2 + "  width:" + i3 + "  height:" + i4, new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportMagnifierTexture(i2, i3, i4);
        }
    }

    public static void reportManualDeformationProtectMaskStatus(boolean z) {
        a.c("reportManualDeformationProtectMaskStatus:" + z, new Object[0]);
    }

    public static void reportSelectTransformObjectInfo(String str, int i2, boolean z, float f2, float f3, float f4, float f5, float f6) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportSelectTransformObjectInfo(str, i2, z, f2, f3, f4, f5, f6);
        }
    }

    public static void reportUnityRecordedVIPStatus(String str) {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.onVipStatus(str);
        }
    }

    public static void reportUnityStepManagerForDetail(String str) {
        a.c("reportUnityStepManagerForDetail", new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportUnityStepManagerForDetail(str);
        }
    }

    public static void reportUnityStepManagerState(boolean z, boolean z2) {
        a.c("reportUnityStepManagerState  previousEnable:" + z + "   nextEnable:" + z2, new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.reportUnityStepManagerState(z, z2);
        }
    }

    public static int requestAutoBeautifyVersion() {
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            return unityEditCallbackApi.requestAutoBeautifyVersion();
        }
        return 1;
    }

    public static void unityEditComponentPrepared() {
        a.c("unityEditComponentPrepared", new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.unityEditComponentPrepared();
        }
    }

    public static void unityEditMainPrepared(int i2, int i3, int i4) {
        a.c("unityEditMainPrepared", new Object[0]);
        UnityEditCallbackApi unityEditCallbackApi = mImpl;
        if (unityEditCallbackApi != null) {
            unityEditCallbackApi.unityEditMainPrepared(i2, i3, i4);
        }
    }

    public static void unregister(UnityEditCallbackApi unityEditCallbackApi) {
        if (mImpl == unityEditCallbackApi) {
            a.c("unregister UnityCallbackApi", new Object[0]);
            mImpl = null;
        }
    }

    public String toString() {
        return "UnityEditCallback{}";
    }
}
