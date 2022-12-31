package com.pinguo.camera360.adv.e.c;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAd;
import com.facebook.drawee.backends.pipeline.e;
import com.facebook.imagepipeline.image.g;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* compiled from: AbsNormalNativeLayout.java */
/* loaded from: classes3.dex */
public abstract class b extends c<us.pinguo.advsdk.a.b> {

    /* compiled from: AbsNormalNativeLayout.java */
    /* loaded from: classes3.dex */
    class a implements com.facebook.drawee.controller.c<g> {
        a() {
        }

        @Override // com.facebook.drawee.controller.c
        public void b(String str, Throwable th) {
        }

        @Override // com.facebook.drawee.controller.c
        public void c(String str) {
        }

        @Override // com.facebook.drawee.controller.c
        public void e(String str, Object obj) {
        }

        @Override // com.facebook.drawee.controller.c
        public void f(String str, Throwable th) {
        }

        @Override // com.facebook.drawee.controller.c
        /* renamed from: g */
        public void d(String str, g gVar, Animatable animatable) {
            if (((us.pinguo.admobvista.d.a) b.this).b.isFinishing()) {
                return;
            }
            b.this.q();
            b.this.r();
        }

        @Override // com.facebook.drawee.controller.c
        /* renamed from: h */
        public void a(String str, g gVar) {
        }
    }

    public b(Activity activity, us.pinguo.advsdk.a.b bVar, ViewGroup viewGroup) {
        super(activity, bVar, viewGroup);
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void e() {
        if (this.f6162j != null && 1 == ((us.pinguo.advsdk.a.b) this.f6164l).l()) {
            this.f6162j.addView(new AdOptionsView(this.b, (NativeAd) ((us.pinguo.advsdk.a.b) this.f6164l).h(), null));
            ViewGroup viewGroup = this.f6162j;
            viewGroup.setVisibility(0);
            VdsAgent.onSetViewVisibility(viewGroup, 0);
        }
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void j() {
        if (this.f6157e == null) {
            q();
            r();
        } else if (this.m != null && t()) {
            q();
            r();
        } else {
            a aVar = new a();
            e h2 = com.facebook.drawee.backends.pipeline.c.h();
            h2.A(aVar);
            e a2 = h2.a(Uri.parse(((us.pinguo.advsdk.a.b) this.f6164l).g()));
            a2.y(true);
            this.f6157e.setController(a2.build());
        }
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void k() {
        if (this.f6160h == null) {
            return;
        }
        if (!TextUtils.isEmpty(((us.pinguo.advsdk.a.b) this.f6164l).b())) {
            this.f6160h.setText(((us.pinguo.advsdk.a.b) this.f6164l).b());
        } else {
            this.f6160h.setText(R.string.default_cta_text);
        }
        ((us.pinguo.advsdk.a.b) this.f6164l).q(this.f6160h);
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void l() {
        if (this.f6161i == null || s()) {
            return;
        }
        this.f6161i.setImageURI(Uri.parse(((us.pinguo.advsdk.a.b) this.f6164l).e()));
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void m() {
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void n() {
        TextView textView = this.f6159g;
        if (textView == null) {
            return;
        }
        textView.setText(((us.pinguo.advsdk.a.b) this.f6164l).c());
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void o() {
        if (this.f6158f == null || TextUtils.isEmpty(((us.pinguo.advsdk.a.b) this.f6164l).k())) {
            return;
        }
        this.f6158f.setText(((us.pinguo.advsdk.a.b) this.f6164l).k());
    }

    public void q() {
        this.a.removeAllViews();
        if (!t()) {
            this.a.addView(this.f6163k);
        }
        ((us.pinguo.advsdk.a.b) this.f6164l).o(this.f6163k, f(), this.a);
        ViewGroup viewGroup = this.a;
        viewGroup.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewGroup, 0);
    }

    public void r() {
        b();
    }

    protected boolean s() {
        return 1 == ((us.pinguo.advsdk.a.b) this.f6164l).l();
    }

    protected boolean t() {
        return 18 == ((us.pinguo.advsdk.a.b) this.f6164l).l() || 1 == ((us.pinguo.advsdk.a.b) this.f6164l).l() || 3 == ((us.pinguo.advsdk.a.b) this.f6164l).l() || 2 == ((us.pinguo.advsdk.a.b) this.f6164l).l() || 25 == ((us.pinguo.advsdk.a.b) this.f6164l).l();
    }
}
