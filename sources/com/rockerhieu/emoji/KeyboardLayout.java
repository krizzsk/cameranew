package com.rockerhieu.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
/* loaded from: classes9.dex */
public class KeyboardLayout extends LinearLayout {
    private boolean a;
    private boolean b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private b f7098d;

    /* renamed from: e  reason: collision with root package name */
    private a f7099e;

    /* loaded from: classes9.dex */
    public interface a {
        void onDispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onKeyBoardStateChange(int i2);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f7099e;
        if (aVar != null) {
            aVar.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b bVar = this.f7098d;
        if (bVar == null) {
            return;
        }
        if (!this.a) {
            this.a = true;
            this.c = i5;
            if (bVar != null) {
                bVar.onKeyBoardStateChange(-1);
            }
        } else {
            bVar.onKeyBoardStateChange(-1);
            int i6 = this.c;
            if (i6 < i5) {
                i6 = i5;
            }
            this.c = i6;
        }
        if (this.a && this.c > i5) {
            this.b = true;
            b bVar2 = this.f7098d;
            if (bVar2 != null) {
                bVar2.onKeyBoardStateChange(-3);
            }
        }
        if (this.a && this.b && this.c == i5) {
            this.b = false;
            b bVar3 = this.f7098d;
            if (bVar3 != null) {
                bVar3.onKeyBoardStateChange(-2);
            }
        }
    }

    public void setOnDispatchTouchListener(a aVar) {
        this.f7099e = aVar;
    }

    public void setOnkbdStateListener(b bVar) {
        this.f7098d = bVar;
    }

    public KeyboardLayout(Context context) {
        super(context);
    }
}
