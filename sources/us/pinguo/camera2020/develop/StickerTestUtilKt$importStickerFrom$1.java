package us.pinguo.camera2020.develop;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* compiled from: StickerTestUtil.kt */
@DebugMetadata(c = "us.pinguo.camera2020.develop.StickerTestUtilKt$importStickerFrom$1", f = "StickerTestUtil.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {41, 43, 46, 49, 54}, m = "invokeSuspend", n = {"containerDir", "$this$forEach$iv", "it", "$this$forEach$iv", "it", "iconPath", "$this$forEach$iv", "iconPath", "stickerDisplay", "$this$forEach$iv", "iconPath", "renderData"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
final class StickerTestUtilKt$importStickerFrom$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $path;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StickerTestUtilKt$importStickerFrom$1(String str, Continuation<? super StickerTestUtilKt$importStickerFrom$1> continuation) {
        super(2, continuation);
        this.$path = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerTestUtilKt$importStickerFrom$1(this.$path, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StickerTestUtilKt$importStickerFrom$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0165 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01be  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00f9 -> B:64:0x01f7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x01af -> B:59:0x01b3). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r35) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.develop.StickerTestUtilKt$importStickerFrom$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
