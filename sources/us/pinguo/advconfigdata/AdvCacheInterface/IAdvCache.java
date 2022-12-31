package us.pinguo.advconfigdata.AdvCacheInterface;

import us.pinguo.advconfigdata.Interface.AdvDownLoadLisenter;
/* loaded from: classes3.dex */
public abstract class IAdvCache<T> {
    public abstract boolean checkResExsited(T t);

    public abstract void downLoadImage(String str, AdvDownLoadLisenter advDownLoadLisenter);

    public abstract T getAdAsync();

    public abstract T getLastAd();

    public abstract String getLocalPath(String str);

    public abstract void loadAd(IAdvCallback iAdvCallback);

    public abstract void preLoadAd();

    public abstract void releaseAll();

    public abstract void setFeedsCallback(IFeedsAdvCallback iFeedsAdvCallback);
}
