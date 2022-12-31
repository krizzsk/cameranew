package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.b.p;
import kotlin.sequences.g;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewGroup.kt */
@DebugMetadata(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", i = {0, 0, 0, 1, 1}, l = {97, 99}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "child", "$this$sequence", "$this$forEach$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: classes.dex */
public final class ViewGroupKt$descendants$1 extends RestrictedSuspendLambda implements p<g<? super View>, Continuation<? super u>, Object> {
    final /* synthetic */ ViewGroup $this_descendants;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGroupKt$descendants$1(ViewGroup viewGroup, Continuation<? super ViewGroupKt$descendants$1> continuation) {
        super(2, continuation);
        this.$this_descendants = viewGroup;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1 = new ViewGroupKt$descendants$1(this.$this_descendants, continuation);
        viewGroupKt$descendants$1.L$0 = obj;
        return viewGroupKt$descendants$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(g<? super View> gVar, Continuation<? super u> continuation) {
        return ((ViewGroupKt$descendants$1) create(gVar, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009c, code lost:
        if (r4 >= r5) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0091 -> B:23:0x0093). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0099 -> B:25:0x009c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3e
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r10.I$1
            int r4 = r10.I$0
            java.lang.Object r5 = r10.L$1
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            java.lang.Object r6 = r10.L$0
            kotlin.sequences.g r6 = (kotlin.sequences.g) r6
            kotlin.j.b(r11)
            r7 = r10
            goto L93
        L20:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L28:
            int r1 = r10.I$1
            int r4 = r10.I$0
            java.lang.Object r5 = r10.L$2
            android.view.View r5 = (android.view.View) r5
            java.lang.Object r6 = r10.L$1
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            java.lang.Object r7 = r10.L$0
            kotlin.sequences.g r7 = (kotlin.sequences.g) r7
            kotlin.j.b(r11)
            r11 = r7
            r7 = r10
            goto L73
        L3e:
            kotlin.j.b(r11)
            java.lang.Object r11 = r10.L$0
            kotlin.sequences.g r11 = (kotlin.sequences.g) r11
            android.view.ViewGroup r1 = r10.$this_descendants
            r4 = 0
            int r5 = r1.getChildCount()
            if (r5 <= 0) goto L9e
            r6 = r10
        L4f:
            int r7 = r4 + 1
            android.view.View r4 = r1.getChildAt(r4)
            java.lang.String r8 = "getChildAt(index)"
            kotlin.jvm.internal.s.g(r4, r8)
            r6.L$0 = r11
            r6.L$1 = r1
            r6.L$2 = r4
            r6.I$0 = r7
            r6.I$1 = r5
            r6.label = r3
            java.lang.Object r8 = r11.a(r4, r6)
            if (r8 != r0) goto L6d
            return r0
        L6d:
            r9 = r6
            r6 = r1
            r1 = r5
            r5 = r4
            r4 = r7
            r7 = r9
        L73:
            boolean r8 = r5 instanceof android.view.ViewGroup
            if (r8 == 0) goto L99
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            kotlin.sequences.e r5 = androidx.core.view.ViewGroupKt.getDescendants(r5)
            r7.L$0 = r11
            r7.L$1 = r6
            r8 = 0
            r7.L$2 = r8
            r7.I$0 = r4
            r7.I$1 = r1
            r7.label = r2
            java.lang.Object r5 = r11.d(r5, r7)
            if (r5 != r0) goto L91
            return r0
        L91:
            r5 = r6
            r6 = r11
        L93:
            r11 = r6
            r6 = r7
            r9 = r5
            r5 = r1
            r1 = r9
            goto L9c
        L99:
            r5 = r1
            r1 = r6
            r6 = r7
        L9c:
            if (r4 < r5) goto L4f
        L9e:
            kotlin.u r11 = kotlin.u.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewGroupKt$descendants$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
