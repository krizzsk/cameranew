package us.pinguo.share.c;

import us.pinguo.share.core.PGShareInfo;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.util.l;
import us.pinguo.share.util.p;
/* compiled from: ShopShareProcessor.java */
/* loaded from: classes6.dex */
public class f extends e<p> {
    public f(p pVar) {
        super(pVar);
    }

    public static l o(l lVar, p pVar) {
        PGShareInfo a = lVar.a();
        a.setTitle(pVar.a);
        a.setText(pVar.b);
        a.setThumbnailUri(pVar.c);
        a.setWebUrl(pVar.f11969d);
        ShareSite b = lVar.b();
        if (b == ShareSite.WECHAT_MOMENTS) {
            a.setTitle(pVar.b);
        }
        if (b != ShareSite.FACEBOOK && b != ShareSite.TWITTER) {
            if (b == ShareSite.INSTAGRAM) {
                a.setImageUri(pVar.c);
            } else if (b == ShareSite.SINAWEIBO) {
                a.setText(a.getTitle() + " | " + a.getText());
            }
        } else {
            a.setThumbnailUri(pVar.f11971f);
        }
        return lVar;
    }

    @Override // us.pinguo.share.c.e
    protected l a(l lVar) {
        o(lVar, (p) this.a);
        return lVar;
    }

    @Override // us.pinguo.share.c.e
    public boolean j(ShareSite shareSite) {
        return false;
    }
}
