package us.pinguo.advconfigdata.AdvCacheInterface;
/* loaded from: classes3.dex */
public interface IAdvCallback<T> {
    void onAdClick(T t);

    void onLoadError(String str);

    void onLoadSuccess(T t, int i2);
}
