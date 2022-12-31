package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.jvm.internal.s;
/* compiled from: CameraMaskImageView.kt */
/* loaded from: classes3.dex */
public final class CameraMaskImageView extends ImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraMaskImageView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        final int h2 = us.pinguo.foundation.t.b.a.h(getContext()) / 3;
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.pinguo.camera360.ui.view.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                CameraMaskImageView.a(CameraMaskImageView.this, h2, view, i2, i3, i4, i5, i6, i7, i8, i9);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CameraMaskImageView this$0, int i2, View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        s.h(this$0, "this$0");
        int width = this$0.getDrawable().getBounds().width();
        ViewParent parent = this$0.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.View");
        float f2 = (((i5 - i3) / 2) - (width / 2)) * 1.0f;
        Matrix matrix = new Matrix();
        matrix.postTranslate(f2, (i2 - ((View) parent).getTop()) * 1.0f);
        this$0.setImageMatrix(matrix);
    }

    public CameraMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new LinkedHashMap();
        final int h2 = us.pinguo.foundation.t.b.a.h(getContext()) / 3;
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.pinguo.camera360.ui.view.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                CameraMaskImageView.a(CameraMaskImageView.this, h2, view, i2, i3, i4, i5, i6, i7, i8, i9);
            }
        });
    }

    public CameraMaskImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new LinkedHashMap();
        final int h2 = us.pinguo.foundation.t.b.a.h(getContext()) / 3;
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.pinguo.camera360.ui.view.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i22, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                CameraMaskImageView.a(CameraMaskImageView.this, h2, view, i22, i3, i4, i5, i6, i7, i8, i9);
            }
        });
    }
}
