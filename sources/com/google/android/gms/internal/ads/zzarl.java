package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzarl {
    private static final Object lock = new Object();
    @GuardedBy("lock")
    private static boolean zzdqy = false;
    @GuardedBy("lock")
    private static boolean zzzl = false;
    private zzdst zzdqz;

    private final void zzn(Context context) {
        synchronized (lock) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvm)).booleanValue() && !zzdqy) {
                try {
                    zzdqy = true;
                    this.zzdqz = (zzdst) zzazj.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzark.zzbyi);
                } catch (zzazl e2) {
                    zzazk.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Nullable
    public final String getVersion(Context context) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvm)).booleanValue()) {
            try {
                zzn(context);
                String valueOf = String.valueOf(this.zzdqz.getVersion());
                return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
            } catch (RemoteException | NullPointerException e2) {
                zzazk.zze("#007 Could not call remote method.", e2);
                return null;
            }
        }
        return null;
    }

    @Nullable
    public final b zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    public final void zzab(b bVar) {
        synchronized (lock) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvm)).booleanValue() && zzzl) {
                try {
                    this.zzdqz.zzab(bVar);
                } catch (RemoteException | NullPointerException e2) {
                    zzazk.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void zzac(b bVar) {
        synchronized (lock) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvm)).booleanValue() && zzzl) {
                try {
                    this.zzdqz.zzac(bVar);
                } catch (RemoteException | NullPointerException e2) {
                    zzazk.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Nullable
    public final b zzb(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5, zzarm zzarmVar, zzarn zzarnVar, @Nullable String str6) {
        synchronized (lock) {
            try {
                try {
                    if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvm)).booleanValue() && zzzl) {
                        if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcvq)).booleanValue()) {
                            return zza(str, webView, str2, str3, str4, str5);
                        }
                        try {
                            return this.zzdqz.zza(str, d.z0(webView), str2, str3, str4, str5, zzarmVar.toString(), zzarnVar.toString(), str6);
                        } catch (RemoteException | NullPointerException e2) {
                            zzazk.zze("#007 Could not call remote method.", e2);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final boolean zzm(Context context) {
        synchronized (lock) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvm)).booleanValue()) {
                if (zzzl) {
                    return true;
                }
                try {
                    zzn(context);
                    boolean zzav = this.zzdqz.zzav(d.z0(context));
                    zzzl = zzav;
                    return zzav;
                } catch (RemoteException e2) {
                    e = e2;
                    zzazk.zze("#007 Could not call remote method.", e);
                    return false;
                } catch (NullPointerException e3) {
                    e = e3;
                    zzazk.zze("#007 Could not call remote method.", e);
                    return false;
                }
            }
            return false;
        }
    }

    @Nullable
    public final b zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (lock) {
            try {
                try {
                    if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvm)).booleanValue() && zzzl) {
                        try {
                            return this.zzdqz.zza(str, d.z0(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e2) {
                            zzazk.zze("#007 Could not call remote method.", e2);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Nullable
    public final b zza(String str, WebView webView, String str2, String str3, @Nullable String str4, zzarm zzarmVar, zzarn zzarnVar, @Nullable String str5) {
        return zza(str, webView, str2, str3, str4, "Google", zzarmVar, zzarnVar, str5);
    }

    @Nullable
    private final b zza(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5, zzarm zzarmVar, zzarn zzarnVar, @Nullable String str6) {
        synchronized (lock) {
            try {
                try {
                    if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvm)).booleanValue() && zzzl) {
                        if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcvp)).booleanValue()) {
                            return zza(str, webView, str2, str3, str4, str5);
                        }
                        try {
                            return this.zzdqz.zzb(str, d.z0(webView), str2, str3, str4, str5, zzarmVar.toString(), zzarnVar.toString(), str6);
                        } catch (RemoteException | NullPointerException e2) {
                            zzazk.zze("#007 Could not call remote method.", e2);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void zzb(b bVar, View view) {
        synchronized (lock) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvm)).booleanValue() && zzzl) {
                try {
                    this.zzdqz.zzd(bVar, d.z0(view));
                } catch (RemoteException | NullPointerException e2) {
                    zzazk.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void zza(b bVar, View view) {
        synchronized (lock) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvm)).booleanValue() && zzzl) {
                try {
                    this.zzdqz.zzc(bVar, d.z0(view));
                } catch (RemoteException | NullPointerException e2) {
                    zzazk.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }
}
