package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.internal.ads.zzaki;
import com.google.android.gms.internal.ads.zzbdu;
import com.google.android.gms.internal.ads.zzbeb;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbfo;
import com.google.android.gms.internal.ads.zzvc;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.tauth.AuthActivity;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaij<T extends zzvc & zzbdu & zzbeb & zzaki & zzbfa & zzbfd & zzbfh & zzbfm & zzbfo> implements zzaif<T> {
    @Nullable
    private final com.google.android.gms.ads.internal.zza zzdhw;
    @Nullable
    private final zzaqg zzdhx;
    @Nullable
    private final zzckn zzdib;
    @Nullable
    private final zzdrz zzdic;
    @Nullable
    private final zzcqr zzdie;
    private com.google.android.gms.ads.internal.overlay.zzt zzdif = null;
    private final zzazo zzdid = new zzazo();

    public zzaij(com.google.android.gms.ads.internal.zza zzaVar, zzaqg zzaqgVar, zzcqr zzcqrVar, zzckn zzcknVar, zzdrz zzdrzVar) {
        this.zzdhw = zzaVar;
        this.zzdhx = zzaqgVar;
        this.zzdie = zzcqrVar;
        this.zzdib = zzcknVar;
        this.zzdic = zzdrzVar;
    }

    private final boolean zza(T t, Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzr.zzkr();
        boolean zzba = com.google.android.gms.ads.internal.util.zzj.zzba(context);
        com.google.android.gms.ads.internal.zzr.zzkr();
        com.google.android.gms.ads.internal.util.zzbg zzbd = com.google.android.gms.ads.internal.util.zzj.zzbd(context);
        zzckn zzcknVar = this.zzdib;
        if (zzcknVar != null) {
            zzcrb.zza(context, zzcknVar, this.zzdic, this.zzdie, str2, "offline_open");
        }
        T t2 = t;
        boolean z = t2.zzacv().zzaeo() && t2.zzabe() == null;
        if (zzba) {
            this.zzdie.zzb(this.zzdid, str2);
            return false;
        }
        com.google.android.gms.ads.internal.zzr.zzkr();
        if (com.google.android.gms.ads.internal.util.zzj.zzbc(context) && zzbd != null && !z) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdae)).booleanValue()) {
                if (t2.zzacv().zzaeo()) {
                    zzcrb.zza(t2.zzabe(), null, zzbd, this.zzdie, this.zzdib, this.zzdic, str2, str);
                } else {
                    t.zza(zzbd, this.zzdie, this.zzdib, this.zzdic, str2, str, com.google.android.gms.ads.internal.zzr.zzkt().zzzc());
                }
                zzckn zzcknVar2 = this.zzdib;
                if (zzcknVar2 != null) {
                    zzcrb.zza(context, zzcknVar2, this.zzdic, this.zzdie, str2, "dialog_impression");
                }
                t.onAdClicked();
                return true;
            }
        }
        this.zzdie.zzgm(str2);
        if (this.zzdib != null) {
            HashMap hashMap = new HashMap();
            com.google.android.gms.ads.internal.zzr.zzkr();
            if (!com.google.android.gms.ads.internal.util.zzj.zzbc(context)) {
                hashMap.put("dialog_not_shown_reason", "notifications_disabled");
            } else if (zzbd == null) {
                hashMap.put("dialog_not_shown_reason", "work_manager_unavailable");
            } else {
                if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzdae)).booleanValue()) {
                    hashMap.put("dialog_not_shown_reason", "notification_flow_disabled");
                } else if (z) {
                    hashMap.put("dialog_not_shown_reason", "fullscreen_no_activity");
                }
            }
            zzcrb.zza(context, this.zzdib, this.zzdic, this.zzdie, str2, "dialog_not_shown", hashMap);
        }
        return false;
    }

    private final void zzac(boolean z) {
        zzaqg zzaqgVar = this.zzdhx;
        if (zzaqgVar != null) {
            zzaqgVar.zzad(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzacr zzacrVar) {
        if (this.zzdib == null) {
            return;
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
            this.zzdic.zzb(zzdsa.zzgx("cct_action").zzu("cct_open_status", zzacrVar.toString()));
        } else {
            this.zzdib.zzaqr().zzr(AuthActivity.ACTION_KEY, "cct_action").zzr("cct_open_status", zzacrVar.toString()).zzaqt();
        }
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if (ContextChain.TAG_PRODUCT.equalsIgnoreCase(str)) {
                return 7;
            }
            if ("l".equalsIgnoreCase(str)) {
                return 6;
            }
            if ("c".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzr.zzkt().zzzc();
            }
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri zze(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e2) {
            String valueOf = String.valueOf(uri.toString());
            zzazk.zzc(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e2);
        }
        return uri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri zza(Context context, zzei zzeiVar, Uri uri, View view, @Nullable Activity activity) {
        if (zzeiVar == null) {
            return uri;
        }
        try {
            return zzeiVar.zzc(uri) ? zzeiVar.zza(uri, context, view, activity) : uri;
        } catch (zzeh unused) {
            return uri;
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(Object obj, Map map) {
        String str;
        boolean z;
        zzvc zzvcVar = (zzvc) obj;
        zzbeb zzbebVar = (zzbeb) zzvcVar;
        String zzc = zzaxu.zzc((String) map.get("u"), zzbebVar.getContext(), true);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            zzazk.zzex("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zza zzaVar = this.zzdhw;
        if (zzaVar != null && !zzaVar.zzjy()) {
            this.zzdhw.zzbk(zzc);
            return;
        }
        zzdmw zzacp = zzbebVar.zzacp();
        zzdnb zzadn = zzbebVar.zzadn();
        boolean z2 = false;
        if (zzacp == null || zzadn == null) {
            str = "";
            z = false;
        } else {
            boolean z3 = zzacp.zzhjz;
            str = zzadn.zzbvs;
            z = z3;
        }
        if ("expand".equalsIgnoreCase(str2)) {
            if (zzbebVar.zzadc()) {
                zzazk.zzex("Cannot expand WebView that is already expanded.");
                return;
            }
            zzac(false);
            ((zzbfh) zzvcVar).zzc(zzc(map), zzd(map));
        } else if ("webapp".equalsIgnoreCase(str2)) {
            zzac(false);
            if (zzc != null) {
                ((zzbfh) zzvcVar).zza(zzc(map), zzd(map), zzc);
            } else {
                ((zzbfh) zzvcVar).zza(zzc(map), zzd(map), (String) map.get(TJAdUnitConstants.String.HTML), (String) map.get("baseurl"));
            }
        } else {
            if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcur)).booleanValue()) {
                    zzac(true);
                    if (TextUtils.isEmpty(zzc)) {
                        zzazk.zzex("Cannot open browser with null or empty url");
                        zzb(zzacr.EMPTY_URL);
                        return;
                    }
                    Uri zze = zze(zza(zzbebVar.getContext(), zzbebVar.zzada(), Uri.parse(zzc), zzbebVar.getView(), zzbebVar.zzabe()));
                    if (z && this.zzdie != null && zza(zzvcVar, zzbebVar.getContext(), zze.toString(), str)) {
                        return;
                    }
                    this.zzdif = new zzaii(this);
                    ((zzbfh) zzvcVar).zza(new com.google.android.gms.ads.internal.overlay.zzd(zze.toString(), this.zzdif, true));
                    return;
                }
            }
            if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                zzac(true);
                Intent zze2 = new zzaik(zzbebVar.getContext(), zzbebVar.zzada(), zzbebVar.getView()).zze(map);
                if (!z || this.zzdie == null || zze2 == null || !zza(zzvcVar, zzbebVar.getContext(), zze2.getData().toString(), str)) {
                    try {
                        ((zzbfh) zzvcVar).zza(new com.google.android.gms.ads.internal.overlay.zzd(zze2, this.zzdif));
                    } catch (ActivityNotFoundException e2) {
                        zzazk.zzex(e2.getMessage());
                    }
                }
            } else if ("open_app".equalsIgnoreCase(str2)) {
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczw)).booleanValue()) {
                    zzac(true);
                    String str3 = (String) map.get(ContextChain.TAG_PRODUCT);
                    if (str3 == null) {
                        zzazk.zzex("Package name missing from open app action.");
                    } else if (z && this.zzdie != null && zza(zzvcVar, zzbebVar.getContext(), str3, str)) {
                    } else {
                        PackageManager packageManager = zzbebVar.getContext().getPackageManager();
                        if (packageManager == null) {
                            zzazk.zzex("Cannot get package manager from open app action.");
                            return;
                        }
                        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str3);
                        if (launchIntentForPackage != null) {
                            ((zzbfh) zzvcVar).zza(new com.google.android.gms.ads.internal.overlay.zzd(launchIntentForPackage, this.zzdif));
                        }
                    }
                }
            } else {
                zzac(true);
                String str4 = (String) map.get("intent_url");
                Intent intent = null;
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        intent = Intent.parseUri(str4, 0);
                    } catch (URISyntaxException e3) {
                        String valueOf = String.valueOf(str4);
                        zzazk.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e3);
                    }
                }
                if (intent != null && intent.getData() != null) {
                    Uri data = intent.getData();
                    if (!Uri.EMPTY.equals(data)) {
                        Uri zze3 = zze(zza(zzbebVar.getContext(), zzbebVar.zzada(), data, zzbebVar.getView(), zzbebVar.zzabe()));
                        if (!TextUtils.isEmpty(intent.getType())) {
                            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczx)).booleanValue()) {
                                intent.setDataAndType(zze3, intent.getType());
                            }
                        }
                        intent.setData(zze3);
                    }
                }
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdah)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map.containsKey(JsonMarshaller.EVENT_ID)) {
                    z2 = true;
                }
                HashMap hashMap = new HashMap();
                if (z2) {
                    this.zzdif = new zzail(this, hashMap, map, zzvcVar);
                }
                if (intent != null) {
                    if (!z || this.zzdie == null || !zza(zzvcVar, zzbebVar.getContext(), intent.getData().toString(), str)) {
                        ((zzbfh) zzvcVar).zza(new com.google.android.gms.ads.internal.overlay.zzd(intent, this.zzdif));
                        return;
                    } else if (z2) {
                        hashMap.put((String) map.get(JsonMarshaller.EVENT_ID), Boolean.TRUE);
                        ((zzaki) zzvcVar).zza("openIntentAsync", hashMap);
                        return;
                    } else {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(zzc)) {
                    zzc = zze(zza(zzbebVar.getContext(), zzbebVar.zzada(), Uri.parse(zzc), zzbebVar.getView(), zzbebVar.zzabe())).toString();
                }
                String str5 = zzc;
                if (!z || this.zzdie == null || !zza(zzvcVar, zzbebVar.getContext(), str5, str)) {
                    ((zzbfh) zzvcVar).zza(new com.google.android.gms.ads.internal.overlay.zzd((String) map.get(ContextChain.TAG_INFRA), str5, (String) map.get("m"), (String) map.get(ContextChain.TAG_PRODUCT), (String) map.get("c"), (String) map.get("f"), (String) map.get("e"), this.zzdif));
                } else if (z2) {
                    hashMap.put((String) map.get(JsonMarshaller.EVENT_ID), Boolean.TRUE);
                    ((zzaki) zzvcVar).zza("openIntentAsync", hashMap);
                }
            }
        }
    }
}
