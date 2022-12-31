package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.l0;
import kotlin.jvm.internal.Lambda;
/* compiled from: CharDirectionality.kt */
/* loaded from: classes3.dex */
final class CharDirectionality$Companion$directionalityMap$2 extends Lambda implements kotlin.jvm.b.a<Map<Integer, ? extends CharDirectionality>> {
    public static final CharDirectionality$Companion$directionalityMap$2 INSTANCE = new CharDirectionality$Companion$directionalityMap$2();

    CharDirectionality$Companion$directionalityMap$2() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public final Map<Integer, ? extends CharDirectionality> invoke() {
        int c;
        int a;
        CharDirectionality[] values = CharDirectionality.values();
        c = l0.c(values.length);
        a = kotlin.z.j.a(c, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a);
        for (CharDirectionality charDirectionality : values) {
            linkedHashMap.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
        }
        return linkedHashMap;
    }
}
