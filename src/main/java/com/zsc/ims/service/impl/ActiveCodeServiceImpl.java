package com.zsc.ims.service.impl;

import com.zsc.ims.utils.InviteCodeGenerator;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class ActiveCodeServiceImpl {
    public String createActiveCode(Integer userId, Integer GroupId) throws NoSuchAlgorithmException {
//       String  ActiveCode =  InviteCodeGenerator.generateCode(userId,GroupId);
//       return ActiveCode;
        return null;
    }
}
