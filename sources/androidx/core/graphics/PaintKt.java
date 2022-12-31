package androidx.core.graphics;

import android.graphics.Paint;
import kotlin.jvm.internal.s;
/* compiled from: Paint.kt */
/* loaded from: classes.dex */
public final class PaintKt {
    public static final boolean setBlendMode(Paint paint, BlendModeCompat blendModeCompat) {
        s.h(paint, "<this>");
        return PaintCompat.setBlendMode(paint, blendModeCompat);
    }
}
