package us.pinguo.inspire.adv.third;

import us.pinguo.inspire.adv.third.AbsAdData;
/* loaded from: classes9.dex */
public interface IAdCallback<T extends AbsAdData> {
    void onAdClick(T t);

    void onLoadError(Throwable th);

    void onLoadSuccess(T t);
}
