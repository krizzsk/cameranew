package com.pinguo.album.views;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.pinguo.album.animations.StateTransAnim;
import com.pinguo.album.animations.d;
import com.pinguo.album.opengles.l;
import java.util.ArrayList;
/* compiled from: GLBaseView.java */
@SuppressLint({"WrongCall"})
/* loaded from: classes3.dex */
public class a {
    protected final Rect a = new Rect();
    private b b;
    protected a c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<a> f6108d;

    /* renamed from: e  reason: collision with root package name */
    protected a f6109e;

    /* renamed from: f  reason: collision with root package name */
    private d f6110f;

    /* renamed from: g  reason: collision with root package name */
    private int f6111g;

    /* renamed from: h  reason: collision with root package name */
    protected int f6112h;

    /* renamed from: i  reason: collision with root package name */
    protected int f6113i;

    /* renamed from: j  reason: collision with root package name */
    private float[] f6114j;

    /* renamed from: k  reason: collision with root package name */
    private StateTransAnim f6115k;

    public a() {
        new Rect();
        this.f6111g = 0;
        this.f6112h = 0;
        this.f6113i = 0;
    }

    private boolean B(int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        Rect rect = this.a;
        boolean z = (i6 == rect.right - rect.left && i5 - i3 == rect.bottom - rect.top) ? false : true;
        rect.set(i2, i3, i4, i5);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(l lVar, a aVar) {
        if (aVar.o() == 0 || aVar.f6110f != null) {
            Rect rect = aVar.a;
            int i2 = rect.left - this.f6113i;
            int i3 = rect.top - this.f6112h;
            lVar.a(i2, i3);
            d dVar = aVar.f6110f;
            if (dVar != null) {
                lVar.s(dVar.n());
                if (dVar.b(com.pinguo.album.animations.c.a())) {
                    q();
                } else {
                    aVar.f6110f = null;
                }
                dVar.m(lVar);
            }
            aVar.y(lVar);
            if (dVar != null) {
                lVar.b();
            }
            lVar.a(-i2, -i3);
        }
    }

    public void C(StateTransAnim stateTransAnim) {
        this.f6115k = stateTransAnim;
        if (stateTransAnim != null) {
            stateTransAnim.l();
        }
    }

    public void D(int i2) {
        if (i2 == o()) {
            return;
        }
        if (i2 == 0) {
            this.f6111g &= -2;
        } else {
            this.f6111g |= 1;
        }
        x(i2);
        q();
    }

    public void E() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.g();
        }
    }

    public void c(a aVar) {
        if (aVar.c == null) {
            if (this.f6108d == null) {
                this.f6108d = new ArrayList<>();
            }
            this.f6108d.add(aVar);
            aVar.c = this;
            b bVar = this.b;
            if (bVar != null) {
                aVar.t(bVar);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void d(b bVar) {
        com.pinguo.album.j.a.a(this.c == null && this.b == null);
        t(bVar);
    }

    public Rect e() {
        return this.a;
    }

    public void f() {
        com.pinguo.album.j.a.a(this.c == null && this.b != null);
        u();
    }

    public boolean g(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        a aVar = this.f6109e;
        if (aVar != null) {
            if (action == 0) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                h(obtain, x, y, this.f6109e, false);
                this.f6109e = null;
            } else {
                h(motionEvent, x, y, aVar, false);
                if (action == 3 || action == 1) {
                    this.f6109e = null;
                }
                return true;
            }
        }
        if (action == 0) {
            for (int l2 = l() - 1; l2 >= 0; l2--) {
                a k2 = k(l2);
                if (k2.o() == 0 && h(motionEvent, x, y, k2, true)) {
                    this.f6109e = k2;
                    return true;
                }
            }
        }
        return w(motionEvent);
    }

    protected boolean h(MotionEvent motionEvent, int i2, int i3, a aVar, boolean z) {
        Rect rect = aVar.a;
        int i4 = rect.left;
        int i5 = rect.top;
        if (!z || rect.contains(i2, i3)) {
            motionEvent.offsetLocation(-i4, -i5);
            if (aVar.g(motionEvent)) {
                motionEvent.offsetLocation(i4, i5);
                return true;
            }
            motionEvent.offsetLocation(i4, i5);
            return false;
        }
        return false;
    }

    public float[] i() {
        return this.f6114j;
    }

    public boolean j(a aVar, Rect rect) {
        int i2 = 0;
        int i3 = 0;
        for (a aVar2 = aVar; aVar2 != this; aVar2 = aVar2.c) {
            if (aVar2 == null) {
                return false;
            }
            Rect rect2 = aVar2.a;
            i2 += rect2.left;
            i3 += rect2.top;
        }
        rect.set(i2, i3, aVar.p() + i2, aVar.n() + i3);
        return true;
    }

    public a k(int i2) {
        ArrayList<a> arrayList = this.f6108d;
        if (arrayList != null) {
            return arrayList.get(i2);
        }
        throw new ArrayIndexOutOfBoundsException(i2);
    }

    public int l() {
        ArrayList<a> arrayList = this.f6108d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public b m() {
        return this.b;
    }

    public int n() {
        Rect rect = this.a;
        return rect.bottom - rect.top;
    }

    public int o() {
        return (this.f6111g & 1) == 0 ? 0 : 4;
    }

    public int p() {
        Rect rect = this.a;
        return rect.right - rect.left;
    }

    public void q() {
        b m = m();
        if (m != null) {
            m.requestRender();
        }
    }

    public void r(int i2, int i3, int i4, int i5) {
        boolean B = B(i2, i3, i4, i5);
        this.f6111g &= -5;
        v(B, i2, i3, i4, i5);
    }

    public void s() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void t(b bVar) {
        this.b = bVar;
        int l2 = l();
        for (int i2 = 0; i2 < l2; i2++) {
            k(i2).t(bVar);
        }
    }

    protected void u() {
        int l2 = l();
        for (int i2 = 0; i2 < l2; i2++) {
            k(i2).u();
        }
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(boolean z, int i2, int i3, int i4, int i5) {
    }

    protected boolean w(MotionEvent motionEvent) {
        return false;
    }

    protected void x(int i2) {
        int l2 = l();
        for (int i3 = 0; i3 < l2; i3++) {
            a k2 = k(i3);
            if (k2.o() == 0) {
                k2.x(i2);
            }
        }
    }

    public void y(l lVar) {
        boolean z;
        StateTransAnim stateTransAnim = this.f6115k;
        if (stateTransAnim == null || !stateTransAnim.b(com.pinguo.album.animations.c.a())) {
            z = false;
        } else {
            q();
            z = this.f6115k.d();
        }
        z(lVar);
        lVar.d();
        if (z) {
            this.f6115k.n(this, lVar);
        }
        int l2 = l();
        for (int i2 = 0; i2 < l2; i2++) {
            A(lVar, k(i2));
        }
        lVar.b();
        if (z) {
            this.f6115k.p(this, lVar);
        }
    }

    protected void z(l lVar) {
        float[] fArr = this.f6114j;
        if (fArr != null) {
            lVar.B(fArr);
        }
        StateTransAnim stateTransAnim = this.f6115k;
        if (stateTransAnim == null || !stateTransAnim.d()) {
            return;
        }
        this.f6115k.m(this, lVar);
    }
}
