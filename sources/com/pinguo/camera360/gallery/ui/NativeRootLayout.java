package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public class NativeRootLayout extends RelativeLayout {
    private b a;
    private GestureDetector b;
    private GestureDetector.OnGestureListener c;

    /* renamed from: d  reason: collision with root package name */
    private int f6456d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f6457e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f6458f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (NativeRootLayout.this.a != null) {
                int x = (int) motionEvent2.getX();
                int abs = Math.abs(((int) motionEvent2.getY()) - ((int) motionEvent.getY()));
                int x2 = x - ((int) motionEvent.getX());
                if (abs < Math.abs(x2)) {
                    if (x2 < 0) {
                        return NativeRootLayout.this.a.b();
                    }
                    if (x2 > 0) {
                        return NativeRootLayout.this.a.a();
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean a();

        boolean b();
    }

    public NativeRootLayout(Context context) {
        this(context, null);
    }

    private void e() {
        this.c = new a();
        this.b = new GestureDetector(getContext(), this.c);
        this.f6456d = 0;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f6457e = relativeLayout;
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        this.f6458f = relativeLayout2;
        addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout3 = this.f6458f;
        relativeLayout3.setVisibility(8);
        VdsAgent.onSetViewVisibility(relativeLayout3, 8);
    }

    public void b(View view) {
        if (this.f6456d == 0) {
            RelativeLayout relativeLayout = this.f6457e;
            relativeLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(relativeLayout, 0);
            this.f6457e.removeAllViews();
            this.f6457e.addView(view);
            return;
        }
        RelativeLayout relativeLayout2 = this.f6458f;
        relativeLayout2.setVisibility(0);
        VdsAgent.onSetViewVisibility(relativeLayout2, 0);
        this.f6458f.removeAllViews();
        this.f6458f.addView(view);
    }

    public ViewGroup c() {
        return this.f6456d == 0 ? this.f6458f : this.f6457e;
    }

    public ViewGroup d() {
        return this.f6456d == 0 ? this.f6457e : this.f6458f;
    }

    public void f() {
        if (this.f6456d == 0) {
            RelativeLayout relativeLayout = this.f6457e;
            relativeLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(relativeLayout, 8);
            this.f6458f.removeAllViews();
            this.f6456d = 1;
            return;
        }
        RelativeLayout relativeLayout2 = this.f6458f;
        relativeLayout2.setVisibility(8);
        VdsAgent.onSetViewVisibility(relativeLayout2, 8);
        this.f6457e.removeAllViews();
        this.f6456d = 0;
    }

    public void g() {
        if (this.f6456d == 0) {
            RelativeLayout relativeLayout = this.f6457e;
            relativeLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(relativeLayout, 0);
            this.f6457e.removeAllViews();
            return;
        }
        RelativeLayout relativeLayout2 = this.f6458f;
        relativeLayout2.setVisibility(0);
        VdsAgent.onSetViewVisibility(relativeLayout2, 0);
        this.f6458f.removeAllViews();
    }

    public void h() {
        this.f6457e.setAlpha(1.0f);
        this.f6457e.setTranslationX(0.0f);
        this.f6457e.setTranslationY(0.0f);
        this.f6458f.setAlpha(1.0f);
        this.f6458f.setTranslationX(0.0f);
        this.f6458f.setTranslationY(0.0f);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return this.b.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a == null) {
            return super.onTouchEvent(motionEvent);
        }
        this.b.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setOnFlingListener(b bVar) {
        this.a = bVar;
    }

    public NativeRootLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeRootLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e();
    }
}
