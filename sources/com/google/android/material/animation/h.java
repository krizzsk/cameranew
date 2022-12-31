package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* compiled from: MotionTiming.java */
/* loaded from: classes2.dex */
public class h {
    private long a;
    private long b;
    @Nullable
    private TimeInterpolator c;

    /* renamed from: d  reason: collision with root package name */
    private int f4034d;

    /* renamed from: e  reason: collision with root package name */
    private int f4035e;

    public h(long j2, long j3) {
        this.a = 0L;
        this.b = 300L;
        this.c = null;
        this.f4034d = 0;
        this.f4035e = 1;
        this.a = j2;
        this.b = j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static h b(@NonNull ValueAnimator valueAnimator) {
        h hVar = new h(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        hVar.f4034d = valueAnimator.getRepeatCount();
        hVar.f4035e = valueAnimator.getRepeatMode();
        return hVar;
    }

    private static TimeInterpolator f(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return a.c;
            }
            return interpolator instanceof DecelerateInterpolator ? a.f4032d : interpolator;
        }
        return a.b;
    }

    public void a(@NonNull Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.a;
    }

    public long d() {
        return this.b;
    }

    @Nullable
    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : a.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (c() == hVar.c() && d() == hVar.d() && g() == hVar.g() && h() == hVar.h()) {
                return e().getClass().equals(hVar.e().getClass());
            }
            return false;
        }
        return false;
    }

    public int g() {
        return this.f4034d;
    }

    public int h() {
        return this.f4035e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @NonNull
    public String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public h(long j2, long j3, @NonNull TimeInterpolator timeInterpolator) {
        this.a = 0L;
        this.b = 300L;
        this.c = null;
        this.f4034d = 0;
        this.f4035e = 1;
        this.a = j2;
        this.b = j3;
        this.c = timeInterpolator;
    }
}
