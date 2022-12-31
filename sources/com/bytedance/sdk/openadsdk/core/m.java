package com.bytedance.sdk.openadsdk.core;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: InsertAdDialog.java */
/* loaded from: classes.dex */
public class m extends Dialog {
    private View a;
    private Context b;
    private ImageView c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f1679d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f1680e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f1681f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f1682g;

    /* renamed from: h  reason: collision with root package name */
    private a f1683h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1684i;

    /* compiled from: InsertAdDialog.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(View view);

        void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout);
    }

    public m(@NonNull Context context) {
        this(context, 0);
    }

    private void b() {
        a aVar;
        try {
            FrameLayout frameLayout = this.f1682g;
            if (frameLayout != null && frameLayout.getChildCount() > 0) {
                View childAt = this.f1682g.getChildAt(0);
                if (childAt instanceof NativeExpressView) {
                    NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                    if (nativeExpressView.m()) {
                        FrameLayout frameLayout2 = this.f1682g;
                        frameLayout2.setVisibility(0);
                        VdsAgent.onSetViewVisibility(frameLayout2, 0);
                        this.c.setVisibility(8);
                        this.f1679d.setVisibility(8);
                        this.f1680e.setVisibility(8);
                        TextView textView = this.f1681f;
                        textView.setVisibility(8);
                        VdsAgent.onSetViewVisibility(textView, 8);
                        View findViewById = nativeExpressView.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.b, "tt_bu_close"));
                        if (findViewById == null || (aVar = this.f1683h) == null) {
                            return;
                        }
                        aVar.a(findViewById);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public void show() {
        b();
        super.show();
        VdsAgent.showDialog(this);
    }

    public m(@NonNull Context context, @StyleRes int i2) {
        super(context, i2 == 0 ? com.bytedance.sdk.openadsdk.utils.t.g(context, "tt_wg_insert_dialog") : i2);
        this.f1684i = false;
        this.b = context;
    }

    public void a(boolean z, a aVar) {
        this.f1684i = z;
        this.f1683h = aVar;
        a();
        a aVar2 = this.f1683h;
        if (aVar2 != null) {
            aVar2.a(this.c, this.f1679d, this.f1682g);
        }
    }

    private void a() {
        setCancelable(false);
        View inflate = LayoutInflater.from(this.b).inflate(com.bytedance.sdk.openadsdk.utils.t.f(this.b, "tt_insert_ad_layout"), (ViewGroup) null);
        this.a = inflate;
        setContentView(inflate);
        this.c = (ImageView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.b, "tt_insert_ad_img"));
        this.f1679d = (ImageView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.b, "tt_insert_dislike_icon_img"));
        this.f1680e = (ImageView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.b, "tt_insert_ad_logo"));
        this.f1681f = (TextView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.b, "tt_insert_ad_text"));
        this.f1682g = (FrameLayout) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.t.e(this.b, "tt_insert_express_ad_fl"));
        int c = ac.c(this.b);
        int i2 = c / 3;
        this.c.setMaxWidth(c);
        this.c.setMinimumWidth(i2);
        this.c.setMinimumHeight(i2);
        this.f1682g.setMinimumWidth(i2);
        this.f1682g.setMinimumHeight(i2);
        this.c.setVisibility(this.f1684i ? 8 : 0);
        this.f1679d.setVisibility(0);
        this.f1680e.setVisibility(this.f1684i ? 8 : 0);
        TextView textView = this.f1681f;
        int i3 = this.f1684i ? 8 : 0;
        textView.setVisibility(i3);
        VdsAgent.onSetViewVisibility(textView, i3);
        FrameLayout frameLayout = this.f1682g;
        int i4 = this.f1684i ? 0 : 8;
        frameLayout.setVisibility(i4);
        VdsAgent.onSetViewVisibility(frameLayout, i4);
        int a2 = (int) ac.a(this.b, 15.0f);
        ac.a(this.f1679d, a2, a2, a2, a2);
        this.f1679d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.m.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                if (m.this.f1683h != null) {
                    m.this.f1683h.a(view);
                }
            }
        });
    }
}
