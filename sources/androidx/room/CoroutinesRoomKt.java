package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.m1;
/* compiled from: CoroutinesRoom.kt */
/* loaded from: classes.dex */
public final class CoroutinesRoomKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final CoroutineDispatcher getQueryDispatcher(RoomDatabase roomDatabase) {
        kotlin.jvm.internal.s.h(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        kotlin.jvm.internal.s.g(backingFieldMap, "backingFieldMap");
        Object obj = backingFieldMap.get("QueryDispatcher");
        if (obj == null) {
            Executor queryExecutor = roomDatabase.getQueryExecutor();
            kotlin.jvm.internal.s.g(queryExecutor, "queryExecutor");
            obj = m1.a(queryExecutor);
            backingFieldMap.put("QueryDispatcher", obj);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) obj;
    }

    public static final CoroutineDispatcher getTransactionDispatcher(RoomDatabase roomDatabase) {
        kotlin.jvm.internal.s.h(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        kotlin.jvm.internal.s.g(backingFieldMap, "backingFieldMap");
        Object obj = backingFieldMap.get("TransactionDispatcher");
        if (obj == null) {
            Executor transactionExecutor = roomDatabase.getTransactionExecutor();
            kotlin.jvm.internal.s.g(transactionExecutor, "transactionExecutor");
            obj = m1.a(transactionExecutor);
            backingFieldMap.put("TransactionDispatcher", obj);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) obj;
    }
}
