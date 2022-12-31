package kotlin.time;

import kotlin.jvm.internal.s;
/* compiled from: DurationUnitJvm.kt */
/* loaded from: classes3.dex */
class d {
    public static final long a(long j2, DurationUnit sourceUnit, DurationUnit targetUnit) {
        s.h(sourceUnit, "sourceUnit");
        s.h(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j2, sourceUnit.getTimeUnit$kotlin_stdlib());
    }
}
