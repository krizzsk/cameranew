package androidx.room;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoomDatabase.kt */
@DebugMetadata(c = "androidx.room.RoomDatabaseKt$withTransaction$2", f = "RoomDatabase.kt", i = {0}, l = {58}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
/* loaded from: classes.dex */
public final class RoomDatabaseKt$withTransaction$2 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super R>, Object> {
    final /* synthetic */ kotlin.jvm.b.l<Continuation<? super R>, Object> $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomDatabaseKt$withTransaction$2(RoomDatabase roomDatabase, kotlin.jvm.b.l<? super Continuation<? super R>, ? extends Object> lVar, Continuation<? super RoomDatabaseKt$withTransaction$2> continuation) {
        super(2, continuation);
        this.$this_withTransaction = roomDatabase;
        this.$block = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$2 = new RoomDatabaseKt$withTransaction$2(this.$this_withTransaction, this.$block, continuation);
        roomDatabaseKt$withTransaction$2.L$0 = obj;
        return roomDatabaseKt$withTransaction$2;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super R> continuation) {
        return ((RoomDatabaseKt$withTransaction$2) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TransactionElement coroutine_suspended;
        Throwable th;
        TransactionElement transactionElement;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                kotlin.j.b(obj);
                CoroutineContext.Element element = ((kotlinx.coroutines.m0) this.L$0).getCoroutineContext().get(TransactionElement.Key);
                kotlin.jvm.internal.s.e(element);
                TransactionElement transactionElement2 = (TransactionElement) element;
                transactionElement2.acquire();
                try {
                    this.$this_withTransaction.beginTransaction();
                    try {
                        kotlin.jvm.b.l<Continuation<? super R>, Object> lVar = this.$block;
                        this.L$0 = transactionElement2;
                        this.label = 1;
                        Object invoke = lVar.invoke(this);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        transactionElement = transactionElement2;
                        obj = invoke;
                    } catch (Throwable th2) {
                        th = th2;
                        this.$this_withTransaction.endTransaction();
                        throw th;
                    }
                } catch (Throwable th3) {
                    coroutine_suspended = transactionElement2;
                    th = th3;
                    coroutine_suspended.release();
                    throw th;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                transactionElement = (TransactionElement) this.L$0;
                try {
                    kotlin.j.b(obj);
                } catch (Throwable th4) {
                    th = th4;
                    this.$this_withTransaction.endTransaction();
                    throw th;
                }
            }
            this.$this_withTransaction.setTransactionSuccessful();
            this.$this_withTransaction.endTransaction();
            transactionElement.release();
            return obj;
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
