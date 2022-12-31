package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.p;
/* loaded from: classes2.dex */
final class c extends ResultReceiver {
    final /* synthetic */ p a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i2, Bundle bundle) {
        p pVar;
        int i3 = 1;
        if (i2 == 1) {
            pVar = this.a;
            i3 = -1;
        } else if (i2 != 2) {
            pVar = this.a;
        } else {
            pVar = this.a;
            i3 = 0;
        }
        pVar.e(Integer.valueOf(i3));
    }
}
