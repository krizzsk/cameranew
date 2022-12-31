package com.bytedance.sdk.openadsdk.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.openadsdk.core.o;
/* compiled from: TTNetClient.java */
/* loaded from: classes.dex */
public class d {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile d a;
    private static IHttpStack c;
    private Context b;

    /* renamed from: d  reason: collision with root package name */
    private l f1985d;

    /* renamed from: e  reason: collision with root package name */
    private com.bytedance.sdk.adnet.b.b f1986e;

    /* renamed from: f  reason: collision with root package name */
    private l f1987f;

    /* renamed from: g  reason: collision with root package name */
    private l f1988g;

    /* renamed from: h  reason: collision with root package name */
    private com.bytedance.sdk.adnet.b.d f1989h;

    /* renamed from: i  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.g.a.b f1990i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTNetClient.java */
    /* loaded from: classes.dex */
    public static class a implements d.InterfaceC0041d {
        private ImageView a;
        private final String b;
        private final int c;

        /* renamed from: d  reason: collision with root package name */
        private final int f1991d;

        a(ImageView imageView, String str, int i2, int i3) {
            this.a = imageView;
            this.b = str;
            this.c = i2;
            this.f1991d = i3;
            if (imageView != null) {
                imageView.setTag(1094453505, str);
            }
        }

        private boolean c() {
            Object tag;
            ImageView imageView = this.a;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.b)) ? false : true;
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
        public void a() {
            int i2;
            ImageView imageView = this.a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.a.getContext()).isFinishing()) || this.a == null || !c() || (i2 = this.c) == 0) {
                return;
            }
            this.a.setImageResource(i2);
        }

        @Override // com.bytedance.sdk.adnet.core.m.a
        public void a(m<Bitmap> mVar) {
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
        public void b() {
            this.a = null;
        }

        @Override // com.bytedance.sdk.adnet.core.m.a
        public void b(m<Bitmap> mVar) {
            ImageView imageView = this.a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.a.getContext()).isFinishing()) || this.a == null || this.f1991d == 0 || !c()) {
                return;
            }
            this.a.setImageResource(this.f1991d);
        }

        @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
        public void a(d.c cVar, boolean z) {
            ImageView imageView = this.a;
            if ((imageView != null && (imageView.getContext() instanceof Activity) && ((Activity) this.a.getContext()).isFinishing()) || this.a == null || !c() || cVar.a() == null) {
                return;
            }
            this.a.setImageBitmap(cVar.a());
        }
    }

    private d(Context context) {
        this.b = context == null ? o.a() : context.getApplicationContext();
    }

    public static IHttpStack a() {
        return c;
    }

    public static e b() {
        return new e();
    }

    private void h() {
        if (this.f1990i == null) {
            k();
            this.f1990i = new com.bytedance.sdk.openadsdk.g.a.b(this.f1988g);
        }
    }

    private void i() {
        if (this.f1989h == null) {
            k();
            this.f1989h = new com.bytedance.sdk.adnet.b.d(this.f1988g, com.bytedance.sdk.openadsdk.g.a.a());
        }
    }

    private void j() {
        if (this.f1985d == null) {
            this.f1985d = com.bytedance.sdk.adnet.a.a(this.b, a());
        }
    }

    private void k() {
        if (this.f1988g == null) {
            this.f1988g = com.bytedance.sdk.adnet.a.a(this.b);
        }
    }

    public l c() {
        j();
        return this.f1985d;
    }

    public l d() {
        k();
        return this.f1988g;
    }

    public l e() {
        if (this.f1987f == null) {
            this.f1987f = com.bytedance.sdk.adnet.a.a(this.b);
        }
        return this.f1987f;
    }

    public com.bytedance.sdk.openadsdk.g.a.b f() {
        h();
        return this.f1990i;
    }

    public com.bytedance.sdk.adnet.b.d g() {
        i();
        return this.f1989h;
    }

    public static void a(IHttpStack iHttpStack) {
        c = iHttpStack;
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    public void a(String str, b.a aVar) {
        j();
        if (this.f1986e == null) {
            this.f1986e = new com.bytedance.sdk.adnet.b.b(this.b, this.f1985d);
        }
        this.f1986e.a(str, aVar);
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, a(str, imageView, 0, 0));
    }

    public void a(String str, ImageView imageView, d.InterfaceC0041d interfaceC0041d) {
        i();
        this.f1989h.a(str, interfaceC0041d);
    }

    public static a a(String str, ImageView imageView, int i2, int i3) {
        return new a(imageView, str, i2, i3);
    }
}
