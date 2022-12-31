package us.pinguo.inspire.module.profile;

import android.content.SharedPreferences;
import java.util.List;
import rx.Observable;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.discovery.fragment.DiscoveryHotVideoFragment;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* compiled from: FlowerLoader.kt */
/* loaded from: classes4.dex */
public final class FlowerLoader {
    private static final int FLOWER_NUM_UNLOGIN;
    private static final String GIFT_LIST_URL;
    public static final FlowerLoader INSTANCE = new FlowerLoader();
    private static final String SEND_FLOWER_URL;
    private static final String USER_GIFT_URL;
    private static final String USER_PROFILE_URL;
    private static volatile int flowerNum;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FlowerLoader.kt */
    /* loaded from: classes4.dex */
    public static final class FlowerAuthorInfo {
        private final List<FlowerGift> gifts;

        public FlowerAuthorInfo(List<FlowerGift> gifts) {
            kotlin.jvm.internal.s.h(gifts, "gifts");
            this.gifts = gifts;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FlowerAuthorInfo copy$default(FlowerAuthorInfo flowerAuthorInfo, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = flowerAuthorInfo.gifts;
            }
            return flowerAuthorInfo.copy(list);
        }

        public final List<FlowerGift> component1() {
            return this.gifts;
        }

        public final FlowerAuthorInfo copy(List<FlowerGift> gifts) {
            kotlin.jvm.internal.s.h(gifts, "gifts");
            return new FlowerAuthorInfo(gifts);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FlowerAuthorInfo) && kotlin.jvm.internal.s.c(this.gifts, ((FlowerAuthorInfo) obj).gifts);
        }

        public final List<FlowerGift> getGifts() {
            return this.gifts;
        }

        public int hashCode() {
            return this.gifts.hashCode();
        }

        public String toString() {
            return "FlowerAuthorInfo(gifts=" + this.gifts + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FlowerLoader.kt */
    /* loaded from: classes4.dex */
    public static final class FlowerGift {
        private final String name;
        private final int num;

        public FlowerGift(String name, int i2) {
            kotlin.jvm.internal.s.h(name, "name");
            this.name = name;
            this.num = i2;
        }

        public static /* synthetic */ FlowerGift copy$default(FlowerGift flowerGift, String str, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = flowerGift.name;
            }
            if ((i3 & 2) != 0) {
                i2 = flowerGift.num;
            }
            return flowerGift.copy(str, i2);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.num;
        }

        public final FlowerGift copy(String name, int i2) {
            kotlin.jvm.internal.s.h(name, "name");
            return new FlowerGift(name, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FlowerGift) {
                FlowerGift flowerGift = (FlowerGift) obj;
                return kotlin.jvm.internal.s.c(this.name, flowerGift.name) && this.num == flowerGift.num;
            }
            return false;
        }

        public final String getName() {
            return this.name;
        }

        public final int getNum() {
            return this.num;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.num;
        }

        public String toString() {
            return "FlowerGift(name=" + this.name + ", num=" + this.num + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FlowerLoader.kt */
    /* loaded from: classes4.dex */
    public static final class FlowerResp {
        private final String accountBalance;
        private final String accountH5Switch;
        private final int accountRangkingAward;
        private final FlowerAuthorInfo authorInfo;

        public FlowerResp(FlowerAuthorInfo authorInfo, String accountH5Switch, int i2, String accountBalance) {
            kotlin.jvm.internal.s.h(authorInfo, "authorInfo");
            kotlin.jvm.internal.s.h(accountH5Switch, "accountH5Switch");
            kotlin.jvm.internal.s.h(accountBalance, "accountBalance");
            this.authorInfo = authorInfo;
            this.accountH5Switch = accountH5Switch;
            this.accountRangkingAward = i2;
            this.accountBalance = accountBalance;
        }

        public static /* synthetic */ FlowerResp copy$default(FlowerResp flowerResp, FlowerAuthorInfo flowerAuthorInfo, String str, int i2, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                flowerAuthorInfo = flowerResp.authorInfo;
            }
            if ((i3 & 2) != 0) {
                str = flowerResp.accountH5Switch;
            }
            if ((i3 & 4) != 0) {
                i2 = flowerResp.accountRangkingAward;
            }
            if ((i3 & 8) != 0) {
                str2 = flowerResp.accountBalance;
            }
            return flowerResp.copy(flowerAuthorInfo, str, i2, str2);
        }

        public final FlowerAuthorInfo component1() {
            return this.authorInfo;
        }

        public final String component2() {
            return this.accountH5Switch;
        }

        public final int component3() {
            return this.accountRangkingAward;
        }

        public final String component4() {
            return this.accountBalance;
        }

        public final FlowerResp copy(FlowerAuthorInfo authorInfo, String accountH5Switch, int i2, String accountBalance) {
            kotlin.jvm.internal.s.h(authorInfo, "authorInfo");
            kotlin.jvm.internal.s.h(accountH5Switch, "accountH5Switch");
            kotlin.jvm.internal.s.h(accountBalance, "accountBalance");
            return new FlowerResp(authorInfo, accountH5Switch, i2, accountBalance);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FlowerResp) {
                FlowerResp flowerResp = (FlowerResp) obj;
                return kotlin.jvm.internal.s.c(this.authorInfo, flowerResp.authorInfo) && kotlin.jvm.internal.s.c(this.accountH5Switch, flowerResp.accountH5Switch) && this.accountRangkingAward == flowerResp.accountRangkingAward && kotlin.jvm.internal.s.c(this.accountBalance, flowerResp.accountBalance);
            }
            return false;
        }

        public final String getAccountBalance() {
            return this.accountBalance;
        }

        public final String getAccountH5Switch() {
            return this.accountH5Switch;
        }

        public final int getAccountRangkingAward() {
            return this.accountRangkingAward;
        }

        public final FlowerAuthorInfo getAuthorInfo() {
            return this.authorInfo;
        }

        public int hashCode() {
            return (((((this.authorInfo.hashCode() * 31) + this.accountH5Switch.hashCode()) * 31) + this.accountRangkingAward) * 31) + this.accountBalance.hashCode();
        }

        public String toString() {
            return "FlowerResp(authorInfo=" + this.authorInfo + ", accountH5Switch=" + this.accountH5Switch + ", accountRangkingAward=" + this.accountRangkingAward + ", accountBalance=" + this.accountBalance + ')';
        }
    }

    /* compiled from: FlowerLoader.kt */
    /* loaded from: classes4.dex */
    public static final class GiftResp {
        private final String icon;
        private final String name;
        private final String price;
        private final String productId;
        private final int standard;

        public GiftResp(String name, String productId, int i2, String price, String icon) {
            kotlin.jvm.internal.s.h(name, "name");
            kotlin.jvm.internal.s.h(productId, "productId");
            kotlin.jvm.internal.s.h(price, "price");
            kotlin.jvm.internal.s.h(icon, "icon");
            this.name = name;
            this.productId = productId;
            this.standard = i2;
            this.price = price;
            this.icon = icon;
        }

        public static /* synthetic */ GiftResp copy$default(GiftResp giftResp, String str, String str2, int i2, String str3, String str4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = giftResp.name;
            }
            if ((i3 & 2) != 0) {
                str2 = giftResp.productId;
            }
            String str5 = str2;
            if ((i3 & 4) != 0) {
                i2 = giftResp.standard;
            }
            int i4 = i2;
            if ((i3 & 8) != 0) {
                str3 = giftResp.price;
            }
            String str6 = str3;
            if ((i3 & 16) != 0) {
                str4 = giftResp.icon;
            }
            return giftResp.copy(str, str5, i4, str6, str4);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.productId;
        }

        public final int component3() {
            return this.standard;
        }

        public final String component4() {
            return this.price;
        }

        public final String component5() {
            return this.icon;
        }

        public final GiftResp copy(String name, String productId, int i2, String price, String icon) {
            kotlin.jvm.internal.s.h(name, "name");
            kotlin.jvm.internal.s.h(productId, "productId");
            kotlin.jvm.internal.s.h(price, "price");
            kotlin.jvm.internal.s.h(icon, "icon");
            return new GiftResp(name, productId, i2, price, icon);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GiftResp) {
                GiftResp giftResp = (GiftResp) obj;
                return kotlin.jvm.internal.s.c(this.name, giftResp.name) && kotlin.jvm.internal.s.c(this.productId, giftResp.productId) && this.standard == giftResp.standard && kotlin.jvm.internal.s.c(this.price, giftResp.price) && kotlin.jvm.internal.s.c(this.icon, giftResp.icon);
            }
            return false;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPrice() {
            return this.price;
        }

        public final String getProductId() {
            return this.productId;
        }

        public final int getStandard() {
            return this.standard;
        }

        public int hashCode() {
            return (((((((this.name.hashCode() * 31) + this.productId.hashCode()) * 31) + this.standard) * 31) + this.price.hashCode()) * 31) + this.icon.hashCode();
        }

        public String toString() {
            return "GiftResp(name=" + this.name + ", productId=" + this.productId + ", standard=" + this.standard + ", price=" + this.price + ", icon=" + this.icon + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FlowerLoader.kt */
    /* loaded from: classes4.dex */
    public static final class SendFlowerResp {
        private final int number;

        public SendFlowerResp(int i2) {
            this.number = i2;
        }

        public static /* synthetic */ SendFlowerResp copy$default(SendFlowerResp sendFlowerResp, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = sendFlowerResp.number;
            }
            return sendFlowerResp.copy(i2);
        }

        public final int component1() {
            return this.number;
        }

        public final SendFlowerResp copy(int i2) {
            return new SendFlowerResp(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SendFlowerResp) && this.number == ((SendFlowerResp) obj).number;
        }

        public final int getNumber() {
            return this.number;
        }

        public int hashCode() {
            return this.number;
        }

        public String toString() {
            return "SendFlowerResp(number=" + this.number + ')';
        }
    }

    /* compiled from: FlowerLoader.kt */
    /* loaded from: classes4.dex */
    public static final class UserGift {
        private final String name;
        private final int num;

        public UserGift(String name, int i2) {
            kotlin.jvm.internal.s.h(name, "name");
            this.name = name;
            this.num = i2;
        }

        public static /* synthetic */ UserGift copy$default(UserGift userGift, String str, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = userGift.name;
            }
            if ((i3 & 2) != 0) {
                i2 = userGift.num;
            }
            return userGift.copy(str, i2);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.num;
        }

        public final UserGift copy(String name, int i2) {
            kotlin.jvm.internal.s.h(name, "name");
            return new UserGift(name, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UserGift) {
                UserGift userGift = (UserGift) obj;
                return kotlin.jvm.internal.s.c(this.name, userGift.name) && this.num == userGift.num;
            }
            return false;
        }

        public final String getName() {
            return this.name;
        }

        public final int getNum() {
            return this.num;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.num;
        }

        public String toString() {
            return "UserGift(name=" + this.name + ", num=" + this.num + ')';
        }
    }

    static {
        String str = Inspire.f11203d;
        SEND_FLOWER_URL = kotlin.jvm.internal.s.q(str, "/comment/gift/addFlower");
        USER_PROFILE_URL = kotlin.jvm.internal.s.q(str, ProfileLoader.PERSONAL_PROFILE_URL);
        GIFT_LIST_URL = kotlin.jvm.internal.s.q(str, "/user/Gifts/list");
        USER_GIFT_URL = kotlin.jvm.internal.s.q(str, "/user/gifts/getUserGifts?userId=");
        FLOWER_NUM_UNLOGIN = 6;
    }

    private FlowerLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshFlowerCount$lambda-1  reason: not valid java name */
    public static final Integer m189refreshFlowerCount$lambda1(List list) {
        UserGift userGift;
        UserGift userGift2;
        int i2 = 0;
        if ((list == null ? 0 : list.size()) > 0) {
            Integer num = null;
            if (kotlin.jvm.internal.s.c("flower", (list == null || (userGift = (UserGift) list.get(0)) == null) ? null : userGift.getName())) {
                if (list != null && (userGift2 = (UserGift) list.get(0)) != null) {
                    num = Integer.valueOf(userGift2.getNum());
                }
                flowerNum = num.intValue();
                us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("flowerNum:", Integer.valueOf(flowerNum)), new Object[0]);
                i2 = flowerNum;
            }
        }
        return Integer.valueOf(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshGiftList$lambda-5  reason: not valid java name */
    public static final GiftResp m190refreshGiftList$lambda5(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        GiftResp giftResp = (GiftResp) list.get(0);
        SharedPreferences.Editor edit = Inspire.c().edit();
        edit.putString("flower_product_id", giftResp.getProductId());
        edit.putString("flower_price", giftResp.getPrice());
        edit.apply();
        return giftResp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshGiftList$lambda-6  reason: not valid java name */
    public static final void m191refreshGiftList$lambda6(GiftResp giftResp) {
        StringBuilder sb = new StringBuilder();
        sb.append("refreshGiftList,id:");
        sb.append((Object) (giftResp == null ? null : giftResp.getProductId()));
        sb.append(" price:");
        sb.append((Object) (giftResp != null ? giftResp.getPrice() : null));
        us.pinguo.common.log.a.k(sb.toString(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshUserProfileForFlowerAndAccountH5$lambda-2  reason: not valid java name */
    public static final Integer m193refreshUserProfileForFlowerAndAccountH5$lambda2(FlowerResp flowerResp) {
        List<FlowerGift> gifts;
        FlowerAuthorInfo authorInfo = flowerResp.getAuthorInfo();
        int i2 = 0;
        FlowerGift flowerGift = (authorInfo == null || (gifts = authorInfo.getGifts()) == null) ? null : gifts.get(0);
        Inspire.c().edit().putString("accountH5Switch", flowerResp.getAccountH5Switch()).apply();
        Inspire.c().edit().putString("accountBalance", flowerResp.getAccountRangkingAward() == 1 ? "" : flowerResp.getAccountBalance()).apply();
        if (kotlin.jvm.internal.s.c("flower", flowerGift != null ? flowerGift.getName() : null)) {
            kotlin.jvm.internal.s.e(flowerGift);
            flowerNum = flowerGift.getNum();
            us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("flowerNum:", Integer.valueOf(flowerNum)), new Object[0]);
            i2 = flowerNum;
        }
        return Integer.valueOf(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshUserProfileForFlowerAndAccountH5$lambda-3  reason: not valid java name */
    public static final void m194refreshUserProfileForFlowerAndAccountH5$lambda3(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendFlower$lambda-0  reason: not valid java name */
    public static final Integer m196sendFlower$lambda0(SendFlowerResp sendFlowerResp) {
        flowerNum = sendFlowerResp.getNumber();
        return Integer.valueOf(sendFlowerResp.getNumber());
    }

    public final String getAccountBalence() {
        String string = Inspire.c().getString("accountBalance", "");
        return string == null ? "" : string;
    }

    public final String getAccountH5Switch() {
        String string = Inspire.c().getString("accountH5Switch", "");
        return string == null ? "" : string;
    }

    public final int getFLOWER_NUM_UNLOGIN() {
        return FLOWER_NUM_UNLOGIN;
    }

    public final int getFlowerNum() {
        return flowerNum;
    }

    public final GiftResp getGiftResp() {
        SharedPreferences c = Inspire.c();
        String string = c.getString("flower_product_id", "challenge_gift_flowers");
        String str = string == null ? "challenge_gift_flowers" : string;
        String string2 = c.getString("flower_price", "$0.99");
        return new GiftResp("", str, 0, string2 == null ? "$0.99" : string2, "");
    }

    public final Observable<Integer> refreshFlowerCount() {
        Observable<Integer> map = us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<List<? extends UserGift>>>() { // from class: us.pinguo.inspire.module.profile.FlowerLoader$refreshFlowerCount$builder$1
        }.url(kotlin.jvm.internal.s.q(USER_GIFT_URL, us.pinguo.user.s0.getInstance().getUserId())).setCacheKey(String.valueOf(System.nanoTime())).build()).map(new Payload()).map(g.a);
        kotlin.jvm.internal.s.g(map, "observe<BaseResponse<Lis…      }\n                }");
        return map;
    }

    public final void refreshGiftList() {
        us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<List<? extends GiftResp>>>() { // from class: us.pinguo.inspire.module.profile.FlowerLoader$refreshGiftList$builder$1
        }.url(GIFT_LIST_URL).setCacheKey(String.valueOf(System.nanoTime())).build()).map(new Payload()).map(c.a).subscribe(b.a, d.a);
    }

    public final void refreshUserProfileForFlowerAndAccountH5() {
        us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<FlowerResp>>() { // from class: us.pinguo.inspire.module.profile.FlowerLoader$refreshUserProfileForFlowerAndAccountH5$builder$1
        }.url(USER_PROFILE_URL).setCacheKey(String.valueOf(System.nanoTime())).build()).map(new Payload()).map(a.a).subscribe(e.a, f.a);
    }

    public final Observable<Integer> sendFlower(String workId) {
        kotlin.jvm.internal.s.h(workId, "workId");
        Observable<Integer> map = us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<SendFlowerResp>>() { // from class: us.pinguo.inspire.module.profile.FlowerLoader$sendFlower$builder$1
        }.url(SEND_FLOWER_URL).put(GuestProfileFragment.USER_ID, us.pinguo.user.s0.getInstance().getUserId()).put(DiscoveryHotVideoFragment.WORK_ID, workId).setCacheKey(String.valueOf(System.nanoTime())).build()).map(new Payload()).map(h.a);
        kotlin.jvm.internal.s.g(map, "observe<BaseResponse<Sen….number\n                }");
        return map;
    }

    public final void setFlowerNum(int i2) {
        flowerNum = i2;
    }
}
