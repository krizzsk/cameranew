package us.pinguo.repository2020.database.staticsticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$deleteCategory$1", f = "StaticStickerManager.kt", i = {0, 0, 0, 1, 1}, l = {580, 580}, m = "invokeSuspend", n = {"sidArr", "it", PGEditResultActivity2.PATH, "sidArr", "it"}, s = {"L$0", "L$2", "L$3", "L$0", "L$2"})
/* loaded from: classes6.dex */
public final class StaticStickerManager$deleteCategory$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $categoryId;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerManager$deleteCategory$1(String str, Continuation<? super StaticStickerManager$deleteCategory$1> continuation) {
        super(2, continuation);
        this.$categoryId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerManager$deleteCategory$1(this.$categoryId, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerManager$deleteCategory$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00b9 -> B:34:0x00d1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ce -> B:34:0x00d1). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$deleteCategory$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
