package us.pinguo.share.util;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.utils.u;
import us.pinguo.share.core.ShareSite;
/* compiled from: ShareDialogOptionsFactory.java */
/* loaded from: classes6.dex */
public class k {
    public static List<ExpandShareSite> a(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (u.a()) {
            arrayList.add(ShareSite.WECHAT_FRIENDS);
            arrayList.add(ShareSite.WECHAT_MOMENTS);
            if (!us.pinguo.foundation.utils.i.c() && z) {
                arrayList.add(ShareSite.DOUYIN);
            }
            arrayList.add(ShareSite.SINAWEIBO);
            arrayList.add(ShareSite.QZONE);
            arrayList.add(ShareSite.QQ);
            arrayList.add(ShareSite.FACEBOOK);
            arrayList.add(ShareSite.INSTAGRAM);
            arrayList.add(ShareSite.TWITTER);
        } else {
            arrayList.add(ShareSite.FACEBOOK);
            arrayList.add(ShareSite.INSTAGRAM);
            arrayList.add(ShareSite.TWITTER);
            arrayList.add(ShareSite.WECHAT_FRIENDS);
            arrayList.add(ShareSite.WECHAT_MOMENTS);
            arrayList.add(ShareSite.SINAWEIBO);
            arrayList.add(ShareSite.QZONE);
            arrayList.add(ShareSite.QQ);
        }
        return f(arrayList);
    }

    public static List<ExpandShareSite> b(us.pinguo.pgshare.commons.f fVar) {
        ArrayList<ShareSite> arrayList = new ArrayList(fVar.d());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (ShareSite shareSite : arrayList) {
            arrayList2.add(new ExpandShareSite(shareSite));
        }
        return arrayList2;
    }

    public static List<ExpandShareSite> c(Bundle bundle) {
        if (bundle == null) {
            return new ArrayList();
        }
        return bundle.getParcelableArrayList("shareSites");
    }

    public static List<ExpandShareSite> d(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (u.a()) {
            arrayList.add(ShareSite.WECHAT_FRIENDS);
            arrayList.add(ShareSite.WECHAT_MOMENTS);
            if (!us.pinguo.foundation.utils.i.c() && z) {
                arrayList.add(ShareSite.DOUYIN);
            }
            arrayList.add(ShareSite.SINAWEIBO);
            arrayList.add(ShareSite.QZONE);
            arrayList.add(ShareSite.QQ);
            arrayList.add(ShareSite.FACEBOOK);
            arrayList.add(ShareSite.TWITTER);
        } else {
            arrayList.add(ShareSite.FACEBOOK);
            arrayList.add(ShareSite.TWITTER);
            arrayList.add(ShareSite.WECHAT_FRIENDS);
            arrayList.add(ShareSite.WECHAT_MOMENTS);
            arrayList.add(ShareSite.SINAWEIBO);
            arrayList.add(ShareSite.QZONE);
            arrayList.add(ShareSite.QQ);
        }
        return f(arrayList);
    }

    public static void e(Bundle bundle, List<ExpandShareSite> list) {
        if (bundle == null || list == null) {
            return;
        }
        bundle.putParcelableArrayList("shareSites", new ArrayList<>(list));
    }

    public static List<ExpandShareSite> f(List<ShareSite> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (ShareSite shareSite : list) {
            arrayList.add(new ExpandShareSite(shareSite));
        }
        return arrayList;
    }
}
