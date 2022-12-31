package us.pinguo.u3dengine.edit;

import androidx.annotation.ColorInt;
import us.pinguo.u3dengine.api.NativeFacesData;
/* compiled from: UnityEditCallbackApi.kt */
/* loaded from: classes6.dex */
public interface UnityEditCallbackApi {
    NativeFacesData editUpdateFaceData(int i2, int i3, int i4);

    int getCustomSpotDetected();

    boolean getFilterAdjustIs64Level();

    String getGLExtensions();

    void onCanvasTransformChanged(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10);

    void onClipViewChanged(float f2, float f3, float f4, float f5);

    void onEditCurrentTextureUpdate(int i2, int i3, int i4);

    void onEditImagedSavedSuccess(String str, boolean z);

    void onEditMakeupInitRenderComplete();

    void onMagicBackgroundItemStatusChanged(String str, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3);

    void onMagicBackgroundMattingMaskImagePrepared(String str, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3, int i4, int i5, float f8, float f9);

    void onRetouchFinished();

    void onRetouchStart();

    void onSpotRemoveEnd();

    void onSpotRemoveStart();

    void onStaticStickerStatusChanged(String str, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3);

    String onUnityInitFilterPath();

    void onUnityRenderEnd();

    void onVipStatus(String str);

    void preCustomSpotDetected(int i2, int i3, int i4, float f2);

    void receiveBlurProtectedAreaInfos(boolean z, float f2, float f3, float f4, float f5, float f6);

    void repaintTransformObjectComplete(String str, float f2, float f3, float f4, float f5, float f6);

    void reportBodyBeatifyEffectStatus(boolean z);

    void reportBodyBeautifyToolUpdated(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z);

    void reportBokehGeneratedIconTexture(int i2, int i3, int i4);

    void reportBokehGeneratedPreviewMaskTexture(int i2, int i3, int i4);

    void reportBokehShapePreviewTexture(int i2, int i3, int i4);

    void reportColorAfterHSLAdjust(HSLAdjustColor hSLAdjustColor, @ColorInt int i2);

    void reportCurrentFilterTexture(int i2, int i3, int i4);

    void reportGestureTransformIfNeed(boolean z, boolean z2);

    void reportMagicBackgroundBrushMaskStatus(float f2);

    void reportMagnifierRenderer();

    void reportMagnifierTexture(int i2, int i3, int i4);

    void reportSelectTransformObjectInfo(String str, int i2, boolean z, float f2, float f3, float f4, float f5, float f6);

    void reportStaticStickerLayerStatus(String str, boolean z, boolean z2);

    void reportUnityStepManagerForDetail(String str);

    void reportUnityStepManagerState(boolean z, boolean z2);

    int requestAutoBeautifyVersion();

    void unityEditComponentPrepared();

    void unityEditMainPrepared(int i2, int i3, int i4);
}
