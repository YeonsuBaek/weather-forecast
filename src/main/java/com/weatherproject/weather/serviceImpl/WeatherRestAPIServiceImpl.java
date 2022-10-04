package com.weatherproject.weather.serviceImpl;

import com.weatherproject.weather.domain.DTO.ApiDataDTO;
import com.weatherproject.weather.domain.DTO.FcstApiDataDTO;
import com.weatherproject.weather.service.WeatherRestAPIService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class WeatherRestAPIServiceImpl implements WeatherRestAPIService {
    @Override
    public ApiDataDTO weatherApiHandle(FcstApiDataDTO fcstApiDataDTO) {

        ApiDataDTO apiDataDTO = new ApiDataDTO();

        apiDataDTO.setBaseDate(fcstApiDataDTO.getBaseDate());
        apiDataDTO.setBaseTime(fcstApiDataDTO.getBaseTime());
        apiDataDTO.setFcstDate(fcstApiDataDTO.getFcstDate());
        apiDataDTO.setFcstTime(fcstApiDataDTO.getFcstTime());

        switch (fcstApiDataDTO.getCategory()) {
            case "POP" : {
                apiDataDTO.setCategory("강수확률");
                apiDataDTO.setFcstValue(fcstApiDataDTO.getFcstValue());
                break;
            }

            case "PTY" : {
                String[] code = new String[5];
                code[0] = "없음";
                code[1] = "비";
                code[2] = "비/눈";
                code[3] = "눈";
                code[4] = "소나기";

                apiDataDTO.setCategory("강수형태");
                //System.out.println("강수형태 : " + fcstApiDataDTO.getFcstValue());
                apiDataDTO.setFcstValue(code[Integer.parseInt(fcstApiDataDTO.getFcstValue())]);
                break;
            }

            case "PCP" : {
                apiDataDTO.setCategory("1시간 강수량");

                /*if(Double.parseDouble(fcstApiDataDTO.getFcstValue()) < 1.0f)
                    apiDataDTO.setFcstValue("1.0mm미만");
                else if(Double.parseDouble(fcstApiDataDTO.getFcstValue()) >= 1.0f && Double.parseDouble(fcstApiDataDTO.getFcstValue()) < 30.0f)
                    apiDataDTO.setFcstValue("1.0~29.0mm");
                else if(Double.parseDouble(fcstApiDataDTO.getFcstValue()) >= 30.0f && Double.parseDouble(fcstApiDataDTO.getFcstValue()) < 50.0f)
                    apiDataDTO.setFcstValue("30.0~50.0mm");
                else
                    apiDataDTO.setFcstValue("50.0mm이상");*/

                apiDataDTO.setFcstValue(fcstApiDataDTO.getFcstValue());

                break;
            }

            case "REH" : {
                apiDataDTO.setCategory("습도");
                apiDataDTO.setFcstValue(fcstApiDataDTO.getFcstValue());

                break;
           }

            case "SNO" : {
                apiDataDTO.setCategory("1시간 신적설");

                /*if(Double.parseDouble(fcstApiDataDTO.getFcstValue()) < 1.0f)
                    apiDataDTO.setFcstValue("1.0cm 미만");
                else if(Double.parseDouble(fcstApiDataDTO.getFcstValue()) >= 1.0f && Double.parseDouble(fcstApiDataDTO.getFcstValue()) < 5.0f)
                    apiDataDTO.setFcstValue(fcstApiDataDTO.getFcstValue());
                else if(Double.parseDouble(fcstApiDataDTO.getFcstValue()) >= 5.0f)
                    apiDataDTO.setFcstValue("5.0cm 이상");
                else
                    apiDataDTO.setFcstValue("적설없음");*/

                apiDataDTO.setFcstValue(fcstApiDataDTO.getFcstValue());

                break;
            }

            case "SKY" : {
                apiDataDTO.setCategory("하늘 상태");

                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("1", "맑음");
                hashMap.put("3", "구름많음");
                hashMap.put("4", "흐림");

                apiDataDTO.setFcstValue(hashMap.get(fcstApiDataDTO.getFcstValue()));

                break;
            }

            case "TMP" : {
                apiDataDTO.setCategory("1시간 기온");

                apiDataDTO.setFcstValue(fcstApiDataDTO.getFcstValue() + "도");

                break;
            }

            case "TMN" : {
                apiDataDTO.setCategory("일 최저기온");

                apiDataDTO.setFcstValue(fcstApiDataDTO.getFcstValue() + "도");

                break;
            }

            case "TMX" : {
                apiDataDTO.setCategory("일 최고기온");

                apiDataDTO.setFcstValue(fcstApiDataDTO.getFcstValue() + "도");

                break;
            }

            case "WSD" : {
                apiDataDTO.setCategory("풍속");

                apiDataDTO.setFcstValue(fcstApiDataDTO.getFcstValue() + "m/s");

                break;
            }

            default:
                break;

        }

        return apiDataDTO;
    }
}
