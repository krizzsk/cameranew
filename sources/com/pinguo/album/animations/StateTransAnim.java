package com.pinguo.album.animations;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.pinguo.album.opengles.l;
import com.pinguo.album.opengles.q;
import us.pinguo.foundation.utils.n0;
/* loaded from: classes3.dex */
public class StateTransAnim extends com.pinguo.album.animations.b {

    /* renamed from: e  reason: collision with root package name */
    private final b f5983e;

    /* renamed from: f  reason: collision with root package name */
    private float f5984f;

    /* renamed from: g  reason: collision with root package name */
    private float f5985g;

    /* renamed from: h  reason: collision with root package name */
    private float f5986h;

    /* renamed from: i  reason: collision with root package name */
    private float f5987i;

    /* renamed from: j  reason: collision with root package name */
    private float f5988j;

    /* renamed from: k  reason: collision with root package name */
    private float f5989k;

    /* renamed from: l  reason: collision with root package name */
    private float f5990l;
    private float m;
    private float n;
    private q o;
    private boolean p;

    /* loaded from: classes3.dex */
    public enum Transition {
        None,
        Outgoing,
        Incoming,
        PhotoIncoming,
        TranslateOut,
        TranslateIn,
        BottomToTop,
        TopToBottom
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Transition.values().length];
            a = iArr;
            try {
                iArr[Transition.Outgoing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Transition.Incoming.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Transition.PhotoIncoming.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Transition.TranslateIn.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Transition.TranslateOut.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Transition.BottomToTop.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Transition.TopToBottom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Transition.None.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static final b A;
        public static final b B;
        private static final Interpolator C = new DecelerateInterpolator();
        public static final b v;
        public static final b w;
        public static final b x;
        public static final b y;
        public static final b z;
        public int a = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        public boolean b = false;
        public float c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f5991d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f5992e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f5993f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f5994g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        public float f5995h = 0.0f;

        /* renamed from: i  reason: collision with root package name */
        public float f5996i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f5997j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f5998k = 1.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f5999l = 1.0f;
        public float m = 0.0f;
        public float n = 0.0f;
        public float o = 0.0f;
        public float p = 0.0f;
        public float q = 0.0f;
        public float r = 0.0f;
        public float s = 0.0f;
        public float t = 0.0f;
        public Interpolator u = C;

        static {
            b bVar = new b();
            z = bVar;
            bVar.o = 1.0f;
            bVar.p = 0.3f;
            bVar.q = 1.0f;
            bVar.r = 1.0f;
            bVar.s = 0.0f;
            bVar.t = -n0.i();
            bVar.f5996i = 0.3f;
            bVar.f5997j = 1.0f;
            bVar.m = n0.i();
            bVar.n = 0.0f;
            b bVar2 = new b();
            A = bVar2;
            bVar2.o = 1.0f;
            bVar2.p = 0.3f;
            bVar2.q = 1.0f;
            bVar2.r = 1.0f;
            bVar2.s = 0.0f;
            bVar2.t = -n0.h();
            bVar2.f5996i = 0.3f;
            bVar2.f5997j = 1.0f;
            bVar2.m = n0.h();
            bVar2.n = 0.0f;
            bVar2.b = true;
            b bVar3 = new b();
            B = bVar3;
            bVar3.o = 1.0f;
            bVar3.p = 0.3f;
            bVar3.q = 1.0f;
            bVar3.r = 1.0f;
            bVar3.s = 0.0f;
            bVar3.t = n0.h();
            bVar3.f5996i = 0.3f;
            bVar3.f5997j = 1.0f;
            bVar3.m = -n0.h();
            bVar3.n = 0.0f;
            bVar3.b = true;
            b bVar4 = new b();
            y = bVar4;
            bVar4.o = 1.0f;
            bVar4.p = 0.3f;
            bVar4.q = 1.0f;
            bVar4.r = 1.0f;
            bVar4.s = 0.0f;
            bVar4.t = n0.i();
            bVar.f5996i = 0.3f;
            bVar.f5997j = 1.0f;
            bVar4.m = -n0.i();
            bVar4.n = 0.0f;
            b bVar5 = new b();
            v = bVar5;
            bVar5.c = 1.0f;
            bVar5.f5991d = 0.0f;
            bVar5.f5992e = 1.0f;
            bVar5.f5993f = 1.0f;
            bVar5.f5996i = 0.0f;
            bVar5.f5997j = 1.0f;
            bVar5.f5998k = 1.0f;
            bVar5.f5999l = 1.0f;
            b bVar6 = new b();
            w = bVar6;
            bVar6.o = 1.0f;
            bVar6.p = 0.0f;
            bVar6.q = 1.0f;
            bVar6.r = 1.0f;
            bVar6.f5996i = 0.0f;
            bVar6.f5997j = 1.0f;
            bVar6.f5998k = 1.0f;
            bVar6.f5999l = 1.0f;
            x = bVar6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(Transition transition) {
            switch (a.a[transition.ordinal()]) {
                case 1:
                    return v;
                case 2:
                    return w;
                case 3:
                    return x;
                case 4:
                    return z;
                case 5:
                    return y;
                case 6:
                    return A;
                case 7:
                    return B;
                default:
                    return null;
            }
        }
    }

    public StateTransAnim(Transition transition, q qVar) {
        this(b.b(transition), qVar);
    }

    private void o(com.pinguo.album.views.a aVar, l lVar, float f2, float f3, float f4, boolean z) {
        if (this.o == null) {
            return;
        }
        if (z) {
            lVar.B(aVar.i());
        }
        lVar.d();
        lVar.setAlpha(f2);
        int p = aVar.p() / 2;
        int n = aVar.n() / 2;
        if (this.p) {
            lVar.a(0.0f, f4);
        } else {
            lVar.a(f4, 0.0f);
        }
        lVar.a(p, n);
        lVar.k(f3, f3, 1.0f);
        this.o.c(lVar, -p, -n);
        lVar.b();
    }

    @Override // com.pinguo.album.animations.b
    public boolean b(long j2) {
        q qVar;
        boolean b2 = super.b(j2);
        if (!d() && (qVar = this.o) != null) {
            qVar.o();
            this.o = null;
        }
        return b2;
    }

    @Override // com.pinguo.album.animations.b
    protected void e(float f2) {
        b bVar = this.f5983e;
        float f3 = bVar.f5998k;
        this.f5984f = f3 + ((bVar.f5999l - f3) * f2);
        float f4 = bVar.f5996i;
        this.f5985g = f4 + ((bVar.f5997j - f4) * f2);
        float f5 = bVar.m;
        this.f5986h = f5 + ((bVar.n - f5) * f2);
        float f6 = bVar.c;
        this.f5988j = f6 + ((bVar.f5991d - f6) * f2);
        float f7 = bVar.f5992e;
        this.f5987i = f7 + ((bVar.f5993f - f7) * f2);
        float f8 = bVar.f5994g;
        this.f5989k = f8 + ((bVar.f5995h - f8) * f2);
        float f9 = bVar.q;
        this.f5990l = f9 + ((bVar.r - f9) * f2);
        float f10 = bVar.o;
        this.m = f10 + ((bVar.p - f10) * f2);
        float f11 = bVar.s;
        this.n = f11 + ((bVar.t - f11) * f2);
        this.p = bVar.b;
    }

    public void m(com.pinguo.album.views.a aVar, l lVar) {
        float f2 = this.f5988j;
        if (f2 > 0.0f) {
            o(aVar, lVar, f2, this.f5987i, this.f5989k, true);
        }
    }

    public void n(com.pinguo.album.views.a aVar, l lVar) {
        int p = aVar.p() / 2;
        int n = aVar.n() / 2;
        if (this.p) {
            lVar.a(0.0f, this.f5986h);
        } else {
            lVar.a(this.f5986h, 0.0f);
        }
        lVar.a(p, n);
        float f2 = this.f5984f;
        lVar.k(f2, f2, 1.0f);
        lVar.a(-p, -n);
        lVar.setAlpha(this.f5985g);
    }

    public void p(com.pinguo.album.views.a aVar, l lVar) {
        float f2 = this.m;
        if (f2 > 0.0f) {
            o(aVar, lVar, f2, this.f5990l, this.n, false);
        }
    }

    public Animator q(Object obj) {
        b bVar = this.f5983e;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(obj, bVar.b ? "translationY" : "translationX", bVar.m, bVar.n);
        b bVar2 = this.f5983e;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(obj, "alpha", bVar2.f5996i, bVar2.f5997j);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.f5983e.a);
        animatorSet.setInterpolator(this.f5983e.u);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public Animator r(Object obj) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        b bVar = this.f5983e;
        String str = bVar.b ? "translationY" : "translationX";
        if (bVar.c <= 0.0f && bVar.f5991d <= 0.0f) {
            ofFloat = ObjectAnimator.ofFloat(obj, str, bVar.s, bVar.t);
            b bVar2 = this.f5983e;
            ofFloat2 = ObjectAnimator.ofFloat(obj, "alpha", bVar2.o, bVar2.p);
        } else {
            ofFloat = ObjectAnimator.ofFloat(obj, str, bVar.f5994g, bVar.f5995h);
            b bVar3 = this.f5983e;
            ofFloat2 = ObjectAnimator.ofFloat(obj, "alpha", bVar3.c, bVar3.f5991d);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.f5983e.a);
        animatorSet.setInterpolator(this.f5983e.u);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public StateTransAnim(b bVar, q qVar) {
        bVar = bVar == null ? b.v : bVar;
        this.f5983e = bVar;
        i(bVar.a);
        j(bVar.u);
        this.o = qVar;
    }
}
