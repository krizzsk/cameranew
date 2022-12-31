package com.ironsource.sdk.handlers;

import android.app.Activity;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.ISNEnums$BackButtonState;
import com.ironsource.sdk.utils.b;
/* loaded from: classes2.dex */
public class BackButtonHandler {
    public static BackButtonHandler a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ISNEnums$BackButtonState.values().length];
            a = iArr;
            try {
                iArr[ISNEnums$BackButtonState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ISNEnums$BackButtonState.Device.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ISNEnums$BackButtonState.Controller.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static BackButtonHandler getInstance() {
        BackButtonHandler backButtonHandler = a;
        return backButtonHandler == null ? new BackButtonHandler() : backButtonHandler;
    }

    public boolean a(Activity activity) {
        if (a.a[b.e().b().ordinal()] != 3) {
            return false;
        }
        try {
            WebController webController = (WebController) d.e.d.k.b.b0(activity).Y().M();
            if (webController != null) {
                webController.O1("back");
                return true;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
