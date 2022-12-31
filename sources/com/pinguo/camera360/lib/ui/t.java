package com.pinguo.camera360.lib.ui;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.k.b.a;
import com.pinguo.lib.download.Config;
import com.pinguo.lib.download.listener.DownloadListenerAdapter;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.share.core.ShareSite;
import vStudio.Android.Camera360.R;
/* compiled from: WebCustomUtils.java */
/* loaded from: classes3.dex */
public class t {

    /* compiled from: WebCustomUtils.java */
    /* loaded from: classes3.dex */
    class a extends DownloadListenerAdapter {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.pinguo.lib.download.listener.DownloadListenerAdapter, com.pinguo.lib.download.listener.DownloadListener
        public void onComplete(Config config) {
            a.C0243a.f(config.getDownloadUrl());
            a.C0243a.c(this.a);
        }
    }

    /* compiled from: WebCustomUtils.java */
    /* loaded from: classes3.dex */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ShareSite.values().length];
            a = iArr;
            try {
                iArr[ShareSite.WECHAT_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ShareSite.WECHAT_MOMENTS.ordinal()] = 2;
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
                a[ShareSite.FACEBOOK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ShareSite.TWITTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ShareSite.SINAWEIBO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        if (com.pinguo.camera360.app.download.b.d().g(str, null)) {
            com.pinguo.camera360.app.download.b.h(context, new Config.Builder(str).setFileSuffix(".apk").setMd5(null).build().getSavePath());
        } else if (us.pinguo.util.q.f(BaseApplication.d())) {
            com.pinguo.camera360.app.download.a aVar = new com.pinguo.camera360.app.download.a();
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            if (lastPathSegment.contains(".apk")) {
                lastPathSegment = lastPathSegment.substring(0, lastPathSegment.lastIndexOf("."));
            }
            a.C0243a.e(str);
            aVar.a(lastPathSegment, str, new a(lastPathSegment));
            Toast makeText = Toast.makeText(context, context.getResources().getString(R.string.web_download_noti, lastPathSegment), 0);
            makeText.show();
            VdsAgent.showToast(makeText);
        } else {
            Toast makeText2 = Toast.makeText(context, (int) R.string.web_download_net_error, 1);
            makeText2.show();
            VdsAgent.showToast(makeText2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        return us.pinguo.webview.b.f("IMG_" + System.currentTimeMillis() + ".jpg");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(ShareSite shareSite) {
        switch (b.a[shareSite.ordinal()]) {
            case 1:
                return ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE;
            case 2:
                return "wechatMoments";
            case 3:
                return "qq";
            case 4:
                return "qqzone";
            case 5:
                return "facebook";
            case 6:
                return FindFriendHeaderCell.TWITTER;
            case 7:
                return "weibo";
            default:
                return null;
        }
    }
}
