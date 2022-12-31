package us.pinguo.share.util;

import us.pinguo.foundation.utils.j0;
import us.pinguo.share.R;
import us.pinguo.share.core.ShareSite;
/* compiled from: ShareAppCheck.java */
/* loaded from: classes6.dex */
public class j {

    /* compiled from: ShareAppCheck.java */
    /* loaded from: classes6.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ShareSite.values().length];
            a = iArr;
            try {
                iArr[ShareSite.SINAWEIBO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ShareSite.WECHAT_FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ShareSite.WECHAT_MOMENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ShareSite.DOUYIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ShareSite.QQ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ShareSite.QZONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ShareSite.FACEBOOK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ShareSite.TWITTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ShareSite.INSTAGRAM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static boolean a(ShareSite shareSite) {
        boolean b = us.pinguo.share.d.a.b(us.pinguo.foundation.e.b(), shareSite);
        if (b) {
            return b;
        }
        switch (a.a[shareSite.ordinal()]) {
            case 1:
                j0.c(R.string.share_weibo_not_installed);
                return b;
            case 2:
            case 3:
                j0.c(R.string.share_wechat_not_installed);
                return b;
            case 4:
                j0.c(R.string.share_douyin_not_installed);
                return b;
            case 5:
                return true;
            case 6:
                j0.c(R.string.share_qzone_not_installed);
                return b;
            case 7:
                j0.c(R.string.share_facebook_not_installed);
                return b;
            case 8:
                j0.c(R.string.share_twitter_not_installed);
                return b;
            case 9:
                j0.c(R.string.share_ins_not_installed);
                return b;
            default:
                return b;
        }
    }
}
