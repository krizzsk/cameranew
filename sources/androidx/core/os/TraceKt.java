package androidx.core.os;

import kotlin.jvm.b.a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
/* compiled from: Trace.kt */
/* loaded from: classes.dex */
public final class TraceKt {
    public static final <T> T trace(String sectionName, a<? extends T> block) {
        s.h(sectionName, "sectionName");
        s.h(block, "block");
        TraceCompat.beginSection(sectionName);
        try {
            return block.invoke();
        } finally {
            r.b(1);
            TraceCompat.endSection();
            r.a(1);
        }
    }
}
