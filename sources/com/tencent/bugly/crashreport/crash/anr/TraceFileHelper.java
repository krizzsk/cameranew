package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public static class a {
        public long a;
        public String b;
        public long c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String[]> f7854d;
    }

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public interface b {
        boolean a(long j2);

        boolean a(long j2, long j3, String str);

        boolean a(String str, int i2, String str2, String str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
        r5 = r8[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r5.matcher(r1).matches() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        return new java.lang.Object[]{r5, r1};
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0003, code lost:
        if (r8 != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0006, code lost:
        r1 = r7.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
        r2 = r8.length;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
        if (r4 >= r2) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object[] a(java.io.BufferedReader r7, java.util.regex.Pattern... r8) throws java.io.IOException {
        /*
            r0 = 0
            if (r7 == 0) goto L29
            if (r8 != 0) goto L6
            goto L29
        L6:
            java.lang.String r1 = r7.readLine()
            if (r1 == 0) goto L29
            int r2 = r8.length
            r3 = 0
            r4 = 0
        Lf:
            if (r4 >= r2) goto L6
            r5 = r8[r4]
            java.util.regex.Matcher r6 = r5.matcher(r1)
            boolean r6 = r6.matches()
            if (r6 == 0) goto L26
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r3] = r5
            r8 = 1
            r7[r8] = r1
            return r7
        L26:
            int r4 = r4 + 1
            goto Lf
        L29:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.a(java.io.BufferedReader, java.util.regex.Pattern[]):java.lang.Object[]");
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, boolean z) {
        if (str == null) {
            x.e("path:%s", str);
            return null;
        }
        a aVar = new a();
        readTraceFile(str, new d(aVar, z));
        if (aVar.a <= 0 || aVar.c <= 0 || aVar.b == null) {
            x.e("first dump error %s", aVar.a + " " + aVar.c + " " + aVar.b);
            return null;
        }
        return aVar;
    }

    public static a readTargetDumpInfo(String str, String str2, boolean z) {
        if (str != null && str2 != null) {
            a aVar = new a();
            readTraceFile(str2, new c(aVar, str, z));
            if (aVar.a > 0 && aVar.c > 0 && aVar.b != null) {
                return aVar;
            }
        }
        return null;
    }

    public static void readTraceFile(String str, b bVar) {
        Throwable th;
        BufferedReader bufferedReader;
        if (str == null || bVar == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
            Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
            Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
            Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_SEC_HYPHEN, Locale.US);
            while (true) {
                Object[] a2 = a(bufferedReader, compile);
                if (a2 != null) {
                    String[] split = a2[1].toString().split("\\s");
                    long parseLong = Long.parseLong(split[2]);
                    long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                    Object[] a3 = a(bufferedReader, compile3);
                    if (a3 == null) {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e3) {
                            if (x.a(e3)) {
                                return;
                            }
                            e3.printStackTrace();
                            return;
                        }
                    }
                    Matcher matcher = compile3.matcher(a3[1].toString());
                    matcher.find();
                    matcher.group(1);
                    SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                    if (!bVar.a(parseLong, time, matcher.group(1))) {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e4) {
                            if (x.a(e4)) {
                                return;
                            }
                            e4.printStackTrace();
                            return;
                        }
                    }
                    while (true) {
                        Object[] a4 = a(bufferedReader, compile4, compile2);
                        if (a4 == null) {
                            break;
                        } else if (a4[0] == compile4) {
                            String obj = a4[1].toString();
                            Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                            matcher2.find();
                            String group = matcher2.group();
                            String substring = group.substring(1, group.length() - 1);
                            obj.contains("NATIVE");
                            Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                            matcher3.find();
                            String group2 = matcher3.group();
                            bVar.a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), a(bufferedReader), b(bufferedReader));
                        } else if (!bVar.a(Long.parseLong(a4[1].toString().split("\\s")[2]))) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e5) {
                                if (x.a(e5)) {
                                    return;
                                }
                                e5.printStackTrace();
                                return;
                            }
                        }
                    }
                    simpleDateFormat = simpleDateFormat2;
                } else {
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException e6) {
                        if (x.a(e6)) {
                            return;
                        }
                        e6.printStackTrace();
                        return;
                    }
                }
            }
        } catch (Exception e7) {
            e = e7;
            bufferedReader2 = bufferedReader;
            if (!x.a(e)) {
                e.printStackTrace();
            }
            x.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e8) {
                    if (x.a(e8)) {
                        return;
                    }
                    e8.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e9) {
                    if (!x.a(e9)) {
                        e9.printStackTrace();
                    }
                }
            }
            throw th;
        }
    }

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    static class d implements b {
        private /* synthetic */ a a;
        private /* synthetic */ boolean b;

        d(a aVar, boolean z) {
            this.a = aVar;
            this.b = z;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(String str, int i2, String str2, String str3) {
            x.c("new thread %s", str);
            a aVar = this.a;
            if (aVar.f7854d == null) {
                aVar.f7854d = new HashMap();
            }
            Map<String, String[]> map = this.a.f7854d;
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            map.put(str, new String[]{str2, str3, sb.toString()});
            return true;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j2, long j3, String str) {
            x.c("new process %s", str);
            a aVar = this.a;
            aVar.a = j2;
            aVar.b = str;
            aVar.c = j3;
            return this.b;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j2) {
            x.c("process end %d", Long.valueOf(j2));
            return false;
        }
    }

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    static class c implements b {
        private /* synthetic */ a a;
        private /* synthetic */ String b;
        private /* synthetic */ boolean c;

        c(a aVar, String str, boolean z) {
            this.a = aVar;
            this.b = str;
            this.c = z;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(String str, int i2, String str2, String str3) {
            x.c("new thread %s", str);
            a aVar = this.a;
            if (aVar.a > 0 && aVar.c > 0 && aVar.b != null) {
                if (aVar.f7854d == null) {
                    aVar.f7854d = new HashMap();
                }
                Map<String, String[]> map = this.a.f7854d;
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                map.put(str, new String[]{str2, str3, sb.toString()});
            }
            return true;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j2, long j3, String str) {
            x.c("new process %s", str);
            if (str.equals(this.b)) {
                a aVar = this.a;
                aVar.a = j2;
                aVar.b = str;
                aVar.c = j3;
                return this.c;
            }
            return true;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j2) {
            x.c("process end %d", Long.valueOf(j2));
            a aVar = this.a;
            return aVar.a <= 0 || aVar.c <= 0 || aVar.b == null;
        }
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 3; i2++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}
