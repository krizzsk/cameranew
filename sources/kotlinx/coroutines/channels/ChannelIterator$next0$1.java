package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ChannelIterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channel.kt */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {585}, m = "next", n = {"this"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class ChannelIterator$next0$1<E> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelIterator$next0$1(Continuation<? super ChannelIterator$next0$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelIterator.DefaultImpls.a(null, this);
    }
}
