package us.pinguo.u3dengine.api;

import us.pinguo.common.log.a;
/* loaded from: classes6.dex */
public class UnityFilterMethodCallback {
    private static UnityFilterCallbackApi mImpl;

    public static long GetBlingBlingRenderResult() {
        a.q("GetBlingBlingRenderResult", new Object[0]);
        UnityFilterCallbackApi unityFilterCallbackApi = mImpl;
        if (unityFilterCallbackApi != null) {
            return unityFilterCallbackApi.getBlingBlingRenderResult();
        }
        return 0L;
    }

    public static int GetNativeFilterResult() {
        a.q("GetNativeFilterResult", new Object[0]);
        UnityFilterCallbackApi unityFilterCallbackApi = mImpl;
        if (unityFilterCallbackApi != null) {
            return unityFilterCallbackApi.getNativeFilterResult();
        }
        return -1;
    }

    public static void PreGetNativeFilterResult(int i2, int i3, int i4) {
        a.q("PreGetNativeFilterResult, org=" + i2 + ", width=" + i3 + ", height=" + i4, new Object[0]);
        UnityFilterCallbackApi unityFilterCallbackApi = mImpl;
        if (unityFilterCallbackApi != null) {
            unityFilterCallbackApi.preNativeFilterResult(i2, i3, i4);
        }
    }

    public static void ReceiveBlingBlingTextureInfo(int i2, int i3, int i4, int i5) {
        a.q("ReceiveBlingBlingTextureInfo, org=" + i2 + ", width=" + i3 + ", height=" + i4, new Object[0]);
        UnityFilterCallbackApi unityFilterCallbackApi = mImpl;
        if (unityFilterCallbackApi != null) {
            unityFilterCallbackApi.receiveBlingBlingTextureInfo(i2, i3, i4, i5);
        }
    }

    public static void registerImpl(UnityFilterCallbackApi unityFilterCallbackApi) {
        mImpl = unityFilterCallbackApi;
    }

    public static void reportSkyChangeRenderComplete(String str, float f2, float f3, float f4, float f5) {
        UnityFilterCallbackApi unityFilterCallbackApi = mImpl;
        if (unityFilterCallbackApi != null) {
            unityFilterCallbackApi.reportSkyChangeRenderComplete(str, f2, f3, f4, f5);
        }
    }

    public static void reportSkyChangeTransformPrepare(String str, float f2, float f3, float f4, float f5) {
        UnityFilterCallbackApi unityFilterCallbackApi = mImpl;
        if (unityFilterCallbackApi != null) {
            unityFilterCallbackApi.reportSkyChangeTransformPrepare(str, f2, f3, f4, f5);
        }
    }

    public static void unregister(UnityFilterCallbackApi unityFilterCallbackApi) {
        if (mImpl == unityFilterCallbackApi) {
            a.c("unregister UnityFilterCallbackApi", new Object[0]);
            mImpl = null;
        }
    }
}
