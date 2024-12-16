package com.smant.common.redis.constants;

/**
 * 缓存有效期
 */
public final class CacheExpire {

    public static final long EXPIRE_1S = 1l;
    public static final long EXPIRE_1MIN = 60 * EXPIRE_1S;
    public static final long EXPIRE_5MIN = 5 * 60 * EXPIRE_1S;
    public static final long EXPIRE_10MIN = 10 * 60 * EXPIRE_1S;
    public static final long EXPIRE_15MIN = 15 * 60 * EXPIRE_1S;
    public static final long EXPIRE_30MIN = 30 * 60 * EXPIRE_1S;
    public static final long EXPIRE_1H = 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_2H = 2 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_12H = 12 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_24H = 24 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_1D = 24 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_5D = 5 * 24 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_7D = 7 * 24 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_10D = 10 * 24 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_15D = 15 * 24 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_20D = 20 * 24 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_30D = 30 * 24 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_1M = 30 * 24 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_6M = 6 * 30 * 24 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_12M = 12 * 30 * 24 * 60 * 60 * EXPIRE_1S;
    public static final long EXPIRE_1Y = 365 * EXPIRE_1D;
    public static final long EXPIRE_2Y = 2 * 365 * EXPIRE_1D;
    public static final long EXPIRE_5Y = 5 * 365 * EXPIRE_1D;
    public static final long EXPIRE_10Y = 10 * 365 * EXPIRE_1D;
}
