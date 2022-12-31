package com.rockerhieu.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes9.dex */
public class FaceView extends ImageView {
    private boolean a;
    private int b;
    private int c;

    public FaceView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.a = true;
        int i2 = this.b;
        if (i2 != 0) {
            setImageResource(i2);
        }
    }

    public void b() {
        setFace(!this.a);
    }

    public void setBtnRes(int i2, int i3) {
        this.b = i2;
        this.c = i3;
        if (!this.a) {
            i2 = i3;
        }
        setImageResource(i2);
    }

    public void setFace(boolean z) {
        if (this.a != z) {
            setImageResource(z ? this.b : this.c);
        }
        this.a = z;
    }

    public FaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
