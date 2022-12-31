package us.pinguo.common.filter.guide;

import android.widget.FrameLayout;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterCollectionAnimControl.kt */
@DebugMetadata(c = "us.pinguo.common.filter.guide.FilterCollectionAnimControl$doArrowAnim$1", f = "FilterCollectionAnimControl.kt", i = {0, 0}, l = {254}, m = "invokeSuspend", n = {"$this$launch", "array"}, s = {"L$0", "L$1"})
/* loaded from: classes4.dex */
public final class FilterCollectionAnimControl$doArrowAnim$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ FrameLayout $fl;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterCollectionAnimControl$doArrowAnim$1(FrameLayout frameLayout, Continuation<? super FilterCollectionAnimControl$doArrowAnim$1> continuation) {
        super(2, continuation);
        this.$fl = frameLayout;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        FilterCollectionAnimControl$doArrowAnim$1 filterCollectionAnimControl$doArrowAnim$1 = new FilterCollectionAnimControl$doArrowAnim$1(this.$fl, continuation);
        filterCollectionAnimControl$doArrowAnim$1.L$0 = obj;
        return filterCollectionAnimControl$doArrowAnim$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterCollectionAnimControl$doArrowAnim$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int i2;
        FrameLayout frameLayout;
        m0 m0Var;
        float[] fArr;
        int i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            j.b(obj);
            i2 = 1000;
            frameLayout = this.$fl;
            m0Var = (m0) this.L$0;
            fArr = new float[]{0.3f, 0.6f, 1.0f};
            i3 = 0;
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            int i5 = this.I$1;
            i2 = this.I$0;
            frameLayout = (FrameLayout) this.L$2;
            fArr = (float[]) this.L$1;
            m0Var = (m0) this.L$0;
            j.b(obj);
            i3 = i5;
        }
        while (i3 < i2) {
            int i6 = i3 + 1;
            n0.c(m0Var);
            float f2 = fArr[i6 % 3];
            float f3 = fArr[(i3 + 2) % 3];
            float f4 = fArr[(i3 + 3) % 3];
            frameLayout.getChildAt(0).setAlpha(f2);
            frameLayout.getChildAt(1).setAlpha(f3);
            frameLayout.getChildAt(2).setAlpha(f4);
            this.L$0 = m0Var;
            this.L$1 = fArr;
            this.L$2 = frameLayout;
            this.I$0 = i2;
            this.I$1 = i6;
            this.label = 1;
            if (DelayKt.b(400L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i3 = i6;
        }
        return u.a;
    }
}
