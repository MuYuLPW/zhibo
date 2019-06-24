package com.muyu.zhibo.utils;

import android.app.Activity;

import com.muyu.zhibo.HomeActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JSUtils {
    private static final String JAVA_CALL_JS_FUNCTION = "//======================工具js\n" +
            "\n" +
            "\n" +
            "//动画滚动\n" +
            "function animationScroll(scrollTop,time) {\n" +
            "    if(scrollTop<0){\n" +
            "        scrollTop=0;\n" +
            "    }\n" +
            "    if(scrollTop>(getScrollHeight()-getWindowHeight())){\n" +
            "        scrollTop=getScrollHeight()-getWindowHeight();\n" +
            "    }\n" +
            "\n" +
            "    var orgScollTop=  getScrollTop(),\n" +
            "        scrollHeight = orgScollTop-scrollTop,\n" +
            "        scrollStep = Math.PI / ( time / 15 ),\n" +
            "        cosParameter = scrollHeight / 2,\n" +
            "        scrollCount = 0,\n" +
            "        scrollMargin;\n" +
            "\n" +
            "    requestAnimationFrame(step);\n" +
            "    function step () {\n" +
            "        setTimeout(function() {\n" +
            "\n" +
            "            //if ( orgScollTop-getScrollTop()<scrollHeight) {\n" +
            "            if ( (scrollHeight>0&&orgScollTop-getScrollTop()<scrollHeight)||(scrollHeight<0&&orgScollTop-getScrollTop()>scrollHeight)) {\n" +
            "                    requestAnimationFrame(step);\n" +
            "                    scrollCount = scrollCount + 1;\n" +
            "                    scrollMargin = cosParameter - cosParameter * Math.cos( scrollCount * scrollStep );\n" +
            "                    window.scrollTo( 0, ( getScrollTop() - scrollMargin ) );\n" +
            "                }\n" +
            "        }, 15 );\n" +
            "    }\n" +
            "}\n" +
            "//动画滚动\n" +
            "function animationScroll1(scrollTop,time){\n" +
            "    if(scrollTop<0){\n" +
            "        return;\n" +
            "    }\n" +
            "    time=time||1200;\n" +
            "    var orgScollTop=  getScrollTop();\n" +
            "    var scrollHeight = orgScollTop-scrollTop;\n" +
            "    var stepNum=time/15;\n" +
            "    var scrollMargin=Math.round(scrollHeight/stepNum);\n" +
            "\n" +
            "    requestAnimationFrame(function(){step(time)});\n" +
            "    function step (remainTime) {\n" +
            "        if(remainTime<0){\n" +
            "            window.scrollTo(0,scrollTop);\n" +
            "        }else{\n" +
            "            if(orgScollTop-getScrollTop()<=scrollHeight){\n" +
            "                window.scrollTo( 0, ( getScrollTop() - scrollMargin ) );\n" +
            "                setTimeout(function(){\n" +
            "                    requestAnimationFrame(function(){step(remainTime-15)});\n" +
            "                },15);\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "}\n" +
            "\n" +
            "function animationScroll2(scrollTop,time){\n" +
            "\n" +
            "    //document.body.style.transition=\"all 1s ease\";\n" +
            "    //document.body.style.marginTop=(scrollTop-getScrollTop())+'px';\n" +
            "    //document.body.style.transition=\"none\";\n" +
            "    //document.body.scrollTop=scrollTop;\n" +
            "    //document.body.style.marginTop=0;\n" +
            "\n" +
            "}\n" +
            "\n" +
            "function add(a, b) {\n" +
            "    var c, d, e;\n" +
            "    try {\n" +
            "        c = a.toString().split(\".\")[1].length;\n" +
            "    } catch (f) {\n" +
            "        c = 0;\n" +
            "    }\n" +
            "    try {\n" +
            "        d = b.toString().split(\".\")[1].length;\n" +
            "    } catch (f) {\n" +
            "        d = 0;\n" +
            "    }\n" +
            "    return e = Math.pow(10, Math.max(c, d)), (mul(a, e) + mul(b, e)) / e;\n" +
            "}\n" +
            "\n" +
            "function sub(a, b) {\n" +
            "    var c, d, e;\n" +
            "    try {\n" +
            "        c = a.toString().split(\".\")[1].length;\n" +
            "    } catch (f) {\n" +
            "        c = 0;\n" +
            "    }\n" +
            "    try {\n" +
            "        d = b.toString().split(\".\")[1].length;\n" +
            "    } catch (f) {\n" +
            "        d = 0;\n" +
            "    }\n" +
            "    return e = Math.pow(10, Math.max(c, d)), (mul(a, e) - mul(b, e)) / e;\n" +
            "}\n" +
            "\n" +
            "function mul(a, b) {\n" +
            "    var c = 0,\n" +
            "        d = a.toString(),\n" +
            "        e = b.toString();\n" +
            "    try {\n" +
            "        c += d.split(\".\")[1].length;\n" +
            "    } catch (f) {}\n" +
            "    try {\n" +
            "        c += e.split(\".\")[1].length;\n" +
            "    } catch (f) {}\n" +
            "    return Number(d.replace(\".\", \"\")) * Number(e.replace(\".\", \"\")) / Math.pow(10, c);\n" +
            "}\n" +
            "\n" +
            "function div(a, b) {\n" +
            "    var c, d, e = 0,\n" +
            "        f = 0;\n" +
            "    try {\n" +
            "        e = a.toString().split(\".\")[1].length;\n" +
            "    } catch (g) {}\n" +
            "    try {\n" +
            "        f = b.toString().split(\".\")[1].length;\n" +
            "    } catch (g) {}\n" +
            "    return c = Number(a.toString().replace(\".\", \"\")), d = Number(b.toString().replace(\".\", \"\")), mul(c / d, Math.pow(10, f - e));\n" +
            "}\n" +
            "\n" +
            "function getImgWh(url,callback) {\n" +
            "    var img = new Image();\n" +
            "    img.src = url;\n" +
            "    if (img.complete) {\n" +
            "        callback(img.width, img.height);\n" +
            "    } else {\n" +
            "        img.onload = function () {\n" +
            "            callback(img.width, img.height);\n" +
            "            img.onload = null;\n" +
            "        };\n" +
            "        //test去连的时候 读不到文件\n" +
            "        img.onerror =function(){\n" +
            "            callback(200,400);\n" +
            "            img.onerror = null;\n" +
            "        }\n" +
            "    };\n" +
            "};\n" +
            "\n" +
            "//检查手机号码\n" +
            "function checkMobileNum(mobileNum){\n" +
            "//  if (mobileNum.length != 11) {\n" +
            "//  \treturn false;\n" +
            "//  }\n" +
            "    return true;\n" +
            "}\n" +
            "function getScrollTop(){\n" +
            "    var scrollTop = 0, bodyScrollTop = 0, documentScrollTop = 0;\n" +
            "    if(document.body){\n" +
            "        bodyScrollTop = document.body.scrollTop;\n" +
            "    }\n" +
            "    if(document.documentElement){\n" +
            "        documentScrollTop = document.documentElement.scrollTop;\n" +
            "    }\n" +
            "    scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;\n" +
            "    return scrollTop;\n" +
            "}\n" +
            "\n" +
            "//文档的总高度\n" +
            "function getScrollHeight(){\n" +
            "    var scrollHeight = 0, bodyScrollHeight = 0, documentScrollHeight = 0;\n" +
            "    if(document.body){\n" +
            "        bodyScrollHeight = document.body.scrollHeight;\n" +
            "    }\n" +
            "    if(document.documentElement){\n" +
            "        documentScrollHeight = document.documentElement.scrollHeight;\n" +
            "    }\n" +
            "    scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;\n" +
            "    return scrollHeight;\n" +
            "}\n" +
            "\n" +
            "//浏览器视口的高度\n" +
            "function getWindowHeight(){\n" +
            "    var windowHeight = 0;\n" +
            "    if(document.compatMode == \"CSS1Compat\"){\n" +
            "        windowHeight = document.documentElement.clientHeight;\n" +
            "    }else{\n" +
            "        windowHeight = document.body.clientHeight;\n" +
            "    }\n" +
            "    return windowHeight;\n" +
            "}\n" +
            "\n" +
            "function util_randomSort(oArr) {\n" +
            "    if(oArr.length==0){\n" +
            "        return oArr;\n" +
            "    }\n" +
            "    var temp_x; //临时交换数\n" +
            "    var tArr = oArr.slice(0);//新数组,复制原数组\n" +
            "    var random_x;\n" +
            "    for(var i=oArr.length;i>0;i--) {\n" +
            "        random_x = Math.floor(Math.random()*i); //   取得一个随机数\n" +
            "        temp_x = tArr[random_x];\n" +
            "        tArr[random_x] = tArr[i-1];\n" +
            "        tArr[i-1] = temp_x;\n" +
            "    }\n" +
            "    return tArr; //返回新数组\n" +
            "}\n" +
            "\n" +
            "\n" +
            "function doNothing() {\n" +
            "}\n" +
            "\n" +
            "//检查是否是数字\n" +
            "function isNum(num){\n" +
            "    if(!(/^\\d*$/.test(num))){\n" +
            "        return false;\n" +
            "    }\n" +
            "    return true;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "function isBlack(data) {\n" +
            "    return (data == \"\" || typeof(data)  == \"undefined\" || data == null || isNullJson(data)) ? true : false;\n" +
            "}\n" +
            "\n" +
            "function isNotBlack(data) {\n" +
            "    return (data == \"\" || typeof(data)  == \"undefined\"|| data == null || isNullJson(data)) ? false : true;\n" +
            "}\n" +
            "\n" +
            "function isFunction(func) {\n" +
            "    if (typeof(func) == \"function\") {\n" +
            "    \t\treturn true;\n" +
            "    }\n" +
            "    return false;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "function isArray(o) {\n" +
            "    return Object.prototype.toString.call(o) === '[object Array]';\n" +
            "}\n" +
            "\n" +
            "function isObject(obj) {\n" +
            " \treturn obj instanceof Object;\n" +
            "}\n" +
            "\n" +
            "function isNullJson(obj) {\n" +
            "    return isJson(obj) && JSON.stringify(obj) == '{}';\n" +
            "}\n" +
            "function isJson(obj) {\n" +
            "    return typeof(obj) == \"object\" &&\n" +
            "        Object.prototype.toString.call(obj).toLowerCase() == \"[object object]\" && !obj.length;\n" +
            "}\n" +
            "var deepCopy= function(source) {\n" +
            "    var result={};\n" +
            "    for (var key in source) {\n" +
            "        result[key] = typeof source[key]==='object'? deepCopy(source[key]): source[key];\n" +
            "    }\n" +
            "    return result;\n" +
            "}\n" +
            "\n" +
            "String.prototype.replaceAll = function (reallyDo, replaceWith, ignoreCase) {\n" +
            "    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {\n" +
            "        return this.replace(new RegExp(reallyDo, (ignoreCase ? \"gi\" : \"g\")), replaceWith);\n" +
            "    } else {\n" +
            "        return this.replace(reallyDo, replaceWith);\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "String.prototype.startWith = function (str) {\n" +
            "    if (str == null || str == \"\" || this.length == 0 || str.length > this.length)\n" +
            "        return false;\n" +
            "    if (this.substr(0, str.length) == str)\n" +
            "        return true;\n" +
            "    else\n" +
            "        return false;\n" +
            "    return true;\n" +
            "}\n" +
            "String.prototype.endWith = function (str) {\n" +
            "    if (str == null || str == \"\" || this.length == 0 || str.length > this.length)\n" +
            "        return false;\n" +
            "    if (this.substring(this.length - str.length) == str)\n" +
            "        return true;\n" +
            "    else\n" +
            "        return false;\n" +
            "    return true;\n" +
            "}\n" +
            "\n" +
            "Array.prototype.contains = function(obj) {\n" +
            "    var i = this.length;\n" +
            "    while (i--) {\n" +
            "        if (this[i] == obj) {\n" +
            "            return true;\n" +
            "        }\n" +
            "    }\n" +
            "    return false;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "Array.prototype.remove = function(obj) {\n" +
            "    for(var i=0;i<this.length;i++){\n" +
            "        if (this[i] == obj) {\n" +
            "            this.splice(i, 1);\n" +
            "        }\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "Date.prototype.format = function (format) {\n" +
            "    var o = {\n" +
            "        \"M+\": this.getMonth() + 1, //month\n" +
            "        \"d+\": this.getDate(), //day\n" +
            "        \"h+\": this.getHours(), //hour\n" +
            "        \"m+\": this.getMinutes(), //minute\n" +
            "        \"s+\": this.getSeconds(), //second\n" +
            "        \"q+\": Math.floor((this.getMonth() + 3) / 3), //quarter\n" +
            "        \"S\": this.getMilliseconds() //millisecond\n" +
            "    }\n" +
            "\n" +
            "    if (/(y+)/.test(format)) {\n" +
            "        format = format.replace(RegExp.$1, (this.getFullYear() + \"\").substr(4 - RegExp.$1.length));\n" +
            "    }\n" +
            "\n" +
            "    for (var k in o) {\n" +
            "        if (new RegExp(\"(\" + k + \")\").test(format)) {\n" +
            "            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : (\"00\" + o[k]).substr((\"\" + o[k]).length));\n" +
            "        }\n" +
            "    }\n" +
            "    return format;\n" +
            "}\n" +
            "\n" +
            "//使用方法\n" +
            "//var now = new Date();\n" +
            "//var nowStr = now.format(\"yyyy-MM-dd hh:mm:ss\");\n" +
            "\n" +
            "function parseDate(str) {\n" +
            "    if (typeof str == 'string') {\n" +
            "        var results = str.match(/^ *(\\d{4})-(\\d{1,2})-(\\d{1,2}) *$/);\n" +
            "        if (results && results.length > 3) {\n" +
            "            return new Date(parseInt(results[1], 10), (parseInt(results[2], 10) - 1), parseInt(results[3], 10));\n" +
            "        }\n" +
            "        results = str.match(/^ *(\\d{4})-(\\d{1,2})-(\\d{1,2}) +(\\d{1,2}):(\\d{1,2}):(\\d{1,2}) *$/);\n" +
            "        if (results && results.length > 6)\n" +
            "            return new Date(parseInt(results[1], 10), parseInt(results[2], 10) - 1, parseInt(results[3], 10), parseInt(results[4], 10), parseInt(results[5], 10), parseInt(results[6], 10));\n" +
            "        results = str.match(/^ *(\\d{4})-(\\d{1,2})-(\\d{1,2}) +(\\d{1,2}):(\\d{1,2}):(\\d{1,2})\\.(\\d{1,9}) *$/);\n" +
            "        if (results && results.length > 7)\n" +
            "            return new Date(parseInt(results[1], 10), parseInt(results[2], 10) - 1, parseInt(results[3], 10), parseInt(results[4], 10), parseInt(results[5], 10), parseInt(results[6], 10), parseInt(results[7], 10));\n" +
            "    }\n" +
            "    return null;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n" +
            "/**\n" +
            " * 阻止事件冒泡\n" +
            " * @param event\n" +
            " */\n" +
            "function stopEventBubble(event) {\n" +
            "    var e = event || window.event;\n" +
            "\n" +
            "    if (e && e.stopPropagation) {\n" +
            "        e.stopPropagation();\n" +
            "    }\n" +
            "    else {\n" +
            "        if(e) {\n" +
            "            e.cancelBubble = true;\n" +
            "        }\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "//获取文件后缀名字 (返回.jpg)\n" +
            "function getFileSuffix(file_name){\n" +
            "    var result =/\\.[^\\.]+/.exec(file_name);\n" +
            "    return result;\n" +
            "}\n" +
            "\n" +
            "//获取随机数字\n" +
            "//var num = GetRandomNum(1,10);\n" +
            "function getRandomNum(Min,Max)\n" +
            "{\n" +
            "    var Range = Max - Min;\n" +
            "    var Rand = Math.random();\n" +
            "    return(Min + Math.round(Rand * Range));\n" +
            "}\n" +
            "\n" +
            "\n" +
            "function formatDate(time) {\n" +
            "    var day = new Date(time);\n" +
            "    var Year = 0;\n" +
            "    var Month = 0;\n" +
            "    var Day = 0;\n" +
            "    var CurrentDate = \"\";\n" +
            "    //初始化时间\n" +
            "    //Year= day.getYear();//有火狐下2008年显示108的bug\n" +
            "    Year = day.getFullYear(); //ie火狐下都可以\n" +
            "    Month = day.getMonth() + 1;\n" +
            "    Day = day.getDate();\n" +
            "    //Hour = day.getHours();\n" +
            "    // Minute = day.getMinutes();\n" +
            "    // Second = day.getSeconds();\n" +
            "    CurrentDate += Year + \"\";\n" +
            "    if (Month >= 10) {\n" +
            "        CurrentDate += Month + \"\";\n" +
            "    } else {\n" +
            "        CurrentDate += \"0\" + Month + \"\";\n" +
            "    }\n" +
            "    if (Day >= 10) {\n" +
            "        CurrentDate += Day;\n" +
            "    } else {\n" +
            "        CurrentDate += \"0\" + Day;\n" +
            "    }\n" +
            "    return CurrentDate;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "//格式化现在得日期\n" +
            "function getNowFormatDate() {\n" +
            "    var day = new Date();\n" +
            "    var Year = 0;\n" +
            "    var Month = 0;\n" +
            "    var Day = 0;\n" +
            "    var CurrentDate = \"\";\n" +
            "    //初始化时间\n" +
            "    //Year= day.getYear();//有火狐下2008年显示108的bug\n" +
            "    Year = day.getFullYear(); //ie火狐下都可以\n" +
            "    Month = day.getMonth() + 1;\n" +
            "    Day = day.getDate();\n" +
            "    //Hour = day.getHours();\n" +
            "    // Minute = day.getMinutes();\n" +
            "    // Second = day.getSeconds();\n" +
            "    CurrentDate += Year + \"\";\n" +
            "    if (Month >= 10) {\n" +
            "        CurrentDate += Month + \"\";\n" +
            "    } else {\n" +
            "        CurrentDate += \"0\" + Month + \"\";\n" +
            "    }\n" +
            "    if (Day >= 10) {\n" +
            "        CurrentDate += Day;\n" +
            "    } else {\n" +
            "        CurrentDate += \"0\" + Day;\n" +
            "    }\n" +
            "    return CurrentDate;\n" +
            "}\n" +
            "\n" +
            "//得到聊天的时间\n" +
            "function getChatTime(begin, end , Interface) {\n" +
            "    var weekday = new Array(7);\n" +
            "    weekday[0] = \"星期天\";\n" +
            "    weekday[1] = \"星期一\";\n" +
            "    weekday[2] = \"星期二\";\n" +
            "    weekday[3] = \"星期三\";\n" +
            "    weekday[4] = \"星期四\";\n" +
            "    weekday[5] = \"星期五\";\n" +
            "    weekday[6] = \"星期六\";\n" +
            "    var time;\n" +
            "    var time2;\n" +
            "    if (begin.getYear() == end.getYear()) {//如果年相等继续\n" +
            "        if (begin.getMonth() == end.getMonth()) {//如果月相等继续\n" +
            "            if (begin.getDate() == end.getDate()) {//是不是今天\n" +
            "                time = hour(begin) + minute(begin);\n" +
            "                time2 = hour(begin) + minute(begin);\n" +
            "                //是就显示时分\n" +
            "            } else {//不是就判断是不是昨天\n" +
            "                end.setHours(0);\n" +
            "                end.setMinutes(0);\n" +
            "                end.setSeconds(0);\n" +
            "                end.setMilliseconds(0);\n" +
            "                var Differ = end - begin;\n" +
            "                if (parseInt(Differ / 3600000) <= 24) {\n" +
            "                    time = '昨天';\n" +
            "                    time2 = '昨天  ' + hour(begin) + minute(begin);\n" +
            "                } else {//不是昨天一周之内就显示星期几不然就具体时间\n" +
            "                    if (parseInt(Differ / 3600000) <= 144) {\n" +
            "                        time = day(weekday, begin);\n" +
            "                        time2 =day(weekday, begin)+ ' ' + hour(begin) + minute(begin);\n" +
            "                    } else {\n" +
            "                        time =  month(begin) + date(begin);\n" +
            "                        time2 =  month(begin) + date(begin)+ ' ' + hour(begin) + minute(begin);\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "        } else {//月不等，直接显示\n" +
            "            time = month(begin) + date(begin);\n" +
            "            time2 = month(begin) + date(begin)+ ' ' + hour(begin) + minute(begin);\n" +
            "        }\n" +
            "    } else {//年不等，直接显示\n" +
            "        time = year(begin) + month(begin) + date(begin);\n" +
            "        time2 = year(begin) + month(begin) + date(begin);\n" +
            "    }\n" +
            "    if(Interface==0){\n" +
            "        return time;\n" +
            "    }else{\n" +
            "        return time2;\n" +
            "    }\n" +
            "\n" +
            "}\n" +
            "\n" +
            "function year(date) {\n" +
            "    return date.getFullYear() + '-';\n" +
            "}\n" +
            "\n" +
            "function month(date) {\n" +
            "    var tt = date.getMonth() + 1;\n" +
            "    if (tt < 10) {\n" +
            "        tt = '0' + tt;\n" +
            "    }\n" +
            "    return tt + '-';\n" +
            "}\n" +
            "\n" +
            "function date(date) {\n" +
            "    var tt = date.getDate();\n" +
            "    if (tt < 10) {\n" +
            "        tt = '0' + tt;\n" +
            "    }\n" +
            "    return tt + ' ';\n" +
            "}\n" +
            "\n" +
            "function hour(date) {\n" +
            "    var tt = date.getHours();\n" +
            "    if (tt < 10) {\n" +
            "        tt = '0' + tt;\n" +
            "    }\n" +
            "    return tt + ':';\n" +
            "}\n" +
            "\n" +
            "function minute(date) {\n" +
            "    var tt = date.getMinutes();\n" +
            "    if (tt < 10) {\n" +
            "        tt = '0' + tt;\n" +
            "    }\n" +
            "    return tt;\n" +
            "}\n" +
            "\n" +
            "function day(weekday, date) {\n" +
            "    return weekday[date.getDay()];\n" +
            "}\n" +
            "\n" +
            "\n" +
            "function indexOf(arr, str) {\n" +
            "    // 如果可以的话，调用原生方法\n" +
            "    if (arr && arr.indexOf) {\n" +
            "        return arr.indexOf(str);\n" +
            "    }\n" +
            "    var len = arr.length;\n" +
            "    for (var i = 0; i < len; i++) {\n" +
            "        // 定位该元素位置\n" +
            "        if (arr[i] == str) {\n" +
            "            return i;\n" +
            "        }\n" +
            "    }\n" +
            "    // 数组中不存在该元素\n" +
            "    return -1;\n" +
            "}\n" +
            "\n" +
            "function base64_encode(str) {\n" +
            "    var c1, c2, c3;\n" +
            "    var base64EncodeChars = \"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\";\n" +
            "    var i = 0, len = str.length, string = '';\n" +
            "\n" +
            "    while (i < len) {\n" +
            "        c1 = str.charCodeAt(i++) & 0xff;\n" +
            "        if (i == len) {\n" +
            "            string += base64EncodeChars.charAt(c1 >> 2);\n" +
            "            string += base64EncodeChars.charAt((c1 & 0x3) << 4);\n" +
            "            string += \"==\";\n" +
            "            break;\n" +
            "        }\n" +
            "        c2 = str.charCodeAt(i++);\n" +
            "        if (i == len) {\n" +
            "            string += base64EncodeChars.charAt(c1 >> 2);\n" +
            "            string += base64EncodeChars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xF0) >> 4));\n" +
            "            string += base64EncodeChars.charAt((c2 & 0xF) << 2);\n" +
            "            string += \"=\";\n" +
            "            break;\n" +
            "        }\n" +
            "        c3 = str.charCodeAt(i++);\n" +
            "        string += base64EncodeChars.charAt(c1 >> 2);\n" +
            "        string += base64EncodeChars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xF0) >> 4));\n" +
            "        string += base64EncodeChars.charAt(((c2 & 0xF) << 2) | ((c3 & 0xC0) >> 6));\n" +
            "        string += base64EncodeChars.charAt(c3 & 0x3F)\n" +
            "    }\n" +
            "    return string\n" +
            "}\n" +
            "\n" +
            "function base64_decode(str) {\n" +
            "    var c1, c2, c3, c4;\n" +
            "    var base64DecodeChars = new Array(\n" +
            "        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,\n" +
            "        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,\n" +
            "        -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57,\n" +
            "        58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6,\n" +
            "        7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,\n" +
            "        25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,\n" +
            "        37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1,\n" +
            "        -1, -1\n" +
            "    );\n" +
            "    var i = 0, len = str.length, string = '';\n" +
            "\n" +
            "    while (i < len) {\n" +
            "        do {\n" +
            "            c1 = base64DecodeChars[str.charCodeAt(i++) & 0xff]\n" +
            "        } while (\n" +
            "        i < len && c1 == -1\n" +
            "            );\n" +
            "\n" +
            "        if (c1 == -1) break;\n" +
            "\n" +
            "        do {\n" +
            "            c2 = base64DecodeChars[str.charCodeAt(i++) & 0xff]\n" +
            "        } while (\n" +
            "        i < len && c2 == -1\n" +
            "            );\n" +
            "\n" +
            "        if (c2 == -1) break;\n" +
            "\n" +
            "        string += String.fromCharCode((c1 << 2) | ((c2 & 0x30) >> 4));\n" +
            "\n" +
            "        do {\n" +
            "            c3 = str.charCodeAt(i++) & 0xff;\n" +
            "            if (c3 == 61)\n" +
            "                return string;\n" +
            "\n" +
            "            c3 = base64DecodeChars[c3]\n" +
            "        } while (\n" +
            "        i < len && c3 == -1\n" +
            "            );\n" +
            "\n" +
            "        if (c3 == -1) break;\n" +
            "\n" +
            "        string += String.fromCharCode(((c2 & 0XF) << 4) | ((c3 & 0x3C) >> 2));\n" +
            "\n" +
            "        do {\n" +
            "            c4 = str.charCodeAt(i++) & 0xff;\n" +
            "            if (c4 == 61) return string;\n" +
            "            c4 = base64DecodeChars[c4]\n" +
            "        } while (\n" +
            "        i < len && c4 == -1\n" +
            "            );\n" +
            "\n" +
            "        if (c4 == -1) break;\n" +
            "\n" +
            "        string += String.fromCharCode(((c3 & 0x03) << 6) | c4)\n" +
            "    }\n" +
            "    return string;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "var rotateLeft = function(lValue, iShiftBits) {\n" +
            "    return (lValue << iShiftBits) | (lValue >>> (32 - iShiftBits));\n" +
            "}\n" +
            "\n" +
            "var addUnsigned = function(lX, lY) {\n" +
            "    var lX4, lY4, lX8, lY8, lResult;\n" +
            "    lX8 = (lX & 0x80000000);\n" +
            "    lY8 = (lY & 0x80000000);\n" +
            "    lX4 = (lX & 0x40000000);\n" +
            "    lY4 = (lY & 0x40000000);\n" +
            "    lResult = (lX & 0x3FFFFFFF) + (lY & 0x3FFFFFFF);\n" +
            "    if (lX4 & lY4) return (lResult ^ 0x80000000 ^ lX8 ^ lY8);\n" +
            "    if (lX4 | lY4) {\n" +
            "        if (lResult & 0x40000000) return (lResult ^ 0xC0000000 ^ lX8 ^ lY8);\n" +
            "        else return (lResult ^ 0x40000000 ^ lX8 ^ lY8);\n" +
            "    } else {\n" +
            "        return (lResult ^ lX8 ^ lY8);\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "var F = function(x, y, z) {\n" +
            "    return (x & y) | ((~ x) & z);\n" +
            "}\n" +
            "\n" +
            "var G = function(x, y, z) {\n" +
            "    return (x & z) | (y & (~ z));\n" +
            "}\n" +
            "\n" +
            "var H = function(x, y, z) {\n" +
            "    return (x ^ y ^ z);\n" +
            "}\n" +
            "\n" +
            "var I = function(x, y, z) {\n" +
            "    return (y ^ (x | (~ z)));\n" +
            "}\n" +
            "\n" +
            "var FF = function(a, b, c, d, x, s, ac) {\n" +
            "    a = addUnsigned(a, addUnsigned(addUnsigned(F(b, c, d), x), ac));\n" +
            "    return addUnsigned(rotateLeft(a, s), b);\n" +
            "};\n" +
            "\n" +
            "var GG = function(a, b, c, d, x, s, ac) {\n" +
            "    a = addUnsigned(a, addUnsigned(addUnsigned(G(b, c, d), x), ac));\n" +
            "    return addUnsigned(rotateLeft(a, s), b);\n" +
            "};\n" +
            "\n" +
            "var HH = function(a, b, c, d, x, s, ac) {\n" +
            "    a = addUnsigned(a, addUnsigned(addUnsigned(H(b, c, d), x), ac));\n" +
            "    return addUnsigned(rotateLeft(a, s), b);\n" +
            "};\n" +
            "\n" +
            "var II = function(a, b, c, d, x, s, ac) {\n" +
            "    a = addUnsigned(a, addUnsigned(addUnsigned(I(b, c, d), x), ac));\n" +
            "    return addUnsigned(rotateLeft(a, s), b);\n" +
            "};\n" +
            "\n" +
            "var convertToWordArray = function(string) {\n" +
            "    var lWordCount;\n" +
            "    var lMessageLength = string.length;\n" +
            "    var lNumberOfWordsTempOne = lMessageLength + 8;\n" +
            "    var lNumberOfWordsTempTwo = (lNumberOfWordsTempOne - (lNumberOfWordsTempOne % 64)) / 64;\n" +
            "    var lNumberOfWords = (lNumberOfWordsTempTwo + 1) * 16;\n" +
            "    var lWordArray = Array(lNumberOfWords - 1);\n" +
            "    var lBytePosition = 0;\n" +
            "    var lByteCount = 0;\n" +
            "    while (lByteCount < lMessageLength) {\n" +
            "        lWordCount = (lByteCount - (lByteCount % 4)) / 4;\n" +
            "        lBytePosition = (lByteCount % 4) * 8;\n" +
            "        lWordArray[lWordCount] = (lWordArray[lWordCount] | (string.charCodeAt(lByteCount) << lBytePosition));\n" +
            "        lByteCount++;\n" +
            "    }\n" +
            "    lWordCount = (lByteCount - (lByteCount % 4)) / 4;\n" +
            "    lBytePosition = (lByteCount % 4) * 8;\n" +
            "    lWordArray[lWordCount] = lWordArray[lWordCount] | (0x80 << lBytePosition);\n" +
            "    lWordArray[lNumberOfWords - 2] = lMessageLength << 3;\n" +
            "    lWordArray[lNumberOfWords - 1] = lMessageLength >>> 29;\n" +
            "    return lWordArray;\n" +
            "};\n" +
            "\n" +
            "var wordToHex = function(lValue) {\n" +
            "    var WordToHexValue = \"\", WordToHexValueTemp = \"\", lByte, lCount;\n" +
            "    for (lCount = 0; lCount <= 3; lCount++) {\n" +
            "        lByte = (lValue >>> (lCount * 8)) & 255;\n" +
            "        WordToHexValueTemp = \"0\" + lByte.toString(16);\n" +
            "        WordToHexValue = WordToHexValue + WordToHexValueTemp.substr(WordToHexValueTemp.length - 2, 2);\n" +
            "    }\n" +
            "    return WordToHexValue;\n" +
            "};\n" +
            "\n" +
            "var uTF8Encode = function(string) {\n" +
            "    string = string.replace(/\\x0d\\x0a/g, \"\\x0a\");\n" +
            "    var output = \"\";\n" +
            "    for (var n = 0; n < string.length; n++) {\n" +
            "        var c = string.charCodeAt(n);\n" +
            "        if (c < 128) {\n" +
            "            output += String.fromCharCode(c);\n" +
            "        } else if ((c > 127) && (c < 2048)) {\n" +
            "            output += String.fromCharCode((c >> 6) | 192);\n" +
            "            output += String.fromCharCode((c & 63) | 128);\n" +
            "        } else {\n" +
            "            output += String.fromCharCode((c >> 12) | 224);\n" +
            "            output += String.fromCharCode(((c >> 6) & 63) | 128);\n" +
            "            output += String.fromCharCode((c & 63) | 128);\n" +
            "        }\n" +
            "    }\n" +
            "    return output;\n" +
            "};\n" +
            "\n" +
            "function hex_md5(string) {\n" +
            "    var x = Array();\n" +
            "    var k, AA, BB, CC, DD, a, b, c, d;\n" +
            "    var S11=7, S12=12, S13=17, S14=22;\n" +
            "    var S21=5, S22=9 , S23=14, S24=20;\n" +
            "    var S31=4, S32=11, S33=16, S34=23;\n" +
            "    var S41=6, S42=10, S43=15, S44=21;\n" +
            "    string = uTF8Encode(string);\n" +
            "    x = convertToWordArray(string);\n" +
            "    a = 0x67452301; b = 0xEFCDAB89; c = 0x98BADCFE; d = 0x10325476;\n" +
            "    for (k = 0; k < x.length; k += 16) {\n" +
            "        AA = a; BB = b; CC = c; DD = d;\n" +
            "        a = FF(a, b, c, d, x[k+0],  S11, 0xD76AA478);\n" +
            "        d = FF(d, a, b, c, x[k+1],  S12, 0xE8C7B756);\n" +
            "        c = FF(c, d, a, b, x[k+2],  S13, 0x242070DB);\n" +
            "        b = FF(b, c, d, a, x[k+3],  S14, 0xC1BDCEEE);\n" +
            "        a = FF(a, b, c, d, x[k+4],  S11, 0xF57C0FAF);\n" +
            "        d = FF(d, a, b, c, x[k+5],  S12, 0x4787C62A);\n" +
            "        c = FF(c, d, a, b, x[k+6],  S13, 0xA8304613);\n" +
            "        b = FF(b, c, d, a, x[k+7],  S14, 0xFD469501);\n" +
            "        a = FF(a, b, c, d, x[k+8],  S11, 0x698098D8);\n" +
            "        d = FF(d, a, b, c, x[k+9],  S12, 0x8B44F7AF);\n" +
            "        c = FF(c, d, a, b, x[k+10], S13, 0xFFFF5BB1);\n" +
            "        b = FF(b, c, d, a, x[k+11], S14, 0x895CD7BE);\n" +
            "        a = FF(a, b, c, d, x[k+12], S11, 0x6B901122);\n" +
            "        d = FF(d, a, b, c, x[k+13], S12, 0xFD987193);\n" +
            "        c = FF(c, d, a, b, x[k+14], S13, 0xA679438E);\n" +
            "        b = FF(b, c, d, a, x[k+15], S14, 0x49B40821);\n" +
            "        a = GG(a, b, c, d, x[k+1],  S21, 0xF61E2562);\n" +
            "        d = GG(d, a, b, c, x[k+6],  S22, 0xC040B340);\n" +
            "        c = GG(c, d, a, b, x[k+11], S23, 0x265E5A51);\n" +
            "        b = GG(b, c, d, a, x[k+0],  S24, 0xE9B6C7AA);\n" +
            "        a = GG(a, b, c, d, x[k+5],  S21, 0xD62F105D);\n" +
            "        d = GG(d, a, b, c, x[k+10], S22, 0x2441453);\n" +
            "        c = GG(c, d, a, b, x[k+15], S23, 0xD8A1E681);\n" +
            "        b = GG(b, c, d, a, x[k+4],  S24, 0xE7D3FBC8);\n" +
            "        a = GG(a, b, c, d, x[k+9],  S21, 0x21E1CDE6);\n" +
            "        d = GG(d, a, b, c, x[k+14], S22, 0xC33707D6);\n" +
            "        c = GG(c, d, a, b, x[k+3],  S23, 0xF4D50D87);\n" +
            "        b = GG(b, c, d, a, x[k+8],  S24, 0x455A14ED);\n" +
            "        a = GG(a, b, c, d, x[k+13], S21, 0xA9E3E905);\n" +
            "        d = GG(d, a, b, c, x[k+2],  S22, 0xFCEFA3F8);\n" +
            "        c = GG(c, d, a, b, x[k+7],  S23, 0x676F02D9);\n" +
            "        b = GG(b, c, d, a, x[k+12], S24, 0x8D2A4C8A);\n" +
            "        a = HH(a, b, c, d, x[k+5],  S31, 0xFFFA3942);\n" +
            "        d = HH(d, a, b, c, x[k+8],  S32, 0x8771F681);\n" +
            "        c = HH(c, d, a, b, x[k+11], S33, 0x6D9D6122);\n" +
            "        b = HH(b, c, d, a, x[k+14], S34, 0xFDE5380C);\n" +
            "        a = HH(a, b, c, d, x[k+1],  S31, 0xA4BEEA44);\n" +
            "        d = HH(d, a, b, c, x[k+4],  S32, 0x4BDECFA9);\n" +
            "        c = HH(c, d, a, b, x[k+7],  S33, 0xF6BB4B60);\n" +
            "        b = HH(b, c, d, a, x[k+10], S34, 0xBEBFBC70);\n" +
            "        a = HH(a, b, c, d, x[k+13], S31, 0x289B7EC6);\n" +
            "        d = HH(d, a, b, c, x[k+0],  S32, 0xEAA127FA);\n" +
            "        c = HH(c, d, a, b, x[k+3],  S33, 0xD4EF3085);\n" +
            "        b = HH(b, c, d, a, x[k+6],  S34, 0x4881D05);\n" +
            "        a = HH(a, b, c, d, x[k+9],  S31, 0xD9D4D039);\n" +
            "        d = HH(d, a, b, c, x[k+12], S32, 0xE6DB99E5);\n" +
            "        c = HH(c, d, a, b, x[k+15], S33, 0x1FA27CF8);\n" +
            "        b = HH(b, c, d, a, x[k+2],  S34, 0xC4AC5665);\n" +
            "        a = II(a, b, c, d, x[k+0],  S41, 0xF4292244);\n" +
            "        d = II(d, a, b, c, x[k+7],  S42, 0x432AFF97);\n" +
            "        c = II(c, d, a, b, x[k+14], S43, 0xAB9423A7);\n" +
            "        b = II(b, c, d, a, x[k+5],  S44, 0xFC93A039);\n" +
            "        a = II(a, b, c, d, x[k+12], S41, 0x655B59C3);\n" +
            "        d = II(d, a, b, c, x[k+3],  S42, 0x8F0CCC92);\n" +
            "        c = II(c, d, a, b, x[k+10], S43, 0xFFEFF47D);\n" +
            "        b = II(b, c, d, a, x[k+1],  S44, 0x85845DD1);\n" +
            "        a = II(a, b, c, d, x[k+8],  S41, 0x6FA87E4F);\n" +
            "        d = II(d, a, b, c, x[k+15], S42, 0xFE2CE6E0);\n" +
            "        c = II(c, d, a, b, x[k+6],  S43, 0xA3014314);\n" +
            "        b = II(b, c, d, a, x[k+13], S44, 0x4E0811A1);\n" +
            "        a = II(a, b, c, d, x[k+4],  S41, 0xF7537E82);\n" +
            "        d = II(d, a, b, c, x[k+11], S42, 0xBD3AF235);\n" +
            "        c = II(c, d, a, b, x[k+2],  S43, 0x2AD7D2BB);\n" +
            "        b = II(b, c, d, a, x[k+9],  S44, 0xEB86D391);\n" +
            "        a = addUnsigned(a, AA);\n" +
            "        b = addUnsigned(b, BB);\n" +
            "        c = addUnsigned(c, CC);\n" +
            "        d = addUnsigned(d, DD);\n" +
            "    }\n" +
            "    var tempValue = wordToHex(a) + wordToHex(b) + wordToHex(c) + wordToHex(d);\n" +
            "    return tempValue.toLowerCase();\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/**\n" +
            " * 跳转校验\n" +
            " *url：有些url不需要校验\n" +
            " * loginUrl 登陆的url;\n" +
            " */\n" +
            "\n" +
            "//function checkUrl(url){\n" +
            "//\n" +
            "//    if(url.indexOf(\"login.html\") != -1 || url.indexOf(\"register.html\") != -1){\n" +
            "//\n" +
            "//        return true;\n" +
            "//    }\n" +
            "//    var user = localStorage.getItem(\"user\");\n" +
            "//\n" +
            "//    if(!user && !user.phone){\n" +
            "//        return true;\n" +
            "//    }\n" +
            "//\n" +
            "//    return;\n" +
            "//}\n" +
            "//\n" +
            "//\n" +
            "//if(!checkUrl(\"../userinfo.html\")){\n" +
            "//    location.href = \"./login.html\"\n" +
            "//}\n" +
            "Array.prototype.getList = function()\n" +
            "{\n" +
            "    this.sort();\n" +
            "    var re=[this[0]];\n" +
            "    for(var i = 1; i < this.length; i++)\n" +
            "    {\n" +
            "        if( this[i] !== re[re.length-1])\n" +
            "        {\n" +
            "            re.push(this[i]);\n" +
            "        }\n" +
            "    }\n" +
            "    return re;\n" +
            "}\n" +
            "\n" +
            "//获取图片真实尺寸\n" +
            "function getImageRealSize(url){\n" +
            "//  if(url.startWith(\"http\")){\n" +
            "        if(url.indexOf(\"/guoguo/\") != (-1)){\n" +
            "            var s1=url.split(\"/guoguo/\");\n" +
            "        }else if(url.indexOf(\"/storage/\") != (-1)){\n" +
            "            var s1=url.split(\"/storage/\");\n" +
            "        }\n" +
            "        var group=s1[1].split(\"*\");\n" +
            "        var orgWidth=parseFloat(group[0]);\n" +
            "        var orgHeight=parseFloat(group[1]);\n" +
            "        var obj ={w:orgWidth,h:orgHeight};\n" +
            "        return obj;\n" +
            "//  }\n" +
            "}\n" +
            "function getHeightFromWidth(realWidth,realHeight,thumWidth){\n" +
            "    var thumHeight = Math.round((thumWidth/realWidth)*realHeight);//显示宽度除以图片真实宽度 乘以 图片真实高度\n" +
            "    return thumHeight;\n" +
            "}\n" +
            "\n" +
            "//压缩图片  并且做变形处理\n" +
            "function getImgByThisSize(url,showWidth,showHieght){\n" +
            "\tif(url.indexOf(\"http\") == 0){\n" +
            "\t\tif(url.indexOf(\"/guoguo/\") != (-1)){\n" +
            "\t        var s1=url.split(\"/guoguo/\");\n" +
            "\t    }else if(url.indexOf(\"/storage/\") != (-1)){\n" +
            "\t        var s1=url.split(\"/storage/\");\n" +
            "\t    }else{\n" +
            "\t    \treturn {url:url,style:\"width:\"+showWidth+\"px;height:\"+showHieght+\"px;\"};\n" +
            "\t    }\n" +
            "\t    var group=s1[1].split(\"*\");\n" +
            "\t    var orgWidth=parseFloat(group[0]);\n" +
            "\t    var orgHeight=parseFloat(group[1]);\n" +
            "\t    var width = Math.round(showWidth*3.5);\n" +
            "\t    if (width < orgWidth) {\n" +
            "\t    \tvar imgTypes = url.substring(url.lastIndexOf(\".\"));\n" +
            "\t    \tvar imgName = url.split(imgTypes)[0]+\"_\"+width+\"_0\";\n" +
            "\t    \turl = imgName+imgTypes;\n" +
            "\t    }\n" +
            "\t    return getImgSizeBySize(url,showWidth,showHieght);\n" +
            "\t}\n" +
            "}\n" +
            "\n" +
            "//只是压缩图片  不做变形处理\n" +
            "function changeImgBySize(url,showWidth){\n" +
            "\tif(url.indexOf(\"/guoguo/\") != (-1)){\n" +
            "        var s1=url.split(\"/guoguo/\");\n" +
            "    }else if(url.indexOf(\"/storage/\") != (-1)){\n" +
            "        var s1=url.split(\"/storage/\");\n" +
            "    }\n" +
            "    var group=s1[1].split(\"*\");\n" +
            "    var orgWidth=parseFloat(group[0]);\n" +
            "    var orgHeight=parseFloat(group[1]);\n" +
            "    var width = Math.round(showWidth*2);\n" +
            "    if (width < orgWidth) {\n" +
            "    \tvar imgTypes = url.substring(url.lastIndexOf(\".\"));\n" +
            "    \tvar imgName = url.split(imgTypes)[0]+\"_\"+width+\"_0\";\n" +
            "    \turl = imgName+imgTypes;\n" +
            "    }\n" +
            "    return url;\n" +
            "}\n" +
            "\n" +
            "//截取照片\n" +
            "function getImgSizeBySize(url,showWidth,showHieght){\n" +
            "    var realSize = getImageRealSize(url);\n" +
            "    var thumSize = {w:showWidth,h:showHieght};\n" +
            "    var h = getHeightFromWidth(realSize.w,realSize.h,thumSize.w);\n" +
            "\n" +
            "    //判断高度是否超出；大于，图片不够显示，截左右\n" +
            "    if(thumSize.h > h){\n" +
            "        var w = getHeightFromWidth(realSize.h,realSize.w,thumSize.h);//肯定超出去\n" +
            "        var over = 0-Math.round((w - thumSize.w)/2);//左右截取\n" +
            "        //margin-left: 17px;margin-right: 17px\n" +
            "        var obj = {img_height:realSize.h,img_width:realSize.w,url:url,style:\"margin-left:\"+over+\"px\"+\"; margin-right:\"+over+\"px;height:\"+showHieght+\"px\"};\n" +
            "        //var obj={over:over,type:1}\n" +
            "        return obj;\n" +
            "    }else{\n" +
            "        var over =  0-Math.round((h - thumSize.h)/2);\n" +
            "        var obj = {img_height:realSize.h,img_width:realSize.w,url:url,style:\"margin-top:\"+over+\"px\"+\";margin-bottom:\"+over+\"px;width:\"+showWidth+\"px\"};\n" +
            "        // var obj={over:over,type:2}\n" +
            "        return obj;\n" +
            "    }\n" +
            "\n" +
            "}\n" +
            "function tryDecodeURIComponent(value){\n" +
            "\tif (value) {\n" +
            "\t\ttry{\n" +
            "\t        return decodeURIComponent(value);\n" +
            "\t    }catch(err){\n" +
            "\t        return value;\n" +
            "\t    }\n" +
            "\t}\n" +
            "\treturn \"\";\n" +
            "}";
    private static final String GETFILEKEY="function Base64() {\n" +
            " \n" +
            "    // private property\n" +
            "    _keyStr = \"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=\";\n" +
            " \n" +
            "    // public method for encoding\n" +
            "    this.encode = function (input) {\n" +
            "        var output = \"\";\n" +
            "        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;\n" +
            "        var i = 0;\n" +
            "        input = _utf8_encode(input);\n" +
            "        while (i < input.length) {\n" +
            "            chr1 = input.charCodeAt(i++);\n" +
            "            chr2 = input.charCodeAt(i++);\n" +
            "            chr3 = input.charCodeAt(i++);\n" +
            "            enc1 = chr1 >> 2;\n" +
            "            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);\n" +
            "            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);\n" +
            "            enc4 = chr3 & 63;\n" +
            "            if (isNaN(chr2)) {\n" +
            "                enc3 = enc4 = 64;\n" +
            "            } else if (isNaN(chr3)) {\n" +
            "                enc4 = 64;\n" +
            "            }\n" +
            "            output = output +\n" +
            "            _keyStr.charAt(enc1) + _keyStr.charAt(enc2) +\n" +
            "            _keyStr.charAt(enc3) + _keyStr.charAt(enc4);\n" +
            "        }\n" +
            "        return output;\n" +
            "    }\n" +
            " \n" +
            "    // public method for decoding\n" +
            "    this.decode = function (input) {\n" +
            "        var output = \"\";\n" +
            "        var chr1, chr2, chr3;\n" +
            "        var enc1, enc2, enc3, enc4;\n" +
            "        var i = 0;\n" +
            "        input = input.replace(/[^A-Za-z0-9\\+\\/\\=]/g, \"\");\n" +
            "        while (i < input.length) {\n" +
            "            enc1 = _keyStr.indexOf(input.charAt(i++));\n" +
            "            enc2 = _keyStr.indexOf(input.charAt(i++));\n" +
            "            enc3 = _keyStr.indexOf(input.charAt(i++));\n" +
            "            enc4 = _keyStr.indexOf(input.charAt(i++));\n" +
            "            chr1 = (enc1 << 2) | (enc2 >> 4);\n" +
            "            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);\n" +
            "            chr3 = ((enc3 & 3) << 6) | enc4;\n" +
            "            output = output + String.fromCharCode(chr1);\n" +
            "            if (enc3 != 64) {\n" +
            "                output = output + String.fromCharCode(chr2);\n" +
            "            }\n" +
            "            if (enc4 != 64) {\n" +
            "                output = output + String.fromCharCode(chr3);\n" +
            "            }\n" +
            "        }\n" +
            "        output = _utf8_decode(output);\n" +
            "        return output;\n" +
            "    }\n" +
            " \n" +
            "    // private method for UTF-8 encoding\n" +
            "    _utf8_encode = function (string) {\n" +
            "        string = string.replace(/\\r\\n/g,\"\\n\");\n" +
            "        var utftext = \"\";\n" +
            "        for (var n = 0; n < string.length; n++) {\n" +
            "            var c = string.charCodeAt(n);\n" +
            "            if (c < 128) {\n" +
            "                utftext += String.fromCharCode(c);\n" +
            "            } else if((c > 127) && (c < 2048)) {\n" +
            "                utftext += String.fromCharCode((c >> 6) | 192);\n" +
            "                utftext += String.fromCharCode((c & 63) | 128);\n" +
            "            } else {\n" +
            "                utftext += String.fromCharCode((c >> 12) | 224);\n" +
            "                utftext += String.fromCharCode(((c >> 6) & 63) | 128);\n" +
            "                utftext += String.fromCharCode((c & 63) | 128);\n" +
            "            }\n" +
            " \n" +
            "        }\n" +
            "        return utftext;\n" +
            "    }\n" +
            " \n" +
            "    // private method for UTF-8 decoding\n" +
            "    _utf8_decode = function (utftext) {\n" +
            "        var string = \"\";\n" +
            "        var i = 0;\n" +
            "        var c = c1 = c2 = 0;\n" +
            "        while ( i < utftext.length ) {\n" +
            "            c = utftext.charCodeAt(i);\n" +
            "            if (c < 128) {\n" +
            "                string += String.fromCharCode(c);\n" +
            "                i++;\n" +
            "            } else if((c > 191) && (c < 224)) {\n" +
            "                c2 = utftext.charCodeAt(i+1);\n" +
            "                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));\n" +
            "                i += 2;\n" +
            "            } else {\n" +
            "                c2 = utftext.charCodeAt(i+1);\n" +
            "                c3 = utftext.charCodeAt(i+2);\n" +
            "                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));\n" +
            "                i += 3;\n" +
            "            }\n" +
            "        }\n" +
            "        return string;\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "function getImgKey(){\n" +
            "\tvar filekey = '?filekey=';\n" +
            "    var a = Date.parse(new Date()).toString();\n" +
            "    var cod = a.replace(/1/g,'f').replace(/2/g,'A').replace(/3/g,'C').replace(/4/g, 'g').replace(/5/g,'W').replace(/6/g,'q').replace(/7/g, 't').replace(/8/g,'m').replace(/9/g, 'J').replace(/0/g,'p');\n" +
            "    var b , c;\n" +
            "    var d = '';\n" +
            "    var doc = '';\n" +
            "\tvar base64=new Base64();\n" +
            "    b = cod.substring(0,5).split('');\n" +
            "    c = cod.substr(cod.length-5,5).split('');\n" +
            "    for(var i =0;i<5;i++){\n" +
            "        d +=c[c.length-1-i]+b[i];\n" +
            "        doc = d +a.substring(5,cod.length-5);\n" +
            "        if(i == 4){\n" +
            "            filekey += base64.encode(doc);\n" +
            "        }\n" +
            "    }\n" +
            "    return filekey;\n" +
            "}";

    /**
     * 执行JS
     *
     * @param js js代码
     * @param functionName js方法名称
     * @param functionParams js方法参数
     * @return
     */
    private static String runScript(String js, String functionName, Object[] functionParams,android.content.Context activity) {
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        try {
            Scriptable scope = rhino.initStandardObjects();

            ScriptableObject.putProperty(scope, "javaContext", Context.javaToJS(activity, scope));
            ScriptableObject.putProperty(scope, "javaLoader", Context.javaToJS(HomeActivity.class.getClassLoader(), scope));

            rhino.evaluateString(scope, js, "MainActivity", 1, null);

            Function function = (Function) scope.get(functionName, scope);

            Object result = function.call(rhino, scope, scope, functionParams);
            if (result instanceof String) {
                return (String) result;
            } else if (result instanceof NativeJavaObject) {
                return (String) ((NativeJavaObject) result).getDefaultValue(String.class);
            } else if (result instanceof NativeObject) {
                return (String) ((NativeObject) result).getDefaultValue(String.class);
            }
            return result.toString();//(String) function.call(rhino, scope, scope, functionParams);
        } finally {
            Context.exit();
        }
    }

    /**
     * 通过js代码对密码进行md5加密
     * @param pass
     * @param activity
     * @return
     */
    public static String getMd5Pass(String pass,Activity activity){
        return runScript(JAVA_CALL_JS_FUNCTION, "hex_md5", new String[] {pass},activity);
    }

    /**
     * 通过js代码对获取flieKey
     * @param activity
     * @return
     */
    public static String getFileKey(android.content.Context activity){
        return runScript(GETFILEKEY, "getImgKey", new String[] {},activity);
    }

}
