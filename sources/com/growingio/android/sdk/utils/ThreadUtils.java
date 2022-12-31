package com.growingio.android.sdk.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/* loaded from: classes2.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object sLock = new Object();
    private static Handler sUiThreadHandler = null;
    private static boolean sWillOverride = false;

    @SuppressLint({"Assert"})
    public static void assertOnUiThread() {
    }

    public static void cancelTaskOnUiThread(Runnable runnable) {
        getUiThreadHandler().removeCallbacks(runnable);
    }

    private static Handler getUiThreadHandler() {
        Handler handler;
        synchronized (sLock) {
            if (sUiThreadHandler == null) {
                if (!sWillOverride) {
                    sUiThreadHandler = new Handler(Looper.getMainLooper());
                } else {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
            }
            handler = sUiThreadHandler;
        }
        return handler;
    }

    public static Looper getUiThreadLooper() {
        return getUiThreadHandler().getLooper();
    }

    public static <T> FutureTask<T> postOnUiThread(FutureTask<T> futureTask) {
        getUiThreadHandler().post(futureTask);
        return futureTask;
    }

    public static void postOnUiThreadDelayed(Runnable runnable, long j2) {
        getUiThreadHandler().postDelayed(runnable, j2);
    }

    public static <T> FutureTask<T> runOnUiThread(FutureTask<T> futureTask) {
        if (runningOnUiThread()) {
            futureTask.run();
        } else {
            postOnUiThread((FutureTask) futureTask);
        }
        return futureTask;
    }

    public static void runOnUiThreadBlocking(Runnable runnable) {
        if (runningOnUiThread()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        postOnUiThread(futureTask);
        try {
            futureTask.get();
        } catch (Exception e2) {
            throw new RuntimeException("Exception occured while waiting for runnable", e2);
        }
    }

    public static <T> T runOnUiThreadBlockingNoException(Callable<T> callable) {
        try {
            return (T) runOnUiThreadBlocking(callable);
        } catch (ExecutionException e2) {
            throw new RuntimeException("Error occured waiting for callable", e2);
        }
    }

    public static boolean runningOnUiThread() {
        return getUiThreadHandler().getLooper() == Looper.myLooper();
    }

    public static void setUiThread(Looper looper) {
        synchronized (sLock) {
            Handler handler = sUiThreadHandler;
            if (handler != null && handler.getLooper() != looper) {
                throw new RuntimeException("UI thread looper is already set to " + sUiThreadHandler.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + looper);
            }
            sUiThreadHandler = new Handler(looper);
        }
    }

    public static void setWillOverrideUiThread() {
        synchronized (sLock) {
            sWillOverride = true;
        }
    }

    public static void postOnUiThread(Runnable runnable) {
        getUiThreadHandler().post(runnable);
    }

    public static <T> FutureTask<T> runOnUiThread(Callable<T> callable) {
        return runOnUiThread(new FutureTask(callable));
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runningOnUiThread()) {
            runnable.run();
        } else {
            getUiThreadHandler().post(runnable);
        }
    }

    public static <T> T runOnUiThreadBlocking(Callable<T> callable) throws ExecutionException {
        FutureTask futureTask = new FutureTask(callable);
        runOnUiThread(futureTask);
        try {
            return (T) futureTask.get();
        } catch (InterruptedException e2) {
            throw new RuntimeException("Interrupted waiting for callable", e2);
        }
    }
}
