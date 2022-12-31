package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbnj extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final Context context;
    private View zzaat;

    private zzbnj(Context context) {
        super(context);
        this.context = context;
    }

    public static zzbnj zza(Context context, View view, zzdmw zzdmwVar) {
        zzbnj zzbnjVar = new zzbnj(context);
        zzbnjVar.zzaat = view;
        zzbnjVar.addView(view);
        com.google.android.gms.ads.internal.zzr.zzlo();
        zzbai.zza((View) zzbnjVar, (ViewTreeObserver.OnScrollChangedListener) zzbnjVar);
        com.google.android.gms.ads.internal.zzr.zzlo();
        zzbai.zza((View) zzbnjVar, (ViewTreeObserver.OnGlobalLayoutListener) zzbnjVar);
        JSONObject jSONObject = zzdmwVar.zzhjy;
        if (jSONObject != null) {
            RelativeLayout relativeLayout = new RelativeLayout(zzbnjVar.context);
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                zzbnjVar.zza(optJSONObject, relativeLayout, 10);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
            if (optJSONObject2 != null) {
                zzbnjVar.zza(optJSONObject2, relativeLayout, 12);
            }
            zzbnjVar.addView(relativeLayout);
        }
        return zzbnjVar;
    }

    private final int zzb(double d2) {
        zzwr.zzqn();
        return zzaza.zze(this.context, (int) d2);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzaat.setY(-iArr[1]);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzaat.setY(-iArr[1]);
    }

    private final void zza(JSONObject jSONObject, RelativeLayout relativeLayout, int i2) {
        TextView textView = new TextView(this.context);
        textView.setTextColor(-1);
        textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzb = zzb(jSONObject.optDouble("padding", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        textView.setPadding(0, zzb, 0, zzb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i2);
        relativeLayout.addView(textView, layoutParams);
    }
}
