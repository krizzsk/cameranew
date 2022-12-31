package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.internal.s6;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics zza;
    private final zzbr zzb;
    private ExecutorService zzc;

    /* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
    /* loaded from: classes2.dex */
    public enum ConsentStatus {
        GRANTED,
        DENIED
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
    /* loaded from: classes2.dex */
    public enum ConsentType {
        AD_STORAGE,
        ANALYTICS_STORAGE
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
    /* loaded from: classes2.dex */
    public static class Event {
        @RecentlyNonNull
        public static final String ADD_PAYMENT_INFO = "add_payment_info";
        @RecentlyNonNull
        public static final String ADD_SHIPPING_INFO = "add_shipping_info";
        @RecentlyNonNull
        public static final String ADD_TO_CART = "add_to_cart";
        @RecentlyNonNull
        public static final String ADD_TO_WISHLIST = "add_to_wishlist";
        @RecentlyNonNull
        public static final String AD_IMPRESSION = "ad_impression";
        @RecentlyNonNull
        public static final String APP_OPEN = "app_open";
        @RecentlyNonNull
        public static final String BEGIN_CHECKOUT = "begin_checkout";
        @RecentlyNonNull
        public static final String CAMPAIGN_DETAILS = "campaign_details";
        @RecentlyNonNull
        @Deprecated
        public static final String CHECKOUT_PROGRESS = "checkout_progress";
        @RecentlyNonNull
        public static final String EARN_VIRTUAL_CURRENCY = "earn_virtual_currency";
        @RecentlyNonNull
        @Deprecated
        public static final String ECOMMERCE_PURCHASE = "ecommerce_purchase";
        @RecentlyNonNull
        public static final String GENERATE_LEAD = "generate_lead";
        @RecentlyNonNull
        public static final String JOIN_GROUP = "join_group";
        @RecentlyNonNull
        public static final String LEVEL_END = "level_end";
        @RecentlyNonNull
        public static final String LEVEL_START = "level_start";
        @RecentlyNonNull
        public static final String LEVEL_UP = "level_up";
        @RecentlyNonNull
        public static final String LOGIN = "login";
        @RecentlyNonNull
        public static final String POST_SCORE = "post_score";
        @RecentlyNonNull
        @Deprecated
        public static final String PRESENT_OFFER = "present_offer";
        @RecentlyNonNull
        public static final String PURCHASE = "purchase";
        @RecentlyNonNull
        @Deprecated
        public static final String PURCHASE_REFUND = "purchase_refund";
        @RecentlyNonNull
        public static final String REFUND = "refund";
        @RecentlyNonNull
        public static final String REMOVE_FROM_CART = "remove_from_cart";
        @RecentlyNonNull
        public static final String SCREEN_VIEW = "screen_view";
        @RecentlyNonNull
        public static final String SEARCH = "search";
        @RecentlyNonNull
        public static final String SELECT_CONTENT = "select_content";
        @RecentlyNonNull
        public static final String SELECT_ITEM = "select_item";
        @RecentlyNonNull
        public static final String SELECT_PROMOTION = "select_promotion";
        @RecentlyNonNull
        @Deprecated
        public static final String SET_CHECKOUT_OPTION = "set_checkout_option";
        @RecentlyNonNull
        public static final String SHARE = "share";
        @RecentlyNonNull
        public static final String SIGN_UP = "sign_up";
        @RecentlyNonNull
        public static final String SPEND_VIRTUAL_CURRENCY = "spend_virtual_currency";
        @RecentlyNonNull
        public static final String TUTORIAL_BEGIN = "tutorial_begin";
        @RecentlyNonNull
        public static final String TUTORIAL_COMPLETE = "tutorial_complete";
        @RecentlyNonNull
        public static final String UNLOCK_ACHIEVEMENT = "unlock_achievement";
        @RecentlyNonNull
        public static final String VIEW_CART = "view_cart";
        @RecentlyNonNull
        public static final String VIEW_ITEM = "view_item";
        @RecentlyNonNull
        public static final String VIEW_ITEM_LIST = "view_item_list";
        @RecentlyNonNull
        public static final String VIEW_PROMOTION = "view_promotion";
        @RecentlyNonNull
        public static final String VIEW_SEARCH_RESULTS = "view_search_results";

        protected Event() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
    /* loaded from: classes2.dex */
    public static class Param {
        @RecentlyNonNull
        public static final String ACHIEVEMENT_ID = "achievement_id";
        @RecentlyNonNull
        public static final String ACLID = "aclid";
        @RecentlyNonNull
        public static final String AD_FORMAT = "ad_format";
        @RecentlyNonNull
        public static final String AD_PLATFORM = "ad_platform";
        @RecentlyNonNull
        public static final String AD_SOURCE = "ad_source";
        @RecentlyNonNull
        public static final String AD_UNIT_NAME = "ad_unit_name";
        @RecentlyNonNull
        public static final String AFFILIATION = "affiliation";
        @RecentlyNonNull
        public static final String CAMPAIGN = "campaign";
        @RecentlyNonNull
        public static final String CHARACTER = "character";
        @RecentlyNonNull
        @Deprecated
        public static final String CHECKOUT_OPTION = "checkout_option";
        @RecentlyNonNull
        @Deprecated
        public static final String CHECKOUT_STEP = "checkout_step";
        @RecentlyNonNull
        public static final String CONTENT = "content";
        @RecentlyNonNull
        public static final String CONTENT_TYPE = "content_type";
        @RecentlyNonNull
        public static final String COUPON = "coupon";
        @RecentlyNonNull
        public static final String CP1 = "cp1";
        @RecentlyNonNull
        public static final String CREATIVE_NAME = "creative_name";
        @RecentlyNonNull
        public static final String CREATIVE_SLOT = "creative_slot";
        @RecentlyNonNull
        public static final String CURRENCY = "currency";
        @RecentlyNonNull
        public static final String DESTINATION = "destination";
        @RecentlyNonNull
        public static final String DISCOUNT = "discount";
        @RecentlyNonNull
        public static final String END_DATE = "end_date";
        @RecentlyNonNull
        public static final String EXTEND_SESSION = "extend_session";
        @RecentlyNonNull
        public static final String FLIGHT_NUMBER = "flight_number";
        @RecentlyNonNull
        public static final String GROUP_ID = "group_id";
        @RecentlyNonNull
        public static final String INDEX = "index";
        @RecentlyNonNull
        public static final String ITEMS = "items";
        @RecentlyNonNull
        public static final String ITEM_BRAND = "item_brand";
        @RecentlyNonNull
        public static final String ITEM_CATEGORY = "item_category";
        @RecentlyNonNull
        public static final String ITEM_CATEGORY2 = "item_category2";
        @RecentlyNonNull
        public static final String ITEM_CATEGORY3 = "item_category3";
        @RecentlyNonNull
        public static final String ITEM_CATEGORY4 = "item_category4";
        @RecentlyNonNull
        public static final String ITEM_CATEGORY5 = "item_category5";
        @RecentlyNonNull
        public static final String ITEM_ID = "item_id";
        @RecentlyNonNull
        @Deprecated
        public static final String ITEM_LIST = "item_list";
        @RecentlyNonNull
        public static final String ITEM_LIST_ID = "item_list_id";
        @RecentlyNonNull
        public static final String ITEM_LIST_NAME = "item_list_name";
        @RecentlyNonNull
        @Deprecated
        public static final String ITEM_LOCATION_ID = "item_location_id";
        @RecentlyNonNull
        public static final String ITEM_NAME = "item_name";
        @RecentlyNonNull
        public static final String ITEM_VARIANT = "item_variant";
        @RecentlyNonNull
        public static final String LEVEL = "level";
        @RecentlyNonNull
        public static final String LEVEL_NAME = "level_name";
        @RecentlyNonNull
        public static final String LOCATION = "location";
        @RecentlyNonNull
        public static final String LOCATION_ID = "location_id";
        @RecentlyNonNull
        public static final String MEDIUM = "medium";
        @RecentlyNonNull
        public static final String METHOD = "method";
        @RecentlyNonNull
        public static final String NUMBER_OF_NIGHTS = "number_of_nights";
        @RecentlyNonNull
        public static final String NUMBER_OF_PASSENGERS = "number_of_passengers";
        @RecentlyNonNull
        public static final String NUMBER_OF_ROOMS = "number_of_rooms";
        @RecentlyNonNull
        public static final String ORIGIN = "origin";
        @RecentlyNonNull
        public static final String PAYMENT_TYPE = "payment_type";
        @RecentlyNonNull
        public static final String PRICE = "price";
        @RecentlyNonNull
        public static final String PROMOTION_ID = "promotion_id";
        @RecentlyNonNull
        public static final String PROMOTION_NAME = "promotion_name";
        @RecentlyNonNull
        public static final String QUANTITY = "quantity";
        @RecentlyNonNull
        public static final String SCORE = "score";
        @RecentlyNonNull
        public static final String SCREEN_CLASS = "screen_class";
        @RecentlyNonNull
        public static final String SCREEN_NAME = "screen_name";
        @RecentlyNonNull
        public static final String SEARCH_TERM = "search_term";
        @RecentlyNonNull
        public static final String SHIPPING = "shipping";
        @RecentlyNonNull
        public static final String SHIPPING_TIER = "shipping_tier";
        @RecentlyNonNull
        @Deprecated
        public static final String SIGN_UP_METHOD = "sign_up_method";
        @RecentlyNonNull
        public static final String SOURCE = "source";
        @RecentlyNonNull
        public static final String START_DATE = "start_date";
        @RecentlyNonNull
        public static final String SUCCESS = "success";
        @RecentlyNonNull
        public static final String TAX = "tax";
        @RecentlyNonNull
        public static final String TERM = "term";
        @RecentlyNonNull
        public static final String TRANSACTION_ID = "transaction_id";
        @RecentlyNonNull
        public static final String TRAVEL_CLASS = "travel_class";
        @RecentlyNonNull
        public static final String VALUE = "value";
        @RecentlyNonNull
        public static final String VIRTUAL_CURRENCY_NAME = "virtual_currency_name";

        protected Param() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
    /* loaded from: classes2.dex */
    public static class UserProperty {
        @RecentlyNonNull
        public static final String ALLOW_AD_PERSONALIZATION_SIGNALS = "allow_personalized_ads";
        @RecentlyNonNull
        public static final String SIGN_UP_METHOD = "sign_up_method";

        protected UserProperty() {
        }
    }

    public FirebaseAnalytics(zzbr zzbrVar) {
        q.j(zzbrVar);
        this.zzb = zzbrVar;
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static FirebaseAnalytics getInstance(@RecentlyNonNull Context context) {
        if (zza == null) {
            synchronized (FirebaseAnalytics.class) {
                if (zza == null) {
                    zza = new FirebaseAnalytics(zzbr.zza(context, null, null, null, null));
                }
            }
        }
        return zza;
    }

    @Nullable
    @Keep
    public static s6 getScionFrontendApiImplementation(Context context, @Nullable Bundle bundle) {
        zzbr zza2 = zzbr.zza(context, null, null, null, bundle);
        if (zza2 == null) {
            return null;
        }
        return new zzc(zza2);
    }

    @NonNull
    public g<String> getAppInstanceId() {
        ExecutorService executorService;
        try {
            synchronized (FirebaseAnalytics.class) {
                if (this.zzc == null) {
                    this.zzc = new zza(this, 0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
                }
                executorService = this.zzc;
            }
            return j.c(executorService, new zzb(this));
        } catch (Exception e2) {
            this.zzb.zzC(5, "Failed to schedule task for getAppInstanceId", null, null, null);
            return j.d(e2);
        }
    }

    @RecentlyNonNull
    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String) j.b(FirebaseInstallations.getInstance().getId(), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        } catch (ExecutionException e3) {
            throw new IllegalStateException(e3.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    public void logEvent(@RecentlyNonNull @Size(max = 40, min = 1) String str, @Nullable Bundle bundle) {
        this.zzb.zzg(str, bundle);
    }

    public void resetAnalyticsData() {
        this.zzb.zzs();
    }

    public void setAnalyticsCollectionEnabled(boolean z) {
        this.zzb.zzp(Boolean.valueOf(z));
    }

    public void setConsent(@RecentlyNonNull Map<ConsentType, ConsentStatus> map) {
        Bundle bundle = new Bundle();
        ConsentStatus consentStatus = map.get(ConsentType.AD_STORAGE);
        if (consentStatus != null) {
            int ordinal = consentStatus.ordinal();
            if (ordinal == 0) {
                bundle.putString("ad_storage", "granted");
            } else if (ordinal == 1) {
                bundle.putString("ad_storage", "denied");
            }
        }
        ConsentStatus consentStatus2 = map.get(ConsentType.ANALYTICS_STORAGE);
        if (consentStatus2 != null) {
            int ordinal2 = consentStatus2.ordinal();
            if (ordinal2 == 0) {
                bundle.putString("analytics_storage", "granted");
            } else if (ordinal2 == 1) {
                bundle.putString("analytics_storage", "denied");
            }
        }
        this.zzb.zzr(bundle);
    }

    @Keep
    @MainThread
    @Deprecated
    public void setCurrentScreen(@RecentlyNonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        this.zzb.zzo(activity, str, str2);
    }

    public void setDefaultEventParameters(@Nullable Bundle bundle) {
        this.zzb.zzJ(bundle);
    }

    public void setSessionTimeoutDuration(long j2) {
        this.zzb.zzt(j2);
    }

    public void setUserId(@Nullable String str) {
        this.zzb.zzn(str);
    }

    public void setUserProperty(@RecentlyNonNull @Size(max = 24, min = 1) String str, @Nullable @Size(max = 36) String str2) {
        this.zzb.zzj(null, str, str2, false);
    }
}
