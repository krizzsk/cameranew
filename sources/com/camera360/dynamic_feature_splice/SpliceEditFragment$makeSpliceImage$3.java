package com.camera360.dynamic_feature_splice;

import com.growingio.android.sdk.java_websocket.WebSocket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.g2;
import us.pinguo.picker.image.PickItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpliceEditFragment.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceEditFragment$makeSpliceImage$3", f = "SpliceEditFragment.kt", i = {0, 0, 0, 0, 0}, l = {WebSocket.DEFAULT_WSS_PORT, 484}, m = "invokeSuspend", n = {"relativePath", "outPath", "dstFile", "tempPath", "takenTimeNew"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
/* loaded from: classes8.dex */
public final class SpliceEditFragment$makeSpliceImage$3 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ long $now;
    final /* synthetic */ ArrayList<m1> $spliceInfos;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ SpliceEditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpliceEditFragment.kt */
    @DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceEditFragment$makeSpliceImage$3$1", f = "SpliceEditFragment.kt", i = {}, l = {493}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.camera360.dynamic_feature_splice.SpliceEditFragment$makeSpliceImage$3$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ long $now;
        final /* synthetic */ Pair<String, Long> $pair;
        int label;
        final /* synthetic */ SpliceEditFragment this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SpliceEditFragment.kt */
        @DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceEditFragment$makeSpliceImage$3$1$1", f = "SpliceEditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.camera360.dynamic_feature_splice.SpliceEditFragment$makeSpliceImage$3$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C00671 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
            final /* synthetic */ long $now;
            final /* synthetic */ Pair<String, Long> $pair;
            int label;
            final /* synthetic */ SpliceEditFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00671(SpliceEditFragment spliceEditFragment, long j2, Pair<String, Long> pair, Continuation<? super C00671> continuation) {
                super(2, continuation);
                this.this$0 = spliceEditFragment;
                this.$now = j2;
                this.$pair = pair;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                return new C00671(this.this$0, this.$now, this.$pair, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
                return ((C00671) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                boolean z;
                SpliceScaleType spliceScaleType;
                boolean z2;
                List list;
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    kotlin.j.b(obj);
                    z = this.this$0.f2161k;
                    if (z) {
                        return kotlin.u.a;
                    }
                    if (us.pinguo.foundation.d.f10987f) {
                        us.pinguo.foundation.utils.k0.a.d("拼图耗时:" + (System.currentTimeMillis() - this.$now) + "ms");
                    }
                    this.this$0.M0();
                    if (this.$pair == null) {
                        us.pinguo.foundation.utils.k0.a.a(vStudio.Android.Camera360.R.string.template_save_picture_fail);
                    } else {
                        l1 K0 = this.this$0.K0();
                        if (K0 != null) {
                            K0.F(new SpliceResult(0, this.$pair.getFirst(), this.$pair.getSecond().longValue()));
                        }
                        Ref$IntRef ref$IntRef = new Ref$IntRef();
                        ArrayList<PickItem> arrayList = this.this$0.b;
                        SpliceEditFragment spliceEditFragment = this.this$0;
                        for (PickItem pickItem : arrayList) {
                            list = spliceEditFragment.v;
                            Object obj2 = null;
                            if (list == null) {
                                kotlin.jvm.internal.s.z("argList");
                                throw null;
                            }
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Object next = it.next();
                                if (kotlin.jvm.internal.s.c(((PickItem) next).path, pickItem.path)) {
                                    obj2 = next;
                                    break;
                                }
                            }
                            if (obj2 == null) {
                                ref$IntRef.element++;
                            }
                        }
                        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                        String valueOf = String.valueOf(this.this$0.b.size());
                        spliceScaleType = this.this$0.u;
                        String str = spliceScaleType.getStr();
                        String valueOf2 = String.valueOf(ref$IntRef.element);
                        z2 = this.this$0.t;
                        cVar.j0(valueOf, str, valueOf2, z2 ? "1" : "0");
                    }
                    return kotlin.u.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SpliceEditFragment spliceEditFragment, long j2, Pair<String, Long> pair, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = spliceEditFragment;
            this.$now = j2;
            this.$pair = pair;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$now, this.$pair, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            boolean z;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                z = this.this$0.f2161k;
                if (z) {
                    return kotlin.u.a;
                }
                if (us.pinguo.foundation.d.f10987f) {
                    us.pinguo.foundation.utils.k0 k0Var = us.pinguo.foundation.utils.k0.a;
                    k0Var.d("拼图耗时:" + (System.currentTimeMillis() - this.$now) + "ms");
                }
                g2 c = kotlinx.coroutines.z0.c();
                C00671 c00671 = new C00671(this.this$0, this.$now, this.$pair, null);
                this.label = 1;
                if (kotlinx.coroutines.j.g(c, c00671, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceEditFragment$makeSpliceImage$3(SpliceEditFragment spliceEditFragment, ArrayList<m1> arrayList, long j2, Continuation<? super SpliceEditFragment$makeSpliceImage$3> continuation) {
        super(2, continuation);
        this.this$0 = spliceEditFragment;
        this.$spliceInfos = arrayList;
        this.$now = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new SpliceEditFragment$makeSpliceImage$3(this.this$0, this.$spliceInfos, this.$now, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((SpliceEditFragment$makeSpliceImage$3) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0201 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.camera360.dynamic_feature_splice.SpliceEditFragment$makeSpliceImage$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
