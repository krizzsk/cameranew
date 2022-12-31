package us.pinguo.share.core.a;

import android.content.Context;
import android.text.TextUtils;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.exception.AppNotExistException;
import us.pinguo.share.exception.ContentNotSupportException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TwitterShareModel.java */
/* loaded from: classes6.dex */
public class j extends a {
    @Override // us.pinguo.share.core.a.d
    public void a(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new ContentNotSupportException("Do not support share local video"));
        }
    }

    @Override // us.pinguo.share.core.a.d
    public ShareSite b() {
        return ShareSite.TWITTER;
    }

    @Override // us.pinguo.share.core.a.d
    public void c(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (!m(context)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(b(), new AppNotExistException("App not installed"));
                return;
            }
            return;
        }
        String str5 = null;
        if (!TextUtils.isEmpty(str3) && !us.pinguo.share.d.b.b(str3)) {
            str5 = us.pinguo.share.d.b.a(str3);
        }
        h(context, "", str, str2 + " " + str4, str5, pGShareListener);
    }

    @Override // us.pinguo.share.core.a.d
    public void d(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        if (!m(context)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(b(), new AppNotExistException("App not installed"));
                return;
            }
            return;
        }
        String str5 = null;
        if (!TextUtils.isEmpty(str3) && !us.pinguo.share.d.b.b(str3)) {
            str5 = us.pinguo.share.d.b.a(str3);
        }
        h(context, "", str, str2 + " " + str4, str5, pGShareListener);
    }

    @Override // us.pinguo.share.core.a.d
    public void e(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        if (!m(context)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(b(), new AppNotExistException("App not installed"));
                return;
            }
            return;
        }
        h(context, "", str, str2 + " " + str3, null, pGShareListener);
    }

    @Override // us.pinguo.share.core.a.d
    public void f(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        if (m(context)) {
            h(context, "", str, str2, str3, pGShareListener);
        } else if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new AppNotExistException("App not installed"));
        }
    }

    @Override // us.pinguo.share.core.a.d
    public void g(Context context, String str, String str2, PGShareListener pGShareListener) {
        if (m(context)) {
            h(context, "", str, str2, null, pGShareListener);
        } else if (pGShareListener != null) {
            pGShareListener.onShareError(b(), new AppNotExistException("App not installed"));
        }
    }
}
