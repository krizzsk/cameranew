package us.pinguo.edit2020.viewmodel.module;

import android.graphics.PointF;
import android.util.Size;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.w;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementModule.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementModule$prepareAndFillOpacity$1 extends Lambda implements w<String, Integer, Integer, Float, Float, Integer, Integer, Integer, Integer, u> {
    final /* synthetic */ l<Boolean, u> $callback;
    final /* synthetic */ String $maskPath;
    final /* synthetic */ boolean $result;
    final /* synthetic */ String $sourcePath;
    final /* synthetic */ BackgroundReplacementModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundReplacementModule.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule$prepareAndFillOpacity$1$1", f = "BackgroundReplacementModule.kt", i = {}, l = {654}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule$prepareAndFillOpacity$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        int label;
        final /* synthetic */ BackgroundReplacementModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BackgroundReplacementModule backgroundReplacementModule, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = backgroundReplacementModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                j.b(obj);
                this.label = 1;
                if (DelayKt.b(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                j.b(obj);
            }
            this.this$0.t0("photoItem");
            return u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundReplacementModule$prepareAndFillOpacity$1(BackgroundReplacementModule backgroundReplacementModule, l<? super Boolean, u> lVar, boolean z, String str, String str2) {
        super(9);
        this.this$0 = backgroundReplacementModule;
        this.$callback = lVar;
        this.$result = z;
        this.$sourcePath = str;
        this.$maskPath = str2;
    }

    @Override // kotlin.jvm.b.w
    public /* bridge */ /* synthetic */ u invoke(String str, Integer num, Integer num2, Float f2, Float f3, Integer num3, Integer num4, Integer num5, Integer num6) {
        invoke(str, num.intValue(), num2.intValue(), f2.floatValue(), f3.floatValue(), num3.intValue(), num4.intValue(), num5.intValue(), num6.intValue());
        return u.a;
    }

    public final void invoke(String cutPath, int i2, int i3, float f2, float f3, int i4, int i5, int i6, int i7) {
        boolean z;
        s.h(cutPath, "cutPath");
        z = this.this$0.s;
        if (z) {
            this.this$0.s = false;
            kotlin.jvm.b.a<u> X = this.this$0.X();
            if (X != null) {
                X.invoke();
            }
        } else {
            this.$callback.invoke(Boolean.valueOf(this.$result));
        }
        this.this$0.r = new BackgroundReplacementModule.a(cutPath, new Size(i2, i3), new PointF(f2 / i4, 1 - (f3 / i5)), this.$sourcePath, new Size(i4, i5), this.$maskPath, new Size(i6, i7));
        us.pinguo.edit2020.bean.f R = this.this$0.R();
        this.this$0.D(R == null ? null : R.f());
        kotlinx.coroutines.l.d(n0.a(z0.a()), null, null, new AnonymousClass1(this.this$0, null), 3, null);
    }
}
