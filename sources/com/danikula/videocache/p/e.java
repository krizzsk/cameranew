package com.danikula.videocache.p;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: LruDiskUsage.java */
/* loaded from: classes.dex */
public abstract class e implements com.danikula.videocache.p.a {
    private static final org.slf4j.b b = org.slf4j.c.i("LruDiskUsage");
    private final ExecutorService a = Executors.newSingleThreadExecutor();

    /* compiled from: LruDiskUsage.java */
    /* loaded from: classes.dex */
    private class a implements Callable<Void> {
        private final File a;

        public a(File file) {
            this.a = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            e.this.e(this.a);
            return null;
        }
    }

    private long d(List<File> list) {
        long j2 = 0;
        for (File file : list) {
            j2 += file.length();
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(File file) throws IOException {
        d.e(file);
        f(d.a(file.getParentFile()));
    }

    private void f(List<File> list) {
        long d2 = d(list);
        int size = list.size();
        for (File file : list) {
            if (!b(file, d2, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    d2 -= length;
                    b.info("Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    b.error("Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    @Override // com.danikula.videocache.p.a
    public void a(File file) throws IOException {
        this.a.submit(new a(file));
    }

    protected abstract boolean b(File file, long j2, int i2);
}
