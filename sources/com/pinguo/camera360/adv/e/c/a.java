package com.pinguo.camera360.adv.e.c;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.backends.pipeline.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.g;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.interaction.AppGoto;
import vStudio.Android.Camera360.R;
/* compiled from: AbsBrandNativeLayout.java */
/* loaded from: classes3.dex */
public abstract class a extends c<AdvItem> implements View.OnClickListener {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbsBrandNativeLayout.java */
    /* renamed from: com.pinguo.camera360.adv.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0237a implements com.facebook.drawee.controller.c<g> {
        C0237a() {
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
            if (((us.pinguo.admobvista.d.a) a.this).b.isFinishing()) {
                return;
            }
            a aVar = a.this;
            aVar.f6163k.setOnClickListener(aVar);
            a.this.q();
            a.this.r();
        }

        @Override // com.facebook.drawee.controller.c
        /* renamed from: h */
        public void a(String str, g gVar) {
        }
    }

    public a(Activity activity, AdvItem advItem, ViewGroup viewGroup) {
        super(activity, advItem, viewGroup);
    }

    @Override // com.pinguo.camera360.adv.e.c.c, us.pinguo.admobvista.d.a
    public void a() {
        ViewGroup viewGroup = this.f6163k;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(4);
        VdsAgent.onSetViewVisibility(viewGroup, 4);
        l();
        o();
        n();
        l();
        k();
        j();
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void e() {
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void j() {
        C0237a c0237a = new C0237a();
        e h2 = com.facebook.drawee.backends.pipeline.c.h();
        h2.A(c0237a);
        e a = h2.a(Uri.parse(((AdvItem) this.f6164l).imageUrl));
        a.y(true);
        this.f6157e.setController(a.build());
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void k() {
        if (this.f6160h == null) {
            return;
        }
        if (!TextUtils.isEmpty(((AdvItem) this.f6164l).btnText)) {
            this.f6160h.setText(((AdvItem) this.f6164l).btnText);
        } else {
            this.f6160h.setText(this.b.getResources().getString(R.string.feeds_more));
        }
        this.f6160h.setOnClickListener(this);
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void l() {
        SimpleDraweeView simpleDraweeView = this.f6161i;
        if (simpleDraweeView == null) {
            return;
        }
        simpleDraweeView.setImageURI(Uri.parse(((AdvItem) this.f6164l).iconUrl));
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
        textView.setText(((AdvItem) this.f6164l).desc);
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public void o() {
        TextView textView = this.f6158f;
        if (textView == null) {
            return;
        }
        textView.setText(((AdvItem) this.f6164l).content);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        AppGoto.getInstance().d((AdvItem) this.f6164l).b(view.getContext());
        ((AdvItem) this.f6164l).exePvTaskClick();
    }

    public void q() {
        this.a.removeAllViews();
        this.a.addView(this.f6163k);
        ViewGroup viewGroup = this.f6163k;
        viewGroup.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewGroup, 0);
        ViewGroup viewGroup2 = this.a;
        viewGroup2.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewGroup2, 0);
    }

    public void r() {
        b();
    }
}
