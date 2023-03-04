package com.example.calculator.base64encodedecode;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Base64EncodeDecodeImpl implements Base64EncodeDecode{

    @Override
    public String getEncodeParam(String param) {
        Base64.Encoder encoder = Base64.getEncoder(); //создание кодеровщика (encoder)
        byte[] bytes = param.getBytes();              //получение необходимого типа (массив байт) из параметра
        return encoder.encodeToString(bytes);         //
    }

    @Override
    public String getDecodeParam(String param) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(param);
        return new String(decode);
    }

}
