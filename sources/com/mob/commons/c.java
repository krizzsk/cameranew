package com.mob.commons;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.mob.MobSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SQLiteHelper;
import com.tapjoy.TapjoyConstants;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.matrix.report.Issue;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: DataHeap.java */
/* loaded from: classes2.dex */
public class c implements Handler.Callback {
    private static c a;
    private SQLiteHelper.SingleTableDB c;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5879f = true;

    /* renamed from: d  reason: collision with root package name */
    private Hashon f5877d = new Hashon();

    /* renamed from: e  reason: collision with root package name */
    private Random f5878e = new Random();
    private Handler b = MobHandlerThread.newHandler("d", this);

    private c() {
        b();
        c();
    }

    private void c() {
        String networkType;
        if (b.G()) {
            return;
        }
        long v = b.v();
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        if (deviceHelper != null && ((networkType = deviceHelper.getNetworkType()) == null || PortalFollowFeeds.TYPE_NONE.equals(networkType))) {
            v = 600000;
        }
        this.b.sendEmptyMessageDelayed(1, v);
    }

    private boolean d() {
        String networkType;
        if (b.t()) {
            return true;
        }
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        if (deviceHelper == null || (networkType = deviceHelper.getNetworkType()) == null || PortalFollowFeeds.TYPE_NONE.equals(networkType)) {
            return false;
        }
        this.f5879f = true;
        return this.f5879f && d.a(d.a("comm/locks/.dhlock"), new LockAction() { // from class: com.mob.commons.c.2
            @Override // com.mob.commons.LockAction
            public boolean run(FileLocker fileLocker) {
                String[][] strArr = new String[50];
                int a2 = c.this.a(strArr);
                while (true) {
                    if (a2 <= 0) {
                        break;
                    }
                    SparseArray a3 = c.this.a(strArr, a2);
                    if (a3 != null) {
                        if (a3.size() > 0) {
                            c.this.a(a3);
                        }
                        if (a2 < 50) {
                            break;
                        }
                        a2 = c.this.a(strArr);
                    } else {
                        c.this.f5879f = false;
                        break;
                    }
                }
                return false;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String e() {
        /*
            java.lang.String r0 = com.mob.commons.h.b()     // Catch: java.lang.Throwable -> Lb
            java.lang.String r0 = com.mob.commons.i.b(r0)     // Catch: java.lang.Throwable -> L9
            goto L14
        L9:
            r1 = move-exception
            goto Ld
        Lb:
            r1 = move-exception
            r0 = 0
        Ld:
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            r2.w(r1)
        L14:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L2f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.mob.commons.i.b()
            r0.append(r1)
            java.lang.String r1 = "/v5/gcl"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L2f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.c.e():java.lang.String");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            this.b.removeMessages(1);
            if (!d()) {
                c();
            }
        } else if (i2 == 2) {
            Object[] objArr = (Object[]) message.obj;
            long longValue = ((Long) ResHelper.forceCast(objArr[0], -1L)).longValue();
            if (longValue > 0) {
                b(longValue, (HashMap) objArr[1]);
                c();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized SQLiteHelper.SingleTableDB b() {
        File dataCacheFile;
        if (this.c == null && (dataCacheFile = ResHelper.getDataCacheFile(MobSDK.getContext(), "comm/dbs/.dh")) != null) {
            if (dataCacheFile.length() > 209715200) {
                dataCacheFile.delete();
                dataCacheFile = ResHelper.getDataCacheFile(MobSDK.getContext(), "comm/dbs/.dh");
            }
            SQLiteHelper.SingleTableDB database = SQLiteHelper.getDatabase(dataCacheFile.getAbsolutePath(), "DataHeap_1");
            this.c = database;
            database.addField(Issue.ISSUE_REPORT_TIME, "text", true);
            this.c.addField("data", "text", true);
        }
        return this.c;
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    public synchronized void a(long j2, HashMap<String, Object> hashMap) {
        if (b.G()) {
            return;
        }
        Message message = new Message();
        message.what = 2;
        message.obj = new Object[]{Long.valueOf(j2), hashMap};
        if (hashMap != null) {
            NLog mobLog = MobLog.getInstance();
            mobLog.d("type: " + hashMap.get("type"), new Object[0]);
        }
        this.b.sendMessage(message);
    }

    private void b(final long j2, final HashMap<String, Object> hashMap) {
        if (d.a(d.a("comm/locks/.dhlock"), new LockAction() { // from class: com.mob.commons.c.1
            @Override // com.mob.commons.LockAction
            public boolean run(FileLocker fileLocker) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Issue.ISSUE_REPORT_TIME, String.valueOf(j2));
                    DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
                    HashMap hashMap2 = hashMap;
                    if (hashMap2 != null) {
                        hashMap2.put("appkey", MobSDK.getAppkey());
                        hashMap.put("apppkg", deviceHelper.getPackageName());
                        hashMap.put("appver", deviceHelper.getAppVersionName());
                        long K = b.K();
                        if (K != 0) {
                            hashMap.put("strategyId", Long.valueOf(K));
                        }
                    }
                    contentValues.put("data", Base64.encodeToString(Data.AES128Encode(Data.rawMD5(deviceHelper.getManufacturer()), c.this.f5877d.fromHashMap(hashMap).getBytes("utf-8")), 2));
                    SQLiteHelper.insert(c.this.b(), contentValues);
                    return false;
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                    return false;
                }
            }
        })) {
            return;
        }
        NLog mobLog = MobLog.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("DataHeap add log error data type = ");
        sb.append(hashMap == null ? null : hashMap.get("type"));
        sb.append(", updateTime = ");
        sb.append(j2);
        mobLog.e(new Throwable(sb.toString()));
    }

    private String b(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeLong(this.f5878e.nextLong());
        dataOutputStream.writeLong(this.f5878e.nextLong());
        dataOutputStream.flush();
        dataOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new GZIPOutputStream(byteArrayOutputStream2));
        bufferedOutputStream.write(str.getBytes("utf-8"));
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        byte[] AES128Encode = Data.AES128Encode(byteArray, byteArrayOutputStream2.toByteArray());
        byte[] encode = new MobRSA(1024).encode(byteArray, new BigInteger("ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", 16), new BigInteger("191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", 16));
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream3);
        dataOutputStream2.writeInt(encode.length);
        dataOutputStream2.write(encode);
        dataOutputStream2.writeInt(AES128Encode.length);
        dataOutputStream2.write(AES128Encode);
        dataOutputStream2.flush();
        dataOutputStream2.close();
        return Base64.encodeToString(byteArrayOutputStream3.toByteArray(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String[][] strArr) {
        int i2 = 0;
        try {
            Cursor query = SQLiteHelper.query(b(), new String[]{Issue.ISSUE_REPORT_TIME, "data"}, null, null, null);
            if (query == null) {
                return 0;
            }
            if (!query.moveToFirst()) {
                query.close();
                return 0;
            }
            long a2 = b.a();
            int i3 = 0;
            do {
                try {
                    String[] strArr2 = new String[2];
                    strArr2[0] = query.getString(0);
                    strArr2[1] = query.getString(1);
                    long j2 = -1;
                    try {
                        j2 = Long.parseLong(strArr2[0]);
                    } catch (Throwable unused) {
                    }
                    if (j2 <= a2) {
                        strArr[i3] = strArr2;
                        i3++;
                    }
                    if (i3 >= strArr.length) {
                        break;
                    }
                } catch (Throwable th) {
                    th = th;
                    i2 = i3;
                    MobLog.getInstance().w(th);
                    return i2;
                }
            } while (query.moveToNext());
            query.close();
            return i3;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SparseArray<String> a(String[][] strArr, int i2) {
        try {
            SparseArray<String> sparseArray = new SparseArray<>();
            HashMap hashMap = new HashMap();
            DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
            hashMap.put("plat", Integer.valueOf(deviceHelper.getPlatformCode()));
            hashMap.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, deviceHelper.getDeviceKey());
            hashMap.put("mac", deviceHelper.getMacAddress());
            hashMap.put(BigAlbumStore.PhotoTagColumns.MODEL, deviceHelper.getModel());
            hashMap.put("duid", DeviceAuthorizer.authorize(null));
            hashMap.put("imei", deviceHelper.getIMEI());
            hashMap.put("serialno", deviceHelper.getSerialno());
            hashMap.put("networktype", deviceHelper.getDetailNetworkTypeForStatic());
            hashMap.put("dataNetworkType", Integer.valueOf(deviceHelper.getDataNtType()));
            ArrayList arrayList = new ArrayList();
            byte[] rawMD5 = Data.rawMD5(deviceHelper.getManufacturer());
            for (int i3 = 0; i3 < i2; i3++) {
                String[] strArr2 = strArr[i3];
                HashMap fromJson = this.f5877d.fromJson(new String(Data.AES128Decode(rawMD5, Base64.decode(strArr2[1], 2)), "utf-8").trim());
                if (fromJson == null || fromJson.isEmpty() || a((String) ResHelper.forceCast(fromJson.get("type"), null))) {
                    sparseArray.put(i3, strArr2[0]);
                    arrayList.add(fromJson);
                }
            }
            if (arrayList.isEmpty()) {
                return new SparseArray<>();
            }
            hashMap.put("datas", arrayList);
            hashMap.put("token", k.a().b());
            ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
            arrayList2.add(new KVPair<>("appkey", MobSDK.getAppkey()));
            arrayList2.add(new KVPair<>("m", b(this.f5877d.fromHashMap(hashMap))));
            ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
            arrayList3.add(new KVPair<>("User-Identity", MobProductCollector.getUserIdentity()));
            arrayList3.add(new KVPair<>(j.a(68), com.mob.commons.b.a.c(MobSDK.getContext())));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
            networkTimeOut.connectionTimeout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
            if (!"200".equals(String.valueOf(this.f5877d.fromJson(new NetworkHelper().httpPost(e(), arrayList2, (KVPair<String>) null, arrayList3, networkTimeOut)).get("status")))) {
                h.b((String) null);
            }
            return sparseArray;
        } catch (Throwable th) {
            h.b((String) null);
            MobLog.getInstance().w(th);
            return null;
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (j.a(19).equals(str)) {
            return b.e();
        }
        if (j.a(20).equals(str)) {
            return b.d();
        }
        if (j.a(21).equals(str)) {
            return b.f();
        }
        if (j.a(22).equals(str)) {
            return b.c();
        }
        if (j.a(23).equals(str)) {
            return b.h();
        }
        if (j.a(24).equals(str)) {
            return b.i();
        }
        if (j.a(25).equals(str)) {
            return b.j();
        }
        if (j.a(26).equals(str)) {
            return b.n();
        }
        if (j.a(27).equals(str)) {
            return b.k();
        }
        if (j.a(28).equals(str)) {
            return b.l();
        }
        if (j.a(29).equals(str)) {
            return b.m();
        }
        if (j.a(30).equals(str)) {
            return b.o() > 0;
        } else if (j.a(31).equals(str)) {
            return b.p();
        } else {
            if (j.a(32).equals(str)) {
                return b.r() > 0;
            } else if (j.a(33).equals(str)) {
                return b.s() > 0;
            } else if (j.a(34).equals(str)) {
                return b.x() > 0;
            } else if (j.a(35).equals(str)) {
                return b.y() > 0;
            } else if (j.a(36).equals(str)) {
                return b.z() > 0;
            } else if (j.a(37).equals(str)) {
                return b.A() > 0;
            } else if (j.a(38).equals(str)) {
                return b.B();
            } else {
                return j.a(39).equals(str) ? b.C() > 0 : !j.a(40).equals(str) || b.D() > 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(SparseArray<String> sparseArray) {
        try {
            StringBuilder sb = new StringBuilder();
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append('\'');
                sb.append(sparseArray.valueAt(i2));
                sb.append('\'');
            }
            SQLiteHelper.SingleTableDB b = b();
            return SQLiteHelper.delete(b, "time in (" + sb.toString() + ")", null);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return 0;
        }
    }
}
