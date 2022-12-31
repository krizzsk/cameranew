package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.util.k;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdoi {
    public static ParcelFileDescriptor zze(final InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        final ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
        zzazp.zzeic.execute(new Runnable(inputStream, parcelFileDescriptor2) { // from class: com.google.android.gms.internal.ads.zzdoh
            private final InputStream zzhlr;
            private final ParcelFileDescriptor zzhls;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhlr = inputStream;
                this.zzhls = parcelFileDescriptor2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                InputStream inputStream2 = this.zzhlr;
                try {
                    ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(this.zzhls);
                    try {
                        k.b(inputStream2, autoCloseOutputStream);
                        autoCloseOutputStream.close();
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                    } catch (Throwable th) {
                        try {
                            autoCloseOutputStream.close();
                        } catch (Throwable th2) {
                            zzeja.zza(th, th2);
                        }
                        throw th;
                    }
                } catch (IOException unused) {
                }
            }
        });
        return parcelFileDescriptor;
    }
}
