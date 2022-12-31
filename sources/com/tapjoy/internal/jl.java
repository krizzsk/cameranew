package com.tapjoy.internal;

import android.app.RemoteInput;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import java.util.Set;
/* loaded from: classes3.dex */
public final class jl {
    final String a;
    final CharSequence b;
    final CharSequence[] c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f7761d;

    /* renamed from: e  reason: collision with root package name */
    final Bundle f7762e;

    /* renamed from: f  reason: collision with root package name */
    final Set f7763f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(20)
    public static RemoteInput[] a(jl[] jlVarArr) {
        if (jlVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[jlVarArr.length];
        for (int i2 = 0; i2 < jlVarArr.length; i2++) {
            jl jlVar = jlVarArr[i2];
            remoteInputArr[i2] = new RemoteInput.Builder(jlVar.a).setLabel(jlVar.b).setChoices(jlVar.c).setAllowFreeFormInput(jlVar.f7761d).addExtras(jlVar.f7762e).build();
        }
        return remoteInputArr;
    }
}
