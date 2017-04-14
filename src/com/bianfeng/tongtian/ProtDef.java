package com.bianfeng.tongtian;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProtDef {
	public static final String VIRTUAL_SERVER = "VIRTUAL_SERVER";

	public static final String SRS_CONNECT = "SRS_CONNECT";
	public static final String SRS_ERROR = "SRS_ERROR";
	public static final String SRS_CLOSE = "SRS_CLOSE";

	public static final String CMDT_ENCRYPTVER = "1";
	public static final String CMDT_CHECKACT = "2";
	public static final String CMDT_REQKEY = "3";
	public static final String CMDT_RESPKEY = "4";
	public static final String CMDT_PLAYERCONNECT = "5"; // SRS协议，请求登录
	public static final String CMDT_PLAYERDATA = "6"; // SRS协议，登录返回
	public static final String CMDT_REQEAUTH = "7"; // 服务端通知需要验证令牌
	public static final String CMDT_RESPEAUTH = "8"; // 客户端输入验证令牌
	public static final String CMDT_REPORTSRSERR = "9"; // SRS协议，通知其他服务错误
	public static final String GET_SRS_LOAD = "10"; // 查询SRS负载
	public static final String RE_GET_SRS_LOAD = "11"; // 服务返回SRS负载
	public static final String CMDT_REQPROCESSAPP = "12"; // 查询Process的AppId
	public static final String CMDT_RESPPROCESSAPP = "13"; // 返回Process的AppId
	public static final String CMDT_REQPLAYERPLUSDATA = "23"; // SRS协议，获取用户数据
	public static final String CMDT_RESPPLAYERPLUSDATA = "24"; // SRS协议，返回用户数据
	public static final String CMDT_REQSYNCDATA = "25"; // SRS协议，主动通知数据变更
	public static final String CMDT_PTPUSHMSG = "26"; // 服务端推送玩家的令牌信息

	public static final String DEBUG_CMDT_CONNECT = "DEBUG_CMDT_CONNECT";
	public static final String DEBUG_CMDT_ENCRYPTVER = "501";
	public static final String DEBUG_CMDT_REQKEY = "401";
	public static final String DEBUG_CMDT__RESPKEY = "402";
	public static final String DEBUG_CMDT_PLAYERCONNECT = "11001"; // 进入游戏打牌
	public static final String DEBUG_CMDT_RESP_PLAYERCONNECT = "11103"; // 进入打牌的状态结果返回

	/** 请求查询玩家游戏数据 */
	public static final String TOOL_RILVER = "12005";
	/** 返回查询玩家游戏数据 */
	public static final String RE_TOOL_RILVER = "12006";
	/** 请求房间人数 */
	public static final String TOOL_NUMPLAYERS = "12044";
	/** 返回房间人数 */
	public static final String RE_TOOL_NUMPLAYERS = "12045";

	public static final String TOOL_TEMP_SESSION = "12007";

	public static final String RE_TOOL_TEMP_SESSION = "12008";

	public static final String GET_PROP_ATTRS = "12009";

	public static final String RE_GET_PROP_ATTRS = "12010";

	public static final String USE_EPROPS = "12050";

	public static final String RE_USE_EPROPS = "12051";

	/** 请求存取款 */
	public static final String TRANSFER_SILVER = "11060";
	public static final String RE_TRANSFER_SILVER = "11061";
	/** 离开房间 */
	public static final String LEAVE_ROOM = "11073";
	/** 服务器响应离开房间 */
	public static final String RE_LEAVE_ROOM = "11074";
	/** 请求进入房间 */
	public static final String JOIN_ROOM = "11007";
	/** SRS协议，响应请求进入房间 */
	public static final String RE_JOIN_ROOM = "11008";
	/** 请求房间内操作 */
	public static final String ROOM_ACTION = "11016";
	/** 响应房间内操作 */
	public static final String RE_ROOM_ACTION = "11017";
	/** 服务端推送桌子信息 */
	public static final String RE_TABLE_INFO = "11014";
	/** 服务端推送玩家信息 */
	public static final String RE_USER_INFO = "11009";
	/** 服务端通知进入房间成功 */
	public static final String RE_JOIN_ROOM_COMPLETE = "11041";
	/** 设置玩家限制(限制同桌密码IP等) */
	public static final String PLAYER_SET_LIMIT = "11022";
	/** 服务端更新房间状态 */
	public static final String RE_ROOM_STATE = "11027";
	/** 服务端更新玩家数据 */
	public static final String RE_PLAYER_NUM_INFO = "11028";
	/** 服务端通知客户端是否可以开始游戏 */
	public static final String RE_SERVER_READY = "11013";
	/** 检测游戏客户端版本号 */
	public static final String CHECK_VER = "113";
	/** 响应检测游戏客户端版本号 */
	public static final String RE_CHECK_VER = "114";
	/** 连接游戏服务器 */
	public static final String CONNECT_GS = "11100";
	/** 响应连接游戏服务器 */
	public static final String RE_CONNECT_GS = "11103";
	/** 通知客户端操作 */
	public static final String NOTICE_CLIENT_ACTION = "11049";
	/** 通知客户端玩家进入排队状态 */
	public static final String NOTICE_CLIENT_WAITING_LIST = "11104";

	/** 加入比赛模式 */
	public static final String JOIN_MATCH_GAME = "11601";
	/** 返回加入比赛模式 */
	public static final String RE_JOIN_MATCH_GAME = "11602";
	/** 当前比赛连接数 */
	public static final String MATCH_PLAYER_COUNT = "11603";
	/** 当前比赛玩家信息 */
	public static final String MATCH_PLAYER_INFO = "11604";
	/** 比赛提示信息 */
	public static final String MATCH_HINT = "11605";
	/** 请求更新玩家积分(暂时当做READY在用，不支持单独发送) */
	public static final String REQ_COIN = "11062";
	public static final String RESP_COIN = "11063";
	/** 房间心跳 */
	public static final String ROOM_CHECKACT = "11079";

	public static final String PROCESS_CUT = "-";
	public static final String MATCH_CFG_PROCESS = "11"
			+ ProtDef.PROCESS_CUT;
	public static final String MATCH_PROCESS = "12"
			+ ProtDef.PROCESS_CUT;

	/** 加入前缀的process，将强制使用符合式的Action指令接收服务端消息 */
	private static final int[] PROCESS_PREFIX_array = { 11, 12 };
	public static final Set PROCESS_PREFIX = new HashSet(Arrays.asList(PROCESS_PREFIX_array));

	/** 模块服务端的PROCESSID */
	public static final int MS_PROCESSID = 1006;
	/** 模块服务端的APPID */
	public static final int MS_APPID = 0;
	/** 发送到模块服务端的指令，5位数字，21开头 */
	public static final String TO_MS_PREFIX = "21";
	/** 从模块服务端接收的指令，5位数字，22开头 */
	public static final String RE_MS_PREFIX = "22";
	/** 发送到公告服务器的指令，HTTP短连接，5位数字，3开头 */
	public static final String NS_PREFIX = "3";

	public static final String TEST = ProtDef.TO_MS_PREFIX + "999";

	/** 连接比赛配置服 */
	public static final String JOIN_MATCH_CFG = ProtDef.MATCH_CFG_PROCESS
			+ "1";

	public static final String RE_JOIN_MATCH_CFG = ProtDef.MATCH_CFG_PROCESS
			+ "2";
	/** 推送比赛配置列表 */
	public static final String MATCH_CONFIG_LIST = ProtDef.MATCH_CFG_PROCESS
			+ "3";
	/** 客户端获取当前比赛的SUBID */
	public static final String GET_MATCH_LIST = ProtDef.MATCH_CFG_PROCESS
			+ "4";

	public static final String RE_GET_MATCH_LIST = ProtDef.MATCH_CFG_PROCESS
			+ "5";
	/** 更新比赛人数 */
	public static final String UPDATE_MATCH_SINGUPS = ProtDef.MATCH_CFG_PROCESS
			+ "7";

	public static final String MATCH_CFG_CHECKACT = ProtDef.MATCH_CFG_PROCESS
			+ "9";

	public static final String JOIN_MATCH = ProtDef.MATCH_PROCESS + "1";

	public static final String RE_JOIN_MATCH = ProtDef.MATCH_PROCESS
			+ "2";

	public static final String SIGN_UP_MATCH = ProtDef.MATCH_PROCESS
			+ "3";

	public static final String RE_SIGN_UP_MATCH = ProtDef.MATCH_PROCESS
			+ "4";
	/** 客户端发送取消报名 */
	public static final String CANCEL_SIGNUP = ProtDef.MATCH_PROCESS
			+ "5";
	/** 服务端返回发送取消报名 */
	public static final String RE_CANCEL_SIGNUP = ProtDef.MATCH_PROCESS
			+ "6";

	public static final String MATCH_REWARD = ProtDef.MATCH_PROCESS
			+ "11";

	public static final String MATCH_CHECKACT = ProtDef.MATCH_PROCESS
			+ "12";
	/** 在比赛开始的时候发送给客户端（广播给报名过的玩家） */
	public static final String MATCH_WHEEL_INFO = ProtDef.MATCH_PROCESS
			+ "15";
	/** 在比赛完成结算的时候发送给客户端 */
	public static final String MATCH_WHEEL_REWARD = ProtDef.MATCH_PROCESS
			+ "16";

	public static final String CHAT_MSG = "107"; // 房间聊天

	/** 游戏服务器通信协议发送 */
	public static final String TO_GS = "11201";
	/** 游戏服务器通信协议返回 */
	public static final String RE_GS = "11200";
	/** 发送 游戏服务器二级通信协议 前缀 */
	public static final String TO_GS_PREFIX = ProtDef.TO_GS + ".";
	/** 接收 游戏服务器二级通信协议 前缀 */
	public static final String RE_GS_PREFIX = ProtDef.RE_GS + ".";
	/* 服务器推送错误代 */
	public static final String ERROR_CODE = ProtDef.RE_GS_PREFIX
			+ "2000";
	/** 准备开始 */
	public static final String GAME_READY = ProtDef.TO_GS_PREFIX + "9";
	/** 获取牌桌具体信息 - 玩家、座位信息 */
	public static final String MATCH_ADD = ProtDef.RE_GS_PREFIX + "1100"; // 进入桌子
	/** 玩家操作 */
	public static final String MATCH_ACTION = ProtDef.TO_GS_PREFIX
			+ "1101";
	/** 推送牌局开始 */
	public static final String MATCH_S_START = ProtDef.RE_GS_PREFIX
			+ "1102";
	/** 推送新一圈开始 */
	public static final String MATCH_S_NEWSTART = ProtDef.RE_GS_PREFIX
			+ "1103";
	/** 推送收到底牌 */
	public static final String MATCH_S_GETCARD = ProtDef.RE_GS_PREFIX
			+ "1104";
	/** 收到玩家动作 */
	public static final String MATCH_S_PLAYACT = ProtDef.RE_GS_PREFIX
			+ "1105";
	/** 牌局结束 */
	public static final String MATCH_S_OVER = ProtDef.RE_GS_PREFIX
			+ "1106";
	/** 进入桌子 */
	// public public static final String MATCH_ENTER_TABLE =
	// ProtocolDefine.RE_GS_PREFIX + "1123";
	/** 系统发牌 */
	public static final String TEXAS_SHOW_CARD = ProtDef.RE_GS_PREFIX
			+ "1107";
	/** 推送桌子坐下 */
	public static final String MATCH_S_SIT = ProtDef.RE_GS_PREFIX
			+ "1108";
	/** 推送桌子站起 */
	public static final String MATCH_S_UP = ProtDef.RE_GS_PREFIX
			+ "1109";
	/** 推送请求带入 */
	public static final String MATCH_S_TAKEIN = ProtDef.RE_GS_PREFIX
			+ "1111";
	/** 收到请求带入 */
	public static final String MATCH_TAKEIN = ProtDef.TO_GS_PREFIX
			+ "1110";
	/** 牌局聊天客户端发 */
	public static final String MATCH_CHAT = ProtDef.TO_GS_PREFIX
			+ "1112";
	/** 牌局服务端推送聊天 */
	public static final String MATCH_S_CHAT = ProtDef.RE_GS_PREFIX
			+ "1113";
	/** 牌局打赏客户端发 */
	public static final String MATCH_SEND_GIFT = ProtDef.TO_GS_PREFIX
			+ "1114";
	/** 牌局服务端推送打赏 */
	public static final String MATCH_S_SEND_GIFT = ProtDef.RE_GS_PREFIX
			+ "1115";
	/** 牌局亮牌 */
	public static final String MATCH_SHOW_CARD = ProtDef.TO_GS_PREFIX
			+ "1117";
	/** 牌局内玩家银子变化 */
	public static final String MATCH_MONEY_CHANGE = ProtDef.RE_GS_PREFIX
			+ "1118";
	/** 站起围观后发送心跳 */
	public static final String MATCH_HEART_BEAT = ProtDef.TO_GS_PREFIX
			+ "1119";
	/** 私人房开启数据统计 (c->s) */
	public static final String MATCH_OPEN_INFO = ProtDef.TO_GS_PREFIX
			+ "1120";
	/** 获取数据统计(c->s) */
	public static final String MATCH_GET_INFO = ProtDef.TO_GS_PREFIX
			+ "1121";
	/** 收到数据统计(S->C) */
	public static final String MATCH_S_GET_INFO = ProtDef.RE_GS_PREFIX
			+ "1122";
	/** 服务端推送修改过的前注额 (c->s) */
	public static final String MATCH_ANTE = ProtDef.RE_GS_PREFIX
			+ "1124";
	/** 是否在房间(c->s) */
	public static final String MATC_IN_TABLE = ProtDef.TO_GS_PREFIX
			+ "1127";
	/** 是否在房间(S->C) */
	public static final String MATC_S_IN_TABLE = ProtDef.RE_GS_PREFIX
			+ "1128";
	/** 被托管(S->C) */
	public static final String MATC_S_IS_TRUSTEE = ProtDef.RE_GS_PREFIX
			+ "1129";
	/** 房间坐下 */
	public static final String MATCH_SIT = ProtDef.TO_GS_PREFIX + "2002";
	/** 离开房间 */
	public static final String MATCH_OUT = ProtDef.TO_GS_PREFIX + "2003";
	// /** 创建房间 */
	// public public static final String MATCH_CREATE =
	// ProtocolDefine.TO_GS_PREFIX + "2004";
	/** 房间站起 */
	public static final String MATCH_UP = ProtDef.TO_GS_PREFIX + "1116";
	/** 房主开始 */
	// public public static final String MATCH_START =
	// ProtocolDefine.TO_GS_PREFIX + "2008";
	/** 牌局结束 */
	public static final String PUSH_DISMISS_TABLE = ProtDef.TO_GS_PREFIX
			+ "2106";
	/** 推送进入桌子 */
	public static final String MATCH_S_ADDTABLE = ProtDef.RE_GS_PREFIX
			+ "2101";
	// /**推送离开桌子**/
	// public public static final String MATCH_S_OUTTABLE =
	// ProtocolDefine.RE_GS_PREFIX +"2102";
	/** 修改个人标签信息 */
	public static final String MODIFY_LABEL_INFO = ProtDef.TO_GS_PREFIX
			+ "3002";

	/** 心跳(c->s) */
	public static final String GLXY_REQ_HEART_BEAT = ProtDef.TO_GS_PREFIX
			+ "10000";
	/** 下注(c->s) */
	public static final String GLXY_REQ_ANTE = ProtDef.TO_GS_PREFIX
			+ "10001";
	/** 上庄(c->s) */
	public static final String GLXY_REQ_BECOME_BANKER = ProtDef.TO_GS_PREFIX
			+ "10002";
	/** 下庄(c->s) */
	public static final String GLXY_REQ_CHANGE_BANKER = ProtDef.TO_GS_PREFIX
			+ "10003";
	/** 桌面位置坐下(c->s) */
	public static final String GLXY_REQ_ADD_SHOW_POS = ProtDef.TO_GS_PREFIX
			+ "10004";
	/** 桌面位置站起(c->s) */
	public static final String GLXY_REQ_SUB_SHOW_POS = ProtDef.TO_GS_PREFIX
			+ "10005";

	/** 历史输赢(c->s) */
	public static final String GLXY_REQ_WIN_HISTORY = ProtDef.TO_GS_PREFIX
			+ "10006";

	/** 下注(s->c) */
	public static final String GLXY_RESP_ANTE = ProtDef.RE_GS_PREFIX
			+ "20001";
	/** 上庄(s->c) */
	public static final String GLXY_RESP_BECOME_BANKER = ProtDef.RE_GS_PREFIX
			+ "20002";
	/** 下庄(s->c) */
	public static final String GLXY_RESP_CHANGE_BANKER = ProtDef.RE_GS_PREFIX
			+ "20003";
	/** 桌子信息(s->c) */
	public static final String GLXY_RESP_TABLE_VO = ProtDef.RE_GS_PREFIX
			+ "20004";
	/** 有人进入(s->c) */
	public static final String GLXY_RESP_PLAYER_ENTER = ProtDef.RE_GS_PREFIX
			+ "20005";
	/** 有人离开(s->c) */
	public static final String GLXY_RESP_PLAYER_LEAVE = ProtDef.RE_GS_PREFIX
			+ "20006";
	/** 游戏结算(s->c) */
	public static final String GLXY_RESP_GAME_END = ProtDef.RE_GS_PREFIX
			+ "20008";
	/** 游戏开始(s->c) */
	public static final String GLXY_RESP_GAME_START = ProtDef.RE_GS_PREFIX
			+ "20007";
	/** 上庄列表(s->c) */
	public static final String GLXY_RESP_BANK_WAITER = ProtDef.RE_GS_PREFIX
			+ "20009";
	/** 桌面位置坐下(s->c) */
	public static final String GLXY_RESP_ADD_SHOW_POS = ProtDef.RE_GS_PREFIX
			+ "20010";
	/** 桌面位置站起(s->c) */
	public static final String GLXY_RESP_SUB_SHOW_POS = ProtDef.RE_GS_PREFIX
			+ "20011";
	/** 欢乐城聊天客户端发 */
	public static final String GLXY_REQ_CHAT = ProtDef.TO_GS_PREFIX
			+ "10007";
	/** 欢乐城服务端推送聊天 */
	public static final String GLXY_RESP_CHAT = ProtDef.RE_GS_PREFIX
			+ "20013";
	/** 历史输赢(s->c) */
	public static final String GLXY_RESP_WIN_HISTORY = ProtDef.RE_GS_PREFIX
			+ "20012";
	/** 猜手牌(C->S */
	public static final String GLXY_MESSAGEVO_REQ_GUESS_CARD = ProtDef.TO_GS_PREFIX
			+ "1130";
	/*** 猜手牌(S->C) */
	public static final String GLXY_MESSAGEVO_RESP_GUESS_CARD = ProtDef.RE_GS_PREFIX
			+ "1131";
	/** 猜手牌获奖(S->C) */
	public static final String GLXY_MESSAGEVO_RESP_GUESS_CARD_WIN = ProtDef.RE_GS_PREFIX
			+ "1132";
	/** 奖池 */
	public static final String BULLETIN = "BULLETIN";
	/** 公告信息 */
	public static final String NOTICE_ADD = "31000";
	public static final String NOTICE_DEL = "31001";
	public static final String NOTICE_GET = "31002";
	public static final String NOTICE_GET_MANY = "31003";
	/** 新邮件数 */
	public static final String IMS_READ_NUM = "31012";
	/** 获取邮件 */
	public static final String IMS_GETS = "31011";
	/** 读邮件 */
	public static final String IMS_READ = "31013";

	/** 保存收藏牌局 */
	public static final String DZ_RECORD_ADD = "31004";// 加
	public static final String DZ_RECORD_DEL = "31005";// 删
	public static final String DZ_RECORD_GET = "31006";
	public static final String DZ_RECORD_GET_MANY = "31007";// 获取全部

	/** 举报 */
	public static final String DZ_FEEDBACK_ADD = "31008";
	/** 获取收藏录像数据 */
	public static final String DZ_RECODE_GETVO = "31009";
	/** 获取举报录像数据 */
	public static final String DZ_FEEDBACK_GETVO = "31010";

	/** 头像 */
	public static final String GET_HEAD_INFO = ProtDef.TO_MS_PREFIX
			+ "001";
	public static final String RE_GET_HEAD_INFO = ProtDef.RE_MS_PREFIX
			+ "001";

	public static final String PROCESS_XYID_REQ_GET_USER_LIST = ProtDef.TO_MS_PREFIX
			+ "017";// 查看玩家数据
	public static final String PROCESS_XYID_RESP_GET_USER_LIST = ProtDef.RE_MS_PREFIX
			+ "017";// 查看玩家数据

	public static final String SET_HEAD_INFO = ProtDef.TO_MS_PREFIX
			+ "002";// 设置
	public static final String RE_SET_HEAD_INFO = ProtDef.RE_MS_PREFIX
			+ "002";// 设置

	public static final String SET_PLAY_INFO = ProtDef.TO_MS_PREFIX
			+ "003";// 查看玩家数据
	public static final String RE_SET_PLAY_INFO = ProtDef.RE_MS_PREFIX
			+ "003";// 查看玩家数据

	public static final String REQ_DI_BAO = "12049";
	public static final String RESP_AWARD_INFO = "12046";

	public static final String BUY_SILVER = "400";
	public static final String BUY_VIP = "401";

	// 好友
	public static final String REQ_GET_USER_FRIEND = "21004"; // 获得用户好友
	public static final String RESP_GET_USER_FRIEND = "22004"; // 获得用户好友返回
	public static final String REQ_SEARCH_USER_FRIEND = "21005"; // 搜索用户ID
	public static final String RESP_SEARCH_USER_FRIEND = "22005"; // 搜索用户ID返回
	public static final String REQ_ADD_USER_FRIEND_REQUEST = "21006"; // 添加好友申请
	public static final String RESP_ADD_USER_FRIEND_REQUEST = "22006"; // 添加好友申请返回
	public static final String REQ_ADD_USER_FRIEND_DELETE = "21008"; // 删除好友
	public static final String RESP_ADD_USER_FRIEND_DELETE = "22008"; // 删除好友返回
	public static final String REQ_ADD_USER_FRIEND = "21009"; // 同意添加好友
	public static final String RESP_ADD_USER_FRIEND = "22009"; // 同意添加好友返回
	public static final String REQ_ADD_USER_FRIEND_FACE2FACE = "21007"; // 面对面加好友
	public static final String RESP_ADD_USER_FRIEND_FACE2FACE = "22007"; // 面对面加好友返回
	public static final String REQ_GET_USER_FRIEND_REQUEST = "21010"; // 获得好友申请列表
	public static final String RESP_GET_USER_FRIEND_REQUEST = "22010"; // 获得好友申请列表返回
	public static final String REQ_ADD_FACE2FACE_FRIEND = "21011"; // 互加好友
	public static final String RESP_ADD_FACE2FACE_FRIEND = "22011"; // 互加好友返回
	public static final String REQ_INVITE_FRIEND = "21012"; // 邀请好友
	public static final String RESP_INVITE_FRIEND = "22012"; // 邀请好友返回
	public static final String REQ_REFUSE_ADD_FRIEND = "21013"; // 拒绝添加好友
	public static final String RESP_REFUSE_ADD_FRIEND = "22013"; // 拒绝添加好友返回

	public static final String REQ_CHANGE_USER_STATUS = "21015"; // 更改玩家状态
	public static final String RESP_CHANGE_USER_STATUS = "22015"; // 更改玩家状态返回

	public static final String GAME_CONFIG = "31015"; // 获取登陆前游戏
	public static final String GAME_LOGIN = "31016"; // 登陆
	public static final String GAME_LOGOUT = "31017"; // 离开
	public static final String GOGO_NOTICE_GET_MANY = "31018"; // 播放跑马灯
	public static final String GOGO_NOTICE_GET_REFLUSH = "22016"; // 游戏内自定模块推

	public static final String REQ_BILL_GET = "21014"; // 账单
	public static final String RESP_BILL_GET = "22014"; // 账单返回

}
