package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public final class v implements com.google.android.play.core.splitinstall.x {
    private final Context a;
    private final com.google.android.play.core.splitcompat.c b;
    private final w c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f4868d;

    public v(Context context, Executor executor, w wVar, com.google.android.play.core.splitcompat.c cVar, com.google.android.play.core.splitcompat.q qVar) {
        this.a = context;
        this.b = cVar;
        this.c = wVar;
        this.f4868d = executor;
    }

    @Nullable
    private final Integer c(List<Intent> list) {
        FileLock fileLock;
        try {
            FileChannel channel = new RandomAccessFile(this.b.f(), "rw").getChannel();
            Integer num = null;
            try {
                fileLock = channel.tryLock();
            } catch (OverlappingFileLockException unused) {
                fileLock = null;
            }
            if (fileLock != null) {
                int i2 = 0;
                try {
                    Log.i("SplitCompat", "Copying splits.");
                    for (Intent intent : list) {
                        String stringExtra = intent.getStringExtra("split_id");
                        AssetFileDescriptor openAssetFileDescriptor = this.a.getContentResolver().openAssetFileDescriptor(intent.getData(), "r");
                        File c = this.b.c(stringExtra);
                        if ((!c.exists() || c.length() == openAssetFileDescriptor.getLength()) && c.exists()) {
                        }
                        if (this.b.g(stringExtra).exists()) {
                            continue;
                        } else {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(openAssetFileDescriptor.createInputStream());
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(c);
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.close();
                                bufferedInputStream.close();
                            } catch (Throwable th) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable th2) {
                                    j1.a(th, th2);
                                }
                                throw th;
                            }
                        }
                    }
                    Log.i("SplitCompat", "Splits copied.");
                    try {
                    } catch (Exception e2) {
                        Log.e("SplitCompat", "Error verifying splits.", e2);
                    }
                } catch (Exception e3) {
                    Log.e("SplitCompat", "Error copying splits.", e3);
                    i2 = -13;
                }
                if (this.c.b()) {
                    Log.i("SplitCompat", "Splits verified.");
                    num = Integer.valueOf(i2);
                    fileLock.release();
                } else {
                    Log.e("SplitCompat", "Split verification failed.");
                    i2 = -11;
                    num = Integer.valueOf(i2);
                    fileLock.release();
                }
            }
            if (channel != null) {
                channel.close();
            }
            return num;
        } catch (Exception e4) {
            Log.e("SplitCompat", "Error locking files.", e4);
            return -13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(v vVar, com.google.android.play.core.splitinstall.v vVar2) {
        try {
            if (com.google.android.play.core.splitcompat.a.c(com.google.android.play.core.splitcompat.q.a(vVar.a))) {
                Log.i("SplitCompat", "Splits installed.");
                vVar2.a();
                return;
            }
            Log.e("SplitCompat", "Emulating splits failed.");
            vVar2.a(-12);
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error emulating splits.", e2);
            vVar2.a(-12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(v vVar, List list, com.google.android.play.core.splitinstall.v vVar2) {
        Integer c = vVar.c(list);
        if (c == null) {
            return;
        }
        if (c.intValue() == 0) {
            vVar2.b();
        } else {
            vVar2.a(c.intValue());
        }
    }

    @Override // com.google.android.play.core.splitinstall.x
    public final void a(List<Intent> list, com.google.android.play.core.splitinstall.v vVar) {
        if (!com.google.android.play.core.splitcompat.a.b()) {
            throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
        }
        this.f4868d.execute(new u(this, list, vVar));
    }
}
