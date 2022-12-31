package androidx.room;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.v1;
/* compiled from: RoomDatabase.kt */
/* loaded from: classes.dex */
public final class RoomDatabaseKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object acquireTransactionThread(Executor executor, final v1 v1Var, Continuation<? super ContinuationInterceptor> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(intercepted, 1);
        qVar.x();
        qVar.e(new RoomDatabaseKt$acquireTransactionThread$2$1(v1Var));
        try {
            executor.execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2

                /* compiled from: RoomDatabase.kt */
                @DebugMetadata(c = "androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1", f = "RoomDatabase.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1  reason: invalid class name */
                /* loaded from: classes.dex */
                static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
                    final /* synthetic */ kotlinx.coroutines.p<ContinuationInterceptor> $continuation;
                    final /* synthetic */ v1 $controlJob;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(kotlinx.coroutines.p<? super ContinuationInterceptor> pVar, v1 v1Var, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$continuation = pVar;
                        this.$controlJob = v1Var;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$continuation, this.$controlJob, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.b.p
                    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
                        return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i2 = this.label;
                        if (i2 == 0) {
                            kotlin.j.b(obj);
                            kotlinx.coroutines.p<ContinuationInterceptor> pVar = this.$continuation;
                            Result.a aVar = Result.Companion;
                            CoroutineContext.Element element = ((kotlinx.coroutines.m0) this.L$0).getCoroutineContext().get(ContinuationInterceptor.Key);
                            kotlin.jvm.internal.s.e(element);
                            pVar.resumeWith(Result.m41constructorimpl(element));
                            v1 v1Var = this.$controlJob;
                            this.label = 1;
                            if (v1Var.x(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            kotlin.j.b(obj);
                        }
                        return kotlin.u.a;
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    kotlinx.coroutines.k.b(null, new AnonymousClass1(qVar, v1Var, null), 1, null);
                }
            });
        } catch (RejectedExecutionException e2) {
            qVar.l(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e2));
        }
        Object u = qVar.u();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (u == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object createTransactionContext(androidx.room.RoomDatabase r6, kotlin.coroutines.Continuation<? super kotlin.coroutines.CoroutineContext> r7) {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt$createTransactionContext$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomDatabaseKt$createTransactionContext$1 r0 = (androidx.room.RoomDatabaseKt$createTransactionContext$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt$createTransactionContext$1 r0 = new androidx.room.RoomDatabaseKt$createTransactionContext$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.a0 r6 = (kotlinx.coroutines.a0) r6
            java.lang.Object r0 = r0.L$0
            androidx.room.RoomDatabase r0 = (androidx.room.RoomDatabase) r0
            kotlin.j.b(r7)
            goto L73
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.j.b(r7)
            r7 = 0
            kotlinx.coroutines.a0 r7 = kotlinx.coroutines.y1.b(r7, r3, r7)
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            kotlinx.coroutines.v1$b r4 = kotlinx.coroutines.v1.b0
            kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r4)
            kotlinx.coroutines.v1 r2 = (kotlinx.coroutines.v1) r2
            if (r2 != 0) goto L50
            goto L58
        L50:
            androidx.room.RoomDatabaseKt$createTransactionContext$2 r4 = new androidx.room.RoomDatabaseKt$createTransactionContext$2
            r4.<init>(r7)
            r2.u(r4)
        L58:
            java.util.concurrent.Executor r2 = r6.getTransactionExecutor()
            java.lang.String r4 = "transactionExecutor"
            kotlin.jvm.internal.s.g(r2, r4)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r0 = acquireTransactionThread(r2, r7, r0)
            if (r0 != r1) goto L6f
            return r1
        L6f:
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L73:
            kotlin.coroutines.ContinuationInterceptor r7 = (kotlin.coroutines.ContinuationInterceptor) r7
            androidx.room.TransactionElement r1 = new androidx.room.TransactionElement
            r1.<init>(r6, r7)
            java.lang.ThreadLocal r0 = r0.getSuspendingTransactionId()
            java.lang.String r2 = "suspendingTransactionId"
            kotlin.jvm.internal.s.g(r0, r2)
            int r6 = java.lang.System.identityHashCode(r6)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            kotlinx.coroutines.t2 r6 = kotlinx.coroutines.u2.a(r0, r6)
            kotlin.coroutines.CoroutineContext r7 = r7.plus(r1)
            kotlin.coroutines.CoroutineContext r6 = r7.plus(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt.createTransactionContext(androidx.room.RoomDatabase, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e A[PHI: r9 
      PHI: (r9v13 java.lang.Object) = (r9v10 java.lang.Object), (r9v1 java.lang.Object) binds: [B:26:0x007b, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object withTransaction(androidx.room.RoomDatabase r7, kotlin.jvm.b.l<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super R> r9) {
        /*
            boolean r0 = r9 instanceof androidx.room.RoomDatabaseKt$withTransaction$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.RoomDatabaseKt$withTransaction$1 r0 = (androidx.room.RoomDatabaseKt$withTransaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt$withTransaction$1 r0 = new androidx.room.RoomDatabaseKt$withTransaction$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L44
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.j.b(r9)
            goto L7e
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.b.l r7 = (kotlin.jvm.b.l) r7
            java.lang.Object r8 = r0.L$0
            androidx.room.RoomDatabase r8 = (androidx.room.RoomDatabase) r8
            kotlin.j.b(r9)
            r6 = r8
            r8 = r7
            r7 = r6
            goto L6a
        L44:
            kotlin.j.b(r9)
            kotlin.coroutines.CoroutineContext r9 = r0.getContext()
            androidx.room.TransactionElement$Key r2 = androidx.room.TransactionElement.Key
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r2)
            androidx.room.TransactionElement r9 = (androidx.room.TransactionElement) r9
            if (r9 != 0) goto L57
            r9 = r5
            goto L5b
        L57:
            kotlin.coroutines.ContinuationInterceptor r9 = r9.getTransactionDispatcher$room_ktx_release()
        L5b:
            if (r9 != 0) goto L6c
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = createTransactionContext(r7, r0)
            if (r9 != r1) goto L6a
            return r1
        L6a:
            kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9
        L6c:
            androidx.room.RoomDatabaseKt$withTransaction$2 r2 = new androidx.room.RoomDatabaseKt$withTransaction$2
            r2.<init>(r7, r8, r5)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.j.g(r9, r2, r0)
            if (r9 != r1) goto L7e
            return r1
        L7e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt.withTransaction(androidx.room.RoomDatabase, kotlin.jvm.b.l, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
