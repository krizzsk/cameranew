package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v1;
/* compiled from: CoroutinesRoom.kt */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class CoroutinesRoom {
    public static final Companion Companion = new Companion(null);

    private CoroutinesRoom() {
    }

    public static final <R> kotlinx.coroutines.flow.c<R> createFlow(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z, strArr, callable);
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z, CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
        return Companion.execute(roomDatabase, z, cancellationSignal, callable, continuation);
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z, Callable<R> callable, Continuation<? super R> continuation) {
        return Companion.execute(roomDatabase, z, callable, continuation);
    }

    /* compiled from: CoroutinesRoom.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final <R> kotlinx.coroutines.flow.c<R> createFlow(RoomDatabase db, boolean z, String[] tableNames, Callable<R> callable) {
            kotlin.jvm.internal.s.h(db, "db");
            kotlin.jvm.internal.s.h(tableNames, "tableNames");
            kotlin.jvm.internal.s.h(callable, "callable");
            return kotlinx.coroutines.flow.e.s(new CoroutinesRoom$Companion$createFlow$1(z, db, tableNames, callable, null));
        }

        public final <R> Object execute(RoomDatabase roomDatabase, boolean z, Callable<R> callable, Continuation<? super R> continuation) {
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) continuation.getContext().get(TransactionElement.Key);
            CoroutineDispatcher transactionDispatcher$room_ktx_release = transactionElement == null ? null : transactionElement.getTransactionDispatcher$room_ktx_release();
            if (transactionDispatcher$room_ktx_release == null) {
                transactionDispatcher$room_ktx_release = z ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            return kotlinx.coroutines.j.g(transactionDispatcher$room_ktx_release, new CoroutinesRoom$Companion$execute$2(callable, null), continuation);
        }

        public final <R> Object execute(RoomDatabase roomDatabase, boolean z, CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
            Continuation intercepted;
            v1 d2;
            Object coroutine_suspended;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) continuation.getContext().get(TransactionElement.Key);
            CoroutineDispatcher transactionDispatcher$room_ktx_release = transactionElement == null ? null : transactionElement.getTransactionDispatcher$room_ktx_release();
            if (transactionDispatcher$room_ktx_release == null) {
                transactionDispatcher$room_ktx_release = z ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(intercepted, 1);
            qVar.x();
            d2 = kotlinx.coroutines.l.d(n1.a, transactionDispatcher$room_ktx_release, null, new CoroutinesRoom$Companion$execute$4$job$1(callable, qVar, null), 2, null);
            qVar.e(new CoroutinesRoom$Companion$execute$4$1(cancellationSignal, d2));
            Object u = qVar.u();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (u == coroutine_suspended) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return u;
        }
    }
}
