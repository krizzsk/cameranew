package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzhm implements Handler.Callback, zznb, zznd, zzok {
    private final Handler handler;
    private int repeatMode = 0;
    private int state = 1;
    private final zzhy[] zzaeq;
    private final zzoh zzaer;
    private final Handler zzaet;
    private final zzie zzaew;
    private final zzif zzaex;
    private boolean zzaez;
    private boolean zzafd;
    private zzid zzafe;
    private zzhz zzafi;
    private zzho zzafj;
    private final zzib[] zzafn;
    private final zzhx zzafo;
    private final zzps zzafp;
    private final HandlerThread zzafq;
    private final zzhh zzafr;
    private zzhy zzafs;
    private zzpk zzaft;
    private zzne zzafu;
    private zzhy[] zzafv;
    private boolean zzafw;
    private boolean zzafx;
    private int zzafy;
    private int zzafz;
    private long zzaga;
    private int zzagb;
    private zzhr zzagc;
    private long zzagd;
    private zzhp zzage;
    private zzhp zzagf;
    private zzhp zzagg;

    public zzhm(zzhy[] zzhyVarArr, zzoh zzohVar, zzhx zzhxVar, boolean z, int i2, Handler handler, zzho zzhoVar, zzhh zzhhVar) {
        this.zzaeq = zzhyVarArr;
        this.zzaer = zzohVar;
        this.zzafo = zzhxVar;
        this.zzaez = z;
        this.zzaet = handler;
        this.zzafj = zzhoVar;
        this.zzafr = zzhhVar;
        this.zzafn = new zzib[zzhyVarArr.length];
        for (int i3 = 0; i3 < zzhyVarArr.length; i3++) {
            zzhyVarArr[i3].setIndex(i3);
            this.zzafn[i3] = zzhyVarArr[i3].zzdz();
        }
        this.zzafp = new zzps();
        this.zzafv = new zzhy[0];
        this.zzaew = new zzie();
        this.zzaex = new zzif();
        zzohVar.zza(this);
        this.zzafi = zzhz.zzaia;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzafq = handlerThread;
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), this);
    }

    private final void setState(int i2) {
        if (this.state != i2) {
            this.state = i2;
            this.zzaet.obtainMessage(1, i2, 0).sendToTarget();
        }
    }

    private final Pair<Integer, Long> zzc(int i2, long j2) {
        return zzb(this.zzafe, 0, -9223372036854775807L);
    }

    private final void zzdq(long j2) throws zzhe {
        zzhp zzhpVar = this.zzagg;
        long zzew = j2 + (zzhpVar == null ? 60000000L : zzhpVar.zzew());
        this.zzagd = zzew;
        this.zzafp.zzel(zzew);
        for (zzhy zzhyVar : this.zzafv) {
            zzhyVar.zzdm(this.zzagd);
        }
    }

    private final boolean zzdr(long j2) {
        if (j2 == -9223372036854775807L || this.zzafj.zzagk < j2) {
            return true;
        }
        zzhp zzhpVar = this.zzagg.zzagu;
        return zzhpVar != null && zzhpVar.zzags;
    }

    private final void zzeq() throws zzhe {
        this.zzafx = false;
        this.zzafp.start();
        for (zzhy zzhyVar : this.zzafv) {
            zzhyVar.start();
        }
    }

    private final void zzer() throws zzhe {
        this.zzafp.stop();
        for (zzhy zzhyVar : this.zzafv) {
            zza(zzhyVar);
        }
    }

    private final void zzes() throws zzhe {
        zzhp zzhpVar = this.zzagg;
        if (zzhpVar == null) {
            return;
        }
        long zzhq = zzhpVar.zzagm.zzhq();
        if (zzhq != -9223372036854775807L) {
            zzdq(zzhq);
        } else {
            zzhy zzhyVar = this.zzafs;
            if (zzhyVar != null && !zzhyVar.zzfe()) {
                long zzgc = this.zzaft.zzgc();
                this.zzagd = zzgc;
                this.zzafp.zzel(zzgc);
            } else {
                this.zzagd = this.zzafp.zzgc();
            }
            zzhq = this.zzagd - this.zzagg.zzew();
        }
        this.zzafj.zzagk = zzhq;
        this.zzaga = SystemClock.elapsedRealtime() * 1000;
        long zzhr = this.zzafv.length == 0 ? Long.MIN_VALUE : this.zzagg.zzagm.zzhr();
        zzho zzhoVar = this.zzafj;
        if (zzhr == Long.MIN_VALUE) {
            zzhr = this.zzafe.zza(this.zzagg.zzagi, this.zzaex, false).zzaip;
        }
        zzhoVar.zzagl = zzhr;
    }

    private final void zzet() {
        zzi(true);
        this.zzafo.onStopped();
        setState(1);
    }

    private final void zzeu() throws IOException {
        zzhp zzhpVar = this.zzage;
        if (zzhpVar == null || zzhpVar.zzags) {
            return;
        }
        zzhp zzhpVar2 = this.zzagf;
        if (zzhpVar2 == null || zzhpVar2.zzagu == zzhpVar) {
            for (zzhy zzhyVar : this.zzafv) {
                if (!zzhyVar.zzec()) {
                    return;
                }
            }
            this.zzage.zzagm.zzho();
        }
    }

    private final void zzev() {
        zzhp zzhpVar = this.zzage;
        long zzhn = !zzhpVar.zzags ? 0L : zzhpVar.zzagm.zzhn();
        if (zzhn == Long.MIN_VALUE) {
            zzh(false);
            return;
        }
        long zzew = this.zzagd - this.zzage.zzew();
        boolean zzdt = this.zzafo.zzdt(zzhn - zzew);
        zzh(zzdt);
        if (zzdt) {
            this.zzage.zzagm.zzee(zzew);
        }
    }

    private final void zzh(boolean z) {
        if (this.zzafd != z) {
            this.zzafd = z;
            this.zzaet.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzi(boolean z) {
        zzhy[] zzhyVarArr;
        this.handler.removeMessages(2);
        this.zzafx = false;
        this.zzafp.stop();
        this.zzaft = null;
        this.zzafs = null;
        this.zzagd = 60000000L;
        for (zzhy zzhyVar : this.zzafv) {
            try {
                zza(zzhyVar);
                zzhyVar.disable();
            } catch (zzhe | RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.zzafv = new zzhy[0];
        zzhp zzhpVar = this.zzagg;
        if (zzhpVar == null) {
            zzhpVar = this.zzage;
        }
        zza(zzhpVar);
        this.zzage = null;
        this.zzagf = null;
        this.zzagg = null;
        zzh(false);
        if (z) {
            zzne zzneVar = this.zzafu;
            if (zzneVar != null) {
                zzneVar.zzia();
                this.zzafu = null;
            }
            this.zzafe = null;
        }
    }

    private final boolean zzu(int i2) {
        this.zzafe.zza(i2, this.zzaex, false);
        this.zzafe.zza(0, this.zzaew, false);
        return this.zzafe.zza(i2, this.zzaex, this.zzaew, this.repeatMode) == -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x005e, code lost:
        zza(r12);
        r2.zzagu = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0263 A[Catch: IOException -> 0x082f, zzhe -> 0x0834, RuntimeException -> 0x0839, TryCatch #9 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:7:0x0019, B:12:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:29:0x0051, B:33:0x0059, B:35:0x005e, B:36:0x0063, B:38:0x006d, B:40:0x0071, B:42:0x0075, B:43:0x0086, B:46:0x008c, B:10:0x0022, B:48:0x0090, B:55:0x00ae, B:62:0x00bc, B:65:0x00bf, B:68:0x00c9, B:72:0x00cd, B:73:0x00ce, B:77:0x00d5, B:80:0x00db, B:82:0x00e1, B:85:0x00e6, B:87:0x00eb, B:91:0x00f4, B:93:0x0116, B:94:0x011d, B:95:0x0124, B:97:0x0129, B:101:0x0134, B:103:0x013e, B:104:0x0140, B:106:0x0144, B:108:0x014a, B:111:0x0150, B:112:0x0157, B:113:0x015b, B:114:0x0162, B:116:0x0166, B:117:0x016b, B:118:0x016e, B:125:0x01a3, B:119:0x017d, B:121:0x0183, B:122:0x0189, B:124:0x0191, B:127:0x01af, B:129:0x01b7, B:132:0x01bc, B:134:0x01c0, B:136:0x01c8, B:139:0x01cd, B:141:0x01de, B:142:0x01ec, B:144:0x01f0, B:146:0x0200, B:148:0x0204, B:150:0x0212, B:151:0x0217, B:159:0x025e, B:164:0x0267, B:166:0x0271, B:168:0x027b, B:169:0x0280, B:170:0x02a8, B:172:0x02ac, B:176:0x02b7, B:177:0x02ba, B:178:0x02c7, B:182:0x02d5, B:184:0x02db, B:185:0x02ec, B:187:0x02f0, B:189:0x02fe, B:191:0x0310, B:195:0x031e, B:197:0x0323, B:198:0x0337, B:199:0x033e, B:162:0x0263, B:152:0x022f, B:154:0x0237, B:156:0x023d, B:157:0x0242, B:201:0x0342, B:202:0x034d, B:209:0x0358, B:210:0x0359, B:212:0x035d, B:214:0x0365, B:216:0x0370, B:215:0x036a, B:218:0x037c, B:220:0x0384, B:221:0x038d, B:223:0x0393, B:224:0x03b1, B:228:0x03ba, B:234:0x03db, B:238:0x03e9, B:246:0x03fd, B:250:0x040b, B:253:0x0414, B:257:0x0423, B:258:0x042a, B:259:0x042b, B:261:0x0433, B:371:0x0666, B:373:0x066c, B:374:0x0674, B:376:0x068f, B:378:0x069a, B:382:0x06a3, B:384:0x06a9, B:390:0x06b5, B:395:0x06bf, B:397:0x06c6, B:398:0x06c9, B:400:0x06cd, B:402:0x06d9, B:403:0x06ec, B:407:0x0705, B:409:0x070d, B:411:0x0713, B:444:0x0795, B:446:0x0799, B:448:0x079e, B:449:0x07a6, B:451:0x07aa, B:455:0x07b3, B:460:0x07c9, B:453:0x07af, B:456:0x07b9, B:458:0x07be, B:459:0x07c4, B:412:0x071d, B:414:0x0722, B:417:0x0729, B:419:0x0731, B:423:0x0740, B:433:0x0770, B:435:0x0778, B:426:0x0748, B:427:0x0754, B:420:0x0734, B:431:0x076a, B:438:0x077f, B:443:0x078b, B:441:0x0785, B:262:0x043b, B:264:0x043f, B:277:0x047a, B:279:0x0482, B:304:0x0554, B:306:0x0558, B:309:0x055f, B:311:0x0563, B:313:0x0567, B:315:0x056e, B:317:0x0572, B:319:0x0578, B:321:0x0582, B:322:0x05a9, B:325:0x05ae, B:327:0x05b3, B:329:0x05bd, B:331:0x05c3, B:333:0x05c9, B:334:0x05cc, B:336:0x05d0, B:338:0x05d5, B:341:0x05e5, B:344:0x05ed, B:345:0x05f0, B:347:0x05f6, B:349:0x05fa, B:354:0x0613, B:356:0x0618, B:359:0x0624, B:361:0x062a, B:363:0x063a, B:365:0x0640, B:367:0x0649, B:368:0x0652, B:369:0x0660, B:370:0x0663, B:314:0x056b, B:281:0x048a, B:283:0x048e, B:291:0x04e9, B:293:0x04ed, B:296:0x0508, B:300:0x0514, B:302:0x0548, B:303:0x054a, B:299:0x050f, B:295:0x04f4, B:285:0x0494, B:288:0x04a5, B:290:0x04d8, B:265:0x0444, B:267:0x044a, B:269:0x0450, B:272:0x045f, B:274:0x0463, B:276:0x046e, B:462:0x07cd, B:466:0x07d5, B:468:0x07db, B:469:0x07e2, B:471:0x07e7, B:473:0x07f2, B:475:0x07f8, B:479:0x0804, B:481:0x0813, B:482:0x081f), top: B:509:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0267 A[Catch: IOException -> 0x082f, zzhe -> 0x0834, RuntimeException -> 0x0839, TryCatch #9 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:7:0x0019, B:12:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:29:0x0051, B:33:0x0059, B:35:0x005e, B:36:0x0063, B:38:0x006d, B:40:0x0071, B:42:0x0075, B:43:0x0086, B:46:0x008c, B:10:0x0022, B:48:0x0090, B:55:0x00ae, B:62:0x00bc, B:65:0x00bf, B:68:0x00c9, B:72:0x00cd, B:73:0x00ce, B:77:0x00d5, B:80:0x00db, B:82:0x00e1, B:85:0x00e6, B:87:0x00eb, B:91:0x00f4, B:93:0x0116, B:94:0x011d, B:95:0x0124, B:97:0x0129, B:101:0x0134, B:103:0x013e, B:104:0x0140, B:106:0x0144, B:108:0x014a, B:111:0x0150, B:112:0x0157, B:113:0x015b, B:114:0x0162, B:116:0x0166, B:117:0x016b, B:118:0x016e, B:125:0x01a3, B:119:0x017d, B:121:0x0183, B:122:0x0189, B:124:0x0191, B:127:0x01af, B:129:0x01b7, B:132:0x01bc, B:134:0x01c0, B:136:0x01c8, B:139:0x01cd, B:141:0x01de, B:142:0x01ec, B:144:0x01f0, B:146:0x0200, B:148:0x0204, B:150:0x0212, B:151:0x0217, B:159:0x025e, B:164:0x0267, B:166:0x0271, B:168:0x027b, B:169:0x0280, B:170:0x02a8, B:172:0x02ac, B:176:0x02b7, B:177:0x02ba, B:178:0x02c7, B:182:0x02d5, B:184:0x02db, B:185:0x02ec, B:187:0x02f0, B:189:0x02fe, B:191:0x0310, B:195:0x031e, B:197:0x0323, B:198:0x0337, B:199:0x033e, B:162:0x0263, B:152:0x022f, B:154:0x0237, B:156:0x023d, B:157:0x0242, B:201:0x0342, B:202:0x034d, B:209:0x0358, B:210:0x0359, B:212:0x035d, B:214:0x0365, B:216:0x0370, B:215:0x036a, B:218:0x037c, B:220:0x0384, B:221:0x038d, B:223:0x0393, B:224:0x03b1, B:228:0x03ba, B:234:0x03db, B:238:0x03e9, B:246:0x03fd, B:250:0x040b, B:253:0x0414, B:257:0x0423, B:258:0x042a, B:259:0x042b, B:261:0x0433, B:371:0x0666, B:373:0x066c, B:374:0x0674, B:376:0x068f, B:378:0x069a, B:382:0x06a3, B:384:0x06a9, B:390:0x06b5, B:395:0x06bf, B:397:0x06c6, B:398:0x06c9, B:400:0x06cd, B:402:0x06d9, B:403:0x06ec, B:407:0x0705, B:409:0x070d, B:411:0x0713, B:444:0x0795, B:446:0x0799, B:448:0x079e, B:449:0x07a6, B:451:0x07aa, B:455:0x07b3, B:460:0x07c9, B:453:0x07af, B:456:0x07b9, B:458:0x07be, B:459:0x07c4, B:412:0x071d, B:414:0x0722, B:417:0x0729, B:419:0x0731, B:423:0x0740, B:433:0x0770, B:435:0x0778, B:426:0x0748, B:427:0x0754, B:420:0x0734, B:431:0x076a, B:438:0x077f, B:443:0x078b, B:441:0x0785, B:262:0x043b, B:264:0x043f, B:277:0x047a, B:279:0x0482, B:304:0x0554, B:306:0x0558, B:309:0x055f, B:311:0x0563, B:313:0x0567, B:315:0x056e, B:317:0x0572, B:319:0x0578, B:321:0x0582, B:322:0x05a9, B:325:0x05ae, B:327:0x05b3, B:329:0x05bd, B:331:0x05c3, B:333:0x05c9, B:334:0x05cc, B:336:0x05d0, B:338:0x05d5, B:341:0x05e5, B:344:0x05ed, B:345:0x05f0, B:347:0x05f6, B:349:0x05fa, B:354:0x0613, B:356:0x0618, B:359:0x0624, B:361:0x062a, B:363:0x063a, B:365:0x0640, B:367:0x0649, B:368:0x0652, B:369:0x0660, B:370:0x0663, B:314:0x056b, B:281:0x048a, B:283:0x048e, B:291:0x04e9, B:293:0x04ed, B:296:0x0508, B:300:0x0514, B:302:0x0548, B:303:0x054a, B:299:0x050f, B:295:0x04f4, B:285:0x0494, B:288:0x04a5, B:290:0x04d8, B:265:0x0444, B:267:0x044a, B:269:0x0450, B:272:0x045f, B:274:0x0463, B:276:0x046e, B:462:0x07cd, B:466:0x07d5, B:468:0x07db, B:469:0x07e2, B:471:0x07e7, B:473:0x07f2, B:475:0x07f8, B:479:0x0804, B:481:0x0813, B:482:0x081f), top: B:509:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04ed A[Catch: IOException -> 0x082f, zzhe -> 0x0834, RuntimeException -> 0x0839, TryCatch #9 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:7:0x0019, B:12:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:29:0x0051, B:33:0x0059, B:35:0x005e, B:36:0x0063, B:38:0x006d, B:40:0x0071, B:42:0x0075, B:43:0x0086, B:46:0x008c, B:10:0x0022, B:48:0x0090, B:55:0x00ae, B:62:0x00bc, B:65:0x00bf, B:68:0x00c9, B:72:0x00cd, B:73:0x00ce, B:77:0x00d5, B:80:0x00db, B:82:0x00e1, B:85:0x00e6, B:87:0x00eb, B:91:0x00f4, B:93:0x0116, B:94:0x011d, B:95:0x0124, B:97:0x0129, B:101:0x0134, B:103:0x013e, B:104:0x0140, B:106:0x0144, B:108:0x014a, B:111:0x0150, B:112:0x0157, B:113:0x015b, B:114:0x0162, B:116:0x0166, B:117:0x016b, B:118:0x016e, B:125:0x01a3, B:119:0x017d, B:121:0x0183, B:122:0x0189, B:124:0x0191, B:127:0x01af, B:129:0x01b7, B:132:0x01bc, B:134:0x01c0, B:136:0x01c8, B:139:0x01cd, B:141:0x01de, B:142:0x01ec, B:144:0x01f0, B:146:0x0200, B:148:0x0204, B:150:0x0212, B:151:0x0217, B:159:0x025e, B:164:0x0267, B:166:0x0271, B:168:0x027b, B:169:0x0280, B:170:0x02a8, B:172:0x02ac, B:176:0x02b7, B:177:0x02ba, B:178:0x02c7, B:182:0x02d5, B:184:0x02db, B:185:0x02ec, B:187:0x02f0, B:189:0x02fe, B:191:0x0310, B:195:0x031e, B:197:0x0323, B:198:0x0337, B:199:0x033e, B:162:0x0263, B:152:0x022f, B:154:0x0237, B:156:0x023d, B:157:0x0242, B:201:0x0342, B:202:0x034d, B:209:0x0358, B:210:0x0359, B:212:0x035d, B:214:0x0365, B:216:0x0370, B:215:0x036a, B:218:0x037c, B:220:0x0384, B:221:0x038d, B:223:0x0393, B:224:0x03b1, B:228:0x03ba, B:234:0x03db, B:238:0x03e9, B:246:0x03fd, B:250:0x040b, B:253:0x0414, B:257:0x0423, B:258:0x042a, B:259:0x042b, B:261:0x0433, B:371:0x0666, B:373:0x066c, B:374:0x0674, B:376:0x068f, B:378:0x069a, B:382:0x06a3, B:384:0x06a9, B:390:0x06b5, B:395:0x06bf, B:397:0x06c6, B:398:0x06c9, B:400:0x06cd, B:402:0x06d9, B:403:0x06ec, B:407:0x0705, B:409:0x070d, B:411:0x0713, B:444:0x0795, B:446:0x0799, B:448:0x079e, B:449:0x07a6, B:451:0x07aa, B:455:0x07b3, B:460:0x07c9, B:453:0x07af, B:456:0x07b9, B:458:0x07be, B:459:0x07c4, B:412:0x071d, B:414:0x0722, B:417:0x0729, B:419:0x0731, B:423:0x0740, B:433:0x0770, B:435:0x0778, B:426:0x0748, B:427:0x0754, B:420:0x0734, B:431:0x076a, B:438:0x077f, B:443:0x078b, B:441:0x0785, B:262:0x043b, B:264:0x043f, B:277:0x047a, B:279:0x0482, B:304:0x0554, B:306:0x0558, B:309:0x055f, B:311:0x0563, B:313:0x0567, B:315:0x056e, B:317:0x0572, B:319:0x0578, B:321:0x0582, B:322:0x05a9, B:325:0x05ae, B:327:0x05b3, B:329:0x05bd, B:331:0x05c3, B:333:0x05c9, B:334:0x05cc, B:336:0x05d0, B:338:0x05d5, B:341:0x05e5, B:344:0x05ed, B:345:0x05f0, B:347:0x05f6, B:349:0x05fa, B:354:0x0613, B:356:0x0618, B:359:0x0624, B:361:0x062a, B:363:0x063a, B:365:0x0640, B:367:0x0649, B:368:0x0652, B:369:0x0660, B:370:0x0663, B:314:0x056b, B:281:0x048a, B:283:0x048e, B:291:0x04e9, B:293:0x04ed, B:296:0x0508, B:300:0x0514, B:302:0x0548, B:303:0x054a, B:299:0x050f, B:295:0x04f4, B:285:0x0494, B:288:0x04a5, B:290:0x04d8, B:265:0x0444, B:267:0x044a, B:269:0x0450, B:272:0x045f, B:274:0x0463, B:276:0x046e, B:462:0x07cd, B:466:0x07d5, B:468:0x07db, B:469:0x07e2, B:471:0x07e7, B:473:0x07f2, B:475:0x07f8, B:479:0x0804, B:481:0x0813, B:482:0x081f), top: B:509:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x04f4 A[Catch: IOException -> 0x082f, zzhe -> 0x0834, RuntimeException -> 0x0839, TryCatch #9 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:7:0x0019, B:12:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:29:0x0051, B:33:0x0059, B:35:0x005e, B:36:0x0063, B:38:0x006d, B:40:0x0071, B:42:0x0075, B:43:0x0086, B:46:0x008c, B:10:0x0022, B:48:0x0090, B:55:0x00ae, B:62:0x00bc, B:65:0x00bf, B:68:0x00c9, B:72:0x00cd, B:73:0x00ce, B:77:0x00d5, B:80:0x00db, B:82:0x00e1, B:85:0x00e6, B:87:0x00eb, B:91:0x00f4, B:93:0x0116, B:94:0x011d, B:95:0x0124, B:97:0x0129, B:101:0x0134, B:103:0x013e, B:104:0x0140, B:106:0x0144, B:108:0x014a, B:111:0x0150, B:112:0x0157, B:113:0x015b, B:114:0x0162, B:116:0x0166, B:117:0x016b, B:118:0x016e, B:125:0x01a3, B:119:0x017d, B:121:0x0183, B:122:0x0189, B:124:0x0191, B:127:0x01af, B:129:0x01b7, B:132:0x01bc, B:134:0x01c0, B:136:0x01c8, B:139:0x01cd, B:141:0x01de, B:142:0x01ec, B:144:0x01f0, B:146:0x0200, B:148:0x0204, B:150:0x0212, B:151:0x0217, B:159:0x025e, B:164:0x0267, B:166:0x0271, B:168:0x027b, B:169:0x0280, B:170:0x02a8, B:172:0x02ac, B:176:0x02b7, B:177:0x02ba, B:178:0x02c7, B:182:0x02d5, B:184:0x02db, B:185:0x02ec, B:187:0x02f0, B:189:0x02fe, B:191:0x0310, B:195:0x031e, B:197:0x0323, B:198:0x0337, B:199:0x033e, B:162:0x0263, B:152:0x022f, B:154:0x0237, B:156:0x023d, B:157:0x0242, B:201:0x0342, B:202:0x034d, B:209:0x0358, B:210:0x0359, B:212:0x035d, B:214:0x0365, B:216:0x0370, B:215:0x036a, B:218:0x037c, B:220:0x0384, B:221:0x038d, B:223:0x0393, B:224:0x03b1, B:228:0x03ba, B:234:0x03db, B:238:0x03e9, B:246:0x03fd, B:250:0x040b, B:253:0x0414, B:257:0x0423, B:258:0x042a, B:259:0x042b, B:261:0x0433, B:371:0x0666, B:373:0x066c, B:374:0x0674, B:376:0x068f, B:378:0x069a, B:382:0x06a3, B:384:0x06a9, B:390:0x06b5, B:395:0x06bf, B:397:0x06c6, B:398:0x06c9, B:400:0x06cd, B:402:0x06d9, B:403:0x06ec, B:407:0x0705, B:409:0x070d, B:411:0x0713, B:444:0x0795, B:446:0x0799, B:448:0x079e, B:449:0x07a6, B:451:0x07aa, B:455:0x07b3, B:460:0x07c9, B:453:0x07af, B:456:0x07b9, B:458:0x07be, B:459:0x07c4, B:412:0x071d, B:414:0x0722, B:417:0x0729, B:419:0x0731, B:423:0x0740, B:433:0x0770, B:435:0x0778, B:426:0x0748, B:427:0x0754, B:420:0x0734, B:431:0x076a, B:438:0x077f, B:443:0x078b, B:441:0x0785, B:262:0x043b, B:264:0x043f, B:277:0x047a, B:279:0x0482, B:304:0x0554, B:306:0x0558, B:309:0x055f, B:311:0x0563, B:313:0x0567, B:315:0x056e, B:317:0x0572, B:319:0x0578, B:321:0x0582, B:322:0x05a9, B:325:0x05ae, B:327:0x05b3, B:329:0x05bd, B:331:0x05c3, B:333:0x05c9, B:334:0x05cc, B:336:0x05d0, B:338:0x05d5, B:341:0x05e5, B:344:0x05ed, B:345:0x05f0, B:347:0x05f6, B:349:0x05fa, B:354:0x0613, B:356:0x0618, B:359:0x0624, B:361:0x062a, B:363:0x063a, B:365:0x0640, B:367:0x0649, B:368:0x0652, B:369:0x0660, B:370:0x0663, B:314:0x056b, B:281:0x048a, B:283:0x048e, B:291:0x04e9, B:293:0x04ed, B:296:0x0508, B:300:0x0514, B:302:0x0548, B:303:0x054a, B:299:0x050f, B:295:0x04f4, B:285:0x0494, B:288:0x04a5, B:290:0x04d8, B:265:0x0444, B:267:0x044a, B:269:0x0450, B:272:0x045f, B:274:0x0463, B:276:0x046e, B:462:0x07cd, B:466:0x07d5, B:468:0x07db, B:469:0x07e2, B:471:0x07e7, B:473:0x07f2, B:475:0x07f8, B:479:0x0804, B:481:0x0813, B:482:0x081f), top: B:509:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x050f A[Catch: IOException -> 0x082f, zzhe -> 0x0834, RuntimeException -> 0x0839, TryCatch #9 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:7:0x0019, B:12:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:29:0x0051, B:33:0x0059, B:35:0x005e, B:36:0x0063, B:38:0x006d, B:40:0x0071, B:42:0x0075, B:43:0x0086, B:46:0x008c, B:10:0x0022, B:48:0x0090, B:55:0x00ae, B:62:0x00bc, B:65:0x00bf, B:68:0x00c9, B:72:0x00cd, B:73:0x00ce, B:77:0x00d5, B:80:0x00db, B:82:0x00e1, B:85:0x00e6, B:87:0x00eb, B:91:0x00f4, B:93:0x0116, B:94:0x011d, B:95:0x0124, B:97:0x0129, B:101:0x0134, B:103:0x013e, B:104:0x0140, B:106:0x0144, B:108:0x014a, B:111:0x0150, B:112:0x0157, B:113:0x015b, B:114:0x0162, B:116:0x0166, B:117:0x016b, B:118:0x016e, B:125:0x01a3, B:119:0x017d, B:121:0x0183, B:122:0x0189, B:124:0x0191, B:127:0x01af, B:129:0x01b7, B:132:0x01bc, B:134:0x01c0, B:136:0x01c8, B:139:0x01cd, B:141:0x01de, B:142:0x01ec, B:144:0x01f0, B:146:0x0200, B:148:0x0204, B:150:0x0212, B:151:0x0217, B:159:0x025e, B:164:0x0267, B:166:0x0271, B:168:0x027b, B:169:0x0280, B:170:0x02a8, B:172:0x02ac, B:176:0x02b7, B:177:0x02ba, B:178:0x02c7, B:182:0x02d5, B:184:0x02db, B:185:0x02ec, B:187:0x02f0, B:189:0x02fe, B:191:0x0310, B:195:0x031e, B:197:0x0323, B:198:0x0337, B:199:0x033e, B:162:0x0263, B:152:0x022f, B:154:0x0237, B:156:0x023d, B:157:0x0242, B:201:0x0342, B:202:0x034d, B:209:0x0358, B:210:0x0359, B:212:0x035d, B:214:0x0365, B:216:0x0370, B:215:0x036a, B:218:0x037c, B:220:0x0384, B:221:0x038d, B:223:0x0393, B:224:0x03b1, B:228:0x03ba, B:234:0x03db, B:238:0x03e9, B:246:0x03fd, B:250:0x040b, B:253:0x0414, B:257:0x0423, B:258:0x042a, B:259:0x042b, B:261:0x0433, B:371:0x0666, B:373:0x066c, B:374:0x0674, B:376:0x068f, B:378:0x069a, B:382:0x06a3, B:384:0x06a9, B:390:0x06b5, B:395:0x06bf, B:397:0x06c6, B:398:0x06c9, B:400:0x06cd, B:402:0x06d9, B:403:0x06ec, B:407:0x0705, B:409:0x070d, B:411:0x0713, B:444:0x0795, B:446:0x0799, B:448:0x079e, B:449:0x07a6, B:451:0x07aa, B:455:0x07b3, B:460:0x07c9, B:453:0x07af, B:456:0x07b9, B:458:0x07be, B:459:0x07c4, B:412:0x071d, B:414:0x0722, B:417:0x0729, B:419:0x0731, B:423:0x0740, B:433:0x0770, B:435:0x0778, B:426:0x0748, B:427:0x0754, B:420:0x0734, B:431:0x076a, B:438:0x077f, B:443:0x078b, B:441:0x0785, B:262:0x043b, B:264:0x043f, B:277:0x047a, B:279:0x0482, B:304:0x0554, B:306:0x0558, B:309:0x055f, B:311:0x0563, B:313:0x0567, B:315:0x056e, B:317:0x0572, B:319:0x0578, B:321:0x0582, B:322:0x05a9, B:325:0x05ae, B:327:0x05b3, B:329:0x05bd, B:331:0x05c3, B:333:0x05c9, B:334:0x05cc, B:336:0x05d0, B:338:0x05d5, B:341:0x05e5, B:344:0x05ed, B:345:0x05f0, B:347:0x05f6, B:349:0x05fa, B:354:0x0613, B:356:0x0618, B:359:0x0624, B:361:0x062a, B:363:0x063a, B:365:0x0640, B:367:0x0649, B:368:0x0652, B:369:0x0660, B:370:0x0663, B:314:0x056b, B:281:0x048a, B:283:0x048e, B:291:0x04e9, B:293:0x04ed, B:296:0x0508, B:300:0x0514, B:302:0x0548, B:303:0x054a, B:299:0x050f, B:295:0x04f4, B:285:0x0494, B:288:0x04a5, B:290:0x04d8, B:265:0x0444, B:267:0x044a, B:269:0x0450, B:272:0x045f, B:274:0x0463, B:276:0x046e, B:462:0x07cd, B:466:0x07d5, B:468:0x07db, B:469:0x07e2, B:471:0x07e7, B:473:0x07f2, B:475:0x07f8, B:479:0x0804, B:481:0x0813, B:482:0x081f), top: B:509:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0548 A[Catch: IOException -> 0x082f, zzhe -> 0x0834, RuntimeException -> 0x0839, TryCatch #9 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:7:0x0019, B:12:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:29:0x0051, B:33:0x0059, B:35:0x005e, B:36:0x0063, B:38:0x006d, B:40:0x0071, B:42:0x0075, B:43:0x0086, B:46:0x008c, B:10:0x0022, B:48:0x0090, B:55:0x00ae, B:62:0x00bc, B:65:0x00bf, B:68:0x00c9, B:72:0x00cd, B:73:0x00ce, B:77:0x00d5, B:80:0x00db, B:82:0x00e1, B:85:0x00e6, B:87:0x00eb, B:91:0x00f4, B:93:0x0116, B:94:0x011d, B:95:0x0124, B:97:0x0129, B:101:0x0134, B:103:0x013e, B:104:0x0140, B:106:0x0144, B:108:0x014a, B:111:0x0150, B:112:0x0157, B:113:0x015b, B:114:0x0162, B:116:0x0166, B:117:0x016b, B:118:0x016e, B:125:0x01a3, B:119:0x017d, B:121:0x0183, B:122:0x0189, B:124:0x0191, B:127:0x01af, B:129:0x01b7, B:132:0x01bc, B:134:0x01c0, B:136:0x01c8, B:139:0x01cd, B:141:0x01de, B:142:0x01ec, B:144:0x01f0, B:146:0x0200, B:148:0x0204, B:150:0x0212, B:151:0x0217, B:159:0x025e, B:164:0x0267, B:166:0x0271, B:168:0x027b, B:169:0x0280, B:170:0x02a8, B:172:0x02ac, B:176:0x02b7, B:177:0x02ba, B:178:0x02c7, B:182:0x02d5, B:184:0x02db, B:185:0x02ec, B:187:0x02f0, B:189:0x02fe, B:191:0x0310, B:195:0x031e, B:197:0x0323, B:198:0x0337, B:199:0x033e, B:162:0x0263, B:152:0x022f, B:154:0x0237, B:156:0x023d, B:157:0x0242, B:201:0x0342, B:202:0x034d, B:209:0x0358, B:210:0x0359, B:212:0x035d, B:214:0x0365, B:216:0x0370, B:215:0x036a, B:218:0x037c, B:220:0x0384, B:221:0x038d, B:223:0x0393, B:224:0x03b1, B:228:0x03ba, B:234:0x03db, B:238:0x03e9, B:246:0x03fd, B:250:0x040b, B:253:0x0414, B:257:0x0423, B:258:0x042a, B:259:0x042b, B:261:0x0433, B:371:0x0666, B:373:0x066c, B:374:0x0674, B:376:0x068f, B:378:0x069a, B:382:0x06a3, B:384:0x06a9, B:390:0x06b5, B:395:0x06bf, B:397:0x06c6, B:398:0x06c9, B:400:0x06cd, B:402:0x06d9, B:403:0x06ec, B:407:0x0705, B:409:0x070d, B:411:0x0713, B:444:0x0795, B:446:0x0799, B:448:0x079e, B:449:0x07a6, B:451:0x07aa, B:455:0x07b3, B:460:0x07c9, B:453:0x07af, B:456:0x07b9, B:458:0x07be, B:459:0x07c4, B:412:0x071d, B:414:0x0722, B:417:0x0729, B:419:0x0731, B:423:0x0740, B:433:0x0770, B:435:0x0778, B:426:0x0748, B:427:0x0754, B:420:0x0734, B:431:0x076a, B:438:0x077f, B:443:0x078b, B:441:0x0785, B:262:0x043b, B:264:0x043f, B:277:0x047a, B:279:0x0482, B:304:0x0554, B:306:0x0558, B:309:0x055f, B:311:0x0563, B:313:0x0567, B:315:0x056e, B:317:0x0572, B:319:0x0578, B:321:0x0582, B:322:0x05a9, B:325:0x05ae, B:327:0x05b3, B:329:0x05bd, B:331:0x05c3, B:333:0x05c9, B:334:0x05cc, B:336:0x05d0, B:338:0x05d5, B:341:0x05e5, B:344:0x05ed, B:345:0x05f0, B:347:0x05f6, B:349:0x05fa, B:354:0x0613, B:356:0x0618, B:359:0x0624, B:361:0x062a, B:363:0x063a, B:365:0x0640, B:367:0x0649, B:368:0x0652, B:369:0x0660, B:370:0x0663, B:314:0x056b, B:281:0x048a, B:283:0x048e, B:291:0x04e9, B:293:0x04ed, B:296:0x0508, B:300:0x0514, B:302:0x0548, B:303:0x054a, B:299:0x050f, B:295:0x04f4, B:285:0x0494, B:288:0x04a5, B:290:0x04d8, B:265:0x0444, B:267:0x044a, B:269:0x0450, B:272:0x045f, B:274:0x0463, B:276:0x046e, B:462:0x07cd, B:466:0x07d5, B:468:0x07db, B:469:0x07e2, B:471:0x07e7, B:473:0x07f2, B:475:0x07f8, B:479:0x0804, B:481:0x0813, B:482:0x081f), top: B:509:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0558 A[Catch: IOException -> 0x082f, zzhe -> 0x0834, RuntimeException -> 0x0839, TryCatch #9 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:7:0x0019, B:12:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:29:0x0051, B:33:0x0059, B:35:0x005e, B:36:0x0063, B:38:0x006d, B:40:0x0071, B:42:0x0075, B:43:0x0086, B:46:0x008c, B:10:0x0022, B:48:0x0090, B:55:0x00ae, B:62:0x00bc, B:65:0x00bf, B:68:0x00c9, B:72:0x00cd, B:73:0x00ce, B:77:0x00d5, B:80:0x00db, B:82:0x00e1, B:85:0x00e6, B:87:0x00eb, B:91:0x00f4, B:93:0x0116, B:94:0x011d, B:95:0x0124, B:97:0x0129, B:101:0x0134, B:103:0x013e, B:104:0x0140, B:106:0x0144, B:108:0x014a, B:111:0x0150, B:112:0x0157, B:113:0x015b, B:114:0x0162, B:116:0x0166, B:117:0x016b, B:118:0x016e, B:125:0x01a3, B:119:0x017d, B:121:0x0183, B:122:0x0189, B:124:0x0191, B:127:0x01af, B:129:0x01b7, B:132:0x01bc, B:134:0x01c0, B:136:0x01c8, B:139:0x01cd, B:141:0x01de, B:142:0x01ec, B:144:0x01f0, B:146:0x0200, B:148:0x0204, B:150:0x0212, B:151:0x0217, B:159:0x025e, B:164:0x0267, B:166:0x0271, B:168:0x027b, B:169:0x0280, B:170:0x02a8, B:172:0x02ac, B:176:0x02b7, B:177:0x02ba, B:178:0x02c7, B:182:0x02d5, B:184:0x02db, B:185:0x02ec, B:187:0x02f0, B:189:0x02fe, B:191:0x0310, B:195:0x031e, B:197:0x0323, B:198:0x0337, B:199:0x033e, B:162:0x0263, B:152:0x022f, B:154:0x0237, B:156:0x023d, B:157:0x0242, B:201:0x0342, B:202:0x034d, B:209:0x0358, B:210:0x0359, B:212:0x035d, B:214:0x0365, B:216:0x0370, B:215:0x036a, B:218:0x037c, B:220:0x0384, B:221:0x038d, B:223:0x0393, B:224:0x03b1, B:228:0x03ba, B:234:0x03db, B:238:0x03e9, B:246:0x03fd, B:250:0x040b, B:253:0x0414, B:257:0x0423, B:258:0x042a, B:259:0x042b, B:261:0x0433, B:371:0x0666, B:373:0x066c, B:374:0x0674, B:376:0x068f, B:378:0x069a, B:382:0x06a3, B:384:0x06a9, B:390:0x06b5, B:395:0x06bf, B:397:0x06c6, B:398:0x06c9, B:400:0x06cd, B:402:0x06d9, B:403:0x06ec, B:407:0x0705, B:409:0x070d, B:411:0x0713, B:444:0x0795, B:446:0x0799, B:448:0x079e, B:449:0x07a6, B:451:0x07aa, B:455:0x07b3, B:460:0x07c9, B:453:0x07af, B:456:0x07b9, B:458:0x07be, B:459:0x07c4, B:412:0x071d, B:414:0x0722, B:417:0x0729, B:419:0x0731, B:423:0x0740, B:433:0x0770, B:435:0x0778, B:426:0x0748, B:427:0x0754, B:420:0x0734, B:431:0x076a, B:438:0x077f, B:443:0x078b, B:441:0x0785, B:262:0x043b, B:264:0x043f, B:277:0x047a, B:279:0x0482, B:304:0x0554, B:306:0x0558, B:309:0x055f, B:311:0x0563, B:313:0x0567, B:315:0x056e, B:317:0x0572, B:319:0x0578, B:321:0x0582, B:322:0x05a9, B:325:0x05ae, B:327:0x05b3, B:329:0x05bd, B:331:0x05c3, B:333:0x05c9, B:334:0x05cc, B:336:0x05d0, B:338:0x05d5, B:341:0x05e5, B:344:0x05ed, B:345:0x05f0, B:347:0x05f6, B:349:0x05fa, B:354:0x0613, B:356:0x0618, B:359:0x0624, B:361:0x062a, B:363:0x063a, B:365:0x0640, B:367:0x0649, B:368:0x0652, B:369:0x0660, B:370:0x0663, B:314:0x056b, B:281:0x048a, B:283:0x048e, B:291:0x04e9, B:293:0x04ed, B:296:0x0508, B:300:0x0514, B:302:0x0548, B:303:0x054a, B:299:0x050f, B:295:0x04f4, B:285:0x0494, B:288:0x04a5, B:290:0x04d8, B:265:0x0444, B:267:0x044a, B:269:0x0450, B:272:0x045f, B:274:0x0463, B:276:0x046e, B:462:0x07cd, B:466:0x07d5, B:468:0x07db, B:469:0x07e2, B:471:0x07e7, B:473:0x07f2, B:475:0x07f8, B:479:0x0804, B:481:0x0813, B:482:0x081f), top: B:509:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0572 A[Catch: IOException -> 0x082f, zzhe -> 0x0834, RuntimeException -> 0x0839, LOOP:9: B:317:0x0572->B:321:0x0582, LOOP_START, TryCatch #9 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:7:0x0019, B:12:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:29:0x0051, B:33:0x0059, B:35:0x005e, B:36:0x0063, B:38:0x006d, B:40:0x0071, B:42:0x0075, B:43:0x0086, B:46:0x008c, B:10:0x0022, B:48:0x0090, B:55:0x00ae, B:62:0x00bc, B:65:0x00bf, B:68:0x00c9, B:72:0x00cd, B:73:0x00ce, B:77:0x00d5, B:80:0x00db, B:82:0x00e1, B:85:0x00e6, B:87:0x00eb, B:91:0x00f4, B:93:0x0116, B:94:0x011d, B:95:0x0124, B:97:0x0129, B:101:0x0134, B:103:0x013e, B:104:0x0140, B:106:0x0144, B:108:0x014a, B:111:0x0150, B:112:0x0157, B:113:0x015b, B:114:0x0162, B:116:0x0166, B:117:0x016b, B:118:0x016e, B:125:0x01a3, B:119:0x017d, B:121:0x0183, B:122:0x0189, B:124:0x0191, B:127:0x01af, B:129:0x01b7, B:132:0x01bc, B:134:0x01c0, B:136:0x01c8, B:139:0x01cd, B:141:0x01de, B:142:0x01ec, B:144:0x01f0, B:146:0x0200, B:148:0x0204, B:150:0x0212, B:151:0x0217, B:159:0x025e, B:164:0x0267, B:166:0x0271, B:168:0x027b, B:169:0x0280, B:170:0x02a8, B:172:0x02ac, B:176:0x02b7, B:177:0x02ba, B:178:0x02c7, B:182:0x02d5, B:184:0x02db, B:185:0x02ec, B:187:0x02f0, B:189:0x02fe, B:191:0x0310, B:195:0x031e, B:197:0x0323, B:198:0x0337, B:199:0x033e, B:162:0x0263, B:152:0x022f, B:154:0x0237, B:156:0x023d, B:157:0x0242, B:201:0x0342, B:202:0x034d, B:209:0x0358, B:210:0x0359, B:212:0x035d, B:214:0x0365, B:216:0x0370, B:215:0x036a, B:218:0x037c, B:220:0x0384, B:221:0x038d, B:223:0x0393, B:224:0x03b1, B:228:0x03ba, B:234:0x03db, B:238:0x03e9, B:246:0x03fd, B:250:0x040b, B:253:0x0414, B:257:0x0423, B:258:0x042a, B:259:0x042b, B:261:0x0433, B:371:0x0666, B:373:0x066c, B:374:0x0674, B:376:0x068f, B:378:0x069a, B:382:0x06a3, B:384:0x06a9, B:390:0x06b5, B:395:0x06bf, B:397:0x06c6, B:398:0x06c9, B:400:0x06cd, B:402:0x06d9, B:403:0x06ec, B:407:0x0705, B:409:0x070d, B:411:0x0713, B:444:0x0795, B:446:0x0799, B:448:0x079e, B:449:0x07a6, B:451:0x07aa, B:455:0x07b3, B:460:0x07c9, B:453:0x07af, B:456:0x07b9, B:458:0x07be, B:459:0x07c4, B:412:0x071d, B:414:0x0722, B:417:0x0729, B:419:0x0731, B:423:0x0740, B:433:0x0770, B:435:0x0778, B:426:0x0748, B:427:0x0754, B:420:0x0734, B:431:0x076a, B:438:0x077f, B:443:0x078b, B:441:0x0785, B:262:0x043b, B:264:0x043f, B:277:0x047a, B:279:0x0482, B:304:0x0554, B:306:0x0558, B:309:0x055f, B:311:0x0563, B:313:0x0567, B:315:0x056e, B:317:0x0572, B:319:0x0578, B:321:0x0582, B:322:0x05a9, B:325:0x05ae, B:327:0x05b3, B:329:0x05bd, B:331:0x05c3, B:333:0x05c9, B:334:0x05cc, B:336:0x05d0, B:338:0x05d5, B:341:0x05e5, B:344:0x05ed, B:345:0x05f0, B:347:0x05f6, B:349:0x05fa, B:354:0x0613, B:356:0x0618, B:359:0x0624, B:361:0x062a, B:363:0x063a, B:365:0x0640, B:367:0x0649, B:368:0x0652, B:369:0x0660, B:370:0x0663, B:314:0x056b, B:281:0x048a, B:283:0x048e, B:291:0x04e9, B:293:0x04ed, B:296:0x0508, B:300:0x0514, B:302:0x0548, B:303:0x054a, B:299:0x050f, B:295:0x04f4, B:285:0x0494, B:288:0x04a5, B:290:0x04d8, B:265:0x0444, B:267:0x044a, B:269:0x0450, B:272:0x045f, B:274:0x0463, B:276:0x046e, B:462:0x07cd, B:466:0x07d5, B:468:0x07db, B:469:0x07e2, B:471:0x07e7, B:473:0x07f2, B:475:0x07f8, B:479:0x0804, B:481:0x0813, B:482:0x081f), top: B:509:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:390:0x06b5 A[Catch: IOException -> 0x082f, zzhe -> 0x0834, RuntimeException -> 0x0839, TryCatch #9 {RuntimeException -> 0x0839, blocks: (B:3:0x0005, B:7:0x0019, B:12:0x0026, B:16:0x002d, B:20:0x0034, B:23:0x0046, B:25:0x004a, B:29:0x0051, B:33:0x0059, B:35:0x005e, B:36:0x0063, B:38:0x006d, B:40:0x0071, B:42:0x0075, B:43:0x0086, B:46:0x008c, B:10:0x0022, B:48:0x0090, B:55:0x00ae, B:62:0x00bc, B:65:0x00bf, B:68:0x00c9, B:72:0x00cd, B:73:0x00ce, B:77:0x00d5, B:80:0x00db, B:82:0x00e1, B:85:0x00e6, B:87:0x00eb, B:91:0x00f4, B:93:0x0116, B:94:0x011d, B:95:0x0124, B:97:0x0129, B:101:0x0134, B:103:0x013e, B:104:0x0140, B:106:0x0144, B:108:0x014a, B:111:0x0150, B:112:0x0157, B:113:0x015b, B:114:0x0162, B:116:0x0166, B:117:0x016b, B:118:0x016e, B:125:0x01a3, B:119:0x017d, B:121:0x0183, B:122:0x0189, B:124:0x0191, B:127:0x01af, B:129:0x01b7, B:132:0x01bc, B:134:0x01c0, B:136:0x01c8, B:139:0x01cd, B:141:0x01de, B:142:0x01ec, B:144:0x01f0, B:146:0x0200, B:148:0x0204, B:150:0x0212, B:151:0x0217, B:159:0x025e, B:164:0x0267, B:166:0x0271, B:168:0x027b, B:169:0x0280, B:170:0x02a8, B:172:0x02ac, B:176:0x02b7, B:177:0x02ba, B:178:0x02c7, B:182:0x02d5, B:184:0x02db, B:185:0x02ec, B:187:0x02f0, B:189:0x02fe, B:191:0x0310, B:195:0x031e, B:197:0x0323, B:198:0x0337, B:199:0x033e, B:162:0x0263, B:152:0x022f, B:154:0x0237, B:156:0x023d, B:157:0x0242, B:201:0x0342, B:202:0x034d, B:209:0x0358, B:210:0x0359, B:212:0x035d, B:214:0x0365, B:216:0x0370, B:215:0x036a, B:218:0x037c, B:220:0x0384, B:221:0x038d, B:223:0x0393, B:224:0x03b1, B:228:0x03ba, B:234:0x03db, B:238:0x03e9, B:246:0x03fd, B:250:0x040b, B:253:0x0414, B:257:0x0423, B:258:0x042a, B:259:0x042b, B:261:0x0433, B:371:0x0666, B:373:0x066c, B:374:0x0674, B:376:0x068f, B:378:0x069a, B:382:0x06a3, B:384:0x06a9, B:390:0x06b5, B:395:0x06bf, B:397:0x06c6, B:398:0x06c9, B:400:0x06cd, B:402:0x06d9, B:403:0x06ec, B:407:0x0705, B:409:0x070d, B:411:0x0713, B:444:0x0795, B:446:0x0799, B:448:0x079e, B:449:0x07a6, B:451:0x07aa, B:455:0x07b3, B:460:0x07c9, B:453:0x07af, B:456:0x07b9, B:458:0x07be, B:459:0x07c4, B:412:0x071d, B:414:0x0722, B:417:0x0729, B:419:0x0731, B:423:0x0740, B:433:0x0770, B:435:0x0778, B:426:0x0748, B:427:0x0754, B:420:0x0734, B:431:0x076a, B:438:0x077f, B:443:0x078b, B:441:0x0785, B:262:0x043b, B:264:0x043f, B:277:0x047a, B:279:0x0482, B:304:0x0554, B:306:0x0558, B:309:0x055f, B:311:0x0563, B:313:0x0567, B:315:0x056e, B:317:0x0572, B:319:0x0578, B:321:0x0582, B:322:0x05a9, B:325:0x05ae, B:327:0x05b3, B:329:0x05bd, B:331:0x05c3, B:333:0x05c9, B:334:0x05cc, B:336:0x05d0, B:338:0x05d5, B:341:0x05e5, B:344:0x05ed, B:345:0x05f0, B:347:0x05f6, B:349:0x05fa, B:354:0x0613, B:356:0x0618, B:359:0x0624, B:361:0x062a, B:363:0x063a, B:365:0x0640, B:367:0x0649, B:368:0x0652, B:369:0x0660, B:370:0x0663, B:314:0x056b, B:281:0x048a, B:283:0x048e, B:291:0x04e9, B:293:0x04ed, B:296:0x0508, B:300:0x0514, B:302:0x0548, B:303:0x054a, B:299:0x050f, B:295:0x04f4, B:285:0x0494, B:288:0x04a5, B:290:0x04d8, B:265:0x0444, B:267:0x044a, B:269:0x0450, B:272:0x045f, B:274:0x0463, B:276:0x046e, B:462:0x07cd, B:466:0x07d5, B:468:0x07db, B:469:0x07e2, B:471:0x07e7, B:473:0x07f2, B:475:0x07f8, B:479:0x0804, B:481:0x0813, B:482:0x081f), top: B:509:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0766  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            Method dump skipped, instructions count: 2216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.handleMessage(android.os.Message):boolean");
    }

    public final synchronized void release() {
        if (this.zzafw) {
            return;
        }
        this.handler.sendEmptyMessage(6);
        while (!this.zzafw) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.zzafq.quit();
    }

    public final void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public final void zza(zzne zzneVar, boolean z) {
        this.handler.obtainMessage(0, 1, 0, zzneVar).sendToTarget();
    }

    public final synchronized void zzb(zzhi... zzhiVarArr) {
        if (this.zzafw) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i2 = this.zzafy;
        this.zzafy = i2 + 1;
        this.handler.obtainMessage(11, zzhiVarArr).sendToTarget();
        while (this.zzafz <= i2) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final void zzep() {
        this.handler.sendEmptyMessage(10);
    }

    public final void zzg(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zza(zzid zzidVar, int i2, long j2) {
        this.handler.obtainMessage(3, new zzhr(zzidVar, i2, j2)).sendToTarget();
    }

    public final void zza(zzhi... zzhiVarArr) {
        if (this.zzafw) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.zzafy++;
        this.handler.obtainMessage(11, zzhiVarArr).sendToTarget();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zznb
    public final void zza(zznc zzncVar) {
        this.handler.obtainMessage(8, zzncVar).sendToTarget();
    }

    private final void zza(long j2, long j3) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j2 + j3) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final void zzb(zzid zzidVar, Object obj) {
        this.handler.obtainMessage(7, Pair.create(zzidVar, obj)).sendToTarget();
    }

    private final long zzb(int i2, long j2) throws zzhe {
        zzhp zzhpVar;
        zzer();
        this.zzafx = false;
        setState(2);
        zzhp zzhpVar2 = this.zzagg;
        if (zzhpVar2 == null) {
            zzhp zzhpVar3 = this.zzage;
            if (zzhpVar3 != null) {
                zzhpVar3.release();
            }
            zzhpVar = null;
        } else {
            zzhpVar = null;
            while (zzhpVar2 != null) {
                if (zzhpVar2.zzagi == i2 && zzhpVar2.zzags) {
                    zzhpVar = zzhpVar2;
                } else {
                    zzhpVar2.release();
                }
                zzhpVar2 = zzhpVar2.zzagu;
            }
        }
        zzhp zzhpVar4 = this.zzagg;
        if (zzhpVar4 != zzhpVar || zzhpVar4 != this.zzagf) {
            for (zzhy zzhyVar : this.zzafv) {
                zzhyVar.disable();
            }
            this.zzafv = new zzhy[0];
            this.zzaft = null;
            this.zzafs = null;
            this.zzagg = null;
        }
        if (zzhpVar != null) {
            zzhpVar.zzagu = null;
            this.zzage = zzhpVar;
            this.zzagf = zzhpVar;
            zzb(zzhpVar);
            zzhp zzhpVar5 = this.zzagg;
            if (zzhpVar5.zzagt) {
                j2 = zzhpVar5.zzagm.zzeg(j2);
            }
            zzdq(j2);
            zzev();
        } else {
            this.zzage = null;
            this.zzagf = null;
            this.zzagg = null;
            zzdq(j2);
        }
        this.handler.sendEmptyMessage(2);
        return j2;
    }

    private static void zza(zzhy zzhyVar) throws zzhe {
        if (zzhyVar.getState() == 2) {
            zzhyVar.stop();
        }
    }

    private final void zza(Object obj, int i2) {
        this.zzafj = new zzho(0, 0L);
        zzb(obj, i2);
        this.zzafj = new zzho(0, -9223372036854775807L);
        setState(4);
        zzi(false);
    }

    private final int zza(int i2, zzid zzidVar, zzid zzidVar2) {
        int zzfg = zzidVar.zzfg();
        int i3 = -1;
        for (int i4 = 0; i4 < zzfg && i3 == -1; i4++) {
            i2 = zzidVar.zza(i2, this.zzaex, this.zzaew, this.repeatMode);
            i3 = zzidVar2.zzc(zzidVar.zza(i2, this.zzaex, true).zzagn);
        }
        return i3;
    }

    private final Pair<Integer, Long> zza(zzhr zzhrVar) {
        zzid zzidVar = zzhrVar.zzafe;
        if (zzidVar.isEmpty()) {
            zzidVar = this.zzafe;
        }
        try {
            Pair<Integer, Long> zzb = zzb(zzidVar, zzhrVar.zzagy, zzhrVar.zzagz);
            zzid zzidVar2 = this.zzafe;
            if (zzidVar2 == zzidVar) {
                return zzb;
            }
            int zzc = zzidVar2.zzc(zzidVar.zza(((Integer) zzb.first).intValue(), this.zzaex, true).zzagn);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) zzb.second);
            }
            int zza = zza(((Integer) zzb.first).intValue(), zzidVar, this.zzafe);
            if (zza != -1) {
                this.zzafe.zza(zza, this.zzaex, false);
                return zzc(0, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhu(this.zzafe, zzhrVar.zzagy, zzhrVar.zzagz);
        }
    }

    private final Pair<Integer, Long> zza(zzid zzidVar, int i2, long j2, long j3) {
        zzpg.zzc(i2, 0, zzidVar.zzff());
        zzidVar.zza(i2, this.zzaew, false, j3);
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        long j4 = j2 + 0;
        long j5 = zzidVar.zza(0, this.zzaex, false).zzaip;
        if (j5 != -9223372036854775807L) {
            int i3 = (j4 > j5 ? 1 : (j4 == j5 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j4));
    }

    private final void zzb(Object obj, int i2) {
        this.zzaet.obtainMessage(6, new zzhq(this.zzafe, obj, this.zzafj, i2)).sendToTarget();
    }

    private final Pair<Integer, Long> zzb(zzid zzidVar, int i2, long j2) {
        return zza(zzidVar, i2, j2, 0L);
    }

    private final void zzb(zzhp zzhpVar) throws zzhe {
        if (this.zzagg == zzhpVar) {
            return;
        }
        boolean[] zArr = new boolean[this.zzaeq.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzhy[] zzhyVarArr = this.zzaeq;
            if (i2 < zzhyVarArr.length) {
                zzhy zzhyVar = zzhyVarArr[i2];
                zArr[i2] = zzhyVar.getState() != 0;
                zzog zzbe = zzhpVar.zzagv.zzbhy.zzbe(i2);
                if (zzbe != null) {
                    i3++;
                }
                if (zArr[i2] && (zzbe == null || (zzhyVar.zzee() && zzhyVar.zzeb() == this.zzagg.zzago[i2]))) {
                    if (zzhyVar == this.zzafs) {
                        this.zzafp.zza(this.zzaft);
                        this.zzaft = null;
                        this.zzafs = null;
                    }
                    zza(zzhyVar);
                    zzhyVar.disable();
                }
                i2++;
            } else {
                this.zzagg = zzhpVar;
                this.zzaet.obtainMessage(3, zzhpVar.zzagv).sendToTarget();
                zza(zArr, i3);
                return;
            }
        }
    }

    private static void zza(zzhp zzhpVar) {
        while (zzhpVar != null) {
            zzhpVar.release();
            zzhpVar = zzhpVar.zzagu;
        }
    }

    private final void zza(boolean[] zArr, int i2) throws zzhe {
        this.zzafv = new zzhy[i2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            zzhy[] zzhyVarArr = this.zzaeq;
            if (i3 >= zzhyVarArr.length) {
                return;
            }
            zzhy zzhyVar = zzhyVarArr[i3];
            zzog zzbe = this.zzagg.zzagv.zzbhy.zzbe(i3);
            if (zzbe != null) {
                int i5 = i4 + 1;
                this.zzafv[i4] = zzhyVar;
                if (zzhyVar.getState() == 0) {
                    zzia zziaVar = this.zzagg.zzagv.zzbia[i3];
                    boolean z = this.zzaez && this.state == 3;
                    boolean z2 = !zArr[i3] && z;
                    int length = zzbe.length();
                    zzht[] zzhtVarArr = new zzht[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        zzhtVarArr[i6] = zzbe.zzbb(i6);
                    }
                    zzhp zzhpVar = this.zzagg;
                    zzhyVar.zza(zziaVar, zzhtVarArr, zzhpVar.zzago[i3], this.zzagd, z2, zzhpVar.zzew());
                    zzpk zzea = zzhyVar.zzea();
                    if (zzea != null) {
                        if (this.zzaft == null) {
                            this.zzaft = zzea;
                            this.zzafs = zzhyVar;
                            zzea.zzb(this.zzafi);
                        } else {
                            throw zzhe.zza(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z) {
                        zzhyVar.start();
                    }
                }
                i4 = i5;
            }
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final /* synthetic */ void zza(zznc zzncVar) {
        this.handler.obtainMessage(9, zzncVar).sendToTarget();
    }
}
