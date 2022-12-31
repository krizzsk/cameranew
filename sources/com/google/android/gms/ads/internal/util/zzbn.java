package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzdmw;
import com.google.android.gms.internal.ads.zzdvu;
import com.google.android.gms.internal.ads.zzdwk;
import com.google.android.gms.internal.ads.zzwr;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbn {
    @Nullable
    private static JSONObject a(Context context, Point point, Point point2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", c(context, point2.x));
            jSONObject.put("y", c(context, point2.y));
            jSONObject.put("start_x", c(context, point.x));
            jSONObject.put("start_y", c(context, point.y));
            return jSONObject;
        } catch (JSONException e2) {
            zzazk.zzc("Error occurred while putting signals into JSON object.", e2);
            return null;
        }
    }

    private static JSONObject b(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", c(context, rect.right - rect.left));
        jSONObject.put("height", c(context, rect.bottom - rect.top));
        jSONObject.put("x", c(context, rect.left));
        jSONObject.put("y", c(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private static int c(Context context, int i2) {
        return zzwr.zzqn().zzd(context, i2);
    }

    private static int[] d(@Nullable View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0135 A[Catch: JSONException -> 0x0151, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0151, blocks: (B:33:0x011c, B:47:0x0144, B:48:0x0148, B:49:0x014d, B:38:0x012b, B:41:0x0135), top: B:55:0x011c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014d A[Catch: JSONException -> 0x0151, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0151, blocks: (B:33:0x011c, B:47:0x0144, B:48:0x0148, B:49:0x014d, B:38:0x012b, B:41:0x0135), top: B:55:0x011c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject zza(android.content.Context r16, @androidx.annotation.Nullable android.view.View r17) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbn.zza(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static JSONObject zzb(Context context, @Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            com.google.android.gms.ads.internal.zzr.zzkr();
            jSONObject.put("can_show_on_lock_screen", zzj.zzq(view));
            com.google.android.gms.ads.internal.zzr.zzkr();
            jSONObject.put("is_keyguard_locked", zzj.zzat(context));
        } catch (JSONException unused) {
            zzazk.zzex("Unable to get lock screen information");
        }
        return jSONObject;
    }

    public static JSONObject zzbk(@Nonnull Context context) {
        JSONObject jSONObject = new JSONObject();
        com.google.android.gms.ads.internal.zzr.zzkr();
        DisplayMetrics zza = zzj.zza((WindowManager) context.getSystemService("window"));
        try {
            jSONObject.put("width", c(context, zza.widthPixels));
            jSONObject.put("height", c(context, zza.heightPixels));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean zzdh(int i2) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcso)).booleanValue()) {
            return ((Boolean) zzwr.zzqr().zzd(zzabp.zzcsp)).booleanValue() || i2 <= 15299999;
        }
        return true;
    }

    public static JSONObject zzt(@Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczj)).booleanValue()) {
                com.google.android.gms.ads.internal.zzr.zzkr();
                jSONObject.put("contained_in_scroll_view", zzj.zzs(view));
            } else {
                com.google.android.gms.ads.internal.zzr.zzkr();
                jSONObject.put("contained_in_scroll_view", zzj.zzr(view) != -1);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static WindowManager.LayoutParams zzzq() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) zzwr.zzqr().zzd(zzabp.zzczm)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    public static JSONObject zza(Context context, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, @Nullable View view) {
        String str;
        String str2;
        JSONObject jSONObject;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject2 = new JSONObject();
        if (map != null && view != null) {
            int[] d2 = d(view);
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, WeakReference<View>> next = it.next();
                View view2 = next.getValue().get();
                if (view2 != null) {
                    int[] d3 = d(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    Iterator<Map.Entry<String, WeakReference<View>>> it2 = it;
                    try {
                        jSONObject4.put("width", c(context, view2.getMeasuredWidth()));
                        jSONObject4.put("height", c(context, view2.getMeasuredHeight()));
                        jSONObject4.put("x", c(context, d3[0] - d2[0]));
                        jSONObject4.put("y", c(context, d3[1] - d2[1]));
                        jSONObject4.put(str4, str3);
                        jSONObject3.put(TypedValues.AttributesType.S_FRAME, jSONObject4);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject = b(context, rect);
                        } else {
                            jSONObject = new JSONObject();
                            jSONObject.put("width", 0);
                            jSONObject.put("height", 0);
                            jSONObject.put("x", c(context, d3[0] - d2[0]));
                            jSONObject.put("y", c(context, d3[1] - d2[1]));
                            jSONObject.put(str4, str3);
                        }
                        jSONObject3.put("visible_bounds", jSONObject);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject3.put("text_color", textView.getCurrentTextColor());
                            str = str3;
                            str2 = str4;
                            try {
                                jSONObject3.put("font_size", textView.getTextSize());
                                jSONObject3.put("text", textView.getText());
                            } catch (JSONException unused) {
                                zzazk.zzex("Unable to get asset views information");
                                it = it2;
                                str3 = str;
                                str4 = str2;
                            }
                        } else {
                            str = str3;
                            str2 = str4;
                        }
                        jSONObject3.put("is_clickable", map2 != null && map2.containsKey(next.getKey()) && view2.isClickable());
                        jSONObject2.put(next.getKey(), jSONObject3);
                    } catch (JSONException unused2) {
                        str = str3;
                        str2 = str4;
                    }
                    it = it2;
                    str3 = str;
                    str4 = str2;
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject zza(@Nullable String str, Context context, Point point, Point point2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            jSONObject.put("click_point", a(context, point, point2));
            jSONObject.put("asset_id", str);
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            jSONObject2 = jSONObject;
            zzazk.zzc("Error occurred while grabbing click signals.", e);
            return jSONObject2;
        }
    }

    public static Point zza(MotionEvent motionEvent, @Nullable View view) {
        int[] d2 = d(view);
        return new Point(((int) motionEvent.getRawX()) - d2[0], ((int) motionEvent.getRawY()) - d2[1]);
    }

    public static boolean zza(Context context, zzdmw zzdmwVar) {
        if (zzdmwVar.zzhjo) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczk)).booleanValue()) {
                return ((Boolean) zzwr.zzqr().zzd(zzabp.zzczn)).booleanValue();
            }
            String str = (String) zzwr.zzqr().zzd(zzabp.zzczl);
            if (!str.isEmpty() && context != null) {
                String packageName = context.getPackageName();
                for (String str2 : zzdwk.zza(zzdvu.zzb(';')).zza(str)) {
                    if (str2.equals(packageName)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
