package com.example.chenlong.coolweather.bean;

import java.util.List;

/**
 * Created by ChenLong on 2017/1/28.
 */

public class WeatherBean
{

    private List<HeWeatherBean> HeWeather;

    public List<HeWeatherBean> getHeWeather()
    {
        return HeWeather;
    }

    public void setHeWeather(List<HeWeatherBean> HeWeather)
    {
        this.HeWeather = HeWeather;
    }

    public static class HeWeatherBean
    {
        /**
         * aqi : {"city":{"aqi":"71","co":"1","no2":"18","o3":"70","pm10":"90","pm25":"24","qlty":"良","so2":"11"}}
         * basic : {"city":"苏州","cnty":"中国","id":"CN101190401","lat":"31.309000","lon":"120.612000","update":{"loc":"2017-01-28 00:52","utc":"2017-01-27 16:52"}}
         * daily_forecast : [{"astro":{"mr":"06:46","ms":"17:50","sr":"06:52","ss":"17:28"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-01-28","hum":"83","pcpn":"0.0","pop":"0","pres":"1022","tmp":{"max":"15","min":"9"},"uv":"5","vis":"10","wind":{"deg":"158","dir":"南风","sc":"3-4","spd":"14"}},{"astro":{"mr":"07:30","ms":"18:48","sr":"06:51","ss":"17:29"},"cond":{"code_d":"104","code_n":"305","txt_d":"阴","txt_n":"小雨"},"date":"2017-01-29","hum":"78","pcpn":"0.5","pop":"95","pres":"1020","tmp":{"max":"18","min":"4"},"uv":"5","vis":"10","wind":{"deg":"317","dir":"北风","sc":"5-6","spd":"28"}},{"astro":{"mr":"08:10","ms":"19:48","sr":"06:50","ss":"17:30"},"cond":{"code_d":"104","code_n":"101","txt_d":"阴","txt_n":"多云"},"date":"2017-01-30","hum":"68","pcpn":"0.1","pop":"83","pres":"1033","tmp":{"max":"8","min":"1"},"uv":"4","vis":"10","wind":{"deg":"15","dir":"东北风","sc":"3-4","spd":"11"}}]
         * hourly_forecast : [{"cond":{"code":"103","txt":"晴间多云"},"date":"2017-01-28 01:00","hum":"85","pop":"0","pres":"1027","tmp":"5","wind":{"deg":"88","dir":"东风","sc":"微风","spd":"14"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2017-01-28 04:00","hum":"88","pop":"0","pres":"1025","tmp":"5","wind":{"deg":"98","dir":"东风","sc":"微风","spd":"16"}},{"cond":{"code":"101","txt":"多云"},"date":"2017-01-28 07:00","hum":"89","pop":"0","pres":"1024","tmp":"6","wind":{"deg":"114","dir":"东南风","sc":"3-4","spd":"18"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2017-01-28 10:00","hum":"77","pop":"0","pres":"1023","tmp":"11","wind":{"deg":"138","dir":"东南风","sc":"3-4","spd":"23"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2017-01-28 13:00","hum":"67","pop":"0","pres":"1021","tmp":"16","wind":{"deg":"155","dir":"东南风","sc":"3-4","spd":"22"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-01-28 16:00","hum":"71","pop":"0","pres":"1019","tmp":"16","wind":{"deg":"149","dir":"东南风","sc":"微风","spd":"15"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-01-28 19:00","hum":"88","pop":"0","pres":"1019","tmp":"12","wind":{"deg":"130","dir":"东南风","sc":"微风","spd":"15"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2017-01-28 22:00","hum":"96","pop":"0","pres":"1019","tmp":"10","wind":{"deg":"133","dir":"东南风","sc":"微风","spd":"15"}}]
         * now : {"cond":{"code":"101","txt":"多云"},"fl":"2","hum":"73","pcpn":"0","pres":"1027","tmp":"5","vis":"10","wind":{"deg":"85","dir":"东风","sc":"5-6","spd":"32"}}
         * status : ok
         * suggestion : {"air":{"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"},"comf":{"brf":"较舒适","txt":"白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},"flu":{"brf":"较易发","txt":"天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。"},"sport":{"brf":"较适宜","txt":"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。"},"trav":{"brf":"适宜","txt":"天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。"},"uv":{"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}}
         */

        private AqiBean aqi;
        private BasicBean basic;
        private NowBean now;
        private String status;
        private SuggestionBean suggestion;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyForecastBean> hourly_forecast;

        public AqiBean getAqi()
        {
            return aqi;
        }

        public void setAqi(AqiBean aqi)
        {
            this.aqi = aqi;
        }

        public BasicBean getBasic()
        {
            return basic;
        }

        public void setBasic(BasicBean basic)
        {
            this.basic = basic;
        }

        public NowBean getNow()
        {
            return now;
        }

        public void setNow(NowBean now)
        {
            this.now = now;
        }

        public String getStatus()
        {
            return status;
        }

        public void setStatus(String status)
        {
            this.status = status;
        }

        public SuggestionBean getSuggestion()
        {
            return suggestion;
        }

        public void setSuggestion(SuggestionBean suggestion)
        {
            this.suggestion = suggestion;
        }

        public List<DailyForecastBean> getDaily_forecast()
        {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast)
        {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyForecastBean> getHourly_forecast()
        {
            return hourly_forecast;
        }

        public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast)
        {
            this.hourly_forecast = hourly_forecast;
        }

        public static class AqiBean
        {
            /**
             * city : {"aqi":"71","co":"1","no2":"18","o3":"70","pm10":"90","pm25":"24","qlty":"良","so2":"11"}
             */

            private CityBean city;

            public CityBean getCity()
            {
                return city;
            }

            public void setCity(CityBean city)
            {
                this.city = city;
            }

            public static class CityBean
            {
                /**
                 * aqi : 71
                 * co : 1
                 * no2 : 18
                 * o3 : 70
                 * pm10 : 90
                 * pm25 : 24
                 * qlty : 良
                 * so2 : 11
                 */

                private String aqi;
                private String co;
                private String no2;
                private String o3;
                private String pm10;
                private String pm25;
                private String qlty;
                private String so2;

                public String getAqi()
                {
                    return aqi;
                }

                public void setAqi(String aqi)
                {
                    this.aqi = aqi;
                }

                public String getCo()
                {
                    return co;
                }

                public void setCo(String co)
                {
                    this.co = co;
                }

                public String getNo2()
                {
                    return no2;
                }

                public void setNo2(String no2)
                {
                    this.no2 = no2;
                }

                public String getO3()
                {
                    return o3;
                }

                public void setO3(String o3)
                {
                    this.o3 = o3;
                }

                public String getPm10()
                {
                    return pm10;
                }

                public void setPm10(String pm10)
                {
                    this.pm10 = pm10;
                }

                public String getPm25()
                {
                    return pm25;
                }

                public void setPm25(String pm25)
                {
                    this.pm25 = pm25;
                }

                public String getQlty()
                {
                    return qlty;
                }

                public void setQlty(String qlty)
                {
                    this.qlty = qlty;
                }

                public String getSo2()
                {
                    return so2;
                }

                public void setSo2(String so2)
                {
                    this.so2 = so2;
                }
            }
        }

        public static class BasicBean
        {
            /**
             * city : 苏州
             * cnty : 中国
             * id : CN101190401
             * lat : 31.309000
             * lon : 120.612000
             * update : {"loc":"2017-01-28 00:52","utc":"2017-01-27 16:52"}
             */

            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
            private UpdateBean update;

            public String getCity()
            {
                return city;
            }

            public void setCity(String city)
            {
                this.city = city;
            }

            public String getCnty()
            {
                return cnty;
            }

            public void setCnty(String cnty)
            {
                this.cnty = cnty;
            }

            public String getId()
            {
                return id;
            }

            public void setId(String id)
            {
                this.id = id;
            }

            public String getLat()
            {
                return lat;
            }

            public void setLat(String lat)
            {
                this.lat = lat;
            }

            public String getLon()
            {
                return lon;
            }

            public void setLon(String lon)
            {
                this.lon = lon;
            }

            public UpdateBean getUpdate()
            {
                return update;
            }

            public void setUpdate(UpdateBean update)
            {
                this.update = update;
            }

            public static class UpdateBean
            {
                /**
                 * loc : 2017-01-28 00:52
                 * utc : 2017-01-27 16:52
                 */

                private String loc;
                private String utc;

                public String getLoc()
                {
                    return loc;
                }

                public void setLoc(String loc)
                {
                    this.loc = loc;
                }

                public String getUtc()
                {
                    return utc;
                }

                public void setUtc(String utc)
                {
                    this.utc = utc;
                }
            }
        }

        public static class NowBean
        {
            /**
             * cond : {"code":"101","txt":"多云"}
             * fl : 2
             * hum : 73
             * pcpn : 0
             * pres : 1027
             * tmp : 5
             * vis : 10
             * wind : {"deg":"85","dir":"东风","sc":"5-6","spd":"32"}
             */

            private CondBean cond;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private WindBean wind;

            public CondBean getCond()
            {
                return cond;
            }

            public void setCond(CondBean cond)
            {
                this.cond = cond;
            }

            public String getFl()
            {
                return fl;
            }

            public void setFl(String fl)
            {
                this.fl = fl;
            }

            public String getHum()
            {
                return hum;
            }

            public void setHum(String hum)
            {
                this.hum = hum;
            }

            public String getPcpn()
            {
                return pcpn;
            }

            public void setPcpn(String pcpn)
            {
                this.pcpn = pcpn;
            }

            public String getPres()
            {
                return pres;
            }

            public void setPres(String pres)
            {
                this.pres = pres;
            }

            public String getTmp()
            {
                return tmp;
            }

            public void setTmp(String tmp)
            {
                this.tmp = tmp;
            }

            public String getVis()
            {
                return vis;
            }

            public void setVis(String vis)
            {
                this.vis = vis;
            }

            public WindBean getWind()
            {
                return wind;
            }

            public void setWind(WindBean wind)
            {
                this.wind = wind;
            }

            public static class CondBean
            {
                /**
                 * code : 101
                 * txt : 多云
                 */

                private String code;
                private String txt;

                public String getCode()
                {
                    return code;
                }

                public void setCode(String code)
                {
                    this.code = code;
                }

                public String getTxt()
                {
                    return txt;
                }

                public void setTxt(String txt)
                {
                    this.txt = txt;
                }
            }

            public static class WindBean
            {
                /**
                 * deg : 85
                 * dir : 东风
                 * sc : 5-6
                 * spd : 32
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg()
                {
                    return deg;
                }

                public void setDeg(String deg)
                {
                    this.deg = deg;
                }

                public String getDir()
                {
                    return dir;
                }

                public void setDir(String dir)
                {
                    this.dir = dir;
                }

                public String getSc()
                {
                    return sc;
                }

                public void setSc(String sc)
                {
                    this.sc = sc;
                }

                public String getSpd()
                {
                    return spd;
                }

                public void setSpd(String spd)
                {
                    this.spd = spd;
                }
            }
        }

        public static class SuggestionBean
        {
            /**
             * air : {"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"}
             * comf : {"brf":"较舒适","txt":"白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"}
             * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
             * drsg : {"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"}
             * flu : {"brf":"较易发","txt":"天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。"}
             * sport : {"brf":"较适宜","txt":"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。"}
             * trav : {"brf":"适宜","txt":"天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。"}
             * uv : {"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}
             */

            private AirBean air;
            private ComfBean comf;
            private CwBean cw;
            private DrsgBean drsg;
            private FluBean flu;
            private SportBean sport;
            private TravBean trav;
            private UvBean uv;

            public AirBean getAir()
            {
                return air;
            }

            public void setAir(AirBean air)
            {
                this.air = air;
            }

            public ComfBean getComf()
            {
                return comf;
            }

            public void setComf(ComfBean comf)
            {
                this.comf = comf;
            }

            public CwBean getCw()
            {
                return cw;
            }

            public void setCw(CwBean cw)
            {
                this.cw = cw;
            }

            public DrsgBean getDrsg()
            {
                return drsg;
            }

            public void setDrsg(DrsgBean drsg)
            {
                this.drsg = drsg;
            }

            public FluBean getFlu()
            {
                return flu;
            }

            public void setFlu(FluBean flu)
            {
                this.flu = flu;
            }

            public SportBean getSport()
            {
                return sport;
            }

            public void setSport(SportBean sport)
            {
                this.sport = sport;
            }

            public TravBean getTrav()
            {
                return trav;
            }

            public void setTrav(TravBean trav)
            {
                this.trav = trav;
            }

            public UvBean getUv()
            {
                return uv;
            }

            public void setUv(UvBean uv)
            {
                this.uv = uv;
            }

            public static class AirBean
            {
                /**
                 * brf : 中
                 * txt : 气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。
                 */

                private String brf;
                private String txt;

                public String getBrf()
                {
                    return brf;
                }

                public void setBrf(String brf)
                {
                    this.brf = brf;
                }

                public String getTxt()
                {
                    return txt;
                }

                public void setTxt(String txt)
                {
                    this.txt = txt;
                }
            }

            public static class ComfBean
            {
                /**
                 * brf : 较舒适
                 * txt : 白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。
                 */

                private String brf;
                private String txt;

                public String getBrf()
                {
                    return brf;
                }

                public void setBrf(String brf)
                {
                    this.brf = brf;
                }

                public String getTxt()
                {
                    return txt;
                }

                public void setTxt(String txt)
                {
                    this.txt = txt;
                }
            }

            public static class CwBean
            {
                /**
                 * brf : 较适宜
                 * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
                 */

                private String brf;
                private String txt;

                public String getBrf()
                {
                    return brf;
                }

                public void setBrf(String brf)
                {
                    this.brf = brf;
                }

                public String getTxt()
                {
                    return txt;
                }

                public void setTxt(String txt)
                {
                    this.txt = txt;
                }
            }

            public static class DrsgBean
            {
                /**
                 * brf : 较冷
                 * txt : 建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。
                 */

                private String brf;
                private String txt;

                public String getBrf()
                {
                    return brf;
                }

                public void setBrf(String brf)
                {
                    this.brf = brf;
                }

                public String getTxt()
                {
                    return txt;
                }

                public void setTxt(String txt)
                {
                    this.txt = txt;
                }
            }

            public static class FluBean
            {
                /**
                 * brf : 较易发
                 * txt : 天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。
                 */

                private String brf;
                private String txt;

                public String getBrf()
                {
                    return brf;
                }

                public void setBrf(String brf)
                {
                    this.brf = brf;
                }

                public String getTxt()
                {
                    return txt;
                }

                public void setTxt(String txt)
                {
                    this.txt = txt;
                }
            }

            public static class SportBean
            {
                /**
                 * brf : 较适宜
                 * txt : 天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。
                 */

                private String brf;
                private String txt;

                public String getBrf()
                {
                    return brf;
                }

                public void setBrf(String brf)
                {
                    this.brf = brf;
                }

                public String getTxt()
                {
                    return txt;
                }

                public void setTxt(String txt)
                {
                    this.txt = txt;
                }
            }

            public static class TravBean
            {
                /**
                 * brf : 适宜
                 * txt : 天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。
                 */

                private String brf;
                private String txt;

                public String getBrf()
                {
                    return brf;
                }

                public void setBrf(String brf)
                {
                    this.brf = brf;
                }

                public String getTxt()
                {
                    return txt;
                }

                public void setTxt(String txt)
                {
                    this.txt = txt;
                }
            }

            public static class UvBean
            {
                /**
                 * brf : 弱
                 * txt : 紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。
                 */

                private String brf;
                private String txt;

                public String getBrf()
                {
                    return brf;
                }

                public void setBrf(String brf)
                {
                    this.brf = brf;
                }

                public String getTxt()
                {
                    return txt;
                }

                public void setTxt(String txt)
                {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastBean
        {
            /**
             * astro : {"mr":"06:46","ms":"17:50","sr":"06:52","ss":"17:28"}
             * cond : {"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"}
             * date : 2017-01-28
             * hum : 83
             * pcpn : 0.0
             * pop : 0
             * pres : 1022
             * tmp : {"max":"15","min":"9"}
             * uv : 5
             * vis : 10
             * wind : {"deg":"158","dir":"南风","sc":"3-4","spd":"14"}
             */

            private AstroBean astro;
            private CondBeanX cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            private TmpBean tmp;
            private String uv;
            private String vis;
            private WindBeanX wind;

            public AstroBean getAstro()
            {
                return astro;
            }

            public void setAstro(AstroBean astro)
            {
                this.astro = astro;
            }

            public CondBeanX getCond()
            {
                return cond;
            }

            public void setCond(CondBeanX cond)
            {
                this.cond = cond;
            }

            public String getDate()
            {
                return date;
            }

            public void setDate(String date)
            {
                this.date = date;
            }

            public String getHum()
            {
                return hum;
            }

            public void setHum(String hum)
            {
                this.hum = hum;
            }

            public String getPcpn()
            {
                return pcpn;
            }

            public void setPcpn(String pcpn)
            {
                this.pcpn = pcpn;
            }

            public String getPop()
            {
                return pop;
            }

            public void setPop(String pop)
            {
                this.pop = pop;
            }

            public String getPres()
            {
                return pres;
            }

            public void setPres(String pres)
            {
                this.pres = pres;
            }

            public TmpBean getTmp()
            {
                return tmp;
            }

            public void setTmp(TmpBean tmp)
            {
                this.tmp = tmp;
            }

            public String getUv()
            {
                return uv;
            }

            public void setUv(String uv)
            {
                this.uv = uv;
            }

            public String getVis()
            {
                return vis;
            }

            public void setVis(String vis)
            {
                this.vis = vis;
            }

            public WindBeanX getWind()
            {
                return wind;
            }

            public void setWind(WindBeanX wind)
            {
                this.wind = wind;
            }

            public static class AstroBean
            {
                /**
                 * mr : 06:46
                 * ms : 17:50
                 * sr : 06:52
                 * ss : 17:28
                 */

                private String mr;
                private String ms;
                private String sr;
                private String ss;

                public String getMr()
                {
                    return mr;
                }

                public void setMr(String mr)
                {
                    this.mr = mr;
                }

                public String getMs()
                {
                    return ms;
                }

                public void setMs(String ms)
                {
                    this.ms = ms;
                }

                public String getSr()
                {
                    return sr;
                }

                public void setSr(String sr)
                {
                    this.sr = sr;
                }

                public String getSs()
                {
                    return ss;
                }

                public void setSs(String ss)
                {
                    this.ss = ss;
                }
            }

            public static class CondBeanX
            {
                /**
                 * code_d : 101
                 * code_n : 101
                 * txt_d : 多云
                 * txt_n : 多云
                 */

                private String code_d;
                private String code_n;
                private String txt_d;
                private String txt_n;

                public String getCode_d()
                {
                    return code_d;
                }

                public void setCode_d(String code_d)
                {
                    this.code_d = code_d;
                }

                public String getCode_n()
                {
                    return code_n;
                }

                public void setCode_n(String code_n)
                {
                    this.code_n = code_n;
                }

                public String getTxt_d()
                {
                    return txt_d;
                }

                public void setTxt_d(String txt_d)
                {
                    this.txt_d = txt_d;
                }

                public String getTxt_n()
                {
                    return txt_n;
                }

                public void setTxt_n(String txt_n)
                {
                    this.txt_n = txt_n;
                }
            }

            public static class TmpBean
            {
                /**
                 * max : 15
                 * min : 9
                 */

                private String max;
                private String min;

                public String getMax()
                {
                    return max;
                }

                public void setMax(String max)
                {
                    this.max = max;
                }

                public String getMin()
                {
                    return min;
                }

                public void setMin(String min)
                {
                    this.min = min;
                }
            }

            public static class WindBeanX
            {
                /**
                 * deg : 158
                 * dir : 南风
                 * sc : 3-4
                 * spd : 14
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg()
                {
                    return deg;
                }

                public void setDeg(String deg)
                {
                    this.deg = deg;
                }

                public String getDir()
                {
                    return dir;
                }

                public void setDir(String dir)
                {
                    this.dir = dir;
                }

                public String getSc()
                {
                    return sc;
                }

                public void setSc(String sc)
                {
                    this.sc = sc;
                }

                public String getSpd()
                {
                    return spd;
                }

                public void setSpd(String spd)
                {
                    this.spd = spd;
                }
            }
        }

        public static class HourlyForecastBean
        {
            /**
             * cond : {"code":"103","txt":"晴间多云"}
             * date : 2017-01-28 01:00
             * hum : 85
             * pop : 0
             * pres : 1027
             * tmp : 5
             * wind : {"deg":"88","dir":"东风","sc":"微风","spd":"14"}
             */

            private CondBeanXX cond;
            private String date;
            private String hum;
            private String pop;
            private String pres;
            private String tmp;
            private WindBeanXX wind;

            public CondBeanXX getCond()
            {
                return cond;
            }

            public void setCond(CondBeanXX cond)
            {
                this.cond = cond;
            }

            public String getDate()
            {
                return date;
            }

            public void setDate(String date)
            {
                this.date = date;
            }

            public String getHum()
            {
                return hum;
            }

            public void setHum(String hum)
            {
                this.hum = hum;
            }

            public String getPop()
            {
                return pop;
            }

            public void setPop(String pop)
            {
                this.pop = pop;
            }

            public String getPres()
            {
                return pres;
            }

            public void setPres(String pres)
            {
                this.pres = pres;
            }

            public String getTmp()
            {
                return tmp;
            }

            public void setTmp(String tmp)
            {
                this.tmp = tmp;
            }

            public WindBeanXX getWind()
            {
                return wind;
            }

            public void setWind(WindBeanXX wind)
            {
                this.wind = wind;
            }

            public static class CondBeanXX
            {
                /**
                 * code : 103
                 * txt : 晴间多云
                 */

                private String code;
                private String txt;

                public String getCode()
                {
                    return code;
                }

                public void setCode(String code)
                {
                    this.code = code;
                }

                public String getTxt()
                {
                    return txt;
                }

                public void setTxt(String txt)
                {
                    this.txt = txt;
                }
            }

            public static class WindBeanXX
            {
                /**
                 * deg : 88
                 * dir : 东风
                 * sc : 微风
                 * spd : 14
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg()
                {
                    return deg;
                }

                public void setDeg(String deg)
                {
                    this.deg = deg;
                }

                public String getDir()
                {
                    return dir;
                }

                public void setDir(String dir)
                {
                    this.dir = dir;
                }

                public String getSc()
                {
                    return sc;
                }

                public void setSc(String sc)
                {
                    this.sc = sc;
                }

                public String getSpd()
                {
                    return spd;
                }

                public void setSpd(String spd)
                {
                    this.spd = spd;
                }
            }
        }
    }
}
