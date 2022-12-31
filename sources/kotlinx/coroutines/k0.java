package kotlinx.coroutines;

import com.growingio.android.sdk.collection.Constants;
import java.util.Objects;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public final class k0 extends AbstractCoroutineContextElement implements t2<String> {
    public static final a b = new a(null);
    private final long a;

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public static final class a implements CoroutineContext.Key<k0> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    public k0(long j2) {
        super(b);
        this.a = j2;
    }

    @Override // kotlinx.coroutines.t2
    /* renamed from: A */
    public void n(CoroutineContext coroutineContext, String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.t2
    /* renamed from: Q */
    public String N(CoroutineContext coroutineContext) {
        int V;
        String name;
        l0 l0Var = (l0) coroutineContext.get(l0.b);
        String str = "coroutine";
        if (l0Var != null && (name = l0Var.getName()) != null) {
            str = name;
        }
        Thread currentThread = Thread.currentThread();
        String name2 = currentThread.getName();
        V = StringsKt__StringsKt.V(name2, " @", 0, false, 6, null);
        if (V < 0) {
            V = name2.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + V + 10);
        Objects.requireNonNull(name2, "null cannot be cast to non-null type java.lang.String");
        String substring = name2.substring(0, V);
        kotlin.jvm.internal.s.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(" @");
        sb.append(str);
        sb.append(Constants.ID_PREFIX);
        sb.append(z());
        kotlin.u uVar = kotlin.u.a;
        String sb2 = sb.toString();
        kotlin.jvm.internal.s.g(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k0) && this.a == ((k0) obj).a;
    }

    public int hashCode() {
        return defpackage.c.a(this.a);
    }

    public String toString() {
        return "CoroutineId(" + this.a + ')';
    }

    public final long z() {
        return this.a;
    }
}
