package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.p;
/* loaded from: classes2.dex */
final class b extends ResultReceiver {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Handler handler, p pVar) {
        super(handler);
        this.a = pVar;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i2, Bundle bundle) {
        this.a.e(null);
    }
}
