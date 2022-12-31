package us.pinguo.repository2020.database.staticsticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$loadStickerAsync$1", f = "StaticStickerManager.kt", i = {}, l = {267, 268}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class StaticStickerManager$loadStickerAsync$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ kotlin.jvm.b.l<Exception, u> $callback;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerManager.kt */
    /* renamed from: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$loadStickerAsync$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends Lambda implements p<StaticStickerJson, Exception, u> {
        final /* synthetic */ kotlin.jvm.b.l<Exception, u> $callback;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StaticStickerManager.kt */
        @DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$loadStickerAsync$1$1$1", f = "StaticStickerManager.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$loadStickerAsync$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C04361 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
            final /* synthetic */ kotlin.jvm.b.l<Exception, u> $callback;
            final /* synthetic */ Exception $e;
            final /* synthetic */ StaticStickerJson $stickerJson;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C04361(StaticStickerJson staticStickerJson, Exception exc, kotlin.jvm.b.l<? super Exception, u> lVar, Continuation<? super C04361> continuation) {
                super(2, continuation);
                this.$stickerJson = staticStickerJson;
                this.$e = exc;
                this.$callback = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                return new C04361(this.$stickerJson, this.$e, this.$callback, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
                return ((C04361) create(m0Var, continuation)).invokeSuspend(u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                Object E;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = this.label;
                if (i2 == 0) {
                    kotlin.j.b(obj);
                    StaticStickerManager staticStickerManager = StaticStickerManager.a;
                    boolean z = this.$stickerJson == null || this.$e != null;
                    this.label = 1;
                    E = staticStickerManager.E(z, this);
                    if (E == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    kotlin.j.b(obj);
                }
                kotlin.jvm.b.l<Exception, u> lVar = this.$callback;
                if (lVar != null) {
                    lVar.invoke(this.$e);
                }
                return u.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(kotlin.jvm.b.l<? super Exception, u> lVar) {
            super(2);
            this.$callback = lVar;
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ u invoke(StaticStickerJson staticStickerJson, Exception exc) {
            invoke2(staticStickerJson, exc);
            return u.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(StaticStickerJson staticStickerJson, Exception exc) {
            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new C04361(staticStickerJson, exc, this.$callback, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StaticStickerManager$loadStickerAsync$1(kotlin.jvm.b.l<? super Exception, u> lVar, Continuation<? super StaticStickerManager$loadStickerAsync$1> continuation) {
        super(2, continuation);
        this.$callback = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerManager$loadStickerAsync$1(this.$callback, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerManager$loadStickerAsync$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.j.b(r5)
            goto L4a
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.j.b(r5)
            goto L36
        L1e:
            kotlin.j.b(r5)
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager r5 = us.pinguo.repository2020.database.staticsticker.StaticStickerManager.a
            java.lang.String r5 = r5.u()
            java.lang.String r1 = "static_sticker_list.json"
            java.lang.String r5 = kotlin.jvm.internal.s.q(r5, r1)
            r4.label = r3
            java.lang.Object r5 = us.pinguo.util.FileUtils.q(r5, r4)
            if (r5 != r0) goto L36
            return r0
        L36:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r1 = 0
            if (r5 == 0) goto L54
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager r5 = us.pinguo.repository2020.database.staticsticker.StaticStickerManager.a
            r4.label = r2
            java.lang.Object r5 = us.pinguo.repository2020.database.staticsticker.StaticStickerManager.g(r5, r1, r4)
            if (r5 != r0) goto L4a
            return r0
        L4a:
            kotlin.jvm.b.l<java.lang.Exception, kotlin.u> r5 = r4.$callback
            if (r5 != 0) goto L4f
            goto L60
        L4f:
            r0 = 0
            r5.invoke(r0)
            goto L60
        L54:
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager r5 = us.pinguo.repository2020.database.staticsticker.StaticStickerManager.a
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager$loadStickerAsync$1$1 r0 = new us.pinguo.repository2020.database.staticsticker.StaticStickerManager$loadStickerAsync$1$1
            kotlin.jvm.b.l<java.lang.Exception, kotlin.u> r2 = r4.$callback
            r0.<init>(r2)
            r5.o(r1, r0)
        L60:
            kotlin.u r5 = kotlin.u.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$loadStickerAsync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
