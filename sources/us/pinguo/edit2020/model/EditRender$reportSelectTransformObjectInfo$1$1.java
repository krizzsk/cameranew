package us.pinguo.edit2020.model;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.b.v;
import kotlin.u;
import kotlinx.coroutines.m0;
/* compiled from: EditRender.kt */
@DebugMetadata(c = "us.pinguo.edit2020.model.EditRender$reportSelectTransformObjectInfo$1$1", f = "EditRender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class EditRender$reportSelectTransformObjectInfo$1$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ float $cx;
    final /* synthetic */ float $cy;
    final /* synthetic */ float $degree;
    final /* synthetic */ float $height;
    final /* synthetic */ v<String, Integer, Boolean, Float, Float, Float, Float, Float, u> $it;
    final /* synthetic */ int $mode;
    final /* synthetic */ boolean $needDelta;
    final /* synthetic */ String $uid;
    final /* synthetic */ float $width;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EditRender$reportSelectTransformObjectInfo$1$1(v<? super String, ? super Integer, ? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, u> vVar, String str, int i2, boolean z, float f2, float f3, float f4, float f5, float f6, Continuation<? super EditRender$reportSelectTransformObjectInfo$1$1> continuation) {
        super(2, continuation);
        this.$it = vVar;
        this.$uid = str;
        this.$mode = i2;
        this.$needDelta = z;
        this.$cx = f2;
        this.$cy = f3;
        this.$width = f4;
        this.$height = f5;
        this.$degree = f6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditRender$reportSelectTransformObjectInfo$1$1(this.$it, this.$uid, this.$mode, this.$needDelta, this.$cx, this.$cy, this.$width, this.$height, this.$degree, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditRender$reportSelectTransformObjectInfo$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            j.b(obj);
            this.$it.invoke(this.$uid, Boxing.boxInt(this.$mode), Boxing.boxBoolean(this.$needDelta), Boxing.boxFloat(this.$cx), Boxing.boxFloat(this.$cy), Boxing.boxFloat(this.$width), Boxing.boxFloat(this.$height), Boxing.boxFloat(this.$degree));
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
