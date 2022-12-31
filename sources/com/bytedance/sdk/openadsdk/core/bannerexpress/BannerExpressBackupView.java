package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* loaded from: classes.dex */
public class BannerExpressBackupView extends BackupView {

    /* renamed from: h  reason: collision with root package name */
    private static i[] f1515h = {new i(1, 6.6666665f, 600, 90), new i(1, 6.4f, VideoEdit2Activity.MIN_SCALED_SIZE, 100), new i(1, 4.0f, 600, 150), new i(2, 1.2f, 600, 500), new i(3, 1.5f, 600, 400), new i(3, 2.0f, 600, IjkMediaCodecInfo.RANK_SECURE), new i(3, 2.3076923f, 600, 260), new i(3, 1.7783505f, 690, 388)};

    /* renamed from: i  reason: collision with root package name */
    private View f1516i;

    /* renamed from: j  reason: collision with root package name */
    private NativeExpressView f1517j;

    /* renamed from: k  reason: collision with root package name */
    private d.a.a.a.a.a.b f1518k;

    /* renamed from: l  reason: collision with root package name */
    private int f1519l;

    public BannerExpressBackupView(@NonNull Context context) {
        super(context);
        this.f1519l = 1;
        this.a = context;
    }

    private void b() {
        i a = a(this.f1517j.getExpectExpressWidth(), this.f1517j.getExpectExpressHeight());
        if (this.f1517j.getExpectExpressWidth() > 0 && this.f1517j.getExpectExpressHeight() > 0) {
            if (this.f1517j.getExpectExpressWidth() > this.f1517j.getExpectExpressHeight()) {
                this.f1691f = ac.c(this.a, this.f1517j.getExpectExpressHeight() * a.b);
                this.f1692g = ac.c(this.a, this.f1517j.getExpectExpressHeight());
            } else {
                this.f1691f = ac.c(this.a, this.f1517j.getExpectExpressWidth());
                this.f1692g = ac.c(this.a, this.f1517j.getExpectExpressWidth() / a.b);
            }
        } else {
            int c = ac.c(this.a);
            this.f1691f = c;
            this.f1692g = Float.valueOf(c / a.b).intValue();
        }
        int i2 = this.f1691f;
        if (i2 > 0 && i2 > ac.c(this.a)) {
            float c2 = ac.c(this.a) / this.f1691f;
            this.f1691f = ac.c(this.a);
            this.f1692g = Float.valueOf(this.f1692g * c2).intValue();
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
        int i3 = a.a;
        if (i3 == 1) {
            e();
        } else if (i3 == 2) {
            d();
        } else if (i3 == 3) {
            c();
        } else {
            e();
        }
    }

    private void c() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_banner_layout3"), (ViewGroup) this, true);
        this.f1516i = inflate;
        View findViewById = inflate.findViewById(t.e(this.a, "tt_bu_close"));
        TextView textView = (TextView) this.f1516i.findViewById(t.e(this.a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                BannerExpressBackupView.this.a();
            }
        });
        int a = (int) ac.a(this.a, 15.0f);
        ac.a(findViewById, a, a, a, a);
        a((ImageView) this.f1516i.findViewById(t.e(this.a, "tt_bu_img")));
        d.a(this.a).a(this.b.y().a(), (ImageView) this.f1516i.findViewById(t.e(this.a, "tt_bu_icon")));
        ((TextView) this.f1516i.findViewById(t.e(this.a, "tt_bu_name"))).setText(getNameOrSource());
        ((TextView) this.f1516i.findViewById(t.e(this.a, "tt_bu_title"))).setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        ((TextView) this.f1516i.findViewById(t.e(this.a, "tt_bu_desc"))).setText(getDescription());
        if (!TextUtils.isEmpty(this.b.I())) {
            textView.setText(this.b.I());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void d() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_banner_layout2"), (ViewGroup) this, true);
        this.f1516i = inflate;
        View findViewById = inflate.findViewById(t.e(this.a, "tt_bu_close"));
        TextView textView = (TextView) this.f1516i.findViewById(t.e(this.a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                BannerExpressBackupView.this.a();
            }
        });
        int a = (int) ac.a(this.a, 15.0f);
        ac.a(findViewById, a, a, a, a);
        a((ImageView) this.f1516i.findViewById(t.e(this.a, "tt_bu_img")));
        d.a(this.a).a(this.b.y().a(), (ImageView) this.f1516i.findViewById(t.e(this.a, "tt_bu_icon")));
        ((TextView) this.f1516i.findViewById(t.e(this.a, "tt_bu_title"))).setText(getTitle());
        ((TextView) this.f1516i.findViewById(t.e(this.a, "tt_bu_desc"))).setText(getDescription());
        if (!TextUtils.isEmpty(this.b.I())) {
            textView.setText(this.b.I());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void e() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_banner_layout1"), (ViewGroup) this, true);
        this.f1516i = inflate;
        View findViewById = inflate.findViewById(t.e(this.a, "tt_bu_close"));
        TextView textView = (TextView) this.f1516i.findViewById(t.e(this.a, "tt_bu_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.f1516i.findViewById(t.e(this.a, "tt_bu_score_bar"));
        TextView textView2 = (TextView) this.f1516i.findViewById(t.e(this.a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.3
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                BannerExpressBackupView.this.a();
            }
        });
        d.a(this.a).a(this.b.y().a(), (ImageView) this.f1516i.findViewById(t.e(this.a, "tt_bu_icon")));
        ((TextView) this.f1516i.findViewById(t.e(this.a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.I())) {
            textView2.setText(this.b.I());
        }
        int d2 = this.b.K() != null ? this.b.K().d() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(d2)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(d2);
        tTRatingBar.setStarImageWidth(ac.c(this.a, 15.0f));
        tTRatingBar.setStarImageHeight(ac.c(this.a, 14.0f));
        tTRatingBar.setStarImagePadding(ac.c(this.a, 4.0f));
        tTRatingBar.a();
        a((View) this, false);
        a((View) textView2, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i2, f fVar) {
        NativeExpressView nativeExpressView = this.f1517j;
        if (nativeExpressView != null) {
            nativeExpressView.a(i2, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar, NativeExpressView nativeExpressView, d.a.a.a.a.a.b bVar) {
        setBackgroundColor(-1);
        this.b = hVar;
        this.f1517j = nativeExpressView;
        this.f1518k = bVar;
        this.f1690e = "banner_ad";
        nativeExpressView.addView(this, new ViewGroup.LayoutParams(-2, -2));
        b();
    }

    private void a(ImageView imageView) {
        d.a(this.a).a(this.b.B().get(0).a(), imageView);
    }

    private i a(int i2, int i3) {
        try {
            float floatValue = Float.valueOf(i2).floatValue() / Float.valueOf(i3).floatValue();
            i[] iVarArr = f1515h;
            i iVar = iVarArr[0];
            float f2 = Float.MAX_VALUE;
            for (i iVar2 : iVarArr) {
                float abs = Math.abs(iVar2.b - floatValue);
                if (abs <= f2) {
                    iVar = iVar2;
                    f2 = abs;
                }
            }
            return iVar;
        } catch (Throwable unused) {
            return f1515h[0];
        }
    }
}
