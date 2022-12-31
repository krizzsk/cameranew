package cn.sharesdk.framework.loopshare;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.loopshare.ActionListener;
import cn.sharesdk.loopshare.MobLink;
import cn.sharesdk.loopshare.RestoreSceneListener;
import cn.sharesdk.loopshare.Scene;
import cn.sharesdk.loopshare.beans.SceneData;
import cn.sharesdk.loopshare.utils.b;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* loaded from: classes.dex */
public class MobLinkAPI {
    private static MoblinkActionListener a;
    private static LoopShareResultListener b;
    private static LoopSharePasswordListener c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile MobLinkAPI f129d;

    /* loaded from: classes.dex */
    private static class SceneListener implements RestoreSceneListener {
        private SceneListener() {
        }

        public void completeRestore(Scene scene) {
        }

        public void notFoundScene(Scene scene) {
        }

        public Class<? extends Activity> willRestoreScene(Scene scene) {
            SSDKLog.b().d("LoopShare MobLinkAPI willRestoreScene ==> RestoreTempActivity", new Object[0]);
            return RestoreTempActivity.class;
        }
    }

    public static LoopShareResultListener b() {
        return b;
    }

    public static LoopSharePasswordListener c() {
        return c;
    }

    public static HashMap<String, Object> d() {
        try {
            String trim = new a(MobSDK.getContext(), "sharesdk_moblink_sp").b("share_restore_extra", null).toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                return new Hashon().fromJson(trim);
            }
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.e("LoopShare MobLinkAPI getCustomDataFromLoopShare " + th, new Object[0]);
        }
        return new HashMap<>();
    }

    private static String f() {
        ClipboardManager clipboardManager;
        try {
            if (Build.VERSION.SDK_INT >= 11 && (clipboardManager = (ClipboardManager) MobSDK.getContext().getSystemService("clipboard")) != null && clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClip().getItemCount() > 0) {
                CharSequence text = clipboardManager.getPrimaryClip().getItemAt(0).getText();
                if (TextUtils.isEmpty(text)) {
                    return null;
                }
                return String.valueOf(text);
            }
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.e("LoopShare MobLinkAPI getClipContent catch: " + th, new Object[0]);
        }
        return null;
    }

    private static void g() {
        ClipboardManager clipboardManager;
        try {
            if (Build.VERSION.SDK_INT >= 11 && (clipboardManager = (ClipboardManager) MobSDK.getContext().getSystemService("clipboard")) != null) {
                clipboardManager.setPrimaryClip(clipboardManager.getPrimaryClip());
                clipboardManager.setText(null);
            }
            SSDKLog.b().d("LoopShare MobLinkAPI clearClipboard is ok", new Object[0]);
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.e("LoopShare MobLinkAPI clearClipboard catch: " + th, new Object[0]);
        }
    }

    public static MobLinkAPI a() {
        synchronized (MobLinkAPI.class) {
            if (f129d == null) {
                synchronized (MobLinkAPI.class) {
                    if (f129d == null) {
                        f129d = new MobLinkAPI();
                    }
                }
            }
        }
        return f129d;
    }

    public static void b(LoopShareResultListener loopShareResultListener) {
        if (loopShareResultListener != null) {
            try {
                a(loopShareResultListener);
            } catch (Throwable th) {
                NLog b2 = SSDKLog.b();
                b2.e("LoopShare MobLinkAPI prepareLoopShare " + th, new Object[0]);
                return;
            }
        }
        MobLink.registerSpecifiedSchemeListener("sdfwe435fdsr34656uthfwer32ufeh439==", new SceneListener());
        SSDKLog.b().d("LoopShare MobLinkAPI prepareLoopShare is OK", new Object[0]);
    }

    public static void a(LoopShareResultListener loopShareResultListener) {
        b = loopShareResultListener;
    }

    public static void a(LoopSharePasswordListener loopSharePasswordListener) {
        c = loopSharePasswordListener;
    }

    public static void a(HashMap<String, Object> hashMap, MoblinkActionListener moblinkActionListener) {
        if (moblinkActionListener != null) {
            try {
                a = moblinkActionListener;
                Scene scene = new Scene();
                scene.setPath(String.valueOf(hashMap.get(PGEditResultActivity2.PATH)));
                if (hashMap.get("params") instanceof HashMap) {
                    scene.setParams((HashMap) hashMap.get("params"));
                } else if (a != null) {
                    a.onError(new Throwable("setLoopshareCustomParams方法中 params 为key的时候，value需要为HashMap类型"));
                    return;
                }
                MobLink.getMobID(scene, new ActionListener<String>() { // from class: cn.sharesdk.framework.loopshare.MobLinkAPI.1
                    public void onError(Throwable th) {
                        if (MobLinkAPI.a != null) {
                            MobLinkAPI.a.onError(th);
                            MoblinkActionListener unused = MobLinkAPI.a = null;
                        }
                    }

                    public void onResult(String str) {
                        if (MobLinkAPI.a != null) {
                            MobLinkAPI.a.onResult(str);
                            MoblinkActionListener unused = MobLinkAPI.a = null;
                        }
                    }
                });
            } catch (Throwable th) {
                NLog b2 = SSDKLog.b();
                b2.e("LoopShare MobLinkAPI mobLinkGetMobID" + th, new Object[0]);
            }
        }
    }

    private static String a(String str) {
        Matcher matcher = Pattern.compile("#(.*?)#").matcher(str);
        return matcher.find() ? matcher.group(1) : "";
    }

    public static void a(boolean z, LoopSharePasswordListener loopSharePasswordListener) {
        if (loopSharePasswordListener != null) {
            a(loopSharePasswordListener);
            String f2 = f();
            NLog b2 = SSDKLog.b();
            b2.d("LoopShare MobLinkAPI readPassWord clipContent: " + f2, new Object[0]);
            try {
                if (!TextUtils.isEmpty(f2)) {
                    String a2 = a(f2);
                    if (TextUtils.isEmpty(a2)) {
                        SSDKLog.b().d("LoopShare MobLinkAPI readPassWord Regular match string is null ", new Object[0]);
                        if (c() != null) {
                            c().onError(new Throwable("readPassWord Regular match string is error"));
                            return;
                        }
                        return;
                    }
                    NLog b3 = SSDKLog.b();
                    b3.d("LoopShare MobLinkAPI readPassWord read mobId is: " + a2, new Object[0]);
                    if (z) {
                        g();
                    }
                    b.a(a2, new ActionListener<SceneData>() { // from class: cn.sharesdk.framework.loopshare.MobLinkAPI.2
                        public void onError(Throwable th) {
                            MobLinkAPI.c().onError(th);
                            NLog b4 = SSDKLog.b();
                            b4.d("LoopShare MobLinkAPI readPassWord onError: " + th, new Object[0]);
                        }

                        public void onResult(SceneData sceneData) {
                            MobLinkAPI.c().onResult(sceneData.a().params);
                            SSDKLog.b().d("LoopShare MobLinkAPI readPassWord onResult is ok", new Object[0]);
                        }
                    });
                    return;
                } else if (c() != null) {
                    c().onError(new Throwable("The clipboard is empty"));
                    return;
                } else {
                    return;
                }
            } catch (Throwable th) {
                if (c() != null) {
                    c().onError(new Throwable("readPassWord catch: " + th));
                    return;
                }
                return;
            }
        }
        SSDKLog.b().d("LoopShare MobLinkAPI readPassWord listener is null", new Object[0]);
    }

    public static void a(HashMap<String, Object> hashMap, final String str, LoopSharePasswordListener loopSharePasswordListener) {
        try {
            if (loopSharePasswordListener != null) {
                a(loopSharePasswordListener);
                ShareSDK.mobLinkGetMobID(hashMap, new MoblinkActionListener() { // from class: cn.sharesdk.framework.loopshare.MobLinkAPI.3
                    @Override // cn.sharesdk.framework.loopshare.MoblinkActionListener
                    public void onError(Throwable th) {
                        MobLinkAPI.c().onError(th);
                    }

                    @Override // cn.sharesdk.framework.loopshare.MoblinkActionListener
                    public void onResult(Object obj) {
                        String str2;
                        if (obj != null) {
                            if (!TextUtils.isEmpty(str)) {
                                str2 = str + "#" + obj + "#";
                            } else {
                                str2 = "#" + obj + "#";
                            }
                            MobLinkAPI.c().onResult(str2);
                            SSDKLog.b().d("LoopShare MobLinkAPI preparePassWord callback is ok", new Object[0]);
                            try {
                                if (Build.VERSION.SDK_INT >= 11) {
                                    Context context = MobSDK.getContext();
                                    MobSDK.getContext();
                                    ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("CLI_LAB_A", str2));
                                    SSDKLog.b().d("LoopShare MobLinkAPI preparePassWord ClipData is ok", new Object[0]);
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                SSDKLog.b().d("LoopShare MobLinkAPI preparePassWord ClipData catch: " + th, new Object[0]);
                                return;
                            }
                        }
                        MobLinkAPI.c().onError(new Throwable("mobId is null"));
                    }
                });
                SSDKLog.b().d("LoopShare MobLinkAPI preparePassWord is OK", new Object[0]);
            } else {
                SSDKLog.b().d("LoopShare MobLinkAPI preparePassWord listener is null", new Object[0]);
            }
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.e("LoopShare MobLinkAPI preparePassWord " + th, new Object[0]);
        }
    }
}
