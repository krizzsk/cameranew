package us.pinguo.interaction;

import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.internal.Lambda;
import us.pinguo.foundation.base.InspireRedirectActivity;
/* compiled from: DestinationMessage.kt */
/* loaded from: classes4.dex */
final class DestinationMessage$launchIntent$3 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ InspireRedirectActivity $context;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ us.pinguo.foundation.proxy.c $onActivityResult;
    final /* synthetic */ Uri $uri;
    final /* synthetic */ DestinationMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DestinationMessage$launchIntent$3(DestinationMessage destinationMessage, Uri uri, InspireRedirectActivity inspireRedirectActivity, Intent intent, us.pinguo.foundation.proxy.c cVar) {
        super(0);
        this.this$0 = destinationMessage;
        this.$uri = uri;
        this.$context = inspireRedirectActivity;
        this.$intent = intent;
        this.$onActivityResult = cVar;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        super/*us.pinguo.foundation.interaction.b*/.f(this.$uri, this.$context, this.$intent, this.$onActivityResult);
    }
}
