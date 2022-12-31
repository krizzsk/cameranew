package com.tapjoy.internal;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatExtras;
import androidx.core.app.NotificationManagerCompat;
import com.tapjoy.internal.ji;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
final class jj implements jh {
    final Notification.Builder a;
    final ji.c b;
    RemoteViews c;

    /* renamed from: d  reason: collision with root package name */
    RemoteViews f7755d;

    /* renamed from: e  reason: collision with root package name */
    final List f7756e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    final Bundle f7757f = new Bundle();

    /* renamed from: g  reason: collision with root package name */
    int f7758g;

    /* renamed from: h  reason: collision with root package name */
    RemoteViews f7759h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jj(ji.c cVar) {
        ArrayList arrayList;
        this.b = cVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.a = new Notification.Builder(cVar.a, cVar.H);
        } else {
            this.a = new Notification.Builder(cVar.a);
        }
        Notification notification = cVar.M;
        this.a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.f7748g).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.c).setContentText(cVar.f7745d).setContentInfo(cVar.f7750i).setContentIntent(cVar.f7746e).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.f7747f, (notification.flags & 128) != 0).setLargeIcon(cVar.f7749h).setNumber(cVar.f7751j).setProgress(cVar.q, cVar.r, cVar.s);
        if (i2 < 21) {
            this.a.setSound(notification.sound, notification.audioStreamType);
        }
        if (i2 >= 16) {
            this.a.setSubText(cVar.o).setUsesChronometer(cVar.m).setPriority(cVar.f7752k);
            Iterator it = cVar.b.iterator();
            while (it.hasNext()) {
                a((ji.a) it.next());
            }
            Bundle bundle = cVar.A;
            if (bundle != null) {
                this.f7757f.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (cVar.w) {
                    this.f7757f.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                String str = cVar.t;
                if (str != null) {
                    this.f7757f.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                    if (cVar.u) {
                        this.f7757f.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                    } else {
                        this.f7757f.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                    }
                }
                String str2 = cVar.v;
                if (str2 != null) {
                    this.f7757f.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str2);
                }
            }
            this.c = cVar.E;
            this.f7755d = cVar.F;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            this.a.setShowWhen(cVar.f7753l);
            if (i3 < 21 && (arrayList = cVar.N) != null && !arrayList.isEmpty()) {
                Bundle bundle2 = this.f7757f;
                ArrayList arrayList2 = cVar.N;
                bundle2.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (i3 >= 20) {
            this.a.setLocalOnly(cVar.w).setGroup(cVar.t).setGroupSummary(cVar.u).setSortKey(cVar.v);
            this.f7758g = cVar.L;
        }
        if (i3 >= 21) {
            this.a.setCategory(cVar.z).setColor(cVar.B).setVisibility(cVar.C).setPublicVersion(cVar.D).setSound(notification.sound, notification.audioAttributes);
            Iterator it2 = cVar.N.iterator();
            while (it2.hasNext()) {
                this.a.addPerson((String) it2.next());
            }
            this.f7759h = cVar.G;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            this.a.setExtras(cVar.A).setRemoteInputHistory(cVar.p);
            RemoteViews remoteViews = cVar.E;
            if (remoteViews != null) {
                this.a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = cVar.F;
            if (remoteViews2 != null) {
                this.a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = cVar.G;
            if (remoteViews3 != null) {
                this.a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i4 >= 26) {
            this.a.setBadgeIconType(cVar.I).setShortcutId(cVar.J).setTimeoutAfter(cVar.K).setGroupAlertBehavior(cVar.L);
            if (cVar.y) {
                this.a.setColorized(cVar.x);
            }
            if (TextUtils.isEmpty(cVar.H)) {
                return;
            }
            this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
    }

    @Override // com.tapjoy.internal.jh
    public final Notification.Builder a() {
        return this.a;
    }

    private void a(ji.a aVar) {
        Bundle bundle;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 20) {
            if (i2 >= 16) {
                this.f7756e.add(jk.a(this.a, aVar));
                return;
            }
            return;
        }
        Notification.Action.Builder builder = new Notification.Action.Builder(aVar.f7741e, aVar.f7742f, aVar.f7743g);
        jl[] jlVarArr = aVar.b;
        if (jlVarArr != null) {
            for (RemoteInput remoteInput : jl.a(jlVarArr)) {
                builder.addRemoteInput(remoteInput);
            }
        }
        if (aVar.a != null) {
            bundle = new Bundle(aVar.a);
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f7740d);
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setAllowGeneratedReplies(aVar.f7740d);
        }
        builder.addExtras(bundle);
        this.a.addAction(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i2 = notification.defaults & (-2);
        notification.defaults = i2;
        notification.defaults = i2 & (-3);
    }
}
