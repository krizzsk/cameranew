package us.pinguo.edit2020.viewmodel.module;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.database.staticsticker.StaticStickerDetail;
import us.pinguo.repository2020.database.staticsticker.Template;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.StaticStickerModule$applyTemplate$1", f = "StaticStickerModule.kt", i = {0}, l = {535}, m = "invokeSuspend", n = {"$this$forEach$iv"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class StaticStickerModule$applyTemplate$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ StaticStickerDetail[] $detailList;
    final /* synthetic */ boolean $history;
    final /* synthetic */ Template $template;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ StaticStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerModule$applyTemplate$1(StaticStickerModule staticStickerModule, StaticStickerDetail[] staticStickerDetailArr, Template template, boolean z, Continuation<? super StaticStickerModule$applyTemplate$1> continuation) {
        super(2, continuation);
        this.this$0 = staticStickerModule;
        this.$detailList = staticStickerDetailArr;
        this.$template = template;
        this.$history = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerModule$applyTemplate$1(this.this$0, this.$detailList, this.$template, this.$history, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerModule$applyTemplate$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00b6 -> B:32:0x00be). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.StaticStickerModule$applyTemplate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
