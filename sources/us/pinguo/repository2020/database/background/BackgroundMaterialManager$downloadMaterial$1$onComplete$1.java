package us.pinguo.repository2020.database.background;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.u;
import kotlinx.coroutines.m0;
/* compiled from: BackgroundMaterialManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1", f = "BackgroundMaterialManager.kt", i = {2, 2, 3, 3, 5, 5, 6, 7}, l = {186, 188, 197, 198, 206, 212, 215, 220, 222, 227}, m = "invokeSuspend", n = {"suckName", "dirPath", "suckName", "dirPath", "suckName", "dirPath", "dirPath", "dirPath"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0"})
/* loaded from: classes6.dex */
final class BackgroundMaterialManager$downloadMaterial$1$onComplete$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ Background $display;
    final /* synthetic */ String $id;
    final /* synthetic */ q<Boolean, String, String, u> $resultCallback;
    final /* synthetic */ String $zPath;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundMaterialManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1$1", f = "BackgroundMaterialManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ Background $display;
        final /* synthetic */ q<Boolean, String, String, u> $resultCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(q<? super Boolean, ? super String, ? super String, u> qVar, Background background, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$resultCallback = qVar;
            this.$display = background;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$resultCallback, this.$display, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                j.b(obj);
                q<Boolean, String, String, u> qVar = this.$resultCallback;
                if (qVar == null) {
                    return null;
                }
                qVar.invoke(Boxing.boxBoolean(false), this.$display.getPid(), null);
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundMaterialManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1$2", f = "BackgroundMaterialManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ Background $display;
        final /* synthetic */ q<Boolean, String, String, u> $resultCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Background background, q<? super Boolean, ? super String, ? super String, u> qVar, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$display = background;
            this.$resultCallback = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$display, this.$resultCallback, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass2) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                j.b(obj);
                this.$display.setState(MaterialState.NOT_DOWNLOADED);
                q<Boolean, String, String, u> qVar = this.$resultCallback;
                if (qVar == null) {
                    return null;
                }
                qVar.invoke(Boxing.boxBoolean(false), this.$display.getPid(), null);
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundMaterialManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1$3", f = "BackgroundMaterialManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ Background $display;
        final /* synthetic */ q<Boolean, String, String, u> $resultCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Background background, q<? super Boolean, ? super String, ? super String, u> qVar, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$display = background;
            this.$resultCallback = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$display, this.$resultCallback, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass3) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                j.b(obj);
                this.$display.setState(MaterialState.NOT_DOWNLOADED);
                q<Boolean, String, String, u> qVar = this.$resultCallback;
                if (qVar == null) {
                    return null;
                }
                qVar.invoke(Boxing.boxBoolean(false), this.$display.getPid(), null);
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundMaterialManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1$4", f = "BackgroundMaterialManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1$4  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ String $dirPath;
        final /* synthetic */ Background $display;
        final /* synthetic */ q<Boolean, String, String, u> $resultCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(Background background, q<? super Boolean, ? super String, ? super String, u> qVar, String str, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$display = background;
            this.$resultCallback = qVar;
            this.$dirPath = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$display, this.$resultCallback, this.$dirPath, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass4) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                j.b(obj);
                this.$display.setState(MaterialState.AVAILABLE);
                q<Boolean, String, String, u> qVar = this.$resultCallback;
                if (qVar == null) {
                    return null;
                }
                qVar.invoke(Boxing.boxBoolean(true), this.$display.getPid(), this.$dirPath);
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundMaterialManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1$5", f = "BackgroundMaterialManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1$5  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass5 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ Background $display;
        final /* synthetic */ q<Boolean, String, String, u> $resultCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(Background background, q<? super Boolean, ? super String, ? super String, u> qVar, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$display = background;
            this.$resultCallback = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.$display, this.$resultCallback, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass5) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                j.b(obj);
                this.$display.setState(MaterialState.NOT_DOWNLOADED);
                q<Boolean, String, String, u> qVar = this.$resultCallback;
                if (qVar == null) {
                    return null;
                }
                qVar.invoke(Boxing.boxBoolean(false), this.$display.getPid(), null);
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundMaterialManager$downloadMaterial$1$onComplete$1(String str, Background background, String str2, q<? super Boolean, ? super String, ? super String, u> qVar, Continuation<? super BackgroundMaterialManager$downloadMaterial$1$onComplete$1> continuation) {
        super(2, continuation);
        this.$zPath = str;
        this.$display = background;
        this.$id = str2;
        this.$resultCallback = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundMaterialManager$downloadMaterial$1$onComplete$1(this.$zPath, this.$display, this.$id, this.$resultCallback, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BackgroundMaterialManager$downloadMaterial$1$onComplete$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0148 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cd A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1$onComplete$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
