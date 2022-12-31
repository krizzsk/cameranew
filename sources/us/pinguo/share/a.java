package us.pinguo.share;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.facebook.f;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import us.pinguo.foundation.e;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
import us.pinguo.util.s;
/* compiled from: LocalFBShare.java */
/* loaded from: classes6.dex */
public class a {
    public static boolean a = false;
    private static ShareContent b;
    public static PGShareListener c;

    public a() {
        if (a) {
            return;
        }
        f.F(e.b());
        a = true;
    }

    private String a(String str) {
        if (str == null || str.startsWith("http") || str.startsWith("file")) {
            return str;
        }
        return InspirePublishFragment.FILE_HEADER + str;
    }

    public static ShareContent b() {
        return b;
    }

    private void f(Activity activity) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            Looper.prepare();
        }
        j0.c(R.string.not_install_app);
    }

    private void g(Activity activity) {
        activity.startActivity(new Intent(activity, FacebookShareActivity.class));
    }

    public void c(Activity activity, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        s sVar = s.a;
        if (!s.h("com.facebook.katana", activity)) {
            f(activity);
            if (pGShareListener != null) {
                pGShareListener.onShareError(ShareSite.FACEBOOK, new RuntimeException("facebook not installed"));
                return;
            }
            return;
        }
        ShareLinkContent.b bVar = new ShareLinkContent.b();
        bVar.h(Uri.parse(str));
        ShareLinkContent.b bVar2 = bVar;
        bVar2.s(str2);
        c = pGShareListener;
        b = bVar2.r();
        g(activity);
    }

    public void d(Activity activity, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        s sVar = s.a;
        if (!s.h("com.facebook.katana", activity)) {
            f(activity);
            if (pGShareListener != null) {
                pGShareListener.onShareError(ShareSite.FACEBOOK, new RuntimeException("facebook not installed"));
                return;
            }
            return;
        }
        String a2 = a(str);
        String a3 = a(str3);
        ShareVideo.b bVar = new ShareVideo.b();
        bVar.i(Uri.parse(a2));
        ShareVideo f2 = bVar.f();
        SharePhoto.b bVar2 = new SharePhoto.b();
        bVar2.q(a3 == null ? null : Uri.parse(a3));
        SharePhoto i2 = bVar2.i();
        ShareVideoContent.b bVar3 = new ShareVideoContent.b();
        bVar3.v(f2);
        bVar3.u(i2);
        bVar3.s(str4);
        bVar3.t(str2);
        b = bVar3.r();
        c = pGShareListener;
        g(activity);
    }

    public void e(Activity activity, String str, PGShareListener pGShareListener) {
        s sVar = s.a;
        if (!s.h("com.facebook.katana", activity)) {
            f(activity);
            if (pGShareListener != null) {
                pGShareListener.onShareError(ShareSite.FACEBOOK, new RuntimeException("facebook not installed"));
                return;
            }
            return;
        }
        String a2 = a(str);
        SharePhoto.b bVar = new SharePhoto.b();
        bVar.q(a2 == null ? null : Uri.parse(a2));
        SharePhoto i2 = bVar.i();
        SharePhotoContent.b bVar2 = new SharePhotoContent.b();
        bVar2.o(i2);
        b = bVar2.q();
        c = pGShareListener;
        g(activity);
    }
}
