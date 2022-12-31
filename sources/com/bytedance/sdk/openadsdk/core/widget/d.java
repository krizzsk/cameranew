package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
/* compiled from: VideoOnTouchLayout.java */
/* loaded from: classes.dex */
public class d {
    private final a a;

    /* renamed from: d  reason: collision with root package name */
    private float f1896d;

    /* renamed from: e  reason: collision with root package name */
    private float f1897e;

    /* renamed from: f  reason: collision with root package name */
    private int f1898f;

    /* renamed from: g  reason: collision with root package name */
    private int f1899g;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1903k;
    private boolean b = false;
    private boolean c = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1900h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1901i = false;

    /* renamed from: j  reason: collision with root package name */
    private final View.OnTouchListener f1902j = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.a.m()) {
                return d.this.b || !d.this.c;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                d dVar = d.this;
                dVar.f1903k = dVar.a(motionEvent);
                d.this.f1896d = x;
                d.this.f1897e = y;
                d.this.f1898f = (int) x;
                d.this.f1899g = (int) y;
                d.this.f1900h = true;
                if (d.this.a != null && d.this.c && !d.this.b) {
                    d.this.a.a(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - d.this.f1898f) > 20.0f || Math.abs(y - d.this.f1899g) > 20.0f) {
                    d.this.f1900h = false;
                }
                if (!d.this.b) {
                    d.this.f1900h = true;
                }
                d.this.f1901i = false;
                d.this.f1896d = 0.0f;
                d.this.f1897e = 0.0f;
                d.this.f1898f = 0;
                if (d.this.a != null) {
                    d.this.a.a(view, d.this.f1900h);
                }
                d.this.f1903k = false;
            } else if (action != 2) {
                if (action == 3) {
                    d.this.f1903k = false;
                }
            } else if (d.this.b && !d.this.f1903k) {
                float abs = Math.abs(x - d.this.f1896d);
                float abs2 = Math.abs(y - d.this.f1897e);
                if (!d.this.f1901i) {
                    if (abs <= 20.0f && abs2 <= 20.0f) {
                        return true;
                    }
                    d.this.f1901i = true;
                }
                if (d.this.a != null) {
                    d.this.a.l();
                }
                d.this.f1896d = x;
                d.this.f1897e = y;
            }
            return d.this.b || !d.this.c;
        }
    };

    /* compiled from: VideoOnTouchLayout.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(View view, boolean z);

        void l();

        boolean m();
    }

    public d(a aVar) {
        this.a = aVar;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(this.f1902j);
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            int c = ac.c(o.a().getApplicationContext());
            int d2 = ac.d(o.a().getApplicationContext());
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float f2 = c;
            if (rawX > f2 * 0.01f && rawX < f2 * 0.99f) {
                float f3 = d2;
                if (rawY > 0.01f * f3 && rawY < f3 * 0.99f) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
