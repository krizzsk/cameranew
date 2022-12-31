package us.pinguo.share.core.a;

import android.app.Activity;
import android.content.Context;
import cn.sharesdk.framework.Platform;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.exception.AppNotExistException;
import us.pinguo.share.exception.ContentNotSupportException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DouyinShareModel.java */
/* loaded from: classes6.dex */
public class b extends a {
    @Override // us.pinguo.share.core.a.d
    public void a(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
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
        shareParams.setVideoPathArray(new String[]{str4});
        shareParams.setShareType(6);
        if (context instanceof Activity) {
            shareParams.setActivity((Activity) context);
        }
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public ShareSite b() {
        return ShareSite.DOUYIN;
    }

    @Override // us.pinguo.share.core.a.d
    public void c(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new ContentNotSupportException("Do not support share webpage"));
        }
    }

    @Override // us.pinguo.share.core.a.d
    public void d(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new ContentNotSupportException("Do not support share web video"));
        }
    }

    @Override // us.pinguo.share.core.a.d
    public void e(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new ContentNotSupportException("Do not support share web image"));
        }
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
        shareParams.setImageArray(new String[]{l(context, str3)});
        shareParams.setShareType(2);
        if (context instanceof Activity) {
            shareParams.setActivity((Activity) context);
        }
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void g(Context context, String str, String str2, PGShareListener pGShareListener) {
        if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new ContentNotSupportException("Do not support share text"));
        }
    }
}
