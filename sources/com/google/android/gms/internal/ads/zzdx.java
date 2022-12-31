package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzcb;
import com.google.android.gms.internal.ads.zzcf;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import java.util.Iterator;
import java.util.LinkedList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdx implements zzdy {
    protected static volatile zzfc zzwc;
    protected MotionEvent zzwh;
    protected double zzwq;
    private double zzwr;
    private double zzws;
    protected float zzwt;
    protected float zzwu;
    protected float zzwv;
    protected float zzww;
    protected DisplayMetrics zzwz;
    protected LinkedList<MotionEvent> zzwi = new LinkedList<>();
    protected long zzwj = 0;
    protected long zzwk = 0;
    protected long zzwl = 0;
    protected long zzwm = 0;
    protected long zzwn = 0;
    protected long zzwo = 0;
    protected long zzwp = 0;
    private boolean zzwx = false;
    protected boolean zzwy = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdx(Context context) {
        try {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcsh)).booleanValue()) {
                zzda.zzbo();
            } else {
                zzff.zzb(zzwc);
            }
            this.zzwz = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    private final void zzbx() {
        this.zzwn = 0L;
        this.zzwj = 0L;
        this.zzwk = 0L;
        this.zzwl = 0L;
        this.zzwm = 0L;
        this.zzwo = 0L;
        this.zzwp = 0L;
        if (this.zzwi.size() > 0) {
            Iterator<MotionEvent> it = this.zzwi.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.zzwi.clear();
        } else {
            MotionEvent motionEvent = this.zzwh;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzwh = null;
    }

    protected abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzev;

    protected abstract zzcf.zza.zzb zza(Context context, zzcb.zza zzaVar);

    @Override // com.google.android.gms.internal.ads.zzdy
    public String zza(Context context, View view, Activity activity) {
        return zza(context, null, zzew.zzyk, view, activity, null);
    }

    protected abstract zzcf.zza.zzb zzb(Context context, View view, Activity activity);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzfi zzb(MotionEvent motionEvent) throws zzev;

    @Override // com.google.android.gms.internal.ads.zzdy
    public String zzb(Context context) {
        if (!zzfh.isMainThread()) {
            return zza(context, null, zzew.zzyj, null, null, null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public void zzb(View view) {
    }

    protected abstract zzcf.zza.zzb zzc(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, zzew.zzyl, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zzwx) {
            zzbx();
            this.zzwx = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzwq = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.zzwr = motionEvent.getRawX();
            this.zzws = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d2 = rawX - this.zzwr;
            double d3 = rawY - this.zzws;
            this.zzwq += Math.sqrt((d2 * d2) + (d3 * d3));
            this.zzwr = rawX;
            this.zzws = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    this.zzwh = obtain;
                    this.zzwi.add(obtain);
                    if (this.zzwi.size() > 6) {
                        this.zzwi.remove().recycle();
                    }
                    this.zzwl++;
                    this.zzwn = zza(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.zzwk += motionEvent.getHistorySize() + 1;
                    zzfi zzb = zzb(motionEvent);
                    if ((zzb == null || zzb.zzzu == null || zzb.zzzx == null) ? false : true) {
                        this.zzwo += zzb.zzzu.longValue() + zzb.zzzx.longValue();
                    }
                    if (this.zzwz != null && zzb != null && zzb.zzzv != null && zzb.zzzy != null) {
                        z = true;
                    }
                    if (z) {
                        this.zzwp += zzb.zzzv.longValue() + zzb.zzzy.longValue();
                    }
                } else if (action2 == 3) {
                    this.zzwm++;
                }
            } catch (zzev unused) {
            }
        } else {
            this.zzwt = motionEvent.getX();
            this.zzwu = motionEvent.getY();
            this.zzwv = motionEvent.getRawX();
            this.zzww = motionEvent.getRawY();
            this.zzwj++;
        }
        this.zzwy = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public void zza(int i2, int i3, int i4) {
        if (this.zzwh != null) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrv)).booleanValue()) {
                zzbx();
            } else {
                this.zzwh.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzwz;
        if (displayMetrics != null) {
            float f2 = displayMetrics.density;
            this.zzwh = MotionEvent.obtain(0L, i4, 1, i2 * f2, i3 * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzwh = null;
        }
        this.zzwy = false;
    }

    private final String zza(Context context, String str, int i2, View view, Activity activity, byte[] bArr) {
        zzdw zzdwVar;
        String str2;
        int i3;
        int i4;
        int i5;
        int i6;
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcrx)).booleanValue();
        zzcf.zza.zzb zzbVar = null;
        if (booleanValue) {
            zzdwVar = zzwc != null ? zzwc.zzcl() : null;
            str2 = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcsh)).booleanValue() ? "be" : "te";
        } else {
            zzdwVar = null;
            str2 = null;
        }
        try {
            if (i2 == zzew.zzyl) {
                zzbVar = zzb(context, view, activity);
                this.zzwx = true;
                i6 = 1002;
            } else if (i2 == zzew.zzyk) {
                zzbVar = zzc(context, view, activity);
                i6 = 1008;
            } else {
                zzbVar = zza(context, null);
                i6 = 1000;
            }
            if (booleanValue && zzdwVar != null) {
                zzdwVar.zza(i6, -1, System.currentTimeMillis() - currentTimeMillis, str2);
            }
        } catch (Exception e2) {
            if (booleanValue && zzdwVar != null) {
                if (i2 == zzew.zzyl) {
                    i3 = 1003;
                } else if (i2 == zzew.zzyk) {
                    i3 = 1009;
                } else {
                    i3 = i2 == zzew.zzyj ? 1001 : -1;
                }
                zzdwVar.zza(i3, -1, System.currentTimeMillis() - currentTimeMillis, str2, e2);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (zzbVar != null) {
            try {
                if (((zzcf.zza) ((zzelb) zzbVar.zzbiw())).zzbik() != 0) {
                    String zzj = zzda.zzj((zzcf.zza) ((zzelb) zzbVar.zzbiw()), str);
                    if (!booleanValue || zzdwVar == null) {
                        return zzj;
                    }
                    if (i2 == zzew.zzyl) {
                        i5 = 1006;
                    } else if (i2 == zzew.zzyk) {
                        i5 = 1010;
                    } else {
                        i5 = i2 == zzew.zzyj ? 1004 : -1;
                    }
                    zzdwVar.zza(i5, -1, System.currentTimeMillis() - currentTimeMillis2, str2);
                    return zzj;
                }
            } catch (Exception e3) {
                String num = Integer.toString(7);
                if (!booleanValue || zzdwVar == null) {
                    return num;
                }
                if (i2 == zzew.zzyl) {
                    i4 = 1007;
                } else if (i2 == zzew.zzyk) {
                    i4 = 1011;
                } else {
                    i4 = i2 == zzew.zzyj ? CloseFrame.NOCODE : -1;
                }
                zzdwVar.zza(i4, -1, System.currentTimeMillis() - currentTimeMillis2, str2, e3);
                return num;
            }
        }
        return Integer.toString(5);
    }
}
