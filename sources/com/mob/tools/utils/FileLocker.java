package com.mob.tools.utils;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
/* loaded from: classes3.dex */
public class FileLocker {
    private FileOutputStream fos;
    private FileLock lock;

    private boolean getLock(boolean z) throws Throwable {
        if (z) {
            this.lock = this.fos.getChannel().lock();
        } else {
            this.lock = this.fos.getChannel().tryLock();
        }
        return this.lock != null;
    }

    public synchronized boolean lock(boolean z) {
        return lock(z, z ? 1000L : 500L, 16L);
    }

    public synchronized void release() {
        if (this.fos == null) {
            return;
        }
        unlock();
        try {
            this.fos.close();
        } catch (Throwable unused) {
        }
        this.fos = null;
    }

    public synchronized void setLockFile(String str) {
        try {
            this.fos = new FileOutputStream(str);
        } catch (Throwable unused) {
            FileOutputStream fileOutputStream = this.fos;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                this.fos = null;
            }
        }
    }

    public synchronized void unlock() {
        FileLock fileLock = this.lock;
        if (fileLock == null) {
            return;
        }
        try {
            fileLock.release();
        } catch (Throwable unused) {
        }
        this.lock = null;
    }

    public synchronized boolean lock(boolean z, long j2, long j3) {
        if (this.fos == null) {
            return false;
        }
        return getLock(z);
    }

    public synchronized void lock(Runnable runnable, boolean z) {
        if (lock(z) && runnable != null) {
            runnable.run();
        }
    }
}
