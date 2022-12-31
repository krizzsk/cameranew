package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class h implements Runnable {
    final /* synthetic */ Context a;
    private final /* synthetic */ String b;
    private final /* synthetic */ boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ boolean f3467d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(zzam zzamVar, Context context, String str, boolean z, boolean z2) {
        this.a = context;
        this.b = str;
        this.c = z;
        this.f3467d = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setMessage(this.b);
        if (this.c) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        if (this.f3467d) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new i(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        AlertDialog create = builder.create();
        create.show();
        VdsAgent.showDialog(create);
    }
}
