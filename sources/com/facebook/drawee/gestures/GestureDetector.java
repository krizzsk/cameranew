package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.VisibleForTesting;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class GestureDetector {
    @Nullable
    @VisibleForTesting
    a a;
    @VisibleForTesting
    final float b;
    @VisibleForTesting
    boolean c;
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    boolean f2600d;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    long f2601e;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    float f2602f;
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    float f2603g;

    /* loaded from: classes.dex */
    public interface a {
        boolean onClick();
    }

    public GestureDetector(Context context) {
        this.b = ViewConfiguration.get(context).getScaledTouchSlop();
        a();
    }

    public static GestureDetector c(Context context) {
        return new GestureDetector(context);
    }

    public void a() {
        this.a = null;
        e();
    }

    public boolean b() {
        return this.c;
    }

    public boolean d(MotionEvent motionEvent) {
        a aVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = true;
            this.f2600d = true;
            this.f2601e = motionEvent.getEventTime();
            this.f2602f = motionEvent.getX();
            this.f2603g = motionEvent.getY();
        } else if (action == 1) {
            this.c = false;
            if (Math.abs(motionEvent.getX() - this.f2602f) > this.b || Math.abs(motionEvent.getY() - this.f2603g) > this.b) {
                this.f2600d = false;
            }
            if (this.f2600d && motionEvent.getEventTime() - this.f2601e <= ViewConfiguration.getLongPressTimeout() && (aVar = this.a) != null) {
                aVar.onClick();
            }
            this.f2600d = false;
        } else if (action != 2) {
            if (action == 3) {
                this.c = false;
                this.f2600d = false;
            }
        } else if (Math.abs(motionEvent.getX() - this.f2602f) > this.b || Math.abs(motionEvent.getY() - this.f2603g) > this.b) {
            this.f2600d = false;
        }
        return true;
    }

    public void e() {
        this.c = false;
        this.f2600d = false;
    }

    public void f(a aVar) {
        this.a = aVar;
    }
}
