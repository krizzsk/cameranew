package com.unity3d.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public class HFPStatus {
    private Context a;

    /* renamed from: e  reason: collision with root package name */
    private AudioManager f8343e;
    private BroadcastReceiver b = null;
    private Intent c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8342d = false;

    /* renamed from: f  reason: collision with root package name */
    private int f8344f = a.a;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    static final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        /* renamed from: d  reason: collision with root package name */
        private static final /* synthetic */ int[] f8345d = {1, 2, 3};
    }

    public HFPStatus(Context context) {
        this.f8343e = null;
        this.a = context;
        this.f8343e = (AudioManager) context.getSystemService("audio");
        initHFPStatusJni();
    }

    private final native void deinitHFPStatusJni();

    private final native void initHFPStatusJni();

    public final void a() {
        deinitHFPStatusJni();
    }

    protected boolean getHFPStat() {
        return this.f8344f == a.b;
    }

    protected void requestHFPStat() {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.unity3d.player.HFPStatus.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                VdsAgent.onBroadcastReceiver(this, context, intent);
                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                if (intExtra == 0) {
                    if (HFPStatus.this.f8342d) {
                        HFPStatus.this.f8343e.setMode(0);
                    }
                    HFPStatus.this.f8342d = false;
                } else if (intExtra == 1) {
                    HFPStatus.this.f8344f = a.b;
                    if (HFPStatus.this.f8342d) {
                        HFPStatus.this.f8343e.setMode(3);
                    } else {
                        HFPStatus.this.f8343e.stopBluetoothSco();
                    }
                } else if (intExtra != 2) {
                } else {
                    if (HFPStatus.this.f8344f == a.b) {
                        HFPStatus.this.f8342d = true;
                        return;
                    }
                    HFPStatus.this.f8344f = a.c;
                }
            }
        };
        this.b = broadcastReceiver;
        this.c = this.a.registerReceiver(broadcastReceiver, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        try {
            this.f8343e.startBluetoothSco();
        } catch (NullPointerException unused) {
            g.Log(5, "startBluetoothSco() failed. no bluetooth device connected.");
        }
    }
}
