package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbce implements zzot {
    private static final Pattern zzbio = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbip = new AtomicReference<>();
    private final int zzbir;
    private final int zzbis;
    private final String zzbit;
    private final zzpd<? super zzbce> zzbix;
    private zzos zzbiy;
    private HttpURLConnection zzbiz;
    private InputStream zzbja;
    private boolean zzbjb;
    private long zzbjc;
    private long zzbjd;
    private long zzbje;
    private long zzcp;
    private int zzens;
    private SSLSocketFactory zzenr = new zzbcd(this);
    private Set<Socket> zzent = new HashSet();
    private final zzox zzbiw = new zzox();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbce(String str, zzpd<? super zzbce> zzpdVar, int i2, int i3, int i4) {
        this.zzbit = zzpg.checkNotEmpty(str);
        this.zzbix = zzpdVar;
        this.zzbir = i2;
        this.zzbis = i3;
        this.zzens = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(Socket socket) {
        this.zzent.add(socket);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long zzc(java.net.HttpURLConnection r9) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r9.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            if (r1 != 0) goto L34
            long r3 = java.lang.Long.parseLong(r0)     // Catch: java.lang.NumberFormatException -> L13
            goto L36
        L13:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r3.append(r1)
            r3.append(r0)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzazk.zzev(r1)
        L34:
            r3 = -1
        L36:
            java.lang.String r1 = "Content-Range"
            java.lang.String r9 = r9.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 != 0) goto Lc9
            java.util.regex.Pattern r1 = com.google.android.gms.internal.ads.zzbce.zzbio
            java.util.regex.Matcher r1 = r1.matcher(r9)
            boolean r5 = r1.find()
            if (r5 == 0) goto Lc9
            r5 = 2
            java.lang.String r5 = r1.group(r5)     // Catch: java.lang.NumberFormatException -> La8
            long r5 = java.lang.Long.parseLong(r5)     // Catch: java.lang.NumberFormatException -> La8
            r7 = 1
            java.lang.String r1 = r1.group(r7)     // Catch: java.lang.NumberFormatException -> La8
            long r7 = java.lang.Long.parseLong(r1)     // Catch: java.lang.NumberFormatException -> La8
            long r5 = r5 - r7
            r7 = 1
            long r5 = r5 + r7
            r7 = 0
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L6c
            r3 = r5
            goto Lc9
        L6c:
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto Lc9
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch: java.lang.NumberFormatException -> La8
            int r1 = r1.length()     // Catch: java.lang.NumberFormatException -> La8
            int r1 = r1 + 26
            java.lang.String r7 = java.lang.String.valueOf(r9)     // Catch: java.lang.NumberFormatException -> La8
            int r7 = r7.length()     // Catch: java.lang.NumberFormatException -> La8
            int r1 = r1 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> La8
            r7.<init>(r1)     // Catch: java.lang.NumberFormatException -> La8
            java.lang.String r1 = "Inconsistent headers ["
            r7.append(r1)     // Catch: java.lang.NumberFormatException -> La8
            r7.append(r0)     // Catch: java.lang.NumberFormatException -> La8
            java.lang.String r0 = "] ["
            r7.append(r0)     // Catch: java.lang.NumberFormatException -> La8
            r7.append(r9)     // Catch: java.lang.NumberFormatException -> La8
            r7.append(r2)     // Catch: java.lang.NumberFormatException -> La8
            java.lang.String r0 = r7.toString()     // Catch: java.lang.NumberFormatException -> La8
            com.google.android.gms.internal.ads.zzazk.zzex(r0)     // Catch: java.lang.NumberFormatException -> La8
            long r0 = java.lang.Math.max(r3, r5)     // Catch: java.lang.NumberFormatException -> La8
            r3 = r0
            goto Lc9
        La8:
            java.lang.String r0 = java.lang.String.valueOf(r9)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r1.append(r0)
            r1.append(r9)
            r1.append(r2)
            java.lang.String r9 = r1.toString()
            com.google.android.gms.internal.ads.zzazk.zzev(r9)
        Lc9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbce.zzc(java.net.HttpURLConnection):long");
    }

    private final void zzir() {
        HttpURLConnection httpURLConnection = this.zzbiz;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                zzazk.zzc("Unexpected error while disconnecting", e2);
            }
            this.zzbiz = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
        if (r3 > 2048) goto L27;
     */
    @Override // com.google.android.gms.internal.ads.zzon
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws com.google.android.gms.internal.ads.zzov {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzbja     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L75
            java.net.HttpURLConnection r2 = r9.zzbiz     // Catch: java.lang.Throwable -> L8d
            long r3 = r9.zzbjd     // Catch: java.lang.Throwable -> L8d
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L11
            goto L14
        L11:
            long r7 = r9.zzcp     // Catch: java.lang.Throwable -> L8d
            long r3 = r3 - r7
        L14:
            int r7 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch: java.lang.Throwable -> L8d
            r8 = 19
            if (r7 == r8) goto L1e
            r8 = 20
            if (r7 != r8) goto L65
        L1e:
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L2e
            int r3 = r2.read()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            r4 = -1
            if (r3 != r4) goto L34
            goto L65
        L2e:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L65
        L34:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            if (r4 != 0) goto L4c
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            if (r3 == 0) goto L65
        L4c:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L8d
        L65:
            java.io.InputStream r2 = r9.zzbja     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8d
            r2.close()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L8d
            goto L75
        L6b:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzov r3 = new com.google.android.gms.internal.ads.zzov     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzos r4 = r9.zzbiy     // Catch: java.lang.Throwable -> L8d
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L8d
            throw r3     // Catch: java.lang.Throwable -> L8d
        L75:
            r9.zzbja = r0
            r9.zzir()
            boolean r0 = r9.zzbjb
            if (r0 == 0) goto L87
            r9.zzbjb = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzbce> r0 = r9.zzbix
            if (r0 == 0) goto L87
            r0.zze(r9)
        L87:
            java.util.Set<java.net.Socket> r0 = r9.zzent
            r0.clear()
            return
        L8d:
            r2 = move-exception
            r9.zzbja = r0
            r9.zzir()
            boolean r0 = r9.zzbjb
            if (r0 == 0) goto La0
            r9.zzbjb = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzbce> r0 = r9.zzbix
            if (r0 == 0) goto La0
            r0.zze(r9)
        La0:
            java.util.Set<java.net.Socket> r0 = r9.zzent
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbce.close():void");
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.zzbiz;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.zzbiz;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int read(byte[] bArr, int i2, int i3) throws zzov {
        try {
            if (this.zzbje != this.zzbjc) {
                byte[] andSet = zzbip.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (true) {
                    long j2 = this.zzbje;
                    long j3 = this.zzbjc;
                    if (j2 != j3) {
                        int read = this.zzbja.read(andSet, 0, (int) Math.min(j3 - j2, andSet.length));
                        if (Thread.interrupted()) {
                            throw new InterruptedIOException();
                        }
                        if (read != -1) {
                            this.zzbje += read;
                            zzpd<? super zzbce> zzpdVar = this.zzbix;
                            if (zzpdVar != null) {
                                zzpdVar.zzc(this, read);
                            }
                        } else {
                            throw new EOFException();
                        }
                    } else {
                        zzbip.set(andSet);
                        break;
                    }
                }
            }
            if (i3 == 0) {
                return 0;
            }
            long j4 = this.zzbjd;
            if (j4 != -1) {
                long j5 = j4 - this.zzcp;
                if (j5 == 0) {
                    return -1;
                }
                i3 = (int) Math.min(i3, j5);
            }
            int read2 = this.zzbja.read(bArr, i2, i3);
            if (read2 == -1) {
                if (this.zzbjd == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.zzcp += read2;
            zzpd<? super zzbce> zzpdVar2 = this.zzbix;
            if (zzpdVar2 != null) {
                zzpdVar2.zzc(this, read2);
            }
            return read2;
        } catch (IOException e2) {
            throw new zzov(e2, this.zzbiy, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setReceiveBufferSize(int i2) {
        this.zzens = i2;
        for (Socket socket : this.zzent) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzens);
                } catch (SocketException e2) {
                    zzazk.zzd("Failed to update receive buffer size.", e2);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x012b, code lost:
        r23.zzbiz = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012d, code lost:
        r0 = r14.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0133, code lost:
        if (r0 < 200) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0137, code lost:
        if (r0 <= 299) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013a, code lost:
        if (r0 != 200) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013c, code lost:
        r3 = r24.position;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0142, code lost:
        if (r3 == 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0144, code lost:
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0146, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0148, code lost:
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0149, code lost:
        r23.zzbjc = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0150, code lost:
        if (r24.isFlagSet(1) != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0152, code lost:
        r3 = r24.zzco;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0158, code lost:
        if (r3 == (-1)) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x015a, code lost:
        r23.zzbjd = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x015d, code lost:
        r3 = zzc(r23.zzbiz);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0165, code lost:
        if (r3 == (-1)) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0167, code lost:
        r4 = r3 - r23.zzbjc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x016c, code lost:
        r4 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x016d, code lost:
        r23.zzbjd = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0170, code lost:
        r23.zzbjd = r24.zzco;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0174, code lost:
        r23.zzbja = r23.zzbiz.getInputStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x017c, code lost:
        r23.zzbjb = true;
        r0 = r23.zzbix;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0181, code lost:
        if (r0 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0183, code lost:
        r0.zza(r23, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0188, code lost:
        return r23.zzbjd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0189, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x018a, code lost:
        zzir();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0193, code lost:
        throw new com.google.android.gms.internal.ads.zzov(r0, r24, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0194, code lost:
        r3 = r23.zzbiz.getHeaderFields();
        zzir();
        r4 = new com.google.android.gms.internal.ads.zzoy(r0, r3, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01a4, code lost:
        if (r0 != 416) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a6, code lost:
        r4.initCause(new com.google.android.gms.internal.ads.zzop(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01af, code lost:
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01b0, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01b1, code lost:
        zzir();
        r5 = java.lang.String.valueOf(r24.uri.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c5, code lost:
        if (r5.length() != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c7, code lost:
        r3 = "Unable to connect to ".concat(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cc, code lost:
        r3 = new java.lang.String("Unable to connect to ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d6, code lost:
        throw new com.google.android.gms.internal.ads.zzov(r3, r0, r24, 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0224 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d9 A[Catch: IOException -> 0x0245, TryCatch #1 {IOException -> 0x0245, blocks: (B:3:0x000f, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:24:0x00d0, B:26:0x00d9, B:27:0x00e0, B:31:0x00e9, B:33:0x00ee, B:35:0x00f6, B:37:0x010b, B:51:0x012b, B:96:0x01db, B:98:0x01e6, B:100:0x01f7, B:102:0x01ff, B:104:0x020d, B:106:0x0217, B:107:0x021a, B:105:0x0212, B:109:0x0224, B:110:0x022b, B:36:0x0108, B:19:0x0085, B:21:0x00a1, B:23:0x00cb, B:111:0x022c, B:112:0x0244), top: B:122:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ee A[Catch: IOException -> 0x0245, TryCatch #1 {IOException -> 0x0245, blocks: (B:3:0x000f, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:24:0x00d0, B:26:0x00d9, B:27:0x00e0, B:31:0x00e9, B:33:0x00ee, B:35:0x00f6, B:37:0x010b, B:51:0x012b, B:96:0x01db, B:98:0x01e6, B:100:0x01f7, B:102:0x01ff, B:104:0x020d, B:106:0x0217, B:107:0x021a, B:105:0x0212, B:109:0x0224, B:110:0x022b, B:36:0x0108, B:19:0x0085, B:21:0x00a1, B:23:0x00cb, B:111:0x022c, B:112:0x0244), top: B:122:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01e6 A[Catch: IOException -> 0x0245, TryCatch #1 {IOException -> 0x0245, blocks: (B:3:0x000f, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:24:0x00d0, B:26:0x00d9, B:27:0x00e0, B:31:0x00e9, B:33:0x00ee, B:35:0x00f6, B:37:0x010b, B:51:0x012b, B:96:0x01db, B:98:0x01e6, B:100:0x01f7, B:102:0x01ff, B:104:0x020d, B:106:0x0217, B:107:0x021a, B:105:0x0212, B:109:0x0224, B:110:0x022b, B:36:0x0108, B:19:0x0085, B:21:0x00a1, B:23:0x00cb, B:111:0x022c, B:112:0x0244), top: B:122:0x000f }] */
    @Override // com.google.android.gms.internal.ads.zzon
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zza(com.google.android.gms.internal.ads.zzos r24) throws com.google.android.gms.internal.ads.zzov {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbce.zza(com.google.android.gms.internal.ads.zzos):long");
    }
}
