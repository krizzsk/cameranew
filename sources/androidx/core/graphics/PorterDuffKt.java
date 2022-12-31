package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import kotlin.jvm.internal.s;
/* compiled from: PorterDuff.kt */
/* loaded from: classes.dex */
public final class PorterDuffKt {
    public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode mode, int i2) {
        s.h(mode, "<this>");
        return new PorterDuffColorFilter(i2, mode);
    }

    public static final PorterDuffXfermode toXfermode(PorterDuff.Mode mode) {
        s.h(mode, "<this>");
        return new PorterDuffXfermode(mode);
    }
}
