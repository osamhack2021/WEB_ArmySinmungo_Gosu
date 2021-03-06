package com.gosu.armysinmungo.armysinmungo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gosu.armysinmungo.armysinmungo.service.UserInfoService;
import com.gosu.armysinmungo.armysinmungo.domain.UserInfo;

import java.time.LocalDate;
import java.util.List;

import com.gosu.armysinmungo.armysinmungo.web.dto.BasicResponse;
import com.gosu.armysinmungo.armysinmungo.web.dto.response.UserInfoResponse;
import com.gosu.armysinmungo.armysinmungo.web.dto.request.LoginRequest;
import com.gosu.armysinmungo.armysinmungo.web.dto.request.SignupRequest;

@RestController
public class UserInfoController {

    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping("/board/login")
    public ResponseEntity<BasicResponse> postLogin(@RequestBody LoginRequest loginRequest) {
    
        List<UserInfo> userInfoList = userInfoService.findAll();

        for(int i=0; i<userInfoList.size(); i++) {
            
            UserInfo userinfo = userInfoList.get(i);
            
            if(userinfo.getMilNum().equals(loginRequest.getMilNum()) &&
                userinfo.getUserPw().equals(loginRequest.getPassword())) {
                    UserInfoResponse userInfoResponse = 
                        UserInfoResponse.builder()
                            .milNum(userinfo.getMilNum())
                            .rank(userinfo.getUserRank())
                            .unitBelong(userinfo.getBranchUnit1())
                            .unitName(userinfo.getBranchUnit2())
                            .userName(userinfo.getUserName())
                            .build();

                    return new ResponseEntity<>(
                        BasicResponse.builder()
                                .status(HttpStatus.OK)
                                .message("????????? ??????")
                                .data(userInfoResponse)
                                .build(), HttpStatus.OK);
                }
        }

        // ?????? ???????????? ?????????
        return new ResponseEntity<>(
            BasicResponse.builder()
                    .status(HttpStatus.UNAUTHORIZED)
                    .message("?????? ?????? ??????????????? ???????????? ????????????.")
                    .build(), HttpStatus.UNAUTHORIZED);
    }
    
    @PostMapping("/board/signup")
    public ResponseEntity<BasicResponse> postSignup(@RequestBody SignupRequest signupRequest) {

        // ???????????? ?????? ??? ?????? dto
        // ???????????? ????????? ????????? ????????? ?????????
        // userRank ????????? ????????????

        List<UserInfo> userInfoList = userInfoService.findAll();

        // ?????? ?????? ??????
        for(int i=0; i<userInfoList.size(); i++) {
            if(userInfoList.get(i).getMilNum().equals(signupRequest.getMilNum())) {
                return new ResponseEntity<>(
                    BasicResponse.builder()
                            .status(HttpStatus.CONFLICT)
                            .message("?????? ????????? ???????????????.")
                            .build(), HttpStatus.CONFLICT);
            }
        }

        // ???????????? == ???????????? ?????? ??????
        if(!signupRequest.getPassword().equals(signupRequest.getPasswordCheck())) {
            return new ResponseEntity<>(
                    BasicResponse.builder()
                            .status(HttpStatus.CONFLICT)
                            .message("??????????????? ???????????? ????????? ?????? ???????????????.")
                            .build(), HttpStatus.CONFLICT);
        }


        // ????????????

        String userRank = "";
        if(signupRequest.getMilNum().length() == 8) userRank = "COMMANDER";
        else userRank = "SOLDIER";

        UserInfo userInfo = 
            UserInfo.builder()
            .branchUnit1("?????? ?????????????????????")
            .branchUnit2("???????????????")
            .userRank(userRank)
            .milNum(signupRequest.getMilNum())
            .userPw(signupRequest.getPassword())
            .userName(signupRequest.getUserName())
            .enlistDate(LocalDate.now())
            .birth(LocalDate.now())
            .cellphone("010-1234-5678")
            .unitCode(3L)
            .build();

        userInfoService.save(userInfo);

        return new ResponseEntity<>(
            BasicResponse.builder()
                    .status(HttpStatus.CREATED)
                    .message("?????? ??????")
                    .build(), HttpStatus.CREATED);
    }

}
