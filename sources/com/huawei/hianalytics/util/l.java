package com.huawei.hianalytics.util;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class l {
    private static Object a = new Object();

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00a3: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:52:0x00a3 */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject a(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.Object r0 = com.huawei.hianalytics.util.l.a
            monitor-enter(r0)
            r1 = 0
            java.lang.String r2 = d(r7, r8)     // Catch: java.lang.Throwable -> L58 org.json.JSONException -> L5a java.io.IOException -> L74 java.io.FileNotFoundException -> L8b
            java.io.FileInputStream r2 = r7.openFileInput(r2)     // Catch: java.lang.Throwable -> L58 org.json.JSONException -> L5a java.io.IOException -> L74 java.io.FileNotFoundException -> L8b
            com.huawei.hianalytics.util.b r3 = new com.huawei.hianalytics.util.b     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
            r4 = 2048(0x800, float:2.87E-42)
            r3.<init>(r4)     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
            byte[] r4 = new byte[r4]     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
        L15:
            int r5 = r2.read(r4)     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
            r6 = -1
            if (r5 == r6) goto L20
            r3.a(r4, r5)     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
            goto L15
        L20:
            int r4 = r3.a()     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
            if (r4 != 0) goto L35
            if (r2 == 0) goto L33
            r2.close()     // Catch: java.io.IOException -> L2c java.lang.Throwable -> Lb2
            goto L33
        L2c:
            java.lang.String r7 = "StorageUtil"
            java.lang.String r8 = "IOException happened when getInfoFromFile's FileOutputStream close"
            com.huawei.hianalytics.b.b.c(r7, r8)     // Catch: java.lang.Throwable -> Lb2
        L33:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb2
            return r1
        L35:
            java.lang.String r4 = new java.lang.String     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
            byte[] r3 = r3.b()     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
            java.lang.String r5 = "UTF-8"
            r4.<init>(r3, r5)     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
            java.lang.String r3 = com.huawei.hianalytics.util.m.a(r4, r7)     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
            r4.<init>(r3)     // Catch: org.json.JSONException -> L5b java.io.IOException -> L75 java.io.FileNotFoundException -> L8c java.lang.Throwable -> La2
            if (r2 == 0) goto L56
            r2.close()     // Catch: java.io.IOException -> L4f java.lang.Throwable -> Lb2
            goto L56
        L4f:
            java.lang.String r7 = "StorageUtil"
            java.lang.String r8 = "IOException happened when getInfoFromFile's FileOutputStream close"
            com.huawei.hianalytics.b.b.c(r7, r8)     // Catch: java.lang.Throwable -> Lb2
        L56:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb2
            return r4
        L58:
            r7 = move-exception
            goto La4
        L5a:
            r2 = r1
        L5b:
            java.lang.String r3 = "StorageUtil"
            java.lang.String r4 = "getInfoFromFile(): JSONException"
            com.huawei.hianalytics.b.b.c(r3, r4)     // Catch: java.lang.Throwable -> La2
            b(r7, r8)     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto L72
            r2.close()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> Lb2
            goto L72
        L6b:
            java.lang.String r7 = "StorageUtil"
            java.lang.String r8 = "IOException happened when getInfoFromFile's FileOutputStream close"
            com.huawei.hianalytics.b.b.c(r7, r8)     // Catch: java.lang.Throwable -> Lb2
        L72:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb2
            return r1
        L74:
            r2 = r1
        L75:
            java.lang.String r7 = "StorageUtil"
            java.lang.String r8 = "getInfoFromFile(): IOException"
            com.huawei.hianalytics.b.b.c(r7, r8)     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto L89
            r2.close()     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lb2
            goto L89
        L82:
            java.lang.String r7 = "StorageUtil"
            java.lang.String r8 = "IOException happened when getInfoFromFile's FileOutputStream close"
            com.huawei.hianalytics.b.b.c(r7, r8)     // Catch: java.lang.Throwable -> Lb2
        L89:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb2
            return r1
        L8b:
            r2 = r1
        L8c:
            java.lang.String r7 = "StorageUtil"
            java.lang.String r8 = "getInfoFromFile(): is not found file"
            com.huawei.hianalytics.b.b.c(r7, r8)     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto La0
            r2.close()     // Catch: java.io.IOException -> L99 java.lang.Throwable -> Lb2
            goto La0
        L99:
            java.lang.String r7 = "StorageUtil"
            java.lang.String r8 = "IOException happened when getInfoFromFile's FileOutputStream close"
            com.huawei.hianalytics.b.b.c(r7, r8)     // Catch: java.lang.Throwable -> Lb2
        La0:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb2
            return r1
        La2:
            r7 = move-exception
            r1 = r2
        La4:
            if (r1 == 0) goto Lb1
            r1.close()     // Catch: java.io.IOException -> Laa java.lang.Throwable -> Lb2
            goto Lb1
        Laa:
            java.lang.String r8 = "StorageUtil"
            java.lang.String r1 = "IOException happened when getInfoFromFile's FileOutputStream close"
            com.huawei.hianalytics.b.b.c(r8, r1)     // Catch: java.lang.Throwable -> Lb2
        Lb1:
            throw r7     // Catch: java.lang.Throwable -> Lb2
        Lb2:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb2
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.util.l.a(android.content.Context, java.lang.String):org.json.JSONObject");
    }

    public static void a(Context context, JSONObject jSONObject, String str) {
        String str2;
        String str3;
        String d2 = d(context, str);
        synchronized (a) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = context.openFileOutput(d2, 0);
                fileOutputStream.write(m.b(jSONObject.toString(), context).getBytes("UTF-8"));
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        str2 = "StorageUtil";
                        str3 = "IOException happened when saveInfoToFile's FileOutputStream close";
                        com.huawei.hianalytics.b.b.c(str2, str3);
                    }
                }
            } catch (FileNotFoundException unused2) {
                com.huawei.hianalytics.b.b.c("StorageUtil", "saveInfoToFile(): is not found file");
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        str2 = "StorageUtil";
                        str3 = "IOException happened when saveInfoToFile's FileOutputStream close";
                        com.huawei.hianalytics.b.b.c(str2, str3);
                    }
                }
            } catch (IOException unused4) {
                com.huawei.hianalytics.b.b.c("StorageUtil", "saveInfoToFile(): IOException");
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused5) {
                        str2 = "StorageUtil";
                        str3 = "IOException happened when saveInfoToFile's FileOutputStream close";
                        com.huawei.hianalytics.b.b.c(str2, str3);
                    }
                }
            }
        }
    }

    public static void b(Context context, String str) {
        synchronized (a) {
            context.deleteFile(d(context, str));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileInputStream] */
    public static String c(Context context, String str) {
        FileInputStream fileInputStream;
        ?? r1 = 0;
        if (e(context, str)) {
            synchronized (a) {
                try {
                } catch (Throwable th) {
                    th = th;
                    r1 = context;
                }
                try {
                    fileInputStream = context.openFileInput(d(context, str));
                    try {
                        b bVar = new b(2048);
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            bVar.a(bArr, read);
                        }
                        if (bVar.a() == 0) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused) {
                                    com.huawei.hianalytics.b.b.c("StorageUtil", "IOException happened when getInfoFromFile's FileOutputStream close");
                                }
                            }
                            return null;
                        }
                        String str2 = new String(bVar.b(), "UTF-8");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                                com.huawei.hianalytics.b.b.c("StorageUtil", "IOException happened when getInfoFromFile's FileOutputStream close");
                            }
                        }
                        return str2;
                    } catch (FileNotFoundException unused3) {
                        com.huawei.hianalytics.b.b.c("StorageUtil", "getInfoFromFile(): is not found file");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                                com.huawei.hianalytics.b.b.c("StorageUtil", "IOException happened when getInfoFromFile's FileOutputStream close");
                            }
                        }
                        return null;
                    } catch (IOException unused5) {
                        com.huawei.hianalytics.b.b.c("StorageUtil", "getInfoFromFile(): IOException");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused6) {
                                com.huawei.hianalytics.b.b.c("StorageUtil", "IOException happened when getInfoFromFile's FileOutputStream close");
                            }
                        }
                        return null;
                    }
                } catch (FileNotFoundException unused7) {
                    fileInputStream = null;
                } catch (IOException unused8) {
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException unused9) {
                            com.huawei.hianalytics.b.b.c("StorageUtil", "IOException happened when getInfoFromFile's FileOutputStream close");
                        }
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    private static String d(Context context, String str) {
        String packageName = context.getPackageName();
        return "hianalytics_" + str + "_" + packageName;
    }

    private static boolean e(Context context, String str) {
        File file = new File(context.getFilesDir(), d(context, str));
        if (file.exists()) {
            long length = file.length();
            if (length > 5242880) {
                com.huawei.hianalytics.b.b.a("HiAnalytics", "checkV1CachedFile: v1 cached file size overlarge - file len: %d limitedSize: %d", Long.valueOf(length), 5242880L);
                return false;
            }
            return true;
        }
        return false;
    }
}
