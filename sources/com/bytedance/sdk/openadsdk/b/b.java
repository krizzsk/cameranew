package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.i;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: LruDiskFile.java */
/* loaded from: classes.dex */
public abstract class b implements com.bytedance.sdk.openadsdk.b.a {
    private final ExecutorService a = Executors.newSingleThreadExecutor();

    /* compiled from: LruDiskFile.java */
    /* loaded from: classes.dex */
    private class a implements Callable<Void> {
        private final File b;

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            b.this.b(this.b);
            return null;
        }

        private a(File file) {
            this.b = file;
        }
    }

    private File b(String str, File file) {
        List<File> a2 = i.a(file);
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        for (File file2 : a2) {
            if (file2 != null && str.equals(file2.getName())) {
                o.e("TTFullScreenVideoAdImpl", "datastoreGet .........get cache video....");
                return file2;
            }
        }
        return null;
    }

    protected abstract void a(List<File> list);

    protected abstract boolean a(long j2, int i2);

    protected abstract boolean a(File file, long j2, int i2);

    @Override // com.bytedance.sdk.openadsdk.b.a
    public void a(File file) throws IOException {
        this.a.submit(new a(file));
    }

    public File a(String str, File file) throws IOException {
        return b(str, file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws IOException {
        try {
            i.b(file);
        } catch (Throwable th) {
            o.a("LruDiskFile", "setLastModifiedNowError", th);
        }
        a(i.a(file.getParentFile()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b(List<File> list) {
        long j2 = 0;
        for (File file : list) {
            j2 += file.length();
        }
        return j2;
    }
}
