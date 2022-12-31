package cn.sharesdk.framework.loopshare;
/* loaded from: classes.dex */
public interface LoopSharePasswordListener<T> {
    void onError(Throwable th);

    void onResult(T t);
}
