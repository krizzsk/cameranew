package us.pinguo.share.core.a;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.exception.AppNotExistException;
import us.pinguo.share.exception.ContentNotSupportException;
/* compiled from: WechatShareModel.java */
/* loaded from: classes6.dex */
class l extends a {
    @Override // us.pinguo.share.core.a.d
    public void a(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new ContentNotSupportException("Do not support share local video"));
        }
    }

    @Override // us.pinguo.share.core.a.d
    public ShareSite b() {
        return ShareSite.WECHAT_FRIENDS;
    }

    @Override // us.pinguo.share.core.a.d
    public void c(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (!m(context)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(b(), new AppNotExistException("App not exist!"));
                return;
            }
            return;
        }
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2);
        shareParams.setUrl(str4);
        if (!TextUtils.isEmpty(str3)) {
            if (us.pinguo.share.d.b.b(str3)) {
                shareParams.setImageUrl(str3);
            } else {
                shareParams.setImagePath(str3);
            }
        }
        shareParams.setShareType(4);
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void d(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (!m(context)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(b(), new AppNotExistException("App not exist!"));
                return;
            }
            return;
        }
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2);
        shareParams.setUrl(str4);
        if (!TextUtils.isEmpty(str3)) {
            if (us.pinguo.share.d.b.b(str3)) {
                shareParams.setImageUrl(str3);
            } else {
                shareParams.setImagePath(str3);
            }
        }
        shareParams.setShareType(6);
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void e(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        if (!m(context)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(b(), new AppNotExistException("App not exist!"));
                return;
            }
            return;
        }
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2);
        shareParams.setImageUrl(str3);
        shareParams.setShareType(2);
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void f(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        if (!m(context)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(b(), new AppNotExistException("App not exist!"));
                return;
            }
            return;
        }
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2);
        shareParams.setImagePath(str3);
        shareParams.setShareType(2);
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void g(Context context, String str, String str2, PGShareListener pGShareListener) {
        if (!m(context)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(b(), new AppNotExistException("App not exist!"));
                return;
            }
            return;
        }
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setText(str2);
        shareParams.setShareType(1);
        k(shareParams, pGShareListener, false);
    }
}
