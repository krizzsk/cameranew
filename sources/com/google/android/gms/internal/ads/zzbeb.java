package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.p;
import com.google.android.gms.dynamic.b;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public interface zzbeb extends com.google.android.gms.ads.internal.zzm, zzaki, zzakw, zzbbo, zzbdu, zzbfa, zzbfd, zzbfh, zzbfl, zzbfm, zzbfo, zzqw, zzvc {
    void destroy();

    @Override // com.google.android.gms.internal.ads.zzbbo, com.google.android.gms.internal.ads.zzbfd
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    @Override // com.google.android.gms.internal.ads.zzbfo
    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i2, int i3);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzbbo
    void setBackgroundColor(int i2);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i2);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar);

    void zza(zzaea zzaeaVar);

    void zza(zzaef zzaefVar);

    @Override // com.google.android.gms.internal.ads.zzbbo
    void zza(zzbev zzbevVar);

    void zza(zzbft zzbftVar);

    void zza(zzdmw zzdmwVar, zzdnb zzdnbVar);

    void zza(zzsh zzshVar);

    void zza(String str, p<zzaif<? super zzbeb>> pVar);

    void zza(String str, zzaif<? super zzbeb> zzaifVar);

    @Override // com.google.android.gms.internal.ads.zzbbo
    void zza(String str, zzbdd zzbddVar);

    @Override // com.google.android.gms.internal.ads.zzbbo
    @Nullable
    zzbev zzabc();

    @Override // com.google.android.gms.internal.ads.zzbbo, com.google.android.gms.internal.ads.zzbfd
    Activity zzabe();

    @Override // com.google.android.gms.internal.ads.zzbbo
    com.google.android.gms.ads.internal.zzb zzabf();

    @Override // com.google.android.gms.internal.ads.zzbbo
    zzacd zzabi();

    @Override // com.google.android.gms.internal.ads.zzbbo, com.google.android.gms.internal.ads.zzbfl
    zzazn zzabj();

    @Override // com.google.android.gms.internal.ads.zzbdu
    zzdmw zzacp();

    void zzacq();

    void zzacr();

    Context zzacs();

    com.google.android.gms.ads.internal.overlay.zzc zzact();

    com.google.android.gms.ads.internal.overlay.zzc zzacu();

    @Override // com.google.android.gms.internal.ads.zzbfj
    zzbft zzacv();

    String zzacw();

    @Nullable
    zzbfn zzacx();

    WebViewClient zzacy();

    boolean zzacz();

    @Override // com.google.android.gms.internal.ads.zzbfm
    zzei zzada();

    @Nullable
    b zzadb();

    boolean zzadc();

    void zzadd();

    boolean zzade();

    boolean zzadf();

    void zzadg();

    void zzadh();

    zzaef zzadi();

    void zzadj();

    void zzadk();

    zzsh zzadl();

    boolean zzadm();

    @Override // com.google.android.gms.internal.ads.zzbfa
    zzdnb zzadn();

    void zzam(boolean z);

    void zzaq(b bVar);

    void zzay(boolean z);

    void zzaz(boolean z);

    void zzb(com.google.android.gms.ads.internal.overlay.zzc zzcVar);

    void zzb(String str, zzaif<? super zzbeb> zzaifVar);

    void zzb(String str, String str2, @Nullable String str3);

    boolean zzb(boolean z, int i2);

    void zzba(boolean z);

    void zzbb(boolean z);

    void zzbv(Context context);

    void zzdu(int i2);

    void zzwb();
}
