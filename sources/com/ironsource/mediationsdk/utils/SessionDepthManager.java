package com.ironsource.mediationsdk.utils;

import com.ironsource.mediationsdk.IronSource;
/* loaded from: classes2.dex */
public class SessionDepthManager {

    /* renamed from: e  reason: collision with root package name */
    private static SessionDepthManager f5656e;
    private int a = 1;
    private int b = 1;
    private int c = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f5657d = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            a = iArr;
            try {
                iArr[IronSource.AD_UNIT.OFFERWALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[IronSource.AD_UNIT.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private IronSource.AD_UNIT a(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return IronSource.AD_UNIT.BANNER;
                }
                return IronSource.AD_UNIT.INTERSTITIAL;
            }
            return IronSource.AD_UNIT.REWARDED_VIDEO;
        }
        return IronSource.AD_UNIT.OFFERWALL;
    }

    public static synchronized SessionDepthManager getInstance() {
        SessionDepthManager sessionDepthManager;
        synchronized (SessionDepthManager.class) {
            if (f5656e == null) {
                f5656e = new SessionDepthManager();
            }
            sessionDepthManager = f5656e;
        }
        return sessionDepthManager;
    }

    public synchronized int b(int i2) {
        return c(a(i2));
    }

    public synchronized int c(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == null) {
            return -1;
        }
        int i2 = a.a[ad_unit.ordinal()];
        if (i2 == 1) {
            return this.c;
        } else if (i2 == 2) {
            return this.a;
        } else if (i2 == 3) {
            return this.b;
        } else if (i2 != 4) {
            return -1;
        } else {
            return this.f5657d;
        }
    }

    public synchronized void d(int i2) {
        e(a(i2));
    }

    public synchronized void e(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == null) {
            return;
        }
        int i2 = a.a[ad_unit.ordinal()];
        if (i2 == 1) {
            this.c++;
        } else if (i2 == 2) {
            this.a++;
        } else if (i2 == 3) {
            this.b++;
        } else if (i2 == 4) {
            this.f5657d++;
        }
    }
}
