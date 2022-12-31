package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzav implements zzk {
    private final Map<String, zzax> zzch;
    private long zzci;
    private final zzaz zzcj;
    private final int zzck;

    public zzav(File file, int i2) {
        this.zzch = new LinkedHashMap(16, 0.75f, true);
        this.zzci = 0L;
        this.zzcj = new zzay(this, file);
        this.zzck = 20971520;
    }

    private final synchronized void remove(String str) {
        boolean delete = zzf(str).delete();
        removeEntry(str);
        if (!delete) {
            zzao.d("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    private final void removeEntry(String str) {
        zzax remove = this.zzch.remove(str);
        if (remove != null) {
            this.zzci -= remove.zzcl;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzc(InputStream inputStream) throws IOException {
        return (zza(inputStream) & 255) | 0 | ((zza(inputStream) & 255) << 8) | ((zza(inputStream) & 255) << 16) | ((zza(inputStream) & 255) << 24) | ((zza(inputStream) & 255) << 32) | ((zza(inputStream) & 255) << 40) | ((zza(inputStream) & 255) << 48) | ((255 & zza(inputStream)) << 56);
    }

    private static String zze(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final File zzf(String str) {
        return new File(this.zzcj.zzo(), zze(str));
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void initialize() {
        File zzo = this.zzcj.zzo();
        if (!zzo.exists()) {
            if (!zzo.mkdirs()) {
                zzao.e("Unable to create cache dir %s", zzo.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = zzo.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            try {
                long length = file.length();
                zzba zzbaVar = new zzba(new BufferedInputStream(zza(file)), length);
                try {
                    zzax zzc = zzax.zzc(zzbaVar);
                    zzc.zzcl = length;
                    zza(zzc.zzcm, zzc);
                    zzbaVar.close();
                } catch (Throwable th) {
                    zzbaVar.close();
                    throw th;
                    break;
                }
            } catch (IOException unused) {
                file.delete();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void zza(String str, boolean z) {
        zzn zzb = zzb(str);
        if (zzb != null) {
            zzb.zzv = 0L;
            zzb.zzu = 0L;
            zza(str, zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized zzn zzb(String str) {
        zzax zzaxVar = this.zzch.get(str);
        if (zzaxVar == null) {
            return null;
        }
        File zzf = zzf(str);
        try {
            zzba zzbaVar = new zzba(new BufferedInputStream(zza(zzf)), zzf.length());
            try {
                zzax zzc = zzax.zzc(zzbaVar);
                if (!TextUtils.equals(str, zzc.zzcm)) {
                    zzao.d("%s: key=%s, found=%s", zzf.getAbsolutePath(), str, zzc.zzcm);
                    removeEntry(str);
                    return null;
                }
                byte[] zza = zza(zzbaVar, zzbaVar.zzp());
                zzn zznVar = new zzn();
                zznVar.data = zza;
                zznVar.zzr = zzaxVar.zzr;
                zznVar.zzs = zzaxVar.zzs;
                zznVar.zzt = zzaxVar.zzt;
                zznVar.zzu = zzaxVar.zzu;
                zznVar.zzv = zzaxVar.zzv;
                List<zzv> list = zzaxVar.zzx;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzv zzvVar : list) {
                    treeMap.put(zzvVar.getName(), zzvVar.getValue());
                }
                zznVar.zzw = treeMap;
                zznVar.zzx = Collections.unmodifiableList(zzaxVar.zzx);
                return zznVar;
            } finally {
                zzbaVar.close();
            }
        } catch (IOException e2) {
            zzao.d("%s: %s", zzf.getAbsolutePath(), e2.toString());
            remove(str);
            return null;
        }
    }

    private zzav(zzaz zzazVar, int i2) {
        this.zzch = new LinkedHashMap(16, 0.75f, true);
        this.zzci = 0L;
        this.zzcj = zzazVar;
        this.zzck = 5242880;
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void zza(String str, zzn zznVar) {
        long j2;
        long j3 = this.zzci;
        byte[] bArr = zznVar.data;
        long length = j3 + bArr.length;
        int i2 = this.zzck;
        if (length <= i2 || bArr.length <= i2 * 0.9f) {
            File zzf = zzf(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(zzf));
                zzax zzaxVar = new zzax(str, zznVar);
                if (zzaxVar.zza(bufferedOutputStream)) {
                    bufferedOutputStream.write(zznVar.data);
                    bufferedOutputStream.close();
                    zzaxVar.zzcl = zzf.length();
                    zza(str, zzaxVar);
                    if (this.zzci >= this.zzck) {
                        if (zzao.DEBUG) {
                            zzao.v("Pruning old cache entries.", new Object[0]);
                        }
                        long j4 = this.zzci;
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        Iterator<Map.Entry<String, zzax>> it = this.zzch.entrySet().iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                j2 = elapsedRealtime;
                                break;
                            }
                            zzax value = it.next().getValue();
                            if (zzf(value.zzcm).delete()) {
                                j2 = elapsedRealtime;
                                this.zzci -= value.zzcl;
                            } else {
                                j2 = elapsedRealtime;
                                String str2 = value.zzcm;
                                zzao.d("Could not delete cache entry for key=%s, filename=%s", str2, zze(str2));
                            }
                            it.remove();
                            i3++;
                            if (((float) this.zzci) < this.zzck * 0.9f) {
                                break;
                            }
                            elapsedRealtime = j2;
                        }
                        if (zzao.DEBUG) {
                            zzao.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.zzci - j4), Long.valueOf(SystemClock.elapsedRealtime() - j2));
                        }
                    }
                    return;
                }
                bufferedOutputStream.close();
                zzao.d("Failed to write header for %s", zzf.getAbsolutePath());
                throw new IOException();
            } catch (IOException unused) {
                if (!zzf.delete()) {
                    zzao.d("Could not clean up file %s", zzf.getAbsolutePath());
                }
                if (this.zzcj.zzo().exists()) {
                    return;
                }
                zzao.d("Re-initializing cache after external clearing.", new Object[0]);
                this.zzch.clear();
                this.zzci = 0L;
                initialize();
            }
        }
    }

    public zzav(zzaz zzazVar) {
        this(zzazVar, 5242880);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 24) | zza(inputStream) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<zzv> zzb(zzba zzbaVar) throws IOException {
        int zzb = zzb((InputStream) zzbaVar);
        if (zzb >= 0) {
            List<zzv> emptyList = zzb == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i2 = 0; i2 < zzb; i2++) {
                emptyList.add(new zzv(zza(zzbaVar).intern(), zza(zzbaVar).intern()));
            }
            return emptyList;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("readHeaderList size=");
        sb.append(zzb);
        throw new IOException(sb.toString());
    }

    private final void zza(String str, zzax zzaxVar) {
        if (!this.zzch.containsKey(str)) {
            this.zzci += zzaxVar.zzcl;
        } else {
            this.zzci += zzaxVar.zzcl - this.zzch.get(str).zzcl;
        }
        this.zzch.put(str, zzaxVar);
    }

    @VisibleForTesting
    private static byte[] zza(zzba zzbaVar, long j2) throws IOException {
        long zzp = zzbaVar.zzp();
        if (j2 >= 0 && j2 <= zzp) {
            int i2 = (int) j2;
            if (i2 == j2) {
                byte[] bArr = new byte[i2];
                new DataInputStream(zzbaVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j2);
        sb.append(", maxLength=");
        sb.append(zzp);
        throw new IOException(sb.toString());
    }

    @VisibleForTesting
    private static InputStream zza(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(OutputStream outputStream, int i2) throws IOException {
        outputStream.write(i2 & 255);
        outputStream.write((i2 >> 8) & 255);
        outputStream.write((i2 >> 16) & 255);
        outputStream.write(i2 >>> 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(OutputStream outputStream, long j2) throws IOException {
        outputStream.write((byte) j2);
        outputStream.write((byte) (j2 >>> 8));
        outputStream.write((byte) (j2 >>> 16));
        outputStream.write((byte) (j2 >>> 24));
        outputStream.write((byte) (j2 >>> 32));
        outputStream.write((byte) (j2 >>> 40));
        outputStream.write((byte) (j2 >>> 48));
        outputStream.write((byte) (j2 >>> 56));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzba zzbaVar) throws IOException {
        return new String(zza(zzbaVar, zzc(zzbaVar)), "UTF-8");
    }
}
