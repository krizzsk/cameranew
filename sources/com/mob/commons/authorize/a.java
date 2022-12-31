package com.mob.commons.authorize;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.LockAction;
import com.mob.commons.MobProduct;
import com.mob.commons.MobProductCollector;
import com.mob.commons.b;
import com.mob.commons.d;
import com.mob.commons.h;
import com.mob.commons.i;
import com.mob.commons.j;
import com.mob.commons.k;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.bugly.BuglyStrategy;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: Authorizer.java */
/* loaded from: classes2.dex */
public final class a {
    private static final String a = i.b("devs-data.dutils.com");

    private File d() {
        File file = new File(ResHelper.getDataCache(MobSDK.getContext()), "comm/dbs/.duid");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> e() {
        try {
            return a(c());
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    private String f() {
        return "sdk.comm" + TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON + "ap.sdk";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        File c;
        File d2;
        try {
            c = c();
            d2 = d();
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        if (c.getPath().equals(d2.getPath())) {
            return false;
        }
        if (c.exists() && c.isFile()) {
            if (!d2.exists() || !d2.isFile()) {
                ResHelper.copyFile(c.getAbsolutePath(), d2.getAbsolutePath());
            }
        } else if (d2.exists() && d2.isFile()) {
            ResHelper.copyFile(d2.getAbsolutePath(), c.getAbsolutePath());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        File dataCacheFile = ResHelper.getDataCacheFile(MobSDK.getContext(), "comm/dbs/.digap");
        if (dataCacheFile != null && dataCacheFile.exists()) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(dataCacheFile));
                long readLong = dataInputStream.readLong();
                dataInputStream.close();
                return readLong < b.a();
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        } else {
            a(b.w() + b.a());
        }
        return false;
    }

    private File c() {
        return ResHelper.getDataCacheFile(MobSDK.getContext(), "comm/dbs/.duid");
    }

    private String c(String str) {
        try {
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            h.b(System.currentTimeMillis());
        }
        if (b.t()) {
            return null;
        }
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("plat", 1);
        hashMap.put("imei", deviceHelper.getIMEI());
        hashMap.put("serialno", deviceHelper.getSerialno());
        hashMap.put("mac", deviceHelper.getMacAddress());
        hashMap.put(BigAlbumStore.PhotoTagColumns.MODEL, deviceHelper.getModel());
        hashMap.put("factory", deviceHelper.getManufacturer());
        hashMap.put("adsid", deviceHelper.getAdvertisingID());
        hashMap.put("oaid", com.mob.commons.b.a.b(MobSDK.getContext()));
        hashMap.put("imsi", deviceHelper.getIMSI());
        hashMap.put("androidid", deviceHelper.getAndroidID());
        hashMap.put("simserialno", deviceHelper.getSimSerialNumber());
        hashMap.put("duid", str);
        MobCommunicator mobCommunicator = new MobCommunicator(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd");
        HashMap hashMap2 = (HashMap) mobCommunicator.requestSynchronized(hashMap, a + "/dgen", false);
        Object obj = hashMap2.get("dri");
        if (obj != null) {
            h.b(System.currentTimeMillis() + (((Integer) obj).intValue() * 60 * 60 * 1000));
        }
        Object obj2 = hashMap2.get("duid");
        if (obj2 != null) {
            String valueOf = String.valueOf(obj2);
            if (deviceHelper.getSdcardState()) {
                deviceHelper.saveWabcd(valueOf, 0);
            }
            return valueOf;
        }
        return null;
    }

    private String b(String str) {
        try {
            String wAbcd = DeviceHelper.getInstance(MobSDK.getContext()).getWAbcd(0);
            return !TextUtils.isEmpty(wAbcd) ? wAbcd : c(str);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(final MobProduct mobProduct, final String str) {
        final String[] strArr = new String[1];
        d.a(d.a("comm/locks/.globalLock"), new LockAction() { // from class: com.mob.commons.authorize.a.1
            @Override // com.mob.commons.LockAction
            public boolean run(FileLocker fileLocker) {
                strArr[0] = a.this.a(mobProduct, a.this.g(), str);
                return false;
            }
        });
        return strArr[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0184 A[Catch: all -> 0x0258, TryCatch #5 {all -> 0x0258, blocks: (B:3:0x0006, B:5:0x0016, B:6:0x001e, B:8:0x0028, B:9:0x002d, B:11:0x004a, B:24:0x007f, B:26:0x0085, B:28:0x008f, B:29:0x0094, B:31:0x009e, B:37:0x00b1, B:39:0x00b7, B:64:0x011c, B:99:0x017a, B:101:0x0184, B:102:0x0189, B:127:0x01e9, B:131:0x01ff, B:140:0x0222, B:145:0x0241, B:147:0x024b, B:149:0x0251, B:150:0x0254, B:104:0x018f, B:106:0x0197, B:110:0x01a5, B:113:0x01aa, B:114:0x01b4, B:116:0x01ba, B:118:0x01c0, B:123:0x01cb, B:124:0x01d2, B:46:0x00d4, B:48:0x00de, B:33:0x00a4, B:40:0x00bc, B:42:0x00c6, B:66:0x0121, B:68:0x0127, B:93:0x0165, B:95:0x016e, B:58:0x0104, B:60:0x010e, B:18:0x0067, B:20:0x0071, B:141:0x022f, B:132:0x0208, B:136:0x0210, B:52:0x00ec, B:54:0x00f6, B:12:0x004f, B:14:0x0059), top: B:157:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ba A[Catch: all -> 0x01a1, TryCatch #5 {all -> 0x0258, blocks: (B:3:0x0006, B:5:0x0016, B:6:0x001e, B:8:0x0028, B:9:0x002d, B:11:0x004a, B:24:0x007f, B:26:0x0085, B:28:0x008f, B:29:0x0094, B:31:0x009e, B:37:0x00b1, B:39:0x00b7, B:64:0x011c, B:99:0x017a, B:101:0x0184, B:102:0x0189, B:127:0x01e9, B:131:0x01ff, B:140:0x0222, B:145:0x0241, B:147:0x024b, B:149:0x0251, B:150:0x0254, B:104:0x018f, B:106:0x0197, B:110:0x01a5, B:113:0x01aa, B:114:0x01b4, B:116:0x01ba, B:118:0x01c0, B:123:0x01cb, B:124:0x01d2, B:46:0x00d4, B:48:0x00de, B:33:0x00a4, B:40:0x00bc, B:42:0x00c6, B:66:0x0121, B:68:0x0127, B:93:0x0165, B:95:0x016e, B:58:0x0104, B:60:0x010e, B:18:0x0067, B:20:0x0071, B:141:0x022f, B:132:0x0208, B:136:0x0210, B:52:0x00ec, B:54:0x00f6, B:12:0x004f, B:14:0x0059), top: B:157:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01cb A[Catch: all -> 0x01a1, TryCatch #5 {all -> 0x0258, blocks: (B:3:0x0006, B:5:0x0016, B:6:0x001e, B:8:0x0028, B:9:0x002d, B:11:0x004a, B:24:0x007f, B:26:0x0085, B:28:0x008f, B:29:0x0094, B:31:0x009e, B:37:0x00b1, B:39:0x00b7, B:64:0x011c, B:99:0x017a, B:101:0x0184, B:102:0x0189, B:127:0x01e9, B:131:0x01ff, B:140:0x0222, B:145:0x0241, B:147:0x024b, B:149:0x0251, B:150:0x0254, B:104:0x018f, B:106:0x0197, B:110:0x01a5, B:113:0x01aa, B:114:0x01b4, B:116:0x01ba, B:118:0x01c0, B:123:0x01cb, B:124:0x01d2, B:46:0x00d4, B:48:0x00de, B:33:0x00a4, B:40:0x00bc, B:42:0x00c6, B:66:0x0121, B:68:0x0127, B:93:0x0165, B:95:0x016e, B:58:0x0104, B:60:0x010e, B:18:0x0067, B:20:0x0071, B:141:0x022f, B:132:0x0208, B:136:0x0210, B:52:0x00ec, B:54:0x00f6, B:12:0x004f, B:14:0x0059), top: B:157:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x024b A[Catch: all -> 0x0258, TryCatch #5 {all -> 0x0258, blocks: (B:3:0x0006, B:5:0x0016, B:6:0x001e, B:8:0x0028, B:9:0x002d, B:11:0x004a, B:24:0x007f, B:26:0x0085, B:28:0x008f, B:29:0x0094, B:31:0x009e, B:37:0x00b1, B:39:0x00b7, B:64:0x011c, B:99:0x017a, B:101:0x0184, B:102:0x0189, B:127:0x01e9, B:131:0x01ff, B:140:0x0222, B:145:0x0241, B:147:0x024b, B:149:0x0251, B:150:0x0254, B:104:0x018f, B:106:0x0197, B:110:0x01a5, B:113:0x01aa, B:114:0x01b4, B:116:0x01ba, B:118:0x01c0, B:123:0x01cb, B:124:0x01d2, B:46:0x00d4, B:48:0x00de, B:33:0x00a4, B:40:0x00bc, B:42:0x00c6, B:66:0x0121, B:68:0x0127, B:93:0x0165, B:95:0x016e, B:58:0x0104, B:60:0x010e, B:18:0x0067, B:20:0x0071, B:141:0x022f, B:132:0x0208, B:136:0x0210, B:52:0x00ec, B:54:0x00f6, B:12:0x004f, B:14:0x0059), top: B:157:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016e A[Catch: all -> 0x0172, TRY_LEAVE, TryCatch #5 {all -> 0x0258, blocks: (B:3:0x0006, B:5:0x0016, B:6:0x001e, B:8:0x0028, B:9:0x002d, B:11:0x004a, B:24:0x007f, B:26:0x0085, B:28:0x008f, B:29:0x0094, B:31:0x009e, B:37:0x00b1, B:39:0x00b7, B:64:0x011c, B:99:0x017a, B:101:0x0184, B:102:0x0189, B:127:0x01e9, B:131:0x01ff, B:140:0x0222, B:145:0x0241, B:147:0x024b, B:149:0x0251, B:150:0x0254, B:104:0x018f, B:106:0x0197, B:110:0x01a5, B:113:0x01aa, B:114:0x01b4, B:116:0x01ba, B:118:0x01c0, B:123:0x01cb, B:124:0x01d2, B:46:0x00d4, B:48:0x00de, B:33:0x00a4, B:40:0x00bc, B:42:0x00c6, B:66:0x0121, B:68:0x0127, B:93:0x0165, B:95:0x016e, B:58:0x0104, B:60:0x010e, B:18:0x0067, B:20:0x0071, B:141:0x022f, B:132:0x0208, B:136:0x0210, B:52:0x00ec, B:54:0x00f6, B:12:0x004f, B:14:0x0059), top: B:157:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(java.util.HashMap<java.lang.String, java.lang.Object> r15) {
        /*
            Method dump skipped, instructions count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.authorize.a.b(java.util.HashMap):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d A[Catch: all -> 0x008d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0019, B:11:0x002d, B:13:0x0035, B:30:0x007d, B:31:0x0080, B:15:0x0040, B:17:0x0048, B:19:0x0052, B:21:0x005b, B:23:0x0065, B:24:0x0069, B:27:0x0071, B:28:0x0078, B:32:0x0084), top: B:38:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.lang.String a(com.mob.commons.MobProduct r11, boolean r12, java.lang.String r13) {
        /*
            r10 = this;
            monitor-enter(r10)
            android.content.Context r0 = com.mob.MobSDK.getContext()     // Catch: java.lang.Throwable -> L8d
            com.mob.tools.utils.DeviceHelper r0 = com.mob.tools.utils.DeviceHelper.getInstance(r0)     // Catch: java.lang.Throwable -> L8d
            boolean r1 = r0.getSdcardState()     // Catch: java.lang.Throwable -> L8d
            java.util.HashMap r2 = r10.e()     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L84
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L8d
            if (r3 <= 0) goto L84
            java.lang.String r3 = "duid"
            java.lang.Object r3 = r2.get(r3)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L8d
            long r4 = com.mob.commons.h.p()     // Catch: java.lang.Throwable -> L8d
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L8d
            if (r6 == 0) goto L2c
            goto L2d
        L2c:
            r13 = r3
        L2d:
            boolean r3 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> L8d
            r6 = 1
            r7 = 0
            if (r3 == 0) goto L40
            java.lang.String r13 = r10.a(r13)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r12 = "duid"
            r2.put(r12, r13)     // Catch: java.lang.Throwable -> L8d
        L3e:
            r7 = 1
            goto L7b
        L40:
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8d
            int r3 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r3 < 0) goto L59
            java.lang.String r12 = r10.c(r13)     // Catch: java.lang.Throwable -> L8d
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L8d
            if (r0 != 0) goto L7b
            java.lang.String r13 = "duid"
            r2.put(r13, r12)     // Catch: java.lang.Throwable -> L8d
            r13 = r12
            goto L3e
        L59:
            if (r1 == 0) goto L7b
            java.lang.String r1 = r0.getWAbcd(r7)     // Catch: java.lang.Throwable -> L8d
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L8d
            if (r3 == 0) goto L69
            r0.saveWabcd(r13, r7)     // Catch: java.lang.Throwable -> L8d
            goto L7b
        L69:
            boolean r3 = r13.equals(r1)     // Catch: java.lang.Throwable -> L8d
            if (r3 != 0) goto L7b
            if (r12 == 0) goto L78
            java.lang.String r12 = "duid"
            r2.put(r12, r1)     // Catch: java.lang.Throwable -> L8d
            r13 = r1
            goto L3e
        L78:
            r0.saveWabcd(r13, r7)     // Catch: java.lang.Throwable -> L8d
        L7b:
            if (r7 == 0) goto L80
            r10.a(r2, r6)     // Catch: java.lang.Throwable -> L8d
        L80:
            r10.a(r2, r7, r11)     // Catch: java.lang.Throwable -> L8d
            goto L8b
        L84:
            java.lang.String r13 = r10.a(r13)     // Catch: java.lang.Throwable -> L8d
            r10.a(r13, r11)     // Catch: java.lang.Throwable -> L8d
        L8b:
            monitor-exit(r10)
            return r13
        L8d:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.authorize.a.a(com.mob.commons.MobProduct, boolean, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final HashMap<String, Object> hashMap) {
        d.a(d.a("comm/locks/.globalLock"), new LockAction() { // from class: com.mob.commons.authorize.a.4
            @Override // com.mob.commons.LockAction
            public boolean run(FileLocker fileLocker) {
                a.this.a((HashMap<String, Object>) hashMap, false);
                return false;
            }
        });
    }

    private String a(String str) {
        String str2;
        if (!TextUtils.isEmpty(str) || (str2 = DeviceAuthorizer.a) == null) {
            String b = b(str);
            return b == null ? str == null ? a(true) : str : b;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(boolean z) {
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        try {
            boolean sdcardState = deviceHelper.getSdcardState();
            String wAbcd = deviceHelper.getWAbcd(0);
            if (TextUtils.isEmpty(wAbcd)) {
                String advertisingID = deviceHelper.getAdvertisingID();
                String trim = advertisingID == null ? null : advertisingID.trim();
                if (TextUtils.isEmpty(trim)) {
                    trim = UUID.randomUUID().toString();
                }
                String byteToHex = Data.byteToHex(Data.SHA1(trim));
                if (z && sdcardState) {
                    deviceHelper.saveWabcd(byteToHex, 0);
                }
                return byteToHex;
            }
            return wAbcd;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    private void a(final HashMap<String, Object> hashMap, final boolean z, final MobProduct mobProduct) {
        new Thread() { // from class: com.mob.commons.authorize.a.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (a.a) {
                    try {
                        boolean z2 = z;
                        boolean z3 = true;
                        if (a.this.a(hashMap) || a.this.h()) {
                            a aVar = a.this;
                            HashMap hashMap2 = hashMap;
                            aVar.a(hashMap2, (String) hashMap2.get("duid"));
                            z2 = true;
                        }
                        if (!a.this.a(hashMap, mobProduct)) {
                            z3 = z2;
                        }
                        if (z3) {
                            a.this.c(hashMap);
                        }
                    }
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(HashMap<String, Object> hashMap) {
        boolean z;
        HashMap hashMap2 = (HashMap) hashMap.get("deviceInfo");
        if (hashMap2 == null) {
            return true;
        }
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        Object obj = hashMap.get("duid");
        String d2 = h.d();
        if (TextUtils.isEmpty(d2) && obj != null) {
            h.d(String.valueOf(obj));
        }
        if (TextUtils.isEmpty(d2) || obj == null || d2.equals(obj)) {
            Object obj2 = hashMap2.get("adsid");
            String str = null;
            try {
                str = deviceHelper.getAdvertisingID();
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
            if (str == null || str.equals(obj2)) {
                System.currentTimeMillis();
                if (b.E()) {
                    Object obj3 = hashMap2.get("phoneno");
                    String ln = deviceHelper.getLN();
                    if (ln != null && !ln.equals(obj3)) {
                        return true;
                    }
                }
                Object obj4 = hashMap2.get("simserialno");
                String simSerialNumber = deviceHelper.getSimSerialNumber();
                if (simSerialNumber == null || simSerialNumber.equals(obj4)) {
                    Object obj5 = hashMap2.get("imei");
                    String imei = deviceHelper.getIMEI();
                    if (imei == null || imei.equals(obj5)) {
                        Object obj6 = hashMap2.get("serialno");
                        String serialno = deviceHelper.getSerialno();
                        if (serialno == null || serialno.equals(obj6)) {
                            Object obj7 = hashMap2.get("mac");
                            String macAddress = deviceHelper.getMacAddress();
                            if (macAddress == null || macAddress.equals(obj7)) {
                                Object obj8 = hashMap2.get(BigAlbumStore.PhotoTagColumns.MODEL);
                                String model = deviceHelper.getModel();
                                if (model == null || model.equals(obj8)) {
                                    Object obj9 = hashMap2.get("factory");
                                    String manufacturer = deviceHelper.getManufacturer();
                                    if (manufacturer == null || manufacturer.equals(obj9)) {
                                        Object obj10 = hashMap2.get("carrier");
                                        String carrier = deviceHelper.getCarrier();
                                        if (carrier == null || carrier.equals(obj10)) {
                                            Object obj11 = hashMap2.get("imsi");
                                            String imsi = deviceHelper.getIMSI();
                                            if (imsi == null || imsi.equals(obj11)) {
                                                Object obj12 = hashMap2.get("imsiArray");
                                                String[] queryIMSI = deviceHelper.queryIMSI();
                                                if (queryIMSI != null && queryIMSI.length > 0) {
                                                    if (obj12 == null) {
                                                        return true;
                                                    }
                                                    try {
                                                        ArrayList arrayList = (ArrayList) obj12;
                                                        if (arrayList.size() != queryIMSI.length) {
                                                            return true;
                                                        }
                                                        boolean z2 = false;
                                                        for (String str2 : queryIMSI) {
                                                            Iterator it = arrayList.iterator();
                                                            while (true) {
                                                                if (it.hasNext()) {
                                                                    if (str2.equals((String) it.next())) {
                                                                        z2 = false;
                                                                        break;
                                                                    }
                                                                } else {
                                                                    z2 = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if (z2) {
                                                            return true;
                                                        }
                                                    } catch (Throwable unused) {
                                                    }
                                                }
                                                Object obj13 = hashMap2.get("androidids");
                                                if (obj13 == null && (obj13 = hashMap2.get("androidid")) != null) {
                                                    ArrayList arrayList2 = new ArrayList();
                                                    arrayList2.add(obj13);
                                                    obj13 = arrayList2;
                                                }
                                                if (obj13 != null && (obj13 instanceof ArrayList)) {
                                                    String androidID = deviceHelper.getAndroidID();
                                                    Iterator it2 = ((ArrayList) obj13).iterator();
                                                    while (true) {
                                                        if (!it2.hasNext()) {
                                                            z = false;
                                                            break;
                                                        }
                                                        Object next = it2.next();
                                                        if (next != null && next.equals(androidID)) {
                                                            z = true;
                                                            break;
                                                        }
                                                    }
                                                    if (!z) {
                                                        return true;
                                                    }
                                                    Object obj14 = hashMap2.get("sysver");
                                                    String oSVersionName = deviceHelper.getOSVersionName();
                                                    if (oSVersionName != null && !oSVersionName.equals(obj14)) {
                                                        return true;
                                                    }
                                                    Object obj15 = hashMap2.get("xp");
                                                    boolean cx = deviceHelper.cx();
                                                    if (obj15 != null && String.valueOf(cx ? 1 : 0).equals(String.valueOf(obj15))) {
                                                        Object obj16 = hashMap2.get("breaked");
                                                        boolean isRooted = deviceHelper.isRooted();
                                                        if (!(obj16 == null && isRooted) && (obj16 == null || String.valueOf(obj16).equals(String.valueOf(isRooted)))) {
                                                            Object obj17 = hashMap2.get(j.a(69));
                                                            String b = com.mob.commons.b.a.b(MobSDK.getContext());
                                                            return (obj17 == null && !TextUtils.isEmpty(b)) || !(obj17 == null || String.valueOf(obj17).equals(b));
                                                        }
                                                        return true;
                                                    }
                                                }
                                                return true;
                                            }
                                            return true;
                                        }
                                        return true;
                                    }
                                    return true;
                                }
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, Object> hashMap, String str) {
        try {
            if (b.t()) {
                return;
            }
            String b = k.a().b();
            b(hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("token", b);
            for (Map.Entry entry : ((HashMap) hashMap.get("deviceInfo")).entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
            try {
                hashMap2.put("carrier", Integer.valueOf(ResHelper.parseInt(String.valueOf(hashMap2.get("carrier")))));
            } catch (Throwable unused) {
            }
            ArrayList arrayList = (ArrayList) hashMap2.remove("androidids");
            if (arrayList != null && !arrayList.isEmpty()) {
                hashMap2.put("androidid", arrayList.get(arrayList.size() - 1));
            }
            DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
            hashMap2.put("duid", str);
            String[] queryIMEI = deviceHelper.queryIMEI();
            if (queryIMEI != null && queryIMEI.length > 0) {
                hashMap2.put("imeiArray", queryIMEI);
            }
            try {
                HashMap<String, String> listNetworkHardware = deviceHelper.listNetworkHardware();
                if (listNetworkHardware != null && !listNetworkHardware.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Map.Entry<String, String> entry2 : listNetworkHardware.entrySet()) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("ss", entry2.getKey());
                        hashMap3.put("mac", entry2.getValue());
                        arrayList2.add(hashMap3);
                    }
                    hashMap2.put("macArray", arrayList2);
                }
            } catch (Throwable unused2) {
            }
            HashMap<String, Long> memoryInfo = deviceHelper.getMemoryInfo();
            HashMap<String, HashMap<String, Long>> sizeInfo = deviceHelper.getSizeInfo();
            if (memoryInfo != null) {
                hashMap2.put("ram", memoryInfo.get("total"));
            }
            if (sizeInfo != null) {
                HashMap<String, Long> hashMap4 = sizeInfo.get("sdcard");
                if (hashMap4 != null) {
                    hashMap2.put("sdcardStorage", hashMap4.get("total"));
                }
                HashMap<String, Long> hashMap5 = sizeInfo.get("data");
                if (hashMap5 != null) {
                    hashMap2.put("dataStorage", hashMap5.get("total"));
                }
            }
            hashMap2.put("romImg", deviceHelper.getMIUIVersion());
            Hashon hashon = new Hashon();
            String encodeToString = Base64.encodeToString(Data.AES128Encode(f(), hashon.fromHashMap(hashMap2)), 2);
            ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
            arrayList3.add(new KVPair<>("m", encodeToString));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
            networkTimeOut.connectionTimeout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
            NetworkHelper networkHelper = new NetworkHelper();
            String str2 = a + "/dinfo";
            ArrayList<KVPair<String>> arrayList4 = new ArrayList<>();
            arrayList4.add(new KVPair<>("User-Identity", MobProductCollector.getUserIdentity()));
            arrayList4.add(new KVPair<>(j.a(68), com.mob.commons.b.a.c(MobSDK.getContext())));
            if ("200".equals(String.valueOf(hashon.fromJson(networkHelper.httpPost(str2, arrayList3, (KVPair<String>) null, arrayList4, networkTimeOut)).get("status")))) {
                h.d(str);
                a(b.a() + b.w());
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(HashMap<String, Object> hashMap, MobProduct mobProduct) {
        if (mobProduct == null) {
            mobProduct = new MobProduct() { // from class: com.mob.commons.authorize.a.3
                @Override // com.mob.commons.MobProduct
                public String getProductTag() {
                    return "COMMON";
                }

                @Override // com.mob.commons.MobProduct
                public int getSdkver() {
                    return MobSDK.SDK_VERSION_CODE;
                }
            };
        }
        boolean z = false;
        try {
            HashMap hashMap2 = (HashMap) hashMap.get("appInfo");
            if (hashMap2 == null) {
                hashMap2 = new HashMap();
                hashMap.put("appInfo", hashMap2);
                z = true;
            }
            String packageName = DeviceHelper.getInstance(MobSDK.getContext()).getPackageName();
            HashMap hashMap3 = (HashMap) hashMap2.get(packageName);
            if (hashMap3 == null) {
                hashMap3 = new HashMap();
                hashMap2.put(packageName, hashMap3);
                z = true;
            }
            String str = (String) hashMap3.get(mobProduct.getProductTag());
            String appkey = MobSDK.getAppkey();
            if (str == null || !str.equals(appkey)) {
                if (a(mobProduct, hashMap)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        return z;
    }

    private boolean a(MobProduct mobProduct, HashMap<String, Object> hashMap) throws Throwable {
        if (b.t()) {
            return false;
        }
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("product", mobProduct.getProductTag()));
        String str = (String) hashMap.get("duid");
        arrayList.add(new KVPair<>("appkey", MobSDK.getAppkey()));
        arrayList.add(new KVPair<>("duid", str));
        arrayList.add(new KVPair<>("apppkg", String.valueOf(deviceHelper.getPackageName())));
        arrayList.add(new KVPair<>("appver", String.valueOf(deviceHelper.getAppVersion())));
        arrayList.add(new KVPair<>("sdkver", String.valueOf(mobProduct.getSdkver())));
        arrayList.add(new KVPair<>("network", String.valueOf(deviceHelper.getDetailNetworkTypeForStatic())));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        networkTimeOut.connectionTimeout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Identity", MobProductCollector.getUserIdentity()));
        arrayList2.add(new KVPair<>(j.a(68), com.mob.commons.b.a.c(MobSDK.getContext())));
        HashMap fromJson = new Hashon().fromJson(new NetworkHelper().httpPost(a + "/dsign", arrayList, (KVPair<String>) null, arrayList2, networkTimeOut));
        if ("true".equals(String.valueOf(fromJson.get("reup")))) {
            a(hashMap, str);
        }
        if ("200".equals(String.valueOf(fromJson.get("status")))) {
            ((HashMap) ((HashMap) hashMap.get("appInfo")).get(deviceHelper.getPackageName())).put(mobProduct.getProductTag(), MobSDK.getAppkey());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092 A[Catch: all -> 0x0098, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0098, blocks: (B:22:0x007e, B:29:0x0092), top: B:42:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.HashMap<java.lang.String, java.lang.Object> r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r0 = "duid"
            r1 = 0
            if (r6 != 0) goto L4d
            java.lang.Object r6 = r5.get(r0)     // Catch: java.lang.Throwable -> L88
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L88
            android.content.Context r2 = com.mob.MobSDK.getContext()     // Catch: java.lang.Throwable -> L88
            com.mob.tools.utils.DeviceHelper r2 = com.mob.tools.utils.DeviceHelper.getInstance(r2)     // Catch: java.lang.Throwable -> L88
            boolean r3 = r2.getSdcardState()     // Catch: java.lang.Throwable -> L88
            if (r3 == 0) goto L4d
            java.util.HashMap r3 = r4.e()     // Catch: java.lang.Throwable -> L88
            if (r3 == 0) goto L39
            java.lang.Object r2 = r3.get(r0)     // Catch: java.lang.Throwable -> L88
            java.lang.Object r2 = com.mob.tools.utils.ResHelper.forceCast(r2, r1)     // Catch: java.lang.Throwable -> L88
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L88
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L88
            if (r3 != 0) goto L4d
            boolean r6 = r2.equals(r6)     // Catch: java.lang.Throwable -> L88
            if (r6 != 0) goto L4d
            r5.put(r0, r2)     // Catch: java.lang.Throwable -> L88
            goto L4d
        L39:
            r3 = 0
            java.lang.String r2 = r2.getWAbcd(r3)     // Catch: java.lang.Throwable -> L88
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L88
            if (r3 != 0) goto L4d
            boolean r6 = r2.equals(r6)     // Catch: java.lang.Throwable -> L88
            if (r6 != 0) goto L4d
            r5.put(r0, r2)     // Catch: java.lang.Throwable -> L88
        L4d:
            java.io.File r6 = r4.c()     // Catch: java.lang.Throwable -> L88
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L88
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L88
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L88
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L88
            r2.writeObject(r5)     // Catch: java.lang.Throwable -> L85
            java.io.File r5 = r4.d()     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L85
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L85
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L85
            if (r0 != 0) goto L7e
            r5.delete()     // Catch: java.lang.Throwable -> L85
            java.lang.String r6 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> L85
            java.lang.String r5 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L85
            com.mob.tools.utils.ResHelper.copyFile(r6, r5)     // Catch: java.lang.Throwable -> L85
        L7e:
            r2.flush()     // Catch: java.lang.Throwable -> L98
            r2.close()     // Catch: java.lang.Throwable -> L98
            goto L98
        L85:
            r5 = move-exception
            r1 = r2
            goto L89
        L88:
            r5 = move-exception
        L89:
            com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L99
            r6.w(r5)     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto L98
            r1.flush()     // Catch: java.lang.Throwable -> L98
            r1.close()     // Catch: java.lang.Throwable -> L98
        L98:
            return
        L99:
            r5 = move-exception
            if (r1 == 0) goto La2
            r1.flush()     // Catch: java.lang.Throwable -> La2
            r1.close()     // Catch: java.lang.Throwable -> La2
        La2:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.authorize.a.a(java.util.HashMap, boolean):void");
    }

    private void a(final String str, final MobProduct mobProduct) {
        new Thread() { // from class: com.mob.commons.authorize.a.5
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (a.a) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("duid", str);
                        a.this.a(hashMap, str);
                        a.this.a(hashMap, mobProduct);
                        a.this.c(hashMap);
                    }
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(final boolean z, final boolean z2) {
        final String[] strArr = new String[1];
        d.a(d.a("comm/locks/.globalLock"), new LockAction() { // from class: com.mob.commons.authorize.a.6
            @Override // com.mob.commons.LockAction
            public boolean run(FileLocker fileLocker) {
                try {
                    if (!z) {
                        a.this.g();
                    }
                    HashMap e2 = a.this.e();
                    if (e2 == null) {
                        e2 = new HashMap();
                    }
                    String str = (String) e2.get("duid");
                    if (str == null && z2) {
                        str = a.this.a(!z);
                        if (!z) {
                            e2.put("duid", str);
                            a.this.a((HashMap<String, Object>) e2, false);
                        }
                    }
                    strArr[0] = str;
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                }
                return false;
            }
        });
        return strArr[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        try {
            HashMap<String, Object> e2 = e();
            String str = e2 != null ? (String) e2.get("duid") : null;
            return str == null ? a((String) null) : str;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    private void a(long j2) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(ResHelper.getDataCacheFile(MobSDK.getContext(), "comm/dbs/.digap")));
            dataOutputStream.writeLong(j2);
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b A[Catch: all -> 0x00d8, TryCatch #0 {all -> 0x00d8, blocks: (B:5:0x0007, B:7:0x001b, B:12:0x0029, B:14:0x002f, B:16:0x0039, B:19:0x0051, B:23:0x005a, B:25:0x0060, B:30:0x006b, B:33:0x007a, B:37:0x0082, B:39:0x0088, B:41:0x008e, B:43:0x0094, B:45:0x009a, B:47:0x00a0, B:52:0x00aa, B:11:0x0024), top: B:57:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00aa A[Catch: all -> 0x00d8, TRY_LEAVE, TryCatch #0 {all -> 0x00d8, blocks: (B:5:0x0007, B:7:0x001b, B:12:0x0029, B:14:0x002f, B:16:0x0039, B:19:0x0051, B:23:0x005a, B:25:0x0060, B:30:0x006b, B:33:0x007a, B:37:0x0082, B:39:0x0088, B:41:0x008e, B:43:0x0094, B:45:0x009a, B:47:0x00a0, B:52:0x00aa, B:11:0x0024), top: B:57:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r12) {
        /*
            java.lang.String r0 = "comm/dbs/.duid"
            java.lang.String r1 = "unknown"
            if (r12 != 0) goto L7
            return
        L7:
            java.io.File r2 = com.mob.tools.utils.ResHelper.getCacheRootFile(r12, r0)     // Catch: java.lang.Throwable -> Ld8
            java.util.HashMap r3 = a(r2)     // Catch: java.lang.Throwable -> Ld8
            android.content.Context r4 = com.mob.MobSDK.getContext()     // Catch: java.lang.Throwable -> Ld8
            java.io.File r0 = com.mob.tools.utils.ResHelper.getDataCacheFile(r4, r0)     // Catch: java.lang.Throwable -> Ld8
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L24
            boolean r6 = r3.isEmpty()     // Catch: java.lang.Throwable -> Ld8
            if (r6 == 0) goto L22
            goto L24
        L22:
            r6 = 1
            goto L29
        L24:
            java.util.HashMap r3 = a(r0)     // Catch: java.lang.Throwable -> Ld8
            r6 = 0
        L29:
            com.mob.tools.utils.DeviceHelper r7 = com.mob.tools.utils.DeviceHelper.getInstance(r12)     // Catch: java.lang.Throwable -> Ld8
            if (r3 == 0) goto La8
            java.lang.String r8 = "deviceInfo"
            java.lang.Object r3 = r3.get(r8)     // Catch: java.lang.Throwable -> Ld8
            java.util.HashMap r3 = (java.util.HashMap) r3     // Catch: java.lang.Throwable -> Ld8
            if (r3 == 0) goto La8
            java.lang.String r8 = "model"
            java.lang.Object r8 = r3.get(r8)     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r9 = "factory"
            java.lang.Object r3 = r3.get(r9)     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> Ld8
            boolean r9 = r1.equalsIgnoreCase(r8)     // Catch: java.lang.Throwable -> Ld8
            r10 = 0
            if (r9 == 0) goto L51
            r8 = r10
        L51:
            boolean r9 = r1.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> Ld8
            if (r9 == 0) goto L58
            r3 = r10
        L58:
            if (r6 == 0) goto L68
            boolean r6 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Ld8
            if (r6 != 0) goto L66
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Ld8
            if (r6 == 0) goto L68
        L66:
            r6 = 1
            goto L69
        L68:
            r6 = 0
        L69:
            if (r6 != 0) goto La8
            java.lang.String r6 = r7.getModel()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r9 = r7.getManufacturer()     // Catch: java.lang.Throwable -> Ld8
            boolean r11 = r1.equalsIgnoreCase(r6)     // Catch: java.lang.Throwable -> Ld8
            if (r11 == 0) goto L7a
            r6 = r10
        L7a:
            boolean r1 = r1.equalsIgnoreCase(r9)     // Catch: java.lang.Throwable -> Ld8
            if (r1 == 0) goto L81
            goto L82
        L81:
            r10 = r9
        L82:
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> Ld8
            if (r1 != 0) goto L94
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Ld8
            if (r1 != 0) goto L94
            boolean r1 = r6.equalsIgnoreCase(r8)     // Catch: java.lang.Throwable -> Ld8
            if (r1 == 0) goto La6
        L94:
            boolean r1 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Ld8
            if (r1 != 0) goto La7
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Ld8
            if (r1 != 0) goto La7
            boolean r1 = r10.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> Ld8
            if (r1 != 0) goto La7
        La6:
            r4 = 1
        La7:
            r6 = r4
        La8:
            if (r6 == 0) goto Le0
            r2.delete()     // Catch: java.lang.Throwable -> Ld8
            r0.delete()     // Catch: java.lang.Throwable -> Ld8
            r7.removeWABCD()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r0 = "comm/.di"
            java.io.File r0 = com.mob.tools.utils.ResHelper.getCacheRootFile(r12, r0)     // Catch: java.lang.Throwable -> Ld8
            r0.delete()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r0 = ".dk"
            java.io.File r0 = com.mob.tools.utils.ResHelper.getCacheRootFile(r12, r0)     // Catch: java.lang.Throwable -> Ld8
            r0.delete()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r0 = ".mcw"
            java.io.File r0 = com.mob.tools.utils.ResHelper.getCacheRootFile(r12, r0)     // Catch: java.lang.Throwable -> Ld8
            r0.delete()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r0 = ".slw"
            java.io.File r12 = com.mob.tools.utils.ResHelper.getCacheRootFile(r12, r0)     // Catch: java.lang.Throwable -> Ld8
            r12.delete()     // Catch: java.lang.Throwable -> Ld8
            goto Le0
        Ld8:
            r12 = move-exception
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
            r0.w(r12)
        Le0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.authorize.a.a(android.content.Context):void");
    }

    private static HashMap<String, Object> a(File file) {
        ObjectInputStream objectInputStream;
        try {
            if (file.exists() && file.isFile()) {
                try {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    try {
                        HashMap<String, Object> hashMap = (HashMap) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return hashMap;
                    } catch (Throwable th) {
                        th = th;
                        MobLog.getInstance().w(th);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream = null;
                }
            }
        } catch (Throwable unused2) {
        }
        return null;
    }
}
