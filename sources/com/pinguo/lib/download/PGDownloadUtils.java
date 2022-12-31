package com.pinguo.lib.download;

import java.io.Closeable;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import us.pinguo.util.v;
/* loaded from: classes3.dex */
public final class PGDownloadUtils {
    private static final String HASH_ALGORITHM = "MD5";
    private static final int RADIX = 36;

    /* loaded from: classes3.dex */
    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        DefaultThreadFactory(int i2, String str) {
            this.threadPriority = i2;
            this.namePrefix = str + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    private PGDownloadUtils() {
    }

    public static void closeIO(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                try {
                    closeable.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    public static ThreadPoolExecutor createExecutor(int i2, int i3) {
        return new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory(i3, "uil-pool-"));
    }

    public static boolean createOrExistsDir(File file) {
        if (file != null) {
            if (file.exists()) {
                return file.isDirectory();
            }
            return file.mkdirs();
        }
        return false;
    }

    public static String generate(String str) {
        if (str == null) {
            str = "";
        }
        return new BigInteger(getMD5(str.getBytes())).abs().toString(36);
    }

    public static String getDownloadPrefPath() {
        File c = v.c();
        if (c != null && createOrExistsDir(c)) {
            String str = c.getAbsolutePath() + File.separator + "download";
            if (createOrExistsDir(new File(str))) {
                return str;
            }
            return null;
        }
        return null;
    }

    private static byte[] getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            us.pinguo.common.log.a.f(e2);
            return null;
        }
    }
}
