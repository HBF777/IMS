package com.zsc.ims.utils;

import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InviteCodeGenerator {

        public static String generateCode() {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String invitationCode = uuid.substring(0, 8);
            return invitationCode;
        }
    }
