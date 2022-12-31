package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class a {
    private Context a;
    private long b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7807d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class C0261a implements t {
        private /* synthetic */ List a;

        C0261a(List list) {
            this.a = list;
        }

        @Override // com.tencent.bugly.proguard.t
        public final void a(boolean z) {
            if (z) {
                x.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                long currentTimeMillis = System.currentTimeMillis();
                for (UserInfoBean userInfoBean : this.a) {
                    userInfoBean.f7800f = currentTimeMillis;
                    a.a(a.this, userInfoBean, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public final class b implements Runnable {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.c();
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public class c implements Runnable {
        private boolean a;
        private UserInfoBean b;

        public c(UserInfoBean userInfoBean, boolean z) {
            this.b = userInfoBean;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.crashreport.common.info.a b;
            try {
                UserInfoBean userInfoBean = this.b;
                if (userInfoBean != null) {
                    if (userInfoBean != null && (b = com.tencent.bugly.crashreport.common.info.a.b()) != null) {
                        userInfoBean.f7804j = b.e();
                    }
                    x.c("[UserInfo] Record user info.", new Object[0]);
                    a.a(a.this, this.b, false);
                }
                if (this.a) {
                    a aVar = a.this;
                    w a = w.a();
                    if (a != null) {
                        a.a(new b());
                    }
                }
            } catch (Throwable th) {
                if (x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < a.this.b) {
                w a = w.a();
                a aVar = a.this;
                a.a(new d(), (aVar.b - currentTimeMillis) + 5000);
                return;
            }
            a.this.a(3, false, 0L);
            a.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public class e implements Runnable {
        private long a;

        public e(long j2) {
            this.a = 21600000L;
            this.a = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            w a = w.a();
            if (a != null) {
                a.a(new b());
            }
            a aVar2 = a.this;
            long j2 = this.a;
            w.a().a(new e(j2), j2);
        }
    }

    public a(Context context, boolean z) {
        this.f7807d = true;
        this.a = context;
        this.f7807d = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ee A[Catch: all -> 0x016f, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fa, B:72:0x0112, B:74:0x0118, B:77:0x0121, B:79:0x0127, B:82:0x0130, B:84:0x013a, B:87:0x0143, B:91:0x0161, B:94:0x0166, B:59:0x00e2), top: B:100:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0118 A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fa, B:72:0x0112, B:74:0x0118, B:77:0x0121, B:79:0x0127, B:82:0x0130, B:84:0x013a, B:87:0x0143, B:91:0x0161, B:94:0x0166, B:59:0x00e2), top: B:100:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0121 A[Catch: all -> 0x016f, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:55:0x00cc, B:58:0x00d3, B:61:0x00e8, B:63:0x00ee, B:65:0x00f3, B:68:0x00fa, B:72:0x0112, B:74:0x0118, B:77:0x0121, B:79:0x0127, B:82:0x0130, B:84:0x013a, B:87:0x0143, B:91:0x0161, B:94:0x0166, B:59:0x00e2), top: B:100:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void c() {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.a.c():void");
    }

    static /* synthetic */ void a(a aVar, UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a;
        if (userInfoBean != null) {
            if (!z && userInfoBean.b != 1 && (a = aVar.a(com.tencent.bugly.crashreport.common.info.a.a(aVar.a).f7817d)) != null && a.size() >= 20) {
                x.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a.size()));
                return;
            }
            long a2 = p.a().a("t_ui", a(userInfoBean), (o) null, true);
            if (a2 >= 0) {
                x.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a2));
                userInfoBean.a = a2;
            }
        }
    }

    public final void b() {
        w a = w.a();
        if (a != null) {
            a.a(new b());
        }
    }

    public final void a(int i2, boolean z, long j2) {
        com.tencent.bugly.crashreport.common.strategy.a a = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a != null && !a.c().f7828f && i2 != 1 && i2 != 3) {
            x.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i2 == 1 || i2 == 3) {
            this.c++;
        }
        com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(this.a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.b = i2;
        userInfoBean.c = a2.f7817d;
        userInfoBean.f7798d = a2.g();
        userInfoBean.f7799e = System.currentTimeMillis();
        userInfoBean.f7800f = -1L;
        userInfoBean.n = a2.f7824k;
        userInfoBean.o = i2 == 1 ? 1 : 0;
        userInfoBean.f7806l = a2.a();
        userInfoBean.m = a2.q;
        userInfoBean.f7801g = a2.r;
        userInfoBean.f7802h = a2.s;
        userInfoBean.f7803i = a2.t;
        userInfoBean.f7805k = a2.u;
        userInfoBean.r = a2.t();
        userInfoBean.s = a2.y();
        userInfoBean.p = a2.z();
        userInfoBean.q = a2.A();
        w.a().a(new c(userInfoBean, z), 0L);
    }

    public final void a() {
        this.b = z.b() + AdvTimeUtils.MILLIS_OF_A_DAY;
        w.a().a(new d(), (this.b - System.currentTimeMillis()) + 5000);
    }

    public final List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (z.a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = p.a().a("t_ui", null, str2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a = a(cursor);
                    if (a != null) {
                        arrayList.add(a);
                    } else {
                        long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(j2);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    x.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", sb2.substring(4), (String[]) null, (o) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size() && i2 < 50; i2++) {
            sb.append(" or _id");
            sb.append(" = ");
            sb.append(list.get(i2).a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        String str = sb2;
        sb.setLength(0);
        try {
            x.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", str, (String[]) null, (o) null, true)));
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = userInfoBean.a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f7799e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f7800f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.c);
            contentValues.put("_dt", z.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) z.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.a = j2;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
