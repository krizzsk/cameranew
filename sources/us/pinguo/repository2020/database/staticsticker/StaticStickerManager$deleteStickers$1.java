package us.pinguo.repository2020.database.staticsticker;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$deleteStickers$1", f = "StaticStickerManager.kt", i = {0, 0, 0, 1, 1}, l = {600, 615}, m = "invokeSuspend", n = {"toDeleteCategoryIdSet", "toUpdateCategoryIdSet", "sid", "toDeleteCategoryIdSet", "toUpdateCategoryIdSet"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class StaticStickerManager$deleteStickers$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ List<String> $idList;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerManager$deleteStickers$1(List<String> list, Continuation<? super StaticStickerManager$deleteStickers$1> continuation) {
        super(2, continuation);
        this.$idList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerManager$deleteStickers$1(this.$idList, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerManager$deleteStickers$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0156 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015c  */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0154 -> B:7:0x0020). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$deleteStickers$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
