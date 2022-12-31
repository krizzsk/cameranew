package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(Size size) {
        s.h(size, "<this>");
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(Size size) {
        s.h(size, "<this>");
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(SizeF sizeF) {
        s.h(sizeF, "<this>");
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(SizeF sizeF) {
        s.h(sizeF, "<this>");
        return sizeF.getHeight();
    }
}
