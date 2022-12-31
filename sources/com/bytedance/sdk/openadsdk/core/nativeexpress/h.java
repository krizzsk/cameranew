package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.x;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* compiled from: FeedExpressBackupView.java */
/* loaded from: classes.dex */
class h extends BackupView {

    /* renamed from: j  reason: collision with root package name */
    private static i[] f1718j = {new i(2, 3.0241935f, 375, 124), new i(3, 1.25f, 375, IjkMediaCodecInfo.RANK_SECURE), new i(4, 1.4044944f, 375, 267), new i(16, 1.25f, 375, IjkMediaCodecInfo.RANK_SECURE), new i(5, 1.25f, 375, IjkMediaCodecInfo.RANK_SECURE), new i(15, 1.25f, 375, IjkMediaCodecInfo.RANK_SECURE), new i(50, 1.25f, 375, IjkMediaCodecInfo.RANK_SECURE)};

    /* renamed from: h  reason: collision with root package name */
    boolean f1719h;

    /* renamed from: i  reason: collision with root package name */
    boolean f1720i;

    /* renamed from: k  reason: collision with root package name */
    private int f1721k;

    /* renamed from: l  reason: collision with root package name */
    private View f1722l;
    private NativeExpressView m;
    private d.a.a.a.a.a.b n;

    public h(@NonNull Context context) {
        super(context);
        this.f1719h = true;
        this.f1720i = true;
        this.a = context;
    }

    private void b(ImageView imageView) {
        com.bytedance.sdk.openadsdk.g.d.a(this.a).a(this.b.B().get(0).a(), imageView);
    }

    private void c() {
        i a = a(this.b.N());
        this.f1691f = ac.c(this.a, this.m.getExpectExpressWidth());
        this.f1692g = ac.c(this.a, this.m.getExpectExpressHeight());
        if (this.f1691f <= 0) {
            this.f1691f = ac.c(this.a);
        }
        if (this.f1692g <= 0) {
            this.f1692g = Float.valueOf(this.f1691f / a.b).intValue();
        }
        int i2 = this.f1691f;
        if (i2 > 0 && i2 > ac.c(this.a)) {
            float c = ac.c(this.a) / this.f1691f;
            this.f1691f = ac.c(this.a);
            this.f1692g = Float.valueOf(this.f1692g * c).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f1691f, this.f1692g);
        }
        layoutParams.width = this.f1691f;
        layoutParams.height = this.f1692g;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (ab.c(this.b.M()) == 9) {
            this.f1690e = "draw_ad";
            h();
            return;
        }
        this.f1690e = "embeded_ad";
        int N = this.b.N();
        if (N == 2) {
            e();
        } else if (N == 3) {
            f();
        } else if (N == 5) {
            i();
        } else if (N == 50) {
            d();
        } else if (N == 15) {
            g();
        } else if (N != 16) {
        } else {
            j();
        }
    }

    private void d() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        this.f1722l = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(t.e(this.a, "tt_bu_video_container"));
        frameLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(frameLayout, 0);
        View findViewById = this.f1722l.findViewById(t.e(this.a, "tt_bu_img_container"));
        findViewById.setVisibility(8);
        VdsAgent.onSetViewVisibility(findViewById, 8);
        TextView textView = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_download"));
        ((ImageView) this.f1722l.findViewById(t.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                h.this.a();
            }
        });
        ((TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.I())) {
            textView.setText(this.b.I());
        }
        View b = b();
        if (b != null) {
            frameLayout.removeAllViews();
            int i2 = this.f1691f;
            frameLayout.addView(b, new ViewGroup.LayoutParams(i2, (i2 * 9) / 16));
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void e() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_feed_img_small"), (ViewGroup) this, true);
        this.f1722l = inflate;
        a((ImageView) inflate.findViewById(t.e(this.a, "tt_bu_img")));
        ((TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_title"))).setText(getTitle());
        ((ImageView) this.f1722l.findViewById(t.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.2
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                h.this.a();
            }
        });
        a((View) this, true);
    }

    private void f() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        this.f1722l = inflate;
        View findViewById = inflate.findViewById(t.e(this.a, "tt_bu_video_container"));
        findViewById.setVisibility(8);
        VdsAgent.onSetViewVisibility(findViewById, 8);
        View findViewById2 = this.f1722l.findViewById(t.e(this.a, "tt_bu_img_container"));
        findViewById2.setVisibility(0);
        VdsAgent.onSetViewVisibility(findViewById2, 0);
        ImageView imageView = (ImageView) this.f1722l.findViewById(t.e(this.a, "tt_bu_img"));
        TextView textView = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_download"));
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.f1692g);
        a(imageView);
        ((ImageView) this.f1722l.findViewById(t.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.3
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                h.this.a();
            }
        });
        ((TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.I())) {
            textView.setText(this.b.I());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void g() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.f1722l = inflate;
        View findViewById = inflate.findViewById(t.e(this.a, "tt_bu_video_container"));
        findViewById.setVisibility(0);
        VdsAgent.onSetViewVisibility(findViewById, 0);
        View findViewById2 = this.f1722l.findViewById(t.e(this.a, "tt_bu_img_container"));
        findViewById2.setVisibility(8);
        VdsAgent.onSetViewVisibility(findViewById2, 8);
        FrameLayout frameLayout = (FrameLayout) this.f1722l.findViewById(t.e(this.a, "tt_bu_video_container_inner"));
        TextView textView = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_title"));
        TextView textView3 = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_video_name1"));
        TextView textView4 = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_video_name2"));
        TextView textView5 = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_download"));
        TextView textView6 = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_video_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.f1722l.findViewById(t.e(this.a, "tt_bu_video_score_bar"));
        com.bytedance.sdk.openadsdk.g.d.a(this.a).a(this.b.y().a(), (ImageView) this.f1722l.findViewById(t.e(this.a, "tt_bu_video_icon")));
        ((ImageView) this.f1722l.findViewById(t.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.4
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                h.this.a();
            }
        });
        int d2 = this.b.K() != null ? this.b.K().d() : 4;
        textView6.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(d2)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(d2);
        tTRatingBar.setStarImageWidth(ac.c(this.a, 15.0f));
        tTRatingBar.setStarImageHeight(ac.c(this.a, 14.0f));
        tTRatingBar.setStarImagePadding(ac.c(this.a, 4.0f));
        tTRatingBar.a();
        textView3.setText(getNameOrSource());
        textView4.setText(getTitle());
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.b.I())) {
            textView5.setText(this.b.I());
        }
        View b = b();
        if (b != null) {
            int i2 = (this.f1691f * 123) / 375;
            frameLayout.removeAllViews();
            frameLayout.addView(b, new ViewGroup.LayoutParams(i2, (i2 * 16) / 9));
        }
        a((View) this, false);
        a((View) textView5, true);
    }

    private void h() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_draw"), (ViewGroup) this, true);
        this.f1722l = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(t.e(this.a, "tt_bu_video_container"));
        TextView textView = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_title"));
        TextView textView3 = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_download"));
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.b.I())) {
            textView3.setText(this.b.I());
        }
        View b = b();
        if (b != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(b, new ViewGroup.LayoutParams(-1, -1));
        }
        a((View) textView2, false);
        a((View) textView, false);
        a((View) textView3, true);
    }

    private void i() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        this.f1722l = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(t.e(this.a, "tt_bu_video_container"));
        frameLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(frameLayout, 0);
        View findViewById = this.f1722l.findViewById(t.e(this.a, "tt_bu_img_container"));
        findViewById.setVisibility(8);
        VdsAgent.onSetViewVisibility(findViewById, 8);
        TextView textView = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_download"));
        ((ImageView) this.f1722l.findViewById(t.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.5
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                h.this.a();
            }
        });
        ((TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.I())) {
            textView.setText(this.b.I());
        }
        View b = b();
        if (b != null) {
            frameLayout.removeAllViews();
            int i2 = this.f1691f;
            frameLayout.addView(b, new ViewGroup.LayoutParams(i2, (i2 * 9) / 16));
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void j() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.f1722l = inflate;
        View findViewById = inflate.findViewById(t.e(this.a, "tt_bu_video_container"));
        findViewById.setVisibility(8);
        VdsAgent.onSetViewVisibility(findViewById, 8);
        View findViewById2 = this.f1722l.findViewById(t.e(this.a, "tt_bu_img_container"));
        findViewById2.setVisibility(0);
        VdsAgent.onSetViewVisibility(findViewById2, 0);
        TextView textView = (TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_download"));
        b((ImageView) this.f1722l.findViewById(t.e(this.a, "tt_bu_img")));
        ((ImageView) this.f1722l.findViewById(t.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.6
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                h.this.a();
            }
        });
        ((TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.f1722l.findViewById(t.e(this.a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.I())) {
            textView.setText(this.b.I());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.core.d.h hVar, NativeExpressView nativeExpressView, d.a.a.a.a.a.b bVar) {
        o.b("FeedExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.b = hVar;
        this.m = nativeExpressView;
        this.n = bVar;
        int d2 = ab.d(hVar.M());
        this.f1721k = d2;
        b(d2);
        c();
        this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    public View b() {
        NativeVideoTsView nativeVideoTsView;
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.b;
        if (hVar != null && this.a != null) {
            if (x.a(hVar)) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.a, this.b);
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.7
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j2, long j3, long j4, boolean z2) {
                        }
                    });
                    nativeVideoTsView.setIsAutoPlay(this.f1719h);
                    nativeVideoTsView.setIsQuiet(this.f1720i);
                } catch (Throwable unused) {
                }
                if (!x.a(this.b) && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
                    return nativeVideoTsView;
                }
            }
            nativeVideoTsView = null;
            if (!x.a(this.b)) {
            }
        }
        return null;
    }

    private i a(int i2) {
        i[] iVarArr = f1718j;
        i iVar = iVarArr[0];
        try {
            for (i iVar2 : iVarArr) {
                if (iVar2.a == i2) {
                    return iVar2;
                }
            }
            return iVar;
        } catch (Throwable unused) {
            return iVar;
        }
    }

    private void b(int i2) {
        this.f1720i = com.bytedance.sdk.openadsdk.core.o.h().a(this.f1721k);
        int c = com.bytedance.sdk.openadsdk.core.o.h().c(i2);
        if (3 == c) {
            this.f1719h = false;
        } else if (1 == c && q.d(this.a)) {
            this.f1719h = true;
        } else if (2 == c) {
            if (q.e(this.a) || q.d(this.a)) {
                this.f1719h = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.widget.ImageView r10) {
        /*
            r9 = this;
            com.bytedance.sdk.openadsdk.core.d.h r0 = r9.b
            java.util.List r0 = r0.B()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.bytedance.sdk.openadsdk.core.d.g r0 = (com.bytedance.sdk.openadsdk.core.d.g) r0
            if (r0 == 0) goto L71
            java.lang.String r2 = r0.a()
            int r3 = r0.b()
            int r0 = r0.c()
            float r4 = (float) r3
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 * r5
            float r6 = (float) r0
            float r4 = r4 / r6
            r6 = 1
            r7 = 1098907648(0x41800000, float:16.0)
            int r8 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r8 > 0) goto L3a
            int r0 = r9.f1692g
            android.content.Context r1 = r9.a
            int r1 = com.bytedance.sdk.openadsdk.utils.ac.c(r1, r7)
            int r0 = r0 - r1
            int r1 = r9.f1692g
        L34:
            float r1 = (float) r1
            float r1 = r1 * r5
            int r3 = (int) r1
            r1 = 1
            goto L54
        L3a:
            r5 = 1071896330(0x3fe3d70a, float:1.78)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 <= 0) goto L54
            r5 = 1072986849(0x3ff47ae1, float:1.91)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L54
            int r0 = r9.f1692g
            android.content.Context r1 = r9.a
            int r1 = com.bytedance.sdk.openadsdk.utils.ac.c(r1, r7)
            int r0 = r0 - r1
            int r1 = r9.f1692g
            goto L34
        L54:
            if (r1 == 0) goto L68
            android.view.ViewGroup$LayoutParams r1 = r10.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            r1.height = r0
            r1.width = r3
            r0 = 8388659(0x800033, float:1.1755015E-38)
            r1.gravity = r0
            r10.setLayoutParams(r1)
        L68:
            android.content.Context r0 = r9.a
            com.bytedance.sdk.openadsdk.g.d r0 = com.bytedance.sdk.openadsdk.g.d.a(r0)
            r0.a(r2, r10)
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.h.a(android.widget.ImageView):void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i2, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.a(i2, fVar);
        }
    }
}
