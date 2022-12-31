package us.pinguo.u3dengine.api;

import kotlin.jvm.internal.s;
import kotlin.text.t;
import us.pinguo.common.log.a;
/* compiled from: UnityCallbackAdapter.kt */
/* loaded from: classes6.dex */
public class UnityCallbackAdapter implements UnityCallbackApi, UnityFilterCallbackApi {
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
        r1 = kotlin.text.StringsKt__StringsKt.O((java.lang.CharSequence) r0.element, ':', 0, false, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010c, code lost:
        r0 = android.os.Build.HARDWARE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x010e, code lost:
        r2.close();
     */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String getCpuHardware() {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.u3dengine.api.UnityCallbackAdapter.getCpuHardware():java.lang.String");
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public boolean changeFilter(String filterPath) {
        s.h(filterPath, "filterPath");
        a.c(s.q("changeFilter, filterPath:", filterPath), new Object[0]);
        return true;
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public boolean changeMakeUp(String makeupPath) {
        s.h(makeupPath, "makeupPath");
        a.c(s.q("changeMakeUp, makeupPath:", makeupPath), new Object[0]);
        return true;
    }

    public long getBlingBlingRenderResult() {
        return -1L;
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public HDCameraSessionResult getCameraSessionResult() {
        return new HDCameraSessionResult();
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public HDCameraSessionResult getCaptureSessionResult() {
        return new HDCameraSessionResult();
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public DefaultBaseConfig getDefaultConfig() {
        boolean o;
        DefaultBaseConfig defaultBaseConfig = new DefaultBaseConfig();
        String cpuHardware = getCpuHardware();
        o = t.o(cpuHardware, "MT6580", false, 2, null);
        if (o) {
            a.c("cpu:" + ((Object) cpuHardware) + ", not support face deformation mask", new Object[0]);
            defaultBaseConfig.setIsSupportFaceDeformationMask(0);
        }
        return defaultBaseConfig;
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public FilterInfo getFilterInfo() {
        return new FilterInfo();
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public int getImageSaveQuality() {
        return 98;
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public NativeFacesData getNativeFaceData() {
        return new NativeFacesData();
    }

    public int getNativeFilterResult() {
        return -1;
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public int getSubSticker() {
        a.c("getSubSticker", new Object[0]);
        return 0;
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi, us.pinguo.nativeinterface.UnityInterface.c
    public void glCleanUp() {
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi, us.pinguo.nativeinterface.UnityInterface.c
    public void glRenderBeforeGetCameraSession() {
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi, us.pinguo.nativeinterface.UnityInterface.c
    public void glRenderBeforeGetCaptureSession() {
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void glRenderBlingBlingFilter() {
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi, us.pinguo.nativeinterface.UnityInterface.c
    public void glRenderNativeFilter() {
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void onBundleLoadStatusChanged(BundleLoadStatus status, String path) {
        s.h(status, "status");
        s.h(path, "path");
        a.c("onBundleLoadStatusChanged, status:" + status + ", path:" + path, new Object[0]);
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void onCaptureEnd(HDCameraSessionResult result) {
        s.h(result, "result");
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void onCaptureStart() {
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void onImageSaved(String savedImage, CaptureModel captureModel) {
        s.h(savedImage, "savedImage");
        s.h(captureModel, "captureModel");
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void onRenderImageEnd(CaptureModel captureModel) {
        s.h(captureModel, "captureModel");
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void onSubStickerSelect(int i2) {
        a.c(s.q("onSubStickerSelect, subIndex:", Integer.valueOf(i2)), new Object[0]);
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void onUnityRenderEnd() {
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void onUnityRenderStart() {
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void onVideoRecordPrepared(int i2) {
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void preCameraSessionResult() {
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void preCaptureSessionResult() {
    }

    public void preNativeFilterResult(int i2, int i3, int i4) {
    }

    public void receiveBlingBlingTextureInfo(int i2, int i3, int i4, int i5) {
    }

    public void reportSkyChangeRenderComplete(String uid, float f2, float f3, float f4, float f5) {
        s.h(uid, "uid");
    }

    public void reportSkyChangeTransformPrepare(String uid, float f2, float f3, float f4, float f5) {
        s.h(uid, "uid");
    }

    @Override // us.pinguo.u3dengine.api.UnityCallbackApi
    public void setCurrentUnityVersion(int i2, String versionCode) {
        s.h(versionCode, "versionCode");
        a.c("setCurrentUnityVersion, version:" + i2 + ", versionCode" + versionCode, new Object[0]);
    }
}
