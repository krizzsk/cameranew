package com.google.android.material.timepicker;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.connect.common.Constants;
/* compiled from: TimePickerClockPresenter.java */
/* loaded from: classes2.dex */
class c implements ClockHandView.d, TimePickerView.g, TimePickerView.f, ClockHandView.c, d {

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f4673f = {Constants.VIA_REPORT_TYPE_SET_AVATAR, "1", "2", "3", Constants.VIA_TO_TYPE_QZONE, "5", Constants.VIA_SHARE_TYPE_INFO, "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f4674g = {"00", "2", Constants.VIA_TO_TYPE_QZONE, Constants.VIA_SHARE_TYPE_INFO, Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_START_WAP, "18", "20", Constants.VIA_REPORT_TYPE_DATALINE};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f4675h = {"00", "5", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_WPA_STATE, "20", Constants.VIA_REPORT_TYPE_CHAT_AUDIO, "30", "35", "40", "45", "50", "55"};
    private TimePickerView a;
    private TimeModel b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f4676d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4677e = false;

    public c(TimePickerView timePickerView, TimeModel timeModel) {
        this.a = timePickerView;
        this.b = timeModel;
        i();
    }

    private int g() {
        return this.b.a == 1 ? 15 : 30;
    }

    private String[] h() {
        return this.b.a == 1 ? f4674g : f4673f;
    }

    private void j(int i2, int i3) {
        TimeModel timeModel = this.b;
        if (timeModel.c == i3 && timeModel.b == i2) {
            return;
        }
        this.a.performHapticFeedback(Build.VERSION.SDK_INT >= 21 ? 4 : 1);
    }

    private void l() {
        TimePickerView timePickerView = this.a;
        TimeModel timeModel = this.b;
        timePickerView.x(timeModel.f4666e, timeModel.c(), this.b.c);
    }

    private void m() {
        n(f4673f, TimeModel.NUMBER_FORMAT);
        n(f4674g, TimeModel.NUMBER_FORMAT);
        n(f4675h, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    private void n(String[] strArr, String str) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = TimeModel.b(this.a.getResources(), strArr[i2], str);
        }
    }

    @Override // com.google.android.material.timepicker.d
    public void a() {
        TimePickerView timePickerView = this.a;
        timePickerView.setVisibility(8);
        VdsAgent.onSetViewVisibility(timePickerView, 8);
    }

    @Override // com.google.android.material.timepicker.d
    public void b() {
        this.f4676d = this.b.c() * g();
        TimeModel timeModel = this.b;
        this.c = timeModel.c * 6;
        k(timeModel.f4665d, false);
        l();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void c(float f2, boolean z) {
        this.f4677e = true;
        TimeModel timeModel = this.b;
        int i2 = timeModel.c;
        int i3 = timeModel.b;
        if (timeModel.f4665d == 10) {
            this.a.m(this.f4676d, false);
            if (!((AccessibilityManager) ContextCompat.getSystemService(this.a.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                k(12, true);
            }
        } else {
            int round = Math.round(f2);
            if (!z) {
                this.b.k(((round + 15) / 30) * 5);
                this.c = this.b.c * 6;
            }
            this.a.m(this.c, z);
        }
        this.f4677e = false;
        l();
        j(i3, i2);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void d(int i2) {
        this.b.l(i2);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void e(int i2) {
        k(i2, true);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void f(float f2, boolean z) {
        if (this.f4677e) {
            return;
        }
        TimeModel timeModel = this.b;
        int i2 = timeModel.b;
        int i3 = timeModel.c;
        int round = Math.round(f2);
        TimeModel timeModel2 = this.b;
        if (timeModel2.f4665d == 12) {
            timeModel2.k((round + 3) / 6);
            this.c = (float) Math.floor(this.b.c * 6);
        } else {
            this.b.j((round + (g() / 2)) / g());
            this.f4676d = this.b.c() * g();
        }
        if (z) {
            return;
        }
        l();
        j(i2, i3);
    }

    public void i() {
        if (this.b.a == 0) {
            this.a.w();
        }
        this.a.j(this);
        this.a.s(this);
        this.a.r(this);
        this.a.p(this);
        m();
        b();
    }

    void k(int i2, boolean z) {
        boolean z2 = i2 == 12;
        this.a.l(z2);
        this.b.f4665d = i2;
        this.a.u(z2 ? f4675h : h(), z2 ? R.string.material_minute_suffix : R.string.material_hour_suffix);
        this.a.m(z2 ? this.c : this.f4676d, z);
        this.a.k(i2);
        this.a.o(new a(this.a.getContext(), R.string.material_hour_selection));
        this.a.n(new a(this.a.getContext(), R.string.material_minute_selection));
    }

    @Override // com.google.android.material.timepicker.d
    public void show() {
        TimePickerView timePickerView = this.a;
        timePickerView.setVisibility(0);
        VdsAgent.onSetViewVisibility(timePickerView, 0);
    }
}
