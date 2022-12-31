package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzpi {
    private boolean isOpen;

    public final synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }

    public final synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean zziu() {
        boolean z;
        z = this.isOpen;
        this.isOpen = false;
        return z;
    }
}
