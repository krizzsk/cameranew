package com.jcodecraeer.xrecyclerview;

import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes2.dex */
public abstract class AppBarStateChangeListener implements AppBarLayout.d {
    private State a = State.IDLE;

    /* loaded from: classes2.dex */
    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    @Override // com.google.android.material.appbar.AppBarLayout.c
    public final void a(AppBarLayout appBarLayout, int i2) {
        if (i2 == 0) {
            State state = this.a;
            State state2 = State.EXPANDED;
            if (state != state2) {
                b(appBarLayout, state2);
            }
            this.a = state2;
        } else if (Math.abs(i2) >= appBarLayout.m()) {
            State state3 = this.a;
            State state4 = State.COLLAPSED;
            if (state3 != state4) {
                b(appBarLayout, state4);
            }
            this.a = state4;
        } else {
            State state5 = this.a;
            State state6 = State.IDLE;
            if (state5 != state6) {
                b(appBarLayout, state6);
            }
            this.a = state6;
        }
    }

    public abstract void b(AppBarLayout appBarLayout, State state);
}
