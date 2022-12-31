package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Objects;
import kotlinx.coroutines.channels.b;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.c0;
/* compiled from: LinkedListChannel.kt */
/* loaded from: classes3.dex */
public class l<E> extends AbstractChannel<E> {
    public l(kotlin.jvm.b.l<? super E, kotlin.u> lVar) {
        super(lVar);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean Q() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean R() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void V(Object obj, j<?> jVar) {
        UndeliveredElementException undeliveredElementException = null;
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                r rVar = (r) obj;
                if (rVar instanceof b.a) {
                    kotlin.jvm.b.l<E, kotlin.u> lVar = this.a;
                    if (lVar != null) {
                        undeliveredElementException = OnUndeliveredElementKt.c(lVar, ((b.a) rVar).f8718d, null);
                    }
                } else {
                    rVar.S(jVar);
                }
            } else {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    UndeliveredElementException undeliveredElementException2 = null;
                    while (true) {
                        int i2 = size - 1;
                        r rVar2 = (r) arrayList.get(size);
                        if (rVar2 instanceof b.a) {
                            kotlin.jvm.b.l<E, kotlin.u> lVar2 = this.a;
                            undeliveredElementException2 = lVar2 == null ? null : OnUndeliveredElementKt.c(lVar2, ((b.a) rVar2).f8718d, undeliveredElementException2);
                        } else {
                            rVar2.S(jVar);
                        }
                        if (i2 < 0) {
                            break;
                        }
                        size = i2;
                    }
                    undeliveredElementException = undeliveredElementException2;
                }
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean t() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean u() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    protected Object x(E e2) {
        p<?> B;
        do {
            Object x = super.x(e2);
            c0 c0Var = a.b;
            if (x == c0Var) {
                return c0Var;
            }
            if (x == a.c) {
                B = B(e2);
                if (B == null) {
                    return c0Var;
                }
            } else if (x instanceof j) {
                return x;
            } else {
                throw new IllegalStateException(kotlin.jvm.internal.s.q("Invalid offerInternal result ", x).toString());
            }
        } while (!(B instanceof j));
        return B;
    }
}
