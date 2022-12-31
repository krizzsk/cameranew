package us.pinguo.repository2020.database.background;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundMaterialManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.background.BackgroundMaterialManager", f = "BackgroundMaterialManager.kt", i = {0, 0}, l = {157}, m = "loadTemplateData", n = {"displayResponseJson", "it"}, s = {"L$0", "L$2"})
/* loaded from: classes6.dex */
public final class BackgroundMaterialManager$loadTemplateData$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BackgroundMaterialManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundMaterialManager$loadTemplateData$1(BackgroundMaterialManager backgroundMaterialManager, Continuation<? super BackgroundMaterialManager$loadTemplateData$1> continuation) {
        super(continuation);
        this.this$0 = backgroundMaterialManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m(this);
    }
}
