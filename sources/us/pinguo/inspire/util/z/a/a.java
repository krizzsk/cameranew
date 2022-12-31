package us.pinguo.inspire.util.z.a;

import com.nostra13.universalimageloader.core.ImageLoader;
import java.lang.ref.WeakReference;
import java.util.Locale;
import us.pinguo.foundation.utils.k;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.discovery.entity.InspireFeedVideo;
import us.pinguo.inspire.module.feeds.view.FeedsPhotoCommentView;
import us.pinguo.share.core.PGShareInfo;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.util.ShareDataType;
import us.pinguo.share.util.l;
import us.pinguo.ui.uilview.PhotoImageView;
/* compiled from: FeedShareProcessor.java */
/* loaded from: classes9.dex */
public class a extends b<InspireFeed> {
    public static final String c = Inspire.f11205f + "/challengeShare/index.html?locale=" + Locale.getDefault().getLanguage().toLowerCase().toString() + "&workId=";

    public a(InspireFeed inspireFeed, FeedsPhotoCommentView feedsPhotoCommentView) {
        super(inspireFeed);
        new WeakReference(feedsPhotoCommentView);
    }

    private l q(l lVar) {
        t(lVar.a(), lVar.b());
        lVar.a().setThumbnailUri(PhotoImageView.addQiNiuSuffix(((InspireFeed) this.a).getFcnt().photos.get(0).url, 256, 256, false));
        lVar.a().setWebUrl(c + ((InspireFeed) this.a).getFcnt().workId);
        return lVar;
    }

    private String r(ShareSite shareSite, String str) {
        boolean z = shareSite == ShareSite.QQ || shareSite == ShareSite.QZONE || shareSite == ShareSite.WECHAT_FRIENDS || shareSite == ShareSite.WECHAT_MOMENTS;
        return !z ? str : us.pinguo.inspire_proxy.c.a.o(ImageLoader.getInstance().u(str), z);
    }

    private l s(l lVar) {
        if (((InspireFeed) this.a).getFcnt() == null || k.a(((InspireFeed) this.a).getFcnt().videos)) {
            return null;
        }
        PGShareInfo a = lVar.a();
        t(a, lVar.b());
        InspireFeedVideo inspireFeedVideo = ((InspireFeed) this.a).getFcnt().videos.get(0);
        a.setThumbnailUri(r(lVar.b(), PhotoImageView.addQiNiuSuffix(inspireFeedVideo.url, inspireFeedVideo.width, inspireFeedVideo.height, true)));
        a.setWebUrl(c + ((InspireFeed) this.a).getFcnt().workId);
        return lVar;
    }

    private void t(PGShareInfo pGShareInfo, ShareSite shareSite) {
        T t = this.a;
        String str = (((InspireFeed) t).sender == null || ((InspireFeed) t).sender.nickname == null) ? "" : ((InspireFeed) t).sender.nickname;
        String str2 = ((InspireFeed) t).getFcnt().desc;
        String p = p(shareSite, str, str2);
        pGShareInfo.setText(o(shareSite, p, str2, null, null));
        pGShareInfo.setTitle(p);
    }

    @Override // us.pinguo.share.c.e
    protected l a(l lVar) {
        if (b() == ShareDataType.VIDEO) {
            return s(lVar);
        }
        q(lVar);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.share.c.e
    public ShareDataType b() {
        if ("video".equals(((InspireFeed) this.a).type)) {
            return ShareDataType.VIDEO;
        }
        if (InspireFeed.TYPE_MULTI.equals(((InspireFeed) this.a).type)) {
            return ShareDataType.MULTI_PHOTO;
        }
        return ShareDataType.SINGLE_PHOTO;
    }

    @Override // us.pinguo.share.c.e
    public boolean j(ShareSite shareSite) {
        return b() != ShareDataType.VIDEO;
    }
}
