package com.google.android.gms.internal.ads;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzcdx extends View.OnClickListener, View.OnTouchListener {
    void zza(String str, View view, boolean z);

    View zzajr();

    Map<String, WeakReference<View>> zzaov();

    Map<String, WeakReference<View>> zzaow();

    Map<String, WeakReference<View>> zzaox();

    String zzaoy();

    FrameLayout zzaoz();

    zzqs zzapa();

    b zzapb();

    View zzgc(String str);

    JSONObject zztk();
}
