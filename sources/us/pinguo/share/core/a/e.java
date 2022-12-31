package us.pinguo.share.core.a;

import android.content.Context;
import cn.sharesdk.framework.Platform;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.exception.AppNotExistException;
import us.pinguo.share.exception.ContentNotSupportException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InstagramShareModel.java */
/* loaded from: classes6.dex */
public class e extends a {
    @Override // us.pinguo.share.core.a.d
    public void a(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (!m(context)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(b(), new AppNotExistException("Instagram not installed"));
                return;
            }
            return;
        }
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2);
        shareParams.setImagePath(str4);
        k(shareParams, pGShareListener, true);
    }

    @Override // us.pinguo.share.core.a.d
    public ShareSite b() {
        return ShareSite.INSTAGRAM;
    }

    @Override // us.pinguo.share.core.a.d
    public void c(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new ContentNotSupportException("Instagram can not share web page"));
        }
    }

    @Override // us.pinguo.share.core.a.d
    public void d(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new ContentNotSupportException("Instagram can not share web video"));
        }
    }

    @Override // us.pinguo.share.core.a.d
    public void e(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        if (!m(context)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(b(), new AppNotExistException("Instagram not installed"));
                return;
            }
            return;
        }
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2);
        shareParams.setImageUrl(str3);
        k(shareParams, pGShareListener, true);
    }

    @Override // us.pinguo.share.core.a.d
    public void f(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        if (!m(context)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(b(), new AppNotExistException("Instagram not installed"));
                return;
            }
            return;
        }
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2);
        shareParams.setImagePath(str3);
        k(shareParams, pGShareListener, true);
    }

    @Override // us.pinguo.share.core.a.d
    public void g(Context context, String str, String str2, PGShareListener pGShareListener) {
        if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new ContentNotSupportException("Instagram can not share pure text"));
        }
    }
}
