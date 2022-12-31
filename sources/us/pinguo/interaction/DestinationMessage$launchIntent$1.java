package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.internal.Lambda;
/* compiled from: DestinationMessage.kt */
/* loaded from: classes4.dex */
final class DestinationMessage$launchIntent$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ Uri $uri;
    final /* synthetic */ DestinationMessage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DestinationMessage$launchIntent$1(DestinationMessage destinationMessage, Uri uri, Context context, Intent intent) {
        super(0);
        this.this$0 = destinationMessage;
        this.$uri = uri;
        this.$context = context;
        this.$intent = intent;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        super/*us.pinguo.foundation.interaction.b*/.b(this.$uri, this.$context, this.$intent);
    }
}
