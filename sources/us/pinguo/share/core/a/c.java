package us.pinguo.share.core.a;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.exception.AppNotExistException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FacebookShareModel.java */
/* loaded from: classes6.dex */
public class c extends a {
    private void o(Platform.ShareParams shareParams, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (us.pinguo.share.d.b.b(str)) {
            shareParams.setImageUrl(str);
        } else {
            shareParams.setImagePath(us.pinguo.share.d.b.a(str));
        }
    }

    @Override // us.pinguo.share.core.a.d
    public void a(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (m(context)) {
            i(context, str, str2, str4, pGShareListener);
        } else if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new AppNotExistException("Facebook not installed, can not share local video"));
        }
    }

    @Override // us.pinguo.share.core.a.d
    public ShareSite b() {
        return ShareSite.FACEBOOK;
    }

    @Override // us.pinguo.share.core.a.d
    public void c(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2 + " " + str4);
        o(shareParams, str3);
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void d(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2 + " " + str4);
        o(shareParams, str3);
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void e(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2);
        shareParams.setImageUrl(str3);
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void f(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        if (m(context)) {
            i(context, str, str2, str3, pGShareListener);
            return;
        }
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2);
        shareParams.setImagePath(str3);
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void g(Context context, String str, String str2, PGShareListener pGShareListener) {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2);
        k(shareParams, pGShareListener, false);
    }
}
