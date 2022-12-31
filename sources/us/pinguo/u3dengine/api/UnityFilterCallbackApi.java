package us.pinguo.u3dengine.api;
/* compiled from: UnityFilterCallbackApi.kt */
/* loaded from: classes6.dex */
public interface UnityFilterCallbackApi {
    long getBlingBlingRenderResult();

    int getNativeFilterResult();

    void preNativeFilterResult(int i2, int i3, int i4);

    void receiveBlingBlingTextureInfo(int i2, int i3, int i4, int i5);

    void reportSkyChangeRenderComplete(String str, float f2, float f3, float f4, float f5);

    void reportSkyChangeTransformPrepare(String str, float f2, float f3, float f4, float f5);
}
