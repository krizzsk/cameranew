package kotlin.jvm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.reflect.c;
/* compiled from: JvmClassMapping.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final <T> Class<T> a(c<T> cVar) {
        s.h(cVar, "<this>");
        Class<T> cls = (Class<T>) ((l) cVar).a();
        s.f(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return cls;
    }

    public static final <T> Class<T> b(c<T> cVar) {
        s.h(cVar, "<this>");
        Class<T> cls = (Class<T>) ((l) cVar).a();
        if (!cls.isPrimitive()) {
            s.f(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return cls;
        }
        String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        cls = (Class<T>) Double.class;
                        break;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        cls = (Class<T>) Integer.class;
                        break;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        cls = (Class<T>) Byte.class;
                        break;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        cls = (Class<T>) Character.class;
                        break;
                    }
                    break;
                case 3327612:
                    if (name.equals(Constants.LONG)) {
                        cls = (Class<T>) Long.class;
                        break;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        cls = (Class<T>) Void.class;
                        break;
                    }
                    break;
                case 64711720:
                    if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                        cls = (Class<T>) Boolean.class;
                        break;
                    }
                    break;
                case 97526364:
                    if (name.equals(TypedValues.Custom.S_FLOAT)) {
                        cls = (Class<T>) Float.class;
                        break;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        cls = (Class<T>) Short.class;
                        break;
                    }
                    break;
            }
        }
        s.f(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return cls;
    }

    public static final <T> c<T> c(Class<T> cls) {
        s.h(cls, "<this>");
        return v.b(cls);
    }
}
