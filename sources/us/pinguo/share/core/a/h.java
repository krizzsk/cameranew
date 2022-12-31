package us.pinguo.share.core.a;

import cn.sharesdk.douyin.Douyin;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.instagram.Instagram;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import us.pinguo.share.core.ShareSite;
/* compiled from: ShareModelFactory.java */
/* loaded from: classes6.dex */
public class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareModelFactory.java */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ShareSite.values().length];
            a = iArr;
            try {
                iArr[ShareSite.FACEBOOK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ShareSite.INSTAGRAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ShareSite.QQ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ShareSite.QZONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ShareSite.SINAWEIBO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ShareSite.TWITTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ShareSite.WECHAT_FRIENDS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ShareSite.WECHAT_MOMENTS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ShareSite.DOUYIN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static Platform a(ShareSite shareSite) {
        return ShareSDK.getPlatform(b(shareSite));
    }

    public static String b(ShareSite shareSite) {
        switch (a.a[shareSite.ordinal()]) {
            case 1:
                return "FaceBook";
            case 2:
                return Instagram.NAME;
            case 3:
                return QQ.NAME;
            case 4:
                return QZone.NAME;
            case 5:
                return SinaWeibo.NAME;
            case 6:
                return Twitter.NAME;
            case 7:
                return Wechat.NAME;
            case 8:
                return WechatMoments.NAME;
            case 9:
                return Douyin.NAME;
            default:
                return null;
        }
    }

    public static d c(ShareSite shareSite) {
        switch (a.a[shareSite.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new e();
            case 3:
                return new f();
            case 4:
                return new g();
            case 5:
                return new i();
            case 6:
                return new j();
            case 7:
                return new l();
            case 8:
                return new k();
            case 9:
                return new b();
            default:
                return null;
        }
    }
}
