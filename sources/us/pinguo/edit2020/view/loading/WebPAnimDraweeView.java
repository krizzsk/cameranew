package us.pinguo.edit2020.view.loading;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.UiThread;
import com.facebook.common.util.d;
import com.facebook.drawee.backends.pipeline.c;
import com.facebook.drawee.backends.pipeline.e;
import com.facebook.imagepipeline.image.g;
import java.io.File;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.widget.RatioWebpAnimImageView;
import us.pinguo.common.widget.h;
/* compiled from: WebPAnimDraweeView.kt */
/* loaded from: classes4.dex */
public final class WebPAnimDraweeView extends RatioWebpAnimImageView {

    /* renamed from: j  reason: collision with root package name */
    private Animatable f10786j;

    /* renamed from: k  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f10787k;

    /* renamed from: l  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f10788l;
    private kotlin.jvm.b.a<u> m;
    private kotlin.jvm.b.a<u> n;
    private boolean o;

    /* compiled from: WebPAnimDraweeView.kt */
    /* loaded from: classes4.dex */
    public static final class a extends com.facebook.drawee.controller.b<g> {
        final /* synthetic */ int c;

        /* compiled from: WebPAnimDraweeView.kt */
        /* renamed from: us.pinguo.edit2020.view.loading.WebPAnimDraweeView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0391a implements com.facebook.s.a.c.b {
            final /* synthetic */ WebPAnimDraweeView a;

            C0391a(WebPAnimDraweeView webPAnimDraweeView) {
                this.a = webPAnimDraweeView;
            }

            @Override // com.facebook.s.a.c.b
            public void a(com.facebook.s.a.c.a aVar) {
            }

            @Override // com.facebook.s.a.c.b
            public void b(com.facebook.s.a.c.a aVar) {
                kotlin.jvm.b.a<u> o = this.a.o();
                if (o == null) {
                    return;
                }
                o.invoke();
            }

            @Override // com.facebook.s.a.c.b
            public void c(com.facebook.s.a.c.a aVar, int i2) {
                kotlin.jvm.b.a<u> q;
                kotlin.jvm.b.a<u> p = this.a.p();
                if (p != null) {
                    p.invoke();
                }
                this.a.setOnFirstFrame(null);
                if (i2 != 19 || (q = this.a.q()) == null) {
                    return;
                }
                q.invoke();
            }

            @Override // com.facebook.s.a.c.b
            public void d(com.facebook.s.a.c.a aVar) {
            }
        }

        a(int i2) {
            this.c = i2;
        }

        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        /* renamed from: h */
        public void d(String str, g gVar, Animatable animatable) {
            if (animatable != null) {
                WebPAnimDraweeView.this.o = true;
            }
            if (animatable == null || gVar == null) {
                return;
            }
            try {
                WebPAnimDraweeView.this.setMAnimTable(animatable);
                ((com.facebook.s.a.c.a) animatable).h(new h(((com.facebook.s.a.c.a) animatable).d(), this.c));
                ((com.facebook.s.a.c.a) animatable).i(new C0391a(WebPAnimDraweeView.this));
                kotlin.jvm.b.a<u> r = WebPAnimDraweeView.this.r();
                if (r == null) {
                    return;
                }
                r.invoke();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebPAnimDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        new LinkedHashMap();
    }

    public static /* synthetic */ void setImagePath$default(WebPAnimDraweeView webPAnimDraweeView, Object obj, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        webPAnimDraweeView.setImagePath(obj, i2);
    }

    public final kotlin.jvm.b.a<u> o() {
        return this.f10787k;
    }

    public final kotlin.jvm.b.a<u> p() {
        return this.f10788l;
    }

    public final kotlin.jvm.b.a<u> q() {
        return this.m;
    }

    public final kotlin.jvm.b.a<u> r() {
        return this.n;
    }

    @UiThread
    public final boolean s() {
        Animatable animatable = this.f10786j;
        if (animatable == null) {
            return false;
        }
        return animatable.isRunning();
    }

    public final void setImagePath(Object obj, int i2) {
        s.e(obj);
        setWebpAnimRes(obj, i2);
    }

    public final void setMAnimTable(Animatable animatable) {
        this.f10786j = animatable;
    }

    public final void setOnAnimFinished(kotlin.jvm.b.a<u> aVar) {
        this.f10787k = aVar;
    }

    public final void setOnFirstFrame(kotlin.jvm.b.a<u> aVar) {
        this.f10788l = aVar;
    }

    public final void setOnLastFrame(kotlin.jvm.b.a<u> aVar) {
        this.m = aVar;
    }

    public final void setOnResourceLoaded(kotlin.jvm.b.a<u> aVar) {
        this.n = aVar;
    }

    public final void setWebpAnimRes(Object path, int i2) {
        s.h(path, "path");
        a aVar = new a(i2);
        com.facebook.drawee.b.a d2 = d();
        Uri uri = null;
        Animatable e2 = d2 == null ? null : d2.e();
        if (e2 != null) {
            e2.stop();
        }
        if (path instanceof String) {
            uri = d.d(new File((String) path));
        } else if (path instanceof Integer) {
            uri = d.e(((Number) path).intValue());
        }
        e a2 = c.h().a(uri);
        a2.A(aVar);
        setController(a2.build());
    }

    public final void t() {
        Animatable animatable = this.f10786j;
        if (animatable == null) {
            return;
        }
        animatable.start();
    }

    public final void u() {
        Animatable animatable = this.f10786j;
        if (animatable == null) {
            return;
        }
        animatable.stop();
    }
}
