package d.c.a.d.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b extends BroadcastReceiver {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(c cVar) {
        this.a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        this.a.a(context, intent);
    }
}
