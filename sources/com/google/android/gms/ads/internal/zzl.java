package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzaau;
import com.google.android.gms.internal.ads.zzacl;
import com.google.android.gms.internal.ads.zzadb;
import com.google.android.gms.internal.ads.zzary;
import com.google.android.gms.internal.ads.zzase;
import com.google.android.gms.internal.ads.zzauu;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzazn;
import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzeh;
import com.google.android.gms.internal.ads.zzei;
import com.google.android.gms.internal.ads.zzsp;
import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvs;
import com.google.android.gms.internal.ads.zzvx;
import com.google.android.gms.internal.ads.zzwr;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzwx;
import com.google.android.gms.internal.ads.zzxc;
import com.google.android.gms.internal.ads.zzxo;
import com.google.android.gms.internal.ads.zzxs;
import com.google.android.gms.internal.ads.zzxt;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyb;
import com.google.android.gms.internal.ads.zzyw;
import com.google.android.gms.internal.ads.zzyx;
import com.google.android.gms.internal.ads.zzzc;
import com.google.android.gms.internal.ads.zzzi;
import com.growingio.android.sdk.collection.Constants;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzl extends zzxo {
    private final zzazn a;
    private final zzvs b;
    private final Future<zzei> c = zzazp.zzeic.zze(new g(this));

    /* renamed from: d  reason: collision with root package name */
    private final Context f3510d;

    /* renamed from: e  reason: collision with root package name */
    private final h f3511e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private WebView f3512f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private zzwx f3513g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private zzei f3514h;

    /* renamed from: i  reason: collision with root package name */
    private AsyncTask<Void, Void, String> f3515i;

    public zzl(Context context, zzvs zzvsVar, String str, zzazn zzaznVar) {
        this.f3510d = context;
        this.a = zzaznVar;
        this.b = zzvsVar;
        this.f3512f = new WebView(context);
        this.f3511e = new h(context, str);
        F0(0);
        this.f3512f.setVerticalScrollBarEnabled(false);
        this.f3512f.getSettings().setJavaScriptEnabled(true);
        this.f3512f.setWebViewClient(new e(this));
        this.f3512f.setOnTouchListener(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String D0(String str) {
        if (this.f3514h == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.f3514h.zza(parse, this.f3510d, null, null);
        } catch (zzeh e2) {
            zzazk.zzd("Unable to process ad data", e2);
        }
        return parse.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.f3510d.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int C0(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzwr.zzqn();
            return zzaza.zze(this.f3510d, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void F0(int i2) {
        if (this.f3512f == null) {
            return;
        }
        this.f3512f.setLayoutParams(new ViewGroup.LayoutParams(-1, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String K0() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(Constants.HTTPS_PROTOCOL_PREFIX).appendEncodedPath(zzadb.zzdcr.get());
        builder.appendQueryParameter("query", this.f3511e.a());
        builder.appendQueryParameter("pubId", this.f3511e.d());
        Map<String, String> e2 = this.f3511e.e();
        for (String str : e2.keySet()) {
            builder.appendQueryParameter(str, e2.get(str));
        }
        Uri build = builder.build();
        zzei zzeiVar = this.f3514h;
        if (zzeiVar != null) {
            try {
                build = zzeiVar.zza(build, this.f3510d);
            } catch (zzeh e3) {
                zzazk.zzd("Unable to process ad data", e3);
            }
        }
        String L0 = L0();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(L0).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(L0);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String L0() {
        String c = this.f3511e.c();
        if (TextUtils.isEmpty(c)) {
            c = "www.google.com";
        }
        String str = zzadb.zzdcr.get();
        StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 8 + String.valueOf(str).length());
        sb.append(Constants.HTTPS_PROTOCOL_PREFIX);
        sb.append(c);
        sb.append(str);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void destroy() throws RemoteException {
        q.e("destroy must be called on the main UI thread.");
        this.f3515i.cancel(true);
        this.c.cancel(true);
        this.f3512f.destroy();
        this.f3512f = null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    @Nullable
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    @Nullable
    public final zzzc getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void pause() throws RemoteException {
        q.e("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void resume() throws RemoteException {
        q.e("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzvl zzvlVar, zzxc zzxcVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyb zzybVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyw zzywVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean zza(zzvl zzvlVar) throws RemoteException {
        q.k(this.f3512f, "This Search Ad has already been torn down");
        this.f3511e.b(zzvlVar, this.a);
        this.f3515i = new f(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzbl(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zze(com.google.android.gms.dynamic.b bVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final com.google.android.gms.dynamic.b zzke() throws RemoteException {
        q.e("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.d.z0(this.f3512f);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzkf() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzvs zzkg() throws RemoteException {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    @Nullable
    public final String zzkh() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    @Nullable
    public final zzyx zzki() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxt zzkj() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzwx zzkk() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwx zzwxVar) throws RemoteException {
        this.f3513g = zzwxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxt zzxtVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxs zzxsVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzvs zzvsVar) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzary zzaryVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzase zzaseVar, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzacl zzaclVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzww zzwwVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxz zzxzVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzauu zzauuVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzaau zzaauVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzzi zzziVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzvx zzvxVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzsp zzspVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
}
