package com.wmt.gateway.util;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author wmtumanday
 */
@Component
public class RouteValidator {

    public static final List<String> OPEN_API_ENDPOINTS = Arrays.asList(
            "/smart/user/v1/login",
            "/smart/user/v1/register"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> OPEN_API_ENDPOINTS
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
