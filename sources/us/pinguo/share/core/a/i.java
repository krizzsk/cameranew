package us.pinguo.share.core.a;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.exception.ContentNotSupportException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SinaWeiboShareModel.java */
/* loaded from: classes6.dex */
public class i extends a {
    @Override // us.pinguo.share.core.a.d
    public void a(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new ContentNotSupportException("Do not support share local video"));
        }
    }

    @Override // us.pinguo.share.core.a.d
    public ShareSite b() {
        return ShareSite.SINAWEIBO;
    }

    @Override // us.pinguo.share.core.a.d
    public void c(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(str2 + " " + str4);
        if (!TextUtils.isEmpty(str3)) {
            if (us.pinguo.share.d.b.b(str3)) {
                shareParams.setImageUrl(str3);
            } else {
                shareParams.setImagePath(us.pinguo.share.d.b.a(str3));
            }
        }
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void d(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(str2 + " " + str4);
        if (!TextUtils.isEmpty(str3)) {
            if (us.pinguo.share.d.b.b(str3)) {
                shareParams.setImageUrl(str3);
            } else {
                shareParams.setImagePath(us.pinguo.share.d.b.a(str3));
            }
        }
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
