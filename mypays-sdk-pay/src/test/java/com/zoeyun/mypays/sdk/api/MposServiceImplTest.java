package com.zoeyun.mypays.sdk.api;

import com.zoeyun.mypays.sdk.bean.request.MposCreateRequest;
import com.zoeyun.mypays.sdk.bean.result.MposCreateResult;
import com.zoeyun.mypays.sdk.config.impl.MypaysDefaultConfigImpl;
import com.zoeyun.mypays.sdk.constant.MypaysConstants;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import com.zoeyun.mypays.sdk.service.MypaysService;
import com.zoeyun.mypays.sdk.service.impl.MypaysServiceImpl;
import org.testng.annotations.Test;

public class MposServiceImplTest {

    @Test
    public void create() {
        MypaysService mypaysService = new MypaysServiceImpl();
        MypaysDefaultConfigImpl configStorage = new MypaysDefaultConfigImpl();
        configStorage.setClientId("468aee69610a31850a41213637643f50");
        configStorage.setClientSecret("36af41dcb774416e861af8f2c5d9b025");
        configStorage.setMerchantCode("MCH123456789");
        configStorage.setRsaPubKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvwPvo+HpePqlRcBBR9JD9aXmy0frrz8R8E3msXO24eapUxuRbaN507lCDyXGSK75+cJIvct050ei0oeNGl3mGygrQv5ReyRr9jl81xX53Q9YALcCkjyNNZWFQoYaBgl/aEgeNZSOfFZ1QtNbHg6kR8YiITE6Xf+VAS50dNdI8KsfLEYc1aq0+KuRur191DzPQ3Y528pT1BBGj3qk13mGwWEIY3/jgHT0PnxnXSgMXLGpbRFZr2ldxQ/f0iF666oL1EeeBSbUqyoPlbfK2owVOSN9Dwuy3EfiwaZy7OHxY3e6pENqL2bZVtIXE9+JR2HlS7JnJRt4iTwscwSfnEJlaQIDAQAB");
        configStorage.setRsaPriKey("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDS6GbZwe1sBfHGh2bgCaneI/OLIgX333e/uLkHNqibNg3IunSLcMS8+fLfrbO2pX4MD9TowP7w/271KefWLL8OF0E/wyHCjTrpIrPwyVvIeQyTYjyiNLaS0esRtKhlLqnVnbuggjdUDf2m5dtUGiOfgZ8yE/cRva5Je5Qglpfn9VFlMwCeN8gA5MDA+ojBWnhhaU8ZrPnVJDfOREdIE0vQKWLWl/8ORtd3du5yuqE0lF8SNeX68aKlQcDjfByxhbgQy9zuHVTiqI2c0VQV483HytsazNPgHEF9ilXLTLHMMfYiwZrOsc9E7ivS+e76FHlf3XszaWEKn25nbJcR+RsBAgMBAAECggEBALJyRCNWe6V8WhaZladVRc5YKMW9ocMZ5l3m01aRHpNEZuFBMT6RyUQDT0WF2Jpe54kZFBFiydHqrVzteeSys2werOxgE35itEdxP0IpfGjgUo2Y/qhXZWpQBk5Sxm/lzXiaHpgt1NZfiA/gR3SfMSjSKXnbfp4aGQ6/apMwF5L/abq0SEnp1NXwBukuHR6/zOvWVlEYhYIeSavZLD6W2mAecEW+JpQrOW0VtcM+5dmUCqRzCvxKxSsezN9cuYsuEV5Evhv+ynWlCBZ45rfJ+1f+vJwZ4w/LSBGgbTYDsz95sAG6jffnTOaeiaBmjPcCaxtVT29X2/MMRDbiMiTUUOkCgYEA8e7vcb2lpxWKMft+oOOx5h/HyMUB+h/+DEinCPX30eorJWH0gSReX2BbVbyWZGTbfOSrSEg6c9ERFtaKb8OXzutwTXeuCD0eMei+hcoQSSxwT5n3ZVbq+1r0Y1/Z9eM51UseqEjeLhhBm5QksVDddDMu3xgoSnbJnS4Xiu0S5UcCgYEA3yuqge5PTU5aEHznU8+stZ9dNHy6exCW/uLn85z8fkCNTYMM3RK4pCa8JT3aZqySEutk0QVuRwC24hHZUo1K+RvyuvCi9X+aKHWkElp8YpJ2H2u23QalpRttbSGoojUo/p3EbfkevaH2DVZQJGskAf/VM9Q7q97WmwSKyoj6wXcCgYAaoYB99rA7WiWiJtrjfuzgNfNZ6EW1cLwYQg8Q73JeCvbA4K13Ybd5rDOhlma/mlKGxu0LwdedVBAbgXYvo0ocntH31Qq1IXUnbUU7mOh+BYQ/XuVapFytWm+4WJ63cFG3ZtNzFsJONKFULNR1KD+YQOIR8KjOuZCr2p0Az+PalQKBgQCEz93HOWWkYg6jZVHdxOfJpq+3PstT1cmmoq7bgf+ZuxzcljMflbagqhSqLSc+l1DPRZtX8V1xj/FGlMy6ni+SFJndurugUnIRxgEAky0XFIaLqHTJEN2fZrU2jyNmdTCSZp2xvOIYhLyDr2w+YCyrq+7by2A/pnwdART/94kTfQKBgAylW8FpM9Gr0R0ApbFcLhFTv/OUv8d/OEoMR0YWgENYlPKCGrKvfHPncdnNWk8aaYSW1jCMU2Drn8Z532Mh0sSmFp8y8UDpCPijIuZEcqUJO+mdiURXOZmEV3KSeyPQYanbZn7DnckHcIVcf3k4Q8IC1cFBWECXwsaxYNGoCtG8");
        configStorage.setUseSandboxEnv(true);
        mypaysService.setConfigStorage(configStorage);

        MposCreateRequest createRequest = MposCreateRequest
                .newBuilder()
                .clientOrderId("O1234657899")
                .body("消费")
                .tradeType(MypaysConstants.TradeType.JSAPI)
                .sceneType(MypaysConstants.SceneType.WX)
                .expireTime("30")
                .limitPay(0)
                .transAmount(600L)
                .payAmount(600L)
                .openId("1234567")
                .build();

        try {
            MposCreateResult createResult = mypaysService.getMposService().create(createRequest);
        } catch (MypaysException e) {
            e.printStackTrace();
        }
    }
}
