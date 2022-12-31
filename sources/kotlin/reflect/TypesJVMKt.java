package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.jvm.internal.s;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.t;
/* compiled from: TypesJVM.kt */
/* loaded from: classes3.dex */
public final class TypesJVMKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Type type) {
        String name;
        kotlin.sequences.e e2;
        int h2;
        String r;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                e2 = SequencesKt__SequencesKt.e(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                StringBuilder sb = new StringBuilder();
                sb.append(((Class) kotlin.sequences.h.k(e2)).getName());
                h2 = SequencesKt___SequencesKt.h(e2);
                r = t.r("[]", h2);
                sb.append(r);
                name = sb.toString();
            } else {
                name = cls.getName();
            }
            s.g(name, "{\n        if (type.isArr…   } else type.name\n    }");
            return name;
        }
        return type.toString();
    }
}
