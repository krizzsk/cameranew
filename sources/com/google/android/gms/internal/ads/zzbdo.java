package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbdo extends zzbdd {
    private static final Set<String> zzeqc = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzeqd = new DecimalFormat("#,###");
    private File zzdb;
    private boolean zzeqe;

    public zzbdo(zzbbo zzbboVar) {
        super(zzbboVar);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzazk.zzex("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.zzdb = file;
        if (!file.isDirectory() && !this.zzdb.mkdirs()) {
            String valueOf = String.valueOf(this.zzdb.getAbsolutePath());
            zzazk.zzex(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzdb = null;
        } else if (this.zzdb.setReadable(true, false) && this.zzdb.setExecutable(true, false)) {
        } else {
            String valueOf2 = String.valueOf(this.zzdb.getAbsolutePath());
            zzazk.zzex(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzdb = null;
        }
    }

    private final File zzd(File file) {
        return new File(this.zzdb, String.valueOf(file.getName()).concat(".done"));
    }

    @Override // com.google.android.gms.internal.ads.zzbdd
    public final void abort() {
        this.zzeqe = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01ea, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01ec, code lost:
        r1 = r5.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01f2, code lost:
        if (r1 < 400) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f4, code lost:
        r15 = "badUrl";
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0204, code lost:
        if (r2.length() == 0) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0206, code lost:
        r2 = "HTTP request failed. Code: ".concat(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x020c, code lost:
        r2 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0211, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r1);
        r4.append(" at ");
        r4.append(r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0239, code lost:
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x023a, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x023c, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x023e, code lost:
        r7 = r5.getContentLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0242, code lost:
        if (r7 >= 0) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0244, code lost:
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x024e, code lost:
        if (r1.length() == 0) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0250, code lost:
        r0 = "Stream cache aborted, missing content-length header at ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0255, code lost:
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x025b, code lost:
        com.google.android.gms.internal.ads.zzazk.zzex(r0);
        zza(r31, r12.getAbsolutePath(), "contentLengthMissing", null);
        com.google.android.gms.internal.ads.zzbdo.zzeqc.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x026c, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x026d, code lost:
        r1 = com.google.android.gms.internal.ads.zzbdo.zzeqd.format(r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwr.zzqr().zzd(com.google.android.gms.internal.ads.zzabp.zzcmy)).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0284, code lost:
        if (r7 <= r3) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0286, code lost:
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r31);
        com.google.android.gms.internal.ads.zzazk.zzex(r2.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02bf, code lost:
        if (r1.length() == 0) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02c1, code lost:
        r0 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02c6, code lost:
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02cc, code lost:
        zza(r31, r12.getAbsolutePath(), "sizeExceeded", r0);
        com.google.android.gms.internal.ads.zzbdo.zzeqc.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02da, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02db, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r31);
        com.google.android.gms.internal.ads.zzazk.zzdy(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0316, code lost:
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzr.zzky();
        r17 = r16.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0334, code lost:
        r10 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0335, code lost:
        r6 = new com.google.android.gms.ads.internal.util.zzbp(((java.lang.Long) com.google.android.gms.internal.ads.zzwr.zzqr().zzd(com.google.android.gms.internal.ads.zzabp.zzcnb)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzwr.zzqr().zzd(com.google.android.gms.internal.ads.zzabp.zzcna)).longValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x034e, code lost:
        r20 = r5.read(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0352, code lost:
        if (r20 < 0) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0354, code lost:
        r11 = r11 + r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0356, code lost:
        if (r11 <= r3) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0358, code lost:
        r15 = "sizeExceeded";
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0368, code lost:
        if (r1.length() == 0) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x036a, code lost:
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0370, code lost:
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x037c, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x037f, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0380, code lost:
        r2 = r1;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0385, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0386, code lost:
        r1 = r10;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0388, code lost:
        r10 = r4;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x038b, code lost:
        r1.flip();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0392, code lost:
        if (r2.write(r1) > 0) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0394, code lost:
        r1.clear();
        r24 = ((r16.currentTimeMillis() - r17) > (1000 * r13) ? 1 : ((r16.currentTimeMillis() - r17) == (1000 * r13) ? 0 : -1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03a3, code lost:
        if (r24 > 0) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03a5, code lost:
        r20 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03a9, code lost:
        if (r30.zzeqe != false) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03af, code lost:
        if (r6.tryAcquire() == false) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03b7, code lost:
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03bb, code lost:
        r24 = r10;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03d9, code lost:
        com.google.android.gms.internal.ads.zzaza.zzaac.post(new com.google.android.gms.internal.ads.zzbdg(r30, r31, r12.getAbsolutePath(), r11, r7, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03e0, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03e2, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03e3, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03e8, code lost:
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x03fa, code lost:
        r6 = r19;
        r1 = r20;
        r5 = r21;
        r15 = r22;
        r10 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r7 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x041d, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x041e, code lost:
        r27 = r4;
        r24 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0424, code lost:
        r15 = "downloadTimeout";
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0426, code lost:
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
        r10 = r2.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0451, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0452, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0455, code lost:
        r2 = r10;
        r1 = r24;
        r10 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x045c, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x045e, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0460, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0463, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x046a, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0472, code lost:
        r27.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0479, code lost:
        if (com.google.android.gms.internal.ads.zzazk.isLoggable(3) == false) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x047b, code lost:
        r1 = com.google.android.gms.internal.ads.zzbdo.zzeqd.format(r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r31);
        com.google.android.gms.internal.ads.zzazk.zzdy(r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x04b2, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x04b4, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x04b5, code lost:
        r15 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x04b7, code lost:
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x04bc, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x04c3, code lost:
        if (r0.isFile() == false) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x04c5, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x04cd, code lost:
        r0.createNewFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x04e4, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x04e7, code lost:
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x04ee, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x04ef, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x04f5, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x04f6, code lost:
        r27 = r4;
        r1 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x04f9, code lost:
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x0518: MOVE  (r15 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY]), block:B:240:0x0518 */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x05a1  */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4, types: [int] */
    /* JADX WARN: Type inference failed for: r24v9 */
    @Override // com.google.android.gms.internal.ads.zzbdd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzfg(java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 1467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdo.zzfg(java.lang.String):boolean");
    }
}
