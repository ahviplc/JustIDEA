package com.lc.utils;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.WeakCache;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * JinRiShiCiUtil 今日诗词工具类
 * <p>
 * 天气接口 : https://v2.jinrishici.com/info
 * 代码:
 * String res = HttpUtil.get(" https://v2.jinrishici.com/info", CharsetUtil.CHARSET_UTF_8);
 * 返回:
 * {"status":"success","data":{"token":"WBZad8M/ONjRfcbmux7BFx72WLYRSVWP","ip":"222.69.221.144","region":"上海|上海","weatherData":null,"tags":["中午","长江","白天","华东","江南","荷花","夏"],"beijingTime":"2021-07-06T12:52:05.837254"}}
 * <p>
 * token接口: https://v2.jinrishici.com/token
 * 返回:
 * {
 * "status": "success",
 * "data": "RgU1rBKtLym/MhhYIXs42WNoqLyZeXY3EkAcDNrcfKkzj8ILIsAP1Hx0NGhdOO1I"
 * }
 * <p>
 * 古诗词接口: https://v2.jinrishici.com/sentence
 * <p>
 * 返回:
 * {
 * "data": {
 * "origin": {
 * "author": "张若虚",
 * "title": "春江花月夜",
 * "content": [
 * "春江潮水连海平，海上明月共潮生。",
 * "滟滟随波千万里，何处春江无月明！",
 * "江流宛转绕芳甸，月照花林皆似霰。",
 * "空里流霜不觉飞，汀上白沙看不见。",
 * "江天一色无纤尘，皎皎空中孤月轮。",
 * "江畔何人初见月，江月何年初照人？",
 * "人生代代无穷已，江月年年只相似。",
 * "不知江月待何人，但见长江送流水。",
 * "白云一片去悠悠，青枫浦上不胜愁。",
 * "谁家今夜扁舟子，何处相思明月楼？",
 * "可怜楼上月徘徊，应照离人妆镜台。",
 * "玉户帘中卷不去，捣衣砧上拂还来。",
 * "此时相望不相闻，愿逐月华流照君。",
 * "鸿雁长飞光不度，鱼龙潜跃水成文。",
 * "昨夜闲潭梦落花，可怜春半不还家。",
 * "江水流春去欲尽，江潭落月复西斜。",
 * "斜月沉沉藏海雾，碣石潇湘无限路。",
 * "不知乘月几人归，落月摇情满江树。"
 * ],
 * "translate": [
 * "春天的江潮水势浩荡，与大海连成一片，一轮明月从海上升起，好像与潮水一起涌出来。",
 * "月光照耀着春江，随着波浪闪耀千万里，所有地方的春江都有明亮的月光。",
 * "江水曲曲折折地绕着花草丛生的原野流淌，月光照射着开遍鲜花的树林好像细密的雪珠在闪烁。",
 * "月色如霜，所以霜飞无从觉察。洲上的白沙和月色融合在一起，看不分明。",
 * "江水、天空成一色，没有一点微小灰尘，明亮的天空中只有一轮孤月高悬空中。",
 * "江边上什么人最初看见月亮，江上的月亮哪一年最初照耀着人？",
 * "人生一代代地无穷无尽，只有江上的月亮一年年地总是相像。",
 * "不知江上的月亮等待着什么人，只见长江不断地一直运输着流水。",
 * "游子像一片白云缓缓地离去，只剩下思妇站在离别的青枫浦不胜忧愁。",
 * "哪家的游子今晚坐着小船在漂流？什么地方有人在明月照耀的楼上相思？",
 * "可怜楼上不停移动的月光，应该照耀着离人的梳妆台。",
 * "月光照进思妇的门帘，卷不走，照在她的捣衣砧上，拂不掉。",
 * "这时互相望着月亮可是互相听不到声音，我希望随着月光流去照耀着您。",
 * "鸿雁不停地飞翔，而不能飞出无边的月光；月照江面，鱼龙在水中跳跃，激起阵阵波纹。",
 * "昨天夜里梦见花落闲潭，可惜的是春天过了一半自己还不能回家。",
 * "江水带着春光将要流尽，水潭上的月亮又要西落。",
 * "斜月慢慢下沉，藏在海雾里，碣石与潇湘的离人距离无限遥远。",
 * "不知有几人能趁着月光回家，唯有那西落的月亮摇荡着离情，洒满了江边的树林。"
 * ],
 * "dynasty": "唐代"
 * },
 * "matchTags": [
 * ],
 * "cacheAt": "2021-07-06T13:33:06.140387",
 * "recommendedReason": "",
 * "content": "春江潮水连海平，海上明月共潮生。",
 * "popularity": 1140000,
 * "id": "5b8b9572e116fb3714e6fa31"
 * },
 * "ipAddress": "222.69.221.144",
 * "token": "pu3D1xNq2qBt5vP1/X6WMG+Fr/s1blzW",
 * "warning": "接口侦测到来自您 IP 的异常流量，已主动下调推荐效果，请正确配置接口，携带 Token 并正常发送请求。一小时内自动恢复。",
 * "status": "success"
 * }
 */
public class JinRiShiCiUtil {
	// 古诗词接口url
	private static String url = "https://v2.jinrishici.com/sentence";

	public static String getOne() {

		// 链式构建get请求
		String res = HttpRequest.get(url)
				.header("X-User-Token", getToken())//头信息，多个头信息多次调用此方法即可
				.execute().body();
		// Console.log("...JinRiShiCi...getOne...", JSONUtil.toJsonPrettyStr(res));
		JSONObject jsonObject = JSONUtil.parseObj(res);
		if (!jsonObject.get("status").toString().equals("success")) {
			Console.log("...JinRiShiCi...getOne...error", jsonObject.get("status").toString(), jsonObject.get("errMessage").toString());
			return "";
		}
		JSONObject dataJsonObj = (JSONObject) jsonObject.get("data");
		return dataJsonObj.get("content").toString();
	}

	public static String getToken() {
		// 缓存失效时长， 0 表示无限制，单位毫秒
		WeakCache<Object, Object> cacheObj = CacheUtil.newWeakCache(0);

		// 如果缓存 token 不存在 则请求获取 把其放入缓存中
		if (!cacheObj.containsKey("token")) {
			// 现获取 token
			String tokenRes = HttpUtil.get("https://v2.jinrishici.com/token", CharsetUtil.CHARSET_UTF_8);
			JSONObject tokenJsonObj = JSONUtil.parseObj(tokenRes);
			cacheObj.put("token", tokenJsonObj.get("data").toString());
		}
		// 如果存在 直接 return
		return cacheObj.get("token").toString();
	}

	public static void main(String[] args) {
		String one = getOne();
		Console.log("one Poem", one);
	}
}
