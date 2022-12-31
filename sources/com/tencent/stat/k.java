package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k implements Runnable {
    private com.tencent.stat.a.e a;
    private StatReportStrategy b;
    private c c = new l(this);

    public k(com.tencent.stat.a.e eVar) {
        this.b = null;
        this.a = eVar;
        this.b = StatConfig.getStatSendStrategy();
    }

    private void b() {
        if (n.b().a() <= 0) {
            c(true);
            return;
        }
        n.b().a(this.a, (c) null);
        n.b().a(-1);
    }

    private void c(boolean z) {
        d.e().c(this.a, this.c);
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        StatLogger statLogger2;
        StatLogger statLogger3;
        n a;
        com.tencent.stat.a.e eVar;
        StatLogger statLogger4;
        StatLogger statLogger5;
        StatLogger statLogger6;
        try {
            if (StatConfig.isEnableStatService()) {
                if (this.a.a() != com.tencent.stat.a.f.ERROR && this.a.d().length() > StatConfig.getMaxReportEventLength()) {
                    statLogger6 = StatService.f8246i;
                    statLogger6.e("Event length exceed StatConfig.getMaxReportEventLength(): " + StatConfig.getMaxReportEventLength());
                    return;
                }
                if (StatConfig.getMaxSessionStatReportCount() > 0) {
                    if (StatConfig.getCurSessionStatReportCount() >= StatConfig.getMaxSessionStatReportCount()) {
                        statLogger5 = StatService.f8246i;
                        statLogger5.e("Times for reporting events has reached the limit of StatConfig.getMaxSessionStatReportCount() in current session.");
                        return;
                    }
                    StatConfig.c();
                }
                statLogger2 = StatService.f8246i;
                statLogger2.i("Lauch stat task in thread:" + Thread.currentThread().getName());
                Context c = this.a.c();
                m mVar = null;
                if (!com.tencent.stat.common.k.h(c)) {
                    n.a(c).a(this.a, (c) null);
                    return;
                }
                if (StatConfig.isEnableSmartReporting() && this.b != StatReportStrategy.ONLY_WIFI_NO_CACHE && com.tencent.stat.common.k.g(c)) {
                    this.b = StatReportStrategy.INSTANT;
                }
                switch (h.a[this.b.ordinal()]) {
                    case 1:
                        b();
                        return;
                    case 2:
                        if (!com.tencent.stat.common.k.e(c)) {
                            a = n.a(c);
                            eVar = this.a;
                            a.a(eVar, mVar);
                            return;
                        }
                        b();
                        return;
                    case 3:
                    case 4:
                        a = n.a(c);
                        eVar = this.a;
                        a.a(eVar, mVar);
                        return;
                    case 5:
                        if (n.a(this.a.c()) == null) {
                            return;
                        }
                        a = n.a(c);
                        eVar = this.a;
                        mVar = new m(this);
                        a.a(eVar, mVar);
                        return;
                    case 6:
                        try {
                            n.a(c).a(this.a, (c) null);
                            Long valueOf = Long.valueOf(com.tencent.stat.common.p.a(c, "last_period_ts", 0L));
                            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                            if (Long.valueOf(Long.valueOf(valueOf2.longValue() - valueOf.longValue()).longValue() / 60000).longValue() > StatConfig.getSendPeriodMinutes()) {
                                n.a(c).a(-1);
                                com.tencent.stat.common.p.b(c, "last_period_ts", valueOf2.longValue());
                                return;
                            }
                            return;
                        } catch (Exception e2) {
                            statLogger3 = StatService.f8246i;
                            statLogger3.e(e2);
                            return;
                        }
                    case 7:
                        if (com.tencent.stat.common.k.e(c)) {
                            c(false);
                            return;
                        }
                        return;
                    default:
                        statLogger4 = StatService.f8246i;
                        statLogger4.error("Invalid stat strategy:" + StatConfig.getStatSendStrategy());
                        return;
                }
            }
        } catch (Throwable th) {
            statLogger = StatService.f8246i;
            statLogger.e(th);
        }
    }
}
