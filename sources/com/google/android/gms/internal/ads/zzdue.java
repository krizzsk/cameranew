package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdue {
    private final Context context;
    private final zzdsy zzvs;

    public zzdue(@NonNull Context context, zzdsy zzdsyVar) {
        this.context = context;
        this.zzvs = zzdsyVar;
    }

    public static boolean zza(zzgp zzgpVar) {
        int i2 = zzdud.zzhtw[zzgpVar.ordinal()];
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
    }

    private final String zzaye() {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String value = zzdwq.OS_ARCH.value();
        if (TextUtils.isEmpty(value) || !hashSet.contains(value)) {
            try {
                String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
                if (strArr != null && strArr.length > 0) {
                    return strArr[0];
                }
            } catch (IllegalAccessException e2) {
                zzdsy zzdsyVar = this.zzvs;
                if (zzdsyVar != null) {
                    zzdsyVar.zza(2024, 0L, e2);
                }
            } catch (NoSuchFieldException e3) {
                zzdsy zzdsyVar2 = this.zzvs;
                if (zzdsyVar2 != null) {
                    zzdsyVar2.zza(2024, 0L, e3);
                }
            }
            String str = Build.CPU_ABI;
            return str != null ? str : Build.CPU_ABI2;
        }
        return value;
    }

    private final zzgp zzayf() {
        FileInputStream fileInputStream;
        byte[] bArr;
        File file = new File(new File(this.context.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            zzdsy zzdsyVar = this.zzvs;
            if (zzdsyVar != null) {
                zzdsyVar.zzg(5017, "No lib/");
            }
            return zzgp.UNKNOWN;
        }
        File[] listFiles = file.listFiles(new zzdye(Pattern.compile(".*\\.so$", 2)));
        if (listFiles != null && listFiles.length != 0) {
            try {
                fileInputStream = new FileInputStream(listFiles[0]);
                bArr = new byte[20];
            } catch (IOException e2) {
                zzc(null, e2.toString());
            }
            if (fileInputStream.read(bArr) == 20) {
                byte[] bArr2 = {0, 0};
                if (bArr[5] == 2) {
                    zzc(bArr, null);
                    zzgp zzgpVar = zzgp.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgpVar;
                }
                bArr2[0] = bArr[19];
                bArr2[1] = bArr[18];
                short s = ByteBuffer.wrap(bArr2).getShort();
                if (s == 3) {
                    zzgp zzgpVar2 = zzgp.X86;
                    fileInputStream.close();
                    return zzgpVar2;
                } else if (s == 40) {
                    zzgp zzgpVar3 = zzgp.ARM7;
                    fileInputStream.close();
                    return zzgpVar3;
                } else if (s == 62) {
                    zzgp zzgpVar4 = zzgp.X86_64;
                    fileInputStream.close();
                    return zzgpVar4;
                } else if (s != 183) {
                    zzc(bArr, null);
                    zzgp zzgpVar5 = zzgp.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgpVar5;
                } else {
                    zzgp zzgpVar6 = zzgp.ARM64;
                    fileInputStream.close();
                    return zzgpVar6;
                }
            }
            fileInputStream.close();
            return zzgp.UNSUPPORTED;
        }
        zzdsy zzdsyVar2 = this.zzvs;
        if (zzdsyVar2 != null) {
            zzdsyVar2.zzg(5017, "No .so");
        }
        return zzgp.UNKNOWN;
    }

    private final void zzc(byte[] bArr, String str) {
        if (this.zzvs == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("os.arch:");
        sb.append(zzdwq.OS_ARCH.value());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";");
        sb.append("CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        this.zzvs.zzg(4007, sb.toString());
    }

    public final zzgp zzayg() {
        zzgp zzayf = zzayf();
        if (zzayf == zzgp.UNKNOWN) {
            String zzaye = zzaye();
            if (TextUtils.isEmpty(zzaye)) {
                zzc(null, "Empty dev arch");
                zzayf = zzgp.UNSUPPORTED;
            } else if (!zzaye.equalsIgnoreCase("i686") && !zzaye.equalsIgnoreCase("x86")) {
                if (zzaye.equalsIgnoreCase("x86_64")) {
                    zzayf = zzgp.X86_64;
                } else if (zzaye.equalsIgnoreCase("arm64-v8a")) {
                    zzayf = zzgp.ARM64;
                } else if (!zzaye.equalsIgnoreCase("armeabi-v7a") && !zzaye.equalsIgnoreCase("armv71")) {
                    zzc(null, zzaye);
                    zzayf = zzgp.UNSUPPORTED;
                } else {
                    zzayf = zzgp.ARM7;
                }
            } else {
                zzayf = zzgp.X86;
            }
        }
        zzdsy zzdsyVar = this.zzvs;
        if (zzdsyVar != null) {
            zzdsyVar.zzg(5018, zzayf.name());
        }
        return zzayf;
    }
}
