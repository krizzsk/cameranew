package us.pinguo.admobvista.StaticsAdv;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.material.timepicker.TimeModel;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.tapjoy.TapjoyConstants;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import us.pinguo.advconfigdata.Statictis.AdvStaticsticManager;
import us.pinguo.advconfigdata.Utils.AdvUtils;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes3.dex */
public abstract class IADStatisticBase {
    public static String ACTION_CLICK = "click";
    public static String ACTION_CONVERSION = "conversion";
    public static String ACTION_REQUEST = "request";
    public static String ACTION_SHOW = "show";
    public static String CHARGE_MODE_CPA = "cpa";
    public static String CHARGE_MODE_CPC = "cpc";
    public static String CHARGE_MODE_CPI = "cpi";
    public static String CHARGE_MODE_CPM = "cpm";
    public static String CHARGE_MODE_CPT = "cpt";
    public static String CHARGE_MODE_DEFAULT = "0";
    public static String CLICK_TYPE_BODY = "body";
    public static String CLICK_TYPE_BUTTON = "button";
    public static String CLICK_TYPE_HEADER = "header";
    public static String CONV_GP = "gp";
    public static String CONV_H5 = "h5";
    public static String CONV_INTERNAL_EC = "ec";
    public static String CONV_INTERNAL_FUNC = "internal_func";
    public static String DELIVER_TYPE_AFFILIATE = "affiliate";
    public static String DELIVER_TYPE_BRAND = "brand";
    public static String DELIVER_TYPE_DSP = "dsp";
    public static String DELIVER_TYPE_SELF_EFFECT = "self_effect";
    public static String DELIVER_TYPE_THIRD_SDK = "third_sdk";
    public static String DISPLAY_TYPE_APPWALL = "appwall";
    public static String DISPLAY_TYPE_BANNER = "banner";
    public static String DISPLAY_TYPE_FEEDS = "feed";
    public static String DISPLAY_TYPE_FULL_SCREEN = "full_screen";
    public static String DISPLAY_TYPE_H5_NON_WAPPWALL = "h5_non_appwall";
    public static String DISPLAY_TYPE_LARGE_CARD = "large_card";
    public static String DISPLAY_TYPE_RECTANGLE = "rectangle";
    public static String FINAL_SOURCE_ADMOB = "admob";
    public static String FINAL_SOURCE_FACEBOOK = "facebook";
    public static final int INTEGER_DEFALUT_VALUE = -1;
    public static String KEY_ADDESCRIPTION = "ad_description";
    public static String KEY_ADVERTISER = "advertiser";
    public static String KEY_AD_ID = "ad_id";
    public static String KEY_BID = "bid";
    public static String KEY_CATEGORY = "ad_category";
    public static String KEY_CHARGE_MODE = "charge_mode";
    public static String KEY_CITY = "city";
    public static String KEY_CLICKOBJECT = "click_obj";
    public static String KEY_CLICK_COUNT = "user_click_count";
    public static String KEY_CLIENTHOUR = "client_time";
    public static String KEY_CONV_TYPE = "conv_type";
    public static String KEY_COUNTRY = "country";
    public static String KEY_CREATIVE_AUTHOR = "creative_author";
    public static String KEY_CTA_TEXT = "cta_text";
    public static String KEY_DELIVERTYPE = "deliver_type";
    public static String KEY_DISPLAYSTYLE = "display_format";
    public static String KEY_EXP_TAG = "exp_tag";
    public static String KEY_FINAL_SOURCE = "final_source";
    public static String KEY_ICON = "icon_url";
    public static String KEY_IMAGE = "image_url";
    public static String KEY_INCENT = "incent";
    public static String KEY_LOAD_TIME = "ad_load_time";
    public static String KEY_LOG_VERSION = "log_version";
    public static String KEY_MEDIATYPE = "media_type";
    public static String KEY_NETWORKTYPE = "network";
    public static String KEY_OFFER_ID = "offer_id";
    public static String KEY_PAGE = "page";
    public static String KEY_PLACEMENT_ID = "placement_id";
    public static String KEY_PLATFORM = "log_source";
    public static String KEY_POS = "pos";
    public static String KEY_PRICE = "price";
    public static String KEY_RANK = "rank";
    public static String KEY_SHOW_COUNT = "user_show_count";
    public static String KEY_SHOW_TIME = "ad_show_time";
    public static String KEY_SOURCE = "source";
    public static String KEY_TITLE = "ad_title";
    public static String KEY_UNIT_ID = "unit_id";
    public static final String LOG_VERSION = "1.5";
    public static String MEDIA_TYPE_MULTI = "multi_image";
    public static String MEDIA_TYPE_SINGLE = "single_image";
    public static String MEDIA_TYPE_VIDEO = "video";
    public static String PAGE_ALBUM = "album";
    public static String PAGE_ALBUM_PHOTO = "album_photo";
    public static String PAGE_COMMUNITY = "community";
    public static String PAGE_COMMUNITY_MESSAGE = "community_message_page";
    public static String PAGE_COMMUNITY_SENDGUIDE_PAGE = "community_sendguide_page";
    public static String PAGE_DISCOVER = "discover";
    public static String PAGE_EDIT_RESULT_PAGE = "edit_result_page";
    public static String PAGE_ENTER_PUBLISH_PAGE = "enter_public_page";
    public static String PAGE_HOME = "home";
    public static String PAGE_HOME_FOLLOW = "home_follow";
    public static String PAGE_HOME_HOT = "home_hot";
    public static String PAGE_PC_PROFILE = "pc_profile_page";
    public static String PAGE_PC_PROFILE_PAGE = "pc_profile_page";
    public static String PAGE_PICTURE_PREVIEW = "picture_preview";
    public static String PAGE_SQUARE = "square";
    public static String PAGE_STARTUP = "startup_page";
    public static String POS_BACKGROUND = "backgroud";
    public static String POS_BANNER = "banner";
    public static String POS_BUBBLE = "bubble";
    public static String POS_FEEDS = "feed";
    public static String POS_FUNCTION = "function";
    public static String POS_INTERSTITIAL = "Interstitial";
    public static String POS_NATIVE_LARGE_CARD = "native_large_card";
    public static String POS_POP_UP = "pop_up";
    public static String POS_TOP_BANNER = "top_banner";
    public static String POS_UPPER_RIGHT_BT = "upper_right_bt";
    public static String SOURCE_TYPE_ADMOB = "admob";
    public static String SOURCE_TYPE_ALTMOB = "altmob";
    public static String SOURCE_TYPE_APPNEXT = "appNext";
    public static String SOURCE_TYPE_BRAND = "brand";
    public static String SOURCE_TYPE_CLOUD_MOBI = "cloudmobi";
    public static String SOURCE_TYPE_DSP = "dsp";
    public static String SOURCE_TYPE_FACEBOOK = "facebook";
    public static String SOURCE_TYPE_GDT = "gdt";
    public static String SOURCE_TYPE_MV = "mobvista";
    public static String SOURCE_TYPE_YM = "yeahmobi";
    public static String SOURCE_TYPE_YOUAPPI = "youappi";
    public static String SOURCE_TYPE_ZYY = "zyy";
    public static String UNIT_ID_ALBUM_BOTTOM_BANNER = "Camera360_012";
    public static String UNIT_ID_ALBUM_TOP_GIF = "Camera360_013";
    public static String UNIT_ID_CHALLENGE_GIFT = "Camera360_016";
    public static String UNIT_ID_FUNCTION_2 = "Camera360_102";
    public static String UNIT_ID_FUNCTION_6 = "Camera360_002";
    public static String UNIT_ID_GLOBAL = "Camera360_global";
    public static String UNIT_ID_HOME_APPWALL = "Camera360_104";
    public static String UNIT_ID_HOME_BANNER = "Camera360_100";
    public static String UNIT_ID_HOME_FEED = "Camera360_003";
    public static String UNIT_ID_HOME_GIFT = "Camera360_114";
    public static String UNIT_ID_INFOMOBI = "Camera360_511";
    public static String UNIT_ID_INTERSTITIAL_ALBUM = "Camera360_019";
    public static String UNIT_ID_INTERSTITIAL_HOME = "Camera360_020";
    public static String UNIT_ID_INTERSTITIAL_HOME_BACKUP = "Camera360_021";
    public static String UNIT_ID_INTERSTITIAL_KEY = "Camera360_506";
    public static String UNIT_ID_INTERSTITIAL_PHOTO_PREVIEW = "Camera360_015";
    public static String UNIT_ID_INTERSTITIAL_RESULT = "Camera360_017";
    public static String UNIT_ID_INTERSTITIAL_REWARD = "Camera360_555";
    public static String UNIT_ID_KEEP_ALIVE_PROGRESS = "Camera360_510";
    public static String UNIT_ID_PROMOTION_REWARD = "Camera360_507";
    public static String UNIT_ID_RESULT_APPWALL = "Camera360_008";
    public static String UNIT_ID_RESULT_BANNER = "Camera360_007";
    public static String UNIT_ID_RESULT_GIFT = "Camera360_018";
    public static String UNIT_ID_REWARD_VIDEO = "Camera360_505";
    public static String UNIT_ID_SPLASH = "Camera360_009";
    public static String UNIT_ID_SQUARE_APPWALL = "Camera360_006";
    public static String UNIT_ID_SQUARE_BANNER = "Camera360_011";
    public static String UNIT_ID_SQUARE_FEED = "Camera360_005";
    public static final String VARCHAR_DEFALUT_VALUE = "default";
    private static long mLastTime;
    private static String mNetWorkType;
    private Context mContext;
    protected int mRank = -1;

    public IADStatisticBase(Context context) {
        this.mContext = context;
    }

    private String getClientHour() {
        return getData();
    }

    private Map<String, String> getContent() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(KEY_AD_ID, getAdId());
            hashMap.put(KEY_POS, getADPos());
            hashMap.put(KEY_RANK, String.valueOf(getRank()));
            hashMap.put(KEY_PAGE, getPage());
            hashMap.put(KEY_SOURCE, getSrcType());
            hashMap.put(KEY_DELIVERTYPE, getDeliverType());
            hashMap.put(KEY_MEDIATYPE, getMediaType());
            hashMap.put(KEY_DISPLAYSTYLE, getDisplayType());
            hashMap.put(KEY_TITLE, getTitle());
            hashMap.put(KEY_ADDESCRIPTION, getAdDescription());
            hashMap.put(KEY_ICON, getIconUrl());
            hashMap.put(KEY_IMAGE, getImageUrl());
            hashMap.put(KEY_CATEGORY, getAdCategory());
            hashMap.put(KEY_CREATIVE_AUTHOR, getCreativeAuthor());
            hashMap.put(KEY_INCENT, isIncent() ? "1" : "0");
            hashMap.put(KEY_ADVERTISER, getAdvertiser());
            hashMap.put(KEY_NETWORKTYPE, getNetWortType());
            hashMap.put(KEY_CLIENTHOUR, getClientHour());
            hashMap.put(KEY_OFFER_ID, getOfferid());
            hashMap.put(KEY_FINAL_SOURCE, getFinalSourceType());
            hashMap.put(KEY_CONV_TYPE, getConvType());
            hashMap.put(KEY_LOAD_TIME, getloadTime());
            hashMap.put(KEY_SHOW_TIME, getShowTime());
            hashMap.put(KEY_CHARGE_MODE, getChargeMode());
            hashMap.put(KEY_PRICE, getPrice());
            hashMap.put(KEY_BID, getBid());
            hashMap.put(KEY_LOG_VERSION, LOG_VERSION);
            hashMap.put(KEY_UNIT_ID, getUnitId());
            hashMap.put(KEY_EXP_TAG, getExpTag());
            hashMap.put(KEY_PLACEMENT_ID, getPlacementId());
            hashMap.put(KEY_CTA_TEXT, getCtaText());
            hashMap.put(KEY_PLATFORM, TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
            hashMap.put(KEY_COUNTRY, getLocalDefault().getCountry());
            hashMap.put(KEY_CITY, VARCHAR_DEFALUT_VALUE);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }

    private String getData() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(7);
        int i7 = i6 == 1 ? 7 : i6 - 1;
        String str = null;
        if (i7 == 1) {
            str = "周一";
        } else if (i7 == 2) {
            str = "周二";
        } else if (i7 == 3) {
            str = "周三";
        } else if (i7 == 4) {
            str = "周四";
        } else if (i7 == 5) {
            str = "周五";
        } else if (i7 == 6) {
            str = "周六";
        } else if (i7 == 7) {
            str = "周日";
        }
        return String.valueOf(i2) + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3)) + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i4)) + PGTransHeader.CONNECTOR + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i5)) + PGTransHeader.CONNECTOR + str;
    }

    private Locale getLocalDefault() {
        return Locale.getDefault();
    }

    private String getNetWortType() {
        if (System.currentTimeMillis() - mLastTime > 60000) {
            mLastTime = System.currentTimeMillis();
            mNetWorkType = null;
        }
        if (TextUtils.isEmpty(mNetWorkType)) {
            int currentNetType = AdvUtils.currentNetType(this.mContext);
            if (currentNetType == 2) {
                mNetWorkType = "2G";
            } else if (currentNetType == 4) {
                mNetWorkType = "3G";
            } else if (currentNetType == 8) {
                mNetWorkType = "4G";
            } else if (currentNetType == 16) {
                mNetWorkType = NetworkUtil.NETWORK_WIFI;
            } else {
                mNetWorkType = NetworkUtil.NETWORK_UNKNOWN;
            }
        }
        return mNetWorkType;
    }

    public String ClickStatistics(String str) {
        Map<String, String> content;
        if (isUpload() && (content = getContent()) != null) {
            StatisticSharePreferenceHelper.onAdvClick();
            content.put(KEY_CLICKOBJECT, str);
            content.put(KEY_SHOW_COUNT, String.valueOf(StatisticSharePreferenceHelper.getShowCount()));
            content.put(KEY_CLICK_COUNT, String.valueOf(StatisticSharePreferenceHelper.getClickCount()));
            String bigData = getBigData(content);
            AdvStaticsticManager.GetInstance().GetStaticInterface().ReportBDNoKey("click_adv_statistic_key", bigData);
            return bigData;
        }
        return null;
    }

    public String ShowStatistics() {
        Map<String, String> content;
        if (isUpload() && (content = getContent()) != null) {
            StatisticSharePreferenceHelper.onAdvShow();
            content.put(KEY_SHOW_COUNT, String.valueOf(StatisticSharePreferenceHelper.getShowCount()));
            content.put(KEY_CLICK_COUNT, String.valueOf(StatisticSharePreferenceHelper.getClickCount()));
            String bigData = getBigData(content);
            AdvStaticsticManager.GetInstance().GetStaticInterface().ReportBDNoKey("show_adv_statistic_key", bigData);
            return bigData;
        }
        return null;
    }

    public abstract String getADPos();

    public abstract String getAdCategory();

    public abstract String getAdDescription();

    public abstract String getAdId();

    public abstract String getAdvertiser();

    public abstract String getBid();

    public String getBigData(Map<String, String> map) {
        String str = null;
        if (map != null && map.size() != 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    String value = TextUtils.isEmpty(entry.getValue()) ? VARCHAR_DEFALUT_VALUE : entry.getValue();
                    String str2 = entry.getKey() + "=" + URLEncoder.encode(value, "utf-8");
                    if (str != null) {
                        str2 = (str + ",") + str2;
                    }
                    str = str2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return str;
    }

    public abstract String getChargeMode();

    public abstract String getConvType();

    public abstract String getCreativeAuthor();

    public abstract String getCtaText();

    public abstract String getDeliverType();

    public abstract String getDisplayType();

    public abstract String getExpTag();

    public abstract String getFinalSourceType();

    public abstract String getIconUrl();

    public abstract String getImageUrl();

    public abstract String getMediaType();

    public abstract String getOfferid();

    public abstract String getPage();

    public abstract String getPlacementId();

    public abstract String getPrice();

    public abstract int getRank();

    public abstract String getShowTime();

    public abstract String getSrcType();

    public abstract String getTitle();

    public abstract String getUnitId();

    public abstract String getloadTime();

    public abstract boolean isIncent();

    public abstract boolean isUpload();
}
