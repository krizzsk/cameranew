package us.pinguo.inspire.util.z.a;

import android.view.View;
import java.util.Locale;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.share.core.PGShareInfo;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.util.ShareDataType;
import us.pinguo.share.util.l;
import us.pinguo.ui.uilview.PhotoImageView;
/* compiled from: WorkShareProcessor.java */
/* loaded from: classes9.dex */
public class d extends b<InspireWork> {
    public static final String c = Inspire.f11205f + "/challengeShare/index.html?locale=" + Locale.getDefault().getLanguage().toLowerCase().toString() + "&workId=";

    public d(InspireWork inspireWork) {
        super(inspireWork);
    }

    private l q(l lVar) {
        PGShareInfo a = lVar.a();
        s(a, lVar.b());
        a.setThumbnailUri(PhotoImageView.addQiNiuSuffix(((InspireWork) this.a).getWorkUrl(), 256, 256, false));
        a.setWebUrl(c + ((InspireWork) this.a).workId);
        return lVar;
    }

    private l r(l lVar) {
        PGShareInfo a = lVar.a();
        s(a, lVar.b());
        a.setThumbnailUri(PhotoImageView.addQiNiuSuffix(((InspireWork) this.a).getWorkUrl(), ((InspireWork) this.a).getWidth(), ((InspireWork) this.a).getHeight(), true));
        a.setWebUrl(c + ((InspireWork) this.a).workId);
        return lVar;
    }

    private void s(PGShareInfo pGShareInfo, ShareSite shareSite) {
        String nickName = ((InspireWork) this.a).getNickName();
        if (nickName == null) {
            nickName = "";
        }
        T t = this.a;
        String str = ((InspireWork) t).desc != null ? ((InspireWork) t).desc : "";
        String p = p(shareSite, nickName, str);
        pGShareInfo.setText(o(shareSite, p, str, null, null));
        pGShareInfo.setTitle(p);
    }

    @Override // us.pinguo.share.c.e
    protected l a(l lVar) {
        if (b() == ShareDataType.VIDEO) {
            r(lVar);
            return lVar;
        }
        q(lVar);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.share.c.e
    public ShareDataType b() {
        if (((InspireWork) this.a).isVideo()) {
            return ShareDataType.VIDEO;
        }
        if (((InspireWork) this.a).isMulityPhotos()) {
            return ShareDataType.MULTI_PHOTO;
        }
        return ShareDataType.SINGLE_PHOTO;
    }

    @Override // us.pinguo.share.c.e
    public boolean j(ShareSite shareSite) {
        return b() != ShareDataType.VIDEO;
    }

    @Deprecated
    public d(InspireWork inspireWork, View view) {
        super(inspireWork);
    }
}
