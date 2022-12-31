package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.tauth.AuthActivity;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class zzwc {
    private final zzvj zzcix;
    private final zzvk zzciy;
    private final zzzz zzciz;
    private final zzagv zzcja;
    private final zzauy zzcjb;
    private final zzawc zzcjc;
    private final zzarp zzcjd;
    private final zzagu zzcje;

    public zzwc(zzvj zzvjVar, zzvk zzvkVar, zzzz zzzzVar, zzagv zzagvVar, zzauy zzauyVar, zzawc zzawcVar, zzarp zzarpVar, zzagu zzaguVar) {
        this.zzcix = zzvjVar;
        this.zzciy = zzvkVar;
        this.zzciz = zzzzVar;
        this.zzcja = zzagvVar;
        this.zzcjb = zzauyVar;
        this.zzcjc = zzawcVar;
        this.zzcjd = zzarpVar;
        this.zzcje = zzaguVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(AuthActivity.ACTION_KEY, "no_ads_fallback");
        bundle.putString("flow", str);
        zzwr.zzqn().zza(context, zzwr.zzqt().zzbrp, "gmob-apps", bundle, true);
    }

    public final zzxl zzb(Context context, zzvs zzvsVar, String str, zzane zzaneVar) {
        return new zzwm(this, context, zzvsVar, str, zzaneVar).zzd(context, false);
    }

    public final zzavm zzc(Context context, String str, zzane zzaneVar) {
        return new zzwe(this, context, str, zzaneVar).zzd(context, false);
    }

    public final zzxi zzb(Context context, String str, zzane zzaneVar) {
        return new zzwl(this, context, str, zzaneVar).zzd(context, false);
    }

    public final zzxl zza(Context context, zzvs zzvsVar, String str, zzane zzaneVar) {
        return new zzwk(this, context, zzvsVar, str, zzaneVar).zzd(context, false);
    }

    @Nullable
    public final zzaro zzb(Activity activity) {
        zzwd zzwdVar = new zzwd(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzazk.zzev("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return zzwdVar.zzd(activity, z);
    }

    public final zzaev zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return new zzwn(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzaey zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return new zzwq(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    @Nullable
    public final zzarf zzb(Context context, zzane zzaneVar) {
        return new zzwi(this, context, zzaneVar).zzd(context, false);
    }

    @Nullable
    public final zzaxy zza(Context context, zzane zzaneVar) {
        return new zzwg(this, context, zzaneVar).zzd(context, false);
    }
}
