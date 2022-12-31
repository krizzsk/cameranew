package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class m extends j5 {
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private String f3869d;

    /* renamed from: e  reason: collision with root package name */
    private AccountManager f3870e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f3871f;

    /* renamed from: g  reason: collision with root package name */
    private long f3872g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(o4 o4Var) {
        super(o4Var);
    }

    @Override // com.google.android.gms.measurement.internal.j5
    protected final boolean g() {
        Calendar calendar = Calendar.getInstance();
        this.c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append(PGTransHeader.CONNECTOR);
        sb.append(lowerCase2);
        this.f3869d = sb.toString();
        return false;
    }

    public final long m() {
        j();
        return this.c;
    }

    public final String n() {
        j();
        return this.f3869d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final long o() {
        f();
        return this.f3872g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void p() {
        f();
        this.f3871f = null;
        this.f3872g = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean q() {
        Account[] result;
        f();
        long currentTimeMillis = this.a.zzax().currentTimeMillis();
        if (currentTimeMillis - this.f3872g > AdvTimeUtils.MILLIS_OF_A_DAY) {
            this.f3871f = null;
        }
        Boolean bool = this.f3871f;
        if (bool == null) {
            if (ContextCompat.checkSelfPermission(this.a.zzaw(), "android.permission.GET_ACCOUNTS") != 0) {
                this.a.a().q().a("Permission error checking for dasher/unicorn accounts");
                this.f3872g = currentTimeMillis;
                this.f3871f = Boolean.FALSE;
                return false;
            }
            if (this.f3870e == null) {
                this.f3870e = AccountManager.get(this.a.zzaw());
            }
            try {
                result = this.f3870e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
            } catch (AuthenticatorException | OperationCanceledException | IOException e2) {
                this.a.a().n().b("Exception checking account types", e2);
            }
            if (result != null && result.length > 0) {
                this.f3871f = Boolean.TRUE;
                this.f3872g = currentTimeMillis;
                return true;
            }
            Account[] result2 = this.f3870e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
            if (result2 != null && result2.length > 0) {
                this.f3871f = Boolean.TRUE;
                this.f3872g = currentTimeMillis;
                return true;
            }
            this.f3872g = currentTimeMillis;
            this.f3871f = Boolean.FALSE;
            return false;
        }
        return bool.booleanValue();
    }
}
