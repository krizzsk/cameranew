package us.pinguo.share.core;

import android.content.Context;
/* loaded from: classes6.dex */
public interface IPGShareManager {
    void intentShare(Context context, String str, String str2, PGShareInfo pGShareInfo, PGShareListener pGShareListener);

    void siteShare(Context context, ShareSite shareSite, PGShareInfo pGShareInfo, PGShareListener pGShareListener);
}
