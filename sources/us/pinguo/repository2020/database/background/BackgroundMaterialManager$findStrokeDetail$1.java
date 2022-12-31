package us.pinguo.repository2020.database.background;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundMaterialManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.background.BackgroundMaterialManager", f = "BackgroundMaterialManager.kt", i = {0}, l = {370}, m = "findStrokeDetail", n = {"jsonPath"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class BackgroundMaterialManager$findStrokeDetail$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BackgroundMaterialManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundMaterialManager$findStrokeDetail$1(BackgroundMaterialManager backgroundMaterialManager, Continuation<? super BackgroundMaterialManager$findStrokeDetail$1> continuation) {
        super(continuation);
        this.this$0 = backgroundMaterialManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, this);
    }
}
