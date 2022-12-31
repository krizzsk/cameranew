package us.pinguo.pgshare.commons;

import java.util.HashMap;
import java.util.Map;
import us.pinguo.share.core.ShareSite;
/* compiled from: ShareDialogConfiguration.java */
/* loaded from: classes5.dex */
public class e {
    static Map<ShareSite, Integer> a = new HashMap();
    static Map<ShareSite, Integer> b = new HashMap();

    static {
        Map<ShareSite, Integer> map = a;
        ShareSite shareSite = ShareSite.FACEBOOK;
        map.put(shareSite, Integer.valueOf(R.drawable.facebook));
        Map<ShareSite, Integer> map2 = a;
        ShareSite shareSite2 = ShareSite.INSTAGRAM;
        map2.put(shareSite2, Integer.valueOf(R.drawable.instagram));
        Map<ShareSite, Integer> map3 = a;
        ShareSite shareSite3 = ShareSite.QQ;
        map3.put(shareSite3, Integer.valueOf(R.drawable.qq));
        Map<ShareSite, Integer> map4 = a;
        ShareSite shareSite4 = ShareSite.QZONE;
        map4.put(shareSite4, Integer.valueOf(R.drawable.qzone));
        Map<ShareSite, Integer> map5 = a;
        ShareSite shareSite5 = ShareSite.SINAWEIBO;
        map5.put(shareSite5, Integer.valueOf(R.drawable.sinaweibo));
        Map<ShareSite, Integer> map6 = a;
        ShareSite shareSite6 = ShareSite.TWITTER;
        map6.put(shareSite6, Integer.valueOf(R.drawable.twitter));
        Map<ShareSite, Integer> map7 = a;
        ShareSite shareSite7 = ShareSite.DOUYIN;
        map7.put(shareSite7, Integer.valueOf(R.drawable.douyin));
        Map<ShareSite, Integer> map8 = a;
        ShareSite shareSite8 = ShareSite.WECHAT_FRIENDS;
        map8.put(shareSite8, Integer.valueOf(R.drawable.wechat_friends));
        Map<ShareSite, Integer> map9 = a;
        ShareSite shareSite9 = ShareSite.WECHAT_MOMENTS;
        map9.put(shareSite9, Integer.valueOf(R.drawable.wechat_moments));
        b.put(shareSite, Integer.valueOf(R.string.facebook));
        b.put(shareSite2, Integer.valueOf(R.string.instagram));
        b.put(shareSite3, Integer.valueOf(R.string.qq));
        b.put(shareSite4, Integer.valueOf(R.string.qzone));
        b.put(shareSite5, Integer.valueOf(R.string.sinaweibo));
        b.put(shareSite6, Integer.valueOf(R.string.twitter));
        b.put(shareSite7, Integer.valueOf(R.string.douyin));
        b.put(shareSite8, Integer.valueOf(R.string.wechat_friends));
        b.put(shareSite9, Integer.valueOf(R.string.wechat_moments));
    }

    public static int a(ShareSite shareSite) {
        return a.get(shareSite).intValue();
    }

    public static int b(ShareSite shareSite) {
        return b.get(shareSite).intValue();
    }

    public static void c(ShareSite shareSite, int i2) {
        a.put(shareSite, Integer.valueOf(i2));
    }
}
