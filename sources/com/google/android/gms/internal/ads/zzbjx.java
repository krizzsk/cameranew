package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tapjoy.TJAdUnitConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjx implements zzamc<zzbkb> {
    private final Context context;
    private final PowerManager zzaae;
    private final zzqt zzfsd;

    public zzbjx(Context context, zzqt zzqtVar) {
        this.context = context;
        this.zzfsd = zzqtVar;
        this.zzaae = (PowerManager) context.getSystemService("power");
    }

    @Override // com.google.android.gms.internal.ads.zzamc
    /* renamed from: zza */
    public final JSONObject zzi(zzbkb zzbkbVar) throws JSONException {
        boolean isScreenOn;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzqx zzqxVar = zzbkbVar.zzfss;
        if (zzqxVar == null) {
            jSONObject = new JSONObject();
        } else if (this.zzfsd.zzlx() != null) {
            boolean z = zzqxVar.zzbrv;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.zzfsd.zzlw()).put("activeViewJSON", this.zzfsd.zzlx()).put("timestamp", zzbkbVar.timestamp).put("adFormat", this.zzfsd.zzlv()).put("hashCode", this.zzfsd.getUniqueId()).put("isMraid", false).put("isStopped", false).put("isPaused", zzbkbVar.zzfsp).put("isNative", this.zzfsd.isNative());
            if (Build.VERSION.SDK_INT >= 20) {
                isScreenOn = this.zzaae.isInteractive();
            } else {
                isScreenOn = this.zzaae.isScreenOn();
            }
            put.put("isScreenOn", isScreenOn).put("appMuted", com.google.android.gms.ads.internal.zzr.zzkw().zzrb()).put("appVolume", com.google.android.gms.ads.internal.zzr.zzkw().zzra()).put("deviceVolume", com.google.android.gms.ads.internal.util.zzae.zzbg(this.context.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzqxVar.zzaal).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put(TJAdUnitConstants.String.TOP, zzqxVar.zzbrw.top).put(TJAdUnitConstants.String.BOTTOM, zzqxVar.zzbrw.bottom).put(TJAdUnitConstants.String.LEFT, zzqxVar.zzbrw.left).put(TJAdUnitConstants.String.RIGHT, zzqxVar.zzbrw.right)).put("adBox", new JSONObject().put(TJAdUnitConstants.String.TOP, zzqxVar.zzbrx.top).put(TJAdUnitConstants.String.BOTTOM, zzqxVar.zzbrx.bottom).put(TJAdUnitConstants.String.LEFT, zzqxVar.zzbrx.left).put(TJAdUnitConstants.String.RIGHT, zzqxVar.zzbrx.right)).put("globalVisibleBox", new JSONObject().put(TJAdUnitConstants.String.TOP, zzqxVar.zzbry.top).put(TJAdUnitConstants.String.BOTTOM, zzqxVar.zzbry.bottom).put(TJAdUnitConstants.String.LEFT, zzqxVar.zzbry.left).put(TJAdUnitConstants.String.RIGHT, zzqxVar.zzbry.right)).put("globalVisibleBoxVisible", zzqxVar.zzbrz).put("localVisibleBox", new JSONObject().put(TJAdUnitConstants.String.TOP, zzqxVar.zzbsa.top).put(TJAdUnitConstants.String.BOTTOM, zzqxVar.zzbsa.bottom).put(TJAdUnitConstants.String.LEFT, zzqxVar.zzbsa.left).put(TJAdUnitConstants.String.RIGHT, zzqxVar.zzbsa.right)).put("localVisibleBoxVisible", zzqxVar.zzbsb).put("hitBox", new JSONObject().put(TJAdUnitConstants.String.TOP, zzqxVar.zzbsc.top).put(TJAdUnitConstants.String.BOTTOM, zzqxVar.zzbsc.bottom).put(TJAdUnitConstants.String.LEFT, zzqxVar.zzbsc.left).put(TJAdUnitConstants.String.RIGHT, zzqxVar.zzbsc.right)).put("screenDensity", this.context.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzbkbVar.zzbrj);
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcqu)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzqxVar.zzbse;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put(TJAdUnitConstants.String.TOP, rect2.top).put(TJAdUnitConstants.String.BOTTOM, rect2.bottom).put(TJAdUnitConstants.String.LEFT, rect2.left).put(TJAdUnitConstants.String.RIGHT, rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbkbVar.zzfsr)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
