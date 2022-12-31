package us.pinguo.share.core;
/* loaded from: classes6.dex */
public interface PGShareListener {
    void onShareCancel(ShareSite shareSite);

    void onShareComplete(ShareSite shareSite, boolean z);

    void onShareError(ShareSite shareSite, Throwable th);
}
