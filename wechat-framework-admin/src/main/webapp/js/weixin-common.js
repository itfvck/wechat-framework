/**
 * 微信JS-SDK
 * 
 * @author lidong
 */

var url = window.location.href;
signatureJSSDK();
// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
wx.error(function(res) {
	console.log(res);
});

wx.ready(function() {
	// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。

//	wx.hideAllNonBaseMenuItem();
//	wx.showMenuItems({
//		menuList : [ "menuItem:share:appMessage", "menuItem:share:timeline" ]
//	// 要显示的菜单项，所有menu项见附录3
//	});

	/**
	 * 调用成功时："xxx:ok" ，其中xxx为调用的接口名 用户取消时："xxx:cancel"，其中xxx为调用的接口名 调用失败时：其值为具体错误信息
	 */
	/**
	 * 分享代码请复制到具体页面修改
	 */
// 获取“分享到朋友圈”按钮点击状态及自定义分享内容接口
/*	wx.onMenuShareTimeline({
		title : '分享到朋友圈', // 分享标题
		link : url, // 分享链接
		imgUrl : '', // 分享图标
		success : function(res) {
			// 用户确认分享后执行的回调函数
			console.log("success:" + res);
		},
		cancel : function(res) {
			// 用户取消分享后执行的回调函数
			console.log("cancel:" + res);
		},
		trigger : function(res) {
			// 监听Menu中的按钮点击时触发的方法，该方法仅支持Menu中的相关接口
			console.log("trigger:" + res);
		},
		fail : function(res) {
			// 接口调用失败时执行的回调函数
			console.log("fail:" + res);
		},
		complete : function(res) {
			console.log("complete:" + res);
			// 接口调用完成时执行的回调函数，无论成功或失败都会执行。
			if (res.errMsg.indexOf("onMenuShareTimeline:ok") > 0) {
				alert("分享成功");
			} else {
				alert(res.errMsg);
			}
		}
	});
	
// 获取“分享给朋友”按钮点击状态及自定义分享内容接口
	wx.onMenuShareAppMessage({
		title : '分享给朋友', // 分享标题
		desc : '获取“分享给朋友”按钮点击状态及自定义分享内容接口', // 分享描述
		link : url, // 分享链接
		imgUrl : '', // 分享图标
		type : '', // 分享类型,music、video或link，不填默认为link
		dataUrl : '', // 如果type是music或video，则要提供数据链接，默认为空
		success : function(res) {
			// 用户确认分享后执行的回调函数
			console.log("success:" + res);
			if (res.errMsg.indexOf("onMenuShareTimeline:ok") > 0) {
				alert("分享成功");
			} else {
				alert(res.errMsg);
			}
		},
		cancel : function(res) {
			// 用户取消分享后执行的回调函数
			console.log("cancel:" + res);
		},
		trigger : function(res) {
			// 监听Menu中的按钮点击时触发的方法，该方法仅支持Menu中的相关接口
			console.log("trigger:" + res);
		},
		fail : function(res) {
			// 接口调用失败时执行的回调函数
			console.log("fail:" + res);
		},
		complete : function(res) {
			console.log("complete:" + res);
			// 接口调用完成时执行的回调函数，无论成功或失败都会执行。
		}
	});*/
});

function shareCallBack(url,param){
	$.ajax({
		type : 'POST',
		url : url,
		data : param,
		dataType : 'json',
		success : function(data) {
			var result = data.result;
			if (result) {
				
			}
		}
	});
}



/**
 * 微信微信JS-SDK验证
 */
function signatureJSSDK() {
	$.ajax({
		type : 'POST',
		url : CONTEXT + 'wechat/jssdk',
		data : {
			"url" : url
		},
		dataType : 'json',
		success : function(data) {
			var result = data.result;
			if (result) {
				wx.config({
					debug : true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
					appId : result.appId, // 必填，公众号的唯一标识
					timestamp : result.timestamp, // 必填，生成签名的时间戳
					nonceStr : result.nonceStr, // 必填，生成签名的随机串
					signature : result.signature,// 必填，签名，见附录1
					jsApiList : [// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
					'onMenuShareTimeline', 'onMenuShareAppMessage',
							'onMenuShareQQ', 'onMenuShareWeibo',
							'onMenuShareQZone', 'startRecord', 'stopRecord',
							'onVoiceRecordEnd', 'playVoice', 'pauseVoice',
							'stopVoice', 'onVoicePlayEnd', 'uploadVoice',
							'downloadVoice', 'chooseImage', 'previewImage',
							'uploadImage', 'downloadImage', 'translateVoice',
							'getNetworkType', 'openLocation', 'getLocation',
							'hideOptionMenu', 'showOptionMenu',
							'hideMenuItems', 'showMenuItems',
							'hideAllNonBaseMenuItem', 'showAllNonBaseMenuItem',
							'closeWindow', 'scanQRCode', 'chooseWXPay',
							'openProductSpecificView', 'addCard', 'chooseCard',
							'openCard' ]
				});
			}
		}
	});
}

/**
 * 设置只能是微信浏览器才能打开页面
 */
function isWeiXin() {
	var browser = {
		versions : function() {
			var u = navigator.userAgent, app = navigator.appVersion;
			return { // 移动终端浏览器版本信息
				trident : u.indexOf('Trident') > -1, // IE内核
				presto : u.indexOf('Presto') > -1, // opera内核
				webKit : u.indexOf('AppleWebKit') > -1, // 苹果、谷歌内核
				gecko : u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, // 火狐内核
				mobile : !!u.match(/AppleWebKit.*Mobile.*/), // 是否为移动终端
				ios : !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), // ios终端
				android : u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, // android终端或uc浏览器
				iPhone : u.indexOf('iPhone') > -1, // 是否为iPhone或者QQHD浏览器
				iPad : u.indexOf('iPad') > -1, // 是否iPad
				webApp : u.indexOf('Safari') == -1
			// 是否web应该程序，没有头部与底部
			};
		}(),
		language : (navigator.browserLanguage || navigator.language)
				.toLowerCase()
	}

	if (browser.versions.mobile) {// 判断是否是移动设备打开。browser代码在下面
		var ua = navigator.userAgent.toLowerCase();// 获取判断用的对象
		if (ua.match(/MicroMessenger/i) == "micromessenger") {
			// 在微信中打开
		} else {
			window.location.href = CONTEXT + 'weixin/invalidBS';
			// if (ua.match(/WeiBo/i) == "weibo") {
			// //在新浪微博客户端打开
			// }
			// if (ua.match(/QQ/i) == "qq") {
			// //在QQ空间打开
			// }
			// if (browser.versions.ios) {
			// //是否在IOS浏览器打开
			// }
			// if(browser.versions.android){
			// //是否在安卓浏览器打开
			// }
		}
	} else {
		// 否则就是PC浏览器打开
		window.location.href = CONTEXT + 'wechat/invalidBs';
	}
}