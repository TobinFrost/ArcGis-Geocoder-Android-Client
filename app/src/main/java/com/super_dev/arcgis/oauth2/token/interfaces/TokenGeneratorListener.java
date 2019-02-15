package com.super_dev.arcgis.oauth2.token.interfaces;

import com.super_dev.arcgis.oauth2.token.TokenGenerator;

public interface TokenGeneratorListener {
    void success(Boolean success, TokenGenerator.Response response);
}
