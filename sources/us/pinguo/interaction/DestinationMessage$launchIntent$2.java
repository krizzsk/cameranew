package us.pinguo.interaction;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.internal.Lambda;
/* compiled from: DestinationMessage.kt */
/* loaded from: classes4.dex */
final class DestinationMessage$launchIntent$2 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ Activity $context;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ int $requestCode;
    final /* synthetic */ Uri $uri;
    final /* synthetic */ DestinationMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DestinationMessage$launchIntent$2(DestinationMessage destinationMessage, Uri uri, Activity activity, Intent intent, int i2) {
        super(0);
        this.this$0 = destinationMessage;
        this.$uri = uri;
        this.$context = activity;
        this.$intent = intent;
        this.$requestCode = i2;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        super/*us.pinguo.foundation.interaction.b*/.e(this.$uri, this.$context, this.$intent, this.$requestCode);
    }
}
