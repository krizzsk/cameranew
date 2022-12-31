package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaqk implements DialogInterface.OnClickListener {
    private final /* synthetic */ String zzdpy;
    private final /* synthetic */ String zzdpz;
    private final /* synthetic */ zzaql zzdqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqk(zzaql zzaqlVar, String str, String str2) {
        this.zzdqa = zzaqlVar;
        this.zzdpy = str;
        this.zzdpz = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    @Instrumented
    public final void onClick(DialogInterface dialogInterface, int i2) {
        Context context;
        VdsAgent.onClick(this, dialogInterface, i2);
        context = this.zzdqa.context;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        try {
            String str = this.zzdpy;
            String str2 = this.zzdpz;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            com.google.android.gms.ads.internal.zzr.zzkr();
            com.google.android.gms.ads.internal.util.zzj.zza(request);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzdqa.zzds("Could not store picture.");
        }
    }
}
