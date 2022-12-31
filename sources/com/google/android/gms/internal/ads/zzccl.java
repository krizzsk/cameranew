package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzccl {
    void cancelUnconfirmedClick();

    void destroy();

    boolean isCustomClickGestureEnabled();

    void setClickConfirmingView(View view);

    JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2);

    void zza(@Nullable View view, MotionEvent motionEvent, View view2);

    void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void zza(View view, Map<String, WeakReference<View>> map);

    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener);

    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void zza(zzagm zzagmVar);

    void zza(zzyj zzyjVar);

    void zza(@Nullable zzyn zzynVar);

    void zzanj();

    void zzank();

    void zzanl();

    void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2);

    void zzf(Bundle bundle);

    void zzfw(String str);

    void zzg(Bundle bundle);

    boolean zzh(Bundle bundle);

    void zztx();
}
