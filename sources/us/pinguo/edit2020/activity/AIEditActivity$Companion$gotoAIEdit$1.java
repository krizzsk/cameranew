package us.pinguo.edit2020.activity;

import android.content.Context;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.g;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
/* compiled from: AIEditActivity.kt */
@DebugMetadata(c = "us.pinguo.edit2020.activity.AIEditActivity$Companion$gotoAIEdit$1", f = "AIEditActivity.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class AIEditActivity$Companion$gotoAIEdit$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ Context $cxt;
    final /* synthetic */ int $ori;
    final /* synthetic */ String $path;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AIEditActivity.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.activity.AIEditActivity$Companion$gotoAIEdit$1$1", f = "AIEditActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.activity.AIEditActivity$Companion$gotoAIEdit$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ Context $cxt;
        final /* synthetic */ String $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$cxt = context;
            this.$path = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$cxt, this.$path, continuation);
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
                AIEditActivity.a.a(this.$cxt, (r13 & 2) != 0 ? null : this.$path, (r13 & 4) != 0 ? false : false, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? false : false);
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AIEditActivity$Companion$gotoAIEdit$1(String str, int i2, Context context, Continuation<? super AIEditActivity$Companion$gotoAIEdit$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$ori = i2;
        this.$cxt = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new AIEditActivity$Companion$gotoAIEdit$1(this.$path, this.$ori, this.$cxt, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((AIEditActivity$Companion$gotoAIEdit$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        byte[] a;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            if (!new File(this.$path).exists()) {
                return u.a;
            }
            if (this.$ori != 0) {
                us.pinguo.image.saver.e.a aVar = new us.pinguo.image.saver.e.a(null);
                aVar.l(this.$ori);
                a = g.a(new File(this.$path));
                try {
                    us.pinguo.util.j.a(a, this.$path, aVar.d());
                } catch (Exception unused) {
                }
            }
            g2 c = z0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$cxt, this.$path, null);
            this.label = 1;
            if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        return u.a;
    }
}
