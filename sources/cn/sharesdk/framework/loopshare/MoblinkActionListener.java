package cn.sharesdk.framework.loopshare;
/* loaded from: classes.dex */
public interface MoblinkActionListener<T> {
    void onError(Throwable th);

    void onResult(T t);
}
