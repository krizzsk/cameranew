package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.util.p;
import com.google.android.gms.dynamic.b;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbeq extends FrameLayout implements zzbeb {
    private final zzbeb zzesi;
    private final zzbbd zzesj;
    private final AtomicBoolean zzesk;

    public zzbeq(zzbeb zzbebVar) {
        super(zzbebVar.getContext());
        this.zzesk = new AtomicBoolean();
        this.zzesi = zzbebVar;
        this.zzesj = new zzbbd(zzbebVar.zzacs(), this, this);
        addView(zzbebVar.getView());
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void destroy() {
        final b zzadb = zzadb();
        if (zzadb != null) {
            zzdvl zzdvlVar = com.google.android.gms.ads.internal.util.zzj.zzeen;
            zzdvlVar.post(new Runnable(zzadb) { // from class: com.google.android.gms.internal.ads.zzbep
                private final b zzesh;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzesh = zzadb;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.gms.ads.internal.zzr.zzlg().zzac(this.zzesh);
                }
            });
            zzdvlVar.postDelayed(new zzbes(this), ((Integer) zzwr.zzqr().zzd(zzabp.zzcvn)).intValue());
            return;
        }
        this.zzesi.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final String getRequestId() {
        return this.zzesi.getRequestId();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbfo
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final WebView getWebView() {
        return this.zzesi.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final boolean isDestroyed() {
        return this.zzesi.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void loadData(String str, String str2, String str3) {
        this.zzesi.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzesi.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void loadUrl(String str) {
        this.zzesi.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzvc
    public final void onAdClicked() {
        zzbeb zzbebVar = this.zzesi;
        if (zzbebVar != null) {
            zzbebVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void onPause() {
        this.zzesj.onPause();
        this.zzesi.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void onResume() {
        this.zzesi.onResume();
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbeb
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzesi.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbeb
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzesi.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void setRequestedOrientation(int i2) {
        this.zzesi.setRequestedOrientation(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzesi.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzesi.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(String str, Map<String, ?> map) {
        this.zzesi.zza(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final zzbbd zzabb() {
        return this.zzesj;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo
    public final zzbev zzabc() {
        return this.zzesi.zzabc();
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final zzaca zzabd() {
        return this.zzesi.zzabd();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo, com.google.android.gms.internal.ads.zzbfd
    public final Activity zzabe() {
        return this.zzesi.zzabe();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo
    public final com.google.android.gms.ads.internal.zzb zzabf() {
        return this.zzesi.zzabf();
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final String zzabg() {
        return this.zzesi.zzabg();
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final int zzabh() {
        return this.zzesi.zzabh();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo
    public final zzacd zzabi() {
        return this.zzesi.zzabi();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo, com.google.android.gms.internal.ads.zzbfl
    public final zzazn zzabj() {
        return this.zzesi.zzabj();
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final int zzabk() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final int zzabl() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final void zzabm() {
        this.zzesi.zzabm();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbdu
    public final zzdmw zzacp() {
        return this.zzesi.zzacp();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzacq() {
        this.zzesi.zzacq();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzacr() {
        this.zzesi.zzacr();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final Context zzacs() {
        return this.zzesi.zzacs();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final com.google.android.gms.ads.internal.overlay.zzc zzact() {
        return this.zzesi.zzact();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final com.google.android.gms.ads.internal.overlay.zzc zzacu() {
        return this.zzesi.zzacu();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbfj
    public final zzbft zzacv() {
        return this.zzesi.zzacv();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final String zzacw() {
        return this.zzesi.zzacw();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final zzbfn zzacx() {
        return this.zzesi.zzacx();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final WebViewClient zzacy() {
        return this.zzesi.zzacy();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final boolean zzacz() {
        return this.zzesi.zzacz();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbfm
    public final zzei zzada() {
        return this.zzesi.zzada();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final b zzadb() {
        return this.zzesi.zzadb();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final boolean zzadc() {
        return this.zzesi.zzadc();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzadd() {
        this.zzesj.onDestroy();
        this.zzesi.zzadd();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final boolean zzade() {
        return this.zzesi.zzade();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final boolean zzadf() {
        return this.zzesi.zzadf();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzadg() {
        this.zzesi.zzadg();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzadh() {
        this.zzesi.zzadh();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    @Nullable
    public final zzaef zzadi() {
        return this.zzesi.zzadi();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzadj() {
        setBackgroundColor(0);
        this.zzesi.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzadk() {
        TextView textView = new TextView(getContext());
        Resources resources = com.google.android.gms.ads.internal.zzr.zzkv().getResources();
        textView.setText(resources != null ? resources.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final zzsh zzadl() {
        return this.zzesi.zzadl();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final boolean zzadm() {
        return this.zzesk.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbfa
    public final zzdnb zzadn() {
        return this.zzesi.zzadn();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzam(boolean z) {
        this.zzesi.zzam(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzaq(b bVar) {
        this.zzesi.zzaq(bVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final void zzaw(boolean z) {
        this.zzesi.zzaw(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzay(boolean z) {
        this.zzesi.zzay(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzaz(boolean z) {
        this.zzesi.zzaz(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzb(String str, zzaif<? super zzbeb> zzaifVar) {
        this.zzesi.zzb(str, zzaifVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzba(boolean z) {
        this.zzesi.zzba(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzbb(boolean z) {
        this.zzesi.zzbb(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzbv(Context context) {
        this.zzesi.zzbv(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzc(boolean z, int i2) {
        this.zzesi.zzc(z, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzakw
    public final void zzcv(String str) {
        this.zzesi.zzcv(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final void zzdp(int i2) {
        this.zzesi.zzdp(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzdu(int i2) {
        this.zzesi.zzdu(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final zzbdd zzfc(String str) {
        return this.zzesi.zzfc(str);
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final void zzkn() {
        this.zzesi.zzkn();
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final void zzko() {
        this.zzesi.zzko();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzwb() {
        this.zzesi.zzwb();
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final void zzwc() {
        this.zzesi.zzwc();
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(String str, JSONObject jSONObject) {
        this.zzesi.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzakw
    public final void zzb(String str, JSONObject jSONObject) {
        this.zzesi.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zza(String str, zzaif<? super zzbeb> zzaifVar) {
        this.zzesi.zza(str, zzaifVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzb(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzesi.zzb(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zza(String str, p<zzaif<? super zzbeb>> pVar) {
        this.zzesi.zza(str, pVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzb(String str, String str2, @Nullable String str3) {
        this.zzesi.zzb(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final void zza(boolean z, long j2) {
        this.zzesi.zza(z, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final boolean zzb(boolean z, int i2) {
        if (this.zzesk.compareAndSet(false, true)) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcpb)).booleanValue()) {
                return false;
            }
            if (this.zzesi.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.zzesi.getParent()).removeView(this.zzesi.getView());
            }
            return this.zzesi.zzb(z, i2);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzesi.zza(zzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zza(zzbft zzbftVar) {
        this.zzesi.zza(zzbftVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo
    public final void zza(String str, zzbdd zzbddVar) {
        this.zzesi.zza(str, zzbddVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zza(zzaea zzaeaVar) {
        this.zzesi.zza(zzaeaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zza(zzsh zzshVar) {
        this.zzesi.zza(zzshVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zza(zzqx zzqxVar) {
        this.zzesi.zza(zzqxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zza(@Nullable zzaef zzaefVar) {
        this.zzesi.zza(zzaefVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo
    public final void zza(zzbev zzbevVar) {
        this.zzesi.zza(zzbevVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzesi.zza(zzdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zza(boolean z, int i2, String str) {
        this.zzesi.zza(z, i2, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zza(boolean z, int i2, String str, String str2) {
        this.zzesi.zza(z, i2, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zza(com.google.android.gms.ads.internal.util.zzbg zzbgVar, zzcqr zzcqrVar, zzckn zzcknVar, zzdrz zzdrzVar, String str, String str2, int i2) {
        this.zzesi.zza(zzbgVar, zzcqrVar, zzcknVar, zzdrzVar, str, str2, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zza(zzdmw zzdmwVar, zzdnb zzdnbVar) {
        this.zzesi.zza(zzdmwVar, zzdnbVar);
    }
}
