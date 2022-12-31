package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
/* compiled from: HackTouchDelegate.java */
/* loaded from: classes.dex */
public class j extends TouchDelegate {
    private View a;
    private Rect b;
    private Rect c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2106d;

    /* renamed from: e  reason: collision with root package name */
    private int f2107e;

    public j(Rect rect, View view) {
        super(rect, view);
        this.b = rect;
        this.f2107e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.c = rect2;
        int i2 = this.f2107e;
        rect2.inset(-i2, -i2);
        this.a = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z2 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                boolean z3 = this.f2106d;
                if (z3) {
                    z = this.c.contains(x, y);
                    z2 = z3;
                } else {
                    z2 = z3;
                }
            } else {
                if (action == 3) {
                    boolean z4 = this.f2106d;
                    this.f2106d = false;
                    z2 = z4;
                }
                z = true;
                z2 = false;
            }
            z = true;
        } else if (this.b.contains(x, y)) {
            this.f2106d = true;
            z = true;
        } else {
            this.f2106d = false;
            z = true;
            z2 = false;
        }
        if (z2) {
            View view = this.a;
            if (z) {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            } else {
                float f2 = -(this.f2107e * 2);
                motionEvent.setLocation(f2, f2);
            }
            if (view.getVisibility() == 0) {
                return view.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
