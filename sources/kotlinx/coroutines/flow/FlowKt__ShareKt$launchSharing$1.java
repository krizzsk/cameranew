package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
/* compiled from: Share.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {}, l = {206, 210, 211, 217}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ T $initialValue;
    final /* synthetic */ x0<T> $shared;
    final /* synthetic */ e1 $started;
    final /* synthetic */ c<T> $upstream;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Share.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<Integer, Continuation<? super Boolean>, Object> {
        /* synthetic */ int I$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.I$0 = ((Number) obj).intValue();
            return anonymousClass1;
        }

        public final Object invoke(int i2, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(Integer.valueOf(i2), continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Boolean> continuation) {
            return invoke(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                return Boxing.boxBoolean(this.I$0 > 0);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Share.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements kotlin.jvm.b.p<SharingCommand, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ T $initialValue;
        final /* synthetic */ x0<T> $shared;
        final /* synthetic */ c<T> $upstream;
        /* synthetic */ Object L$0;
        int label;

        /* compiled from: Share.kt */
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$a */
        /* loaded from: classes3.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[SharingCommand.values().length];
                iArr[SharingCommand.START.ordinal()] = 1;
                iArr[SharingCommand.STOP.ordinal()] = 2;
                iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(c<? extends T> cVar, x0<T> x0Var, T t, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$upstream = cVar;
            this.$shared = x0Var;
            this.$initialValue = t;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ Object invoke(SharingCommand sharingCommand, Continuation<? super kotlin.u> continuation) {
            return invoke2(sharingCommand, continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(SharingCommand sharingCommand, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass2) create(sharingCommand, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                int i3 = a.a[((SharingCommand) this.L$0).ordinal()];
                if (i3 == 1) {
                    c<T> cVar = this.$upstream;
                    d dVar = this.$shared;
                    this.label = 1;
                    if (cVar.d(dVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 3) {
                    T t = this.$initialValue;
                    if (t == d1.a) {
                        this.$shared.h();
                    } else {
                        this.$shared.a(t);
                    }
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            return kotlin.u.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ShareKt$launchSharing$1(e1 e1Var, c<? extends T> cVar, x0<T> x0Var, T t, Continuation<? super FlowKt__ShareKt$launchSharing$1> continuation) {
        super(2, continuation);
        this.$started = e1Var;
        this.$upstream = cVar;
        this.$shared = x0Var;
        this.$initialValue = t;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, continuation);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return invoke2(m0Var, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((FlowKt__ShareKt$launchSharing$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L25
            if (r1 == r5) goto L21
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L21
            if (r1 != r2) goto L15
            goto L21
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1d:
            kotlin.j.b(r8)
            goto L5c
        L21:
            kotlin.j.b(r8)
            goto L8d
        L25:
            kotlin.j.b(r8)
            kotlinx.coroutines.flow.e1 r8 = r7.$started
            kotlinx.coroutines.flow.e1$a r1 = kotlinx.coroutines.flow.e1.a
            kotlinx.coroutines.flow.e1 r6 = r1.a()
            if (r8 != r6) goto L3f
            kotlinx.coroutines.flow.c<T> r8 = r7.$upstream
            kotlinx.coroutines.flow.x0<T> r1 = r7.$shared
            r7.label = r5
            java.lang.Object r8 = r8.d(r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L3f:
            kotlinx.coroutines.flow.e1 r8 = r7.$started
            kotlinx.coroutines.flow.e1 r1 = r1.b()
            r5 = 0
            if (r8 != r1) goto L69
            kotlinx.coroutines.flow.x0<T> r8 = r7.$shared
            kotlinx.coroutines.flow.h1 r8 = r8.c()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r1.<init>(r5)
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.e.n(r8, r1, r7)
            if (r8 != r0) goto L5c
            return r0
        L5c:
            kotlinx.coroutines.flow.c<T> r8 = r7.$upstream
            kotlinx.coroutines.flow.x0<T> r1 = r7.$shared
            r7.label = r3
            java.lang.Object r8 = r8.d(r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L69:
            kotlinx.coroutines.flow.e1 r8 = r7.$started
            kotlinx.coroutines.flow.x0<T> r1 = r7.$shared
            kotlinx.coroutines.flow.h1 r1 = r1.c()
            kotlinx.coroutines.flow.c r8 = r8.a(r1)
            kotlinx.coroutines.flow.c r8 = kotlinx.coroutines.flow.e.i(r8)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            kotlinx.coroutines.flow.c<T> r3 = r7.$upstream
            kotlinx.coroutines.flow.x0<T> r4 = r7.$shared
            T r6 = r7.$initialValue
            r1.<init>(r3, r4, r6, r5)
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.flow.e.f(r8, r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L8d:
            kotlin.u r8 = kotlin.u.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
