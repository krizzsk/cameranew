package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.Lambda;
/* compiled from: AbstractMap.kt */
/* loaded from: classes3.dex */
final class AbstractMap$toString$1 extends Lambda implements kotlin.jvm.b.l<Map.Entry<? extends K, ? extends V>, CharSequence> {
    final /* synthetic */ c<K, V> this$0;

    AbstractMap$toString$1(c<K, ? extends V> cVar) {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public final CharSequence invoke(Map.Entry<? extends K, ? extends V> it) {
        String c;
        kotlin.jvm.internal.s.h(it, "it");
        c = this.this$0.c(it);
        return c;
    }
}
