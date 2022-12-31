package com.bytedance.sdk.openadsdk.core.c;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* compiled from: InteractionExpressBackupView.java */
/* loaded from: classes.dex */
class a extends BackupView {

    /* renamed from: h  reason: collision with root package name */
    private static i[] f1534h = {new i(1, 1.0f, IjkMediaCodecInfo.RANK_SECURE, IjkMediaCodecInfo.RANK_SECURE), new i(2, 0.6666667f, IjkMediaCodecInfo.RANK_SECURE, 450), new i(3, 1.5f, IjkMediaCodecInfo.RANK_SECURE, 200)};

    /* renamed from: i  reason: collision with root package name */
    private View f1535i;

    /* renamed from: j  reason: collision with root package name */
    private NativeExpressView f1536j;

    /* renamed from: k  reason: collision with root package name */
    private d.a.a.a.a.a.b f1537k;

    /* renamed from: l  reason: collision with root package name */
    private int f1538l;
    private Dialog m;

    public a(@NonNull Context context) {
        super(context);
        this.f1538l = 1;
        this.a = context;
    }

    private void b() {
        i a = a(this.f1536j.getExpectExpressWidth(), this.f1536j.getExpectExpressHeight());
        if (this.f1536j.getExpectExpressWidth() > 0 && this.f1536j.getExpectExpressHeight() > 0) {
            if (this.f1536j.getExpectExpressWidth() > this.f1536j.getExpectExpressHeight()) {
                this.f1691f = ac.c(this.a, this.f1536j.getExpectExpressHeight() * a.b);
                this.f1692g = ac.c(this.a, this.f1536j.getExpectExpressHeight());
            } else {
                this.f1691f = ac.c(this.a, this.f1536j.getExpectExpressWidth());
                this.f1692g = ac.c(this.a, this.f1536j.getExpectExpressWidth() / a.b);
            }
        } else {
            this.f1691f = ac.c(this.a, a.c);
            this.f1692g = ac.c(this.a, a.f1723d);
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
        setLayoutParams(layoutParams);
        int i3 = a.a;
        if (i3 == 1) {
            c();
        } else if (i3 == 2) {
            d();
        } else if (i3 == 3) {
            e();
        } else {
            c();
        }
    }

    private void c() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_insert_layout1"), (ViewGroup) this, true);
        this.f1535i = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(t.e(this.a, "tt_bu_img"));
        View findViewById = this.f1535i.findViewById(t.e(this.a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.f1535i.findViewById(t.e(this.a, "tt_bu_icon"));
        TextView textView = (TextView) this.f1535i.findViewById(t.e(this.a, "tt_bu_title"));
        TextView textView2 = (TextView) this.f1535i.findViewById(t.e(this.a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.f1535i.findViewById(t.e(this.a, "tt_bu_download"));
        TextView textView4 = (TextView) this.f1535i.findViewById(t.e(this.a, "tt_bu_dislike"));
        int a = (int) ac.a(this.a, 15.0f);
        ac.a(findViewById, a, a, a, a);
        a(findViewById);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.b.I())) {
            textView3.setText(this.b.I());
        }
        a(imageView);
        d.a(this.a).a(this.b.y().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, false);
        a((View) textView3, true);
        a((View) textView4, true);
    }

    private void d() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_insert_layout2"), (ViewGroup) this, true);
        this.f1535i = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(t.e(this.a, "tt_bu_img"));
        View findViewById = this.f1535i.findViewById(t.e(this.a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.f1535i.findViewById(t.e(this.a, "tt_bu_icon"));
        TextView textView = (TextView) this.f1535i.findViewById(t.e(this.a, "tt_bu_title"));
        TextView textView2 = (TextView) this.f1535i.findViewById(t.e(this.a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.f1535i.findViewById(t.e(this.a, "tt_bu_download"));
        TextView textView4 = (TextView) this.f1535i.findViewById(t.e(this.a, "tt_bu_dislike"));
        int a = (int) ac.a(this.a, 15.0f);
        ac.a(findViewById, a, a, a, a);
        a(findViewById);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.3
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.b.I())) {
            textView3.setText(this.b.I());
        }
        a(imageView);
        d.a(this.a).a(this.b.y().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, false);
        a((View) textView3, true);
        a((View) textView4, true);
    }

    private void e() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_insert_layout3"), (ViewGroup) this, true);
        this.f1535i = inflate;
        View findViewById = this.f1535i.findViewById(t.e(this.a, "tt_bu_close"));
        TextView textView = (TextView) this.f1535i.findViewById(t.e(this.a, "tt_bu_dislike"));
        int a = (int) ac.a(this.a, 15.0f);
        ac.a(findViewById, a, a, a, a);
        a(findViewById);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.4
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                a.this.a();
            }
        });
        a((ImageView) inflate.findViewById(t.e(this.a, "tt_bu_img")));
        ((TextView) this.f1535i.findViewById(t.e(this.a, "tt_bu_desc"))).setText(getDescription());
        a((View) this, false);
        a(this.f1535i, true);
        a((View) textView, true);
    }

    public void a(Dialog dialog) {
        this.m = dialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar, NativeExpressView nativeExpressView, d.a.a.a.a.a.b bVar) {
        setBackgroundColor(-1);
        this.b = hVar;
        this.f1536j = nativeExpressView;
        this.f1537k = bVar;
        this.f1690e = "interaction";
        nativeExpressView.addView(this, new ViewGroup.LayoutParams(-2, -2));
        b();
    }

    private void a(ImageView imageView) {
        d.a(this.a).a(this.b.B().get(0).a(), imageView);
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.2
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view2) {
                VdsAgent.onClick(this, view2);
                if (a.this.m != null) {
                    a.this.m.dismiss();
                }
            }
        });
    }

    private i a(int i2, int i3) {
        try {
            float floatValue = Float.valueOf(i2).floatValue() / Float.valueOf(i3).floatValue();
            i[] iVarArr = f1534h;
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
            return f1534h[0];
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i2, f fVar) {
        NativeExpressView nativeExpressView = this.f1536j;
        if (nativeExpressView != null) {
            nativeExpressView.a(i2, fVar);
        }
    }
}
