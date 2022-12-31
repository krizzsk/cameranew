package me.everything.a.a.a;

import android.view.MotionEvent;
import android.view.View;
import me.everything.a.a.a.g;
/* compiled from: HorizontalOverScrollBounceEffectDecorator.java */
/* loaded from: classes9.dex */
public class a extends g {

    /* compiled from: HorizontalOverScrollBounceEffectDecorator.java */
    /* renamed from: me.everything.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    protected static class C0325a extends g.a {
        public C0325a() {
            this.a = View.TRANSLATION_X;
        }

        @Override // me.everything.a.a.a.g.a
        protected void a(View view) {
            this.b = view.getTranslationX();
            this.c = view.getWidth();
        }
    }

    /* compiled from: HorizontalOverScrollBounceEffectDecorator.java */
    /* loaded from: classes9.dex */
    protected static class b extends g.e {
        protected b() {
        }

        @Override // me.everything.a.a.a.g.e
        public boolean a(View view, MotionEvent motionEvent) {
            if (motionEvent.getHistorySize() == 0) {
                return false;
            }
            float y = motionEvent.getY(0) - motionEvent.getHistoricalY(0, 0);
            float x = motionEvent.getX(0) - motionEvent.getHistoricalX(0, 0);
            if (Math.abs(x) < Math.abs(y)) {
                return false;
            }
            this.a = view.getTranslationX();
            this.b = x;
            this.c = x > 0.0f;
            return true;
        }
    }

    public a(me.everything.a.a.a.h.a aVar) {
        this(aVar, 3.0f, 1.0f, -2.0f);
    }

    @Override // me.everything.a.a.a.g
    protected g.a c() {
        return new C0325a();
    }

    @Override // me.everything.a.a.a.g
    protected g.e d() {
        return new b();
    }

    @Override // me.everything.a.a.a.g
    protected void g(View view, float f2) {
        view.setTranslationX(f2);
    }

    @Override // me.everything.a.a.a.g
    protected void h(View view, float f2, MotionEvent motionEvent) {
        view.setTranslationX(f2);
        motionEvent.offsetLocation(f2 - motionEvent.getX(0), 0.0f);
    }

    public a(me.everything.a.a.a.h.a aVar, float f2, float f3, float f4) {
        super(aVar, f4, f2, f3);
    }
}
