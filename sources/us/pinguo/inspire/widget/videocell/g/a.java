package us.pinguo.inspire.widget.videocell.g;

import us.pinguo.inspire.Inspire;
import us.pinguo.ui.widget.banner.b;
/* compiled from: VideoBannerAdapter.java */
/* loaded from: classes9.dex */
public abstract class a<T> extends b<T> {
    private static final float WIDE_MAX = 1.7777778f;
    private static int mScreenWidth = us.pinguo.foundation.t.b.a.j(Inspire.a());
    private int mPicHeight;

    /* compiled from: VideoBannerAdapter.java */
    /* renamed from: us.pinguo.inspire.widget.videocell.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0413a {
        public int a;
        public int b;

        public C0413a(a aVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r2 < r7) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        r2 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        if (r2 > r7) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void showPhoto(us.pinguo.inspire.widget.videocell.InspireVideoView r6, us.pinguo.inspire.widget.videocell.g.a<T>.C0413a r7, java.lang.String r8) {
        /*
            r5 = this;
            int r0 = r7.b
            if (r0 <= 0) goto La
            if (r0 > 0) goto L7
            goto La
        L7:
            int r7 = r7.a
            goto Lc
        La:
            r0 = 1
            r7 = 1
        Lc:
            int r1 = us.pinguo.inspire.widget.videocell.g.a.mScreenWidth
            float r2 = (float) r1
            float r3 = (float) r0
            float r4 = (float) r7
            float r3 = r3 / r4
            float r2 = r2 * r3
            if (r7 <= r0) goto L21
            float r7 = (float) r1
            r0 = 1058013184(0x3f100000, float:0.5625)
            float r7 = r7 * r0
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 >= 0) goto L2c
        L1f:
            r2 = r7
            goto L2c
        L21:
            float r7 = (float) r1
            r0 = 1071877689(0x3fe38e39, float:1.7777778)
            float r7 = r7 * r0
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 <= 0) goto L2c
            goto L1f
        L2c:
            int r7 = (int) r2
            r5.mPicHeight = r7
            us.pinguo.ui.uilview.PhotoImageView r7 = r6.a()
            us.pinguo.inspire.widget.video.WorkDetailVideoView r6 = r6.b()
            r6.setCoverView(r7)
            int r0 = us.pinguo.inspire.widget.videocell.g.a.mScreenWidth
            int r1 = r5.mPicHeight
            r7.setSize(r0, r1)
            int r0 = us.pinguo.inspire.widget.videocell.g.a.mScreenWidth
            int r1 = r5.mPicHeight
            r6.setVideoSize(r0, r1)
            r6 = 0
            r7.setVideoImageUrl(r8, r6, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.widget.videocell.g.a.showPhoto(us.pinguo.inspire.widget.videocell.InspireVideoView, us.pinguo.inspire.widget.videocell.g.a$a, java.lang.String):void");
    }
}
