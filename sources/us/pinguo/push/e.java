package us.pinguo.push;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileFilter;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ArrayBlockingQueue;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.push.i;
/* compiled from: PushDispatcher.java */
/* loaded from: classes6.dex */
public class e {

    /* renamed from: k  reason: collision with root package name */
    private static final int f11779k = TimeZone.getDefault().getRawOffset();
    private Queue<c> a;
    private String b;
    private String c;

    /* renamed from: e  reason: collision with root package name */
    private long f11781e;

    /* renamed from: j  reason: collision with root package name */
    private i f11786j;

    /* renamed from: d  reason: collision with root package name */
    private String f11780d = null;

    /* renamed from: f  reason: collision with root package name */
    private String f11782f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f11783g = null;

    /* renamed from: h  reason: collision with root package name */
    private Set<String> f11784h = null;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11785i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PushDispatcher.java */
    /* loaded from: classes6.dex */
    public class a implements i.a {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // us.pinguo.push.i.a
        public void a(int i2) {
            us.pinguo.common.log.a.m("newPush", " push result " + i2, new Object[0]);
            this.a.c = i2;
            if (this.a.c != PushResult.SUCCESS.getValue()) {
                if (this.a.c >= PushResult.FAIL.getValue()) {
                    this.a.f11787d = e.this.c;
                    this.a.b++;
                    this.a.m(6, "error result:" + this.a.c);
                } else {
                    this.a.m(6, "error result:" + this.a.c);
                }
            } else {
                this.a.f11787d = e.this.c;
                this.a.m(0, FirebaseAnalytics.Param.SUCCESS);
            }
            e.this.n(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PushDispatcher.java */
    /* loaded from: classes6.dex */
    public class b implements FileFilter {
        b() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file.isDirectory()) {
                return true;
            }
            String name = file.getName();
            if (name.indexOf(95) == 10 && name.endsWith(".json") && name.length() > 15) {
                return e.this.f11780d.compareTo(name.substring(2, 10)) > 0;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PushDispatcher.java */
    /* loaded from: classes6.dex */
    public static class c {
        private File a;
        private int b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private String f11787d;

        /* renamed from: e  reason: collision with root package name */
        private String f11788e;

        /* renamed from: f  reason: collision with root package name */
        private us.pinguo.push.c f11789f;

        /* synthetic */ c(String str, String str2, a aVar) {
            this(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(int i2, String str) {
            us.pinguo.push.c cVar = this.f11789f;
            if (cVar != null) {
                cVar.h(i2, str);
            }
        }

        private c(String str, String str2) {
            this.a = null;
            this.b = 0;
            this.c = PushResult.UNDO.getValue();
            this.f11787d = null;
            this.f11788e = null;
            this.f11789f = null;
            this.f11788e = str;
            this.f11787d = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.f11781e = 0L;
        this.f11786j = null;
        us.pinguo.common.utils.e.b("");
        this.a = new ArrayBlockingQueue(10);
        this.b = k(context);
        long currentTimeMillis = System.currentTimeMillis();
        this.f11781e = currentTimeMillis;
        this.c = us.pinguo.common.utils.i.b(currentTimeMillis, AdvTimeUtils.DATE_FORMAT_DAY);
        this.f11786j = new i();
    }

    private void f() {
        us.pinguo.common.log.a.m("newPush", "clearHistory", new Object[0]);
        if (this.f11783g == null) {
            return;
        }
        File[] listFiles = new File(this.f11783g).listFiles(new b());
        us.pinguo.common.log.a.m("newPush", "delFiles: " + listFiles.length, new Object[0]);
        for (File file : listFiles) {
            file.delete();
        }
    }

    private void g(c cVar) {
        this.f11786j.a(cVar.f11789f, new a(cVar));
    }

    private void h(c cVar) {
        if (cVar != null && cVar.f11789f != null) {
            if (this.f11784h.contains(cVar.f11788e)) {
                us.pinguo.common.log.a.g("newPush", "HistoryIdSet is contains this id. ", new Object[0]);
                cVar.m(5, "HistoryIdSet is contains this id. ");
                return;
            } else if (this.f11785i) {
                us.pinguo.push.c cVar2 = cVar.f11789f;
                Date a2 = cVar2.a();
                Date g2 = cVar2.g();
                if (a2 != null) {
                    us.pinguo.common.log.a.m("newPush", "from time:" + a2.getTime(), new Object[0]);
                    us.pinguo.common.log.a.m("newPush", "timeMillis:" + this.f11781e, new Object[0]);
                    long time = a2.getTime();
                    if (time > this.f11781e) {
                        cVar.c = PushResult.UNDO.getValue();
                        n(cVar);
                        cVar.m(2, "now is:" + this.f11781e + " /from is:" + time);
                        return;
                    }
                }
                if (g2 != null) {
                    long time2 = g2.getTime();
                    if (g2.getTime() < this.f11781e) {
                        cVar.c = PushResult.TIMEOUT.getValue();
                        cVar.f11787d = this.c;
                        n(cVar);
                        cVar.m(3, "now is:" + this.f11781e + " /to is:" + time2);
                        return;
                    }
                }
                g(cVar);
                return;
            } else {
                n(cVar);
                cVar.m(4, "time:" + (this.f11781e + f11779k));
                return;
            }
        }
        us.pinguo.common.log.a.g("newPush", "fbean: " + cVar + " pushControl:" + cVar.f11789f, new Object[0]);
    }

    private c i(File file) {
        us.pinguo.push.c cVar;
        String name = file.getName();
        if (!name.endsWith(".json")) {
            file.delete();
            return null;
        } else if (name.indexOf(95) != 10) {
            file.delete();
            return null;
        } else {
            c cVar2 = new c(name.substring(11, name.length() - 5), name.substring(2, 10), null);
            cVar2.b = name.charAt(1) - '0';
            cVar2.c = name.charAt(0) - '0';
            cVar2.a = file;
            try {
                cVar = us.pinguo.push.a.b(us.pinguo.common.utils.e.j(file));
            } catch (Exception unused) {
                cVar = null;
            }
            if (cVar != null) {
                cVar2.f11789f = cVar;
                return cVar2;
            }
            file.delete();
            return null;
        }
    }

    private Set<String> j() {
        File[] listFiles;
        HashSet hashSet = new HashSet();
        if (this.f11783g == null) {
            return hashSet;
        }
        for (File file : new File(this.f11783g).listFiles()) {
            String name = file.getName();
            int indexOf = name.indexOf(95);
            if (name.endsWith(".json") && indexOf == 10) {
                hashSet.add(name.substring(11, name.length() - 5));
            } else {
                file.delete();
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k(Context context) {
        File a2 = j.a(context);
        if (a2 != null && us.pinguo.common.utils.e.a(a2)) {
            String str = a2.getAbsolutePath() + File.separator + Constants.PUSH;
            if (us.pinguo.common.utils.e.b(str)) {
                return str;
            }
            return null;
        }
        return null;
    }

    private Queue<c> m() {
        LinkedList linkedList = new LinkedList();
        if (this.f11782f == null) {
            return linkedList;
        }
        File[] listFiles = new File(this.f11782f).listFiles();
        us.pinguo.common.log.a.m("newPush", "filelist:" + listFiles.length, new Object[0]);
        for (File file : listFiles) {
            us.pinguo.common.log.a.m("newPush", "jsonFile:" + file, new Object[0]);
            c i2 = i(file);
            if (i2 != null) {
                linkedList.add(i2);
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(c cVar) {
        if (cVar == null || cVar.f11789f == null) {
            return;
        }
        us.pinguo.common.log.a.d("newPush", "bean.result: " + cVar.c, new Object[0]);
        if (cVar.b < 2 && cVar.c != PushResult.SUCCESS.getValue()) {
            if ((cVar.c == PushResult.UNDO.getValue() || cVar.c == PushResult.FAIL.getValue()) && this.f11782f != null) {
                File file = new File(this.f11782f + File.separator + (String.valueOf(cVar.c) + String.valueOf(cVar.b) + cVar.f11787d + '_' + cVar.f11788e + ".json"));
                if (cVar.a != null) {
                    us.pinguo.common.log.a.m("newPush", "fail rename to newFile", new Object[0]);
                    cVar.a.renameTo(file);
                    return;
                }
                try {
                    us.pinguo.common.log.a.m("newPush", "fail writeFileContent", new Object[0]);
                    us.pinguo.common.utils.e.n(file, cVar.f11789f.c());
                    return;
                } catch (Exception e2) {
                    us.pinguo.common.log.a.g("newPush", "writeFile error :" + e2.toString(), new Object[0]);
                    return;
                }
            }
            return;
        }
        if (this.f11783g != null) {
            File file2 = new File(this.f11783g + File.separator + (String.valueOf(cVar.c) + String.valueOf(cVar.b) + cVar.f11787d + '_' + cVar.f11788e + ".json"));
            if (cVar.a == null) {
                try {
                    us.pinguo.common.utils.e.n(file2, cVar.f11789f.c());
                } catch (Exception e3) {
                    us.pinguo.common.log.a.g("newPush", " writeFileContent error: " + e3.toString(), new Object[0]);
                }
            } else {
                us.pinguo.common.log.a.m("newPush", "success rename to newFile", new Object[0]);
                cVar.a.renameTo(file2);
            }
        }
        this.f11784h.add(cVar.f11788e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        us.pinguo.push.c b2 = us.pinguo.push.a.b(str);
        if (b2 == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayBlockingQueue(10);
        }
        c cVar = new c(b2.b(), this.c, null);
        cVar.f11789f = b2;
        this.a.offer(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        Queue<c> queue = this.a;
        if (queue != null) {
            queue.clear();
            this.a = null;
        }
    }

    public void l() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f11781e = currentTimeMillis;
            long j2 = f11779k + currentTimeMillis;
            long j3 = (j2 / AdvTimeUtils.MILLIS_OF_A_DAY) * AdvTimeUtils.MILLIS_OF_A_DAY;
            this.f11785i = j2 > j3 + 25200000 && j2 < 82800000 + j3;
            this.c = us.pinguo.common.utils.i.b(currentTimeMillis, AdvTimeUtils.DATE_FORMAT_DAY);
            this.f11780d = us.pinguo.common.utils.i.b(this.f11781e - 1296000000, AdvTimeUtils.DATE_FORMAT_DAY);
            if (this.b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.b);
                String str = File.separator;
                sb.append(str);
                sb.append("activity");
                String sb2 = sb.toString();
                this.f11782f = sb2;
                if (!us.pinguo.common.utils.e.b(sb2)) {
                    this.f11782f = null;
                }
                String str2 = this.b + str + "history";
                this.f11783g = str2;
                if (!us.pinguo.common.utils.e.b(str2)) {
                    this.f11783g = null;
                }
            }
            f();
            this.f11784h = j();
            Queue<c> m = m();
            while (true) {
                c poll = m.poll();
                if (poll == null) {
                    break;
                }
                us.pinguo.common.log.a.k("newPush readFileQueue while", new Object[0]);
                h(poll);
            }
            while (true) {
                c poll2 = this.a.poll();
                if (poll2 == null) {
                    return;
                }
                us.pinguo.common.log.a.k("newPush queue", new Object[0]);
                h(poll2);
            }
        } catch (Exception unused) {
        }
    }
}
