package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.matrix.report.Issue;
import com.tencent.tauth.AuthActivity;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbda implements zzaif<zzbbo> {
    private boolean zzepk;

    private static int zza(Context context, Map<String, String> map, String str, int i2) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                zzwr.zzqn();
                return zzaza.zze(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
                sb.append("Could not parse ");
                sb.append(str);
                sb.append(" in a video GMSG: ");
                sb.append(str2);
                zzazk.zzex(sb.toString());
                return i2;
            }
        }
        return i2;
    }

    private static Integer zza(Map<String, String> map, String str) {
        if (map.containsKey(str)) {
            try {
                return Integer.valueOf(Integer.parseInt(map.get(str)));
            } catch (NumberFormatException unused) {
                String str2 = map.get(str);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41 + String.valueOf(str2).length());
                sb.append("Video gmsg invalid numeric parameter '");
                sb.append(str);
                sb.append("': ");
                sb.append(str2);
                zzazk.zzex(sb.toString());
                return null;
            }
        }
        return null;
    }

    private static void zza(zzbax zzbaxVar, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbaxVar.zzdk(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzazk.zzex(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzbaxVar.zzdl(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbaxVar.zzdm(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbaxVar.zzdn(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbaxVar.zzdo(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzbbo zzbboVar, Map map) {
        int i2;
        String[] split;
        zzbbo zzbboVar2 = zzbboVar;
        String str = (String) map.get(AuthActivity.ACTION_KEY);
        if (str == null) {
            zzazk.zzex("Action missing from video GMSG.");
            return;
        }
        if (zzazk.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzazk.zzdy(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get(TypedValues.Custom.S_COLOR);
            if (TextUtils.isEmpty(str2)) {
                zzazk.zzex("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbboVar2.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                zzazk.zzex("Invalid color parameter in video GMSG.");
                return;
            }
        }
        if ("decoderProps".equals(str)) {
            String str3 = (String) map.get("mimeTypes");
            if (str3 == null) {
                zzazk.zzex("No MIME types specified for decoder properties inspection.");
                zzbax.zza(zzbboVar2, "missingMimeTypes");
                return;
            }
            HashMap hashMap = new HashMap();
            for (String str4 : str3.split(",")) {
                hashMap.put(str4, com.google.android.gms.ads.internal.util.zzbx.zzep(str4.trim()));
            }
            zzbax.zza(zzbboVar2, hashMap);
            return;
        }
        zzbbd zzabb = zzbboVar2.zzabb();
        if (zzabb == null) {
            zzazk.zzex("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = AppSettingsData.STATUS_NEW.equals(str);
        boolean equals2 = "position".equals(str);
        if (!equals && !equals2) {
            zzbev zzabc = zzbboVar2.zzabc();
            if (zzabc != null) {
                if ("timeupdate".equals(str)) {
                    String str5 = (String) map.get(TJAdUnitConstants.String.VIDEO_CURRENT_TIME);
                    if (str5 == null) {
                        zzazk.zzex("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    }
                    try {
                        zzabc.zze(Float.parseFloat(str5));
                        return;
                    } catch (NumberFormatException unused2) {
                        String valueOf = String.valueOf(str5);
                        zzazk.zzex(valueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(valueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                        return;
                    }
                } else if (FreeSpaceBox.TYPE.equals(str)) {
                    zzabc.zzaej();
                    return;
                }
            }
            zzbax zzaav = zzabb.zzaav();
            if (zzaav == null) {
                zzbax.zza(zzbboVar2);
                return;
            } else if ("click".equals(str)) {
                Context context = zzbboVar2.getContext();
                int zza = zza(context, map, "x", 0);
                int zza2 = zza(context, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, zza, zza2, 0);
                zzaav.zze(obtain);
                obtain.recycle();
                return;
            } else if (TJAdUnitConstants.String.VIDEO_CURRENT_TIME.equals(str)) {
                String str6 = (String) map.get(Issue.ISSUE_REPORT_TIME);
                if (str6 == null) {
                    zzazk.zzex("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzaav.seekTo((int) (Float.parseFloat(str6) * 1000.0f));
                    return;
                } catch (NumberFormatException unused3) {
                    String valueOf2 = String.valueOf(str6);
                    zzazk.zzex(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                    return;
                }
            } else if ("hide".equals(str)) {
                zzaav.setVisibility(4);
                VdsAgent.onSetViewVisibility(zzaav, 4);
                return;
            } else if (TrackLoadSettingsAtom.TYPE.equals(str)) {
                zzaav.zzhy();
                return;
            } else if ("loadControl".equals(str)) {
                zza(zzaav, (Map<String, String>) map);
                return;
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzaav.zzaap();
                    return;
                } else {
                    zzaav.zzaaq();
                    return;
                }
            } else if ("pause".equals(str)) {
                zzaav.pause();
                return;
            } else if ("play".equals(str)) {
                zzaav.play();
                return;
            } else if ("show".equals(str)) {
                zzaav.setVisibility(0);
                VdsAgent.onSetViewVisibility(zzaav, 0);
                return;
            } else if ("src".equals(str)) {
                String str7 = (String) map.get("src");
                Integer zza3 = zza(map, "periodicReportIntervalMs");
                String[] strArr = {str7};
                String str8 = (String) map.get("demuxed");
                if (str8 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str8);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            strArr2[i3] = jSONArray.getString(i3);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused4) {
                        String valueOf3 = String.valueOf(str8);
                        zzazk.zzex(valueOf3.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(valueOf3) : new String("Malformed demuxed URL list for playback: "));
                        strArr = new String[]{str7};
                    }
                }
                if (zza3 != null) {
                    zzbboVar2.zzdp(zza3.intValue());
                }
                zzaav.zzc(str7, strArr);
                return;
            } else if ("touchMove".equals(str)) {
                Context context2 = zzbboVar2.getContext();
                zzaav.zza(zza(context2, map, "dx", 0), zza(context2, map, "dy", 0));
                if (this.zzepk) {
                    return;
                }
                zzbboVar2.zzwc();
                this.zzepk = true;
                return;
            } else if ("volume".equals(str)) {
                String str9 = (String) map.get("volume");
                if (str9 == null) {
                    zzazk.zzex("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzaav.setVolume(Float.parseFloat(str9));
                    return;
                } catch (NumberFormatException unused5) {
                    String valueOf4 = String.valueOf(str9);
                    zzazk.zzex(valueOf4.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf4) : new String("Could not parse volume parameter from volume video GMSG: "));
                    return;
                }
            } else if ("watermark".equals(str)) {
                zzaav.zzaar();
                return;
            } else {
                String valueOf5 = String.valueOf(str);
                zzazk.zzex(valueOf5.length() != 0 ? "Unknown video action: ".concat(valueOf5) : new String("Unknown video action: "));
                return;
            }
        }
        Context context3 = zzbboVar2.getContext();
        int zza4 = zza(context3, map, "x", 0);
        int zza5 = zza(context3, map, "y", 0);
        int zza6 = zza(context3, map, PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W, -1);
        int zza7 = zza(context3, map, PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H, -1);
        int min = Math.min(zza6, zzbboVar2.zzabl() - zza4);
        int min2 = Math.min(zza7, zzbboVar2.zzabk() - zza5);
        try {
            i2 = Integer.parseInt((String) map.get("player"));
        } catch (NumberFormatException unused6) {
            i2 = 0;
        }
        boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
        if (equals && zzabb.zzaav() == null) {
            zzabb.zza(zza4, zza5, min, min2, i2, parseBoolean, new zzbbl((String) map.get("flags")));
            zzbax zzaav2 = zzabb.zzaav();
            if (zzaav2 != null) {
                zza(zzaav2, (Map<String, String>) map);
                return;
            }
            return;
        }
        zzabb.zze(zza4, zza5, min, min2);
    }
}
