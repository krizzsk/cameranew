package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.jvm.internal.s;
/* compiled from: SpannedString.kt */
/* loaded from: classes.dex */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned spanned, int i2, int i3) {
        s.h(spanned, "<this>");
        s.n(4, "T");
        throw null;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i2, int i3, int i4, Object obj) {
        int i5 = i4 & 1;
        if ((i4 & 2) != 0) {
            spanned.length();
        }
        s.h(spanned, "<this>");
        s.n(4, "T");
        throw null;
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        s.h(charSequence, "<this>");
        SpannedString valueOf = SpannedString.valueOf(charSequence);
        s.g(valueOf, "valueOf(this)");
        return valueOf;
    }
}
