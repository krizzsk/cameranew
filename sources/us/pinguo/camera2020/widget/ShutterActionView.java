package us.pinguo.camera2020.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
/* compiled from: ShutterActionView.kt */
/* loaded from: classes3.dex */
public final class ShutterActionView extends View {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShutterActionView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
    }

    public final void a() {
        l.d(n0.a(z0.c()), null, null, new ShutterActionView$show$1(this, null), 3, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShutterActionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShutterActionView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }
}
