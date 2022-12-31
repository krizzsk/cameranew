package us.pinguo.advconfigdata.Interface;
/* loaded from: classes3.dex */
public interface AdvDownLoadLisenter {
    void onLoadFailed(String str, int i2, String str2);

    void onLoadProgress(String str, int i2);

    void onLoadSuccess(String str, String str2);
}
