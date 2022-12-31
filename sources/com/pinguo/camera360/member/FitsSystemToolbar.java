package com.pinguo.camera360.member;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.Toolbar;
import java.util.LinkedHashMap;
/* compiled from: FitsSystemToolbar.kt */
/* loaded from: classes3.dex */
public final class FitsSystemToolbar extends Toolbar {
    public static final a a;
    private static final String b;

    /* compiled from: FitsSystemToolbar.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        a = aVar;
        b = aVar.getClass().getName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitsSystemToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (getPaddingBottom() != 0) {
            i5 -= getPaddingBottom();
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), 0);
        }
        super.onLayout(z, i2, i3, i4, i5);
        String str = b;
        Log.i(str, " l = " + i2 + " t = " + i3 + " r = " + i4 + " b = " + i5);
        StringBuilder sb = new StringBuilder();
        sb.append("paddingBottom = ");
        sb.append(getPaddingBottom());
        sb.append(" paddingTop = ");
        sb.append(getPaddingTop());
        Log.i(str, sb.toString());
    }
}
