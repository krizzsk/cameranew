package us.pinguo.u3dengine;

import android.content.Context;
import java.util.Locale;
import kotlin.jvm.internal.s;
import us.pinguo.u3dengine.api.EngineMode;
/* compiled from: UnityControlCaller.kt */
/* loaded from: classes6.dex */
public final class UnityControlCaller {
    private static final String BRIDGE_MESSAGE_RECEIVER = "BridgeController";
    private static Context appContext;
    public static final UnityControlCaller INSTANCE = new UnityControlCaller();
    private static EngineMode currentEngineMode = EngineMode.OFF;

    private UnityControlCaller() {
    }

    public static final Context getAppContext() {
        Context context = appContext;
        if (context != null) {
            return context;
        }
        s.z("appContext");
        throw null;
    }

    public static final void initializeUnityBugly(boolean z) {
        String str = z ? "1" : "0";
        PgUnityPlayer.a(BRIDGE_MESSAGE_RECEIVER, "InitializeBugly", str);
        us.pinguo.common.log.a.c(s.q("InitializeBugly:", str), new Object[0]);
    }

    public static final void setContext(Context context) {
        s.h(context, "context");
        appContext = context;
    }

    public static final void setCurrentLanguage(Locale locale) {
        s.h(locale, "locale");
        String language = locale.getLanguage();
        s.g(language, "locale.language");
        String lowerCase = language.toLowerCase(locale);
        s.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String str = "zh";
        if (s.c(lowerCase, "zh")) {
            String country = locale.getCountry();
            s.g(country, "locale.country");
            String lowerCase2 = country.toLowerCase(locale);
            s.g(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (!s.c(lowerCase2, "cn")) {
                str = "zh-tw";
            }
        } else {
            String language2 = locale.getLanguage();
            s.g(language2, "locale.language");
            str = language2.toLowerCase(locale);
            s.g(str, "this as java.lang.String).toLowerCase(locale)");
        }
        PgUnityPlayer.a(BRIDGE_MESSAGE_RECEIVER, "SetCurrentLanguage", str);
    }

    public static /* synthetic */ void setCurrentLanguage$default(Locale locale, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            locale = Locale.getDefault();
            s.g(locale, "getDefault()");
        }
        setCurrentLanguage(locale);
    }

    public static final void setEngineMode(EngineMode mode, Module from) {
        s.h(mode, "mode");
        s.h(from, "from");
        us.pinguo.common.log.a.c("SetUnityRenderMode from:" + from + ":, mode:" + mode.name(), new Object[0]);
        if (mode == EngineMode.OFF) {
            if (currentEngineMode == EngineMode.CAMERA && from != Module.CAMERA) {
                return;
            }
            if (currentEngineMode == EngineMode.EDIT && from != Module.EDIT) {
                return;
            }
            if (currentEngineMode == EngineMode.SKY && from != Module.SKY) {
                return;
            }
        }
        currentEngineMode = mode;
        PgUnityPlayer.a(BRIDGE_MESSAGE_RECEIVER, "SetUnityRenderMode", String.valueOf(mode.ordinal()));
        us.pinguo.common.log.a.c(s.q("SetUnityRenderMode real:", mode.name()), new Object[0]);
    }
}
