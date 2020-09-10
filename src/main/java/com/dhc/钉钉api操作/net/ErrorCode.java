package com.dhc.钉钉api操作.net;

public class ErrorCode {

    /** 联运订单待支付 */
    public static final int INTERMODAL_NOT_PAY = 0;

    /**联运订单支付成功  */
    public static final int INTERMODAL_PAY_SUCCESS = 1;

    /**联运订单已关闭/退款 */
    public static final int INTERMODAL_CLOSE_OR_REFOUND = 2;

    /** 成功 */
    public static final int SUCCESS = 200;

    /**失败 */
    public static final int FAIL = 100;

    /** 错误: 参数异常 */
    public static final int ERROR_INVALID_PARAMS = 800;

    /** 错误: 未知原因 */
    public static final int ERROR_CODE_UNKOWN = 1000;

    /** 错误：无效用户 */
    public static final int ERROR_CODE_INVALID_UUID    = 1001;
    /** 错误: 登录session无效 */
    public static final int ERROR_CODE_INVALID_SESSION = 1002;

    /** 错误: 数据库插入失败 */
    public static final int ERROR_CODE_DB_INSERT = 2001;
    /** 错误: 数据库更新失败 */
    public static final int ERROR_CODE_DB_UPDATE = 2002;
    /** 错误: 数据库查询失败 */
    public static final int ERROR_CODE_DB_QUERY = 2003;
    /** 错误: 参数无效(联运商ID) */
    public static final int ERROR_CODE_INVALID_ID             = 2101;
    /** 错误: 参数无效(联运商账号) */
    public static final int ERROR_CODE_INVALID_ACCOUNT        = 2102;
    /** 错误: 参数无效(联运商联系人) */
    public static final int ERROR_CODE_INVALID_CONTACTNAME    = 2103;
    /** 错误: 参数无效(联运商联系电话) */
    public static final int ERROR_CODE_INVALID_CONTACTPHONE   = 2104;
    /** 错误: 参数无效(联运商联系邮箱) */
    public static final int ERROR_CODE_INVALID_CONTACTEMAIL   = 2105;
    /** 错误: 参数无效(联运商联系地址) */
    public static final int ERROR_CODE_INVALID_CONTACTADDRESS = 2106;
    /** 错误: 参数无效(联运商开发类型) */
    public static final int ERROR_CODE_INVALID_DEVELOPTYPE    = 2107;
    /** 错误：参数无效(注册公司名称已存在) */
    public static final int ERROR_CODE_INVALID_COMPANY        = 2108;
    /** 错误：参数无效(注册公司地址为空) */
    public static final int ERROR_CODE_INVALID_COMPANYADDRESS = 2109;

    /** 错误: 参数无效(联运游戏GID) */
    public static final int ERROR_CODE_INVALID_GID            = 2121;
    /** 错误: 参数无效(联运游戏CPID) */
    public static final int ERROR_CODE_INVALID_CPID           = 2122;
    /** 错误: 参数无效(联运游戏appKey) */
    public static final int ERROR_CODE_INVALID_APPKEY         = 2123;
    /** 错误: 参数无效(联运游戏状态) */
    public static final int ERROR_CODE_INVALID_APPSTATUS      = 2124;
    /** 错误: 参数无效(游戏包名) */
    public static final int ERROR_CODE_INVALID_PKG            = 2125;
    /** 错误: 广告信息不存在 */
    public static final int ERROR_CODE_INVALID_PARAM            = 2126;
    /** 错误：参数无效(更新时未传appKey或appSecret或cpId) */
    public static final int ERROR_CODE_INVALID_PARAMS         = 2125;
    /** 错误：参数无效(appKey和包名对应的status无效) */
    public static final int ERROR_CODE_INVALID_STATUS         = 2127;
    /** 错误：参数无效(app Name无效) */
    public static final int ERROR_CODE_INVALID_APPNAME         = 2128;
    /**错误：游戏未上架或没查到**/
    public static final int ERROR_CODE_GAME_NOT_ON_SHELVES         = 2129;
    /**错误：调用其他服务失败**/
    public static final int ERROR_CODE_INVOKE_OTHER_SERVICE_         = 2130;


    /** 错误: 参数无效(支付类型) */
    public static final int ERROR_CODE_INVALID_PAYTYPE = 3001;
    /** 错误: 参数无效(时间) */
    public static final int ERROR_CODE_INVALID_TIME    = 3002;
    /** 错误: 参数无效(签名) */
    public static final int ERROR_CODE_INVALID_SIGN    = 3003;
    /** 错误: 参数无效(订单ID) */
    public static final int ERROR_CODE_INVALID_ORDERID = 3004;
    /** 错误: 参数无效(代金券ID) */
    public static final int ERROR_CODE_INVALID_VOUCHERID = 3005;
    /** 错误: 参数无效(游戏ID未在内容库找到) */
    public static final int ERROR_CODE_INVALID_GAME = 3006;
    /** 错误: 参数无效(随机数非法) */
    public static final int ERROR_CODE_INVALID_RANDOM = 3007;
    /** 错误: 微信签名生成无效 */
    public static final int ERROR_CODE_WXSIGN_INVALID  = 3011;
    /** 错误: 微信签名不匹配 */
    public static final int ERROR_CODE_WXSIGN_MISMATCH = 3012;

    /** 错误: 微信下单请求失败 */
    public static final int ERROR_CODE_WX_CREATE_ORDER_FAIL = 3022;
    /** 错误: 下单请求失败 */
    public static final int ERROR_CODE_CREATE_ORDER_FAIL = 3023;

    /** 错误: 微信查询订单请求失败 */
    public static final int ERROR_CODE_WX_QUERY_ORDER_FAIL        = 3031;
    /** 错误: 微信查询订单系统错误 */
    public static final int ERROR_CODE_WX_QUERY_ORDER_SYSTEMERROR = 3032;
    /** 微信订单状态: 转入退款 */
    public static final int ERROR_CODE_WX_QUERY_ORDER_REFUND      = 3033;
    /** 微信订单状态: 未支付 */
    public static final int ERROR_CODE_WX_QUERY_ORDER_NOTPAY      = 3034;
    /** 微信订单状态: 已关闭 */
    public static final int ERROR_CODE_WX_QUERY_ORDER_CLOSED      = 3035;
    /** 微信订单状态: 已撤销(刷卡支付) */
    public static final int ERROR_CODE_WX_QUERY_ORDER_REVOKED     = 3036;
    /** 微信订单状态: 用户支付中 */
    public static final int ERROR_CODE_WX_QUERY_ORDER_USERPAYING  = 3037;
    /** 微信订单状态: 支付失败(其他原因) */
    public static final int ERROR_CODE_WX_QUERY_ORDER_PAYERROR    = 3038;

    /** 错误: 微信关闭订单请求失败 */
    public static final int ERROR_CODE_WX_CLOSE_ORDER_FAIL        = 3041;
    /** 错误: 微信关闭订单系统错误 */
    public static final int ERROR_CODE_WX_CLOSE_ORDER_SYSTEMERROR = 3042;

    /** 错误: 微信申请退款请求失败 */
    public static final int ERROR_CODE_WX_PAY_REFUND_FAIL        = 3051;
    /** 错误: 微信申请退款系统错误 */
    public static final int ERROR_CODE_WX_PAY_REFUND_SYSTEMERROR = 3052;

    /** 错误: 微信查询退款请求失败 */
    public static final int ERROR_CODE_WX_QUERY_REFUND_FAIL        = 3061;
    /** 错误: 微信查询退款系统错误 */
    public static final int ERROR_CODE_WX_QUERY_REFUND_SYSTEMERROR = 3062;
    /** 微信退款状态: 退款关闭 */
    public static final int ERROR_CODE_WX_QUERY_REFUND_CLOSE       = 3053;
    /** 微信退款状态: 退款处理中 */
    public static final int ERROR_CODE_WX_QUERY_REFUND_PROCESSING  = 3054;
    /** 微信退款状态: 退款异常 */
    public static final int ERROR_CODE_WX_QUERY_REFUND_CHANGE      = 3055;

    /** 错误: 微信下载对账单请求失败 */
    public static final int ERROR_CODE_WX_DOWNLOAD_BILL_FAIL     = 3071;
    /** 错误: 微信下载资金帐单请求失败 */
    public static final int ERROR_CODE_WX_DOWNLOAD_FUNDFLOW_FAIL = 3072;

    /** 错误: 微信拉取订单评价数据请求失败 */
    public static final int ERROR_CODE_WX_QUERY_COMMENT_FAIL = 3081;

    /** 错误: 微信交易保障报告失败 */
    public static final int ERROR_CODE_WX_REPORT_FAIL = 3090;

    /** 错误：重复下单 */
    public static final int ERROR_CODE_LOCK_FAIL = 3100;

}
