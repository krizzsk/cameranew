package cn.sharesdk.framework.loopshare.watermark;
/* loaded from: classes.dex */
public interface WaterMarkListener {
    void onCancel();

    void onEnd(int i2);

    void onFailed(String str, int i2);

    void onProgress(int i2);

    void onStart();
}
