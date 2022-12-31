package com.facebook.ads.internal.checkerframework.checker.nullness.qual;

import com.facebook.ads.internal.checkerframework.framework.qual.DefaultFor;
import com.facebook.ads.internal.checkerframework.framework.qual.DefaultInUncheckedCodeFor;
import com.facebook.ads.internal.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import com.facebook.ads.internal.checkerframework.framework.qual.QualifierForLiterals;
import com.facebook.ads.internal.checkerframework.framework.qual.SubtypeOf;
import com.facebook.ads.internal.checkerframework.framework.qual.UpperBoundFor;
import com.facebook.ads.redexgen.X.C8D;
import com.facebook.ads.redexgen.X.C8E;
import com.facebook.ads.redexgen.X.EnumC06697z;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@SubtypeOf({MonotonicNonNull.class})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@UpperBoundFor(typeKinds = {C8D.A0I, C8D.A0C, C8D.A04, C8D.A06, C8D.A08, C8D.A0B, C8D.A0E, C8D.A0J, C8D.A05})
@Retention(RetentionPolicy.RUNTIME)
@QualifierForLiterals({EnumC06697z.A0B})
@DefaultFor({C8E.A05})
@DefaultQualifierInHierarchy
@DefaultInUncheckedCodeFor({C8E.A0E, C8E.A0C})
@Documented
/* loaded from: assets/audience_network.dex */
public @interface NonNull {
}
