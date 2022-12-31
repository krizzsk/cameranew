package cn.sharesdk.wechat.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.wechat.utils.i;
import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.security.MessageDigest;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: WechatCore.java */
/* loaded from: classes.dex */
public class j {
    private String a;

    private boolean d() {
        SSDKLog.b().d("checking signature of wechat client...", new Object[0]);
        try {
            PackageInfo packageInfo = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.mm", 64);
            int length = packageInfo.signatures.length;
            for (int i2 = 0; i2 < length; i2++) {
                if ("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499".equals(packageInfo.signatures[i2].toCharsString())) {
                    SSDKLog.b().d("pass!", new Object[0]);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return false;
        }
    }

    public boolean a(String str) {
        this.a = str;
        if (!d()) {
            SSDKLog.b().d("register app failed for wechat app signature check failed", new Object[0]);
            return false;
        }
        String str2 = "weixin://registerapp?appid=" + str;
        String packageName = MobSDK.getContext().getPackageName();
        Intent intent = new Intent(ConstantsAPI.ACTION_HANDLE_APP_REGISTER);
        intent.putExtra(ConstantsAPI.SDK_VERSION, 621086720);
        intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
        intent.putExtra(ConstantsAPI.CONTENT, str2);
        intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, 0L);
        intent.putExtra(ConstantsAPI.CHECK_SUM, a(str2, packageName, 621086720));
        MobSDK.getContext().sendBroadcast(intent, ConstantsAPI.WXApp.WXAPP_BROADCAST_PERMISSION);
        SSDKLog.b().d("sending broadcast, intent=" + ConstantsAPI.ACTION_HANDLE_APP_REGISTER + ", perm=" + ConstantsAPI.WXApp.WXAPP_BROADCAST_PERMISSION, new Object[0]);
        return true;
    }

    public void b(m mVar) throws Throwable {
        i.a aVar = (i.a) mVar;
        ContentResolver contentResolver = MobSDK.getContext().getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.a, aVar.a, aVar.b, "" + aVar.c}, null);
        if (query != null) {
            query.close();
        }
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity");
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        intent.addFlags(134217728);
        MobSDK.getContext().startActivity(intent);
    }

    public boolean c() {
        int i2;
        try {
            i2 = ResHelper.parseInt(b("_build_info_sdk_int_"));
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            i2 = -1;
        }
        return i2 >= 553779201;
    }

    public boolean b() {
        return d();
    }

    private String b(String str) {
        try {
            Cursor query = MobSDK.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref"), new String[]{"_id", "key", "type", FirebaseAnalytics.Param.VALUE}, "key = ?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            String string = query.moveToFirst() ? query.getString(query.getColumnIndex(FirebaseAnalytics.Param.VALUE)) : null;
            query.close();
            return string;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    public void a(m mVar, boolean z) throws Throwable {
        if (b()) {
            if (mVar.a(z)) {
                String packageName = MobSDK.getContext().getPackageName();
                String str = "weixin://sendreq?appid=" + this.a;
                Intent intent = new Intent();
                intent.setClassName("com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity");
                Bundle bundle = new Bundle();
                mVar.a(bundle);
                intent.putExtras(bundle);
                intent.putExtra(ConstantsAPI.SDK_VERSION, 621086720);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, str);
                intent.putExtra(ConstantsAPI.CHECK_SUM, a(str, packageName, 621086720));
                if (mVar.a() == 2) {
                    try {
                        String a = a(MobSDK.getContext());
                        if (!TextUtils.isEmpty(a)) {
                            intent.putExtra(ConstantsAPI.TOKEN, a);
                            SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, " _message_token " + a);
                        }
                    } catch (Exception e2) {
                        SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, " WechatCore that put token catch " + e2);
                    }
                }
                intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                intent.addFlags(134217728);
                intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
                MobSDK.getContext().startActivity(intent);
                SSDKLog.b().d("starting activity, packageName=com.tencent.mm, className=com.tencent.mm.plugin.base.stub.WXEntryActivity", new Object[0]);
                return;
            }
            throw new Throwable("sendReq checkArgs fail");
        }
        throw new WechatClientNotExistException();
    }

    private String a(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[]{this.a, "621086720"}, null);
            if (query == null || !query.moveToFirst()) {
                return null;
            }
            String string = query.getString(0);
            NLog b = SSDKLog.b();
            b.d(OnekeyShare.SHARESDK_TAG, "MicroMsg.SDK.WXApiImplV10(WechatCore) getTokenFromWX token is " + string);
            query.close();
            return string;
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.e(OnekeyShare.SHARESDK_TAG, "WechatCore catch " + th);
            return null;
        }
    }

    public void a(m mVar) throws Throwable {
        g gVar = (g) mVar;
        Cursor query = MobSDK.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.a, "1", String.valueOf(gVar.a), gVar.b, gVar.c}, null);
        if (query != null) {
            query.close();
        }
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity");
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        intent.addFlags(134217728);
        MobSDK.getContext().startActivity(intent);
    }

    public boolean a() {
        String str;
        try {
            str = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.mm", 0).versionName;
            NLog b = SSDKLog.b();
            b.i("wechat versionName ==>> " + str, new Object[0]);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            str = "0";
        }
        String[] split = str.split("_")[0].split("\\.");
        int length = split.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                iArr[i2] = ResHelper.parseInt(split[i2]);
            } catch (Throwable th2) {
                SSDKLog.b().d(th2);
                iArr[i2] = 0;
            }
        }
        return length >= 4 && iArr[0] == 6 && iArr[1] == 0 && iArr[2] == 2 && iArr[3] <= 56;
    }

    private byte[] a(String str, String str2, int i2) {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i2);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i3 = 0;
            for (byte b : digest) {
                cArr2[i3] = cArr[(b >>> 4) & 15];
                int i4 = i3 + 1;
                cArr2[i4] = cArr[b & 15];
                i3 = i4 + 1;
            }
            str3 = new String(cArr2);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            str3 = null;
        }
        if (str3 != null) {
            return str3.getBytes();
        }
        return null;
    }

    public boolean a(WechatHandlerActivity wechatHandlerActivity, k kVar) {
        Intent intent = wechatHandlerActivity.getIntent();
        if (intent == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(ConstantsAPI.Token.WX_TOKEN_KEY);
        if (stringExtra != null && stringExtra.equals(ConstantsAPI.Token.WX_TOKEN_VALUE_MSG)) {
            String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
            if (TextUtils.isEmpty(stringExtra2)) {
                SSDKLog.b().d("invalid argument, \"_mmessage_appPackage\" is empty", new Object[0]);
                return false;
            }
            if (!a(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), a(intent.getStringExtra(ConstantsAPI.CONTENT), stringExtra2, intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0)))) {
                SSDKLog.b().d("checksum fail", new Object[0]);
                return false;
            }
            Bundle extras = intent.getExtras();
            int i2 = extras.getInt("_wxapi_command_type", 0);
            if (i2 == 1) {
                kVar.a(new a(extras));
            } else if (i2 == 2) {
                kVar.a(new e(extras));
            } else if (i2 == 3) {
                wechatHandlerActivity.onGetMessageFromWXReq(new b(extras).a);
            } else if (i2 == 4) {
                wechatHandlerActivity.onShowMessageFromWXReq(new f(extras).a);
            } else if (i2 != 19) {
                return false;
            } else {
                wechatHandlerActivity.onGetMessageFromWXReq(new b(extras).a);
            }
            return true;
        }
        SSDKLog.b().d("invalid argument, \"wx_token_key\" is empty or does not equals \"com.tencent.mm.openapi.token\"", new Object[0]);
        return false;
    }

    private boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0) {
            if (bArr2 != null && bArr2.length != 0) {
                if (bArr.length != bArr2.length) {
                    SSDKLog.b().d("checkSumConsistent fail, length is different", new Object[0]);
                    return false;
                }
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    if (bArr[i2] != bArr2[i2]) {
                        SSDKLog.b().d("checkSumConsistent fail, not match", new Object[0]);
                        return false;
                    }
                }
                return true;
            }
            SSDKLog.b().d("checkSumConsistent fail, invalid arguments, checksum is empty", new Object[0]);
            return false;
        }
        SSDKLog.b().d("checkSumConsistent fail, invalid arguments, \"_mmessage_checksum\" is empty", new Object[0]);
        return false;
    }
}
