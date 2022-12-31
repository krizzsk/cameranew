package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.open.SocialConstants;
import java.util.Map;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.common.network.HttpRequest;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaqf extends zzaqq {
    private final Context context;
    private final Map<String, String> zzdbf;
    private String zzdpd;
    private long zzdpe;
    private long zzdpf;
    private String zzdpg;
    private String zzdph;

    public zzaqf(zzbeb zzbebVar, Map<String, String> map) {
        super(zzbebVar, "createCalendarEvent");
        this.zzdbf = map;
        this.context = zzbebVar.zzabe();
        this.zzdpd = zzdq(SocialConstants.PARAM_COMMENT);
        this.zzdpg = zzdq("summary");
        this.zzdpe = zzdr("start_ticks");
        this.zzdpf = zzdr("end_ticks");
        this.zzdph = zzdq(FirebaseAnalytics.Param.LOCATION);
    }

    private final String zzdq(String str) {
        return TextUtils.isEmpty(this.zzdbf.get(str)) ? "" : this.zzdbf.get(str);
    }

    private final long zzdr(String str) {
        String str2 = this.zzdbf.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(14)
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzdpd);
        data.putExtra("eventLocation", this.zzdph);
        data.putExtra(SocialConstants.PARAM_COMMENT, this.zzdpg);
        long j2 = this.zzdpe;
        if (j2 > -1) {
            data.putExtra("beginTime", j2);
        }
        long j3 = this.zzdpf;
        if (j3 > -1) {
            data.putExtra("endTime", j3);
        }
        data.setFlags(PGImageSDK.SDK_STATUS_CREATE);
        return data;
    }

    public final void execute() {
        if (this.context == null) {
            zzds("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzkr();
        if (!com.google.android.gms.ads.internal.util.zzj.zzao(this.context).zzsa()) {
            zzds("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzkr();
        AlertDialog.Builder zzan = com.google.android.gms.ads.internal.util.zzj.zzan(this.context);
        Resources resources = com.google.android.gms.ads.internal.zzr.zzkv().getResources();
        zzan.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        zzan.setMessage(resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzan.setPositiveButton(resources != null ? resources.getString(R.string.s3) : HttpRequest.HEADER_ACCEPT, new zzaqe(this));
        zzan.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzaqh(this));
        AlertDialog create = zzan.create();
        create.show();
        VdsAgent.showDialog(create);
    }
}
