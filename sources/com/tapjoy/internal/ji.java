package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompatExtras;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class ji {

    /* loaded from: classes3.dex */
    public static class a {
        final Bundle a;
        final jl[] b;
        final jl[] c;

        /* renamed from: d  reason: collision with root package name */
        boolean f7740d;

        /* renamed from: e  reason: collision with root package name */
        public int f7741e;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f7742f;

        /* renamed from: g  reason: collision with root package name */
        public PendingIntent f7743g;
    }

    /* loaded from: classes3.dex */
    public static class b extends d {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f7744e;

        public final b a(CharSequence charSequence) {
            this.b = c.d(charSequence);
            return this;
        }

        public final b b(CharSequence charSequence) {
            this.f7744e = c.d(charSequence);
            return this;
        }

        @Override // com.tapjoy.internal.ji.d
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void a(jh jhVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(jhVar.a()).setBigContentTitle(this.b).bigText(this.f7744e);
                if (this.f7754d) {
                    bigText.setSummaryText(this.c);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        Bundle A;
        Notification D;
        RemoteViews E;
        RemoteViews F;
        RemoteViews G;
        String H;
        String J;
        long K;
        Notification M;
        @Deprecated
        public ArrayList N;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Context a;
        CharSequence c;

        /* renamed from: d  reason: collision with root package name */
        CharSequence f7745d;

        /* renamed from: e  reason: collision with root package name */
        PendingIntent f7746e;

        /* renamed from: f  reason: collision with root package name */
        PendingIntent f7747f;

        /* renamed from: g  reason: collision with root package name */
        RemoteViews f7748g;

        /* renamed from: h  reason: collision with root package name */
        Bitmap f7749h;

        /* renamed from: i  reason: collision with root package name */
        CharSequence f7750i;

        /* renamed from: j  reason: collision with root package name */
        int f7751j;

        /* renamed from: k  reason: collision with root package name */
        int f7752k;
        boolean m;
        d n;
        CharSequence o;
        CharSequence[] p;
        int q;
        int r;
        boolean s;
        String t;
        boolean u;
        String v;
        boolean x;
        boolean y;
        String z;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public ArrayList b = new ArrayList();

        /* renamed from: l  reason: collision with root package name */
        boolean f7753l = true;
        boolean w = false;
        int B = 0;
        int C = 0;
        int I = 0;
        int L = 0;

        public c(@NonNull Context context, @NonNull String str) {
            Notification notification = new Notification();
            this.M = notification;
            this.a = context;
            this.H = str;
            notification.when = System.currentTimeMillis();
            this.M.audioStreamType = -1;
            this.f7752k = 0;
            this.N = new ArrayList();
        }

        public final c a(int i2) {
            this.M.icon = i2;
            return this;
        }

        public final c b(CharSequence charSequence) {
            this.f7745d = d(charSequence);
            return this;
        }

        public final c c(CharSequence charSequence) {
            this.M.tickerText = d(charSequence);
            return this;
        }

        public final Notification d() {
            Notification notification;
            jj jjVar = new jj(this);
            d dVar = jjVar.b.n;
            if (dVar != null) {
                dVar.a(jjVar);
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 26) {
                notification = jjVar.a.build();
            } else if (i2 >= 24) {
                notification = jjVar.a.build();
                if (jjVar.f7758g != 0) {
                    if (notification.getGroup() != null && (notification.flags & 512) != 0 && jjVar.f7758g == 2) {
                        jj.a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.f7758g == 1) {
                        jj.a(notification);
                    }
                }
            } else if (i2 >= 21) {
                jjVar.a.setExtras(jjVar.f7757f);
                notification = jjVar.a.build();
                RemoteViews remoteViews = jjVar.c;
                if (remoteViews != null) {
                    notification.contentView = remoteViews;
                }
                RemoteViews remoteViews2 = jjVar.f7755d;
                if (remoteViews2 != null) {
                    notification.bigContentView = remoteViews2;
                }
                RemoteViews remoteViews3 = jjVar.f7759h;
                if (remoteViews3 != null) {
                    notification.headsUpContentView = remoteViews3;
                }
                if (jjVar.f7758g != 0) {
                    if (notification.getGroup() != null && (notification.flags & 512) != 0 && jjVar.f7758g == 2) {
                        jj.a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.f7758g == 1) {
                        jj.a(notification);
                    }
                }
            } else if (i2 >= 20) {
                jjVar.a.setExtras(jjVar.f7757f);
                notification = jjVar.a.build();
                RemoteViews remoteViews4 = jjVar.c;
                if (remoteViews4 != null) {
                    notification.contentView = remoteViews4;
                }
                RemoteViews remoteViews5 = jjVar.f7755d;
                if (remoteViews5 != null) {
                    notification.bigContentView = remoteViews5;
                }
                if (jjVar.f7758g != 0) {
                    if (notification.getGroup() != null && (notification.flags & 512) != 0 && jjVar.f7758g == 2) {
                        jj.a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.f7758g == 1) {
                        jj.a(notification);
                    }
                }
            } else if (i2 >= 19) {
                SparseArray<? extends Parcelable> a = jk.a(jjVar.f7756e);
                if (a != null) {
                    jjVar.f7757f.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, a);
                }
                jjVar.a.setExtras(jjVar.f7757f);
                notification = jjVar.a.build();
                RemoteViews remoteViews6 = jjVar.c;
                if (remoteViews6 != null) {
                    notification.contentView = remoteViews6;
                }
                RemoteViews remoteViews7 = jjVar.f7755d;
                if (remoteViews7 != null) {
                    notification.bigContentView = remoteViews7;
                }
            } else if (i2 >= 16) {
                notification = jjVar.a.build();
                Bundle a2 = ji.a(notification);
                Bundle bundle = new Bundle(jjVar.f7757f);
                for (String str : jjVar.f7757f.keySet()) {
                    if (a2.containsKey(str)) {
                        bundle.remove(str);
                    }
                }
                a2.putAll(bundle);
                SparseArray<? extends Parcelable> a3 = jk.a(jjVar.f7756e);
                if (a3 != null) {
                    ji.a(notification).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, a3);
                }
                RemoteViews remoteViews8 = jjVar.c;
                if (remoteViews8 != null) {
                    notification.contentView = remoteViews8;
                }
                RemoteViews remoteViews9 = jjVar.f7755d;
                if (remoteViews9 != null) {
                    notification.bigContentView = remoteViews9;
                }
            } else {
                notification = jjVar.a.getNotification();
            }
            RemoteViews remoteViews10 = jjVar.b.E;
            if (remoteViews10 != null) {
                notification.contentView = remoteViews10;
            }
            if (Build.VERSION.SDK_INT >= 16 && dVar != null) {
                ji.a(notification);
            }
            return notification;
        }

        public final c a(CharSequence charSequence) {
            this.c = d(charSequence);
            return this;
        }

        public final c b() {
            this.M.defaults = 1;
            return this;
        }

        public final c c() {
            this.f7752k = 0;
            return this;
        }

        public final c a(PendingIntent pendingIntent) {
            this.f7746e = pendingIntent;
            return this;
        }

        public final c a(Bitmap bitmap) {
            this.f7749h = bitmap;
            return this;
        }

        public final c a(d dVar) {
            if (this.n != dVar) {
                this.n = dVar;
                if (dVar != null) {
                    dVar.a(this);
                }
            }
            return this;
        }

        public final c a() {
            this.M.flags |= 16;
            return this;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        protected c a;
        CharSequence b;
        CharSequence c;

        /* renamed from: d  reason: collision with root package name */
        boolean f7754d = false;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void a(jh jhVar) {
        }

        public final void a(c cVar) {
            if (this.a != cVar) {
                this.a = cVar;
                if (cVar != null) {
                    cVar.a(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            return notification.extras;
        }
        if (i2 >= 16) {
            return jk.a(notification);
        }
        return null;
    }
}
