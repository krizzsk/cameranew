package cn.sharesdk.twitter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.e;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: TwitterSSOProcessor.java */
/* loaded from: classes.dex */
public class d extends e {

    /* renamed from: d  reason: collision with root package name */
    private String f297d;

    /* renamed from: e  reason: collision with root package name */
    private String f298e;

    /* renamed from: f  reason: collision with root package name */
    private cn.sharesdk.framework.authorize.d f299f;

    public d(cn.sharesdk.framework.authorize.d dVar) {
        super(dVar);
        this.f299f = dVar;
    }

    private void c(Intent intent) {
        SSOListener sSOListener = this.c;
        if (sSOListener == null) {
            return;
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra("error");
            int intExtra = intent.getIntExtra("error_code", -1);
            Throwable th = new Throwable(stringExtra + " (" + intExtra + ")");
            SSOListener sSOListener2 = this.c;
            if (sSOListener2 != null) {
                sSOListener2.onFailed(th);
                return;
            }
            return;
        }
        try {
            sSOListener.onCancel();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str) {
        this.f297d = str;
    }

    public void b(String str) {
        this.f298e = str;
    }

    private void b() {
        try {
            Intent component = new Intent().setComponent(new ComponentName(a(this.f299f.getContext().getPackageManager()), "com.twitter.android.SingleSignOnActivity"));
            a.a(this.f299f.getContext(), component);
            component.putExtra("ck", this.f297d).putExtra("cs", this.f298e);
            this.f299f.startActivityForResult(component, InspirePublishFragment.MAX_DESC_COUNT);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.sharesdk.framework.authorize.e
    public void a() {
        try {
            if (a(this.f299f.getContext())) {
                b();
                return;
            }
            this.f299f.finish();
            SSOListener sSOListener = this.c;
            if (sSOListener != null) {
                sSOListener.onFailed(new Throwable(" You may not have installed Twitter client "));
            }
        } catch (Throwable th) {
            this.f299f.finish();
            SSOListener sSOListener2 = this.c;
            if (sSOListener2 != null) {
                sSOListener2.onFailed(th);
            }
        }
    }

    private void b(Intent intent) {
        if (this.c == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            this.c.onComplete(intent.getExtras());
        } else if (stringExtra.equals("access_denied")) {
            SSOListener sSOListener = this.c;
            if (sSOListener != null) {
                sSOListener.onCancel();
            }
        } else {
            String stringExtra2 = intent.getStringExtra("error_description");
            if (stringExtra2 != null) {
                stringExtra = stringExtra + ": " + stringExtra2;
            }
            SSOListener sSOListener2 = this.c;
            if (sSOListener2 != null) {
                sSOListener2.onFailed(new Throwable(stringExtra));
            }
        }
    }

    @Override // cn.sharesdk.framework.authorize.e
    public void a(int i2, int i3, Intent intent) {
        try {
            this.f299f.finish();
            if (i2 == 140) {
                if (i3 == -1) {
                    cn.sharesdk.framework.authorize.d dVar = this.f299f;
                    if (dVar != null) {
                        dVar.finish();
                    }
                    b(intent);
                } else if (i3 != 0) {
                } else {
                    cn.sharesdk.framework.authorize.d dVar2 = this.f299f;
                    if (dVar2 != null) {
                        dVar2.finish();
                    }
                    c(intent);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return a(packageManager, "com.twitter.android", "3082025d308201c6a00302010202044bd76cce300d06092a864886f70d01010505003073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e6420526563686973301e170d3130303432373233303133345a170d3438303832353233303133345a3073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e642052656368697330819f300d06092a864886f70d010101050003818d003081890281810086233c2e51c62232d49cc932e470713d63a6a1106b38f9e442e01bc79ca4f95c72b2cb3f1369ef7dea6036bff7c4b2828cb3787e7657ad83986751ced5b131fcc6f413efb7334e32ed9787f9e9a249ae108fa66009ac7a7932c25d37e1e07d4f9f66aa494c270dbac87d261c9668d321c2fba4ef2800e46671a597ff2eac5d7f0203010001300d06092a864886f70d0101050500038181003e1f01cb6ea8be8d2cecef5cd2a64c97ba8728aa5f08f8275d00508d64d139b6a72c5716b40a040df0eeeda04de9361107e123ee8d3dc05e70c8a355f46dbadf1235443b0b214c57211afd4edd147451c443d49498d2a7ff27e45a99c39b9e47429a1dae843ba233bf8ca81296dbe1dc5c5434514d995b0279246809392a219b") || a(packageManager, "com.twitter.android.beta", "308203523082023aa00302010202044fd0006b300d06092a864886f70d0101050500306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c65301e170d3132303630373031313431395a170d3339313032343031313431395a306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c6530820122300d06092a864886f70d01010105000382010f003082010a028201010089e6cbdfed4288a9c0a215d33d4fa978a5bdd20be426ef4b497d358a9fd1c6efec9684f059f6955e60e5fda1b5910bb2d097e7421a78f9c81e95cd8ef3bf50add7f8d9f073c0478736a6c7fd38c5871559783a76420d37f3f874f2114ec02532e85587791d24037485b1b95ec8cbc75b52042867988b51c7c3589d5b5972fd20a2e8a7c9ced986873f5008a418b2921daa7cfb78afc174eecdb8a79dc0961bea9740d09c4656ac9b8c86263a788e35af1d4a3f86ce053a1aefb5369def91614a390219f896f378712376baa05934a341798950e229f4f735b86004952b259f23cc9fc3b8c1bc8171984884dc92940e91f2e9a78a84a78f0c2946b7e37bbf3b9b0203010001300d06092a864886f70d010105050003820101001cf15250365e66cc87bb5054de1661266cf87907841016b20dfa1f9f59842020cbc33f9b4d41717db0428d11696a0bade6a4950a48cc4fa8ae56c850647379a5c2d977436b644162c453dd36b7745ccb9ff0b5fc070125024de73dab6dcda5c69372e978a49865f569927199ed0f61d7cbee1839079a7da2e83f8c90f7421a8c81b3f17f1cc05d52aedac9acd6e092ffd9ad572960e779a5b91a78e1aeb2b3c7b24464bd223c745e40abd74fc586310809520d183443fcca3c6ade3be458afedbd3325df9c0e552636e35bb55b240eb8c0ba3973c4fb81213f22363be2d70e85014650c2f4fc679747a7ec31ea7b08da7dd9b9ba279a7fbbc1bd440fbe831bf4");
    }

    public static String a(PackageManager packageManager) {
        if (a(packageManager, "com.twitter.android", "3082025d308201c6a00302010202044bd76cce300d06092a864886f70d01010505003073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e6420526563686973301e170d3130303432373233303133345a170d3438303832353233303133345a3073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e642052656368697330819f300d06092a864886f70d010101050003818d003081890281810086233c2e51c62232d49cc932e470713d63a6a1106b38f9e442e01bc79ca4f95c72b2cb3f1369ef7dea6036bff7c4b2828cb3787e7657ad83986751ced5b131fcc6f413efb7334e32ed9787f9e9a249ae108fa66009ac7a7932c25d37e1e07d4f9f66aa494c270dbac87d261c9668d321c2fba4ef2800e46671a597ff2eac5d7f0203010001300d06092a864886f70d0101050500038181003e1f01cb6ea8be8d2cecef5cd2a64c97ba8728aa5f08f8275d00508d64d139b6a72c5716b40a040df0eeeda04de9361107e123ee8d3dc05e70c8a355f46dbadf1235443b0b214c57211afd4edd147451c443d49498d2a7ff27e45a99c39b9e47429a1dae843ba233bf8ca81296dbe1dc5c5434514d995b0279246809392a219b")) {
            return "com.twitter.android";
        }
        if (a(packageManager, "com.twitter.android.beta", "308203523082023aa00302010202044fd0006b300d06092a864886f70d0101050500306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c65301e170d3132303630373031313431395a170d3339313032343031313431395a306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c6530820122300d06092a864886f70d01010105000382010f003082010a028201010089e6cbdfed4288a9c0a215d33d4fa978a5bdd20be426ef4b497d358a9fd1c6efec9684f059f6955e60e5fda1b5910bb2d097e7421a78f9c81e95cd8ef3bf50add7f8d9f073c0478736a6c7fd38c5871559783a76420d37f3f874f2114ec02532e85587791d24037485b1b95ec8cbc75b52042867988b51c7c3589d5b5972fd20a2e8a7c9ced986873f5008a418b2921daa7cfb78afc174eecdb8a79dc0961bea9740d09c4656ac9b8c86263a788e35af1d4a3f86ce053a1aefb5369def91614a390219f896f378712376baa05934a341798950e229f4f735b86004952b259f23cc9fc3b8c1bc8171984884dc92940e91f2e9a78a84a78f0c2946b7e37bbf3b9b0203010001300d06092a864886f70d010105050003820101001cf15250365e66cc87bb5054de1661266cf87907841016b20dfa1f9f59842020cbc33f9b4d41717db0428d11696a0bade6a4950a48cc4fa8ae56c850647379a5c2d977436b644162c453dd36b7745ccb9ff0b5fc070125024de73dab6dcda5c69372e978a49865f569927199ed0f61d7cbee1839079a7da2e83f8c90f7421a8c81b3f17f1cc05d52aedac9acd6e092ffd9ad572960e779a5b91a78e1aeb2b3c7b24464bd223c745e40abd74fc586310809520d183443fcca3c6ade3be458afedbd3325df9c0e552636e35bb55b240eb8c0ba3973c4fb81213f22363be2d70e85014650c2f4fc679747a7ec31ea7b08da7dd9b9ba279a7fbbc1bd440fbe831bf4")) {
            return "com.twitter.android.beta";
        }
        return null;
    }

    private static boolean a(PackageManager packageManager, String str, String str2) {
        try {
            for (Signature signature : packageManager.getPackageInfo(str, 64).signatures) {
                if (!str2.equals(signature.toCharsString())) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
