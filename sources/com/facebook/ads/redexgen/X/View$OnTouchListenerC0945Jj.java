package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Jj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnTouchListenerC0945Jj implements View.OnTouchListener {
    public static String[] A01 = {"Jj6DPCpvRav0Dl4Hzko1ZYQ46cJHU9e3", "aRIYRX895b825x5MQHViVQuTPsX5EcgU", "WsB7SnaDyHBw", "ElhXrOblYWeIXKV5fK", "0U38eQ8bNMWMKT3qwHCBhGirZFomfBRA", "KG5ePHom1Hb0a65hRE12sPtgaad7Jk0V", "yn6apVjnupr8JkU7fdbub5PEYmvdUytV", "Qv1reMq3fGwFA"};
    public final /* synthetic */ C1209Tu A00;

    public View$OnTouchListenerC0945Jj(C1209Tu c1209Tu) {
        this.A00 = c1209Tu;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AA aa;
        AA aa2;
        aa = this.A00.A04;
        if (aa != null) {
            int action = motionEvent.getAction();
            if (A01[6].charAt(0) == 'l') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "gh2YpB8N5DvGnIVUwjzoCnzlhXQ6xZpi";
            strArr[4] = "c0aZKZ8jQy4nragOlR5MHbPn3w24MGfh";
            if (action == 1) {
                aa2 = this.A00.A04;
                aa2.A0m();
            }
        }
        return true;
    }
}
