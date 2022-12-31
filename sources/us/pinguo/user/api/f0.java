package us.pinguo.user.api;

import android.content.Context;
import android.content.res.Resources;
import us.pinguo.inspire.api.Payload;
import us.pinguo.user.R;
/* compiled from: StatusErrorCodeHelper.java */
/* loaded from: classes6.dex */
public class f0 {
    public static String a(Context context, int i2) {
        Resources resources = context.getResources();
        if (i2 != 200) {
            if (i2 != 401) {
                if (i2 != 420) {
                    if (i2 != 500) {
                        if (i2 != 10546) {
                            if (i2 != 10553) {
                                if (i2 != 10601) {
                                    if (i2 != 10500) {
                                        if (i2 != 10501) {
                                            if (i2 != 10524) {
                                                if (i2 != 10525) {
                                                    switch (i2) {
                                                        case 10000:
                                                            return resources.getString(R.string.status_errorcode10000);
                                                        case 10001:
                                                            return resources.getString(R.string.status_errorcode10001);
                                                        case 10002:
                                                            return resources.getString(R.string.status_errorcode10002);
                                                        case 10003:
                                                            return resources.getString(R.string.status_errorcode10003);
                                                        case 10004:
                                                            return resources.getString(R.string.status_errorcode10004);
                                                        case 10005:
                                                            return resources.getString(R.string.status_errorcode10005);
                                                        case 10006:
                                                            return resources.getString(R.string.status_errorcode10006);
                                                        case 10007:
                                                            return resources.getString(R.string.status_errorcode10007);
                                                        case 10008:
                                                            return resources.getString(R.string.status_errorcode10008);
                                                        case 10009:
                                                            return resources.getString(R.string.status_errorcode10009);
                                                        case 10010:
                                                            return resources.getString(R.string.status_errorcode10010);
                                                        case 10011:
                                                            return resources.getString(R.string.status_errorcode10011);
                                                        case 10012:
                                                            return resources.getString(R.string.status_errorcode10012);
                                                        case 10013:
                                                            return resources.getString(R.string.status_errorcode10013);
                                                        default:
                                                            switch (i2) {
                                                                case 10510:
                                                                    return resources.getString(R.string.status_errorcode10510);
                                                                case 10511:
                                                                    return resources.getString(R.string.status_errorcode10511);
                                                                case Payload.SERVER_ERROR_CODE_10512 /* 10512 */:
                                                                    return resources.getString(R.string.status_errorcode10512);
                                                                case Payload.SERVER_ERROR_CODE_10513 /* 10513 */:
                                                                    return resources.getString(R.string.status_errorcode10513);
                                                                case 10514:
                                                                    return resources.getString(R.string.status_errorcode10514);
                                                                case 10515:
                                                                    return resources.getString(R.string.status_errorcode10010);
                                                                case 10516:
                                                                    return resources.getString(R.string.status_errorcode10516);
                                                                case 10517:
                                                                    return resources.getString(R.string.status_errorcode10517);
                                                                case 10518:
                                                                    return resources.getString(R.string.status_errorcode10518);
                                                                case 10519:
                                                                    return resources.getString(R.string.status_errorcode10519);
                                                                case 10520:
                                                                    return resources.getString(R.string.status_errorcode10520);
                                                                case 10521:
                                                                    return resources.getString(R.string.status_errorcode10521);
                                                                case 10522:
                                                                    return resources.getString(R.string.status_errorcode10522);
                                                                default:
                                                                    switch (i2) {
                                                                        case 10530:
                                                                            return resources.getString(R.string.status_errorcode10530);
                                                                        case 10531:
                                                                            return resources.getString(R.string.status_errorcode10531);
                                                                        case 10532:
                                                                            return resources.getString(R.string.status_errorcode10532);
                                                                        case 10533:
                                                                            return resources.getString(R.string.status_errorcode10533);
                                                                        case 10534:
                                                                            return resources.getString(R.string.status_errorcode10534);
                                                                        case 10535:
                                                                            return resources.getString(R.string.status_errorcode10535);
                                                                        case 10536:
                                                                            return resources.getString(R.string.pg_login_phone_number_not_exist);
                                                                        case 10537:
                                                                            return resources.getString(R.string.pg_login_phone_verify_error);
                                                                        case 10538:
                                                                            return resources.getString(R.string.status_errorcode10538);
                                                                        case 10539:
                                                                            return resources.getString(R.string.pg_login_phone_verify_code_expired);
                                                                        case 10540:
                                                                            return resources.getString(R.string.status_errorcode10540);
                                                                        case 10541:
                                                                            return resources.getString(R.string.status_errorcode10541);
                                                                        case 10542:
                                                                            return resources.getString(R.string.status_errorcode10542);
                                                                        case 10543:
                                                                            return resources.getString(R.string.status_errorcode10543);
                                                                        case 10544:
                                                                            return resources.getString(R.string.status_errorcode10544);
                                                                        default:
                                                                            return null;
                                                                    }
                                                            }
                                                    }
                                                }
                                                return resources.getString(R.string.status_errorcode10525);
                                            }
                                            return resources.getString(R.string.forbidden_words);
                                        }
                                        return resources.getString(R.string.status_errorcode10501);
                                    }
                                    return resources.getString(R.string.status_errorcode10500);
                                }
                                return resources.getString(R.string.status_errorcode10601);
                            }
                            return resources.getString(R.string.status_errorcode10553);
                        }
                        return resources.getString(R.string.status_errorcode10546);
                    }
                    return resources.getString(R.string.status_errorcode500);
                }
                return resources.getString(R.string.status_errorcode420);
            }
            return resources.getString(R.string.status_errorcode401);
        }
        return resources.getString(R.string.status_errorcode200);
    }
}
