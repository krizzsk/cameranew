package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.f;
import java.util.Set;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaqg extends zzaqq {
    private static final Set<String> zzdpi = f.g("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private int height;
    private final Object lock;
    private int width;
    private zzaqt zzdhy;
    private final zzbeb zzdjd;
    private final Activity zzdoy;
    private String zzdpj;
    private boolean zzdpk;
    private int zzdpl;
    private int zzdpm;
    private int zzdpn;
    private int zzdpo;
    private zzbft zzdpp;
    private ImageView zzdpq;
    private LinearLayout zzdpr;
    private PopupWindow zzdps;
    private RelativeLayout zzdpt;
    private ViewGroup zzdpu;

    public zzaqg(zzbeb zzbebVar, zzaqt zzaqtVar) {
        super(zzbebVar, "resize");
        this.zzdpj = "top-right";
        this.zzdpk = true;
        this.zzdpl = 0;
        this.zzdpm = 0;
        this.height = -1;
        this.zzdpn = 0;
        this.zzdpo = 0;
        this.width = -1;
        this.lock = new Object();
        this.zzdjd = zzbebVar;
        this.zzdoy = zzbebVar.zzabe();
        this.zzdhy = zzaqtVar;
    }

    public final void zza(int i2, int i3, boolean z) {
        synchronized (this.lock) {
            this.zzdpl = i2;
            this.zzdpm = i3;
            PopupWindow popupWindow = this.zzdps;
        }
    }

    public final void zzad(boolean z) {
        synchronized (this.lock) {
            PopupWindow popupWindow = this.zzdps;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.zzdpt.removeView(this.zzdjd.getView());
                ViewGroup viewGroup = this.zzdpu;
                if (viewGroup != null) {
                    viewGroup.removeView(this.zzdpq);
                    this.zzdpu.addView(this.zzdjd.getView());
                    this.zzdjd.zza(this.zzdpp);
                }
                if (z) {
                    zzdu(IADStatisticBase.VARCHAR_DEFALUT_VALUE);
                    zzaqt zzaqtVar = this.zzdhy;
                    if (zzaqtVar != null) {
                        zzaqtVar.zzvq();
                    }
                }
                this.zzdps = null;
                this.zzdpt = null;
                this.zzdpu = null;
                this.zzdpr = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0214 A[Catch: all -> 0x04a9, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0136, B:67:0x0142, B:138:0x028d, B:139:0x0292, B:141:0x0294, B:143:0x02b6, B:145:0x02ba, B:147:0x02ca, B:149:0x02fa, B:153:0x032c, B:154:0x0360, B:184:0x03b6, B:191:0x03e5, B:192:0x03fd, B:193:0x041f, B:195:0x0427, B:196:0x042e, B:197:0x0453, B:200:0x0456, B:202:0x0466, B:204:0x0470, B:206:0x0482, B:207:0x0499, B:203:0x046b, B:185:0x03bd, B:186:0x03c4, B:187:0x03cb, B:188:0x03d2, B:189:0x03d8, B:190:0x03df, B:156:0x0364, B:159:0x036e, B:162:0x0378, B:165:0x0382, B:168:0x038c, B:171:0x0396, B:148:0x02f7, B:209:0x049b, B:210:0x04a0, B:121:0x0233, B:123:0x0237, B:124:0x0248, B:130:0x0272, B:132:0x0276, B:136:0x0285, B:133:0x0279, B:135:0x0281, B:127:0x026a, B:129:0x0270, B:68:0x0149, B:70:0x014d, B:71:0x0153, B:98:0x01a0, B:106:0x0211, B:108:0x0214, B:110:0x0217, B:112:0x021b, B:99:0x01ae, B:102:0x01de, B:100:0x01bf, B:101:0x01d2, B:103:0x01e1, B:104:0x01f8, B:105:0x0208, B:73:0x0157, B:76:0x0161, B:79:0x016b, B:82:0x0175, B:85:0x017f, B:88:0x0189, B:116:0x0223, B:117:0x0229, B:212:0x04a2, B:213:0x04a7), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0233 A[Catch: all -> 0x04a9, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0136, B:67:0x0142, B:138:0x028d, B:139:0x0292, B:141:0x0294, B:143:0x02b6, B:145:0x02ba, B:147:0x02ca, B:149:0x02fa, B:153:0x032c, B:154:0x0360, B:184:0x03b6, B:191:0x03e5, B:192:0x03fd, B:193:0x041f, B:195:0x0427, B:196:0x042e, B:197:0x0453, B:200:0x0456, B:202:0x0466, B:204:0x0470, B:206:0x0482, B:207:0x0499, B:203:0x046b, B:185:0x03bd, B:186:0x03c4, B:187:0x03cb, B:188:0x03d2, B:189:0x03d8, B:190:0x03df, B:156:0x0364, B:159:0x036e, B:162:0x0378, B:165:0x0382, B:168:0x038c, B:171:0x0396, B:148:0x02f7, B:209:0x049b, B:210:0x04a0, B:121:0x0233, B:123:0x0237, B:124:0x0248, B:130:0x0272, B:132:0x0276, B:136:0x0285, B:133:0x0279, B:135:0x0281, B:127:0x026a, B:129:0x0270, B:68:0x0149, B:70:0x014d, B:71:0x0153, B:98:0x01a0, B:106:0x0211, B:108:0x0214, B:110:0x0217, B:112:0x021b, B:99:0x01ae, B:102:0x01de, B:100:0x01bf, B:101:0x01d2, B:103:0x01e1, B:104:0x01f8, B:105:0x0208, B:73:0x0157, B:76:0x0161, B:79:0x016b, B:82:0x0175, B:85:0x017f, B:88:0x0189, B:116:0x0223, B:117:0x0229, B:212:0x04a2, B:213:0x04a7), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x028d A[Catch: all -> 0x04a9, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0136, B:67:0x0142, B:138:0x028d, B:139:0x0292, B:141:0x0294, B:143:0x02b6, B:145:0x02ba, B:147:0x02ca, B:149:0x02fa, B:153:0x032c, B:154:0x0360, B:184:0x03b6, B:191:0x03e5, B:192:0x03fd, B:193:0x041f, B:195:0x0427, B:196:0x042e, B:197:0x0453, B:200:0x0456, B:202:0x0466, B:204:0x0470, B:206:0x0482, B:207:0x0499, B:203:0x046b, B:185:0x03bd, B:186:0x03c4, B:187:0x03cb, B:188:0x03d2, B:189:0x03d8, B:190:0x03df, B:156:0x0364, B:159:0x036e, B:162:0x0378, B:165:0x0382, B:168:0x038c, B:171:0x0396, B:148:0x02f7, B:209:0x049b, B:210:0x04a0, B:121:0x0233, B:123:0x0237, B:124:0x0248, B:130:0x0272, B:132:0x0276, B:136:0x0285, B:133:0x0279, B:135:0x0281, B:127:0x026a, B:129:0x0270, B:68:0x0149, B:70:0x014d, B:71:0x0153, B:98:0x01a0, B:106:0x0211, B:108:0x0214, B:110:0x0217, B:112:0x021b, B:99:0x01ae, B:102:0x01de, B:100:0x01bf, B:101:0x01d2, B:103:0x01e1, B:104:0x01f8, B:105:0x0208, B:73:0x0157, B:76:0x0161, B:79:0x016b, B:82:0x0175, B:85:0x017f, B:88:0x0189, B:116:0x0223, B:117:0x0229, B:212:0x04a2, B:213:0x04a7), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0294 A[Catch: all -> 0x04a9, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0136, B:67:0x0142, B:138:0x028d, B:139:0x0292, B:141:0x0294, B:143:0x02b6, B:145:0x02ba, B:147:0x02ca, B:149:0x02fa, B:153:0x032c, B:154:0x0360, B:184:0x03b6, B:191:0x03e5, B:192:0x03fd, B:193:0x041f, B:195:0x0427, B:196:0x042e, B:197:0x0453, B:200:0x0456, B:202:0x0466, B:204:0x0470, B:206:0x0482, B:207:0x0499, B:203:0x046b, B:185:0x03bd, B:186:0x03c4, B:187:0x03cb, B:188:0x03d2, B:189:0x03d8, B:190:0x03df, B:156:0x0364, B:159:0x036e, B:162:0x0378, B:165:0x0382, B:168:0x038c, B:171:0x0396, B:148:0x02f7, B:209:0x049b, B:210:0x04a0, B:121:0x0233, B:123:0x0237, B:124:0x0248, B:130:0x0272, B:132:0x0276, B:136:0x0285, B:133:0x0279, B:135:0x0281, B:127:0x026a, B:129:0x0270, B:68:0x0149, B:70:0x014d, B:71:0x0153, B:98:0x01a0, B:106:0x0211, B:108:0x0214, B:110:0x0217, B:112:0x021b, B:99:0x01ae, B:102:0x01de, B:100:0x01bf, B:101:0x01d2, B:103:0x01e1, B:104:0x01f8, B:105:0x0208, B:73:0x0157, B:76:0x0161, B:79:0x016b, B:82:0x0175, B:85:0x017f, B:88:0x0189, B:116:0x0223, B:117:0x0229, B:212:0x04a2, B:213:0x04a7), top: B:220:0x0007, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            Method dump skipped, instructions count: 1248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqg.zzg(java.util.Map):void");
    }

    public final void zzi(int i2, int i3) {
        this.zzdpl = i2;
        this.zzdpm = i3;
    }

    public final boolean zzvp() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdps != null;
        }
        return z;
    }
}
