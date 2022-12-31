package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.Key;
import com.tencent.tauth.AuthActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzaqq {
    private final zzbeb zzdjd;
    private final String zzdqg;

    public zzaqq(zzbeb zzbebVar) {
        this(zzbebVar, "");
    }

    public final void zza(int i2, int i3, int i4, int i5) {
        try {
            this.zzdjd.zza("onSizeChanged", new JSONObject().put("x", i2).put("y", i3).put("width", i4).put("height", i5));
        } catch (JSONException e2) {
            zzazk.zzc("Error occurred while dispatching size change.", e2);
        }
    }

    public final void zzb(int i2, int i3, int i4, int i5) {
        try {
            this.zzdjd.zza("onDefaultPositionReceived", new JSONObject().put("x", i2).put("y", i3).put("width", i4).put("height", i5));
        } catch (JSONException e2) {
            zzazk.zzc("Error occurred while dispatching default position.", e2);
        }
    }

    public final void zzds(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put(AuthActivity.ACTION_KEY, this.zzdqg);
            zzbeb zzbebVar = this.zzdjd;
            if (zzbebVar != null) {
                zzbebVar.zza("onError", put);
            }
        } catch (JSONException e2) {
            zzazk.zzc("Error occurred while dispatching error event.", e2);
        }
    }

    public final void zzdt(String str) {
        try {
            this.zzdjd.zza("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e2) {
            zzazk.zzc("Error occurred while dispatching ready Event.", e2);
        }
    }

    public final void zzdu(String str) {
        try {
            this.zzdjd.zza("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e2) {
            zzazk.zzc("Error occurred while dispatching state change.", e2);
        }
    }

    public zzaqq(zzbeb zzbebVar, String str) {
        this.zzdjd = zzbebVar;
        this.zzdqg = str;
    }

    public final void zza(int i2, int i3, int i4, int i5, float f2, int i6) {
        try {
            this.zzdjd.zza("onScreenInfoChanged", new JSONObject().put("width", i2).put("height", i3).put("maxSizeWidth", i4).put("maxSizeHeight", i5).put("density", f2).put(Key.ROTATION, i6));
        } catch (JSONException e2) {
            zzazk.zzc("Error occurred while obtaining screen information.", e2);
        }
    }
}
