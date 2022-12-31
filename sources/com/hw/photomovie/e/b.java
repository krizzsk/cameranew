package com.hw.photomovie.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import androidx.core.location.LocationRequestCompat;
import com.hw.photomovie.e.a;
/* compiled from: MovieTimer.java */
/* loaded from: classes2.dex */
public class b implements a, ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    private final ValueAnimator a;
    private a.InterfaceC0200a b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5177d;

    /* renamed from: e  reason: collision with root package name */
    private com.hw.photomovie.a f5178e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5179f;

    public b(com.hw.photomovie.a aVar) {
        this.f5178e = aVar;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
        this.a = ofInt;
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(this);
        ofInt.addListener(this);
        ofInt.setDuration(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // com.hw.photomovie.e.a
    public void a(a.InterfaceC0200a interfaceC0200a) {
        this.b = interfaceC0200a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.c = this.a.getCurrentPlayTime();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        a.InterfaceC0200a interfaceC0200a = this.b;
        if (interfaceC0200a != null) {
            if (this.f5177d) {
                interfaceC0200a.onMoviedPaused();
            } else {
                interfaceC0200a.onMovieEnd();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        a.InterfaceC0200a interfaceC0200a = this.b;
        if (interfaceC0200a != null) {
            if (this.f5177d) {
                interfaceC0200a.onMovieResumed();
            } else {
                interfaceC0200a.onMovieStarted();
            }
        }
        if (this.f5177d) {
            this.a.setCurrentPlayTime(this.c);
        }
        this.f5177d = false;
        this.c = 0L;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.f5177d || !valueAnimator.isRunning()) {
            return;
        }
        long currentPlayTime = valueAnimator.getCurrentPlayTime();
        if (currentPlayTime >= this.f5178e.d()) {
            this.a.removeUpdateListener(this);
            this.a.removeListener(this);
            this.a.end();
            a.InterfaceC0200a interfaceC0200a = this.b;
            if (interfaceC0200a != null) {
                interfaceC0200a.onMovieEnd();
            }
            this.a.addUpdateListener(this);
            this.a.addListener(this);
            if (this.f5179f) {
                this.a.start();
                return;
            }
            return;
        }
        a.InterfaceC0200a interfaceC0200a2 = this.b;
        if (interfaceC0200a2 != null) {
            interfaceC0200a2.onMovieUpdate((int) currentPlayTime);
        }
    }

    @Override // com.hw.photomovie.e.a
    public void pause() {
        if (this.f5177d) {
            return;
        }
        this.f5177d = true;
        this.c = this.a.getCurrentPlayTime();
        this.a.cancel();
    }

    @Override // com.hw.photomovie.e.a
    public void start() {
        if (!this.f5177d) {
            this.a.start();
        } else {
            this.a.start();
        }
    }
}
