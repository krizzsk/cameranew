package us.pinguo.share.core.a;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import us.pinguo.share.core.PGShareConfiguration;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QQShareModel.java */
/* loaded from: classes6.dex */
public class f extends a {
    private void o(Platform.ShareParams shareParams) {
        if (TextUtils.isEmpty(shareParams.getTitle())) {
            shareParams.setTitle(PGShareConfiguration.getSite());
        }
        if (TextUtils.isEmpty(shareParams.getTitleUrl())) {
            shareParams.setTitleUrl(PGShareConfiguration.getSiteUrl());
        }
        if (TextUtils.isEmpty(shareParams.getText())) {
            shareParams.setText(PGShareConfiguration.getSite());
        }
    }

    @Override // us.pinguo.share.core.a.d
    public void a(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
    }

    @Override // us.pinguo.share.core.a.d
    public ShareSite b() {
        return ShareSite.QQ;
    }

    @Override // us.pinguo.share.core.a.d
    public void c(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setTitleUrl(str4);
        shareParams.setText(str2);
        if (!TextUtils.isEmpty(str3)) {
            if (us.pinguo.share.d.b.b(str3)) {
                shareParams.setImageUrl(str3);
            } else {
                shareParams.setImagePath(us.pinguo.share.d.b.a(str3));
            }
        }
        o(shareParams);
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void d(Context context, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(str);
        shareParams.setTitleUrl(str4);
        shareParams.setText(str2);
        if (!TextUtils.isEmpty(str3)) {
            if (us.pinguo.share.d.b.b(str3)) {
                shareParams.setImageUrl(str3);
            } else {
                shareParams.setImagePath(us.pinguo.share.d.b.a(str3));
            }
        }
        o(shareParams);
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void e(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImageUrl(str3);
        if (!m(context)) {
            o(shareParams);
        }
        k(shareParams, pGShareListener, false);
    }

    @Override // us.pinguo.share.core.a.d
    public void f(Context context, String str, String str2, String str3, PGShareListener pGShareListener) {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImagePath(str3);
        if (!m(context)) {
            o(shareParams);
        }
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
