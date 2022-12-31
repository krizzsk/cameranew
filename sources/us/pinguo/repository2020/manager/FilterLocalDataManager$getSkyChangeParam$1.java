package us.pinguo.repository2020.manager;

import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterLocalDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterLocalDataManager", f = "FilterLocalDataManager.kt", i = {}, l = {BaseBlurEffect.ROTATION_270}, m = "getSkyChangeParam", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FilterLocalDataManager$getSkyChangeParam$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilterLocalDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterLocalDataManager$getSkyChangeParam$1(FilterLocalDataManager filterLocalDataManager, Continuation<? super FilterLocalDataManager$getSkyChangeParam$1> continuation) {
        super(continuation);
        this.this$0 = filterLocalDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r(null, this);
    }
}
