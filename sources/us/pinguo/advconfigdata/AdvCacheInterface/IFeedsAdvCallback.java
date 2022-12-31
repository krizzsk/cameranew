package us.pinguo.advconfigdata.AdvCacheInterface;
/* loaded from: classes3.dex */
public interface IFeedsAdvCallback<T> {
    void onClickMob(T t);

    void onLoadMobFailed();

    void onLoadMobSuccess();
}
