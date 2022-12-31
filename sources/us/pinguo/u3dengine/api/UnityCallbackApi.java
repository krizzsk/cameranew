package us.pinguo.u3dengine.api;

import us.pinguo.nativeinterface.UnityInterface;
/* compiled from: UnityCallbackApi.kt */
/* loaded from: classes6.dex */
public interface UnityCallbackApi extends UnityInterface.c {
    boolean changeFilter(String str);

    boolean changeMakeUp(String str);

    HDCameraSessionResult getCameraSessionResult();

    HDCameraSessionResult getCaptureSessionResult();

    DefaultBaseConfig getDefaultConfig();

    FilterInfo getFilterInfo();

    int getImageSaveQuality();

    NativeFacesData getNativeFaceData();

    int getSubSticker();

    @Override // us.pinguo.nativeinterface.UnityInterface.c
    /* synthetic */ void glCleanUp();

    @Override // us.pinguo.nativeinterface.UnityInterface.c
    /* synthetic */ void glRenderBeforeGetCameraSession();

    @Override // us.pinguo.nativeinterface.UnityInterface.c
    /* synthetic */ void glRenderBeforeGetCaptureSession();

    /* synthetic */ void glRenderBlingBlingFilter();

    @Override // us.pinguo.nativeinterface.UnityInterface.c
    /* synthetic */ void glRenderNativeFilter();

    void onBundleLoadStatusChanged(BundleLoadStatus bundleLoadStatus, String str);

    void onCaptureEnd(HDCameraSessionResult hDCameraSessionResult);

    void onCaptureStart();

    void onImageSaved(String str, CaptureModel captureModel);

    void onRenderImageEnd(CaptureModel captureModel);

    void onSubStickerSelect(int i2);

    void onUnityRenderEnd();

    void onUnityRenderStart();

    void onVideoRecordPrepared(int i2);

    void preCameraSessionResult();

    void preCaptureSessionResult();

    void setCurrentUnityVersion(int i2, String str);
}
