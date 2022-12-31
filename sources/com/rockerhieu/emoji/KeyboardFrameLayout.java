package com.rockerhieu.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.rockerhieu.emoji.KeyboardLayout;
/* loaded from: classes9.dex */
public class KeyboardFrameLayout extends FrameLayout {
    private boolean a;
    private boolean b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private KeyboardLayout.b f7096d;

    /* renamed from: e  reason: collision with root package name */
    private KeyboardLayout.a f7097e;

    public KeyboardFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        KeyboardLayout.a aVar = this.f7097e;
        if (aVar != null) {
            aVar.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        KeyboardLayout.b bVar = this.f7096d;
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
            KeyboardLayout.b bVar2 = this.f7096d;
            if (bVar2 != null) {
                bVar2.onKeyBoardStateChange(-3);
            }
        }
        if (this.a && this.b && this.c == i5) {
            this.b = false;
            KeyboardLayout.b bVar3 = this.f7096d;
            if (bVar3 != null) {
                bVar3.onKeyBoardStateChange(-2);
            }
        }
    }

    public void setOnDispatchTouchListener(KeyboardLayout.a aVar) {
        this.f7097e = aVar;
    }

    public void setOnkbdStateListener(KeyboardLayout.b bVar) {
        this.f7096d = bVar;
    }

    public KeyboardFrameLayout(Context context) {
        super(context);
    }
}
